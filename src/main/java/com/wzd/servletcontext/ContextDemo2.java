package com.wzd.servletcontext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName ContextDemo2
 * @Description Context对象
 * @Version 1.0
 * @date ：Created in 2019/4/30 0030 23:31
 * @modified By：
 */

public class ContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*ServletContext servletContext = this.getServletContext();
        Students students = (Students)servletContext.getAttribute("student");
        System.out.println(students);*/
        String name = (String)req.getAttribute("name");
        System.out.println("neme = " + name);
    }
}
