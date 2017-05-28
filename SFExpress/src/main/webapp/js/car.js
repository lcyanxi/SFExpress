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
    $.cookie.json = true;
    var products = $.cookie("products");
    // console.log(products);
    $.each(products, function (index, element) {
        $(".template").clone(true).removeClass("template").addClass("cart_body").show().appendTo("#cart").children(".id").find("img").attr("src", element.pic)
            .siblings("p").text(element.id).parents(".cart_body")
            .children(".price").text(element.price).end()
            .find(".num").val(element.amount).end()
            .children(".sub").text((element.price * element.amount).toFixed(2)).end()
            .find(".detele").data("product", element);
    });
    // 购物车为空
    if (products.length == 0) {
        $('.zhezhao').show();
        $(".cart_null").show();
    }
    // 点击删除
    $(".detele").on("click", function () {
        var prod = $(this).data("product"),
            prodIndex = $.inArray(prod, products);
        products.splice(prodIndex, 1);
        $.cookie("products", products, {expires: 7});
        $(this).parents(".cart_body").remove();
        calcTotal();
    });
    // 全选
    $("#ck_all").click(function () {
        var status = $("#ck_all").prop("checked");
        $("#cart .ck").prop("checked", status);
        calcTotal();
    });
    // 单选
    $("#cart .ck").click(function () {
        if ($("#cart .ck:checked").length == products.length) {
            $("#ck_all").prop("checked", true);
        } else {
            $("#ck_all").prop("checked", false);
        }
        calcTotal();
    });
    // 删除选中
    $("#del_checked").on("click", function () {
        $("#cart .ck:checked").parents(".cart_body").find(".detele").click();
        if (products.length == 0) {
            $('.zhezhao').show();
            $(".cart_null").show();
        }
    });
    // 清空购物车?y有问题
    $("#clear_cart").on("click", function () {
        console.log(products.length);
        if (products.length == 0) {
            $('.zhezhao').show();
            $(".cart_null").show();
        } else {
            $(".cart_body").find("a").click();
            $('.zhezhao').show();
            $(".cart_null").show();
        }
        calcTotal();
    });
    $("#go_on2").click(function () {
        location = "../WEB-INF/index.html";
    });
    // 加数量
    $(".addnum").click(function () {
        var amount = $(this).prev(".num").val();
        amount++;
        update(amount, $(this).parents(".cart_body"));
    });
    // 减数量
    $(".minus").click(function () {
        var amount = $(this).next(".num").val();
        amount--;
        if (amount < 1) {
            return;
        }
        update(amount, $(this).parents(".cart_body"));
    });
    // 填数量
    $(".num").on("blur", function () {
        var amount = $(this).val();
        if (/^[1-9]\d*$/.test(amount)) {
            update(amount, $(this).parents(".cart_body"));
        } else {
            alert("数量应该为数字");
            var prod = $(this).parents(".cart_body").find("a").data("product");
            $(".num").val(prod.amount);
        }
    })

    function update(amount, $element) {
        var prod = $element.find("a").data("product");
        prod.amount = amount;
        $.cookie("products", products, {expires: 7});
        $element.find(".num").val(amount);
        $element.find(".sub").text((prod.price * amount).toFixed(2));
        calcTotal();
    }

    // 合计
    function calcTotal() {
        var sum = 0;
        $("#cart .ck:checked").each(function (index, element) {
            var a = parseFloat($(this).parents(".cart_body").find(".sub").text());
            sum += a;
        })
        $("#subAll").text(sum.toFixed(2));
    }

    // 继续购物
    $("#goout").click(function () {
        location = "../WEB-INF/index.html";
    });
    // 去结算
    $("#account").click(function () {
        location = "../WEB-INF/indent.html";
    });
});