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
	<table id="dg" style="height:400px; width:100%"></table> 
	<div id="modify_win">
		<div id="modifyForm">
			<form id="modifyform" action="">
				对此申请进行审核
				  <div>   
			        <label for="regid">编号：</label>   
			        <input id="regid" class="easyui-validatebox"  style="border:0" type="text" name="regid" data-options="" />   
			    </div> 
			    <div>   
			        <label for="name">学生姓名：</label>   
			        <input id="name" class="easyui-validatebox"  style="border:0" type="text" name="name" data-options="" />   
			    </div> 
			    <div>   
			        <label for="studentno">学生学号：</label>   
			        <input id="studentno" class="easyui-validatebox"  style="border:0" type="text" name="studentno" data-options="" />   
			    </div> 
			    <div>   
			        <label for="email">使用邮箱：</label>   
			        <input id="email" class="easyui-validatebox"  style="border:0"  type="text" name="email" data-options="" />   
			    </div> 
			       <div>   
			        <label for="departrue">所在学院：</label>   
			        <input id="departrue" class="easyui-validatebox"  style="border:0"  type="text" name="departrue" data-options="" />   
			    </div> 
			    <div>   
			        <label for="grade">所在班级：</label>   
			        <input id="grade" class="easyui-validatebox" type="text"  style="border:0" name="grade" data-options="" />   
			    </div> 
				<a id="btn" href="javascript:accessReg()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" style="margin-left:100px;">通过</a>
				<a id="btn" href="javascript:modifyReg()" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" style="margin-left:20px;">驳回</a>  
			</form>
		</div>
	</div>
	 
	
	<script type="text/javascript">
	//预加载表格显示数据
	$(function(){	
		$('#dg').datagrid('load',{
		});
	});
	
	$('#dg').datagrid({    
	    url:'/graduation/managerReg/loadReg',
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
				$('#modifyform input[name=regid]').val(row.regid);
				$('#modifyform input[name=studentno]').val(row.studentno);
				$('#modifyform input[name=name]').val(row.name);
				$('#modifyform input[name=email]').val(row.email);
				$('#modifyform input[name=departrue]').val(row.departrue);
				$('#modifyform input[name=grade]').val(row.grade);
	    		$('#modify_win').window('open');
				}
		
		}],
	    columns:[[ 
	    	{field:'',title:'',width:100,checkbox:true},
	    	{field:'regid',title:'编号',width:100,align:'center'},
	        {field:'studentno',title:'学生编号',width:100,align:'center'}, 
	        {field:'name',title:'学生姓名',width:100,align:'center'},
	        {field:'email',title:'学生邮箱',width:300,align:'center'},
	        {field:'departrue',title:'所在学院',width:100,align:'center'},   
	        {field:'grade',title:'所在班级',width:100,align:'center'}, 
	    ]]    
	}); 
		//审核窗口
		$('#modify_win').window({    
		    title:"进行审核",
		    width:400,
		    height:400, 
		    iconCls:'icon-edit',
		    resizable:true,
		    modal:true,
		    closed:true
		});
			function accessReg(){
				var regid=$('#modifyform input[name=regid]').val();
				$.post('/graduation/managerReg/accessReg?regid='+regid,$('#modifyform').serialize(),function(data){
					if(data=='true'){
						$('#modify_win').window('close');
						$.messager.alert('好消息','成功');	
						$('#dg').datagrid('load',{		
						});
					}else{
						$.messager.alert('警告','失败！');
					}
					
				},'text');
			
			} 
			function modifyReg(){
				var regid=$('#modifyform input[name=regid]').val();
				$.post('/graduation/managerReg/modifyReg',{regid:regid},function(data){
					if(data=='true'){
						$('#modify_win').window('close');
						$.messager.alert('好消息','成功');	
						$('#dg').datagrid('load',{		
						});
					}else{
						$.messager.alert('警告','失败！');
					}
					
				},'text');
			
			} 
	</script>

</body>
</html>