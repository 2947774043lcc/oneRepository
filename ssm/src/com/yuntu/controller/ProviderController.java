package com.yuntu.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;
import com.yuntu.commons.contants.Contants;
import com.yuntu.pojo.Provider;
import com.yuntu.pojo.User;
import com.yuntu.service.ProviderService;
import com.yuntu.util.PageSupport;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.controller
 * @Author: Shuo
 * @CreateTime: 2023-10-26  16:35
 * @Description:
 * @Version: 1.0
 */
@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @RequestMapping(value = "/providerlist")
    public String providerList(@RequestParam(value = "queryProCode",required = false) String queryProCode,
                           @RequestParam(value = "queryProName",required = false) String queryProName,
                           @RequestParam(value = "method",required = false) String method,
                           @RequestParam(value = "pageIndex",required = false) String pageIndex, Model model) throws Exception {

        int currentPageNo = 1;//进入页面第一页
        if (pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //创建分页器
        PageSupport pageSupport = new PageSupport();
        int total = providerService.getProviderCount(queryProCode,queryProName);
        pageSupport.setCurrentPageNo(currentPageNo);//当前页
        pageSupport.setPageSize(Contants.PAGE_SIZE);
        pageSupport.setTotalCount(total);

        //控制首页和尾页
        int totalPageCount = pageSupport.getTotalPageCount();//总页数
        if (currentPageNo<1){
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        List<Provider> providerList = providerService.getProviderList(queryProCode, queryProName, currentPageNo, Contants.PAGE_SIZE);
        model.addAttribute("providerList",providerList);
        model.addAttribute("totalCount",total);
        model.addAttribute("currentPageNo",currentPageNo);
        model.addAttribute("totalPageCount",totalPageCount);
        model.addAttribute("queryProCode",queryProCode);
        model.addAttribute("queryProName",queryProName);
        return "provider/providerlist";
    }

    @RequestMapping("/provideradd")
    public String userAdd(){
        return "provider/provideradd";
    }

    @RequestMapping(value = "/provideraddsave.html",method = RequestMethod.POST)
    public String addProvider(Provider provider, HttpSession session, HttpServletRequest request, @RequestParam(value = "attachs",required = false) MultipartFile attach) throws IOException {
        String idPicPath = null;//文件路径
        if (!attach.isEmpty()){
            //路径
            String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles");
            //文件名
            String oldFileName = attach.getOriginalFilename();
            //后缀
            String prefix = FilenameUtils.getExtension(oldFileName);
            //判断文件大小
            int filesize = 5000000;
            if (attach.getSize() > filesize) {
                request.setAttribute("uploadWpError","上传大小不能超过500K");
                return "provider/provideradd";
            }else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") ||
                    prefix.equalsIgnoreCase("jpeg")){//判断文件格式
                String newFileName = System.currentTimeMillis()+ RandomUtils.nextInt(1000000)+"Personal.jpg";
                File tagerFile = new File(path,newFileName);
                if (!tagerFile.exists()){//是否存在
                    tagerFile.mkdirs();//创建
                }
                attach.transferTo(tagerFile);
                idPicPath = path+File.separator+newFileName;
            }else{
                request.setAttribute("uploadWpError","图片上传格式不正确");
                return "provider/provideradd";
            }
        }
        System.out.println("新的文件路径->"+idPicPath);
        provider.setCreationDate(new Date());
        User currentUser = (User) session.getAttribute(Contants.USER_SESSION);
        provider.setCreatedBy(currentUser.getId());
        provider.setIdPicPath(idPicPath);
        if (providerService.add(provider)){
            //如果添加成功 重定向到查询接口
            return "redirect:/provider/providerlist";
        }
        return "provider/provideradd";
    }

    @RequestMapping(value = "/updateProvider",method = RequestMethod.GET)
    public String gotoUpdateProvider(@RequestParam String proid,Model model) throws SQLException {
        Provider provider = providerService.getProviderById(proid);
        model.addAttribute("provider",provider);
        return "provider/providermodify";
    }

    @RequestMapping("/providerModifySave")
    public String updateProvider(Provider provider,HttpSession session){
        User modifyByUser = (User) session.getAttribute(Contants.USER_SESSION);
        provider.setModifyBy(modifyByUser.getId());
        provider.setModifyDate(new Date());
        if (providerService.updateProvider(provider)){
            return "redirect:/provider/providerlist";
        }else{
            return "provider/providermodify";
        }
    }

    @RequestMapping(value = "/delProvider",method = RequestMethod.GET)
    @ResponseBody
    //将java对象转换为JSON格式的数据对象
    public Object delProvider(@RequestParam String proid){
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isNullOrEmpty(proid)){
            map.put("delResult","notexist");
        }else{
            if (providerService.deleteProviderById(Integer.parseInt(proid))){
                map.put("delResult","true");
            }else{
                map.put("delResult","false");
            }
        }
        return JSON.toJSONString(map);
    }



}
