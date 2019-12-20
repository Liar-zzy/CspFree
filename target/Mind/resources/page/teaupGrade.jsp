<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="webRoot" value="<%=basePath%>" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>上传考试成绩</title>
		<link rel="stylesheet" href="${webRoot}/resources/layui/css/layui.css">
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

					<h1 style="color: green"><i class="layui-icon layui-icon-carousel" style="font-size: 100px"></i> 上传考试成绩</h1>
				</legend>
			</fieldset>
		</div>

		<form class="layui-form" action="">

			<div class="layui-row">

			<!-- 选择考试场次 -->
			<!-- <div class="layui-form-item">
				<label class="layui-form-label" >考试场次</label>
				<div class="layui-input-block" style="width:500px">
					<select name="city" lay-verify="required" >
						<option value=""></option>
						<option value="0">第18次CCF</option>
						<option value="1">第17次CCF</option>
						<option value="2">第16次CCF</option>
						<option value="3">第15次CCF</option>
						<option value="4">第14次CCF</option>
					</select>
				</div>
			</div> -->

			<!-- 输入考试成绩 -->
			<!-- <div class="layui-form-item">
				<label class="layui-form-label">考试成绩</label>
				<div class="layui-input-block" style="width:500px">
					<input type="text" name="title" required lay-verify="required" placeholder="请输入考试成绩" autocomplete="off" class="layui-input">
				</div>
			</div> -->

			<!-- 上传考试成绩 -->
			
			<div class="layui-col-space1" style="height: 100px">
				
			</div>
			
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="button" class="layui-btn" id="test1">
						<i class="layui-icon">&#xe67c;</i>上传考试成绩
					</button>
					
					<!-- https://www.layui.com/doc/modules/upload.html -->
					
				</div>
			</div>
			<script src="${webRoot}/static/build/layui.js"></script>
		<!-- </form> -->
		<script src="../layui/layui.js"></script>

		<!-- 监听是否点击提交 -->
		<script>
			//Demo
			layui.use('form', function() {
				var form = layui.form;

				//监听提交
				form.on('submit(formDemo)', function(data) {
					layer.msg(JSON.stringify(data.field));
					return false;
				});
			});
		</script>

		<!-- 上传照片 -->
		<script>
			layui.use('upload', function() {
				var upload = layui.upload;

				//执行实例
				var uploadInst = upload.render({
					elem: '#test1' //绑定元素
						,
					url: '/upload/' //上传接口
						,
					done: function(res) {
						//上传完毕回调
					},
					error: function() {
						//请求异常回调
					}
				});
			});
		</script>
	</body>
</html>
