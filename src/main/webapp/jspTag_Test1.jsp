<%--
  Created by IntelliJ IDEA.
  User: toothbond
  Date: 16/7/12
  Time: 上午11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 使用taglib指令引用gacl标签库，标签库的前缀(prefix)可以随便设置，如这里设置成 prefix="xdp" -->
<%@taglib uri="/gacl" prefix="xdp"%>
<html>
<head>
    <title>输出客服端的IP</title>
</head>
<body>
你的IP地址是(使用java代码获取输出)：
<%
    //在jsp页面中使用java代码获取客户端ip
    String ip = request.getRemoteAddr();
    out.write(ip);
%>

<hr/>
你的IP地址是(使用自定义标签获取输出)：
<xdp:viewIP/>
<hr/>
自定义标签控制JSP是否执行:
<xdp:demo1>
    Hello,JSPTag!
</xdp:demo1>
</body>
</html>
