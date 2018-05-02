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
	<script type="text/javascript" src="/airlineTickets/easyui/locale/easyui-lang-zh_CN.js"></script>
	<style type="text/css">
	#dg{
		background-color: #ccc;
		
	}
	#ff{
		text-align:center;
		
	}
	#ff input{
		 margin-top:15px;
		
	}
	#ff_1{
		text-align:center;
		
	}
	#ff_1 input{
		 margin-top:15px;
		
	}
	#content{
		
		float: left;
		margin-left:40px;
		margin-top:10px;
	}
	#left {
	
		float: left;
		margin-top:40px;
		margin-left:20px;
		font-family:'楷体';
		text-align:center;
	
	}
	#left input{
			margin-top:20px;
	
	}
	#left a {
			margin-top:40px;
	
	}
	</style>
</head>
<body>
<div id="left">
	<b>你可以根据以下条件查找：</b><br/>
	<form id="ff_2" method="post">   
			    <div>   
			        <label for="inst_number1">公司编号：</label>   
			        <input  class="easyui-validatebox" type="text" name="inst_number1" />   
			    </div>   
			    <div>   
			        <label for="com_name1">公司名称：</label>   
			        <input class="easyui-validatebox" type="text" name="com_name1" />   
			    </div>   
 				<div>   
			        <label for="com_telnumber1">联系电话：</label>   
			        <input class="easyui-validatebox" type="text" name="com_telnumber1"  />   
			    </div> 
			    <a id="btn" href="javascript:searchCompany()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-top:20px">开始查找</a>
			</form> 
</div>
<div id="content">

	<table id="dg"></table>
	<div id="win">
	
		<form id="ff_1" method="post">   
			    <div>   
			        <label for="inst_number">公司编号：</label>   
			        <input class="easyui-validatebox" type="text" name="inst_number"   data-options="validType:'inst_number'"/>   
			    </div>   
			    <div>   
			        <label for="com_name">公司名称：</label>   
			        <input class="easyui-validatebox" type="text" name="com_name"  data-options="validType:'com_name'"/>   
			    </div>   
 				<div>   
			        <label for="com_telnumber">联系电话：</label>   
			        <input class="easyui-validatebox" type="text" name="com_telnumber"  data-options="validType:'com_telnumber'"/>   
			    </div> 
			    <a id="btn" href="javascript:addCompany()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="margin-top:20px">确认增加</a>
			</form> 
	
	</div> 
	<div id="win_1">
	
	<form id="ff" method="post">   
				<div>   
			        <label for="cid">编&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp号：</label>   
			        <input id="cid" class="easyui-validatebox" type="text" name="cid2" readonly= "readonly" />   
			    </div>  
			    <div>   
			        <label for="inst_number">公司编号：</label>   
			        <input id="inst_number" class="easyui-validatebox" type="text" name="inst_number2"data-options="validType:'inst_number'"  />   
			    </div>   
			    <div>   
			        <label for="com_name">公司名称：</label>   
			        <input id="com_name" class="easyui-validatebox" type="text" name="com_name2" data-options="validType:'com_name'"  />   
			    </div>   
 				<div>   
			        <label for="com_telnumber">联系电话：</label>   
			        <input id="com_telnumber" class="easyui-validatebox" type="text" name="com_telnumber2" data-options="validType:'com_telnumber'" />   
			    </div> 
			    <a id="btn" href="javascript:modifyCompany()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="margin-top:20px">确认修改</a>
			</form> 
	
	</div>
	</div> 
</body>
	<script type="text/javascript">
	
