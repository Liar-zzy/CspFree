<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="webRoot" value="<%=basePath%>"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看免费名单</title>
    <link rel="stylesheet" href="${webRoot}/resources/layui/css/layui.css" media="all"/>
    <script type="text/javascript" src="${webRoot}/resources/layui/layui.js"></script>
    <script type="text/javascript" src="${webRoot}/resources/jquery-3.4.1/jquery-3.4.1.js"></script>
</head>
<body>

<script>
    function openAddUser() {
        var $ = layui.jquery;
        var layer = layui.layer;
        var table = layui.table;//加载表格模块
        var form = layui.form;
        layer.open({
            type: 1,
            title: '设定条件',
            content: $("#saveOrUpdateDiv"),
            area: ['400px', '200px'],
            success: function (index) {
                $("#dataFrm")[0].reset();
            }
        });
    }
</script>


<!-- 搜索条件开始 -->
<div class="menu">

    <fieldset class="layui-elem-field layui-field-title"
              style="margin-top: 20px;">
        <legend>
            <h1 style="color: green">查看免费名单</h1>
        </legend>
    </fieldset>

    <form class="layui-form" action="${pageContext.request.contextPath}/RedList/insertIntoRedList?name=#searchname">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">
                    <p1 style="font-size:16px;">姓名：</p1>
                </label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="name" id="searchname">
                </div>
                <input type="submit" class="layui-btn layui-btn-danger" value="搜索" id="search">
                <%--                <button class="layui-btn" data-type="reload">搜索</button>--%>
<%--                <button type="button" class="layui-btn" lay-event="add" onclick="openAddUser()">设定免费条件</button>--%>

            </div>
        </div>
    </form>
</div>
<!-- 搜索条件结束 -->

<!-- 数据表格开始 -->
<table lay-filter="demo" id="demo">
    <!-- <div id="userBar" style="display:none;" >
          <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </div> -->
    <thead>
    <tr>
        <th lay-data="{field:'1',align:'center'}">姓名</th>
        <th lay-data="{field:'2',align:'center',width:240}">身份证</th>
        <th lay-data="{field:'3',align:'center', sort: true,width:240}">金额</th>
        <th lay-data="{field:'4',align:'center', sort: true,width:240}">团报码</th>

        <!-- <th lay-data="{field:'11', toolbar:'#userBar' ,width:250,align:'center', fixed:'right'}">操作</th> -->
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${RedList}" var="user">
        <tr>

            <td>${user.name}</td>
            <td>${user.identify}</td>
            <td>${user.money}</td>
            <td>${user.groupCode}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- 数据表格结束 -->
<!-- 添加和修改的弹出层开始 -->
<div style="display: none;padding: 20px" id="saveOrUpdateDiv">
    <form class="layui-form "
          action="${pageContext.request.contextPath}/RedList/insertIntoRedList?num=#numall&score=#score"
          lay-filter="dataFrm" id="dataFrm">
        <div class="layui-form-item">
            <label class="layui-form-label" style="color:red">人数：</label>
            <div class="layui-input-inline">
                <input type="text" name="num" id="numall" autocomplete="off"
                       class="layui-input" value="150">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="color:red">分数：</label>
            <div class="layui-input-inline">
                <input type="text" name="score" id="score" autocomplete="off"
                       class="layui-input" value="300">
            </div>
        </div>

        <div class="layui-form-item" style="text-align: center;">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn layui-btn-normal
		      layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit">提交
                </button>
                <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh">重置
                </button>
            </div>
        </div>
    </form>
</div>

<!-- 添加和修改的弹出层结束 -->
<!-- 渲染数据表格 -->
<script type="text/javascript">
    //静态表格
    layui.use(['jquery', 'layer', 'form', 'table'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var table = layui.table;//加载表格模块
        var form = layui.form;

        table.init('demo', {
            id: 'demo'
            , height: 'funll-300' //设置高度
            , page: true//开启分页
            , toolbar: '#userToolBar'
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，

        });
    });

</script>
</body>
</html>