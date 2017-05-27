$(function(){
	$(window).on("load",function(){
	// 读取cookie中的用户名显示
		$.cookie.json = true;
		var name = $.cookie("name");
		console.log(name);
		if(name){
			$(".user_name").text("欢迎您"+name);
				$(".quit").show();
			// 点击退出清空当前的cookie值
			$(".quit").on("click",function(){
				$.cookie("name",name,{expires:-1});
				location = "login.html";
			});
		}
		var text_sheng;
		// 页面加载完成后出现
		$("#userAddId").show();
		$(".zhezhao").show();
		// 点击保存时消失，并将信息存入页面,
		// 消失的时候还需判断输入是否符合标准
		$("#save").click(function(){
			//如果信息输入完整则关闭
			if(checkAddname()&&checkAddhome()&&checkAddphone()){
				$("#userAddId").hide();
				$(".zhezhao").hide();
				// 将输入的信息保存到cookie中
				var $ul = $(this).siblings("ul"),
					add_name = $ul.find("#IU-name").val(),
					add_phone = $ul.find("#IU-phone").val(),
					add_shi = $ul.find(".shi").text(),
					add_xian = $ul.find(".xian").text(),
					add_cun = $ul.find("#IU-address").val(),
					add_information = {
						"name":add_name,
						"phone":add_phone,
						"shi":add_shi,
						"xian":add_xian,
						"cun":add_cun
					};
					$.cookie.json = true;
				var add_informations = $.cookie("add_information");
					if(!add_informations){
						add_informations = [];
					}
				add_informations.push(add_information);
				$.cookie("add_informations",add_informations,{expires:7});
				// 所有填入的信息清空
				$(".indentAll").find("input").val("");
				$(".indentAll").find("select").val("");
			// 读取cookie
				$.cookie.json = true;
				var add_informations = $.cookie("add_informations");
				$.each(add_informations,function(index,element){
					$(".userAddress").find(".f-name").text(element.name).end()
					.find(".f-phone").text(element.phone).end()
					.find(".f-shi").text(element.shi).end()
					.find(".f-xian").text(element.xian).end()
					.find(".f-zhen").text(element.cun);
				});
			// 将购物车中的东西加入列表中
				$.cookie.json = true;
				var products = $.cookie("products");
				$.each(products,function(index,element){
					$(".ci-template").clone(true).removeClass("ci-template").
					addClass("cart_body").show().appendTo("#cart-info").
					children(".id").text(element.id).end().
					children(".price").text(element.price).end().
					children(".amount").text(element.amount).end().
					children(".sub").text((element.price*element.amount).
						toFixed(2)).end();
				});
				// 总计金额
				function all(){
					var sum = 0;
					$("#cart-info .sub").each(function(){
						var a = parseFloat($(this).text());
						sum+=a;
					});
					$("#gross").text(sum.toFixed(2));
				}
				all();
			} 
		});
		/************判断输入信息是否准确************/
		function checkAddname(){
			if($("#IU-name").val().length !=0){
				return true;
			}else{
				$(".iuErr").hide();
			}
		}
		function checkAddhome(){
			if(($("#IU-address").val().length==0)||
				($(".sheng").text().length ==0)||
				($(".shi").text().length==0)||
				($(".xian").text().length==0)){
					$(".faErr").show();
			}else{
				return true;
				$(".faErr").hide();
			}
		}
		function checkAddphone(){
			var CAphone =/^[0-9]{11}$/.test($("#IU-phone").val());
			if(CAphone){
				return true;
			}else{
				$(".ipErr").show();
			}
		}


		$("#amend").click(function(){
			$("#userAddId").show();
			$(".zhezhao").show();
		});
		/* 验证输入是否正确*/
		// 失去焦点
		$("#IU-name").on("blur",function(){
			if($("#IU-name").val().length === 0){
				$(".iuErr").show();
			}else{
				$(".iuErr").hide();
			}
		});
		$("#IU-address").on("blur",function(){
			if($("#IU-address").val().length === 0){
				$(".faErr").show();
			}else{
				$(".faErr").hide();
			}
		});
		$("#IU-phone2").on("blur",function(){
			if(($("#IU-phone").val().length===0||($("#IU-phone2").val().length===0))){
				$(".ipErr").show();
			}else{
				$(".ipErr").hide();
			}
		});
		/***********省市级联**********/
		var address = [];
		$.getJSON("js/address.json",function(data){
			var provinces = data.regions;

			$.each(provinces,function(index,province){
				address[province.name] = [];
				var cities = province.regions;
				$.each(cities,function(index,city){
					address[province.name][city.name] = city.regions;
				});
			});
			initProvince();
		});
		// 省份初始化
		function initProvince(){
			$("#province").empty().append("<option value='-1'>请选择省份</option>");
			for(var provinceName in address){
				$("<option value='"+provinceName+"'>"+provinceName+"</option>")
				.appendTo("#province");
			}
		}
		// 城市加载
		function initCity(){
			var provinceName = $("#province").val();
			// 获取该省份下的所有城市
			var  cities = address[provinceName];
			// 显示城市
			$("#city").empty().append("<option value='-1'>请选择城市</option>");
		
			for(var cityName in cities){
				$("<option value='"+cityName+"'>"+cityName+"</option>")
				.appendTo("#city");
			}
			$(".sheng").text(provinceName);
			text_sheng = $(".sheng").text();
			
		};
		function initDistrict(){
			// 获取已选省份与城市
			var provinceName = $("#province").val(),
				cityName = $("#city").val();
			// 获取选定城市下的所有区县信息
			var districts = address[provinceName][cityName];
			// 显示区县
			$("#district").empty().append("<option value='-1'>请选择区县</option>");
			for(var i in districts){
				$("<option value='"+districts[i].name+"'>"+
					districts[i].name+"</option>").appendTo("#district");
			}
			$(".shi").text(cityName);
		};

		$("#province").on("change",initCity);
		$("#city").on("change",initDistrict);
        $("#district").on("change",function(){
        	$(".xian").text($(this).val());
        });
	});
});