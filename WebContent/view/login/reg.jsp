<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <script type="text/javascript" src="../../js/jquery-1.3.2.min.js"></script> 
  <!-- 重置文件 -->
  <link rel="stylesheet" href="/graduation/css/login/style1.css">
  <title>注册</title>
</head>
<body>
  <div class="reg_div">
    <p>注册</p>
    <ul class="reg_ul">
    <li>我们会将你的信息进行核对以及本人确定</li>
      <li>
          <span>真实姓名：</span>
          <input type="text" name="name" value="" placeholder="2-5位中文姓名" class="reg_name">
          <span class="tip name_hint"></span>
      </li>
          <span>性别：</span>
         <input type="radio" name="sex" value="1" checked="checked"/>男
	     <input type="radio" name="sex" value="2"/>女<br/>
          <span ></span>
     </li>

      <li>
          <span>邮箱：</span>
          <input type="text" name="email" value="" placeholder="邮箱" class="reg_email">
          <span class="tip email_hint"></span>
      </li>
      <li>
          <span>学号：</span>
          <input type="text" name="stuno" value="" placeholder="学号" class="reg_stuno">
          <span class="tip stuno_hint"></span>
      </li>
      <li>
          <span>所在学院：</span>
          <input type="text" name="departrue" value="" placeholder="输入所在学院" class="reg_depature">
          <span class="tip depature_hint"></span>
      </li>
       <li>
          <span>班级：</span>
          <input type="email" name="grade" value="" placeholder="班级" class="reg_class">
          <span class="tip user_class" ></span>
      </li>
      <li>
       
        <button type="button" name="button" class="red_button" onclick="reg()">注册</button>
        <button type="button"   onclick="window.location.href='/graduation/login.jsp'">放弃注册</button>
      </li>
    </ul>
  </div>
  
  <script type="text/javascript" src="../../js/jquery.min.js"> </script>
  
 
  <script type="text/javascript">
//user
  var user_Boolean = false;
  var stuno_Boolean = false;
  var emaile_Boolean = false;
  var depature_Boolean = false;
  var class_Boolean = false;
  $('.reg_name').blur(function(){
    if ((/^[\u4E00-\u9FA5]{1,5}$/).test($(".reg_name").val())){
      $('.name_hint').html("✔").css("color","green");
      user_Boolean = true;
    }else {
      $('.name_hint').html("×").css("color","red");
      user_Boolean = false;
    }
  });
  // stuno
  $('.reg_stuno').blur(function(){
    if ((/^63\d{10}$/).test($(".reg_stuno").val())){
      $('.stuno_hint').html("✔").css("color","green");
      stuno_Boolean = true;
    }else {
      $('.stuno_hint').html("×").css("color","red");
      stuno_Boolean = false;
    }
  });



  // Email
  $('.reg_email').blur(function(){
    if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/).test($(".reg_email").val())){
      $('.email_hint').html("✔").css("color","green");
      emaile_Boolean = true;
    }else {
      $('.email_hint').html("×").css("color","red");
      emaile_Boolean = false;
    }
  });


  // depature
  $('.reg_depature').blur(function(){
    if ((/^[\u4E00-\u9FA5]{1,5}$/).test($(".reg_depature").val())){
      $('.depature_hint').html("✔").css("color","green");
      depature_Boolean = true;
    }else {
      $('.depature_hint').html("×").css("color","red");
      depature_Boolean = false;
    }
  });

  //CLASS
  $('.reg_class').blur(function(){
    if ((/^[\u4E00-\u9FA5]{1,5}$/).test($(".reg_class").val())){
      $('.class_hint').html("✔").css("color","green");
      class_Boolean = true;
    }else {
      $('.class_hint').html("×").css("color","red");
     class_Boolean = false;
    }
  });
  // click
  $('.red_button').click(function(){
    if(user_Boolean && stuno_Boolean && depature_Boolean && emaile_Boolean && class_Boolean == true){
      alert("正在提交");
		var a=$('input[name="name"]').val();
		var b=$('input[name="email"]').val();
		var c=$('input[name="stuno"]').val();
		var d=$('input[name="sex"]').val();
		var e=$('input[name="departrue"]').val();
		var f=$('input[name="grade"]').val();
		$.post("/graduation/studentReg/studentReg",{name:a,email:b,stuno:c,
			sex:d,departrue:e,grade:f},function(data){
		
			if(data=="true"){
				alert("成功");	
			}else{
				alert("失败，请重试");
			}
			
		},"text");
    }else {
      alert("请完善信息");
    }
  });

  
  </script>
  <div style="text-align:center;">
<p><a href="http://localhost:8080/graduation/index.html" target="_blank">欢迎你的使用</a></p>
</div>

</body>
</html>