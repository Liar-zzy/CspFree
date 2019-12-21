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
    <title>查看个人成绩</title>
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

            <h1 style="color: green"><i class="layui-icon layui-icon-carousel" style="font-size: 100px"></i> 查看个人成绩</h1>
        </legend>
    </fieldset>
</div>


<div class="layui-tab" lay-filter="test1">
    <ul class="layui-tab-title">
        <li class="layui-this" lay-id="111">第十九次Csp成绩</li>
        <li lay-id="222">第十八次Csp成绩</li>
        <li lay-id="333">第十七次Csp成绩</li>
        <li lay-id="444">第十六次Csp成绩</li>
        <li lay-id="555">第十五次Csp成绩</li>
    </ul>
    <div class="layui-tab-content">

        <div class="layui-tab-item layui-show">


            <table lay-filter="demo" id="demo">
                <!-- <div id="userToolBar" style="display:none;" >
                      <button type="button" class="layui-btn" lay-event="add" >添加用户</button>
                </div> -->
                <%--				<div id="userBar" style="display:none;">--%>
                <%--					<a class="layui-btn layui-btn-xs" lay-event="edit">重置密码</a>--%>
                <%--					<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
                <%--				</div>--%>
                <thead>
                <tr>
					<th lay-data="{field:'1',align:'center'}">总分</th>
					<th lay-data="{field:'2',align:'center'}">第一题</th>
					<th lay-data="{field:'3',align:'center'}">第二题</th>
					<th lay-data="{field:'4',align:'center'}">第三题</th>
					<th lay-data="{field:'5',align:'center'}">第四题</th>
					<th lay-data="{field:'6',align:'center'}">第五题</th>
                    <%--					<th lay-data="{field:'7', toolbar:'#userBar' ,width:200,align:'center', fixed:'right'}">操作</th>--%>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ListSelfGrade}" var="user">
                    <c:if test="${user.session ==19}">
                        <tr>
							<td>${user.grade}</td>
                            <td>${user.first}</td>
                            <td>${user.second}</td>
                            <td>${user.third}</td>
                            <td>${user.fourth}</td>
                            <td>${user.fifth}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>

        </div>
        <div class="layui-tab-item">
            <table lay-filter="demo" id="demo1">
                <!-- <div id="userToolBar" style="display:none;" >
                      <button type="button" class="layui-btn" lay-event="add" >添加用户</button>
                </div> -->
                <%--				<div id="userBar" style="display:none;">--%>
                <%--					<a class="layui-btn layui-btn-xs" lay-event="edit">重置密码</a>--%>
                <%--					<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
                <%--				</div>--%>
                <thead>
                <tr>
					<th lay-data="{field:'1',align:'center'}">总分</th>
					<th lay-data="{field:'2',align:'center'}">第一题</th>
					<th lay-data="{field:'3',align:'center'}">第二题</th>
					<th lay-data="{field:'4',align:'center'}">第三题</th>
					<th lay-data="{field:'5',align:'center'}">第四题</th>
					<th lay-data="{field:'6',align:'center'}">第五题</th>
                    <%--					<th lay-data="{field:'7', toolbar:'#userBar' ,width:200,align:'center', fixed:'right'}">操作</th>--%>
                </tr>
                </thead>
                <tbody>
				<c:forEach items="${ListSelfGrade}" var="user">
					<c:if test="${user.session ==18}">
						<tr>
							<td>${user.grade}</td>
							<td>${user.first}</td>
							<td>${user.second}</td>
							<td>${user.third}</td>
							<td>${user.fourth}</td>
							<td>${user.fifth}</td>
						</tr>
					</c:if>
				</c:forEach>
                </tbody>
            </table>
        </div>
        <div class="layui-tab-item">
            <table lay-filter="demo" id="demo2">
                <!-- <div id="userToolBar" style="display:none;" >
                      <button type="button" class="layui-btn" lay-event="add" >添加用户</button>
                </div> -->
                <%--				<div id="userBar" style="display:none;">--%>
                <%--					<a class="layui-btn layui-btn-xs" lay-event="edit">重置密码</a>--%>
                <%--					<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
                <%--				</div>--%>
                <thead>
                <tr>
					<th lay-data="{field:'1',align:'center'}">总分</th>
					<th lay-data="{field:'2',align:'center'}">第一题</th>
					<th lay-data="{field:'3',align:'center'}">第二题</th>
					<th lay-data="{field:'4',align:'center'}">第三题</th>
					<th lay-data="{field:'5',align:'center'}">第四题</th>
					<th lay-data="{field:'6',align:'center'}">第五题</th>
                    <%--					<th lay-data="{field:'7', toolbar:'#userBar' ,width:200,align:'center', fixed:'right'}">操作</th>--%>
                </tr>
                </thead>
                <tbody>
				<c:forEach items="${ListSelfGrade}" var="user">
					<c:if test="${user.session ==17}">
						<tr>
							<td>${user.grade}</td>
							<td>${user.first}</td>
							<td>${user.second}</td>
							<td>${user.third}</td>
							<td>${user.fourth}</td>
							<td>${user.fifth}</td>
						</tr>
					</c:if>
				</c:forEach>
                </tbody>
            </table>
        </div>
        <div class="layui-tab-item">
            <table lay-filter="demo" id="demo3">
                <!-- <div id="userToolBar" style="display:none;" >
                      <button type="button" class="layui-btn" lay-event="add" >添加用户</button>
                </div> -->
                <%--				<div id="userBar" style="display:none;">--%>
                <%--					<a class="layui-btn layui-btn-xs" lay-event="edit">重置密码</a>--%>
                <%--					<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
                <%--				</div>--%>
                <thead>
                <tr>
					<th lay-data="{field:'1',align:'center'}">总分</th>
					<th lay-data="{field:'2',align:'center'}">第一题</th>
					<th lay-data="{field:'3',align:'center'}">第二题</th>
					<th lay-data="{field:'4',align:'center'}">第三题</th>
					<th lay-data="{field:'5',align:'center'}">第四题</th>
					<th lay-data="{field:'6',align:'center'}">第五题</th>
                    <%--					<th lay-data="{field:'7', toolbar:'#userBar' ,width:200,align:'center', fixed:'right'}">操作</th>--%>
                </tr>
                </thead>
                <tbody>
				<c:forEach items="${ListSelfGrade}" var="user">
					<c:if test="${user.session ==16}">
						<tr>
							<td>${user.grade}</td>
							<td>${user.first}</td>
							<td>${user.second}</td>
							<td>${user.third}</td>
							<td>${user.fourth}</td>
							<td>${user.fifth}</td>
						</tr>
					</c:if>
				</c:forEach>
                </tbody>
            </table>
        </div>
        <div class="layui-tab-item">
            <table lay-filter="demo" id="demo4">
                <!-- <div id="userToolBar" style="display:none;" >
                      <button type="button" class="layui-btn" lay-event="add" >添加用户</button>
                </div> -->
                <%--				<div id="userBar" style="display:none;">--%>
                <%--					<a class="layui-btn layui-btn-xs" lay-event="edit">重置密码</a>--%>
                <%--					<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>
                <%--				</div>--%>
                <thead>
                <tr>
                    <th lay-data="{field:'1',align:'center'}">总分</th>
                    <th lay-data="{field:'2',align:'center'}">第一题</th>
                    <th lay-data="{field:'3',align:'center'}">第二题</th>
                    <th lay-data="{field:'4',align:'center'}">第三题</th>
                    <th lay-data="{field:'5',align:'center'}">第四题</th>
					<th lay-data="{field:'6',align:'center'}">第五题</th>
                    <%--					<th lay-data="{field:'7', toolbar:'#userBar' ,width:200,align:'center', fixed:'right'}">操作</th>--%>
                </tr>
                </thead>
                <tbody>
				<c:forEach items="${ListSelfGrade}" var="user">
					<c:if test="${user.session ==15}">
						<tr>
							<td>${user.grade}</td>
							<td>${user.first}</td>
							<td>${user.second}</td>
							<td>${user.third}</td>
							<td>${user.fourth}</td>
							<td>${user.fifth}</td>
						</tr>
					</c:if>
				</c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<script src="../layui/layui.js"></script>

