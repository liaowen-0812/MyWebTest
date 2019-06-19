<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/14
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="jQuery-2.2.2-min.js"></script>
</head>
<body>
<div align="center">
    <form action="http://localhost:8081/webjsp/message" method="post">
        <input type="text" value="${username}" id="username" name="username"/>
        <input type="submit"  name="clickPage" value="查询"/>
    <table border="1">
        <thead>
        <tr>
            <th>姓名</th>
            <th>类型</th>
            <th>时间</th>
            <th>录入人</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${kaoqinObj['list']}" var="user">
            <tr><td>${user.sysStu.sysStuName}</td><td>${user.sysType}</td>
                <td>${user.sysTime}</td><td>${user.sysMan}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
            <input type="submit" value="上一页" name="clickPage" >

            <span id="curentSpan">${kaoqinObj['page']['curentPage']}</span>/
            <span id="maxPage">${kaoqinObj['page']['maxPage']}</span>

            <input type="submit" value="下一页" name="clickPage">
            <input type="hidden" value="${kaoqinObj['page']['curentPage']}" name="showPage">
         </form>
</div>
</body>
    <script>
    </script>
</html>
