<%--
  Created by IntelliJ IDEA.
  User: 闵叶灵
  Date: 2020/3/31
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
    table,th, td
    {
        border: 1px solid black;
    }
</style>
<body>

<h3>Admin ...</h3>

<c:if test="${lists!=null}">
    <table>
        <c:forEach items="${lists}" var="admin">
            <tr>
                <td><h5>${admin.id}</h5></td>
                <td><h5>${admin.username}</h5></td>
                <td><h5>${admin.password}</h5></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
<head>
    <title>Title</title>
</head>
</html>
