package com.colin.xml.servlet;

import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/*
* @WebServet : 绑定url-pattern
* @MultipartConfig : 加入这个注解，才认为这个Servlet可以做文件上传
*/
@WebServlet("/uploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 设置上传的文件要保存的位置
        String path = "D:\\ProgramData\\Git_Space\\Spring龙哥\\Spring\\upLoad";
        //2. 获取上传文件，保存在Part对象中，参数是<input type="file" name="myFile">标签中的name属性
        Part part = req.getPart("myFile");
        //3. 获取上传文件的文件名，也可以自己重新命名，防止文件在服务器中由于文件名重复而导致文件覆盖
        String fileName = part.getSubmittedFileName();
        //4. 将文件写入指定的路径中
        part.write(path + File.separator + fileName);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}

