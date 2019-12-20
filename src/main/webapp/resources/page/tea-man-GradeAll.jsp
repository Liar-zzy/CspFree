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
<title>echarts</title>
<link rel="stylesheet" href="${webRoot}/resources/layui/css/layui.css">
</head>
<body>

	<div style="display: flex">
		<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
		<div id="main" style="width: 1000px; height: 500px;"></div>
	</div>

	<script src="${webRoot}/resources/layui/layui.js"></script>
	<script src="https://cdn.bootcss.com/echarts/4.4.0-rc.1/echarts.min.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/jquery-3.4.1/jquery-3.4.1.js"></script>

	<script type="text/javascript">
		//监听事件
		layui.use([ 'element', 'jquery' ], function() {
			var $ = layui.jquery;
			var element = layui.element;

		})

		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));

		// 指定图表的配置项和数据
		var option = {
			    title : {
			        text: '全部成绩分析',
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['均分','正确率']
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            dataView : {show: true, readOnly: false},
			            magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            data : ['第一题','第二题','第三题','第四题','第五题']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            name:'均分'
			        },
			        {
			            type : 'value',
			            name:'正确率',
			            max:1,
			            min:0
			        } 
			    ],
			    series : [
			        {
			            name:'均分',
			            type:'bar',
			            data:[],
			            
			        },
			        {
			            name:'正确率',
			            type:'line',
			            data:[],
			            yAxisIndex: 1,
			            
			        }
			    ]
			};

		$.ajax({
			type: "get",
			url: "${ctx}/resources/stuGrade/ListFirstToFifth",
			cache : false,    //禁用缓存
			dataType: "json",
			success: function(result) {

				var averageA=[];
				var fenshu=[]
				console.log(result)
				for(var i=0;i<result.length;i++) {

					console.log(result[i].average)
					console.log(result[i].accuracy)

					// names.push(result[i].name);
					// var obj = new Object();
					// obj.name = result[i].name;
					// obj.value = result[i].value;

					// console.log(result[i].name)
					// console.log(result[i].value)
					averageA.push(result[i].average)
					fenshu.push(result[i].accuracy);
				}
				console.log(averageA)
				console.log(fenshu)
				myChart.setOption(option);
				myChart.setOption({ //加载数据图表
					series: [{
						data: averageA
					},
						{
						data:fenshu
					}
					]
				});
			},
		});
	</script>
</body>
</html>


<!-- 注释
	修改  72行  78行   data[]数组里的值即可 
 -->