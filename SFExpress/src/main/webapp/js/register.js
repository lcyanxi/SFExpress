$(function(){
	$(window).on("load",function(){
		// 获得焦点时
		$("#username").on("focus",function(){
			$(".regPoint1").show();
			$(".regPoint-err1").hide();
			$(".reg_exist").hide();
		});
		$("#password").on("focus",function(){
			$(".regPoint2").show();
			$(".regPoint-err2").hide();
		});
		$("#password2").on("focus",function(){
			$(".regPoint3").show();
			$(".regPoint-err3").hide();
		});
		$("#auth_code").on("focus",function(){
			$(".regPoint").show();
		});
		//失去焦点时
		$("#username").on("blur",function(){
			checkUsername();
		});
		$("#password").on("blur",function(){
			console.log(456);
			checkPassword();
		});
		$("#password2").on("blur",function(){
			checkSame();
		});
		//验证用户名和密码是否合法
		var uname,pwd;
		function checkUsername(){
			console.log($("#username").val());
			uname = /^[0-9]{11}$/.test($("#username").val());
			console.log(uname);
			if(!uname){
				console.log(1);
				$(".regPoint-err1").show();
				$(".regPoint1").hide();
			}else{
				console.log(2);
				$(".regPoint1").hide();
				$(".regOK1").show();
				
			}
		}
		// 验证密码
		function checkPassword(){
			pwd = /^[a-z0-9_-]{6,20}$/.test($("#password").val());
			var len = $("#password").val().length;
			if(pwd){
				$(".regOK2").show();
				$(".regPoint2").hide();
				if(len>=6&&len<10){
					$(".reg-thr>em").eq(0).addClass("curr").siblings().removeClass("curr");
				}else if(len>=10&&len<14){
					$(".reg-thr>em").eq(1).addClass("curr").siblings().removeClass("curr");
				}else{
					$(".reg-thr>em").eq(2).addClass("curr").siblings().removeClass("curr");
				}
			}else{
				$(".regPoint2").hide();
				$(".regPoint-err2").show();
				$(".regOK2").hide();

			}
		}
		//密码相同
		function checkSame(){
			if($("#password2").val().length === 0){
				return;
			}
			if($("#password").val() === $("#password2").val()){
				$(".regOK3").show();
			}else{
				$(".regPoint-err3").show();
				$(".regOK3").hide();
			}
		}

		// 注册
		$("#reg").on("click",function(){
			if(checkUsername&&pwd&&checkCode&&($("#password").val()===$("#password2").val())){
				// alert("注册成功");
				var name = $("#username").val(),
					password = $("#password").val();
				var data = {
					"username":name,
					"password":password
				};
				var data = JSON.stringify(data);
				$.ajax({
					type:"post",
					url:"/user/adduser",
					data:data,
					success:function(data){
						console.log(data);
						alert(data);
						$(".zhezhao").show();
						$(".register-success").show();
						$("#successBtn").click(function(){
							location = "../WEB-INF/login.html";
						});
					},
					error:function(data){
						var date = JSON.parse(JSON.parse(data.responseText));
						console.log(date);
						if(date.ResultCode == 202){
							console.log('用户已存在');
							$('.zhezhao').show();
							$('.zhezhao2').show();
							$('#re-login').click(function(){
								location.href = '../WEB-INF/login.html'
							});
						}else if(date.ResultCode == 200){
							console.log('注册成功');
							location.href = '../WEB-INF/login.html';
						}
					}	
				});
			}
			else{
				// alert("注册不成功");
			}
		});
		// 随机生成验证码
		function randomString(){
			var $arr = "ABCDEFGHIGKLMNOPQRSTUVWXYZ123456789";
			var Maxlen = $arr.length;
			var pos = "";
			for(var i=0;i<4;i++){
				pos += $arr.charAt(Math.floor(Math.random()* Maxlen));
			}
			return pos;
		};
		$("#onchange").on("click",function(){
			$("#code_img1").text(randomString());
			// console.log($("#code_img1").text());
		});
		$("#code_img1").text(randomString());
		function checkCode(){
			if($("#auth_code").val()== $("#code_img1").text()){
				$(".regOK").show();
				$(".regPoint").hide();
			}else{
				return;
			}
		}
		$("#auth_code").on("blur",function(){
			checkCode();
		});
		
	});
});

