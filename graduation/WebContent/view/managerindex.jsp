<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
<title>管理员主界面</title>
		<link href="/airlineTickets/css/managerindex.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/metro/easyui.css">   
		<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/icon.css">   
		<script type="text/javascript" src="/airlineTickets/easyui/jquery.min.js"></script>   
		<script type="text/javascript" src="/airlineTickets/easyui/jquery.easyui.min.js"></script>
		<style type="text/css">
			#header{
				background-image:url(/airlineTickets/img/main.jpg) ;
				background-repeat: no-repeat;
				background-size:100%;
				height: 100%;
				
			}
			body{
				font-family:'楷体';
			}
			#menus ul{
					list-style:none;
					padding:0px;
			
			}
			#menus ul li{
					list-style:none;
					padding:10px;
					margin-top:20px;
					text-align:center;
					font-size:20px;
					height:30px;
					line-height: 30px;
			
			}
			#menus ul li a{
							text-decoration: none;
							font-size:20px;
			}
			
		</style>
</head>

<body>
	<div  id="cc" class="easyui-layout" style="width:600px;height:400px;" fit="true" >   
    <div  data-options="region:'north'" style="height:130px;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="header">
		  <tr>
		    <td rowspan="2" align="left" valign="top" id="logo"><img src="/airlineTickets/image/manager/logo.jpg" width="110" height="100"></td>
		    <td align="left" valign="bottom">
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td align="left" valign="bottom" id="header-name">火箭旅行</td>
		        <td align="right" valign="top" id="header-right">
		        	
		            
		        </td>
		      </tr>
		    </table></td>
		  </tr>
		  <tr>
		    <td align="left" valign="bottom">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td align="left" valign="top" id="header-admin">欢迎管理员</td>
		        <td align="left" valign="bottom" id="header-menu">
		        <a href="/airlineTickets/view/manageraircompany.jsp" target="centerIframe" onFocus="this.blur()">航空公司信息</a>
		        <a href="/airlineTickets/view/managerfoundairport.jsp" target="centerIframe" onFocus="this.blur()">机场信息</a>
		        <a href="/airlineTickets/view/manageruserinfo.jsp" target="centerIframe" onFocus="this.blur()">用户信息</a>
		        <a href="/airlineTickets/view/ManagerChangePassword.jsp" target="centerIframe" onFocus="this.blur()">更改密码</a>
		        <a href=" javascript:searchAirport()"id="exist"  onFocus="this.blur()">退出登录</a>
		        </td>
		      </tr>
		    </table></td>
		  </tr>
		</table>
    </div>   
    <div  data-options="region:'center'" style="padding:0px;background:#eee;" >
    
    	<iframe name="centerIframe" style="width:100%;height:100%;border:none"src="/airlineTickets/view/manageraircompany.jsp">
    	 
     	</iframe>
    </div>   
</div> 
	<script type="text/javascript">
	$("#menus li").click(function(){
		$("#menus li").css('backgroundColor','#fff');
		$(this).css('backgroundColor','#A3C3F6')
	});
	$("#exist").click(function(){
		$.messager.confirm('确认','您确认想要退出吗？',function(r){    
		    if (r){ 
		    	
		    	window.location.href="/airlineTickets/managerlogout/logout";
		    	
		    }
		});
	
	});
	</script>

</body>

</html>