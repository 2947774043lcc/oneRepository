package com.yuntu.controller;

import com.yuntu.commons.contants.Contants;
import com.yuntu.pojo.Bill;
import com.yuntu.pojo.User;
import com.yuntu.service.BillService;
import com.yuntu.util.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.controller
 * @Author: Shuo
 * @CreateTime: 2023-10-26  16:35
 * @Description:
 * @Version: 1.0
 */

@RequestMapping("/bill")
@Controller
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping(value = "/billlist")
    public String billList(@RequestParam(value = "billCode",required = false) String billCode,
                           @RequestParam(value = "productName",required = false) String productName,
                           @RequestParam(value = "method",required = false) String method,
                           @RequestParam(value = "pageIndex",required = false) String pageIndex, Model model) throws Exception {

        int currentPageNo = 1;//进入页面第一页
        if (pageIndex != null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //创建分页器
        PageSupport pageSupport = new PageSupport();
        int total = billService.getBillCount(billCode,productName);
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
        List<Bill> billList = billService.getBillList(billCode, productName, currentPageNo, Contants.PAGE_SIZE);
        model.addAttribute("billList",billList);
        model.addAttribute("totalCount",total);
        model.addAttribute("currentPageNo",currentPageNo);
        model.addAttribute("totalPageCount",totalPageCount);
        model.addAttribute("billCode",billCode);
        model.addAttribute("productName",productName);
        return "bill/billlist";
    }

    @RequestMapping("/billadd")
    public String billAdd(){
        return "bill/billadd";
    }

    @RequestMapping(value = "/billaddsave.html",method = RequestMethod.POST)
    public String addBill(Bill bill, HttpSession session){
        bill.setCreationDate(new Date());
        User currentUser = (User) session.getAttribute(Contants.USER_SESSION);
        bill.setCreatedBy(currentUser.getId());
        if (billService.add(bill)){
            //如果添加成功 重定向到查询接口
            return "redirect:/bill/billlist";
        }
        return "bill/billadd";
    }

    @RequestMapping(value = "/updatebill",method = RequestMethod.GET)
    public String gotoUpdateBill(@RequestParam(value = "billid") String billid,Model model) throws SQLException {
        Bill bill = billService.getBillById(billid);
        model.addAttribute("bill",bill);
        return "bill/billmodify";
    }

    @RequestMapping("/billmodifysave")
    public String updateBill(Bill bill,HttpSession session){
        User modifyByUser = (User) session.getAttribute(Contants.USER_SESSION);
        bill.setModifyBy(modifyByUser.getId());
        bill.setModifyDate(new Date());
        if (billService.updateBill(bill)){
            return "redirect:/bill/billlist";
        }else{
            return "bill/updatebill";
        }
    }

    @RequestMapping(value = "/deletebill",method = RequestMethod.GET)
    //将java对象转换为JSON格式的数据对象
    public String delBill(@RequestParam String billid){

        boolean b = billService.deleteBillById(Integer.parseInt(billid));
        if (b) {
            return "redirect:/bill/billlist";
        }else{
            return "bill/billlist";
        }
    }



}
