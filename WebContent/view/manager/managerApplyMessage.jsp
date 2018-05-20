<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=getServletContext().getContextPath();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>优惠政策子页面</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/metro/easyui.css">   
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/icon.css">
<script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="<%=path%>/easyui/jquery.easyui.min.js"></script>
<style type="text/css">
	#addForm{
		width:320px;
		height:150px;
		margin:auto;
		margin-top:30px;
		font-size: 16px;
		font-family: '楷体';
	}
	#addForm input{
		margin:8px;
		margin-top:20px;
		font-size: 16px;
		font-family: '楷体';
	}
	#addForm select{
		margin:8px;
		margin-left:25px;
		width:170px;
		height:25px;
	}
	
	#modifyForm{
		width:350px;
		height:200px;
		font-size:18px;
		font-family: '楷体';
		margin:auto;
		margin-top:30px;
	}
	#modifyForm input{
		margin:10px;
	}
	#modifyForm a{
		margin:20px;
	}
	#findForm{
		font-size:15px;
		
	}
	#findForm input{
		margin:5px;
	}
	#findForm select{
		margin:5px;
		width:180px;
	}
	
</style>
</head>
<body>
	<div id="findForm">
		<form id="searchform" action="">
			学生姓名：<input type="text" name="sname" class="easyui-validatebox" placeholder="请输入学生姓名">
			学生编号：<input type="text" name="sno" class="easyui-validatebox" placeholder="请输入学生编号">
			<a id="btn" href="javascript:searchApply()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-left:10px;">查找</a>  
		</form>
	</div>

	<table id="dg" style="height:400px; width:100%"></table> 
	<script type="text/javascript">
	//预加载表格显示数据
	$(function(){	
		$('#dg').datagrid('load',{
			sname:'',
			sno:''
		});
	});
	//格式化日期
	function parsJSONDate(json){
		var year=json.year+1900;
		var month=json.month+1;
		var date=json.date;
		var hour=json.hours;
		var minute=json.minutes;
		var second=json.seconds;
		return year+"-"+(month>10?month:("0"+month))+"-"+(date>10?date:("0"+date))+" "+(hour>10?hour:("0"+hour))+":"+(minute>10?minute:("0"+minute));
	}
	function progress(json){
		if(json==0){
			
			return "未通过";
			
		}else if(json==1){
			
			return "班级通过";
		}else if(json==2){
			
			return "专业审核通过";
		}else if(json==3){
			
			return "学院通过";
		}else if(json==4){
			
			return "学校通过";
		}
	
	}
	
	var lid=${sessionScope.user.lid}
	
	$('#dg').datagrid({    
	    url:'<%=path%>/managerstudentApplyMessage/loadApplyMessage',
	    pagination:true,
	    rownumbers:true,
	    height:400,
	    width:890,
	    columns:[[ 
	    	{field:'',title:'',width:100,checkbox:true},
	        {field:'aiid',title:'编号',width:100,align:'center'}, 
	        {field:'sname',title:'姓名',width:100,align:'center'},
	        {field:'sno',title:'学号',width:100,align:'center'},
	        {field:'applytime',title:'申请时间',width:200,align:'center',
	        	formatter: function(value,row,index){
					return parsJSONDate(value);
				},
				
	        },   
	        {field:'progress',title:'进度',width:200,align:'center',
	        	formatter: function(value,row,index){
					return progress(value);
				},
				
	        },
	        {field:'score',title:'得分',width:100,align:'center'},   
	    ]]    
	}); 
		 function searchApply(){
			 
				var applytime=$("input[name=applytime]").val();
				
				var sname=$("input[name=sname]").val();
				var sno=$("input[name=sno]").val();
					$('#dg').datagrid('load',{
						sname:sname,
						sno:sno
					});
				
		 }
			
	</script>

</body>
</html>