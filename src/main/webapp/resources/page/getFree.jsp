<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<c:set var="webRoot" value="<%=basePath%>"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>考试报名</title>
    <script src="${webRoot}/resources/layui/layui.js"></script>
    <link rel="stylesheet" href="${webRoot}/resources/layui/css/layui.css">
    <script type="text/javascript" src="${webRoot}/resources/jquery-3.4.1/jquery-3.4.1.js"></script>
    <style type="text/css">
        .font_ {
            font-size: 30px;
            color: black;
        }

        .register {
            float: right;
            margin-right: 225px;
        }
    </style>
</head>
<body>

<div class="menu">
    <fieldset class="layui-elem-field layui-field-title"
              style="margin-top: 20px;">
        <legend>

            <h1 style="color: green"><i class="layui-icon layui-icon-file-b" style="font-size: 100px"></i> 考试报名</h1>
        </legend>
    </fieldset>
    <form class="layui-form" action="/market_3x/GoodsServlet?type=query" method="post">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">
                    <p1 style="font-size:16px;">考试名称：</p1>
                </label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="input" value="${input }">
                </div>
                <input type="submit" class="layui-btn layui-btn-normal" value="搜索">
            </div>
        </div>
    </form>
</div>
<fieldset class="layui-elem-field layui-field-title"
          style="margin-top: 30px;">

    <legend>考试列表</legend>
</fieldset>
<ul class="layui-timeline">
    <li class="layui-timeline-item"><i
            class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text layui-card">
            <div class="layui-timeline-title layui-card-header">
                <span class="font_">第二十次CCF计算机软件能力认证</span>
                <button type="button" class="layui-btn layui-btn-lg register" id="getFree">
                    <jsp:useBean id="SESSION_USER" scope="session" type="com.ccf.pojo.User"/>
                    <c:set var="isSign" scope="session" value="${SESSION_USER.isSignUp}"/>
                    <c:if test="${isSign == '1'}">
                        已报名
                    </c:if>
                    <c:if test="${isSign != '1'}">
                        认证报名
                    </c:if>
                </button>
            </div>
        </div>
    </li>
    <li class="layui-timeline-item"><i
            class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text layui-card">
            <div class="layui-timeline-title layui-card-header">
                <span class="font_">第十九次CCF计算机软件能力认证</span>
                <button type="button" style="color: #4E5465" class="layui-btn layui-btn-lg register">已截止</button>
            </div>
        </div>
    </li>
    <li class="layui-timeline-item"><i
            class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text layui-card">
            <div class="layui-timeline-title layui-card-header">
                <span class="font_">第十八次CCF计算机软件能力认证</span>
                <button type="button" style="color: #4E5465" class="layui-btn layui-btn-lg register">已截止</button>
            </div>
        </div>
    </li>
    <li class="layui-timeline-item"><i
            class="layui-icon layui-timeline-axis"></i>
        <div class="layui-timeline-content layui-text layui-card">
            <div class="layui-timeline-title layui-card-header">
                <span class="font_">第十七次CCF计算机软件能力认证</span>
                <button type="button" style="color: #4E5465" class="layui-btn layui-btn-lg register">已截止</button>
            </div>
        </div>
    </li>
</ul>

<script src="../layui/layui.js"></script>
<script type="text/javascript">
    //监听事件
    layui.use(['element', 'jquery'], function () {
        var $ = layui.jquery;
        var element = layui.element;

    })
</script>

<script>

    $('#getFree').click(function () {
        <%--console.log("点击getFree")--%>
        <%--var alteredobj={--%>

        <%--}--%>

        <%--$.ajax({--%>
        <%--    url:'${ctx}/user/modify',--%>
        <%--    type:'post',--%>
        <%--    contentType:'application/json',--%>
        <%--    data:JSON.stringify(alteredobj),--%>
        <%--    success:function (data) {--%>
        <%--         if(data.update=="success"){--%>
        <%--         	layer.msg("报名成功")--%>
        <%--         }--%>
        <%--        setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒--%>
        <%--            window.location.reload();//页面刷新--%>
        <%--        },2000);--%>
        <%--    }--%>
        <%--})--%>
        console.log("点击getFree")

        $.ajax({
            type: 'POST',
            url: '${ctx}/user/signUp',
        });


    });
</script>
</body>
</html>