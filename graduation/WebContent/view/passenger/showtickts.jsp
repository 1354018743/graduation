<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购票查询</title>
        <link rel="stylesheet" type="text/css" href="/airlineTickets/css/bootstrap.min.css" />
		<script type="text/javascript" src="/airlineTickets/js/jquery-1.11.0.min.js" charset="utf-8" ></script>
		<script type="text/javascript" src="/airlineTickets/js/bootstrap.min.js" charset="utf-8" ></script>
		<script type="text/javascript" src="/airlineTickets/easyui/jquery.min.js"></script>
	    <script type="text/javascript" src="/airlineTickets/easyui/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="/airlineTickets/easyui/locale/easyui-lang-zh_CN.js"></script>
	    <script type="text/javascript" src="/airlineTickets/js/bootstrap.min.js" charset="utf-8" ></script>
 <style type="css/text">
   .www{
   		position: relative;
   		margin-top: 400px;
   	}
 </style>

</head>
<body>
  <div class="container">
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
				            <li><a href="#"><img src="/airlineTickets/img/userLogout.jpg" /> 退出</a></li> 
				        </ul> 
				    </div> 
				</nav>
				<!--
                	图片
                -->
				<div class="col-md-12" style="height: 100px;">
					<img src="/airlineTickets/img/airline.jpg" style="height: 122px; width: 1170px; margin-top: -20px; margin-left: -16px">
				</div>
				<!--
                	机票信息栏
                -->
				<nav class="navbar navbar-default col-md-12" role="navigation" style="height: 100px;">
					<div class="container-fluid"> 
				        <div class="navbar-header"> 
				        	<form id="searchForm">
				        		<div class="form-group navbar-header" style="position: absolute; top: 30px;  left: 95px;">
				        			<input type="text" placeholder="起点" class="form-control" name="startplace" />
				        		</div>
				        		<div class="form-group navbar-header" style="position: absolute; top: 30px; left: 311px;">
						            <button class="btn" style="border-radius: 20px; color: #999999; background-color: #FFFFFF; border-color: #999999;">换</button>
						        </div>
				        		<div class="form-group navbar-header" style="position: absolute; top: 30px; left: 371px;">
						            <input type="text" placeholder="终点"  class="form-control" name="endplace"/>
						        </div>
				        		<div class="form-group navbar-header" style="position: absolute; top: 30px; left: 587px;">
						            <input  id="begin" type="text" placeholder="单程日期"  class="form-control easyui-datebox" name="danchengtime"/>
						        </div>
				        		<div class="form-group navbar-header" style="position: absolute; top: 30px; left: 803px;">
						            <input id="end" type="text" placeholder="往返日期"  class="form-control easyui-datebox" name="wanfantime"/>
						        </div>
				        		<div class="form-group navbar-header" style="position: absolute; top: 30px; left: 1019px;">
						            <button type="submit" class="btn btn-warning" onclick="searchTicket()">搜索</button>
						        </div>
				        	</form>
				        </div> 
				    </div> 
				</nav>
				<!--
                	前后日期
                -->
				<nav class="navbar navbar-default" role="navigation" style="height: 100px; width: 1170px; position: absolute; top: 272px;">
					<div class="container-fluid"> 
				        <div class="form-group navbar-header" style="position: absolute; left: -1px;">
						    <button class="btn"  style="height: 99px; color: #9""99999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;"><</button>
						</div>
						<div class="form-group navbar-header" style="position: absolute; left: 34px;">
						    <button class="btn"  style="width: 157px; height: 99px; color: #999999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;">前三天</button>
						</div>
						<div class="form-group navbar-header" style="position: absolute; left: 191px;">
						    <button class="btn"  style="width: 157px; height: 99px; color: #999999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;">前两天</button>
						</div>
						<div class="form-group navbar-header" style="position: absolute; left: 348px;">
						    <button class="btn"  style="width: 157px; height: 99px; color: #999999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;">前一天</button>
						</div>
						<div class="form-group navbar-header" style="position: absolute; left: 505px;">
						    <button class="btn"  style="width: 157px; height: 99px; color: #999999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;">当天</button>
						</div>
						<div class="form-group navbar-header" style="position: absolute; left: 662px;">
						    <button class="btn"  style="width: 157px; height: 99px; color: #999999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;">后一天</button>
						</div>
						<div class="form-group navbar-header" style="position: absolute; left: 819px;">
						    <button class="btn"  style="width: 157px; height: 99px; color: #999999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;">后两天</button>
						</div>
						<div class="form-group navbar-header" style="position: absolute; left: 976px;">
						    <button class="btn"  style="width: 157px; height: 99px; color: #999999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;">后三天</button>
						</div>
						<div class="form-group navbar-header" style="position: absolute; left: 1133px;">
						    <button class="btn"   style="height: 99px; color: #999999; background-color: #F8F8F8; border-color: #E7E7E7; font-size: larger;" ></button>
						</div>
				    </div> 
				</nav>
				<!--
                	筛选条件
                -->
                <nav class="navbar navbar-default" role="navigation" style="height: 40px; width: 1170px; position: absolute; top: 372px;">
					<div class="container-fluid"> 
				        <div class="form-group navbar-header" style="position: absolute; left: -1px;">
						    <div >
						        <ul class="nav navbar-nav">
						            <li class="dropdown">
						                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
						                    	起飞时间
						                    <b class="caret"></b>
						                </a>
						                <ul class="dropdown-menu">
						                	<form>
						                		<p>　<input type="checkbox" name="time_1" value="time_1">　00:00-10:00</input></p>
						                		<p>　<input type="checkbox" name="time_2" value="time_2">　10:00-14:00</input></p>
						                		<p>　<input type="checkbox" name="time_3" value="time_3">　14:00-19:00</input></p>
						                		<p>　<input type="checkbox" name="time_4" value="time_4">　19:00-24:00</input></p>
						                	</form>
						                </ul>
						            </li>
						        </ul>
						    </div>
						</div>
						<div class="form-group navbar-header" style="position: absolute; left: 99px;">
						    <div >
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
			</div>
		</div>
		 <!--引用easyui里的表格和树里面的datagrid，显示表格的第一列属性行-->
		 <!--加table的目的是为了后面动态的增加查询出来的行 和第一列属性行 -->
	     <table id="dg" class="www"></table>   
