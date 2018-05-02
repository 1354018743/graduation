<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询订单</title>
<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/icon.css">
<style type="text/css">
	#dg{
		background-color: #DEE0E1;
	}
</style>

</head>
<body>
	<script type="text/javascript" src="/airlineTickets/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/airlineTickets/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/airlineTickets/easyui/locale/easyui-lang-zh_CN.js"></script>
 
	
 
	<div style="width:1200px;height:500px;margin:auto;margin-top:50px;border:1px solid #000">
		<table id="dg"></table>  
	</div>
	<script type="text/javascript">
	//初始化时间
	function parseJSONDate(json) {
		var year = json.year+1900;
		var month = json.month+1;
		var date = json.date;
		return year+"-"+(month>10?month:("0"+month)+"-"+(date>10?date:("0"+date)));
	}
	//初始化数据表格
	$('#dg').datagrid({    
	    url:'/airlineTickets/passenger/searchOrder', 
		pagination:true,
		rownumbers:true,
	    columns:[[    
	    	{field:'',width:100,checkbox:true},    
	        {field:'insurance',title:'保险金额',width:100},
	        {field:'pre_state',title:'付款状况',width:100},    
	        {field:'realname',title:'真实姓名',width:100}, 
	        {field:'setouttime',title:'起飞时间',width:200,
	        	formatter: function(value,row,index){
					return parseJSONDate(value);
				}	
	        },
	        {field:'achieve',title:'到达时间',width:200,
	        	formatter: function(value,row,index){
					return parseJSONDate(value);
				}	
	        },
	        {field:'com_name',title:'航空公司',width:100}, 
	    ]]    
	});  

	
	</script>
</body>
</html>