<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path=getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>重庆交通大学资助申请系统</title>

        <!-- CSS -->
         <link href="/graduation/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <link href="/graduation/assets/bootstrap/css/fresh-bootstrap-table.css" rel="stylesheet">
	    <link href="/graduation/assets/bootstrap/css/animate.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="/graduation/assets/bootstrap/css/bootstrapValidator.min.css"/>
	    <link rel="stylesheet" href="/graduation/assets/bootstrap/css/style.min.css" />
		
	</head>
	<body>
		
	<!-----------------------------------------导航条设计开始---------------------------------> 
      <!--黑色导航条样式为navbar-inverse，白色样式为default  ， .navbar-fixed-top导航条固定在顶端--> 
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
               <!-- Brand and toggle get grouped for better mobile display --> 
               <div class="navbar-header"> 
                   
                   <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> 
                       <span class="sr-only">资助申请</span> 
                       <span class="icon-bar"></span> 
                       <span class="icon-bar"></span> 
                       <span class="icon-bar"></span> 
                   </button> 
                   <a class="navbar-brand" href="#">学生主页</a><!---方log的地方--> 
               </div>

               <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> 
                   <!--具体菜单项--> 
                   <ul class="nav navbar-nav"> 
                       <li ><a href="<%=path%>/view/student/main.jsp">首页 <span class="sr-only">(current)</span></a></li><!--普通菜单--> 
                       <li ><a href="<%=path%>/view/student/apply.jsp">申请资助</a></li> 
                       <li ><a href="<%=path%>/view/student/progress.jsp">申请历史</a></li> 
                       <li ><a href="<%=path%>/view/student/password.jsp">更改密码</a></li> 
                       <li class="active"><a href="<%=path%>/view/student/info.jsp">个人资料</a></li> 
                   </ul> 
					
                   <ul class="nav navbar-nav navbar-right"> 
                   	   <li><a >欢迎${sessionScope.user.username}</a></li>
                       <li><a href="<%=path%>/Logout/logout">退出登录</a></li> 
                   </ul> 
               </div><!-- /.navbar-collapse --> 
           </div><!-- /.container-fluid --> 
       </nav> 
       <!------------------------------------------导航条结束-------------------------------->	
		<div class="row">
                        <div class="col-sm-8 col-sm-offset-2 ">
                        <br/>
                         <br/>
                          <br/>
						<div class="panel panel-default text-left">
							<div class="row">
                        		<div class="col-sm-8 col-sm-offset-2 ">
						           <div class="panel-body text-center">
						             <input  name="sid" type="hidden" readonly="true"/><br/> <br/> 
										学生学号：<input  name="studentno" type="text" readonly="true"/><br/> <br/> 
										真实姓名：<input  name="name" type="text" /> <br/> <br/>
										所在学院：<input  name="departure" type="text" /> <br/> <br/> 
										所在班级：<input  name="grade" type="text" /> <br/> <br/>   
										使用邮箱：<input  name="email" type="text"/><br/> <br/>
										<button class="btn" onclick="modify()">确认更改</button>
						           </div>
						       </div>
						  </div>
						</div>  
			</div>
		</div>
		<br/>
		<br/>
		<br/>
						<nav class="navbar navbar-default navbar-fixed-bottom text-center">
						  <div class="container">
						    <p style="margin-top:10px">2018@leizhen </p>
						           
						             <p> 重庆交通大学资助申请系统 </p>
						  </div>
	
   </nav>
   <script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>   
	<script>
    window.onload = function(){ 
    	
    	$('input[name=sid]').val('${sessionScope.student.sid}');
    	$('input[name=studentno]').val('${sessionScope.student.stuno}');
    	$('input[name=name]').val('${sessionScope.student.name}');
    	$('input[name=departure]').val('${sessionScope.student.departure}');
    	$('input[name=grade]').val('${sessionScope.student.grade}');
    	$('input[name=email]').val('${sessionScope.student.email}');
    	
    }  
	function modify(){
		var sid=$('input[name=sid]').val();
		var name=$('input[name=name]').val();
		var departure=$('input[name=departure]').val();
		var grade=$('input[name=grade]').val(); 
		var email=$('input[name=email]').val();
		$.post("/graduation/StudentMessage/modifyStudentMessage",{sid:sid,name:name,departure:departure,grade:grade,email:email},function(data){
			if(data=="true"){
				alert('修改成功！');
				location.reload();
			}else{
			alert('服务器异常，请稍后再试！'); 
			location.reload();
			}
		},'text');
	
		
	}
	</script>
	</body>
</html>
