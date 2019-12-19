<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html class="loginHtml">
<head>
	<meta charset="utf-8">
	<title>Csp-Free</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="icon" href="../../favicon.ico">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../../css/public.css" media="all" />
</head>
<body class="loginBody">
	<form class="layui-form">
		<div class="login_face"><img src="../../images/face.jpg" class="userAvatar"></div>
		<div class="layui-form-item input-item">
			<label for="userName">用户名</label>
			<input type="text" placeholder="请输入用户名" autocomplete="off" id="userName" class="layui-input" lay-verify="required">
		</div>
		<div class="layui-form-item input-item">
			<label for="password">密码</label>
			<input type="password" placeholder="请输入密码" autocomplete="off" id="password" class="layui-input" lay-verify="required">
		</div>
		<div class="layui-form-item input-item" id="imgCode">
			<label for="code">验证码</label>
			<input type="text" placeholder="请输入验证码" autocomplete="off" id="code" class="layui-input">
			<img src="../../images/code.jpg">
		</div>
		<div class="layui-form-item">

			<button class="layui-btn layui-block" lay-filter="login" lay-submit id="login">登录</button>

		</div>
		<div class="layui-form-item layui-row">
			<a href="javascript:;" class="seraph icon-qq layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
			<a href="javascript:;" class="seraph icon-wechat layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
			<a href="javascript:;" class="seraph icon-sina layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
		</div>
	</form>
	<script type="text/javascript" src="../../layui/layui.js"></script>
	<script type="text/javascript" src="login.js"></script>
	<script type="text/javascript" src="../../js/cache.js"></script>
</body>
<script src="../../jquery-3.4.1/jquery-3.4.1.js"></script>
<script>
	layui.use(['layer', 'form', 'element'], function(){
		var layer = layui.layer
				,form = layui.form
				,element = layui.element
		window.test = function(){
			//JS代码
		}
	});
	$('#login').click(function () {

		var name=$('input[id=userName]').val();
		var password=$('input[id=password]').val();

		var obj={
			id:name,
			password:password
		}
		console.log(obj)
		$.ajax({
			url:'${ctx}/user/login',
			type:'post',
			contentType:'application/json',
			data:JSON.stringify(obj),
			success:function (data) {
				console.log(data)
				if(data.logincheck=="success"){
					layer.msg('登录成功');
					window.setTimeout( function(){}, 2 * 1000 );
					window.location.href="../../index.jsp";
				}
				else{

					layer.msg('账号密码错误');
					setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
						window.location.reload();//页面刷新
					},2000);

					$('input[id=login_username]').val("");
					$('input[id=login_password]').val("");

				}
			}

		})

	});
</script>

</html>