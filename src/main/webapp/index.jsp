<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 在单独的jsp页面中指定error页面 --%>
<%@ page language="java" import="java.util.*" errorPage="/ErrorPage/error.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>在Form表单中使用验证码</title>
        <script type="text/javascript">
            function changeImage(){
                console.log("onclick");
                document.getElementById("validateCodeImg").src ="${pageContext.request.contextPath}/servlet/drawimage?" + Math.random();
            }

        </script>
    </head>

    <body>
    <%
        //这行代码报错
        //int x = 1/0;
    %>
    <h2>Hello World!</h2>
    <form action="/servlet/check" method="POST">
        验证码:<input type="text" name="validateCode"/>
        <img alt="验证码看不清，换一张" src="<%=request.getContextPath()%>/servlet/drawimage" id="validateCodeImg" onclick="changeImage()">
        <a href="javascript:void(0)" onclick="changeImage()">看不清，换一张</a>
        <br/>
        <input type="submit" value="提交">
    </form>

    <%
        pageContext.setAttribute("name1","1111");
        request.setAttribute("name2","name2");
        application.setAttribute("name3","name3");
    %>

    <br>
    <h2>${name1}</h2>
    <h2><%=pageContext.findAttribute("name3")%></h2>
    </body>
</html>
