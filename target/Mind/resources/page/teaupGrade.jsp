<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="webRoot" value="<%=basePath%>"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>上传考试成绩</title>
    <script type="text/javascript" src="${webRoot}/resources/jquery-3.4.1/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="${webRoot}/resources/jquery-3.4.1/jquery.form.js"></script>
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

    <script type="text/javascript">

        /*  ajax 方式上传文件操作 */
        $(document).ready(function(){
            $("#btn").click(function(){ if(checkData()){
                $('#form1').ajaxSubmit({
                    url:'${ctx}/uploadExcel/ajax',
                    dataType: 'text',
                    success: resutlMsg,
                    error: errorMsg
                });
                function resutlMsg(msg){
                    alert(msg);
                    $("#upfile").val("");
                }
                function errorMsg(){
                    alert("导入excel出错！");
                }
            }
            });
        });

        //JS校验form表单信息
        function checkData(){
            var fileDir = $("#upfile").val();
            var suffix = fileDir.substr(fileDir.lastIndexOf("."));
            if("" == fileDir){
                alert("选择需要导入的Excel文件！");
                return false;
            }
            if(".xls" != suffix && ".xlsx" != suffix ){
                alert("选择Excel格式的文件导入！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>

<div class="menu">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>

            <h1 style="color: green"><i class="layui-icon layui-icon-carousel" style="font-size: 100px">

            </i> 上传考试成绩</h1>
        </legend>
    </fieldset>
</div>

<form method="POST"  enctype="multipart/form-data" id="form1" action="uploadExcel/form">

    <label>选择考试成绩文件: </label>
    <input id="upfile" type="file" name="upfile"><br> <br>

    <input type="button" value="确定"
           class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release"  id="btn" name="btn" >

</form>
</body>
</html>