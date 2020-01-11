$(document).ready(function () {
    // 提交按钮监听
    submitListener();
    // 查询信息并显示
    initData();
});

function initData(){
    var userId = $("#id").val();
    $.ajax({
        type: 'GET',
        async: true,
        url: '/sys/user/getUserDetail.do?id=' + userId,
        data: {},
        success: function (data) {
            if (data.success) {
                var User = data.result;
                $("#nickname").val(User.nickname);
                $("#email").val(User.email);
                $("#phone").val(User.phone);
            } else {
                layer.msg(data.message, {icon: 5});
            }
        },
        error: function () {
            alert("请求失败！请刷新页面重试");
        },
        dataType: 'json'
    });
}

function submitListener() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#UserForm").validate({
        rules: {
            nickname: {
                required: true
            },
            email:{
                email: true
            },
            phone:{
                digits: true,
                minlength: 11
            },
            password: {
                rangelength: [4,20]
            },
            checkPassword: {
                equalTo:"#password"
            }
        },
        messages: {
            nickname: {
                required: icon + "请输入用户昵称"
            },
            email:{
                email: icon + "请输入合法的电子邮件"
            },
            phone:{
                digits: icon + "请输入数字",
                minlength: icon + "电话长度必须为11位"
            },
            password: {
                rangelength: icon + "密码长度必须在4～20位之间"
            },
            checkPassword:{
                equalTo: icon + "密码输入不一致，请重新输入"
            }
        },
        // 提交按钮监听 按钮必须type="submit"
        submitHandler:function(form){
            // 获取表单数据
            var data = {};
            $.each($("form").serializeArray(), function (i, field) {
                data[field.name] = field.value;
            });
            // 添加数据
            $.ajax({
                type: 'PUT',
                async: false,
                url: '/sys/user/update.do',
                data: JSON.stringify(data),
                contentType: "application/json;charset=UTF-8",
                success: function (res) {
                    if (res.success){
                        layer.msg('编辑成功',{
                            time: 1000,
                            icon: 6
                        });
                        // 成功后跳转到列表页面
                        setTimeout(function(){
                            location.href = "/web/user/list.shtml";
                        },1000);
                    }else {
                        layer.msg(res.message, {icon: 2});
                    }
                },
                error: function () {
                    layer.msg(res.message, {icon: 5});
                },
                dataType: 'json'
            });
        }
    });
}

$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        }else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"
});

function cancel(){
    location.href = "/web/user/list.shtml";
}