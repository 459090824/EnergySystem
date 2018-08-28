<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>实时监测</title>
    <meta name="keywords" content="实时监测信息" />
	<meta name="description" content="实时监测信息" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- bootstrap -->
    <link href="<%=basePath %>admin/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="<%=basePath %>admin/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="<%=basePath %>admin/css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath %>admin/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />
	<link href="<%=basePath %>admin/css/lib/jquery.dataTables.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/icons.css">

    <!-- this page specific styles -->
    <link rel="stylesheet" href="<%=basePath %>admin/css/compiled/index.css" type="text/css" media="screen" />
    
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    
    <!-- dataTables -->
    <script src="<%=basePath %>admin/js/jquery.dataTables.js"></script>

    <!-- 引入 ECharts 文件 -->
    <script src="<%=basePath %>admin/js/echarts.min.js"></script>

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- lato font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>

    <style type="text/css">
        .dashboard-stats {
            float: left;
            width: 33%;
            padding-left: 10px;
        }

        .dashboard-stats-item {
            position: relative;
            overflow: hidden;
            color: #fff;
            cursor: pointer;
            height: 105px;
            margin-right: 10px;
            margin-bottom: 10px;
            padding-left: 15px;
            padding-top: 20px;
        }

        .dashboard-stats-item .m-top-none {
            margin-top: 5px;
        }

        .dashboard-stats-item h2 {
            font-size: 28px;
            font-family: inherit;
            line-height: 1.1;
            font-weight: 500;
            padding-left: 70px;
            color: #fff;
        }

        .dashboard-stats-item h2 span {
            font-size: 12px;
            padding-left: 5px;
            color: #fff;
        }

        .dashboard-stats-item h5 {
            font-size: 15px;
            font-family: inherit;
            margin-top: 7px;
            line-height: 1.1;
            padding-left: 70px;
            color: #fff;
        }


        .dashboard-stats-item .stat-icon {
            position: absolute;
            top: 18px;
            font-size: 50px;
            opacity: .3;
        }

        .dashboard-stats i.fa.stats-icon {
            width: 50px;
            padding: 20px;
            font-size: 50px;
            text-align: center;
            color: #fff;
            height: 50px;
            border-radius: 10px;
        }
        .panel-default {
            border: none;
            border-radius: 0px;
            margin-bottom: 0px;
            box-shadow: none;
            -webkit-box-shadow: none;
        }

        .panel-default  .panel-heading {
            color: #777;
            background-color: #fff;
            border-color: #e6e6e6;
            padding: 10px 10px;
        }

        .panel-default  .panel-body {
            padding: 10px;
            padding-bottom: 0px;
        }
        .hr-32, .hr32 {
            margin: 32px 0;
        }
        .hr {
            display: block;
            height: 0;
            overflow: hidden;
            font-size: 0;
            border-top: 1px solid #e3e3e3;
            margin: 20px 0;
            margin-top: 30px;
        }
        .hr.dotted, .hr-dotted {
            border-top-style: dotted;
        }
       .field-box {
            margin-bottom: 25px;
            margin-left: 0;
            float: left;
            width: 100%;
        }
        .lable1{
            display: inline-block;
            float: left;
            font-weight: 600;
            font-size: 13px;
            cursor: auto;
            width: 120px;
        }
        .actions {
            margin-top: 0px;
            text-align: right;
            padding-right: 40px;
        }
    </style>

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
	<!-- navbar -->
    <jsp:include page="include/header.jsp"/>
    <!-- end navbar -->
	
    <!-- sidebar -->
    <jsp:include page="include/lefter.jsp"/>
    <!-- end sidebar -->
    
    <!-- main container -->
    <div class="content">

        <!-- upper main stats -->
        <!-- end upper main stats -->

        <div id="pad-wrapper"> 
            <div class="row"> 
				<!-- 6个统计框 -->
                <div class="col-md-6">
                    <div class="dashboard-stats">
                        <div class="dashboard-stats-item" style="background-color: #578ebe;">
                            <div class="stat-icon">
                                <i class="icon-bell"></i>
                            </div>
                            <h2 class="m-top-none">${systemInfo}<span>个</span></h2>
                            <h5>系统消息</h5>
                        </div>
                    </div>
                    <div class="dashboard-stats">
                        <div class="dashboard-stats-item" style="background-color: #e35b5a;">
                            <h2 class="m-top-none">${equipmentTotal}<span>个</span></h2>
                            <h5>所有设备</h5>
                            <div class="stat-icon">
                                <i class="icon-reorder"></i>
                            </div>
                        </div>
                    </div>
                    <div class="dashboard-stats">
                        <div class="dashboard-stats-item" style="background-color: #8775a7; margin-right: 0px;">
                            <h2 class="m-top-none">${equipmentNoWorkNum}<span>个</span></h2>
                            <h5>未工作设备</h5>
                            <div class="stat-icon">
                                <i class="icon-remove"></i>
                            </div>
                        </div>
                    </div>
                    <div class="dashboard-stats">
                        <div class="dashboard-stats-item" style="background-color: #4f5c65; margin-bottom: 0px;">
                            <h2 class="m-top-none">30<span>次</span></h2>
                            <h5>浏览次数</h5>
                            <div class="stat-icon">
                                <i class="icon-tags"></i>
                            </div>
                        </div>
                    </div>
                    <div class="dashboard-stats">
                        <div class="dashboard-stats-item" style="background-color: #14aae4; margin-bottom: 0px;">
                            <h2 class="m-top-none">${equipmentConnectNum}<span>个</span></h2>
                            <h5>连接设备</h5>
                            <div class="stat-icon">
                                <i class="icon-ok"></i>
                            </div>
                        </div>
                    </div>
                    <div class="dashboard-stats">
                        <div class="dashboard-stats-item" style="background-color: #f29503; margin-right: 0px; margin-bottom: 0px;">
                            <h2 class="m-top-none">${equipmentErroNum}<span>个</span></h2>
                            <h5>故障设备</h5>
                            <div class="stat-icon">
                                <i class="icon-wrench" style="padding-left: 10px;"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end 6个统计框 -->
        
                <!-- echarts饼状图 -->
                <div class="col-md-6">
                    <div style="height: 221px; border-left: 1px solid #e6e6e6;" id="pie"></div>
                </div>
                <!-- end echarts饼状图 --> 
            </div>
            
            <div class="hr hr32 hr-dotted"></div>

            <div class="row">
                <!--设备能耗列表-->
                <div class="col-md-6">
                    <div class="row header " style="margin-left: 0px;margin-bottom: 20px">
                        <h4>设备列表</h4>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <table id="example" class="table display" >
                                <thead>
                                    <tr>
                                        <th class="col-md-4 sortable text-center">
                                           	<span  class="line"></span> 设备名称
                                        </th>
                                        <th class="col-md-4 sortable text-center">
                                            <span class="line"></span>设备状态
                                        </th>
                                        <th class="col-md-4 sortable text-center">
                                            <span class="line"></span>控制模式
                                        </th>
                                        
                                    </tr>
                                </thead>
                                <tbody id="equipmentList">
                                	<c:forEach items="${equipmentUnions}" var="equipmentUnion" varStatus="status">
	                                <!-- row -->
	                                <tr class="first">
	                   <!--                  <td>
	                                        <span class="subtext">${equipmentUnion.equipment_Name }</span>
	                                    </td>      --> 
	                                    <td class="text-center">${equipmentUnion.equipment_Name }</td>
	                                    <td class="text-center">${equipmentUnion.state.state_Name }</td>
	                                    <td class="text-center">${equipmentUnion.equipmentControlModel.equipmentControlModel_Name }</td>
	                                </tr>
	                                </c:forEach>
                                </tbody>
                            </table>
                        </div>                
                    </div>
                </div>
                <!--end 设备能耗列表-->
                
                <!--echarts 柱状图-->
                <div class="col-md-6">
                    <div class="row header" style="margin-left: 0px;margin-bottom: 20px">
                        <h4>设备数量</h4>
                        <div class="btn-group pull-right" style="margin-top: 10px;margin-right: 15px">
                            <button id="area" class="glow left active" onclick="getBarChartData(this.id);">区域</button>
                            <button id="building" class="glow middle" onclick="getBarChartData(this.id);">建筑</button>
                            <button id="room" class="glow right" onclick="getBarChartData(this.id);">房间</button>
                        </div>
                    </div>
                    <!--echarts 柱状图 设备数量-->
                    <div id="bar" style="height: 450px; border: 1px solid #e6e6e6; background-color: #fff;" ></div>
                    <!--end echarts 柱状图 设备数量-->
                </div>
                <!--end echarts 柱状图-->
            </div>
                
        </div>

        
    </div>
    <!--end main container -->
    
    <!-- scripts -->
    <script src="<%=basePath %>admin/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>admin/js/jquery-ui-1.10.2.custom.min.js"></script>
    <!-- knob -->
    <script src="<%=basePath %>admin/js/jquery.knob.js"></script>
    <!-- flot charts -->
    <script src="<%=basePath %>admin/js/jquery.flot.js"></script>
    <script src="<%=basePath %>admin/js/jquery.flot.stack.js"></script>
    <script src="<%=basePath %>admin/js/jquery.flot.resize.js"></script>
    <script src="<%=basePath %>admin/js/theme.js"></script>
    
    <!-- 分页 dataTables -->
    <script type="text/javascript">
    	$(document).ready(function(){
    		$('#example').dataTable({
    			"sPaginationType": "full_numbers",
    			"bFilter":false,
    			"bLengthChange":false,
    			"oLanguage": {
					"oPaginate": {
						"sFirst": "首页",
						"sPrevious": "上一页",
						"sNext": "下一页",
						"sLast": "末页",
 					},
    				"sInfo":"第 _START_ 到 _END_ 条/共 _TOTAL_ 条"
				}
    		});
    	});
    </script> 
    <!-- end 分页 dataTables -->
    
    <!-- echarts 饼状图 -->
    <script type="text/javascript">
 		// 基于准备好的dom，初始化echarts实例
    	var myChartt = echarts.init(document.getElementById('pie'));
    	myChartt.showLoading();
    	//通过ajax获取数据
	    $.ajax({
	      	type:"get",
	         url:"<%=basePath %>superadmin/findPieData",//请求路径
	         data:{},
	         dataType:"json",//返回数据形式为json   
	         success:function(result){
	        	 
	             // 指定图表的配置项和数据
	             var optiont = {
	                 title : {
	                     text: '设备类型',
	                     x:'center'
	                 },
	                 tooltip : {
	                     trigger: 'item',
	                     formatter: "{a} <br/>{b} : {c} ({d}%)"
	                 },
	                 legend: {
	                     orient: 'vertical',
	                     left: '25',
	                     data: [],
	                 }, 
	                 series : [
	                     {
	                         name: '设备类型',
	                         type: 'pie',
	                         radius : '55%',
	                         center: ['50%', '60%'],
	                         data:[
	
	                               ],
	                         itemStyle: {
	                             emphasis: {
	                                 shadowBlur: 10,
	                                 shadowOffsetX: 0,
	                                 shadowColor: 'rgba(0, 0, 0, 0.5)'
	                             }
	                         }
	                     }
	                 ],
	                  color: ["#30a1ec", "#76bdee", "#c4dafe","#666699"]
	             }; 
	        	 
	        	 var res = [];
	             var len = result[0].category.length;
	             var i = 0;
	             while (i <= len) {
	                 res.push({
	                 name: result[0].category[i],
	                 value: result[0].data[i]
	                 });
	                 i++;
	             } 
	             optiont.legend.data = result[0].category;//legend赋值数据
	        	 optiont.series[0].data = res;//y轴赋值数据
	             myChartt.hideLoading(); 
	             myChartt.setOption(optiont);
	          }                       
	      });
    </script>
    <!-- end echarts 饼状图 -->
    
    <!-- echarts 柱状图 -->
    <script type="text/javascript">
	    // 基于准备好的dom，初始化echarts实例
	    var myChart = echarts.init(document.getElementById('bar')); 
		var option;
        // 指定图表的配置项和数据
        option = {
             tooltip: {},
             xAxis: {
                 data: []
             },
             yAxis: {},
             series: [{
                 type: 'bar',
                 itemStyle:{
                     normal:{
                         color:'#3d88ba'
                     }
                 },
                 data: []
             }]
         };
         // 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
        //默认显示area数据
		var optiont = myChart.getOption();
		$.ajax({
			type:"get",
			url:"<%=basePath %>superadmin/findData/area",
			data:{},
	       	dataType:"json",//返回数据形式为json   
	       		success:function(result){
					optiont.xAxis[0].data =  result[0].xdata;//x轴赋值数据
					optiont.series[0].data = result[0].data;//y轴赋值数据
					myChart.hideLoading(); 
					myChart.setOption(optiont);                                            
	      		},
	      		error:function(result){
	      			alert("error");
	      		}
	    }); 
        //onclick方法
		function getBarChartData(id){	
			$("#area").removeClass("active");
			$("#building").removeClass("active");
			$("#room").removeClass("active");
			$("#"+ id).addClass("active");
        	
			//获得图表的options对象
			var options = myChart.getOption();       	                               									 
			//通过ajax获取数据
		    $.ajax({
				type:"get",
				url:"<%=basePath %>superadmin/findData/"+id,//请求路径
				data:{},
		       	dataType:"json",//返回数据形式为json   
		       		success:function(result){
						options.xAxis[0].data =  result[0].xdata;//x轴赋值数据
						options.series[0].data = result[0].data;//y轴赋值数据
						myChart.hideLoading(); 
						myChart.setOption(options);                                            
		      		},
		      		error:function(result){
		      			alert("error");
		      		}
		    	});
		}
    </script> 
    <!-- end echarts 柱状图 -->
    <!-- end scripts -->

</body>
</html>