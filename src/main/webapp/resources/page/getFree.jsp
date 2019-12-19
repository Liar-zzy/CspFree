<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考试报名</title>
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
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>
					  
				<h1 style="color: green"><i class="layui-icon layui-icon-file-b" style="font-size: 100px"></i> 考试报名</h1>
			</legend>
		</fieldset>
		<form class="layui-form" action="/market_3x/GoodsServlet?type=query" method="post" >
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label"><p1 style="font-size:16px;">考试名称：</p1></label>
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
			class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text layui-card">
				<div class="layui-timeline-title layui-card-header">
					<span class="font_">第十八次CCF计算机软件能力认证</span>
					<button type="button" class="layui-btn layui-btn-lg register">认证报名</button>
				</div>
			</div></li>
		<li class="layui-timeline-item"><i
			class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text layui-card">
				<div class="layui-timeline-title layui-card-header">
					<span class="font_">第十八次CCF计算机软件能力认证</span>
					<button type="button" class="layui-btn layui-btn-lg register">认证报名</button>
				</div>
			</div></li>
		<li class="layui-timeline-item"><i
			class="layui-icon layui-timeline-axis"></i>
			<div class="layui-timeline-content layui-text layui-card">
				<div class="layui-timeline-title layui-card-header">
					<span class="font_">第十八次CCF计算机软件能力认证</span>
					<button type="button" class="layui-btn layui-btn-lg register">认证报名</button>
				</div>
			</div></li>
	</ul>

	<script src="../layui/layui.js"></script>
	<script type="text/javascript">
		//监听事件
		layui.use([ 'element', 'jquery' ], function() {
			var $ = layui.jquery;
			var element = layui.element;

		})
	</script>
</body>
</html>