<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>航班查询</title>

	<link rel="stylesheet" type="text/css" href="/airlineTickets/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="/airlineTickets/easyui/themes/icon.css">


</head>
<body>
	<script type="text/javascript" src="/airlineTickets/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="/airlineTickets/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/airlineTickets/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="/airlineTickets/js/bootstrap.min.js" charset="utf-8" ></script>
	<div class="container" style="margin-top:50px;">
		<div class="row">
			<!--
               	顶部状态栏
               -->
			<nav class="navbar navbar-default col-md-12" role="navigation"> 
			    <div class="container-fluid"> 
			        <div class="navbar-header"> 
			            <a class="navbar-brand" href="#">航空购票网</a> 
			        </div> 
			        <ul class="nav navbar-nav navbar-right"> 
			            <li><a href="#"><img src="/airlineTickets/img/userLog.jpg" /> 用户名</a></li> 
			            <li><a href="/airlineTickets/view/passenger/login.jsp"><img src="/airlineTickets/img/userLogout.jpg" /> 退出</a></li> 
			        </ul> 
			    </div> 
			</nav>
			<!--
               	图片
               -->
			<div class="col-md-12" style="height: 100px;">
				  <img src="/airlineTickets/img/main.jpg" style="height: 122px; width: 1170px; margin-top: -20px; margin-left: -16px;"/> 
				
			</div>
			<!--
               	机票信息栏
               -->
			<nav class="navbar navbar-default col-md-12" role="navigation" style="height: 100px;">
				<div class="container-fluid"> 
			        <div class="navbar-header"> 
			        	<form>
			        		<div class="form-group navbar-header" style="position: absolute; top: 30px;  left: 95px;">
			        			<input id="cc" type="text" placeholder="起点" class="form-control" />
			        		</div>
			        		<div class="form-group navbar-header" style="position: absolute; top: 30px; left: 311px;">
					            <button id="btn" class="btn" style="border-radius: 20px; color: #999999; background-color: #FFFFFF; border-color: #999999;">到</button>
					        </div>
			        		<div class="form-group navbar-header" style="position: absolute; top: 30px; left: 371px;">
					            <input type="text" placeholder="终点"  class="form-control"/>
					        </div>
			        		<div class="form-group navbar-header" style="position: absolute; top: 30px; left: 587px;">
					        	起飞时间：<input  id="dd"  type= "text" placeholder="起飞时间" class= "easyui-datebox"autocomplete="off" style="height:34px;" value="date"></input>   
					        </div>
			        		
			        		<div class="form-group navbar-header" style="position: absolute; top: 30px; left: 1019px;">
					            <button class="btn btn-warning" onclick="searchFlight()"><a target="displayIframe">搜索</a></button>
					        </div>
			        	</form>
			        </div> 
			    </div> 
			</nav>
			
			<!--
               	筛选条件
               -->
               <nav class="navbar navbar-default" role="navigation" style="height: 40px; width: 1170px; position: absolute; top: 320px;">
				<div class="container-fluid"> 
			       
					<div class="form-group navbar-header" style="position: absolute; left: 80px;">
					   
				        <ul class="nav navbar-nav">
				            <li class="dropdown">
				                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
				                    	航空公司
				                    <b class="caret"></b>
				                </a>
				                <ul class="dropdown-menu">
				                	<form>
				                		<p>　<input type="checkbox" name="airplane_1" value="airplane_1">　航空公司1</input></p>
				                		<p>　<input type="checkbox" name="airplane_2" value="airplane_2">　航空公司2</input></p>
				                		<p>　<input type="checkbox" name="airplane_3" value="airplane_3">　航空公司3</input></p>
				                		<p>　<input type="checkbox" name="airplane_4" value="airplane_4">　航空公司4</input></p>
				                	</form>
				                </ul>
				            </li>
				        </ul>
				    
					</div>
					<div class="form-group navbar-header" style="position: absolute; left: 199px;">
					    <div >
					        <ul class="nav navbar-nav">
					            <li class="dropdown">
					                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
					                    	舱位
					                    <b class="caret"></b>
					                </a>
					                <ul class="dropdown-menu">
					                	<form>
					                		<p>　<input type="checkbox" name="level_1" value="level_1">　商务舱</input></p>
					                		<p>　<input type="checkbox" name="level_2" value="level_2">　经济舱</input></p>
					                	</form>
					                </ul>
					            </li>
					        </ul>
					    </div>
					</div>
					<div class="form-group navbar-header" style="position: absolute; top:  -1px; left: 966px;">
					    <button class="btn"  style="height: 50px; color: #999999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;">起飞时间↑</button>
					</div>
					<div class="form-group navbar-header" style="position: absolute; top:  -1px; left: 1068px;">
					    <button class="btn"  style="height: 50px; color: #999999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;">价格排序↑</button>
					</div>
			    </div> 
			</nav>
			<div style="height:300px; width:1170px;border:1px solid #fff;position:absolute;top:380px;border:1px solid #ccc; ">
					<table id="dg"></table>  
			</div>
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
	    url:'/airlineTickets/passenger/searchFlight', 
		pagination:true,
		rownumbers:true,
	    columns:[[    
	        {field:'com_name',title:'航空公司',width:100,align:'center',}, 
	        {field:'setouttime',title:'起飞时间',width:200,align:'center',
	        	formatter: function(value,row,index){
					return parseJSONDate(value);
				}	
	        },
	        {field:'achieve',title:'到达时间',width:200,align:'center',
	        	formatter: function(value,row,index){
					return parseJSONDate(value);
				}	
	        },
	        {field:'port_name',title:'起点',width:100,align:'center',}, 
	        {field:'port_name1',title:'终点',width:100,align:'center',}, 
	    ]]    
	});

		
	</script>
</body>
</html>