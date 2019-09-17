$(function () {
    $("#userLoginForm").validate({
        rules: {
            userLoginName: {
                required: true
            },
            userLoginPwd: {
                required: true
            }
        },
        messages: {
            userLoginName: {
                required: "请输入业主账户名"
            },
            userLoginPwd: {
                required: "请输入密码"
            }
        }
    });
    $("#adminLoginForm").validate({
        rules: {
            adminName: {
                required: true
            },
            adminPwd: {
                required: true
            }
        },
        messages: {
            adminName: {
                required: "管理员名不能为空"
            },
            adminPwd: {
                required: "请输入密码"
            }
        }
    });
    $("#userRegisterForm,#updatePForm").validate({
        rules: {
            userRegisterName: {
                required: true,
                rangelength: [2, 6]
            },
            userRegisterPwd: {
                required: true,
                minlength: 6
            },
            userConfirmPwd: {
                required: true,
                equalTo: "#userRegisterPwd"
            },
            phoneNumber: {
                required: true,
                minlength: 11,
                isMobile: true
            }
        },
        messages: {
            userRegisterName: {
                required: "请输入业主姓名",
                rangelength: "业主名应在2~6个汉字之内"
            },
            userRegisterPwd: {
                required: "请输入密码",
                minlength: "密码至少6位"
            },
            userConfirmPwd: {
                required: "请确认密码",
                equalTo: "两次密码不一致，请重新输入"
            },
            phoneNumber: {
                required: "请输入手机号码",
                minlength: "请输入正确的手机号码",
                isMobile: "请输入正确的手机号码"
            }
        }
    });
    $("#addRecordForm,#updateRecordForm").validate({
        rules: {
            money: {
                required: true,
                number: true
            },
            p_id: {
                required: true
            }
        },
        messages: {
            money: {
                required: "请输入金额",
                number: "请输入数字"
            },
            p_id: {
                required: "请输入业主ID"
            }
        }

    });

    $("#p_id").blur(function () {
        var p_id = $(this).val();
        $.post(
            "/adminFindPById",
            {"p_id": p_id},
            function (data) {
                var isExist = data.isExist;
                var checkPidInfo = "";
                if (isExist) {
                    $("#addRecord").prop('disabled', false);
                    $("#checkPidInfo").css("color", "#008B45");
                    checkPidInfo = "";
                }
                else {
                    $("#addRecord").prop('disabled', true);
                    $("#checkPidInfo").css("color", "red");
                    checkPidInfo = "用户不存在";
                }
                $("#checkPidInfo").html(checkPidInfo);
            },
            "json"
        );
    });
    $("#p_name").blur(function () {
        var p_name = $(this).val();
        p_name=encodeURI(p_name);
        $.post(
            "/findProprietorByName",
            {"p_name": p_name},
            function (data) {
                var isExist = data.isExist;
                var checkPname = "";
                if (!isExist) {
                    $("#find").prop('disabled', true);
                    $("#checkPname").css("color", "red");
                    checkPname = "用户不存在";
                }
                $("#checkPname").html(checkPname);
            },
            "json"
        );
    });

    $("#old_pwd").blur(function () {
        var old_pwd = $(this).val();
        $.post(
            "/checkPwd",
            {"old_pwd": old_pwd},
            function (data) {
                var is_true = data.is_true;
                var checkPwdInfo = "";
                if (is_true) {
                    $("#change").prop('disabled', false);
                    $("#checkPwdInfo").css("color", "#008B45");
                    checkPwdInfo = "密码正确";
                }
                else {
                    $("#change").prop('disabled', true);
                    $("#checkPwdInfo").css("color", "red");
                    checkPwdInfo = "密码错误，请重新输入";
                }
                $("#checkPwdInfo").html(checkPwdInfo);
            },
            "json"
        );
    });
    $("#imgText").blur(function () {
        var imgText = $(this).val();
        $.post(
            "/checkImgText",
            {"imgText": imgText},
            function (data) {
                var isTrue = data.isTrue;
                var checkImgInfo = "";
                if (isTrue) {
                    $("#login").prop('disabled', false);
                    $("#checkImgInfo").css("color", "#008B45");
                    // checkImgInfo = "验证码正确";
                }
                else {
                    $("#checkImgInfo").css("color", "red");
                    checkImgInfo = "验证码错误，请重新输入";
                }

                $("#checkImgInfo").html(checkImgInfo);
            },
            "json"
        );
    });
})

// 验证手机号码
$.validator.addMethod("isMobile", function (value, element) {
    var length = value.length;
    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写手机号码")

function changeImg() {
    $("#imgCode").attr("src", "/checkImg?time=" + new Date().getTime());
    $("#checkImgInfo").html("");
    $("#imgText").html("");
}

function delProprietor(p_id) {
    var isDel = confirm("确定要删除吗？");
    if (isDel) {
        location.href = "/deleteProprietorById?p_id=" + p_id;
    }
}

function delRecord(r_id) {
    var isDel = confirm("确定要删除吗？");
    if (isDel) {
        location.href = "/delRecordByRid?r_id=" + r_id;
    }
}

function updateProprietorInfo(p_id) {
    location.href = "/adminFindPByPid?p_id=" + p_id;
}

function updateRcord(r_id) {
    location.href = "/findRecordById?r_id=" + r_id;
}

function goBack() {
    window.history.go(-1);
}

