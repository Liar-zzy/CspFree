<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看免费名单</title>
		<link rel="stylesheet" href="../layui/css/layui.css">
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

					<h1 style="color: green"><i class="layui-icon layui-icon-carousel" style="font-size: 100px"></i> 查看免费名单</h1>
				</legend>
			</fieldset>
		</div>
	
		<form class="layui-form" action="">
			<div class="layui-col-space1" style="height: 20px">
				
			</div>
			<div class="layui-row">

			<!-- 输入考试成绩 -->
			<div class="layui-form-item">
				<label class="layui-form-label">免费名额最低分数</label>
				<div class="layui-input-block" style="width:500px">
					<input type="text" name="title" required lay-verify="required" placeholder="请输入免费名额最低分数" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<script src="/static/build/layui.js"></script>


			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" id="upFreeLowGrade" lay-submit lay-filter="formDemo">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
		<div class="layui-col-space1" style="height: 100px;">
		</div>
		<p>此处需要有免费成绩的表单</p>
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
	</body>
</html>
