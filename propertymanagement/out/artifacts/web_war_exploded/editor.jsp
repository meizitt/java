<%--
  Created by IntelliJ IDEA.
  User: deer
  Date: 2019/9/16
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>editor</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/messages_zh.js"></script>
    <script src="js/verify_form.js"></script>
    <style>
        body {
            background-color: #d9edf7;
        }</style>
</head>
<body>
<div class="container">
    <div class="row clearfix" style="margin-top: 50px">
        <div class="col-md-3 column">
        </div>
        <div class="col-md-6column">
            <div class="" style="text-align: center">
                <h1 style="font-size: 50px">物业管理信息系统</h1>
            </div>
        </div>
        <div class="col-md-3 column">
        </div>
    </div>
    <div class="row clearfix" style="position: relative;top: 50px;">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <c:if test="${!empty proprietor}">
                <form role="form" id="updatePForm" class="form-group"
                      action="/updateProprietorInfo?p_id=${proprietor.p_id}"
                      method="post">
                    <div>
                        <div>
                            <h4><label class="label label-info">业主姓名</label></h4>
                            <input class="form-control" type="text" placeholder="Username "
                                   id="userRegisterName" name="userRegisterName" value="${proprietor.p_name}">
                        </div>
                        <div>
                            <h4><label class="label label-info">性别</label></h4>
                            <div class="form-group">

                                <span><input type="radio" name="sex" id="m" value="男" checked></span>
                                <span><label class="label label-success">男</label></span>

                                <span><input type="radio" name="sex" id="f" value="女"></span>
                                <span><label class="label label-success">女</label></span>
                                <c:if test="${proprietor.p_sex == '女'}">
                                    <script>
                                        $("#f").attr("checked", "true");
                                    </script>
                                </c:if>
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
                                   placeholder="Phone Number" value="${proprietor.p_phonenumber}">
                        </div>
                        <div>
                            <h4><label class="label label-info">入住时间</label></h4>
                            <input class="form-control" type="date" name="inTime" id="inTime"
                                   value="${proprietor.p_check_in_time}">
                        </div>
                        <div class="text-right" style="margin-top: 15px">
                            <button class="btn btn-primary" type="submit">修改</button>
                            &nbsp;
                            <button class="btn btn-danger" type="button" onclick="goBack()">取消</button>
                        </div>
                    </div>
                </form>
            </c:if>
            <c:if test="${!empty record}">
                <form role="form" class="form-group" id="updateRecordForm"
                      action="/updateRecord?r_id=${record.r_id}&p_id=${record.p_id}" method="post">
                    <div class="form-group">
                        <h4><label class="label label-info">业主id</label></h4>
                        <input class="form-control" type="text" placeholder="Proprietor ID" id="p_id"
                               name="p_id" value="${record.p_id}" disabled="true">
                        <span id="checkPidInfo"></span>
                    </div>
                    <div class="form-group">
                        <h4><label class="label label-info">时间</label></h4>
                        <input class="form-control" type="date" placeholder="￥" id="time"
                               name="time" value="${record.r_time}">
                    </div>
                    <div class="form-group">
                        <h4><label class="label label-info">金额</label></h4>
                        <input class="form-control" type="text" placeholder="￥" id="money"
                               name="money" value="${record.r_money}">

                    </div>
                    <div class=" form-group">
                        <h4><label class="label label-info">备注</label></h4>
                        <input class="form-control" type="text" placeholder="Remark" id="remark"
                               name="remark" value="${record.r_remark}">
                    </div>

                    <div class="text-right" style="margin-top: 15px">
                        <button class="btn btn-primary" type="submit" id="addRecord">修改</button>
                        &nbsp;
                        <button class="btn btn-danger" type="button" onclick="goBack()">取消</button>
                    </div>
                </form>
            </c:if>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</body>
</html>