//预加载表格显示数据


	$(function(){
		
		$('#dg').datagrid('load',{
			inst_number1:'',
			com_name1:'',
			com_telnumber1:'',
		});
	});
	$('#dg').datagrid({    
	    url:'/airlineTickets/managercompany/loadCompany',
	    pagination:true,
	    rownumbers:true,
	    height:400,
	    width:890,

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
					
					$.messager.alert('警告','请选择要删除的公司'); 
					return;
				}
				$.messager.confirm('确认','您确认想要删除吗？',function(r){    
				    if (r){    
				        
				    	var cids=[];
						for(var i=0;i<rows.length;i++){
							cids[i]=rows[i].cid
							
						}
						
						var cidStr=cids.join(",");
						
						$.post('/airlineTickets/managercompany/deleteCompany',{cids:cidStr},function(data){
							if(data=='true'){
								
								$.messager.alert('好消息','成功！');
								$('#dg').datagrid('load',{
									
										inst_number1: '',
										com_name1: '',
										com_telnumber1:'',
									
								
								});

		  
							}else{
								$.messager.alert('警告','服务器异常！');
							}
							
						},'text');
				    	
				    }    
				});  
				
				
				
			
			}
		},'-',{
			iconCls: 'icon-edit',
			text:'修改',
			handler: function(){

				var row=$("#dg").datagrid('getSelected');
				if(!row){
					
					$.messager.alert('警告','请选择要修改的公司'); 
					return;
				}
				$('#win_1').window('open');
				var cid= row.cid;
				$.post('/airlineTickets/managercompany/loadCompanyByCid',{cid:cid},function(data){	

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
	        {field:'com_telnumber',title:'联系电话',width:200},   
	    ]]    
	}); 
	
	$('#win').window({    
	    width:400,    
	    height:300,    
	    modal:true,  
	    closed:true,
	    minimizable:false,
	    maximizable:false,
	    collapsible:false,
	    title:"添加公司",
	}); 
	
	$('#win_1').window({    
	    width:400,    
	    height:300,    
	    modal:true,  
	    closed:true,
	    minimizable:false,
	    maximizable:false,
	    collapsible:false,
	    title:"修改公司",
	}); 
	//添加机场
	function addCompany(){
		var inst_number=$("input[name='inst_number']").val();
		var com_name=$("input[name='com_name']").val();
		var com_telnumber=$("input[name='com_telnumber']").val();
		$('#ff_1').form('clear');
		$('#ff_1').form('submit',{
			onSubmit:function(){
				$.post('/airlineTickets/managercompany/addCompany',{inst_number:inst_number,com_name:com_name,com_telnumber:com_telnumber},function(data){
					if(data=='true'){
						
						$('#win').window('close');
						$.messager.alert('好消息','成功！');
						
						$('#dg').datagrid('load',{
							inst_number1: '',
							com_name1: '',
							com_telnumber1:'',
						});
					}else{
						$.messager.alert('警告','服务器异常！');
					}
					
				},'text');
			}
		});
		
	}
	
	//修改机场
	
 function modifyCompany(){
	 	
	    var cid=$("#cid").val();
	    var inst_number=$("#inst_number").val();
		var com_name=$("#com_name").val();
		var com_telnumber=$("#com_telnumber").val();
		$.post('/airlineTickets/managercompany/modifyCompany',{cid:cid,inst_number:inst_number,com_name:com_name,com_telnumber:com_telnumber},function(data){
			if(data=='true'){
				$('#win_1').window('close');
				$.messager.alert('好消息','成功！');
				
				$('#dg').datagrid('load',{
					inst_number1: '',
					com_name1: '',
					com_telnumber1:'',
				
				});


			}else{
				$.messager.alert('警告','服务器异常！');
			}
			
		},'text');
	 
 }
 
 //查询机场
 
 
 function searchCompany(){
	 
		var inst_number1=$("#ff_2 input[name=inst_number1]").val();
		
		var com_name1=$("#ff_2 input[name=com_name1]").val();
		var com_telnumber1=$("#ff_2 input[name=com_telnumber1]").val();
		
			$('#dg').datagrid('load',{
				inst_number1: inst_number1,
				com_name1: com_name1,
				com_telnumber1:com_telnumber1
			});
		
 }
 
 
//表单验证

$.extend($.fn.validatebox.defaults.rules,{  
	
	inst_number: {
		  validator: function (value) {
		    var flag = true;
		    $.ajax({
		      type: "post",
		      async: false,
		      url: "/airlineTickets/managercompany/isHaveCompany?inst_number="+$("input[name='inst_number']").val()+"&com_name="+""+"&com_telnumber="+"",
		      success: function(data){//在验证函数里加载数据，加载过来后判断输入的值
		        var inst_number =data;
		        
		      	var old_number=$("input[name='inst_number']").val();
		      	
		       if(inst_number==old_number){
		    	   
		    	   
		    	   $.messager.alert('警告','该公司已存在！');
		    	   flag = false;
		           
		       }
		      }
		    });
		    if(!/^[A-Z]{2}\d{4}$/i.test(value)){
		    	
		    	return false;
		    }
		    return flag;
		  },
		  message: '公司编号应为两位大写英文加4位数字'
		},

    com_name: { 
                validator : function(value, param) {  
                    return /^[\u4e00-\u9fa5]{2,}$/i.test(value);  
                },   
                message : '输入正确的公司名称'  
            },           
    com_telnumber : {// 验证英语  
                validator : function(value) {  
                	return /^\d{11}$/i.test(value);  
                },  
                message : '请输入正确的电话'  
            },  
});  

		
		

</script>
</html>