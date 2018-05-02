<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet" type="text/css" href="/airlineTickets/css/bootstrap.min.css" />
<script type="text/javascript" src="/airlineTickets/js/jquery-1.11.0.min.js" charset="utf-8" ></script>
<script type="text/javascript" src="/airlineTickets/js/bootstrap.min.js" charset="utf-8" ></script>
<title>用户注册</title>

    <style type="text/css">
			html{
				height: 580px;
			}
			body{
				height: 580px;
			}
			#div1{
				 width: 1100px;
			}
			#diva{
				 border:#000 solid 1px;
				 margin-top: 10px;
				 width: 1100px;
				 height: 100%;
			}
			#wenzi1{
				position: relative;
				margin-left:7%;
				 top: 1.5%;
				font-size: 10px;
				color: forestgreen;
			}
			#wenzi2{
				margin-top:-1px;
				
				font-size: 19px;
				color:#FFFFFF;
				margin-left: 5px;
				
			}
			#divc{
				 width: 86%;
				 height: 90%;
				 border:#000 solid 1px;
				position: relative;
                 left: 7%;
                 top: 2%;
                
			}
			#divb{
				 position: relative;
				width: 100%;
				height:25px;
				border:#000 solid 1px;
				background: greenyellow;
			}
			#divd>span{
				color:red;
			    
			}
			#divd{
				position: relative;
				margin-top:3%;
				margin-left: 35%;
				
			}
			#bott{
				margin-left: 50px;
			}
			#divd>lable {
				color:red;
				margin-left:10px;
			}
			#divd>img{
				width: 50px;
				height:50px;
				margin-left: 40px;
			}
			#wenzitouxiang{
				position: relative;
				top: -20px;
			}
			#picturefile{
				position: relative;
				top:30px;
				left:-70px;
			}
			#telephone{
				margin-top: 25px;
			}
			
		</style>
