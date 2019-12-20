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
<title>查看免费名单</title>
<link rel="stylesheet" href="${webRoot}/resources/layui/css/layui.css" media="all" />
<script type="text/javascript" src="${webRoot}/resources/layui/layui.js"></script>
</head>
<body>	
 		
	<script>
	  function openAddUser(){
		  var $ = layui.jquery;
			var layer = layui.layer;
			var table = layui.table;//加载表格模块
			var form =layui.form;
	    layer.open({
	    	type:1,
			title:'设定分数线',
			content:$("#saveOrUpdateDiv"),
			area:['400px','200px'],
			success:function(index){
				$("#dataFrm")[0].reset();
			}
	    });
	}   
	</script>
	
	<!-- 搜索条件开始 -->
	<div class="menu">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 20px;">
			<legend>
				<h1 style="color: green">查看免费名单</h1>
			</legend>
		</fieldset>
		<form class="layui-form" action="https://www.baidu.com/" method="post" >
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label"><p1 style="font-size:16px;">姓名：</p1></label>
					<div class="layui-input-inline">
						<input class="layui-input" name="input" value="${input}">
					</div>
					<input type="submit" class="layui-btn layui-btn-danger" value="搜索">
					<button type="button" class="layui-btn" lay-event="add" onclick="openAddUser()">设定免费人数(默认150)</button>
				</div>
			</div>
		</form>
	</div>
	<!-- 搜索条件结束 -->
	
	<!-- 数据表格开始 -->
	<table lay-filter="demo" id="demo">
		<!-- <div id="userBar" style="display:none;" >
	 	 	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</div> -->
		<thead>
			<tr>
				<th lay-data="{field:'1',align:'center'}" >学号</th>
				<th lay-data="{field:'2',align:'center',width:240}">姓名</th>
				<th lay-data="{field:'3',align:'center', sort: true,width:240}">班级</th>
				<th lay-data="{field:'3',align:'center', sort: true,width:150}">选拔赛成绩</th>
				<!-- <th lay-data="{field:'11', toolbar:'#userBar' ,width:250,align:'center', fixed:'right'}">操作</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${FreeList}" var="user" >
				<tr>

					<td>${user.sid}</td>
					<td>${user.name}</td>
					<td>${user.classNom}</td>
					<td>${user.rank}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 数据表格结束 -->
	<!-- 添加和修改的弹出层开始 -->
	<div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
		<form class="layui-form " action="https://www.baidu.com/" >
			<div class="layui-form-item" hidden="true">
					<label class="layui-form-label" style="color:red">ID：</label>
					<div class="layui-input-inline">
						<input type="text" name="1"   autocomplete="off"
							class="layui-input">
					</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label" style="color:red">分数线:</label>
					<div class="layui-input-inline">
						<input type="text" name="5"  lay-verify="required|number" autocomplete="off"
							class="layui-input">
					</div>
				</div>
			</div>

			<div class="layui-form-item" style="text-align: center;">
		    <div class="layui-input-block">
		      <button type="submit" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
		      <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
		    </div>
		  </div>
		</form>
	</div>
	
  	
	<!-- 添加和修改的弹出层结束 -->
	<!-- 渲染数据表格 -->
	<script type="text/javascript">
		//静态表格
		layui.use([ 'jquery', 'layer', 'form', 'table' ], function() {
			var $ = layui.jquery;
			var layer = layui.layer;
			var table = layui.table;//加载表格模块
			var form =layui.form;
			
			table.init('demo', {
				id: 'demo'
				,height : 'funll-300' //设置高度
				,width:595
				,page : true//开启分页
				/* ,toolbar: '#userToolBar' */
				,cellMinWidth: 80 //全局定义常规单元格的最小宽度，
				
			});
			
		 
			
		 	
		});
		
		
	</script>
</body>
</html>


<!-- 说明
	1.所有注释了代码是多余的功能，可以删掉
	2.“搜索”按钮是一个form表单，改38行的action即可
	3."设立分数线也是一个action"，在111行
	4.服务端接收表单数据  注意看name的值，我是用数字标号了
	5.循环显示：去掉静态数据，打开for each循环即可


 -->

