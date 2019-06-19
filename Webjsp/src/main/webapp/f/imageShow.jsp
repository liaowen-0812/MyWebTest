<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/18
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
//http://ip+port+projectName
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>文件展示</title>
    <script src="kaoqin/jQuery-2.2.2-min.js"></script>
</head>
<body>
   <c:forEach items="${list}" var="fileObj">
       <img src="img/${fileObj.fileName}">
   </c:forEach>
</body>
</html>