<!-- 监听是否点击提交 -->
<script>
    //Demo
    layui.use('element', function () {
        var element = layui.element;

        //一些事件监听
        element.on('tab(demo)', function (data) {
            console.log(data);
        });
    });
</script>

<!-- 上传照片 -->
<script>
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
</script>
<script type="text/javascript">
    //静态表格
    layui.use(['jquery', 'layer', 'form', 'table'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var table = layui.table;//加载表格模块
        var form = layui.form;

        table.init('demo', {
            id: 'demo'
            , height: 'funll-300' //设置高度
            , page: true//开启分页
            , toolbar: '#userToolBar'

        });

        //监听头部工具栏事件
        table.on("toolbar(userToolBar)", function (obj) {
            switch (obj.event) {
                case 'add':
                    alert("add");
                    openAddUser();
                    break;
            }
            ;
        })

        //监听行工具事件
        table.on('tool(demo)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            if (layEvent === 'del') { //删除

                //layer.msg("删除");
                //console.log(data[1]);

                layer.confirm('真的删除行么', function (index) {
                    layer.close(index);
                    //向服务端发送删除指令
                    //alert(data[1]);
                    window.location.href = "/market_3x/UserServlet?type=del&id=" + data[1] + ""

                });
            } else if (layEvent === 'edit') { //编辑
                //layer.msg("编辑");
                //openUpdateUser();
                console.log(data)
                console.log(data[1])
                var id = data[1]
                var alterobj = {
                    id: id,
                    password: "000000",
                }

                $.ajax({
                    url: '${ctx}/user/modify',
                    type: 'post',
                    contentType: 'application/json',
                    data: JSON.stringify(alterobj),
                    success: function (databack) {
                        console.log(databack)
                        if (databack.update == "success") {
                            layer.msg("重置成功")
                        }
                        setTimeout(function () {  //使用  setTimeout（）方法设定定时2000毫秒
                            window.location.reload();//页面刷新
                        }, 2000);
                    }
                })
            }
        });

        var url;
        var mainIndex;


        //打开修改页面
        function openUpdateUser(data) {

            mainIndex = layer.open({
                type: 1,
                title: '修改密码',
                content: $("#saveOrUpdateDiv"),
                area: ['400px', '200px'],
                success: function (index) {
                    //alert("ok");
                    form.val("dataFrm", data);
                    url = "/market_3x/UserServlet?type=update";
                }
            });
        }

        //保存
        form.on("submit(doSubmit)", function (obj) {

            //alert(url);
            //这是没得办法，url传不过来
            if (typeof (url) == "undefined") {
                url = "/market_3x/UserServlet?type=add";
            }
            //alert(url);
            //序列化表单数据
            var params = $("#dataFrm").serialize();
            $.post(url, params, function (obj) {
                //alert(params);
                //layer.msg(obj);
                //alert(params);
                //关闭弹出层
                layer.close(mainIndex);
                //刷新数据 表格
                window.location.href = "";
                return false;

            })
        });


    });

</script>
</body>
</html>
