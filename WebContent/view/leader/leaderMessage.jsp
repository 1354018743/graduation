<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>领导个人信息子页面</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/metro/easyui.css">   
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/icon.css">
<link href="/graduation/css/leader/leaderMessage.css" rel="stylesheet" type="text/css" media="all" />
<style type="text/css">
	
</style>
</head>
<body>
	<div id="formdiv">
	          员工编号：<input id="inst_number" name="leaderid" type="text" readonly="readonly" /><br>
		工作编号：<input id="inst_number" name="leaderno" type="text" readonly="readonly" /><br>  
		真实姓名：<input id="inst_number" name="name" type="text" readonly="readonly" /><br>
		在校职务：<input id="inst_number" name="job" type="text" readonly="readonly" /><br>
		所在学院：<input id="inst_number" name="departure" type="text" readonly="readonly" /><br>
		办公地点：<input id="com_name" name="workplace" type="text" readonly="readonly"/> <br>  
		联系电话：<input id="com_telnumber" name="phone" type="text" readonly="readonly"/><br> 
		<div id="modifydiv">
			<a href="javascript:modifyMessage()">修改</a><br>
		</div>
	</div>
	<div id="win">
		<div id="windiv">
			<form id="modifyform" action="">
			          员工编号：<input id="inst_number" name="leaderid" type="text" readonly="readonly" /><br>
				工作编号：<input  name="leaderno" type="text" readonly="readonly" /><br>  
				真实姓名：<input  name="name" type="text" /> <br>
				在校职务：<input  name="job" type="text" /> <br>  
				所在学院：<input  name="departure" type="text" /> <br>  
				办公地点：<input  name="workplace" type="text" /> <br>    
				联系电话：<input  name="phone" type="text"/><br> 
				<a id="btn" href="javascript:modifyLeaderMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
				<a id="btn" href="javascript:canclemodifyLeaderMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-clear'">取消</a>
			</form>
		</div>
	</div> 
	
	<script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="<%=path%>/easyui/jquery.easyui.min.js"></script>  
	<script src="<%=path%>/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
		$(function(){
			$('#formdiv input[name=leaderid]').val('${sessionScope.leader.leaderid}');
			$('#formdiv input[name=leaderno]').val('${sessionScope.leader.leaderno}');
			$('#formdiv input[name=name]').val('${sessionScope.leader.name}');
			$('#formdiv input[name=job]').val('${sessionScope.leader.job}');
			$('#formdiv input[name=departure]').val('${sessionScope.leader.departure}');
			$('#formdiv input[name=workplace]').val('${sessionScope.leader.workplace}');
			$('#formdiv input[name=phone]').val('${sessionScope.leader.phone}');
		});
		function modifyMessage(){
			$('#win').window('open');
			$('#modifyform input[name=leaderid]').val('${sessionScope.leader.leaderid}');
			$('#modifyform input[name=leaderno]').val('${sessionScope.leader.leaderno}');
			$('#modifyform input[name=name]').val('${sessionScope.leader.name}');
			$('#modifyform input[name=job]').val('${sessionScope.leader.job}');
			$('#modifyform input[name=departure]').val('${sessionScope.leader.departure}');
			$('#modifyform input[name=workplace]').val('${sessionScope.leader.workplace}');
			$('#modifyform input[name=phone]').val('${sessionScope.leader.phone}');
		
		}
		$('#win').window({    
		    width:500,    
		    height:400,    
		    modal:true,
		    closed:true,
		    title:'更改权限',
		    iconCls:'icon-edit'
		}); 
		
		//修改审核人员信息
		function modifyLeaderMessage(){
			$.post("/graduation/leaderMessage/modifyLeaderMessage",$('#modifyform').serialize(),function(data){
				if(data=="true"){
					
					
					$.messager.alert('恭喜','修改成功！');
					parent.location.reload()
					$('#win').window('close');
				}else{
					$('#win').window('close');
					$.messager.alert('警告','服务器异常，请稍后再试！'); 
				}
			},'text');
		}
		//取消修改信息
		function canclemodifyLeaderMessage(){
			$('#win').window('close');
		}
	</script>
	
</body>
</html>