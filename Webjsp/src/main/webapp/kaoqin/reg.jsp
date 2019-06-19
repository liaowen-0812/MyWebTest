<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/14
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <script src="jQuery-2.2.2-min.js"></script>
</head>
<body>
    <div align="center">
        <form action="../insert" method="post">
            姓名:<input type="text" id="studentName" name="studentName" onchange="isName(this)"/>
            <span id="spanId"></span><br/>
            考勤类型:
            <select name="selectType">
                <option value="迟到">迟到</option>
                <option value="作业">作业</option>
                <option value="请假">请假</option>
            </select><br/>
            时间:<input type="text" name="inputTime"/><br/>
            录入人:<input type="text" name="userName"/><br/>
            录入时间:<input type="text" name="insertTime"/><br/>
            <input type="submit" value="提交"/>
        </form>
    </div>

</body>
<script>
    function isName(inp) {
        $.post("../isName",{"name":$("#studentName").val()},function (data) {
            alert(data)
            if(data == "true"){
                $("#spanId").html("用户正确")
            }else{
                $("#spanId").html("用户不存在")
            }
        })
    }
</script>
</html>
