<%--
  Created by IntelliJ IDEA.
  User: deer
  Date: 2019/9/13
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pers.c.domain.Proprietor" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>proprietor</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/messages_zh.js"></script>
    <script src="js/verify_form.js"></script>
    <style>
        tr, td, th {
            text-align: center;
        }

        body {
            background-color: #d9edf7;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="row clearfix" style="margin-top: 50px">
        <div class="col-md-3 column">
            <div class="" style="text-align: center"></div>
        </div>
        <div class="col-md-6 column">
            <div class="" style="text-align: center">
                <h1 style="font-size: 50px">物业管理信息系统</h1>
            </div>
        </div>
        <div class="col-md-3 column">
            <div class="" style="text-align: center"></div>
        </div>
    </div>
    <div class="row clearfix" style="position: relative;top:70px;">
        <div class="col-md-4 column">
            <div class="panel panel-info" style="border: none">
                <div class="panel-heading" style="text-align: center;border-bottom: solid">
                    <h3 class="panel-title" style="font-size: 18px;margin-bottom: -4px">用户&nbsp;&nbsp;&nbsp;
                        <a href="/proprietorLogout" class="glyphicon glyphicon-log-out"></a>
                    </h3>

                </div>
                <div class="panel-body" style="background-color:#d9edf7 ">
                    <div class="list-group">
                        <a style="background-color: #d9edf7" href="/findProprietorById?p_id=${proprietor.p_id}"
                           class="list-group-item">用户信息</a>
                        <a style="background-color: #d9edf7" href="/paging?currentPage=${pageBean.currentPage}"
                           class="list-group-item">查询缴费记录
                        </a>
                        <a style="background-color: #d9edf7" href="#" class="list-group-item" data-toggle="modal"
                           data-target="#changePwdModal">修改密码</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8 column">
            <c:if test="${!empty pinfo}">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>业主id</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>住址</th>
                        <th>联系电话</th>
                        <th>入住时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${pinfo.p_id}</td>
                        <td>${pinfo.p_name}</td>
                        <td>${pinfo.p_sex}</td>
                        <td>${pinfo.p_addres}</td>
                        <td>${pinfo.p_phonenumber}</td>
                        <td>${pinfo.p_check_in_time}</td>
                    </tr>
                    </tbody>
                </table>
            </c:if>


            <c:if test="${!empty pageBean}">
                <div style="height: 120px">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>缴费id</th>
                        <th>缴费时间</th>
                        <th>金额</th>
                        <th>备注</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageBean.recordList}" var="record">
                        <tr>
                            <td>${record.r_id}</td>
                            <td>${record.r_time}</td>
                            <td>${record.r_money}</td>
                            <td>${record.r_remark}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                </div>
                <div style="position: absolute;top: 200px;right: 40px;" >

                    <nav aria-label="Page navigation">
                        <ul class="pagination">

                            <c:if test="${pageBean.currentPage==1}">

                                <li class="disabled">
                                    <a href="javascript:void(0);" aria-label="Previous">
                                        <span aria-hidden="true">上一页</span></a>
                                </li>
                            </c:if>
                            <c:if test="${pageBean.currentPage!=1}">
                                <li>
                                    <a href="/paging?currentPage=${pageBean.currentPage-1}" aria-label="Previous">
                                        <span aria-hidden="true">上一页</span></a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${pageBean.totalPage}" var="page">

                                <c:if test="${pageBean.currentPage==page}">
                                    <li class="active"><a href="javascript:void(0);"> ${page} </a></li>
                                </c:if>

                                <c:if test="${pageBean.currentPage!=page}">
                                    <li><a href="/paging?currentPage=${page}"> ${page} </a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${pageBean.currentPage==pageBean.totalPage}">
                                <li class="disabled">
                                    <a href="javascript:void(0);" aria-label="Next">
                                        <span aria-hidden="true">下一页</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
                                <li>
                                    <a href="/paging?currentPage=${pageBean.currentPage+1}" aria-label="Next">
                                        <span aria-hidden="true">下一页</span>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </c:if>
        </div>
    </div>
</div>
<!-- <%--修改密码窗口--%> -->
<div class="container">
    <div id="changePwdModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-content">
            <div class="">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="modal-title">
                        <h2 style="padding-left: 38%">修改密码</h2>
                    </div>
                    <form class="form-group" id="changePwdForm" action="/updateProprietorPwd" method="POST">
                        <div style="padding-left: 50px">
                            <div class="form-group">
                                <h4><label class="label label-info">请输入原密码</label></h4>
                                <input class="form-control" type="password" placeholder="Old Password " id="old_pwd"
                                       name="old_pwd" required>
                                <span id="checkPwdInfo"></span>
                            </div>
                            <div class="form-group">
                                <h4><label class="label label-info">请输入新密码</label></h4>
                                <input class="form-control" type="password" placeholder="New Password " id="new_pwd"
                                       name="new_pwd" required>
                            </div>
                            <div class="text-right" style="padding-right: 106px">
                                <button class="btn btn-primary" type="submit" id="change">修改</button>
                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>