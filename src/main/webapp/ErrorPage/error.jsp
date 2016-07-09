<%--
  Created by IntelliJ IDEA.
  User: toothbond
  Date: 16/7/9
  Time: 下午2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误信息友好提示页面</title>
</head>
<body>
对不起，出错了，请联系管理员解决！<br>
<p>异常信息如下:<%=exception.getMessage()%></p>
</body>
</html>
