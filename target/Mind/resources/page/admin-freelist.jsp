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
    <title>查看免费名单</title>
    <link rel="stylesheet" href="${webRoot}/resources/layui/css/layui.css" media="all"/>
    <script type="text/javascript" src="${webRoot}/resources/layui/layui.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/jquery-3.4.1/jquery-3.4.1.js"></script>
</head>
<body>

<script>
    function openAddUser() {
        var $ = layui.jquery;
        var layer = layui.layer;
        var table = layui.table;//加载表格模块
        var form = layui.form;
        layer.open({
            type: 1,
            title: '设定分数线',
            content: $("#saveOrUpdateDiv"),
            area: ['400px', '200px'],
            success: function (index) {
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
    <form class="layui-form" >
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">
                    <p1 style="font-size:16px;">姓名：</p1>
                </label>
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
        <th lay-data="{field:'1',align:'center'}">学号</th>
        <th lay-data="{field:'2',align:'center',width:240}">姓名</th>
        <th lay-data="{field:'3',align:'center', sort: true,width:240}">班级</th>
        <th lay-data="{field:'3',align:'center', sort: true,width:150}">选拔赛成绩</th>
        <!-- <th lay-data="{field:'11', toolbar:'#userBar' ,width:250,align:'center', fixed:'right'}">操作</th> -->
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${FreeList}" var="user">
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
		<form class="layui-form " action="https://www.layui.com/demo/layer.html" lay-filter="dataFrm" id="dataFrm">
			<div class="layui-form-item" >
					<label class="layui-form-label" style="color:red">分数线：</label>
					<div class="layui-input-inline">
						<input type="text" name="1"   autocomplete="off"
							class="layui-input">
					</div>
			</div>
			
			<div class="layui-form-item" style="text-align: center;">
		    <div class="layui-input-block">
		      <button type="text" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
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
				,page : true//开启分页
				,toolbar: '#userToolBar'
				,cellMinWidth: 80 //全局定义常规单元格的最小宽度，
				
			});
			
			
			
			
			
		    var url;
			var mainIndex; 
			
			
			
			
			//保存
			/*  form.on("submit(doSubmit)",function(obj){

            //alert(url);
            //这是没得办法，url传不过来
            if(typeof(url)=="undefined"){
                url="https://www.layui.com/demo/layer.html";
            }
            alert(url);
            //序列化表单数据
            var params=$("#dataFrm").serialize();
            $.post(url,params,function(obj){
                //alert(params);
                console.info(params);
                //layer.msg(obj);
                //alert(params);
                //关闭弹出层
                layer.close(mainIndex);
                //刷新数据 表格
                //window.location.href="/market_3x/GoodsServlet?type=goGoods";
                //return false;

            })
        });  */


    });


</script>
</body>
</html>

<!-- 搜索url在38行
设定分数线在79行

-->
