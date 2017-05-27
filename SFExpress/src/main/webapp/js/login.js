$(function(){

	// 失去焦点时
	$("#username").on("blur",function(){
		if($("#username").val().length===0){
			$("#usernameError").show();
		}else{
			$("#usernameError").hide();
		}
	});
	$("#password").on("blur",function(){
		if($("#password").val().length===0){
			$("#passwordError").show();
		}else{
			$("#passwordError").hide();
		}
	});
	//获得焦点时
	$("#username").on("focus",function(){
		$("#usernameError").hide();
	});
	$("#password").on("focus",function(){
		$("#passwordError").hide();		
	});

	// 检查用户名和密码
	function check(){
		var name = $("#username").val(),
			pwd = $("#password").val();
		var data = {
			"username":name,
			"password":pwd
			};
		var	data = JSON.stringify(data);
		console.log(data);
		$.ajax({
			type:"post",
			url:"http://localhost:8080/project-webapp/json/login",
			data:data,
			success:function(data){
				alert(1);
				console.log(data);
				// var flog = JSON.parse(data);
				// if(flog==true){
				// 	location="index.html";
				// 	// 将用户名保存到cookie中
				// 	$.cookie.json = true;
				// 	$.cookie("name",name,{expires:7});
				// }else{
				// 	$(".zhezhao").show();
				// 	$(".login-error").show();
				// }
			},
			error:function(data){
				console.log(data);
				var date = JSON.parse(data.responseText);
				console.log(date);
				if(date.ResultCode == 200){
					location.href = '../WEB-INF/index.html';
					// 将用户名保存到cookie中
						$.cookie.json = true;
						$.cookie("name",name,{expires:7});
				}else{
					$(".zhezhao").show();
					$(".login-error").show();
				}
			}
		});
	}
	// 登陆
	$("#login").on("click",function(){
		if(checkCode()){
			check()
		}
	});
	$("#errorBtn").click(function(){
		$(".login-error").hide();
		$(".zhezhao").hide();
	});
	// 验证码
	function randomString(){
		var $arr = "ABCDEFGHIGKLMNOPQRSTUVWXYZ123456789";
		var Maxlen = $arr.length;
		var pos = "";
		for(var i=0;i<4;i++){
			pos += $arr.charAt(Math.floor(Math.random()* Maxlen));
		}
		return pos;
	};
	$(".code_auth").text(randomString());
	function checkCode(){
		if($("#code_auth").val()== $(".code_auth").text()){
			return true;
		}else{
			$(".code_err").addClass("color_red");
		}
	}
	$("#code_auth").on("blur",function(){
		checkCode();
	});
	$("#code_auth").on("focus",function(){
		if($(".code_err").hasClass("color_red")){
			$(".code_err").removeClass("color_red");
		}
	});
});