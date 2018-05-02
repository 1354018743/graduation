<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/metro/easyui.css"> 
	<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/icon.css">   
	<script type="text/javascript" src="/airlineTickets/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="/airlineTickets/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/airlineTickets/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
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
<body>
	<div id="left">
	<b>你可以根据以下条件查找：</b><br/>
	<form id="ff" method="post">   
			    <div>   
			        <label for="realname">真实姓名：</label>   
			        <input  class="easyui-validatebox" type="text" name="realname" data-options="" />   
			    </div>   
			    <div>   
			        <label for="cardid">身份证号：</label>   
			        <input class="easyui-validatebox" type="text" name="cardid" data-options="" />   
			    </div>   
 				<div>   
			        <label for="tel_number">电话号码：</label>   
			        <input class="easyui-validatebox" type="text" name="tel_number" data-options="" />   
			    </div> 
			    <div>   
			        <label for="email">电子邮箱：</label>   
			        <input class="easyui-validatebox" type="text" name="email" data-options="" />   
			    </div> 
			    <a id="btn" href="javascript:searchPassenger()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-top:20px">开始查找</a>
			</form> 
</div>
<div id="content">

	<table id="dg"></table>
</div>
</body>
<script type="text/javascript">
$(function(){
	
	$('#dg').datagrid('load',{
		realname: '',
		cardid: '',
		tel_number:'',
		email:'',
	});
});
$('#dg').datagrid({    
    url:'/airlineTickets/managerpassenger/loadPassenger', 
    pagination:true,
    rownumbers:true,
    height:400,
    width:890,
    toolbar: [{
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
			        
			    	var pids=[];
					for(var i=0;i<rows.length;i++){
						pids[i]=rows[i].pid
						
					}
					
					var pidStr=pids.join(",");
					
					$.post('/airlineTickets/managerpassenger/deletePassenger',{pids:pidStr},function(data){
						if(data=='true'){
							
							$.messager.alert('好消息','成功！');
							$('#dg').datagrid('load',{
								realname: '',
								cardid: '',
								tel_number:'',
								email:'',
							});

	  
						}else{
							$.messager.alert('警告','服务器异常！');
						}
						
					},'text');
			    	
			    }    
			});  
			
			
			
		
		}
	}],

    columns:[[ 
    	{field:'',title:'',width:100,checkbox:true},
        {field:'pid',title:'编号',width:42}, 
        {field:'realname',title:'真实姓名',width:70}, 
        {field:'sex',title:'性别',width:70,
        	formatter: function(value,row,index){
    			if (row.sex==1){
    				return '男';
    			} else {
    				return '女';
    			}
    		}
        },
        {field:'cardid',title:'身份证号',width:200},    
        {field:'tel_number',title:'电话号码',width:200}, 
        {field:'email',title:'电子邮箱',width:200}, 
        
    ]]    
});

function searchPassenger(){
	
	var realname=$("#ff input[name='realname']").val();
	var cardid=$("#ff input[name='cardid']").val();
	var tel_number=$("#ff input[name='tel_number']").val();
	var email=$("#ff input[name='email']").val();
	$('#dg').datagrid('load', {    
		realname: realname,    
		cardid: cardid,
		tel_number:tel_number,
		email:email,
	});  
	
}
	</script>
</html>