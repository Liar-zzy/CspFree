<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<c:set var="webRoot" value="<%=basePath%>"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看个人成绩</title>
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
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>

            <h1 style="color: green"><i class="layui-icon layui-icon-carousel" style="font-size: 100px"></i> 查看个人成绩</h1>
        </legend>
    </fieldset>
</div>

<form class="layui-form" action="">

    <div class="layui-row">

        <div class="layui-tab" lay-filter="test1">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="111">第十八次Csp成绩</li>
                <li lay-id="222">第十七次Csp成绩</li>
                <li lay-id="333">第十六次Csp成绩</li>
                <li lay-id="444">第十五次Csp成绩</li>
                <li lay-id="555">第十四次Csp成绩</li>
            </ul>
            <div class="layui-tab-content">


                <div class="layui-tab-item layui-show">

                    <form class="layui-form" action="">
                        <div class="layui-col-space0" style="height: 50px;">
                            <div class="layui-form-item">
                                <label class="layui-form-label">考试成绩：</label>
                                <div class="layui-input-block">
                                    <input type="text" id="cspgrade18" style="width: 400px;" name="title" required
                                           readonly="true"
                                           lay-verify="required"
                                           value="100" autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-col-space0" style="height: 50px;">

                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">平均成绩：</label>
                                <div class="layui-input-block">
                                    <input type="text" id="cspgrade18average" style="width: 400px;" name="title"
                                           required
                                           readonly="true"
                                           lay-verify="required" value="100" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                    </form>
                </div>
                <div class="layui-tab-item">
                    <form class="layui-form" action="">
                        <div class="layui-col-space0" style="height: 50px;">
                            <div class="layui-form-item">
                                <label class="layui-form-label">考试成绩：</label>
                                <div class="layui-input-block">
                                    <input type="text" id="cspgrade17" style="width: 400px;" name="title" required
                                           readonly="true"
                                           lay-verify="required"
                                           value="100" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <c:forEach items="${SESSION_STU}" var="user">
                            <div class="layui-col-space0" style="height: 50px;">

                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">平均成绩：</label>
                                <div class="layui-input-block">
                                    <input type="text" id="cspgrade17average" style="width: 400px;" name="title"
                                           required readonly="true"
                                           lay-verify="required" value="100" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            </c:forEach>
                    </form>
                </div>

                <div class="layui-tab-item">
                    <form class="layui-form" action="">
                        <div class="layui-col-space0" style="height: 50px;">
                            <div class="layui-form-item">
                                <label class="layui-form-label">考试成绩：</label>
                                <div class="layui-input-block">
                                    <input type="text" id="cspgrade16" style="width: 400px;" name="title" required
                                           readonly="true" lay-verify="required"
                                           value="100" autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-col-space0" style="height: 50px;">

                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">平均成绩：</label>
                                <div class="layui-input-block">
                                    <input type="text" id="cspgrade16average" style="width: 400px;" name="title"
                                           required readonly="true"
                                           lay-verify="required" value="100" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                    </form>
                </div>
                <div class="layui-tab-item">
                    <form class="layui-form" action="">
                        <div class="layui-col-space0" style="height: 50px;">
                            <div class="layui-form-item">
                                <label class="layui-form-label">考试成绩：</label>
                                <div class="layui-input-block">
                                    <input type="text" id="cspgrade15" style="width: 400px;" name="title" required
                                           readonly="true" lay-verify="required"
                                           value="100" autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-col-space0" style="height: 50px;">

                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">平均成绩：</label>
                                <div class="layui-input-block">
                                    <input type="text" id="cspgrade15average" style="width: 400px;" name="title"
                                           required readonly="true"
                                           lay-verify="required" value="100" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                    </form>
                </div>
                <div class="layui-tab-item">
                    <form class="layui-form" action="">
                        <div class="layui-col-space0" style="height: 50px;">
                            <div class="layui-form-item">
                                <label class="layui-form-label">考试成绩：</label>
                                <div class="layui-input-block">
                                    <input type="text" id="cspgrade14" style="width: 400px;" name="title" required
                                           readonly="true" lay-verify="required"
                                           value="100" autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-col-space0" style="height: 50px;">

                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">平均成绩：</label>
                                <div class="layui-input-block">
                                    <input type="text" id="cspgrade14average" style="width: 400px;" name="title"
                                           required readonly="true"
                                           lay-verify="required" value="100" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                    </form>
                </div>
            </div>
        </div>


</form>
<script src="../layui/layui.js"></script>

<!-- 监听是否点击提交 -->
<script>
    //Demo
    layui.use('element', function () {
        var element = layui.element;

        //一些事件监听
        element.on('tab(demo)', function (data) {
            console.log(data);
        });
    });
</script>

<!-- 上传照片 -->
<script>
    layui.use('upload', function () {
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,
            url: '/upload/' //上传接口
            ,
            done: function (res) {
                //上传完毕回调
            },
            error: function () {
                //请求异常回调
            }
        });
    });
</script>
</body>
</html>
