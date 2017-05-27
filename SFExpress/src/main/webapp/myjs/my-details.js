$(function(){
	var html = '';
	$.ajax({
		type:"POST",
		url:'http://localhost:8080/project-webapp/json/selectAll',
		dataType:"json",
		success:function(data){
			console.log(JSON.parse(data));
			var data = JSON.parse(data);
			console.log(data.length);
			for(var i = 0;i<data.length;i++){
				html += '<dl class="dmrt-product">'+
							'<dd>'+
								'<img src="'+data[i].imgurl+'" alt="" />'+
							'</dd>'+
							'<dt>'+
								'<p class="dmrtp-one">'+
									'￥<span>'+data[i].price+'</span>'+
								'</p>'+
								'<p class="dmrtp-two">'+
									data[i].desc+
								'</p>'+
								'<p class="dmrtp-thr"></p>'+
								'<p class="dmrtp-four">'+
									data[i].pj+
									'<a href="#">'+data[i].type+'</a>'+
								'</p>'+
								'<div class="dmrtp-five">'+
									'<div class="amout">1</div>'+
									'<div class="operate">'+
										'<button class="add"></button>'+
										'<button class="cut"></button>'+
									'</div>'+
									'<button class="append-car">'+
										'<i></i>'+
										'加入购物车'+
									'</button>'+
								'</div>'+
							'</dt>'+
						'</dl>';
			}
			console.log(html)
			$('.dmr-thr').append(html);
		}
	})
})