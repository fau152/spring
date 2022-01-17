<%--
  Created by IntelliJ IDEA.
  User: wangl
  Date: 2022/1/14
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
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
  <a href="downloadFile">
    <button>下载</button>
  </a>
  </body>
</html>