</head>
<body>
     <div data-options="region:'north'" style="height:158px" id="div1">
		  <img src="/airlineTickets/img/main.jpg" style="height:100%;width:100%">
		  <h1 style="position:relative;text-align: center;margin-top:-120px;font-size:xx-large;"><strong>火箭航空网上购票系统</strong></h1>
    	  <h6><label style="position:relative;margin-left:200px;color:red;margin-top:-70px;font-size:small;">火箭航空网上购票</label><label style="color:#A8A7FD;margin-top:-70px;font-size:small;">是目前国内新兴的热门网上购票系统，截至目前，没有授权于其他网站开发类似服务内容，敬请广大用户注意<label></h6>
        </div> 
         <div id="diva">
         	 <h1 id="wenzi1">你现在的位置是：用户注册</h1>
        	<div id="divc">
        	  <div id="divb">
        	    <h1 id="wenzi2">账户信息</h>	
        	  </div>
        	  <form action="/airlineTicket/passenger2/login" method="post" enctype="multipart/form-data" >
        	    <div id="divd">
        	  	   <span>*</span>用  户  名：<input type="text" name="username" id="username" onblur="return regusername()"><lable></lable></p>
        	  	   <span>*</span>登录密码：<input type="password" name="password1" id="password" onblur="return regpassword()"><lable></lable></p>
        	  	   <span>*</span>确认密码：<input type="password" name="password2" id="password2" onblur="return regpasswordnext()"><lable></lable></p>
        	  	   <span>*</span>姓     名：<input type="text" name="realname"><lable>提示：请输入真实姓名</lable></p>
        	  	                                                           性     别：<input type="radio" name="sex" value="1"/>男 
        	  	                      <input type="radio" name="sex" value="2"/>女</p>
        	  	      
        	  	   <span>*</span>证件号码：<input type="text" name="cardid" id="idnumber" onblur="return regidnumber()"><lable></lable></p>
        	  	                                                           邮         箱：<input type="text" name="mail" id="email" onblur="return regemaile()"><lable></lable></p>
        	  	   <label id="wenzitouxiang"> 头        像：</label>  <img></img>
        	  	                        <input type="file" name="file" id="picturefile" onchange="showpicturn()"/></p>
        	  	   <span>*</span> 手机号码：<input type="text" name="telephone" id="telephone" onblur="return regtelephone()"><lable></lable></p>
        	  	   <input type="button" value="注册"  data-toggle="modal" data-target="#myModal"  onclick="return submitform()"><input type="button" value="返回" id="bott">
        	  	   <!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					    <div class="modal-dialog">
					        <div class="modal-content">
					            <div class="modal-header">
					                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					                <h4 class="modal-title" id="myModalLabel">邮箱验证</h4>
					            </div>
					            <div class="modal-body"><lable id="lablexy">验证码：</lable><span ></span></p>
					                                     <lable>验证码：</lable><input type="text" name="telephoneyazhengma"> <a herf="">发送验证码</a>
					            </div>
					            <div class="modal-footer">
					                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
					                <button type="submit" class="btn btn-primary">提交注册</button>
					            </div>
					        </div><!-- /.modal-content -->
					    </div><!-- /.modal -->
					</div>
        	     </div>
        	   </form>
        	</div>
         </div>
          <span style="color:red">
            	<%= request.getAttribute("loginInfo")==null?"":request.getAttribute("loginInfo").toString() %>
          </span>
    	<script> 
    			
    			var onpaswordcount=false;
    		
    		 
    		//验证手机号码是否正确
    		  function regtelephone(){
    		  	//从用户的输入中得到手机号码
		    	var telephone=document.getElementById("telephone").value;
		    	//定义手机号码的正则表达式
		    	var regtelephone=/^1[3|5|7|8]\d{9}$/;
		    	//用test验证两个手机号是否符合正则规定
		    	if(regtelephone.test(telephone)){
					document.getElementById("telephone").nextElementSibling.innerHTML="√";
				    return true;
				}else{
				  document.getElementById("telephone").nextElementSibling.innerHTML="手机号码有误";
	              	return false;		
				}
		       }
    		 //验证身份证号码
    		  function regidnumber(){
		    	 var idnumber=document.getElementById("idnumber").value;
			     var regidnumber=/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
				 if(regidnumber.test(idnumber)){
					document.getElementById("idnumber").nextElementSibling.innerHTML="√";
				    return true;
				 }else{
				    document.getElementById("idnumber").nextElementSibling.innerHTML="身份证号有误";
	              	return false;		
				}
		   
				
		    }
    		  //验证邮箱
    		    function regemaile(){
		    	var email=document.getElementById("email").value;
				var regemaile=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
				if(regemaile.test(email)){
					document.getElementById("email").nextElementSibling.innerHTML="√";
				  return true;
				}else{
				  document.getElementById("email").nextElementSibling.innerHTML="邮箱有误";
	              	return false;		
				}
					
			
		    }
    		//验证用户名是否为空
    		   function regusername(){
    		   	 var username=document.getElementById("username").value;
    		   	 if(username==""||username==null){
    		   	 	document.getElementById("username").nextElementSibling.innerHTML="用户名不能为空";
    		   	 	return false;
    		   	 }else if(username.length<5){
    		   	 	document.getElementById("username").nextElementSibling.innerHTML="用户名不少于5个字符";
    		   	 	return false;
    		   	 }else{
    		   	 	document.getElementById("username").nextElementSibling.innerHTML="√";
    		   	 	return true;
    		   	 }
    		   }
    		 //验证密码是否为空，至少六位
    		  function regpassword(){
    		  	
    		  	if(onpaswordcount){
    		  	 regpasswordnext();
    		  	}
    		   	 var username=document.getElementById("password").value;
    		   	 if(username==""||username==null){
    		   	 	document.getElementById("password").nextElementSibling.innerHTML="用户名不能为空";
    		   	 	onpaswordcount=true;
    		   	 	return false;
    		   	 }else if(username.length<6){
    		   	 	document.getElementById("password").nextElementSibling.innerHTML="用户名不少于6个字符";
    		   	 	onpaswordcount=true;
    		   	 	return false;
    		   	 }else{
    		   	 	document.getElementById("password").nextElementSibling.innerHTML="√";
    		   	 	onpaswordcount=true;
    		   	 	return true;
    		   	 }
    		   	 
    		    
    		   }
    		 //验证第二次输入密码是否等于第一次
    		 function regpasswordnext(){
    		 	var password1=document.getElementById("password").value;
    		 	var password2=document.getElementById("password2").value;
    		 	if(password1==password2){
    		 		document.getElementById("password2").nextElementSibling.innerHTML="√";
    		 		return true;
    		 	}else{
    		 		document.getElementById("password2").nextElementSibling.innerHTML="前后密码不一致";
    		 		return false;
    		 	}
    		 }
    		 //即时显示图片
    		 function showpicturn(){
    		 	//获得文件的路径
    		 	//通过文件路径获得图片
    		 	//用循环将二进文件读取进去img
    		 	var picture=document.getElementById("picturefile").value;
    		 	
    		 	
    		 }
    		 function  submitform(){
    			 var result=regusername()&regpassword()&regtelephone()&regemaile()&regidnumber()&regpasswordnext();
 				if(result){
 					var tel=document.getElementById("telephone").value
 					document.getElementById("lablexy").nextElementSibling.innerHTML=tel;
 					return true;
 					
 				}else{
 					return false;
 				}    			 
    			 
    		 }
    		 
    	</script>
    	  

</body>
</html>