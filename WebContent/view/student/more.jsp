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
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="/graduation/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/graduation/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="/graduation/assets/css/form-elements.css">
        <link rel="stylesheet" href="/graduation/assets/css/style.css">
        
        <link rel="shortcut icon" href="/graduation/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/graduation/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/graduation/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/graduation/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/graduation/assets/ico/apple-touch-icon-57-precomposed.png">

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
                       <li ><a href="<%=path%>/view/student/main.jsp">返回 <span class="sr-only">(current)</span></a></li><!--普通菜单--> 
                   </ul> 

                  
               </div><!-- /.navbar-collapse --> 
           </div><!-- /.container-fluid --> 
       </nav> 
       <!------------------------------------------导航条结束-------------------------------->	
       <!---------主体------------------> 
<div class="jumbotron">
  <h2>欢迎使用资助申请系统</h2>
  <p>本系统提供资助申请，资助进度的查询</p>
  <p>有什么问题请及时向我们反馈</p>
</div>

	</body>
<nav class="navbar navbar-default navbar-fixed-bottom"> 
 <div  id="copyright">
            <p style="margin-top:10px">2018@leizhen </p>
           
             <p> 重庆交通大学资助申请系统 </p>
 </div>
 </nav>
</html>
