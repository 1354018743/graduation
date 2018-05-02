<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path=getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>后台管理页面</title>
			<style type="text/css">
				body{
				background-color: deepskyblue;
					}
				#div{
				width:400px ;
				height: 270px;
				border-style:none ;
				position: absolute;
				margin-left: 800px;
				background-color:antiquewhite;
					}
				#user{
				width: 300px;
				height:30px;
				margin-top:25px ;
					}
				#pswd{
				width: 300px;
				height:30px;
				margin-top:25px ;
					}
				#remember{
					margin-left:80px;
					margin-top:25px;
					}
				#saveTime{
					margin-left:80px;
					margin-top:25px;
					}
				h1{
				margin-left: 890px;
				margin-top:150px ;
					}
				button{
				width:150px;
				height:30px;
				margin-left:130px;
				margin-top:25px;
				}
			</style>
	</head>
	<body>
	
		<h1>后台管理系统</h1>
		<div id="div">
		<form action="/graduation/AirlineLogin/airlineLogin" method="post" id="loginFrom">
			
			　用户名：<input type="text" id="user" name="username" placeholder="请输入用户名" /><br>
			　密　码：<input type="password" id="pswd" name="password" placeholder="请输入密码"  /><br>
			<input type="checkbox" id="remember" name="remember" value="1">记住密码
			<input type="checkbox" id="autoLogin" name="autoLogin" value="1">自动登录<br>	
			<button type="submit" >登录</button>
		</form>
		
		<span style="color:red;margin-top:20px;margin-left:140px;">
            	${requestScope.loginInfo }
        </span></div>
		<script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>   
		<script type="text/javascript" src="<%=path%>/easyui/jquery.easyui.min.js"></script>  
		<script src="<%=path%>/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
		
		
		
		
	</body>
</html>