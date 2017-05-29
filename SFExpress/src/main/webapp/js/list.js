$(function () {
    // 读取cookie中的用户名显示
    $.cookie.json = true;
    var name = $.cookie("name");
    console.log(name);
    if (name) {
        $(".user_name").text("欢迎您" + name);
        $(".quit").show();
        // 点击退出清空当前的cookie值
        $(".quit").on("click", function () {
            $.cookie("name", name, {expires: -1});
            location = "../WEB-INF/login.html";
        });
    }
    /***********放大镜效果***********/
        // 小图轮播
    var nextIndex = 1,
        $imgs = $(".op-box img"),
        imgHeight = $(".op-box img").height(),
        len = $imgs.length;
    $(".op-box").height(imgHeight * len);
    //上一张
    $(".op-prev").on("click", function () {
        move();
    });

    // 下一张
    $(".op-next").on("click", function () {
        move();
    });
    //移动函数
    function move() {
        var _top = -nextIndex * imgHeight;
        nextIndex++;
        if (nextIndex > len - 5) {
            nextIndex = 0
        }
        $(".op-box").animate({
            "top": _top,
        });
    }

    //放大镜
    //鼠标移到小图切换大图
    $.each($(".op-box img"), function (index, element) {
        $(this).on("mousemove", function () {
            $(".op-middle img").attr({
                src: "img/middle_1800240143_1_" + (index + 1) + ".jpg",
            });
            $(".op-big img").attr({
                src: "img/original_1800240143_1_" + (index + 1) + ".jpg",
            });
        });
    });

    var middleWidth = $(".op-middle").width(),
        middleHeight = $(".op-middle").height(),
        popWidth = $(".op-pop").width(),
        popHeight = $(".op-pop").height();

    $(".op-middle").hover(function () {
        $(".op-pop,.op-big").fadeIn();
    }, function () {
        $(".op-pop,.op-big").fadeOut();
    }).on("mousemove", function (event) {
        //计算出遮罩在整个文档中的绝对定位(即光标在遮罩中心)
        var _left = event.pageX - popWidth / 2,
            _top = event.pageY - popHeight / 2;
        $(".op-pop").offset({
            "top": _top,
            "left": _left
        });
        //获取到遮罩相对.op-middle的定位
        _left = $(".op-pop").position().left;
        _top = $(".op-pop").position().top;
        console.log(_left, _top);
        //越界
        if (_left < 0) {
            _left = 0;
        } else if (_left > middleWidth - popWidth) {
            _left = middleWidth - popWidth;
        }
        if (_top < 0) {
            _top = 0;
        } else if (_top > middleHeight - popHeight) {
            _top = middleHeight - popHeight;
        }
        //重新定位
        $(".op-pop").css({
            "top": _top,
            "left": _left
        });
        //放大镜位置
        $(".op-big img").css({
            "top": -2 * _top,
            "left": -2 * _left
        });
    });


    /*********移入商品介绍的js***********/
    //鼠标移入添加样式
    $(".ltr-header a").on("click", function () {
        $(this).siblings("a").removeClass("ltr-header-bg");
        $(this).addClass("ltr-header-bg");
    });
    // 点击用户评论跳转
    $(".discuss").click(function () {
        $(".ltra-info").hide();
    });
    // 点击商品介绍显示
    $(".ltr-header-bg").click(function () {
        $(".ltra-info").show();
    });
    //当页面滚到这个div时，这个div要固定在顶部
    $(window).on("scroll", function () {
        var _scrollTop = $(this).scrollTop(),
            listTop = $(".ltr-demo").offset().top;
        if (_scrollTop >= listTop) {
            $(".ltr-header").addClass("fixed-top");
        } else {
            $(".ltr-header").removeClass("fixed-top");
        }
    });
    /*************页面下方图片无缝轮播****************/
    var $sfPics = $(".sfPic"),
        imgWidth = $(".sfPic").width(),
        lens = $sfPics.length,
        currIndex = 1,
        timer = null;
    $("#sf-imgs").width(imgWidth * lens);
    // 自动轮播
    timer = setInterval(moveLeft, 3000);
    // 鼠标移入上面的span运动
    $.each($(".sfIcons div"), function (index, element) {
        $(this).on("mouseenter", function () {
            // console.log($(this).index())
            $(this).addClass("Curr-bg").siblings().removeClass("Curr-bg");
            clearInterval(timer);
            currIndex = $(this).index();
            moveLeft();
            timer = setInterval(moveLeft, 3000);
        });
    });
    function moveLeft() {
        // console.log(123);
        var _left = -currIndex * imgWidth;
        currIndex++;
        if (currIndex >= lens) {
            currIndex = 0;
        }
        $("#sf-imgs").animate({
            "left": _left
        });
    };
    /************点击加减按钮**************/
    // 加按钮
    $(".lbo-add").on("click", function () {
        var _num = $(this).siblings(".lbo-amout").text();
        _num++;
        $(".lbo-amout").text(_num);
    });
    // 键按钮
    $(".lbo-cut").on("click", function () {
        var _num = $(this).siblings(".lbo-amout").text();
        _num--;
        if (_num < 1) {
            return;
        }
        $(".lbo-amout").text(_num);
    });


    /************加入购物车*****************/
    $("#append_car").click(function () {
        var number = $(".lbo-amout").text();
        var proid = $("#proid").text();

        addcart(proid, number);
        // 成功提示信息
    });
});
function addcart(id, num) {

    //Ajax 添加 购物车
    $.ajax({
        url: "/cart/addcart",
        type: "GET",
        async: false,
        data: {
            proid: id,
            num: num
        },
        timeout: 30000,
        dataType: "json",
        success: function (data) {

            //如果发送成功 则开启定时
            if (data.status > 0) {

                var cartnum = $("#cartnum");

                var num_cart = cartnum.val();

                var intnum = parseInt(num_cart.toString());

                cartnum.val(intnum + 1);

                //一直过来的
                $("#show_img").show(600).animate({
                    "left": 600,
                    "top": -220,
                }, 1000).hide(600, function () {
                    $(".zhezhao").show();
                    $(".car_success").show();
                }).css({
                    "left": 150,
                    "top": 50
                });
                // 继续购物和查看购物车
                $("#go_on").click(function () {
                    $(".zhezhao").hide();
                    $(".car_success").hide();
                });
                $("#car_goto").click(function () {
                    location = "/cart/all";
                });

            } else if (data.status == -2) {

                alert("请先登录再添加到购物车！");
            } else {

                alert("加入购物车失败！");
            }
        },
        complete: function (XMLHttpREquest, status) {
            //发送失败
            if (status == "timeout") {
                alert("添加超时请重新添加！");
            }
        }
    });
}