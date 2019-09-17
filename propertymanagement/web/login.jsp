<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>社区物业管理系统</title>
    <%--<!-- Bootstrap -->--%>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <%--<!-- jQuery -->--%>
    <script src="js/jquery-3.4.1.js"></script>
    <%--<!-- Bootstrap 的所有 JavaScript 插件 -->--%>
    <script src="js/bootstrap.min.js"></script>
    <%--<!-- 表单验证和验证中文化 -->--%>
    <script src="js/jquery.validate.js"></script>
    <script src="js/messages_zh.js"></script>
    <script src="js/verify_form.js"></script>

    <style>
        input[type="number"],
        input[type="date"],
        input[type="text"],
        input[type="password"] {
            padding-left: 20px;
            width: 80%;
        }

        .center {
            text-align: center;

        }
        body{
            background-color: #d9edf7;
        }
    </style>

</head>

<body>
<div>
    <div class="container">
        <div class="row clearfix" style="margin-top: 70px">
            <div class="col-md-3 column">
            </div>
            <div class="col-md-6 column">
                <div style="text-align: center">
                    <h1 style="font-size: 50px">社区物业管理信息系统</h1>
                </div>
            </div>
            <div class="col-md-3 column">
            </div>
        </div>
        <div class="row clearfix" style="position: relative;top:70px;">
            <div class="col-md-4 column">
            </div>
            <div class="col-md-4 column">
                <div class="center">
                    <div class="panel panel-info" style="border: none">
                        <div class="panel-heading" style="border-bottom: solid">
                            <h2 class="panel-title" style="font-size: 20px">社区管理员</h2>
                        </div>
                        <div class="panel-body" style="background-color: #D9EDF7">
                            <button class="btn btn-default btn-lg" data-toggle="modal" data-target="#adminModal"
                            style="background-color: #D9EDF7">
                                登录
                            </button>
                        </div>
                    </div>
                </div>

                <div class="center">
                    <div class="panel panel-info" style="border: none">
                        <div class="panel-heading" style="border-bottom: solid">
                            <h2 class="panel-title" style="font-size: 20px">社区业主</h2>
                        </div>
                        <div class="panel-body" style="background-color: #D9EDF7;border: none">
                        <span>
                            <button type="button" class="btn btn-default btn-lg" data-toggle="modal"
                                    data-target="#userLoginModal" style="background-color: #D9EDF7">登录</button>
                        </span>
                            <span>
                            <button type="button" class="btn btn-default btn-lg" data-toggle="modal"
                                    data-target="#userRegisterModal" style="background-color: #D9EDF7">注册</button>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4 column">
            </div>
        </div>
    </div>
</div>
<%--<!-- 管理员登录窗口 -->--%>
<div class="container">
    <div id="adminModal" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="modal-title">
                        <h2 style="padding-left: 34%">管理员登录</h2>
                    </div>
                    <form class="form-group" id="adminLoginForm" action="/findAdmin" method="post">
                        <div style="padding-left: 50px">
                            <div class="form-group">
                                <h4><label class="label label-info">管理员名</label></h4>
                                <input class="form-control" type="text" placeholder="Administrator account "
                                       id="adminName" name="adminName">
                            </div>
                            <div class="form-group">
                                <h4><label class="label label-info">密码</label></h4>
                                <input class="form-control" type="password" placeholder="Password" id="adminPwd"
                                       name="adminPwd">
                            </div>
                            <div class="form-group">
                                <span><label class="label label-info" style="font-size: 14px">验证码</label></span>
                                <span>
                                    <img src="/checkImg" alt="" id="imgCode" name="imgCode">
                                    <span id="checkImgInfo"></span>
                                    <span class="glyphicon glyphicon-repeat" aria-hidden="true"
                                          onclick="changeImg()"></span>
                                </span>
                                <input type="text" class="form-control" id="imgText" name="imgText"
                                       placeholder="Verification Code" required>

                            </div>
                            <div class="text-right" style="padding-right: 106px">
                                <button class="btn btn-primary" type="submit" id="login">登录</button>
                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <a style="text-decoration-line: none" href="" data-toggle="modal" data-dismiss="modal"
                       data-target="">忘记密码？</a>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<!-- 用户登录窗口 -->--%>
