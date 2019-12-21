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
    <title>上传考试成绩</title>
    <link rel="stylesheet" href="${webRoot}/resources/layui/css/layui.css">
    <script type="text/javascript" src="${webRoot}/resources/jquery-3.4.1/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${webRoot}/resources/jquery-3.4.1/jquery.form.js"></script>
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
<script type="text/javascript">

    /*  ajax 方式上传文件操作 */
    $(document).ready(function () {
        console.log("ajax上传")
        $("#btn").click(function () {
            if (checkData()) {
                console.log("submit")
                $('#form1').ajaxSubmit({
                    url: '${ctx}/uploadExcel/ajax',
                    dataType: 'text',
                    success: resutlMsg,
                    error: errorMsg
                });

                function resutlMsg(msg) {
                    alert(msg);
                    $("#upfile").val("");
                }

                function errorMsg() {
                    alert("导入excel出错！");
                }
            }
        });
    });

    //JS校验form表单信息
    function checkData() {
        console.log("检查图表")
            var fileDir = $("#upfile").val();
        var suffix = fileDir.substr(fileDir.lastIndexOf("."));
        if ("" == fileDir) {
            alert("选择需要导入的Excel文件！");
            return false;
        }
        if (".xls" != suffix && ".xlsx" != suffix) {
            alert("选择Excel格式的文件导入！");
            return false;
        }
        return true;
    }
</script>

<div class="menu">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>

            <h1 style="color: green"><i class="layui-icon layui-icon-carousel" style="font-size: 100px"></i> 上传考试成绩</h1>
        </legend>
    </fieldset>
</div>

<form class="layui-form" action="">

    <div class="layui-row">
        <!-- 上传考试成绩 -->

        <div class="layui-col-space1" style="height: 100px">

        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">

                <!-- <button type="button" class="layui-btn" id="test1">
                    <i class="layui-icon">&#xe67c;</i>上传考试成绩
                </button> -->

                <form method="POST" enctype="multipart/form-data" id="form1" action="uploadExcel/form">

    <label>上传文件: </label>
    <input id="upfile" type="file" name="upfile"><br> <br>
                    <input type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release"
                           value="确定" id="btn" name="btn">

                </form>

                <!-- https://www.layui.com/doc/modules/upload.html -->

            </div>
        </div>
        <%--        <script src="${webRoot}/static/build/layui.js"></script>--%>
        <!-- </form> -->
        <%--        <script src="../layui/layui.js"></script>--%>

        <!-- 监听是否点击提交 -->
        <%--        <script>--%>
        <%--            //Demo--%>
        <%--            layui.use('form', function () {--%>
        <%--                var form = layui.form;--%>

        <%--                //监听提交--%>
        <%--                form.on('submit(formDemo)', function (data) {--%>
        <%--                    layer.msg(JSON.stringify(data.field));--%>
        <%--                    return false;--%>
        <%--                });--%>
        <%--            });--%>
        <%--        </script>--%>
        <!-- 上传照片 -->
        <!-- <script>
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
        </script> -->
</body>
</html>
