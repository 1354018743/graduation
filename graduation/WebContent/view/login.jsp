<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>登录重庆交通大学资助系统</title>
<link href="/graduation/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 

<!-- -->
</head>
<body>
<!-- contact-form -->	
<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>欢迎登录重庆交通大学资助申请审核系统</h1>
		 			
	</div>
		<form action="/graduation/Login/airlineLogin" method="post" id="loginFrom">
			
				<input name="username" type="text" class="text"autocomplete="off" value="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}"><a href="#" class=" icon user"></a>
				<br/>
				<input name="password" type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"> <a href="#" class="icon lock"></a>
				<br/>
				<span class="typechoose"> 身份: <select name="usertype" id=selecttype>
							<option value="-1">
							请选择登陆身份
							</option>
							<option value="1">
							学生
							</option>
							<option value="2">
							审核人员
							</option>
							</option>
							<option value="3">
							管理员
							</option>
							</select> 
				</span>
			<br/>
			<div class="submit">
				<input type="submit"   value="登录" >
				
				<input type="button" onclick="window.location.href='/graduation/view/reg.jsp'" value="注册" ><br/>
				<div ><span id="info" >
            	${requestScope.loginInfo }
                </span></div>
				<h4><a href="#">忘记密码?请向辅导员反映，我们将重置你的密码</a></h4>
						  <div class="clear">  </div>	
			</div>
				
		</form>
		</div>					
	</div>

	<div class="clear"> </div>
<!--- footer --->
<div class="footer">
	<p>Copyright &copy; 2018.</p>
</div>
<script type="text/javascript"  src="../js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

$("#info").html("");
</script>

</body>
</html>