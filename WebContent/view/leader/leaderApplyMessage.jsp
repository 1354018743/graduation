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
	<div id="modify_win">
		<div id="modifyForm">
			<form id="modifyform" action="">
				对此申请进行审核
				<div>   
			        <label for="aiid1">申请编号：</label>   
			        <input id="aiid1" readonly="true" style="border:0" class="easyui-validatebox" type="text" name="aiid1" data-options="" />   
			    </div> 
			    <div>   
			        <label for="sname1">学生姓名：</label>   
			        <input id="sname1" class="easyui-validatebox"  style="border:0" type="text" name="sname1" data-options="" />   
			    </div> 
			    <div>   
			        <label for="sno1">学生学号：</label>   
			        <input id="sno1" class="easyui-validatebox"  style="border:0" type="text" name="sno1" data-options="" />   
			    </div> 
			    <div>   
			        <label for="applytime1">申请时间：</label>   
			        <input id="applytime1" class="easyui-validatebox"  style="border:0"  type="text" name="applytime1" data-options="" />   
			    </div> 
			       <div>   
			        <label for="progress1">申请进度：</label>   
			        <input id="progress1" class="easyui-validatebox"  style="border:0"  type="text" name="progress1" data-options="" />   
			    </div> 
			    <div>   
			        <label for="score1">所得分数：</label>   
			        <input id="score1" class="easyui-validatebox" type="text"  style="border:0" name="score1" data-options="" />   
			    </div> 
				<a id="btn" href="javascript:accessApply()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" style="margin-left:100px;">通过</a>
				<a id="btn" href="javascript:modifyApply()" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" style="margin-left:20px;">驳回</a>  
			</form>
		</div>
	</div>
	 
	
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
			
			return "已提交申请";
			
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
	    url:'/graduation/studentApplyMessage/loadApplyMessage?lid='+lid,
	    pagination:true,
	    rownumbers:true,
	    height:400,
	    width:890,
	    toolbar: [{
			iconCls: 'icon-edit',
			text:'进行审核',
			handler: function(){
				var row=$('#dg').datagrid('getSelected');
				if(!row){
	    			$.messager.alert('警告','请选择要审核的申请！');  
	    			return;
	    		}
				$('#modifyform input[name=aiid1]').val(row.aiid);
				$('#modifyform input[name=sname1]').val(row.sname);
				$('#modifyform input[name=sno1]').val(row.sno);
				$('#modifyform input[name=applytime1]').val(parsJSONDate(row.applytime));
				$('#modifyform input[name=score1]').val(row.score);
				$('#modifyform input[name=progress1]').val(progress(row.progress));
	    		$('#modify_win').window('open');
				}
		
		}],
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
		//初始化窗口
		$('#modify_win').window({    
		    title:"进行审核",
		    width:400,
		    height:400, 
		    iconCls:'icon-edit',
		    resizable:true,
		    modal:true,
		    closed:true
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
			function accessApply(){
				var aiid1=$('#aiid1').val();
				$.post('/graduation/leaderApply/accessApply',{aiid1:aiid1},function(data){
					if(data=='true'){
						$('#modify_win').window('close');
						$.messager.alert('好消息','成功');	
						$('#dg').datagrid('load',{	
							sname:'',
							sno:''
						});
					}else{
						$.messager.alert('警告','失败！');
					}
					
				},'text');
			
			} 
			function modifyApply(){
				var aiid1=$('#aiid1').val();
				$.post('/graduation/leaderApply/modifyApply',{aiid1:aiid1},function(data){
					if(data=='true'){
						$('#modify_win').window('close');
						$.messager.alert('好消息','成功');	
						$('#dg').datagrid('load',{
							sname:'',
							sno:''
						});
					}else{
						$.messager.alert('警告','失败！');
					}
					
				},'text');
			
			} 
	</script>

</body>
</html>