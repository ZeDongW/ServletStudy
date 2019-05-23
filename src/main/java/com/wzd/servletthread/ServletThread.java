package com.wzd.servletthread;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName ServletThread
 * @Description Servlet线程问题
 * @Version 1.0
 * @date ：Created in 2019/4/30 0030 18:49
 * @modified By：
 */

public class ServletThread extends HttpServlet {

    //统计访问人数
    int count = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
       /* synchronized (ServletThread.class){
            resp.getWriter().write("当前网站累计访问人数" + count);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }*/
        resp.getWriter().write("当前网站累计访问人数" + count++);
    }
}
