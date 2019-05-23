package com.wzd.servletdemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ZeDongW
 * @ClassName HelloServlet
 * @Description 第一个Servlet
 * @Version 1.0
 * @date ：Created in 2019/4/21 0021 22:10
 * @modified By：
 */

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        resp.getWriter().write("这是第一个Servlet程序，当前系统时间为：" + simpleDateFormat.format(new Date()));
    }
}
