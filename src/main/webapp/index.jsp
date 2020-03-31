<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 闵叶灵
  Date: 2020/3/31
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这世界我来了！
<a href="hello">Hello</a>
<a href="allAdmin2">获取all Admin信息</a>

    <c:forEach items="${lists}" var="admin">
        <tr>
            <td><h1>${admin.id}</h1></td>
            <td><h1>${admin.username}</h1></td>
            <td><h1>${admin.password}</h1></td>
        </tr>
    </c:forEach>

</body>
</html>
