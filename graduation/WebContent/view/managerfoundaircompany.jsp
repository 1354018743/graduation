<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>航空公司信息</title>
	<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/metro/easyui.css">   
	<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/icon.css">   
	<script type="text/javascript" src="/airlineTickets/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="/airlineTickets/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div id="win">
	
	<form id="ss" method="post">   
			
			    <div>   
			        <label for="inst_number">公司编号：</label>   
			        <input id="inst_number" class="easyui-validatebox" type="text"  name="inst_number1" data-options="" />   
			    </div>   
			    <div>   
			        <label for="com_name">航空公司名称：</label>   
			        <input id="com_name" class="easyui-validatebox"  type="text" name="com_name1" data-options="" />   
			    </div>   
 				<div>   
			        <label for="com_telnumber">公司电话：</label>   
			        <input id="com_telnumber" class="easyui-validatebox" type="text" name="com_telnumber1" data-options="" />   
			    </div> 
			    <a id="btn" href="javascript:addAirCompany()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="margin-top:20px">确认修改</a>
			</form> 
	
	</div>
<div id="win_1">
	
	<form id="w" method="post">   
				<div>   
			        <label for="cid">编&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp号：</label>   
			        <input id="cid" class="easyui-validatebox" type="text" name="cid" readonly= "readonly" />   
			    </div>  
			    <div>   
			        <label for="inst_number">公司编号：</label>   
			        <input id="inst_number" class="easyui-validatebox" type="text" name="inst_number" data-options="" />   
			    </div>   
			    <div>   
			        <label for="com_name">航空公司名称：</label>   
			        <input id="com_name" class="easyui-validatebox" type="text" name="com_name" data-options="" />   
			    </div>   
 				<div>   
			        <label for="com_telnumber">公司电话：</label>   
			        <input id="com_telnumber" class="easyui-validatebox" type="text" name="com_telnumber" data-options="" />   
			    </div> 
			    <a id="btn" href="javascript:modifyAirCompany()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="margin-top:20px">确认修改</a>
			</form> 
	
	</div>
	<table id="dg"></table>
	<script type="text/javascript">
	$('#dg').datagrid({    
	    url:'/airlineTickets/AirCompany/loadAirCompany', 
	    pagination:true,
	    rownumbers:true,
	    height:400,
	    toolbar: [{
			iconCls: 'icon-add',
			text:'添加',
			handler: function(){
				
				$('#win').window('open');
	
			}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除',
			handler: function(){
				var rows=$("#dg").datagrid('getSelections');
				if(rows.length<=0){
					$.messager.alert("确认","请选中");
					return;
				}
					$.messager.confirm("确认","删除航空该空公司",function(r){
						if(r){
							var cids=[];
							for(var i=0;i<rows.length;i++){
								cids[i]=rows[i].cid;
						}
							var cidStr=cids.join(",");	
						$.post('/airlineTickets/AirCompany/deleteCompanys',{cids:cidStr},function(data){
                                if(data=='true'){
								$.messager.alert('好消息','成功！');
								$('#dg').datagrid('load',{
								
								});
								}else{
									$.messeger.alert("确定","错了");
								}
						
						
						},'text');	
						}
					})
				
			}
		},'-',{
			iconCls: 'icon-edit',
			text:'修改',
			handler: function(){
				var row=$('#dg').datagrid('getSelected');
				if(!row){
					$.messager.alert('错误','请选择一个机场');
					return ;
				}
				$('#win_1').window('open');
				var cid= row.cid;
				$.post('/airlineTickets/AirCompany/loadAirCompanybycid',{cid:cid},function(data){	

					$("#cid").val(data[0].cid);
					$("#inst_number").val(data[0].inst_number);
					$("#com_name").val(data[0].com_name);
					$("#com_telnumber").val(data[0].com_telnumber);
				},'json');
			}
		}],

	    columns:[[ 
	    	{field:'',title:'',width:100,checkbox:true},
	        {field:'cid',title:'编号',width:200},    
	        {field:'inst_number',title:'公司编号',width:200},    
	        {field:'com_name',title:'公司名称',width:200}, 
	        {field:'com_telnumber',title:'公司电话',width:200}
	           
	    ]]    
	}); 
	
	$('#win_1').window({    
	    width:400,    
	    height:300,    
	    modal:true,  
	    closed:true,
	    minimizable:false,
	    maximizable:false,
	    collapsible:false,
	    title:"修改公司信息",
	});
	
	$('#win').window({    
	    width:400,    
	    height:300,    
	    modal:true,  
	    closed:true,
	    minimizable:false,
	    maximizable:false,
	    collapsible:false,
	    title:"修改公司信息",
	});
	//异步修改信息
	function modifyAirCompany(){
		var cid=$('#cid').val();
		var inst_number=$('#inst_number').val();
		var com_name=$('#com_name').val();
		var com_telnumber=$('#com_telnumber').val();
		$.post('/airlineTickets/AirCompany/modifyAirCompany',{cid:cid,inst_number:inst_number,com_name:com_name,com_telnumber:com_telnumber},function(data){
			if(data=='true'){
				$('#win_1').window('close');
				$.messager.alert('好消息','成功');	
				$('#dg').datagrid('load',{		
				});
			}else{
				$.messager.alert('警告','失败！');
			}
			
		},'text');
	
	}
	function addAirCompany(){
		var inst_number=$("input[name='inst_number1']").val();
		var com_name=$("input[name='com_name1']").val();
		var com_telnumber=$("input[name='com_telnumber1']").val();
		alert(com_telnumber);
		$.post('/airlineTickets/AirCompany/addAirCompany',{inst_number:inst_number,com_name:com_name,com_telnumber:com_telnumber},function(data){
			if(data=='true'){
				$('#win').window('close');
				$.messager.alert('好消息','成功！');
				$('#dg').datagrid('load',{
					
				});
			}else{
				$.messager.alert('警告','服务器异常！');
			}
			
		},'text');
	}

</script>
</body>
</html>