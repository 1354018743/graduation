<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>航空公司信息子页面</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/metro/easyui.css">   
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/icon.css">

<style type="text/css">
	#formdiv{
	 	width:500px;
	 	height:300px;
	 	margin:auto;
		font-size:20px;
		font-family:'楷体';
	 	margin-top:40px;	
	}
	#formdiv input{
	 	margin:20px;
	 	height:30px;
	 	width:250px;
	 	font-size:20px;
		font-family:'楷体';
		border:none;
		padding:5px;
	}
	#modifydiv{
	 	height:30px;
	 	width:200px;
	 	font-size:20px;
		font-family:'楷体';
		padding:5px;
		margin-left:290px;
	}
	#modifydiv a{
		text-decoration: none;
	}
	#windiv{
		width:350px;
		height:200px;
		margin:auto;
		font-size:18px;
		font-family:'楷体';
	 	margin-top:40px;
	}
	#windiv input{
		margin:10px;
	 	height:20px;
	 	width:200px;
	 	font-size:18px;
		font-family:'楷体';
		padding:5px;
	}
	#btn{
		margin:10px;
		margin-left:70px;
	}
</style>
</head>
<body>
	<div id="formdiv">
		公司编号：<input id="inst_number" name="inst_number" type="text" readonly="readonly" /><br>  
		公司名称：<input id="com_name" name="com_name" type="text" readonly="readonly"/> <br>  
		电话号码：<input id="com_telnumber" name="com_telnumber" type="text" readonly="readonly"/><br> 
		<div id="modifydiv">
			<a href="javascript:modifyMessage()">修改</a><br>
		</div>
	</div>
	<div id="win">
		<div id="windiv">
			<form id="modifyform" action="">
				公司编号：<input  name="inst_number" type="text" readonly="readonly" /><br>  
				公司名称：<input  name="com_name" type="text" /> <br>  
				电话号码：<input  name="com_telnumber" type="text"/><br> 
				<a id="btn" href="javascript:modifycompanyMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
				<a id="btn" href="javascript:canclemodifycompanyMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-clear'">取消</a>
			</form>
		</div>
	</div> 
	
	<script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="<%=path%>/easyui/jquery.easyui.min.js"></script>  
	<script src="<%=path%>/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
		$(function(){
			$('#inst_number').val('${sessionScope.airCompany.inst_number}');
			$('#com_name').val('${sessionScope.airCompany.com_name}');
			$('#com_telnumber').val('${sessionScope.airCompany.com_telnumber}');
		});
		function modifyMessage(){
			$('#win').window('open');
			$('#modifyform input[name=inst_number]').val('${sessionScope.airCompany.inst_number}');
			$('#modifyform input[name=com_name]').val('${sessionScope.airCompany.com_name}');
			$('#modifyform input[name=com_telnumber]').val('${sessionScope.airCompany.com_telnumber}');
		
		}
		$('#win').window({    
		    width:500,    
		    height:300,    
		    modal:true,
		    closed:true,
		    title:'修改信息',
		    iconCls:'icon-edit'
		}); 
		
		//修改航班信息
		function modifycompanyMessage(){
			$.post("/airlineTickets/airlineCompanyMessage/modifyCompanyMessage",$('#modifyform').serialize(),function(data){
				if(data=="true"){
					$('#win').window('close');
					parent.location.reload()
					$.messager.alert('恭喜','修改成功！'); 
				}else{
					$('#win').window('close');
					$.messager.alert('警告','服务器异常，请稍后再试！'); 
				}
			},'text');
		}
		//取消修改信息
		function canclemodifycompanyMessage(){
			$('#win').window('close');
		}
	</script>
	
</body>
</html>