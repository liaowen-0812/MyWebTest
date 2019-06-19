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
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>文件上传</title>
    <script src="kaoqin/jQuery-2.2.2-min.js"></script>
</head>
<body>
    <form action="file" id="formId" method="post" enctype="multipart/form-data">
        文件:<input type="file" id="fileId" name="file"/>
        <input value="提交" type="button" onclick="isTrue()"/>
    </form>
</body>
    <script>
        function isTrue() {
            var flag = false;//标识
            var fileName = $("#fileId").val();
            var ext = fileName.substr(fileName.lastIndexOf(".")+1);
            var arr=["jpg","png","gif"];//使用是什么格式的后缀
            $.each(arr,function () {
                if(this==ext){
                    flag=true;
                }
            })
            if(flag){
                $("#formId").submit();
            }else{
                alert("文件选择错误(后缀以jpg/png/gif结尾)")
            }
        }
    </script>
</html>
