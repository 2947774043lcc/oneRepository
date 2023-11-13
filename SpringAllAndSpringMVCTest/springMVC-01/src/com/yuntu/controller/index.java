package com.yuntu.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: SpringAllTest
 * @BelongsPackage: com.yuntu.controller
 * @Author: Shuo
 * @CreateTime: 2023-10-23  14:33
 * @Description:
 * @Version: 1.0
 */
public class index extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("进入接口");
        return new ModelAndView("index");
    }
}
