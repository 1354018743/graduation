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
        <script type="text/javascript" src="../../js/jquery-1.3.2.min.js"></script>
				<style>
		     form {
						padding: 3em 2em;
						background: #F2F2F2;
						
					}
		
		</style>
		
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
                       <li class="active"><a href="<%=path%>/view/student/password.jsp">更改密码</a></li> 
                       <li><a href="<%=path%>/view/student/info.jsp">个人资料</a></li> 
                   </ul> 
                   <ul class="nav navbar-nav navbar-right"> 
                      <li><a>欢迎${sessionScope.user.username}</a></li>
                       <li><a href="<%=path%>/Logout/logout">退出登录</a></li> 
                   </ul> 
               </div><!-- /.navbar-collapse --> 
           </div><!-- /.container-fluid --> 
       </nav> 
       <!------------------------------------------导航条结束-------------------------------->	
       <!---------主体------------------> 
<div class="row">
                        <div class="col-sm-8 col-sm-offset-2 form-box">
                        	<div >
                        		<div >
                        			<h3>修改个人密码</h3>
                            		<p>修改密码后，请记住自己的密码</p>
                        		</div>
                            </div>            
			                    	<form  method="post">   
			
								    <div>   
								        <label >请输入原密码：&nbsp&nbsp&nbsp</label>   
								        <input id="oldpassword"  type="password"  name="oldpassword"  />   
								        <br/>
								        <br/>  
								    </div>   
								    <div>   
								        <label >请输入密码：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>   
								        <input id="newpassword"   type="password" name="newpassword"  /> 
								        <br/>
								        <br/>    
								    </div>   
					 				<div>   
								        <label >请再次输入密码：</label>   
								        <input id="passwordagain"  type="password" name="passwordagain"  />
								        <br/>
								        <br/>   
								    </div> 
								      <button type="button" name="button" class="btn" >确认修改</button>
								</form> 
			                       
			                   
                        </div>
                    </div>
<script type="text/javascript">
		    
$('.btn').click(function(){
		    	var oldpassword=$('#oldpassword').val();
		    	var newpassword=$('#newpassword').val();
		    	var passwordagain=$('#passwordagain').val();
		    	
		    	 if(newpassword!=passwordagain){
		    		alert('两次密码不一致');
		    		
		    	 }else{
		    		 $.post('<%=path%>/student/changePassword',{oldpassword:oldpassword,passwordagain:passwordagain},function(data){
							if(data=='true'){
								alert('修改成功');
								
							}else{
								
								alert('修改失败,请确认原密码')
							}
							},'text');
		    	 }	    
		    
});
		</script>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
<nav class="navbar navbar-default navbar-fixed-bottom text-center"> 
 <div  id="copyright">
            <p style="margin-top:10px">2018@leizhen </p>
           
             <p> 重庆交通大学资助申请系统 </p>
 </div>
 </nav>
	</body>

</html>
