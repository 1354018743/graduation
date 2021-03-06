<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>s审核人员主页面</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/metro/easyui.css">   
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/icon.css"> 
<link href="/graduation/css/leader/leaderMain.css" rel="stylesheet" type="text/css" media="all" />  

</head>

	<body class="easyui-layout">  
		<div data-options="region:'north'" style="height:120px;background-image:url(<%=path%>/images/bg1.jpg);background-size: 100%;border: none;">
			<div style=" height:90px;width:800px;font-size: 60px;margin:auto; text-align: center;line-height: 120px;font-family:'YouYuan';">
				欢迎使用资助审核系统
			</div>
			<div style="text-align: right;margin-right: 50px;font-size: 16px;font-family:'微软雅黑';">
				欢迎${sessionScope.user.username},<a style="color:red" href="<%=path%>/leaderLogout/leaderlogout">退出登录</a>
			</div>
		</div>   
		<div data-options="region:'south'" style="height:40px;border: none;">
			<div style="height:20px;width: 500px; margin: auto;text-align: center;">
				© Copyright 2018 雷震 
			</div>
			<div style="height:20px;width: 500px; margin: auto;text-align: center;">
				版权所有，翻版必究
			</div>
		</div>   
		<div data-options="region:'west'" style="width:200px;">
			<ul id="menu" >
				<a href="<%=path%>/view/leader/leaderMessage.jsp" target="centerIframe">
					<li>
						查看个人信息
					</li>
				</a>
				<a href="<%=path%>/view/leader/leaderApplyMessage.jsp" target="centerIframe">
					<li>
						查看申请信息
					</li>
				</a>
				<a href="<%=path%>/view/leader/leaderStudentMessage.jsp" target="centerIframe">
					<li>
						查询学生
					</li>
				</a>
				<a href="<%=path%>/view/leader/modifyLeaderPassword.jsp" target="centerIframe">
					<li>
						修改密码
					</li>
				</a>
			</ul>
		</div>   
		<div data-options="region:'center'" >
			<iframe name="centerIframe" style="width: 100%;height: 100%; border: none;" src="<%=path%>/view/flightMessage.jsp">
			</iframe>
		</div> 
		
		<script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>   
		<script type="text/javascript" src="<%=path%>/easyui/jquery.easyui.min.js"></script>  
		<script src="<%=path%>/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
		
		<script>
			$(function(){
				$('#menu>a>li:first').css("background-color","#A3C3E4");
				$('#menu>a>li:first').css("color","#FFFFFF");
			});
			$('#menu a li').click( function () { 
				$('#menu>a>li').css("background-color","#FFFFFF");
				$('#menu>a>li').css("color","#222222");
				$(this).css("background-color","#A3C3E4");
				$(this).css("color","#FFFFFF");
			});
			
		</script>
		
	</body> 

</html>