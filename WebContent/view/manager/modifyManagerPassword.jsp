<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/graduation/easyui/themes/metro/easyui.css">   
	<link rel="stylesheet" type="text/css" href="/graduation/easyui/themes/icon.css">   
	<script type="text/javascript" src="/graduation/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="/graduation/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/graduation/easyui/jqeruy.md5.js"></script>
</head>
<body>
	<div id="win">
	
	<form id="ss" method="post">   
			
			    <div>   
			        <label for="oldpassword">请输入原密码：&nbsp&nbsp&nbsp</label>   
			        <input id="oldpassword" class="easyui-validatebox" type="password"  name="oldpassword" data-options="" />   
			        </br>
			        </br>
			    </div>   
			    <div>   
			        <label for="newpassword">请输入密码：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>   
			        <input id="newpassword" class="easyui-validatebox"  type="password" name="newpassword" data-options="" /> 
			        </br>
			        </br>  
			    </div>   
 				<div>   
			        <label for="passwordagain">请再次输入密码：</label>   
			        <input id="passwordagain" class="easyui-validatebox" type="password" name="passwordagain" data-options="" />
			        </br>
			        </br>   
			    </div> 
			    <a id="btn" href="javascript:changePassword()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="margin-top:20px">确认修改</a>
			</form> 
		<script type="text/javascript">
		$('#win').window({    
		    width:400,    
		    height:200,    
		    minimizable:false,
		    maximizable:false,
		    collapsible:false,
		    title:"修改密码",
		    })
		    
		    
		    function changePassword(){
		    	var oldpassword=$('#oldpassword').val();
		    	var newpassword=$('#newpassword').val();
		    	var passwordagain=$('#passwordagain').val();
		    	
		    	 if(newpassword!=passwordagain){
		    		 $.messager.alert('警告','两次密码不一致');
		    		 
		    	 }else{
		    		 $.post('/graduation/managerChangePassword/changePassword',{oldpassword:oldpassword,passwordagain:passwordagain},function(data){
							if(data=='true'){
								$.messager.alert('确认','修改成功');
								parent.location.reload();
							}else{
								
								$.messager.alert('警告','修改失败,请确认原密码')
							}
							},'text');
		    	 }
		    	 
		    	
		    
		    
		    
		    }
		    
		    
		</script>
	</div>
</body>
</html>