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
		<link rel="shortcut icon" href="/graduation/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/graduation/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/graduation/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/graduation/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/graduation/assets/ico/apple-touch-icon-57-precomposed.png">
		<script type="text/javascript" src="../../js/jquery-1.3.2.min.js"></script>
		<style>
		<style>
			body{
			font-family: 'Droid Sans', sans-serif;
			font-size:16px;
			background: url(../../images/bgs.jpg);
			background-repeat: no-repeat;
			background-attachment: fixed;
			background-position: center;
			background-size: cover;
		     }
		     form {
						padding: 3em 2em;
						background: #F2F2F2;
						
					}
			.form-group{
						
					
			
			
			}
		
		</style>

		
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
                       <li class="active"><a href="<%=path%>/view/student/apply.jsp">申请资助</a></li> 
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

                    <div class="row">
                        <div class="col-sm-10 col-sm-offset-1 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>填写申请表</h3>
                            		<p>填写的信息必须是真实的</p>
                        		</div>
                            </div>
			        <form action=""method="post" id="apply"> 
			            	<b><h3>1、你家里有几口人</h3></b> 
						   <input name="population"type="radio"value="2"checked="checked"/>  
						      	 2 
						   <input name="sex"type="radio"value="3">  
						       	 3  
						   <input name="sex"type="radio"value="4">  
						       	 4 
						   <input name="sex"type="radio"value="5">  
						       	 5个及其以上 
						   <b><h3>2、农村户口么？</h3></b>  
						   <input name="country"type="radio"value="农村"checked="checked"/>  
						     	  是  
						   <input name="country"type="radio"value="城镇">  
						  		  不是  
						   <b><h3>3、你是低保家庭么？</h3></b>  
						    <input name="allowances"type="radio"value="低保家庭"checked="checked"/>  
						    	是 
						    <br>  
						    <input name="allowances"type="radio"value="非低保家庭">  
						                   不是
						    <b><h3>4、你在专业的排名</h3></b>  
						    <input name="ranking"type="radio"value="前五"checked="checked"/>  
						    	前五
						    <input name="ranking"type="radio"value="前十"/>  
						                前十
						    <input name="ranking"type="radio"value="前二十"/>  
						              前二十
						     <b><h3>5、你在校违过纪么？</h3></b>  
						    <input name="principle"type="radio"value="没有"checked="checked"/>  
						    	没有
						    <input name="principle"type="radio"value="有"/>  
						                有
							  <b><h3>6、你获得过资助么？</h3></b>  
						    <input name="subsidize"type="radio"value="没有"checked="checked"/>  
						    	没有
						    <input name="subsidize"type="radio"value="有"/>  
						                   有
							<b><h3>7、月开销多大？</h3></b>  
						    <input name="spending"type="radio"value="1000以内"checked="checked"/>  
						    	1000以内
						    <input name="spending"type="radio"value="1000-2000"/>  
						                   1000-2000	 	 
						     <input name="spending"type="radio"value="2000以上"/>  
						                   2000以上	 	 
						                  
						     <br/>
						     <b><h3>8、你父母的工作？</h3></b>  
						    <input name="work"type="radio"value="管理层"checked="checked"/>  
						    	管理层
						    <input name="work"type="radio"value="工人阶层"/>  
						               工人阶层	 	 
						     <input name="work"type="radio"value="农民"/>  
						                农民 	
						      <input name="work"type="radio"value="无业 "/>  
						                无业 
						                  
						     <br/>    
			                        <a type="button" class="btn" onclick="submit()" >提交申请</a>
			                    </form>
                        </div>
                    </div>

	</body>
	<script type="text/javascript">
		    
function submit(){	    	
		    	
		    		 $.post('/graduation/ApplyUpload/applyUpload',$('#apply').serialize(),function(data){
							if(data=='true'){
								alert('提交成功');
								
							}else{
								
								alert('提交失败')
							}
							},'text');
		    	    
		    
}
</script>
<nav class="navbar navbar-default  navbar-fixed-foot text-center"> 
 <div  id="copyright">
            <p style="margin-top:10px">2018@leizhen </p>
           
             <p> 重庆交通大学资助申请系统 </p>
 </div>
 </nav>
</html>
