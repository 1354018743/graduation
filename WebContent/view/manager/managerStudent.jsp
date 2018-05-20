<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=getServletContext().getContextPath();
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理审核人员页面</title>
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
	<div id="win">
		<div id="addForm">
			<form id="addform" action="">

			    <div>   
			        <label for="stuno">学生编号：</label>   
			        <input id="stuno" class="easyui-validatebox"   type="text" name="stuno" data-options="" />   
			    </div> 
			    <div>   
			        <label for="sname">真实姓名：</label>   
			        <input id="sname" class="easyui-validatebox"   type="text" name="sname" data-options="" />   
			    </div> 
			       <div>   
			        <label for="departure1">所在学院：</label>   
			        <input id="departure1" class="easyui-validatebox"    type="text" name="departure1" data-options="" />   
			    </div> 
			    
			       <div>   
			        <label for="grade">所在班级：</label>   
			        <input id="grade" class="easyui-validatebox"    type="text" name="grade" data-options="" />   
			    </div> 
			    <div>   
			        <label for="email">使用邮箱：</label>   
			        <input id="email" class="easyui-validatebox" type="text"   name="email" data-options="" />   
			    </div> 
			      
				<a id="btn" href="javascript:addStudent()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" style="margin-left:100px;">确定</a>
				<a id="btn" href="javascript:canclemodifyLeaderMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-clear'">取消</a>  
			</form>
		</div>
	</div>
	<div id="win_modify">
		<div id="modifyForm">
			<form id="modifyform" action="">
				<div>   
			        <label for="leaderid">编号：</label>   
			        <input id="leaderid" readonly="true" style="border:0" class="easyui-validatebox" type="text" name="leaderid" data-options="" />   
			    </div> 
			    <div>   
			        <label for="leaderno">职工编号：</label>   
			        <input id="leaderno" class="easyui-validatebox"  style="border:0" type="text" name="leaderno" data-options="" />   
			    </div> 
			    <div>   
			        <label for="name">真实姓名：</label>   
			        <input id="name" class="easyui-validatebox"  style="border:0" type="text" name="name" data-options="" />   
			    </div> 
			    <div>   
			        <label for="job">在校职务：</label>   
			        <input id="job" class="easyui-validatebox"  style="border:0"  type="text" name="job" data-options="" />   
			    </div> 
			       <div>   
			        <label for="departure">所属学院：</label>   
			        <input id="departure" class="easyui-validatebox"  style="border:0"  type="text" name="departure" data-options="" />   
			    </div> 
			    <div>   
			        <label for="workplace">工作地点：</label>   
			        <input id="workplace" class="easyui-validatebox" type="text"  style="border:0" name="workplace" data-options="" />   
			    </div> 
			    <div>   
			        <label for="phone">联系电话：</label>   
			        <input id="phone" class="easyui-validatebox" type="text"  style="border:0" name="phone" data-options="" />   
			    </div> 
			    <div>   
			        <label for="type">审核权限：</label>   
			         <select name="rank" id=selecttype class=" form-control">
											
											<option value="1">
											班干部级
											</option>
											<option value="2">
											专业级
											</option>
											</option>
											<option value="3">
												学院级
											</option>
											<option value="4">
											校级
											</option>
										</select> 
			    </div> 
				<a id="btn" href="javascript:modifyPower()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" style="margin-left:100px;">确定</a>
				<a id="btn" href="javascript:canclemodifyLeaderMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-clear'">取消</a>  
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
	    url:'/graduation/managerStudent/loadStudent',
	    pagination:true,
	    rownumbers:true,
	    height:400,
	    width:890,
	    toolbar: [{
			iconCls: 'icon-remove',
			text:'删除学生',
			handler: function(){
				var rows=$("#dg").datagrid('getSelections');
				
				if(rows.length<=0){
					
					$.messager.alert('警告','请选择要删除的公司'); 
					return;
				}
				$.messager.confirm('确认','您确认想要删除吗？',function(r){    
				    if (r){    
				        
				    	var sids=[];
						for(var i=0;i<rows.length;i++){
							sids[i]=rows[i].sid
							
						}
						
						var sidStr=sids.join(",");
						
						$.post('/graduation/managerStudent/deleteStudent',{sids:sidStr},function(data){
							if(data=='true'){
								
								$.messager.alert('好消息','成功！');
								$('#dg').datagrid('load',{
									
										sname: '',
										sno: '',
									
								
								});

		  
							}else{
								$.messager.alert('警告','服务器异常！');
							}
							
						},'text');
				    	
				    }    
				});  
				
				
				
			
			}
		},'-',{
			iconCls: 'icon-add',
			text:'增加学生',
			handler: function(){
				$('#win').window('open');
			}
		}],
	    columns:[[ 
	    	{field:'',title:'',width:100,checkbox:true},
	        {field:'sid',title:'编号',width:100,align:'center'}, 
	        {field:'stuno',title:'学生编号',width:100,align:'center'},
	        {field:'name',title:'姓名',width:100,align:'center'},
	        {field:'departure',title:'学院',width:100,align:'center'}, 
	        {field:'grade',title:'班级',width:100,align:'center'},
	        {field:'email',title:'邮箱',width:150,align:'center'},
	    ]]    
	}); 
		//初始化修改权限
		$('#win_modify').window({    
		    title:"更改权限",
		    width:400,
		    height:500, 
		    iconCls:'icon-edit',
		    resizable:true,
		    modal:true,
		    closed:true
		});
		//初始化增加审核人员窗口
		$('#win').window({    
		    title:"添加学生",
		    width:400,
		    height:400, 
		    iconCls:'icon-edit',
		    resizable:true,
		    modal:true,
		    closed:true
		});
		 function modifyPower(){
			 
				var power=$('#modifyform select').val();
				var leaderid=$('#modifyform input[name="leaderid"]').val();
				$.post("/graduation/managerLeader/modifyLeaderPower",{power:power,leaderid:leaderid},function(data){
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
		 function addStudent(){
				var stuno=$('#addform input[name="stuno"]').val();
				var name=$('#addform input[name="sname"]').val();
				var departure=$('#addform input[name="departure1"]').val();
				var grade=$('#addform input[name="grade"]').val();
				var email=$('#addform input[name="email"]').val();
				$.post("/graduation/managerStudent/addStudent",$('#addform').serialize(),function(data){
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
			function modifyApply(){
				var aiid1=$('#aiid1').val();
				$.post('/graduation/leaderApply/modifyApply',{aiid1:aiid1},function(data){
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
			 function searchApply(){					
					var sname=$("input[name=sname]").val();
					var sno=$("input[name=sno]").val();
						$('#dg').datagrid('load',{
							sname:sname,
							sno:sno
						});
					
			 }
			//取消修改信息
			function canclemodifyLeaderMessage(){
				$('#win').window('close');
			}
	</script>

</body>
</html>