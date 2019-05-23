package com.wzd.httpresponse;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName HttpResponseDemo
 * @Description HttpResponse类演示
 * @Version 1.0
 * @date ：Created in 2019/4/29 0029 8:54
 * @modified By：
 */

public class HttpResponseDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setStatus(404,"资源不存在");
//        resp.sendError(404);
//        resp.setStatus(302);
//        resp.setHeader("location","/ServletStudy/page/adv.html");
//        resp.setHeader("refresh","1");
//        resp.setHeader("refresh","3;url=/ServletStudy/page/adv.html");
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/image/2.jpg");
        File file = new File(realPath);
        System.out.println(file.getAbsolutePath());
        FileInputStream fileInputStream = new FileInputStream(file);
        resp.setContentType("image/jpg");
//        resp.setHeader("Content-Disposition", "attachment; filename="+file.getName());
        byte[] bytes = new byte[1024];
        int len =0;
        while((len = fileInputStream.read(bytes)) != -1){
            resp.getOutputStream().write(bytes,0,len);
        }
    }
}
