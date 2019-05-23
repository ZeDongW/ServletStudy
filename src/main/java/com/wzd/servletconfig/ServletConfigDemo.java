package com.wzd.servletconfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author ZeDongW
 * @ClassName ServletConfigDemo
 * @Description ServletConfig对象
 * @Version 1.0
 * @date ：Created in 2019/4/30 0030 22:12
 * @modified By：
 */

public class ServletConfigDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String paramName = initParameterNames.nextElement();
            String paramValue = servletConfig.getInitParameter(paramName);
            System.out.println(paramName + " = " + paramValue);
        }
        System.out.println(servletConfig.getServletName());
    }
}
