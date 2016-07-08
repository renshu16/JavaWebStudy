<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <h2>Hello World!</h2>
    <form action="/servlet/check" method="POST">
        验证码:<input type="text" name="validateCode"/>
        <img alt="验证码看不清，换一张" src="<%=request.getContextPath()%>/servlet/drawimage" id="validateCodeImg" onclick="changeImage()">
        <a href="javascript:void(0)" onclick="changeImage()">看不清，换一张</a>
        <br/>
        <input type="submit" value="提交">
    </form>
    </body>
</html>
