$(document).ready(function () {
	Metronic.init();
	// 轮播图
    $.backstretch(
        [
            "img/bg/1.jpg",
            "img/bg/2.jpg",
            "img/bg/3.jpg",
            "img/bg/4.jpg"
        ],
        {
        	fade: 1000,
            duration: 8000
        }
    );

    // 设置录入表单数据的时候隐藏错误提示
    $('#loginForm').on('keyup', function () {
        $("#errorMsg").text("");
        $("#alert").hide();
    });

});

// 回车提交表单
document.onkeydown = keydown;
function keydown(e) {
    var currKey = 0, e = e || event;
    currKey = e.keyCode || e.which || e.charCode;//支持IE、FF
    if (currKey === 13) {
    	submitFrom();
    }
}

function localStorageUserInfo() {
    var localStorage = window.localStorage;
    var $username = $("#username").val();
    var $password = $("#password").val();
    if ($('#rememberMe').is(':checked')) {
        localStorage.setItem("username", $username);
        localStorage.setItem("password", $password);
    }else{
        if(localStorage.getItem("username") != null){
            localStorage.removeItem("username");
            localStorage.removeItem("password");
        }
    }
}

function submitFrom() {
    // 点击了记住我就存储本地数据
    localStorageUserInfo();

	// 获取表单数据
	var data = {};
	$.each($("#loginForm").serializeArray(), function (i, field) {
	    var value = field.value;
	    if ("rememberMe" === field.name) {
            value = true;
        }
        data[field.name] = value;
    });

	// 请求后端接口
    $.ajax({
        type: 'POST',
        async: false,
        contentType: "application/json;charset=UTF-8",
        url: '/sys/login',
        data: JSON.stringify(data),
        success: function (res) {
            if (res.code == 200) {
                window.localStorage.setItem('username', data.username);
                window.location.replace("/web/index.shtml");
            } else {
                $("#errorMsg").text(res.message);
                $("#alert").show();
            }
        },
        error: function () {
            alert("请求失败！请刷新页面重试");
        },
        dataType: 'json'
    });
}