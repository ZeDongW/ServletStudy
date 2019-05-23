package com.wzd.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author ZeDongW
 * @ClassName ServletContextDemo
 * @Description ServletContext对象
 * @Version 1.0
 * @date ：Created in 2019/4/30 0030 22:28
 * @modified By：
 */

public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        /*String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        resp.sendRedirect(contextPath + "/image/1.jpg"); //获取路径
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames(); //获取web参数
        while (initParameterNames.hasMoreElements()){
            String paramName = initParameterNames.nextElement();
            String paramValue = servletContext.getInitParameter(paramName);
            System.out.println(paramName + " = " + paramValue);
        }

        String aaa = this.getServletConfig().getInitParameter("aaa");
        System.out.println("aaa = " + aaa);
        servletContext.setAttribute("student", new Students("张三",23));
        System.out.println("保存成功");
        req.setAttribute("name","张三");
        servletContext.getRequestDispatcher("/context2").forward(req,resp);*/
//        String realPath = servletContext.getRealPath("/image/1.jpg");
//        File file = new File(realPath);
        InputStream resourceAsStream = servletContext.getResourceAsStream("/image/1.jpg");
//        FileInputStream fileInputStream = new FileInputStream(file);
        resp.setContentType("image/jpg");
        resp.setHeader("Content-Disposition", "attachment; filename=1.jpg");
        byte[] bytes = new byte[2048];
        int len =0;
        while((len = resourceAsStream.read(bytes)) != -1){
            resp.getOutputStream().write(bytes,0,len);
        }
    }
}
