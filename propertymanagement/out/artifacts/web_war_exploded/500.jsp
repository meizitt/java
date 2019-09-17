<%--
  Created by IntelliJ IDEA.
  User: deer
  Date: 2019/9/16
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<div>请求错误<button type="button" onclick="goBack()">返回</button></div>
</body>
<script>
    function goBack() {
        window.history.go(-1);
    }
</script>
</html>