</body>
    
    <script type="text/javascript">
	  //格式化json日期对象
		function parseJSONDate(json){
		  alert(json);
			var year = json.year+1900;
			var month = json.month+1;
			var date = json.date;
			return year+"-"+(month>10?month:("0"+month))+"-"+(date>10?date:("0"+date));
		}
	   ////加载datagrid表格数据',  
       $('#dg').datagrid({    
	    url:'/airlineTickets/tickets/loadAllTickets', 
		pagination:true,
		rownumbers:true,
		 columns:[[    
		        {field:'cid',title:'公司编号',width:120,hidden:true,checkbox:true},
		        {field:'com_name',title:'公司名称',width:120,checkbox:true},
		        {field:'setouttime',title:'出发时间',width:120,align:'center'},    
		        {field:'achieve',title:'到达时间',width:120,align:'center'},
		        {field:'star_airportnumber',title:'出发机场编号',width:120,hidden:true,align:'center'}, 
		        {field:'starport_name',title:'出发机场',width:120,align:'center'}, 
		        {field:'end_airportnumber',title:'到达机场编号',width:120,hidden:true,align:'center'},
		        {field:'endport_name',title:'到达机场',width:200,align:'center'},    
		        {field:'price_2',title:'经济仓票价',width:160,align:'center'},
		        {field:'price_1',title:'商务仓票价',width:160,align:'center'},	
		        {field:'pricecount_2',title:'经济仓票数',width:160,align:'center'},
		        {field:'pricecount_1',title:'商务仓票数',width:160,align:'center'}  
	        ]]    
	       
	});

	   
    
    	//查询票function
		function searchTicket(){
			//获取查询参数
			var startplace =$('#searchForm input[name="startplace"]').val();
			var endplace =$('#searchForm input[name="endplace"]').val();
			var danchengtime =$('#begin').combo('getValue');
			var wanfantime =$('#end').combo('getValue');
		    alert(startplace);
			//加载数据
			$('#result').datagrid(
		            'load',{
			 	startplace:startplace,
				endplace:endplace,
				danchengtime:danchengtime,
				wanfantime:wanfantime
			});
			
		}
		
    </script>
</html>