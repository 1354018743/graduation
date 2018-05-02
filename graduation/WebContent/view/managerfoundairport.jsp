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
			        <label for="port_number">机场编号：</label>   
			        <input  class="easyui-validatebox" type="text" name="port_number1" data-options="" />   
			    </div>   
			    <div>   
			        <label for="port_name">机场名称：</label>   
			        <input class="easyui-validatebox" type="text" name="port_name1" data-options="" />   
			    </div>   
 				<div>   
			        <label for="city">所在城市：</label>   
			        <input class="easyui-validatebox" type="text" name="city1" data-options="" />   
			    </div> 
			    <a id="btn" href="javascript:searchAirport()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-top:20px">开始查找</a>
			</form> 
</div>
<div id="content">

	<table id="dg"></table>
	<div id="win">
	
	<form id="ff_1" method="post">   
			    <div>   
			        <label for="port_number">机场编号：</label>   
			        <input class="easyui-validatebox" type="text" name="port_number"   data-options="validType:'port_number'"/>   
			    </div>   
			    <div>   
			        <label for="port_name">机场名称：</label>   
			        <input class="easyui-validatebox" type="text" name="port_name"  data-options="validType:'port_name'"/>   
			    </div>   
 				<div>   
			        <label for="city">所在城市：</label>   
			        <input class="easyui-validatebox" type="text" name="city"  data-options="validType:'city'"/>   
			    </div> 
			    <a id="btn" href="javascript:addAirport()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="margin-top:20px">确认增加</a>
			</form> 
	
	</div> 
	<div id="win_1">
	
	<form id="ff" method="post">   
				<div>   
			        <label for="aid">编&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp号：</label>   
			        <input id="aid" class="easyui-validatebox" type="text" name="aid" readonly= "readonly" />   
			    </div>  
			    <div>   
			        <label for="port_number">机场编号：</label>   
			        <input id="port_number" class="easyui-validatebox" type="text" name="port_number"data-options="validType:'port_number'"  />   
			    </div>   
			    <div>   
			        <label for="port_name">机场名称：</label>   
			        <input id="port_name" class="easyui-validatebox" type="text" name="port_name" data-options="validType:'port_name'"  />   
			    </div>   
 				<div>   
			        <label for="city">所在城市：</label>   
			        <input id="city" class="easyui-validatebox" type="text" name="city" data-options="validType:'city'" />   
			    </div> 
			    <a id="btn" href="javascript:modifyAirport()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="margin-top:20px">确认修改</a>
			</form> 
	
	</div>
	</div> 
</body>
	<script type="text/javascript">
	
//预加载表格显示数据


	$(function(){
		
		$('#dg').datagrid('load',{
			port_number: '',
			port_name: '',
			city:'',
		});
	});
	$('#dg').datagrid({    
	    url:'/airlineTickets/managerairport/loadAirport',
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
					
					$.messager.alert('警告','请选择要删除的机场机场'); 
					return;
				}
				$.messager.confirm('确认','您确认想要删除吗？',function(r){    
				    if (r){    
				        
				    	var aids=[];
						for(var i=0;i<rows.length;i++){
							aids[i]=rows[i].aid
							
						}
						
						var aidStr=aids.join(",");
						
						$.post('/airlineTickets/managerairport/deleteAirport',{aids:aidStr},function(data){
							if(data=='true'){
								
								$.messager.alert('好消息','成功！');
								$('#dg').datagrid('load',{
									
										port_number: '',
										port_name: '',
										city:'',
									
								
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
					
					$.messager.alert('警告','请选择要修改的机场'); 
					return;
				}
				$('#win_1').window('open');
				var aid= row.aid;
				$.post('/airlineTickets/managerairport/loadAirportByAid',{aid:aid},function(data){	

					$("#aid").val(data[0].aid);
					$("#port_number").val(data[0].port_number);
					$("#port_name").val(data[0].port_name);
					$("#city").val(data[0].city);
				},'json');
			}
		}],

	    columns:[[ 
	    	{field:'',title:'',width:100,checkbox:true},
	        {field:'aid',title:'编号',width:200},    
	        {field:'port_number',title:'机场编号',width:200},    
	        {field:'port_name',title:'机场名称',width:200}, 
	        {field:'city',title:'所在城市',width:200},   
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
	    title:"添加飞机场",
	}); 
	
	$('#win_1').window({    
	    width:400,    
	    height:300,    
	    modal:true,  
	    closed:true,
	    minimizable:false,
	    maximizable:false,
	    collapsible:false,
	    title:"修改飞机场",
	}); 
	//添加机场
	function addAirport(){
		var port_number=$("input[name='port_number']").val();
		var port_name=$("input[name='port_name']").val();
		var city=$("input[name='city']").val();
		$('#ff_1').form('clear');
		$('#ff_1').form('submit',{
			onSubmit:function(){
				$.post('/airlineTickets/managerairport/addAirport',{port_number:port_number,port_name:port_name,city:city},function(data){
					if(data=='true'){
						
						$('#win').window('close');
						$.messager.alert('好消息','成功！');
						
						$('#dg').datagrid('load',{
							port_number: '',
							port_name: '',
							city:'',
						});
					}else{
						$.messager.alert('警告','服务器异常！');
					}
					
				},'text');
			}
		});
		
	}
	
	//修改机场
	
 function modifyAirport(){
	 	
	    var aid=$("#aid").val();
	    var port_number=$("#port_number").val();
		var port_name=$("#port_name").val();
		var city=$("#city").val();
		$.post('/airlineTickets/managerairport/modifyAirport',{aid:aid,port_number:port_number,port_name:port_name,city:city},function(data){
			if(data=='true'){
				$('#win_1').window('close');
				$.messager.alert('好消息','成功！');
				
				$('#dg').datagrid('load',{
					port_number: '',
					port_name: '',
					city:'',
				
				});


			}else{
				$.messager.alert('警告','服务器异常！');
			}
			
		},'text');
	 
 }
 
 //查询机场
 
 
 function searchAirport(){
	 
		var port_number=$("input[name='port_number1']").val();
		var port_name=$("input[name='port_name1']").val();
		var city=$("input[name='city1']").val();
		
			$('#dg').datagrid('load',{
				port_number: port_number,
				port_name: port_name,
				city:city
			});
		
 }
 
 
//表单验证

$.extend($.fn.validatebox.defaults.rules,{  
	
	port_number: {
		  validator: function (value) {
		    var flag = true;
		    $.ajax({
		      type: "post",
		      async: false,
		      url: "/airlineTickets/managerairport/isHaveAirport?port_number="+$("input[name='port_number']").val()+"&port_name="+""+"&city="+"",
		      success: function(data){//在验证函数里加载数据，加载过来后判断输入的值
		        var port_number =data;
		        
		      	var old_number=$("input[name='port_number']").val();
		      	
		       if(port_number==old_number){
		    	   
		    	   flag = false;
		           
		       }
		      }
		    });
		    if(!/^[A-Z]{2}\d{4}$/i.test(value)){
		    	
		    	return false;
		    }
		    return flag;
		  },
		  message: '机场编号已有或者不是两位大写英文加4位数字'
		},

    port_name: { 
                validator : function(value, param) {  
                    return /^[\u4e00-\u9fa5]{2,}$/i.test(value);  
                },   
                message : '输入正确的机场名称'  
            },           
     city : {// 验证英语  
                validator : function(value) {  
                	return /^[\u4e00-\u9fa5]{2,}$/i.test(value);  
                },  
                message : '请输入正确城市'  
            },  
});  

		
		

</script>
</html>