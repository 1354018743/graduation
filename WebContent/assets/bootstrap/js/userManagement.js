$(function(){
	//根据窗口调整表格高度
    $(window).resize(function() {
        $('#mytab').bootstrapTable('resetView', {
            height: tableHeight()
        })
    })
    //生成用户数据
    $('#mytab').bootstrapTable({
    	method: 'post',
    	contentType: "application/x-www-form-urlencoded",
    	url:"/graduation/student/loadApply",
    	height:tableHeight(),//高度调整
    	toolbar: '#toolbar',
    	striped: true, //是否显示行间隔色
    	dataField: "res",
    	pageNumber: 1, //初始化加载第一页，默认第一页
    	pagination:true,//是否分页
    	queryParamsType:'limit',
    	queryParams:queryParams,
    	sidePagination:'server',
    	pageSize:10,//单页记录数
    	pageList:[5,10,20,30],//分页步进值
    	showRefresh:true,//刷新按钮
    	showColumns:true,
    	clickToSelect: true,//是否启用点击选中行
    	toolbarAlign:'right',
    	buttonsAlign:'right',//按钮对齐方式
    	toolbar:'#toolbar',//指定工作栏
    	columns:[
        	{
        		title:'申请日期',
        		field:'CreateTime',
        		align:'center',
        		sortable:true
        	},
        	{
        		title:'所得分数',
        		field:'score',
        		align:'center',
        		sortable:true
        	},
        	{
        		title:'操作',
        		field:'Attribute',
        		align:'center',
        		formatter:operateFormatter
        	}
    	],
    	locale:'zh-CN',//中文支持,
    })
   
   function operateFormatter(value,row,index){
    	if(value==2){
    		return '<i class="fa fa-lock" style="color:red"></i>'
    	}else if(value==1){
    		return '<i class="fa fa-unlock" style="color:green"></i>'
    	}else{
    		return '数据错误'
    	}
    }

    //请求服务数据时所传参数
    function queryParams(params){
    	return{
    		pageSize: params.limit,
    		pageIndex:params.pageNumber,
    		Name:$('#search_name').val(),
    		Tel:$('#search_tel').val()
    	}
    }
   
    //修改按钮事件
    $('#btn_edit').click(function(){
    	var dataArr=$('#mytab').bootstrapTable('getSelections');
    	$('.tableBody').addClass('animated slideOutLeft');
		setTimeout(function(){
			$('.tableBody').removeClass('animated slideOutLeft').css('display','none');
		},500)
		$('.changeBody').css('display','block');
		$('.changeBody').addClass('animated slideInRight');
		$('#edit_ID').val(dataArr[0].ID);
		$('#edit_LoginName').val(dataArr[0].LoginName);
		$('#edit_Name').val(dataArr[0].Name);
		$('#edit_Tel').val(dataArr[0].Tel);
		$('#edit_Email').val(dataArr[0].Email);
		if(dataArr[0].Attribute==1){
			$("#editForm input[name=Attribute]:eq(0)").prop("checked",true);
			$("#editForm input[name=Attribute]:eq(1)").prop("checked",false);
		}
		else if(dataArr[0].Attribute==2){
			$("#editForm input[name=Attribute]:eq(1)").prop("checked",true);
			$("#editForm input[name=Attribute]:eq(0)").prop("checked",false);
		}
		//先清空角色复选框
	    $('#editForm .edit input').prop('checked',false);
		//获取用户角色
		$.post('../index.php/admin/Index/getUserById',
				{ID:dataArr[0].ID},
				function(data){
				   var roleIDArr=data.res.user.RoleID;
                   //将对应用户的角色列表显示到对应的修改页
                   for(var i=0;i<roleIDArr.length;i++){
                	   for(var j=0;j<$('#editForm .edit input').length;j++){
                		   if(roleIDArr[i]==$('#editForm .edit input:eq('+j+')').val()){
                			   $('#editForm .edit input:eq('+j+')').prop('checked',true);
                		   }
                	   }
                   }
		        }
		);
    })
    /*
     * 用户管理增加用户页面所有事件
    */
    //增加页面表单验证   
    // Validate the form manually
    $('#add_saveBtn').click(function() {
       //点击保存时触发表单验证
       $('#addForm').bootstrapValidator('validate');
       //如果表单验证正确，则请求后台添加用户
       if($("#addForm").data('bootstrapValidator').isValid()){
    	   var _info = $('#addForm').serialize();
    	  $.post(
				"../index.php/admin/index/insertUser",
				$('#addForm').serialize(),
				function(data){
					//后台返回添加成功
					if(data.suc==true){
						$('.addBody').addClass('animated slideOutLeft');
				    	setTimeout(function(){
							$('.addBody').removeClass('animated slideOutLeft').css('display','none');
						},500);
				    	$('.tableBody').css('display','block').addClass('animated slideInRight');
				    	$('#mytab').bootstrapTable('refresh', {url: '../index.php/admin/index/userManagement'});
				    	$('#addForm').data('bootstrapValidator').resetForm(true);
				    	//隐藏修改与删除按钮
						$('#btn_delete').css('display','none');
						$('#btn_edit').css('display','none');
					}
					//否则
					else{
					}
				}
			) 
       }
    });
    //增加页面返回按钮事件
    $('#add_backBtn').click(function() {
    	$('.addBody').addClass('animated slideOutLeft');
    	setTimeout(function(){
			$('.addBody').removeClass('animated slideOutLeft').css('display','none');
		},500)
    	$('.tableBody').css('display','block').addClass('animated slideInRight');  
    	$('#addForm').data('bootstrapValidator').resetForm(true);
    });
    /*
     * 用户管理修改用户页面所有事件
    */
    //修改页面回退按钮事件
    $('#edit_backBtn').click(function(){
    	$('.changeBody').addClass('animated slideOutLeft');
    	setTimeout(function(){
			$('.changeBody').removeClass('animated slideOutLeft').css('display','none');
		},500)
    	$('.tableBody').css('display','block').addClass('animated slideInRight'); 
    	$('#editForm').data('bootstrapValidator').resetForm(true);
    })
    //修改页面保存按钮事件
    $('#edit_saveBtn').click(function(){
    	$('#editForm').bootstrapValidator('validate');
    	if($("#editForm").data('bootstrapValidator').isValid()){
    		 $.post("../index.php/admin/index/updateUserById",
				$('#editForm').serialize(),
				function(data){
					if(data.suc==true){
						//隐藏修改与删除按钮
						$('#btn_delete').css('display','none');
						$('#btn_edit').css('display','none');
						//回退到人员管理主页
						$('.changeBody').addClass('animated slideOutLeft');
				    	setTimeout(function(){
							$('.changeBody').removeClass('animated slideOutLeft').css('display','none');
						},500)
				    	$('.tableBody').css('display','block').addClass('animated slideInRight'); 
				    	//刷新人员管理主页
				    	$('#mytab').bootstrapTable('refresh', {url: '../index.php/admin/index/userManagement'});
				    	//修改页面表单重置
				    	$('#editForm').data('bootstrapValidator').resetForm(true);
					}else{
					}
			    }
    		 ) 
    	}
    })
    //删除事件按钮
    $('#btn_delete').click(function(){
    	var dataArr=$('#mytab').bootstrapTable('getSelections');
    	$('.popup_de .show_msg').text('确定要删除该用户吗?');
    	$('.popup_de').addClass('bbox');
    	$('.popup_de .btn_submit').one('click',function(){
    		var ID=[];
        	for(var i=0;i<dataArr.length;i++){
        		ID[i]=dataArr[i].ID;
        	}
        	$.post("../index.php/admin/index/deleteUserById",
        			{ID:ID},
        			function(data){
        		if(data.suc==true){
        			$('.popup_de .show_msg').text('删除成功！');
					$('.popup_de .btn_cancel').css('display','none');
					$('.popup_de').addClass('bbox');
					$('.popup_de .btn_submit').one('click',function(){
						$('.popup_de').removeClass('bbox');
					})
        			$('#mytab').bootstrapTable('refresh', {url: '../index.php/admin/index/userManagement'});
        		}else{
        		}
        	});
    	})
    })
    //弹出框取消按钮事件
   　　$('.popup_de .btn_cancel').click(function(){
	   $('.popup_de').removeClass('bbox');
   　　})
    //弹出框关闭按钮事件
     $('.popup_de .popup_close').click(function(){
	   $('.popup_de').removeClass('bbox');
   　　})
})
function tableHeight() {
    return $(window).height() - 140;
}
