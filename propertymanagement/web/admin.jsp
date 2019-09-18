<%--
  Created by IntelliJ IDEA.
  User: deer
  Date: 2019/9/13
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pers.c.domain.Proprietor" %>
<%@ page import="pers.c.domain.Record" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>admin</title>
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
                    <h3 class="panel-title" style="font-size: 18px;margin-bottom: -4px">管理员&nbsp;&nbsp;&nbsp;
                        <a href="/adminLogout" class="glyphicon glyphicon-log-out"></a>
                    </h3>
                </div>
                <div class="panel-body" style="background-color:#d9edf7 ">
                    <div class="panel-group" id="panel-699485">
                        <div class="panel panel-info" style="background-color:#d9edf7">
                            <div class="panel-heading" style="text-align: center">
                                <a style="background-color: #d9edf7" class="panel-title collapsed"
                                   data-toggle="collapse"
                                   data-parent="#panel-699485" href="#panel-element-822426">缴费管理</a>
                            </div>
                            <div id="panel-element-822426" class="panel-collapse collapse">
                                <div class="panel-body" style="background-color:#d9edf7 ">
                                    <a style="background-color: #d9edf7" href="/findAllRecode?currentPage=${pageBean.currentPage}" class="list-group-item">全部记录</a>
                                    <a style="background-color: #d9edf7" href="#" class="list-group-item"
                                       data-toggle="modal"
                                       data-target="#addRecordModal">增添记录</a>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-info" style="background-color:#d9edf7 ">
                            <div class="panel-heading" style="text-align: center">
                                <a style="background-color: #d9edf7" class="panel-title collapsed"
                                   data-toggle="collapse"
                                   data-parent="#panel-699485" href="#panel-element-915934">用户信息管理</a>
                            </div>
                            <div id="panel-element-915934" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <a style="background-color: #d9edf7" href="/findAllProprietor"
                                       class="list-group-item">全部用户</a>
                                    <a style="background-color: #d9edf7" href="#"
                                       data-toggle="modal"
                                       data-target="#inputPnameModal"
                                       class="list-group-item">
                                        查找用户
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8 column">
            <c:if test="${!empty proprietorList}">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>业主id</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>住址</th>
                        <th>联系电话</th>
                        <th>入住时间</th>
                        <th>修改</th>
                        <th>删除用户</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${proprietorList}" var="proprietor">
                        <tr>
                            <td>${proprietor.p_id}</td>
                            <td>${proprietor.p_name}</td>
                            <td>${proprietor.p_sex}</td>
                            <td>${proprietor.p_addres}</td>
                            <td>${proprietor.p_phonenumber}</td>
                            <td>${proprietor.p_check_in_time}</td>
                            <td>
                                <a href="javascript:void(0);" onclick="updateProprietorInfo('${proprietor.p_id}')">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </a>
                            </td>
                            <td>
                                <a href="javascript:void(0);" onclick="delProprietor('${proprietor.p_id}')">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                </a>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${!empty pageBean}">
                <div>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>缴费id</th>
                            <th>业主id</th>
                            <th>业主姓名</th>
                            <th>缴费时间</th>
                            <th>金额</th>
                            <th>备注</th>
                            <th>修改记录</th>
                            <th>删除记录</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageBean.recordList}" var="recordList">
                            <tr>
                                <td>${recordList.r_id}</td>
                                <td>${recordList.p_id}</td>
                                <td>${recordList.p_name}</td>
                                <td>${recordList.r_time}</td>
                                <td>${recordList.r_money}</td>
                                <td>${recordList.r_remark}</td>
                                <td>
                                    <a href="javascript:void(0);" onclick="updateRcord('${recordList.r_id}')">
                                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                    </a>
                                </td>
                                <td>
                                    <a href="javascript:void(0);" onclick="delRecord('${recordList.r_id}','${pageBean.currentPage}')">
                                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div>
                    <nav aria-label="Page navigation" style="position: absolute;top: 300px;right: 40px">
                        <ul class="pagination">

                            <c:if test="${pageBean.currentPage==1}">

                                <li class="disabled">
                                    <a href="javascript:void(0);" aria-label="Previous">
                                        <span aria-hidden="true">上一页</span></a>
                                </li>
                            </c:if>
                            <c:if test="${pageBean.currentPage!=1}">
                                <li>
                                    <a href="/findAllRecode?currentPage=${pageBean.currentPage-1}" aria-label="Previous">
                                        <span aria-hidden="true">上一页</span></a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${pageBean.totalPage}" var="page">

                                <c:if test="${pageBean.currentPage==page}">
                                    <li class="active"><a href="javascript:void(0);"> ${page} </a></li>
                                </c:if>

                                <c:if test="${pageBean.currentPage!=page}">
                                    <li><a href="/findAllRecode?currentPage=${page}"> ${page} </a></li>
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
                                    <a href="/findAllRecode?currentPage=${pageBean.currentPage+1}" aria-label="Next">
                                        <span aria-hidden="true">下一页</span>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>

            </c:if>
            <c:if test="${!empty allRecord}">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>缴费id</th>
                        <th>业主id</th>
                        <th>业主姓名</th>
                        <th>缴费时间</th>
                        <th>金额</th>
                        <th>备注</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allRecord}" var="record">
                        <tr>
                            <td>${record.r_id}</td>
                            <td>${record.p_id}</td>
                            <td>${record.p_name}</td>
                            <td>${record.r_time}</td>
                            <td>${record.r_money}</td>
                            <td>${record.r_remark}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>
</div>
</div>
<%--添加记录窗口--%>
<div class="container">
    <div id="addRecordModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-content">
            <div class="">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="modal-title">
                        <h2 style="padding-left: 35%">增添缴费记录</h2>
                    </div>
                    <form class="form-group" id="addRecordForm" action="/addRecord" method="POST">
                        <div style="padding-left: 50px">
                            <div class="form-group">
                                <h4><label class="label label-info">请输入业主id(四位)</label></h4>
                                <input class="form-control" type="text" placeholder="Proprietor ID" id="p_id"
                                       name="p_id">
                                <span id="checkPidInfo"></span>
                            </div>
                            <div class="form-group">
                                <h4><label class="label label-info">金额</label></h4>
                                <input class="form-control" type="text" placeholder="￥" id="money"
                                       name="money">

                            </div>
                            <div class=" form-group">
                                <h4><label class="label label-info">备注</label></h4>
                                <input class="form-control" type="text" placeholder="Remark" id="remark"
                                       name="remark">
                            </div>
                        </div>
                        <div class="text-right" style="padding-right: 106px">
                            <button class="btn btn-primary" type="submit" id="addRecord">添加</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%--输入用户姓名窗口--%>
<div class="container">
    <div id="inputPnameModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-content">
            <div class="">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>
                    </button>
                </div>
                <div class="modal-body">
                    <form class="form-group" id="inputPnameForm" action="/findProprietorByname" method="post">
                        <div style="padding-left: 50px">
                            <div class="form-group">
                                <h4><label class="label label-info">请输入业主姓名</label></h4>
                                <input class="form-control" type="text" placeholder="Proprietor Name" id="p_name"
                                       name="p_name" required>
                                <span id="checkPname"></span>
                            </div>
                        </div>
                        <div class="text-right" style="padding-right: 106px">
                            <button class="btn btn-primary" type="submit" id="find">查找</button>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
