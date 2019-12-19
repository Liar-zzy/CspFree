<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>个人中心</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../../css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-row">
	<div class="layui-col-md6 layui-col-xs12">
		<div class="layui-form-item">
			<label class="layui-form-label">ID</label>
			<div class="layui-input-block">
				<input type="text" value="${SESSION_USER.id}" disabled class="layui-input layui-disabled" readonly="true">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-block">
				<input type="text" value="${SESSION_USER.name}" disabled class="layui-input layui-disabled" readonly="true">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户身份</label>
			<div class="layui-input-block">
				<input type="text" value="${SESSION_USER.role}" disabled class="layui-input layui-disabled" readonly="true">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">身份证号</label>
			<div class="layui-input-block">
				<input type="tel" value="${SESSION_USER.identify}"  lay-verify="phone" class="layui-input userPhone" readonly="true">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号码</label>
			<div class="layui-input-block">
				<input type="tel" value="${SESSION_USER.phone}" s lay-verify="phone" class="layui-input userPhone">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-block">
				<input type="text" value="${SESSION_USER.email}"  lay-verify="email" class="layui-input userEmail">
			</div>
		</div>
		
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="changeUser">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript" src="../../layui/layui.js"></script>
<script type="text/javascript" src="userInfo.js"></script>
<script type="text/javascript" src="../../js/cacheUserInfo.js"></script>
</body>
</html>