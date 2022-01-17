# 一、Servlet3.0文件上传下载
参考博客：https://cloud.tencent.com/developer/article/1671417
## 1. 文件上传
### 客户端代码（浏览器）
在要上传文件的网页界面上需要提供一个表单，作为文件上传的入口：
主要是用到了客户端`HTML`页面的表单元素，使用`<form>`标签的`enctype`属性，
并设置它的值为`multipart/formdata`，意思是：`多部分/表单数据`，
同时使用`<input type="file">`的输入域用于指定上传的文件。

关于form表单 enctype属性：

|值|描述|
|:----|:----|
| application/x-www-form-urlencoded  | 在发送前编码所有字符(默认) |
| multipart/form-data  | 不对字符编码，每一个表单项分割为一个部件 |
| text/plain  | 空格转换为加号，但不对特殊字符编码 |
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Servlet3.0文件上传</title>
  </head>
  <body>
  <h1>Servlet3.0文件上传</h1>
  <hr>
  <form action="uploadServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="myFile"/>
    <input type="submit" value="上传"/>
  </form>
  </body>
</html>
```
### 服务端（Servlet）
Servet的逻辑也很简单，只需要搞清楚以下两点：
1. Servlet3.0将`multipart/form-data`的POST请求封装成Part,通过Part对上传文件进行操作。
2. 使用@MultipartConfig注解： 该注解告诉容器该 Servlet 能够处理`multipart/formdata`的请求。
   使用该注解，`request`对象才可以得到表单的各部分。

搞清楚这两点之后，使用request对象的getPart()方法拿到表单中的文件，使用part.write()方法将文件写入指定路径下即可。
```java
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
```
## 2. 文件下载
### 客户端
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Servlet3.0文件下载</title>
  </head>
  <body>
     <a href="downloadFile">
       <button>下载</button>
     </a>
  </body>
</html>
```
### 服务端（Servlet）
文件下载的原理大致是：
1. 确定要下载的文件
2. 设置响应头
3. 设置文件字节输入流和Servlet输出流
4. 从盘符下读取文件，写入浏览器缓冲区中提供下载
同时要考虑到中文乱码的问题，包括网页的中文乱码和文件名中文乱码。
```java
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
        // 确定要下载的文件
        String path = "D:\\ProgramData\\Git_Space\\Spring龙哥\\Spring\\upLoad";
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
```