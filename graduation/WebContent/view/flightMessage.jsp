<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>航班信息子页面</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/metro/easyui.css">   
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/icon.css">  
<style type="text/css">
	#addForm{
		width:250px;
		height:300px;
		margin:auto;
	}
	#addForm input{
		margin:5px;
	}
	#addForm select{
		margin:5px;
	}
	#sureDelete{
		width:300px;
		height:50px;
		font-size:18px;
		margin:auto;
		text-align:center;
		line-height:130px;
	}
	#bb{
		width:300px;
		height:50px;
		font-size:18px;
		margin:auto;
		text-align:center;
		line-height:130px;
		
	}
	#bb a{
		margin:20px;
	}
	#modifyForm{
		width:250px;
		height:300px;
		margin:auto;
	}
	#modifyForm input{
		margin:5px;
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
				飞机编号：<input type="text" name="air_number" class="easyui-validatebox" placeholder="请输入飞机编号">
				<a id="btn" href="javascript:searchFlightMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-left:10px;">查找</a>  
			</form>
	</div>
	<table id="dg" style="height:350px; width:100%"></table> 
	<div id="add_win">
		<div id="addForm">
			<form id="addform" action="">
				<input type="hidden" value="${sessionScope.airCompany.cid}" name="cid">
				飞机编号：<input type="text" name="air_number" class="easyui-validatebox" placeholder="请输入飞机号"><br>
				起飞时间：<input class="easyui-datetimebox" name="setouttime" data-options="required:true,showSeconds:false" style="width:170px;"><br>
				到达时间：<input class="easyui-datetimebox" name="achieve" data-options="required:true,showSeconds:false" style="width:170px"><br>
				起飞机场：<select id="port_name" name="port_name" ></select><br>
				到达机场：<select id="end_port_name" name="end_port_name"></select><br>
				座位等级：<input type="text" name="genre_1" class="easyui-validatebox" value="商务舱" readonly="readonly"><br>
				机票价格：<input type="text" name="price_1" class="easyui-validatebox" placeholder="请输入价格"><br>
				机票总数：<input type="text" name="pricecount_1" class="easyui-validatebox" placeholder="请输入总票数"><br>
				座位等级：<input type="text" name="genre_2" class="easyui-validatebox" value="经济舱" readonly="readonly"><br>
				机票价格：<input type="text" name="price_2" class="easyui-validatebox" placeholder="请输入价格"><br>
				机票总数：<input type="text" name="pricecount_2" class="easyui-validatebox" placeholder="请输入总票数"><br>
				<a id="btn" href="javascript:addFlightMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="margin-left:180px;">增加</a>  
			</form>
		</div>
	</div>
	<div id="delete_win">
		<div id="sureDelete">
		确定删除你所选择的航班信息吗？
		</div>
		<div id="bb">
			<a href="javascript:deleteFlightMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
			<a href="javascript:cancledeleteFlightMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-clear'">取消</a>
		</div>
	</div>
	 <div id="modify_win">
		<div id="modifyForm">
			<form id="modifyform" action="">
				航班编号：<input id="fid" type="text" name="fid" class="easyui-validatebox"  readonly="readonly"><br>
				飞机编号：<input id="air_number" type="text" name="air_number" class="easyui-validatebox" ><br>
				起飞时间：<input id="setouttime" class="easyui-datetimebox" name="setouttime" data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:170px;"><br>
				到达时间：<input id="achieve" class="easyui-datetimebox" name="achieve" data-options="required:true,showSeconds:false"  style="width:170px"><br>
				起飞机场：<input id="port_name_1" type="text" name="port_name" class="easyui-validatebox"  readonly="readonly"><br>
				起飞机场：<input id="end_port_name_1" type="text" name="end_port_name" class="easyui-validatebox"  readonly="readonly"><br>
				座位等级：<input id="genre_1" type="text" name="genre_1" class="easyui-validatebox" value="商务舱" readonly="readonly"><br>
				机票价格：<input id="price_1" type="text" name="price_1" class="easyui-validatebox" placeholder="请输入价格"><br>
				机票总数：<input id="pricecount_1" type="text" name="pricecount_1" class="easyui-validatebox" placeholder="请输入总票数"><br>
				座位等级：<input id="genre_2" type="text" name="genre_2" class="easyui-validatebox" value="经济舱" readonly="readonly"><br>
				机票价格：<input id="price_2" type="text" name="price_2" class="easyui-validatebox" placeholder="请输入价格"><br>
				机票总数：<input id="pricecount_2" type="text" name="pricecount_2" class="easyui-validatebox" placeholder="请输入总票数"><br>
				<a id="btn" href="javascript:modifyFlightMessage()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" style="margin-left:180px;">修改</a>  
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
	  	//查找航班信息
	  	function searchFlightMessage(){
	  		var cid=$('#searchform input[name=cid]').val();
			var port_name=$('#searchform select[name=port_name]').val();
			var end_port_name=$('#searchform select[name=end_port_name]').val();
			var starttime=$('#searchform input[name=starttime]').val();
			var endtime=$('#searchform input[name=endtime]').val();
			var startprice_1=$('#searchform input[name=startprice_1]').val();
			var endprice_1=$('#searchform input[name=endprice_1]').val();
			var startprice_2=$('#searchform input[name=startprice_2]').val();
			var endprice_2=$('#searchform input[name=endprice_2]').val();
			var air_number=$('#searchform input[name=air_number]').val();
	  		$('#dg').datagrid({    
			    url:'/airlineTickets/flightMessage/searchFlightMessage?cid='+cid+'&port_name='+port_name+'&end_port_name='+end_port_name+'&starttime='+starttime+'&endtime='+endtime+'&startprice_1='+startprice_1+'&endprice_1='+endprice_1+'&startprice_2='+startprice_2+'&endprice_2='+endprice_2+'&air_number='+air_number,
			    columns:[[  
			    	{field:'',title:'',width:100,checkbox:true},
			    	{field:'fid',title:'航班编号',align:'center'},
			        {field:'air_number',title:'飞机编号',align:'center'},    
			        {field:'setouttime',title:'起飞时间',
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
		  	     	{field:'port_name',title:'起飞机场',width:90,align:'center'}, 
			        {field:'end_port_name',title:'到达机场',width:90,align:'center'}, 
			        {field:'genre_1',title:'座位等级',width:70,align:'center'}, 
			        {field:'price_1',title:'机票价格',width:70,align:'center'}, 
			        {field:'pricecount_1',title:'总票数',width:70,align:'center'}, 
			        {field:'genre_2',title:'座位等级',width:70,align:'center'}, 
			        {field:'price_2',title:'机票价格',width:70,align:'center'}, 
			        {field:'pricecount_2',title:'总票数',width:70,align:'center'}
		    	]]    
			}); 
	  		$('#searchform select[name=port_name]').val(-1);
			$('#searchform select[name=end_port_name]').val(-1);
			$('#searchform input[name=startprice_1]').val("");
			$('#searchform input[name=endprice_1]').val("");
			$('#searchform input[name=startprice_2]').val("");
			$('#searchform input[name=endprice_2]').val("");
			$('#searchform input[name=air_number]').val("");
			$('#searchform input[name=starttime]').datetimebox('setValue',""); 
    		$('#searchform input[name=endtime]').datetimebox('setValue',"");
	  	}
		//修改航班信息
		function modifyFlightMessage(){
			$.post("/airlineTickets/flightMessage/modifyFlightMessage",$('#modifyform').serialize(),function(data){
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
		//取消删除航班信息
		function cancledeleteFlightMessage(){
			$('#delete_win').window('close');
			$('#dg').datagrid('clearSelections');
		}
		//删除航班信息
		function deleteFlightMessage(){
			$('#delete_win').window('close');
			//获取选中行
    		var rows=$('#dg').datagrid('getSelections');
			//获取选中的行号
    		//放入数据
			var fids=[];
			for(var i=0;i<rows.length;i++){
				fids[i]=rows[i].fid;
			}
			//放入字符串
			var fidStr=fids.join(",");
			$.post("/airlineTickets/flightMessage/deleteFlightMessage",{fids:fidStr},function(data){
				if(data=="true"){
					$.messager.alert('恭喜','航班删除成功！');
					$('#dg').datagrid('load',{});
				}else{
					$.messager.alert('警告','服务器异常，请稍后再试！'); 
				}
			},'text');
		}
	
		//增加航班信息
		function addFlightMessage(){
			$.post("/airlineTickets/flightMessage/addFlightMessage",$('#addform').serialize(),function(data){
				if(data=="true"){
					$('#add_win').window('close');
					$.messager.alert('恭喜','增加成功！'); 
					$('#dg').datagrid('load',{});
				}else{
					$('#add_win').window('close');
					$.messager.alert('警告','服务器异常，请稍后再试！'); 
				}
			},'text');
			$('#addform input[name=air_number]').val("");
			$('#addform input[name=genre_1]').val("");
			$('#addform input[name=price_1]').val("");
			$('#addform input[name=pricecount_1]').val("");
    		$('#addform input[name=genre_2]').val("");
    		$('#addform input[name=price_2]').val("");
			$('#addform input[name=pricecount_2]').val("");
    		$('#addform input[name=setouttime]').datetimebox('setValue',""); 
    		$('#addform input[name=achieve]').datetimebox('setValue',"");
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
		//初始化增加航班窗口
		$('#add_win').window({    
		    width:500,    
		    height:380,    
		    modal:true,
		    closed:true,
		    iconCls:'icon-add',
		    title:'增加航班'
		});
		//初始化删除航班窗口
		$('#delete_win').window({    
		    title:"删除航班",
		    width:350,
		    height:200, 
		    iconCls:'icon-remove',
		    resizable:true,
		    modal:true,
		    closed:true
		});
		//初始化修改航班窗口
		$('#modify_win').window({    
		    width:500,    
		    height:410,    
		    modal:true,
		    closed:true,
		    iconCls:'icon-edit',
		    title:'修改航班'
		});
		var cid=1;
		//初始化表格数据
		$('#dg').datagrid({    
		    url:'/airlineTickets/flightMessage/loadFlightMessage?cid='+'${sessionScope.airCompany.cid}',
		    pagination:true,
		    toolbar: [{
				iconCls: 'icon-add',
				text:'增加航班',
				handler: function(){
					$('#add_win').window('open');
					//动态加载机场选项
					$.get("/airlineTickets/airportMessage/loadAirportMessage",function(data){
						$('#port_name option').remove();
						$('#end_port_name option').remove();
						for(var i=0;i<data.length;i++){
							$('#port_name').append("<option value='"+data[i].aid+"'>"+data[i].port_name+"</option");
							$('#end_port_name').append("<option value='"+data[i].aid+"'>"+data[i].port_name+"</option");
						}
					},'json');
					}
			},'-',{
				iconCls: 'icon-remove',
				text:'删除航班',
				handler: function(){
					//获取选中行
		    		var rows=$('#dg').datagrid('getSelections');
		    		if(rows<=0){
		    			$.messager.alert('警告','请至少选择一个要删除的航班！');  
		    			return;
		    		}
		    		//打开是否确定删除窗口
		    		$('#delete_win').window('open');
					}
			},'-',{
				iconCls: 'icon-edit',
				text:'修改航班',
				handler: function(){
					//获取选中行
		    		var row=$('#dg').datagrid('getSelected');
		    		if(!row){
		    			$.messager.alert('警告','请选择要修改的航班！');  
		    			return;
		    		}
		    		//时间格式化
		    		var setouttime=parsJSONDate(row.setouttime);
		    		var achieve=parsJSONDate(row.achieve);
		    		$('#fid').val(row.fid);
		    		$('#air_number').val(row.air_number);
		    		$('#setouttime').datetimebox('setValue',setouttime); 
		    		$('#achieve').datetimebox('setValue',achieve);
		    		$('#port_name_1').val(row.port_name);
		    		$('#end_port_name_1').val(row.end_port_name);
		    		$('#genre_1').val(row.genre_1);
		    		$('#price_1').val(row.price_1);
		    		$('#pricecount_1').val(row.pricecount_1);
		    		$('#genre_2').val(row.genre_2);
		    		$('#price_2').val(row.price_2);
		    		$('#pricecount_2').val(row.pricecount_2);
		    		//打开修改窗口
		    		$('#modify_win').window('open');
					}
			}],
		    columns:[[  
		    	{field:'',title:'',width:100,checkbox:true},
		    	{field:'fid',title:'航班编号',align:'center'},
		        {field:'air_number',title:'飞机编号',align:'center'},    
		        {field:'setouttime',title:'起飞时间',
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
		        {field:'port_name',title:'起飞机场',width:90,align:'center'}, 
		        {field:'end_port_name',title:'到达机场',width:90,align:'center'}, 
		        {field:'genre_1',title:'座位等级',width:70,align:'center'}, 
		        {field:'price_1',title:'机票价格',width:70,align:'center'}, 
		        {field:'pricecount_1',title:'总票数',width:70,align:'center'}, 
		        {field:'genre_2',title:'座位等级',width:70,align:'center'}, 
		        {field:'price_2',title:'机票价格',width:70,align:'center'}, 
		        {field:'pricecount_2',title:'总票数',width:70,align:'center'} ,
		    ]]    
		});  

	
	</script>
</body>
</html>