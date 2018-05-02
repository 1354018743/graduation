<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>航空购票系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
         <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
         <link rel="stylesheet" href="../css/style.css">
    
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <style type="text/css">
        	body{
        		background-image:url(/airlineTickets/img/loginbeijing.gif);
        		background-size:100%;
        	}
            #wenzi1{
             color:green;
             position: absolute;
             margin-top:160px;
             margin-left:300px ;
            }
            #wenzi2{
             color:#000000;
             font-size:10px;
             position:absolute;
             left:70px;
             top:180px;
            }
            #check1{
             width:15px;
             position:absolute;
             left:50px;
             top:140px;
             
            }
            #imgs1{
            	position: absolute;
            	margin-top:170px;
            	margin-left:260px;
            	width: 30px;
            	height: 30px;
            }
            #maindiv{
            	position:absolute;
            	width: 1230px;
            	height: 600px;
            }
            #div2{
            	border-color:#0000FF;
            	border-left:1px;
            	position:absolute;
            	left:280px;
                top:250px;
            }
             #div3{
            	border-color:#0000FF;
            	border-left:1px;
            	position:absolute;
            	left:280px;
                top:300px;
            }
             #div2{
            	position:absolute;
            	left:280px;
                top:250px;
              
                
            }
              .imgs2{
            	width: 30px;
            	height: 32px;
            	position:relative;
            	left:0px;
                top:10px;
                border:#000 solid 1px;
                border-right:none ;
            }
            .textbox1{
            	width:300px;
            	height: 30px;
            	position:relative;
            	left:0px;
            	top:-3.5px;
            	border:#000 solid 1px;
            	border-left:none ;
            }
            
            #div4{
            	border-color:#0000FF;
            	border-left:1px;
            	position:absolute;
            	left:320px;
                top:360px;
            }
             #div4>h1{
             	font-size: 16px;
             }
             #inputx1{
             	position:relative;
            	left:52px;
                top:-55px;
                width:80px;
            	height: 30px;
             }
             .canven{
             	position:relative;
             	left:72px;
                top:-40px;
             }
             #bton{
             	position:absolute;
             	left:350px;
                top:420px;
                width: 60px;
                height: 40px;
             }
             #bton1{
             	position:absolute;
             	left:450px;
                top:420px;
                width: 60px;
                height: 40px;
             }
             #span2{
                position:absolute;
                left:370px;
                top:480px;
                
             
             }
        </style>
       

</head>
<body>
      <div class="page-container" id="maindiv">
            <form action="/airlineTicket/passenger2/login" method="post">
            	 <img src="/airlineTickets/img/logo.jpg" id="imgs1"></img>
                 <h1 id="wenzi1">航空购票系统用户登录</h1>
                     <div id="div2"><img src="/airlineTickets/img/timg.jpg" class="imgs2"><input type="text" name="username" class="username textbox1" placeholder="请输入用户名"></div></br>
                     <div id="div3"><img src="/airlineTickets/img/suo.jpg" class="imgs2"><input type="password" name="password" class="password textbox1" placeholder="请输入密码"></div></br>
                     <div id="div4"><h1>验证码:</h1><input type="text" name="yanzhengma" id="inputx1"><canvas id="canvas" width="120" height="40" class="canven"></canvas></div><br>
                      <input type="hidden" name="scyanzhengma" id="hid">
                <button type="submit" id="bton">登录</button>
                <button id="bton1">返回</button>
            </form>
               
            <span style="color:red" id="span2">
            	<%= request.getAttribute("loginInfo")==null?"":request.getAttribute("loginInfo").toString() %>
            </span>
            
        </div>

        <!-- Javascript -->
        <script src="/airlineTickets/js/jquery-1.11.0.min.js"></script>
        <script src="/airlineTickets/easyui/jquery.easyui.min.js"></script>
        <script src="/airlineTickets/easyui/loacal/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript">
       
		//随机数
		function randomNum(min,max){
			return Math.floor(Math.random()*(max-min)+min);
		}
		//随机颜色
		function randomColor(min,max){
			var r=randomNum(min,max);
			var g=randomNum(min,max);
			var b=randomNum(min,max);
			return "rgb("+r+","+g+","+b+")";
		}
		var can=document.getElementById("canvas");
		var ctx=can.getContext("2d");
		
		ctx.fillStyle=randomColor(170,250);
		ctx.fillRect(0,0,120,40);
		
		var str="ABCDEFGHIJKLMNPQRSTUVWXYZ123456789";
		var numx="";
		for(var i=0;i<4;i++){
			var numbers=str[randomNum(0,str.length)];
			
			numx=numx+numbers;
			ctx.fillStyle=randomColor(50,100);
			ctx.baselineShift="top";
			ctx.font=randomNum(15,30)+"px";
			var x=10+i*30;
			var y=25;
			var rotate=randomNum(-10,10);
			ctx.rotate(rotate*Math.PI/180);
			ctx.translate(x,y);
			ctx.fillText(numbers,0,0);
			ctx.rotate(-rotate*Math.PI/180);
			ctx.translate(-x,-y);
			
			
		}
		
		
		for(var i=0;i<6;i++){
			ctx.strokeStyle=randomColor(100,170);
			var x1=randomNum(0,120);
			var y1=randomNum(0,40);
			var x2=randomNum(0,120);
			var y2=randomNum(0,40);
			ctx.moveTo(x1,y1);
			ctx.lineTo(x2,y2);
			ctx.stroke();
		}
		  
		document.getElementById("hid").value=numx;
		  
		 
	</script>
	
		
		
		
</body>
</html>