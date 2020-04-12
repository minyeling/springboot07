<%--
  Created by IntelliJ IDEA.
  User: 闵叶灵
  Date: 2020/4/11
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="sends" method="post" enctype="multipart/form-data">
    输入邮件号码：<input name="mailNum" value="xxx@qq.com" type="text"/><br>
    输入邮件标题：<input name="titleName" value="" type="text"/><br>
    输入邮件内容：<textarea  name="info"></textarea><br>
    上传附件：<input type="file" name="file">
    <button type="submit" value="提交">提交</button>
    <br>
</form>

</body>
</html>
