package com.yuntu.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;
import com.yuntu.commons.contants.Contants;
import com.yuntu.pojo.Role;
import com.yuntu.pojo.User;
import com.yuntu.service.RoleService;
import com.yuntu.service.UserService;
import com.yuntu.util.PageSupport;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FilenameFilter;
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
 * @CreateTime: 2023-10-24  14:41
 * @Description:
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;



    @RequestMapping(value = "/dologin")
    public String doLogin(@RequestParam String userPassword, @RequestParam String userCode,
                          HttpServletRequest request, HttpSession session) throws Exception {
        User user = userService.login(userCode, userPassword);
        if (user!=null) {
            //登录成功
            session.setAttribute("userSession",user);
            return "redirect:/user/main.html";
        }else{
            request.setAttribute("error","用户名或者密码不匹配");
            return "login";
        }
    }
    @RequestMapping(value = "/main.html")
    public String mainHTML(HttpSession session){
        if (session.getAttribute(Contants.USER_SESSION) == null ){
            return "login";
        }else{
            return "frame";//主页
        }

    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.removeAttribute(Contants.USER_SESSION);
        return "redirect:/user/main.html";
    }
    @RequestMapping("/userlist")
    public String userList(@RequestParam(value = "queryname",required = false) String queryUserName,
                           @RequestParam(value = "queryUserRole",required = false) String queryUserRole,
                           @RequestParam(value = "method",required = false) String method,
                           @RequestParam(value = "pageIndex",required = false) String pageIndex, Model model) throws Exception {
    int UserRole = 0;
    if (queryUserRole == null){
        queryUserRole = "";
    }
    if (queryUserRole!=null && !queryUserRole.equals("")){
        UserRole = Integer.parseInt(queryUserRole);
    }
    int currentPageNo = 1;//进入页面第一页
    if (pageIndex != null){
        currentPageNo = Integer.parseInt(pageIndex);
    }
        //创建分页器
        PageSupport pageSupport = new PageSupport();
        int total = userService.getUserCode(queryUserName,UserRole);
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
        List<Role> roleList = roleService.selectAllRole();
        List<User> userList = userService.getUserList(queryUserName, UserRole, currentPageNo, Contants.PAGE_SIZE);
        model.addAttribute("userList",userList);
        model.addAttribute("totalCount",total);
        model.addAttribute("currentPageNo",currentPageNo);
        model.addAttribute("totalPageCount",totalPageCount);
        model.addAttribute("roleList",roleList);
        model.addAttribute("queryname",queryUserName);
        model.addAttribute("queryUserRole",queryUserRole);
        return "user/userlist";
    }

    @RequestMapping("/useradd")
    public String userAdd(){
        return "user/useradd";
    }

    /*单文件上传*/
    /*@RequestMapping(value = "/useraddsave.html",method = RequestMethod.POST)
    public String addUser(User user, HttpSession session, HttpServletRequest request,@RequestParam(value = "attachs",required = false) MultipartFile attach) throws IOException {

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
                return "user/useradd";
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
                return "user/useradd";
            }
        }
        System.out.println("新的文件路径->"+idPicPath);
        user.setIdPicPath(idPicPath);
        user.setCreationDate(new Date());
        User currentUser = (User) session.getAttribute(Contants.USER_SESSION);
        user.setCreatedBy(currentUser.getId());
        if (userService.add(user)){
            //如果添加成功 重定向到查询接口
            return "redirect:/user/userlist";
        }
        return "user/useradd";
    }*/

    /*多文件上传*/
    @RequestMapping(value = "/useraddsave.html",method = RequestMethod.POST)
    public String addUser(User user, HttpSession session, HttpServletRequest request,@RequestParam(value = "attachs",required = false) MultipartFile[] attachs) throws IOException {

        String idPicPath = null;//文件路径
        String workPicPath = null;
        boolean flag = true;  //判断标识
        for (int i = 0; i < attachs.length; i++) {
            MultipartFile attach = attachs[i];
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
                    flag = false;
                }else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") ||
                        prefix.equalsIgnoreCase("jpeg")){//判断文件格式
                    String newFileName = System.currentTimeMillis()+ RandomUtils.nextInt(1000000)+"Personal.jpg";
                    File tagerFile = new File(path,newFileName);
                    if (!tagerFile.exists()){//是否存在
                        tagerFile.mkdirs();//创建
                    }
                    attach.transferTo(tagerFile);
                    if (i==0){
                        idPicPath = path+File.separator+newFileName;
                    } else if (i==1) {
                        workPicPath = path+File.separator+newFileName;
                    }

                }else{
                    request.setAttribute("uploadWpError","图片上传格式不正确");
                    flag = false;
                }
            }
        }
        if (flag){
            System.out.println("新的文件路径->"+idPicPath);
            user.setIdPicPath(idPicPath);
            user.setWorkPicPath(workPicPath);
            user.setCreationDate(new Date());
            User currentUser = (User) session.getAttribute(Contants.USER_SESSION);
            user.setCreatedBy(currentUser.getId());
            if (userService.add(user)){
                //如果添加成功 重定向到查询接口
                return "redirect:/user/userlist";
            }
        }
        return "user/useradd";
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public String gotoUpdateUser(@RequestParam String uid,Model model) throws SQLException {
        User user = userService.getUserById(uid);
        model.addAttribute("user",user);
        return "user/usermodify";
    }

    @RequestMapping("/usermodifysave")
    public String updateUser(User user,HttpSession session){
        User modifyByUser = (User) session.getAttribute(Contants.USER_SESSION);
        user.setModifyBy(modifyByUser.getId());
        user.setModifyDate(new Date());
        if (userService.UpdateUser(user)){
            return "redirect:/user/userlist";
        }else{
            return "user/usermodify";
        }
    }


    @RequestMapping(value = "/delUser",method = RequestMethod.GET)
    @ResponseBody
    //将java对象转换为JSON格式的数据对象
    public Object delUser(@RequestParam String uid){
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isNullOrEmpty(uid)){
            map.put("delResult","notexist");
        }else{
            if (userService.deleteUserById(Integer.parseInt(uid))){
                map.put("delResult","true");
            }else{
                map.put("delResult","false");
            }
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/updPassword")
    public String updatePassword(){
        return "user/pwdmodify";
    }

    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
    @ResponseBody
    public String updPwd(@RequestParam String oldpassword,HttpServletRequest request,HttpSession session){
        Map<String, String> map = new HashMap<>();
        User user = (User) session.getAttribute(Contants.USER_SESSION);
        if (user==null){
            map.put("result","sessionerror");
        }else{
            if (oldpassword.equals(user.getUserPassword())){
                map.put("result","true");
            } else if (StringUtils.isNullOrEmpty(oldpassword)) {
                map.put("result","error");
            } else{
                map.put("result","false");
            }
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/updatePass")
    public String updPass(HttpSession session,@RequestParam("rnewpassword") String rnewpassword){
        User user = (User) session.getAttribute(Contants.USER_SESSION);
        boolean b = userService.updPwd(user, rnewpassword);
        session.removeAttribute(Contants.USER_SESSION);
        if (b) {
            return "redirect:/user/main.html";
        }else{
            session.setAttribute("message","修改失败");
            return "user/pwdmodify";
        }
    }

    @RequestMapping("/userCode.do")
    public @ResponseBody String getUserCode(@RequestParam String userCode){
        Map<String, String> map = new HashMap<>();
        boolean flag = userService.getCode(userCode);
        if (flag) {
            map.put("userCode","exist");
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/viewUser")
    public String viewUser(@RequestParam("uid") String uid,Model model) throws SQLException {
        User user = userService.getUserById(uid);
        model.addAttribute("user",user);
        return "user/userview";
    }

}