<div class="container">
    <div id="userLoginModal" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="modal-title">
                        <h2 style="padding-left: 34%">业主登录</h2>
                    </div>
                    <form class="form-group" id="userLoginForm" action="/findProprietor" method="post">
                        <div style="padding-left: 50px">
                            <div class="form-group">
                                <h4><label class="label label-info">业主账户名</label></h4>
                                <input class="form-control" type="text" placeholder="Username " id="userLoginName"
                                       name="userLoginName">
                            </div>
                            <div class="form-group">
                                <h4><label class="label label-info">密码</label></h4>
                                <input class="form-control" type="password" placeholder="Password" id="userLoginPwd"
                                       name="userLoginPwd">
                            </div>
                            <div class="text-right" style="padding-right: 106px">
                                <button class="btn btn-primary" type="submit">登录</button>
                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <a style="text-decoration-line: none" href="" data-toggle="modal" data-dismiss="modal"
                       data-target="">忘记密码？</a>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<!-- 用户注册窗口 -->--%>
<div class="container">
    <div id="userRegisterModal" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="modal-title">
                        <h2 style="padding-left: 34%">业主注册</h2>
                    </div>
                    <form class="form-group" action="/addProprietor" method="post" id="userRegisterForm">
                        <div>
                            <div>
                                <h4><label class="label label-info">业主姓名</label></h4>
                                <input class="form-control" type="text" placeholder="Username "
                                       id="userRegisterName" name="userRegisterName">
                            </div>
                            <div>
                                <h4><label class="label label-info">密码</label></h4>
                                <input class="form-control" type="password" name="userRegisterPwd"
                                       id="userRegisterPwd" placeholder="Password">
                            </div>
                            <div>
                                <h4><label class="label label-info">确认密码</label></h4>
                                <input class="form-control" type="password" name="userConfirmPwd"
                                       id="userConfirmPwd" placeholder="Confirm Password">
                            </div>
                            <div>
                                <h4><label class="label label-info">性别</label></h4>
                                <div class="form-group">
                                    <span><input type="radio" name="sex" id="m" value="男" checked></span>
                                    <span><label class="label label-success">男</label></span>
                                    <span><input type="radio" name="sex" id="f" value="女"></span>
                                    <span><label class="label label-success">女</label></span>
                                </div>
                            </div>
                            <div>
                                <h4><label class="label label-info">住址</label></h4>
                                <div>
                                        <span>
                                            <select class="form-group" style="width: 65px" name="dong" id="dong">
                                                <option class="form-group" value="1">01</option>
                                                <option class="form-group" value="2">02</option>
                                                <option class="form-group" value="3">03</option>
                                                <option class="form-group" value="4">04</option>
                                            </select>
                                        </span>
                                    <span><label class="label label-success ">栋</label></span>
                                    <span>
                                            <select class="form-group" style="width: 65px" name="danyuan" id="danyuan">
                                                <option class="form-group" value="1">1</option>
                                                <option class="form-group" value="2">2</option>
                                                <option class="form-group" value="3">3</option>
                                            </select>
                                        </span>
                                    <span><label class="label label-success ">单元</label> </span>
                                    <span>
                                            <select class="form-group" style="width: 65px" name="lou" id="lou">
                                                <option class="form-group" value="">1</option>
                                                <option class="form-group" value="">2</option>
                                                <option class="form-group" value="">3</option>
                                                <option class="form-group" value="">5</option>
                                                <option class="form-group" value="">6</option>
                                            </select>
                                        </span>
                                    <span> <label class="label label-success">楼</label> </span>
                                    <span>
                                            <select class="form-group" style="width: 65px" name="shi" id="shi">
                                                <option class="form-group" value="1">1</option>
                                                <option class="form-group" value="2">2</option>
                                            </select>
                                        </span>
                                    <span><label class="label label-success">室</label> </span>
                                </div>
                            </div>
                            <div>
                                <h4><label class="label label-info">联系电话</label></h4>
                                <input class="form-control" type="number" name="phoneNumber" id="phoneNumber"
                                       placeholder="Phone Number">
                            </div>
                            <div>
                                <h4><label class="label label-info">入住时间</label></h4>
                                <input class="form-control" type="date" name="inTime" id="inTime">
                            </div>
                            <div class="text-center" style="margin-top: 25px;padding-right: 60px">
                                <button class="btn btn-primary" type="submit">注册</button>
                                <span>&nbsp;&nbsp;&nbsp;</span>
                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer"></div>
            </div>
        </div>
    </div>
</div>
</body>

</html>