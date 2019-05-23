package com.wzd.httprequset;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author ZeDongW
 * @ClassName HttpRequestDemo
 * @Description http请求
 * @Version 1.0
 * @date ：Created in 2019/4/22 0022 14:11
 * @modified By：
 */

public class HttpRequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().write("调用了doGet方法---------</br>");
        System.out.println("get方式");
//        doPost(req,resp);
//        t2(req);
//        getBrowserType(req,resp);
//        getDownLoad(req,resp);
//        String queryString = req.getQueryString();
//        System.out.println(queryString);
        getParameters(req);
        requsetParam(req, resp);
    }

    /**
     * @Author: ZeDongW
     * @Description: 广告跳转
     * @Date: 2019/4/24 0024 10:07
     * @Param: [req, resp]
     * @return: void
     */ 
    private void getDownLoad(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String referer = req.getHeader("referer");
        System.out.println(referer);
        if(referer == null || !referer.contains("/ServletStudy/page/adv.html")){
            resp.getWriter().write("当前是非法链接，请返回到首页。<a href='/ServletStudy/page/adv.html'>首页</a>");
        } else {
            resp.getWriter().write("资源正在下载...");
        }
    }

    /**
     * @Author: ZeDongW
     * @Description: 获取浏览器类型
     * @Date: 2019/4/24 0024 8:55
     * @Param: [req, resp]
     * @return: void
     */
    private void getBrowserType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        String userAgent = req.getHeader("user-agent");
        System.out.println(userAgent);

        if(userAgent.contains("Firefox")){
            resp.getWriter().write("您正在使用火狐浏览器");
        } else if (userAgent.contains("Chrome")){
            resp.getWriter().write("您正在使用谷歌浏览器");
        } else if (userAgent.contains("Trident")){
            resp.getWriter().write("您正在使用IE浏览器");
        } else {
            resp.getWriter().write("无法识别您的浏览器");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().write("调用了doPost方法---------</br>");
        System.out.println("post方式");
        //获取Request内容
//        t1(req);
//        t2(req);
        requsetParam(req, resp);
//        printParams(req);
        getParameters(req);
    }

    /**
     * @Author: ZeDongW
     * @Description: 获取参数
     * @Date: 2019/4/26 0026 6:41
     *
     * @Param: [req]
     * @return: void
     */
    private void getParameters(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " : " + password);
        System.out.println("############################################");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println("paramName =" + s);
            String[] parameterValues = req.getParameterValues(s);
            for (String parameterValue : parameterValues) {
                System.out.println("paramValue = " + parameterValue);
            }
            System.out.println("---------------");
        }
    }

    /**
     * @Author: ZeDongW
     * @Description: 打印post请求参数
     * @Date: 2019/4/26 0026 6:30
     * @Param: [req]
     * @return: void
     */
    private void printParams(HttpServletRequest req) throws IOException {
        ServletInputStream inputStream = req.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = inputStream.read(bytes)) != -1) {
            String str = new String(bytes, 0, len);
            System.out.println(str);
        }
    }

    /**
     * @Author: ZeDongW
     * @Description: 请求头
     * @Date: 2019/4/22 0022 20:57
     * @Param: [req]
     * @return: void
     */
    private void t2(HttpServletRequest req) {
        String host = req.getHeader("Host");
        System.out.println(host);

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + ":" + headerValue);
        }
    }

    /**
     * @Author: ZeDongW
     * @Description: 获取请求行
     * @Date: 2019/4/22 0022 20:45
     * @Param: [req]
     * @return: void
     */
    private void t1(HttpServletRequest req) {
        System.out.println("请求方式：" + req.getMethod());
        System.out.println("URI:" + req.getRequestURI());
        System.out.println("URL:" + req.getRequestURL());
        System.out.println("http协议版本：" + req.getProtocol());
    }

    /**
     * @Author: ZeDongW
     * @Description: 请求信息
     * @Date: 2019/4/22 0022 20:42
     * @Param: [req, resp]
     * @return: void
     */
    private void requsetParam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            String[] parameterValues = req.getParameterValues(s);
            resp.getWriter().write("param =" + s + "\r\n");
            for (String parameterValue : parameterValues) {
                resp.getWriter().write("paramvalue =" + parameterValue + "\r\n");
            }
            resp.getWriter().write("----------------------------\r\n");
        }
    }

}
