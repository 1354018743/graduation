<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path=getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="/graduation/assets/css/form-elements.css">
        <link rel="stylesheet" href="/graduation/assets/css/style.css">
         <link href="/graduation/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	    <link href="/graduation/assets/bootstrap/css/fresh-bootstrap-table.css" rel="stylesheet">
	    <link href="/graduation/assets/bootstrap/css/animate.min.css" rel="stylesheet">
	    <link rel="stylesheet" href="/graduation/assets/bootstrap/css/bootstrapValidator.min.css"/>
	    <link rel="stylesheet" href="/graduation/assets/bootstrap/css/style.min.css" />
	    <link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/metro/easyui.css">   
		<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/themes/icon.css">
	    <style>
	    	.back:hover{cursor: pointer;}
	    	.fixed-table-toolbar .btn-group>.btn-group:last-child>.btn {
			    border-top-right-radius: 0px;
			    border-bottom-right-radius: 0px;
			}
			label{width:100px;}
			.popup_de{
				background-color:rgba(0,0,0,0.3);
				width:100%;
				height: 100%;
				position:fixed;
				z-index:999;
				top:0;
				left:0;
				display:none;
			}
			.bbox{
				display: -webkit-box;   /* 老版本语法: Safari, iOS, Android browser, older WebKit browsers. */
			    display: -moz-box;      /* 老版本语法: Firefox (buggy) */
			    display: -ms-flexbox;   /* 混合版本语法: IE 10 */   
				display: -webkit-flex;  /* 新版本语法: Chrome 21+ */
				display: -moz-flex;
			    display: flex;          /* 新版本语法: Opera 12.1, Firefox 22+ */
			}
			.bbox.xycenter{
				-moz-box-pack: center; /*Firefox*/
			    -webkit-box-pack: center; /*Safari,Opera,Chrome*/
			    box-pack: center;
			    -moz-justify-content: center;
			    -webkit-justify-content: center;
			    justify-content: center;
				-moz-box-align: center; /*Firefox*/
			    -webkit-box-align:center; /*Safari,Opera,Chrome*/
			    box-align: center;
				-moz-align-items: center;
			    -webkit-align-items: center;
				align-items:center;
			}
			.popup_de .popup_box{
				width:300px;
				height:150px;
				font-family: '微软雅黑';
				background-color: #fff;
				border-radius:5px;
				color:#333;
			}
			.popup_de .popup_btn{
				display: inline-block;
				width:100px;
				height:30px;
				border-radius: 3px;
				border:1px solid #1ab394;
				font-size:15px;
				text-align: center;
				line-height: 30px;
				margin-right:15px;
				cursor: pointer;
			}
			.popup_de .show_msg{
				display: block;
				width:100%;
				text-align: center;
				font-size:18px;
				margin-top:40px;
				margin-bottom: 20px;
				padding:10px;
			}
			.popup_de .popup_close{
				width:30px;
				height:30px;
				font-size:25px;
				text-align: center;
				display: inline-block;
		        cursor:pointer;
		        float: right;
		        border-top-right-radius: 5px;
				line-height:30px;
			}
			.popup_de .popup_close:hover{
				background-color: #1ab394;
				color:#fff;
			}
			.popup_de .btn_submit{
				background-color: #1ab394;
				color:#fff;
			}
			.popup_de .btn_box{
				text-align: center;
			}
	    </style>
	</head>
	<body>
	<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
               <!-- Brand and toggle get grouped for better mobile display --> 
               <div class="navbar-header"> 
                   
                   <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> 
                       <span class="sr-only">资助申请</span> 
                       <span class="icon-bar"></span> 
                       <span class="icon-bar"></span> 
                       <span class="icon-bar"></span> 
                   </button> 
                   <a class="navbar-brand" href="#">学生主页</a><!---方log的地方--> 
               </div>

               <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> 
                   <!--具体菜单项--> 
                   <ul class="nav navbar-nav"> 
                       <li ><a href="<%=path%>/view/student/main.jsp">首页 <span class="sr-only">(current)</span></a></li><!--普通菜单--> 
                       <li ><a href="<%=path%>/view/student/apply.jsp">申请资助</a></li> 
                       <li class="active"><a href="<%=path%>/view/student/progress.jsp">申请历史</a></li> 
                       <li><a href="<%=path%>/view/student/password.jsp">更改密码</a></li> 
                       <li><a href="<%=path%>/view/student/info.jsp">个人资料</a></li> 
                   </ul> 

                   <ul class="nav navbar-nav navbar-right"> 
                    <li><a >欢迎${sessionScope.user.username}</a></li>
                       <li><a href="<%=path%>/Logout/logout">退出登录</a></li> 
                   </ul> 
               </div><!-- /.navbar-collapse --> 
           </div><!-- /.container-fluid --> 
          
       </nav> 
       <!------------------------------------------导航条结束-------------------------------->	
		<div class="row">
            <div class="col-sm-8 col-sm-offset-2 ">
		<table id="dg" style="height:400px; width:100%"></table> 
		</div>
		</div>
  <script type="text/javascript" src="<%=path%>/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="<%=path%>/easyui/jquery.easyui.min.js"></script>  
	<script src="<%=path%>/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>

	<script type="text/javascript">
		
	//预加载表格显示数据
	$(function(){
		
		
		$('#dg').datagrid('load',{
			lid:'',
			
		});
	});
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
	function progress(json){
		if(json==-1){
			
			return "未通过";
			
		}else if(json==0){
			
			return "提交了申请";
			
		}else if(json==1){
			
			return "班级通过";
		}else if(json==2){
			
			return "专业审核通过";
		}else if(json==3){
			
			return "学院通过";
		}else if(json==4){
			
			return "学校通过";
		}
	
	}
	var lid=${sessionScope.user.lid}
	
	$('#dg').datagrid({    
	    url:'/graduation/applyMessage/loadApplyMessage?lid='+lid,
	    pagination:true,
	    rownumbers:true,
	    height:400,
	    width:890,
	    toolbar: [{
			iconCls: 'icon-edit',
			text:'导出申请',
			handler: function(){
				var row=$('#dg').datagrid('getSelected');
				if(!row){
	    			$.messager.alert('警告','请选择导出的申请！');  
	    			return;
	    		}
				$.messager.confirm('确认','您确认想要导出吗？',function(r){    
				    if (r){    
				        
				    	var aid=row.aid;
						
						$.post('/graduation/Export/export',{aid:aid},function(data){
							if(data=='true'){
								
								$.messager.alert('好消息','已导出到桌面！');
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
		
		}],
	    columns:[[ 
	    	{field:'',title:'',width:100,checkbox:true},
	        {field:'aiid',title:'编号',width:100,align:'center'}, 
	        {field:'applytime',title:'申请时间',width:300,align:'center',
	        	formatter: function(value,row,index){
					return parsJSONDate(value);
				},
				
	        },   
	        {field:'progress',title:'进度',width:300,align:'center',
	        	formatter: function(value,row,index){
					return progress(value);
				},
				
	        },
	        {field:'score',title:'得分',width:158,align:'center'},   
	        {field:'aid',title:'申请编号',width:158,align:'center'},
	    ]]    
	}); 
	</script>
	</body>
		<nav class="navbar navbar-default  navbar-fixed-bottom text-center"> 
		 <div  id="copyright">
		            <p style="margin-top:10px">2018@leizhen </p>
		           
		             <p> 重庆交通大学资助申请系统 </p>
		 </div>
		</nav>
</html>
