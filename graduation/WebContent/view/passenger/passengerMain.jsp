<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎用户使用火箭航空网上购票系统</title>
<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/icon.css">
<style type="text/css">

	ul{
		list-style:none;
	}
	#southUL1{
		margin-left:300px;
		width:100px;
		margin-top:-47px;
	}
	#southUL2{
		margin-left:900px;
		width:200px;
		margin-top:-47px;
	}
	#southUL1>li:hover{
		cursor: pointer;
		background-color: #CCE3F5;
	}
	label{
		margin-right:20px;
	}
	#westUL1{
		line-height:30px;
		font-size:large;
		font-family:monospace;
		cursor: pointer;
		padding-left: 0px;
	}
	#westUL1 li{
		height:30px;
		line-height: 30px;
		margin-bottom: 20px;
		text-align: center;
	}
	#westUL1 li:hover {
		background-color: #E0ECFF;
		color:red;
	}
	.regionUL1 li{
		list-style:disc;
		margin-bottom: 10px;
		font-size:small;
	}
	.regionUL1>li:hover {
		background-color: #E0ECFF;
		cursor: pointer;
		color:red;
}
</style>
</head>
<body class="easyui-layout">   
	
	<script type="text/javascript" src="/airlineTickets/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/airlineTickets/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/airlineTickets/easyui/locale/easyui-lang-zh_CN.js"></script>

  
    <div data-options="region:'north'" style="height:158px">
		<img src="/airlineTickets/img/main.jpg" style="height:100%;width:100%">
		<h1 style="position:relative;text-align: center;margin-top:-120px;font-size:xx-large;"><strong>火箭航空网上购票系统</strong></h1>
    	<h6><label style="position:relative;margin-left:200px;color:red;margin-top:-70px;font-size:small;">火箭航空网上购票</label><label style="color:#A8A7FD;margin-top:-70px;font-size:small;">是目前国内新兴的热门网上购票系统，截至目前，没有授权于其他网站开发类似服务内容，敬请广大用户注意<label></h6>
    </div>   
    <div data-options="region:'south',title:'版权所有'" style="height:100px;">
    	<img src="/airlineTickets/img/logo.jpg" style="height:40px;width:60px;margin-left:850px;margin-top:15px;">
    	<ul id="southUL1">
    		<li>站长电话：110</li>
    		<li>投诉建议</li>
    		<li>常见问题</li>
    	</ul>
    	<ul id="southUL2">
    		<li>版权所有&nbsp&copy;&nbsp我们是来自宇宙的火箭队</li>
    		<li>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp京ICP备15003716号-3</li>
    	</ul>
    </div>   
       
    <div data-options="region:'west',title:'菜单'" style="width:200px;">
	    <div id="aa" class="easyui-accordion" title="" data-options="fit:true">  
		        <ul id="westUL1">
			        <img src="/airlineTickets/img/logo.jpg" style="height:50px;width:50px;margin-left:75px;margin-bottom: 20px;">
		    		<li>个人信息修改</li>
		    		<li><a href="/airlineTickets/view/passenger/searchFlight.jsp">查询航班</li>
		    		<li><a href="/airlineTickets/view/passenger/showtickets.jsp">购买机票</li>
		    		<li><a href="/airlineTickets/view/passenger/searchOrder.jsp">查询订单</a></li>
		    		<li>退订机票</li>
		    		<li>历史购票</li>
		    		<li><a href="/airlineTickets/view/passenger/login.jsp">退出登陆</li>
	   			</ul>	
		    </div> 
		</div> 
    </div>   
    <div data-options="region:'center',title:'站内热点'" style="margin-left:200px;margin-top:150px;">
    	<div style="width:600px;border:1px solid #bbb;float:left;height:300px;">
    	<h2 style="color:red;margin-bottom:20px;">最新动态</h2>
 			<ul class="regionUL1">
 				<li>公告</li>
 				<li>关于调整互联网、电话订票起始时间的公告</li>
 				<li>关于2017年十一国庆、中秋期间增开部分旅客列车的公告（1）</li>
 				<li>关于2017年十一国庆、中秋期间增开部分旅客列车的公告（2）</li>
 				<li>政府出台相关票价信息</li>
 				<li>临时关闭重庆至北京的航班公告</li>
 				<li>受大风影响临时调整部分航班的公告</li>
 				<li>关于新开航线的公告</li>
 			</ul>
    	</div>
    	<div style="width:730px;border:1px solid #bbb;float:left;height:300px;">
    		<h2 style="color:red;">余票信息</h2>
    		<table id="dg" style="height:226px"></table>  
    	</div>
	</div>  

<script type="text/javascript">

//初始化数据表格
function parseJSONDate(json) {
var year = json.year+1900;
var month = json.month+1;
var date = json.date;
return year+"-"+(month>10?month:("0"+month)+"-"+(date>10?date:("0"+date)));
}
$('#dg').datagrid({    
    url:'/airlineTickets/tickets/loadAllTickets', 
	pagination:true,
	rownumbers:true,
	 columns:[[    
	        {field:'com_name',title:'公司名称',width:120,checkbox:true},
	        {field:'setouttime',title:'出发时间',width:120,align:'center'},    
	        {field:'achieve',title:'到达时间',width:120,align:'center'},
	        {field:'starport_name',title:'出发机场',width:120,align:'center'}, 
	        {field:'endport_name',title:'到达机场',width:200,align:'center'},    
	        {field:'price_2',title:'经济仓票价',width:160,align:'center'},
	        {field:'price_1',title:'商务仓票价',width:160,align:'center'},	
	        {field:'pricecount_2',title:'经济仓票数',width:160,align:'center'},
	        {field:'pricecount_1',title:'商务仓票数',width:160,align:'center'}  
        ]]    
       
});

   


	
	
</script>
</body>
</html>