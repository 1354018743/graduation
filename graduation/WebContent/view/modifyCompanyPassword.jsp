<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
	String path=getServletContext().getContextPath();
%>
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>Personal Password</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page"> 
    <link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/metro/easyui.css">   
	<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/icon.css"> 
     <style type="text/css">
     form{
     		width:600px ;
			height: 250px;
			
			position: absolute;
			margin-left: 300px;
			margin-top:50px;
			
     	}
     	form input{
	     	margin:15px;
     		height:35px;
     		width:250px;
     	}
     	
     	#btn{
     	width:100px;
     	height:20px;
     	margin-left:150px;
     	margin-top:10px;
     	}
     	span{
     	font-family:'楷体';
     	font-size:20px;
     	}
     	#span1{
     	color:red;
     	}
     	#span3{
     	color:red;
     	}
     
     </style>
  
  </head>  
    
  <body>  
    
    <form action ="" >  
        <span>&nbsp&nbsp旧密码:</span>     
        <input type = "password"  name ="oldpwd" id="lab1"  onblur="checkpassword()" placeholder="请输入原密码"/>
        <span id="span1" ></span>  
        <br/>  
        <span>&nbsp&nbsp新密码:</span>     
        <input type = "password"  name ="newpwd" id="lab2" placeholder="请输入新密码">
        <span></span>  
        <br/>  
        <span>确认密码:</span>  
        <input type = "password"  name ="confirm" id="lab3" onblur="samenewpassword()" placeholder="请确认新密码">
        <span id="span3"></span>
         <br/>
         <a id="btn" href="javascript:changepassword()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确认修改</a> 
     </form>  
        
        <script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>   
		<script type="text/javascript" src="<%=path%>/easyui/jquery.easyui.min.js"></script>  
		<script src="<%=path%>/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
        var flag1=false;
        var flag2=false;
        function checkpassword(){
        	var password=$('#lab1').val();
       		$.post("/airlineTickets/companypassword/ModifyPassword",{password:password},function(data){
       			if(data=="true"){
       				flag1=true;
       				return;
       			}else
       				$('#span1').html('原密码错误!');
       		},'text');
        }
        function samenewpassword(){
        	var password1=$('#lab2').val();
        	var password2=$('#lab3').val();
        	if(password1==password2){
        		flag2=true;
        		return;
        	}else
        		$('#span3').html('两次密码不一样!');
        }
        function changepassword(){
        	if(flag1&&flag2){
        		var password1=$('#lab2').val();
        		$.post("/airlineTickets/companypassword/ChangePassword",{password:password1},function(data){
        			if(data=="true"){
           				$.messager.alert('恭喜你','修改成功!');
           			}else{
           				$.messager.alert('警告','服务器异常，请稍后再试!');
           			}
        			$('#lab1').val("");
        			$('#lab2').val("");
        			$('#lab3').val("");
        		},'text');
        	}
        }
        
        </script>
  </body>  
</html> 