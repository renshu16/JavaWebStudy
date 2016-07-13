<%--
  Created by IntelliJ IDEA.
  User: toothbond
  Date: 16/7/12
  Time: 下午3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/WEB-INF/simpletag.tld" prefix="rensq"%>
<html>
<head>
    <title>SimpleJspTagDemo</title>
</head>
<body>

<rensq:demo1>
    Hello,SimpleJSPTag!
</rensq:demo1>

<br>

<rensq:demo2 count="5">
    <h1>jsp自定义标签添加属性count</h1>
</rensq:demo2>

</body>
</html>
