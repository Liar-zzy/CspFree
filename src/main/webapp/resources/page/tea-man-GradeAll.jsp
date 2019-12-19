<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>echarts</title>
<link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>

	<div style="display: flex">
		<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
		<div id="main" style="width: 530px; height: 400px;"></div>
	</div>

	<script src="../layui/layui.js"></script>
	<script src="https://cdn.bootcss.com/echarts/4.4.0-rc.1/echarts.min.js"></script>
	<script type="text/javascript">
		//监听事件
		layui.use([ 'element', 'jquery' ], function() {
			var $ = layui.jquery;
			var element = layui.element;

		})

		//---------------------------------------------------------------
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
			        data:['答对人数','正确率']
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
			            name:'答对人数'
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
			            name:'答对人数',
			            type:'bar',
			            data:[200, 150, 40, 70, 10],
			            
			        },
			        {
			            name:'正确率',
			            type:'line',
			            data:[0.7, 0.6, 0.33, 0.2, 0.1],
			            yAxisIndex: 1,
			            
			        }
			    ]
			};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	</script>
</body>
</html>


<!-- 注释
	修改  72行  78行   data[]数组里的值即可 
 -->