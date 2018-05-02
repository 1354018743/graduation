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
			<input type="hidden" value="${sessionScope.airCompany.cid}" name="cid">
			出发机场：<select id="port_name_2" name="port_name" >
				<option value="-1">---请选择---</option>
			</select>
			到达机场：<select id="end_port_name_2" name="end_port_name">
				<option value="-1">---请选择---</option>
			</select>
			出发时间：<input class="easyui-datebox" name="starttime"  style="width:180px;">
			到：<input class="easyui-datebox" name="endtime" style="width:180px"><br>
			商务舱机票价格：<input type="text" name="startprice_1" class="easyui-validatebox" placeholder="请输入起始价格">
			至<input type="text" name="endprice_1" class="easyui-validatebox" placeholder="请输入截止价格">
			经济舱机票价格：<input type="text" name="startprice_2" class="easyui-validatebox" placeholder="请输入起始价格">
			至<input type="text" name="endprice_2" class="easyui-validatebox" placeholder="请输入截止价格"><br>
			航班编号：<input type="text" name="fid" class="easyui-validatebox" placeholder="请输入航班编号">
			<a id="btn" href="javascript:searchDescount()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-left:10px;">查找</a>  
		</form>
	</div>

	<table id="dg" style="height:400px; width:100%"></table> 
	<div id="add_win">
		<div id="addForm">
			<form id="addform" action="">
				航班编号：<select id="addformselect" name="fid"></select><br>
				商务舱折扣：<input type="text" name="descount_1" class="easyui-validatebox" placeholder="请输入商务舱折扣"><br>
				经济舱折扣：<input type="text" name="descount_2" class="easyui-validatebox" placeholder="请输入经济舱折扣"><br>
				<a id="btn" href="javascript:addDescount()" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="margin-left:220px; margin-top:18px;">增加</a>  
			</form>
		</div>
	</div>
	
	<div id="modify_win">
		<div id="modifyForm">
			<form id="modifyform" action="">
				&nbsp&nbsp航班编号：<input type="text" name="fid" class="easyui-validatebox" readonly="readonly"><br>
				商务舱折扣：<input type="text" name="descount_1" class="easyui-validatebox" ><br>
				经济舱折扣：<input type="text" name="descount_2" class="easyui-validatebox" ><br>
				<a id="btn" href="javascript:modifyDescount()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" style="margin-left:220px;">修改</a>  
			</form>
		</div>
	</div>
	 
	<script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="<%=path%>/easyui/jquery.easyui.min.js"></script>  
	<script src="<%=path%>/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
		
		//初始加载机场地点
		$(function(){
			$.get("/airlineTickets/airportMessage/loadAirportMessage",function(data){
				$('#port_name_2 option:not(:first)').remove();
				$('#end_port_name_2 option:not(:first)').remove();
				for(var i=0;i<data.length;i++){
					$('#port_name_2').append("<option value='"+data[i].aid+"'>"+data[i].port_name+"</option");
					$('#end_port_name_2').append("<option value='"+data[i].aid+"'>"+data[i].port_name+"</option");
				}
			},'json');
		});
		
		//查找折扣信息
	  	function searchDescount(){
	  		var cid=$('#searchform input[name=cid]').val();
			var port_name=$('#searchform select[name=port_name]').val();
			var end_port_name=$('#searchform select[name=end_port_name]').val();
			var starttime=$('#searchform input[name=starttime]').val();
			var endtime=$('#searchform input[name=endtime]').val();
			var startprice_1=$('#searchform input[name=startprice_1]').val();
			var endprice_1=$('#searchform input[name=endprice_1]').val();
			var startprice_2=$('#searchform input[name=startprice_2]').val();
			var endprice_2=$('#searchform input[name=endprice_2]').val();
			var fid=$('#searchform input[name=fid]').val();
	  		$('#dg').datagrid({    
			    url:'/airlineTickets/AirlineDescount/searchDescount?cid='+cid+'&port_name='+port_name+'&end_port_name='+end_port_name+'&starttime='+starttime+'&endtime='+endtime+'&startprice_1='+startprice_1+'&endprice_1='+endprice_1+'&startprice_2='+startprice_2+'&endprice_2='+endprice_2+'&fid='+fid,
			    columns:[[  
			    	{field:'',title:'',width:100,checkbox:true},
			    	{field:'fid',title:'航班编号',align:'center'},
			        {field:'setouttime',title:'出发时间',
			        	formatter: function(value,row,index){
							return parsJSONDate(value);
						},
						align:'center'
			        },    
			        {field:'achieve',title:'到达时间',
			        	formatter: function(value,row,index){
							return parsJSONDate(value);
						},
						align:'center'
			        },    
			        {field:'port_name',title:'出发机场',width:90,align:'center'}, 
			        {field:'end_port_name',title:'到达机场',width:90,align:'center'},
			        {field:'genre_1',title:'座位等级',width:70,align:'center'}, 
			        {field:'price_1',title:'机票原价',width:70,align:'center'}, 
			        {field:'descount_1',title:'机票折扣',width:70,align:'center'}, 
			        {field:'genre_2',title:'座位等级',width:70,align:'center'}, 
			        {field:'price_2',title:'机票原价',width:70,align:'center'}, 
			        {field:'descount_2',title:'机票折扣',width:70,align:'center'} ,
			    ]]    
			});
			$('#searchform select[name=port_name]').val(-1);
			$('#searchform select[name=end_port_name]').val(-1);
			$('#searchform input[name=startprice_1]').val("");
			$('#searchform input[name=endprice_1]').val("");
			$('#searchform input[name=startprice_2]').val("");
			$('#searchform input[name=endprice_2]').val("");
			$('#searchform input[name=fid]').val("");
			$('#searchform input[name=starttime]').datetimebox('setValue',""); 
    		$('#searchform input[name=endtime]').datetimebox('setValue',"");
	  	}
		
		//修改优惠政策
		function modifyDescount(){
			$.post("/airlineTickets/AirlineDescount/modifyDescount",$('#modifyform').serialize(),function(data){
				if(data=="true"){
					$('#modify_win').window('close');
					$.messager.alert('恭喜','修改成功！'); 
					$('#dg').datagrid('load',{});
				}else{
					$('#modify_win').window('close');
					$.messager.alert('警告','服务器异常，请稍后再试！'); 
				}
			},'text');
			$('#dg').datagrid('clearSelections');
		}
		
		//增加优惠政策
		function addDescount(){
			$.post("/airlineTickets/AirlineDescount/addDescount",$('#addform').serialize(),function(data){
				if(data=="true"){
					$('#add_win').window('close');
					$.messager.alert('恭喜','增加成功！'); 
					$('#dg').datagrid('load',{});
				}else{
					$('#add_win').window('close');
					$.messager.alert('警告','服务器异常，请稍后再试！'); 
				}
				$('#addform input[name=descount_1]').val("");
				$('#addform input[name=descount_2]').val("");
			},'text');
		}
		
		//格式化日期
		function parsJSONDate(json){
			var year=json.year+1900;
			var month=json.month+1;
			var date=json.date;
			var hour=json.hours;
			var minute=json.minutes;
			var second=json.seconds;
			return year+"-"+(month>10?month:("0"+month))+"-"+(date>10?date:("0"+date))+" "+(hour>10?hour:("0"+hour))+":"+(minute>10?minute:("0"+minute));
		}
		//初始化增加优惠政策窗口
		$('#add_win').window({    
		    width:500,    
		    height:300,    
		    modal:true,
		    closed:true,
		    iconCls:'icon-add',
		    title:'增加优惠政策'
		});
		
		//初始化修改优惠政策窗口
		$('#modify_win').window({    
		    title:"修改优惠政策",
		    width:400,
		    height:270, 
		    iconCls:'icon-edit',
		    resizable:true,
		    modal:true,
		    closed:true
		});
	
		var cid=1;
		//初始化表格数据
		$('#dg').datagrid({    
		    url:'/airlineTickets/AirlineDescount/loadDescount?cid='+'${sessionScope.airCompany.cid}',
		    pagination:true,
		    singleSelect:true,
		    toolbar: [{
				iconCls: 'icon-add',
				text:'增加优惠政策',
				handler: function(){
					//动态加载机场选项
					$.get("/airlineTickets/loadFlightId/loadFlightId",{cid:'${sessionScope.airCompany.cid}'},function(data){
						$('#addformselect option').remove();
						if(!data.length){
							$.messager.alert('警告','没有需要增加的优惠！');
							return;
						}else{
							for(var i=0;i<data.length;i++){
								$('#addformselect').append("<option value='"+data[i].fid+"'>"+data[i].fid+"</option");
								$('#add_win').window('open');
							}
						}
					},'json');
					}
			},'-',{
				iconCls: 'icon-edit',
				text:'修改优惠政策',
				handler: function(){
					var row=$('#dg').datagrid('getSelected');
					if(!row){
		    			$.messager.alert('警告','请选择要修改的优惠政策！');  
		    			return;
		    		}
					$('#modifyform input[name=fid]').val(row.fid);
					$('#modifyform input[name=descount_1]').val(row.descount_1);
					$('#modifyform input[name=descount_2]').val(row.descount_2);
		    		$('#modify_win').window('open');
					}
			
			}],
		    columns:[[  
		    	{field:'',title:'',width:100,checkbox:true},
		    	{field:'fid',title:'航班编号',align:'center'},
    
		        {field:'setouttime',title:'出发时间',
		        	formatter: function(value,row,index){
						return parsJSONDate(value);
					},
					align:'center'
		        },    
		        {field:'achieve',title:'到达时间',
		        	formatter: function(value,row,index){
						return parsJSONDate(value);
					},
					align:'center'
		        },    
		        {field:'port_name',title:'出发机场',width:90,align:'center'}, 
		        {field:'end_port_name',title:'到达机场',width:90,align:'center'},
		        {field:'genre_1',title:'座位等级',width:70,align:'center'}, 
		        {field:'price_1',title:'机票原价',width:70,align:'center'}, 
		        {field:'descount_1',title:'机票折扣',width:70,align:'center'}, 
		        {field:'genre_2',title:'座位等级',width:70,align:'center'}, 
		        {field:'price_2',title:'机票原价',width:70,align:'center'}, 
		        {field:'descount_2',title:'机票折扣',width:70,align:'center'} ,
		        
		    ]]    
		});  

	
	</script>

</body>
</html>