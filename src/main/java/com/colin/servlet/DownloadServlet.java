package com.colin.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet("/downloadFile")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、文件存放路径
        String path = "D:\\ProgramData\\Git_Space\\Spring龙哥\\Spring\\upLoad";
        // 2、需要下载的文件名
        String fileName = "美女.jpg";
        File file = new File(path + File.separator + fileName);
        //清除缓冲区中存在的任何数据以及状态代码和标头
        resp.reset();
        //设置浏览器编码，防止中文乱码
        resp.setCharacterEncoding("UTF-8");
        //设置要下载的文件的文件名的编码，防止中文乱码
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //设置相应头中下载文件的文件名
        resp.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        //构造文件字节输入流，用于从盘符中读取文件
        InputStream input = new FileInputStream(file);
        //构造Servlet文件输出流，用于下载
        ServletOutputStream out = resp.getOutputStream();
        //暂存区
        byte[] buff = new byte[1024];
        int len;
        //下载操作
        while ((len = input.read(buff)) != -1) {
            out.write(buff, 0, len);
            out.flush();
        }
        input.close();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
