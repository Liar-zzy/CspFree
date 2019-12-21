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
    <title>录入考试成绩</title>
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

            <h1 style="color: green"><i class="layui-icon layui-icon-carousel" style="font-size: 100px"></i> 录入考试成绩</h1>
        </legend>
    </fieldset>
</div>

<form class="layui-form" >
    <div class="layui-col-space1" style="height: 100px">

    </div>
    <div class="layui-row">

        <!-- 选择考试场次 -->
        <div class="layui-form-item">
            <label class="layui-form-label">考试场次</label>
            <div class="layui-input-block" style="width:500px">
                <select name="city" lay-verify="required" id="session">
                    <option value=""></option>
                    <option value="19">第19次CCF</option>
                    <option value="18">第18次CCF</option>
                    <option value="17">第17次CCF</option>
                    <option value="16">第16次CCF</option>
                    <option value="15">第15次CCF</option>
                </select>
            </div>
        </div>

        <!-- 输入考试成绩 -->
        <div class="layui-form-item">
            <label class="layui-form-label">总分</label>
            <div class="layui-input-block" style="width:500px">
                <input type="text" name="title" required lay-verify="required" id="grade" placeholder="请输入总分" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

		<div class="layui-form-item">
			<label class="layui-form-label">第一题</label>
			<div class="layui-input-block" style="width:500px">
				<input type="text" name="title" required lay-verify="required" id="first" placeholder="请输入第一题" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">第二题</label>
			<div class="layui-input-block" style="width:500px">
				<input type="text" name="title" required lay-verify="required" id="second" placeholder="请输入第二题" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">第三题</label>
			<div class="layui-input-block" style="width:500px">
				<input type="text" name="title" required lay-verify="required" id="third" placeholder="请输入第三题" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">第四题</label>
			<div class="layui-input-block" style="width:500px">
				<input type="text" name="title" required lay-verify="required" id="fourth" placeholder="请输入第四题" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">第五题</label>
			<div class="layui-input-block" style="width:500px">
				<input type="text" name="title" required lay-verify="required" id="fifth" placeholder="请输入第五题" autocomplete="off" class="layui-input">
			</div>
		</div>
        <!-- 上传考试凭证 -->
<%--        <div class="layui-form-item">--%>
<%--            <div class="layui-input-block">--%>
<%--                <button type="button" class="layui-btn" id="test1">--%>
<%--                    <i class="layui-icon">&#xe67c;</i>上传考试凭证--%>
<%--                </button>--%>

<%--                <!-- https://www.layui.com/doc/modules/upload.html -->--%>

<%--            </div>--%>
<%--        </div>--%>
<%--        <script src="/static/build/layui.js"></script>--%>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" id="submitGrade" >立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
</form>
<script src="${webRoot}/resources/layui/layui.js"></script>

<!-- 监听是否点击提交 -->
<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;

        // //监听提交
        // form.on('submit(formDemo)', function (data) {
        //
        //
        // });
    });
</script>

<!-- 上传照片 -->
<script>
    $('#submitGrade').click(function () {

        var session =$('#session').val();
        var grade = $('#grade').val();
        var first = $('#first').val();
        var second = $('#second').val();
        var third = $('#third').val();
        var fourth = $('#fourth').val();
        var fifth = $('#fifth').val();

        var obj = {
            session:session,
            grade:grade,
            first:first,
            second:second,
            third:third,
            fourth:fourth,
            fifth:fifth,
        }


        alert('上传成功');



        $.ajax({
            url:'${ctx}/uploadExcel/upGrade',
            type:'post',
            contentType:'application/json',
            data:JSON.stringify(obj),
            success:function (data) {

                console.log(data)
                if(data.upGrade=="success"){
                    layer.msg('上传成功');
                    setTimeout(function(){
                    },2000);
                }

            }

        })

    })
</script>
</body>
</html>
