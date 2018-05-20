<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path=getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
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
		<style>

		
		</style>
	</head>
	<body>
		
	<!-----------------------------------------导航条设计开始---------------------------------> 
      <!--黑色导航条样式为navbar-inverse，白色样式为default  ， .navbar-fixed-top导航条固定在顶端--> 
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container ">
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
                       <li class="active"><a href="<%=path%>/view/student/main.jsp">首页 <span class="sr-only">(current)</span></a></li><!--普通菜单--> 
                       <li ><a href="<%=path%>/view/student/apply.jsp">申请资助</a></li> 
                       <li><a href="<%=path%>/view/student/progress.jsp">申请历史</a></li> 
                       <li><a href="<%=path%>/view/student/password.jsp">更改密码</a></li> 
                       <li><a href="<%=path%>/view/student/info.jsp">个人资料</a></li> 
                   </ul> 

                   <ul class="nav navbar-nav navbar-right"> 
                    <li><a >欢迎${sessionScope.user.username}</a></li>
                       <li><a href="<%=path%>/Logout/logout">退出登录</a></li> 
                   </ul> 
               </div><!-- /.navbar-collapse --> 
           </div><!-- /.container-fluid --> 
       </nav> 
       <!------------------------------------------导航条结束-------------------------------->	
       <!---------主体------------------> 
<div class="jumbotron text-center">
  <h2>欢迎使用资助申请系统</h2>
  <p>本系统提供资助申请，资助进度的查询</p>
  <p>有什么问题请及时向我们反馈</p>
  <p><a class="btn btn-primary btn-lg" href="<%=path%>/view/student/more.jsp" role="button">了解更多</a></p>
</div>
<div class="container"> 
    <!--声明行--> 
    <div class="row"> 
        <!--为3的栅格系统，相对于一行放四个--> 
    <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="<%=path%>/images/第一教学楼.jpeg" alt="第一教学楼">
      <div class="caption">
        <h3>第一教学楼</h3>
        <p>第一教学楼是重庆交通大学进行就业，学习技术的地方，在这里我们的学习生活更充实</p>
		<p><a href="#" class="btn btn-success" role="button">详细</a></p>
      </div>
    </div>
  </div>
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="<%=path%>/images/李子湖.jpeg" alt="第一教学楼">
      <div class="caption">
        <h3>李子湖</h3>
        <p>李子湖位于重庆交通大学双福新校区，风景优美，学生们经常在李子湖畔散步</p>
		<p><a href="#" class="btn btn-success" role="button">详细</a></p>
      </div>
    </div>
  </div>
    <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="<%=path%>/images/校门.jpeg" alt="第一教学楼">
      <div class="caption">
        <h3>南岸校门</h3>
        <p>这是我们第一次进入学校，无数的路过，在这里我们度过了美好的大学生活</p>
        <p><a href="#" class="btn btn-success" role="button">详细</a></p>
      </div>
    </div>
    </div>
    </div>
    <div class="row"> 

    </div> 

</div>
	</body>
<nav class="navbar navbar-default navbar-fixed-foot text-center"> 
 <div  id="copyright">
            <p style="margin-top:10px">2018@leizhen </p>
           
             <p> 重庆交通大学资助申请系统 </p>
 </div>
 </nav>
</html>
