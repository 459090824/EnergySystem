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
    <title>能耗统计</title>
    <meta name="keywords" content="能耗统计" />
	<meta name="description" content="能耗统计" />
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

    <!-- 引入 日期插件-->
    <script src="<%=basePath %>admin/laydate/laydate.js"></script>

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
        <div id="pad-wrapper"> 
            <div class="row"> 
                <div class="col-md-6">
                    <!-- 6个统计框 -->
                    <div class="row"  style="margin-left: 1px;margin-right: 1px;" >
                        <div class="dashboard-stats">
                            <div class="dashboard-stats-item" style="background-color: #578ebe;">
                                <div class="stat-icon">
                                    <i class="icon-bell"></i>
                                </div>
                                <h2 class="m-top-none">220<span>V</span></h2>
                                <h5>当前电压</h5>
                            </div>
                        </div>
                        <div class="dashboard-stats">
                            <div class="dashboard-stats-item" style="background-color: #e35b5a;">
                                <h2 class="m-top-none">${energyTypeCount}<span>种</span></h2>
                                <h5>能源种类</h5>
                                <div class="stat-icon">
                                    <i class="icon-reorder"></i>
                                </div>
                            </div>
                        </div>
                        <div class="dashboard-stats">
                            <div class="dashboard-stats-item" style="background-color: #8775a7; margin-right: 0px;">
                                <h2 class="m-top-none">${equipmentEnergyConsumptionForDay}<span>kWh</span></h2>
                                <h5>当前能耗</h5>
                                <div class="stat-icon">
                                    <i class="icon-remove"></i>
                                </div>
                            </div>
                        </div>
                        <div class="dashboard-stats">
                            <div class="dashboard-stats-item" style="background-color: #4f5c65; margin-bottom: 0px;">
                                <h2 class="m-top-none">50<span>A</span></h2>
                                <h5>当前电流</h5>
                                <div class="stat-icon">
                                    <i class="icon-tags"></i>
                                </div>
                            </div>
                        </div>
                        <div class="dashboard-stats">
                            <div class="dashboard-stats-item" style="background-color: #14aae4; margin-bottom: 0px;">
                                <h2 class="m-top-none">6<span>个</span></h2>
                                <h5>暂定模块</h5>
                                <div class="stat-icon">
                                    <i class="icon-ok"></i>
                                </div>
                            </div>
                        </div>
                        <div class="dashboard-stats">
                            <div class="dashboard-stats-item" style="background-color: #f29503; margin-right: 0px; margin-bottom: 0px;">
                                <h2 class="m-top-none">${equipmentEnergyConsumptionForMonth}<span>kWh</span></h2>
                                <h5>当月能耗</h5>
                                <div class="stat-icon">
                                    <i class="icon-wrench" style="padding-left: 10px;"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end 6个统计框 -->

                    <!--能耗查询-->
                    <div class="row"  style="margin-left: 1px;margin-right: 1px;">
                        <div class="hr hr32 hr-dotted"></div>
                        <div class="row header" style="margin-left: 12px;margin-bottom: 20px">
                        <h4>能耗查询</h4>
                        </div>
                        <div style="margin-top: 35px;">
                            <form id="new_user_form1" class="new_user_form">
                                <div class="col-md-12 field-box">
                                    <label class="lable1">位置:</label>
                                    <div class="ui-select span5">
                                    <select id="park_ID" name="park_ID"  onclick="branchone(this);">
                                    	<option value="">请选择</option> 
                                       <c:forEach items="${parks}" var="park" varStatus="status" >                                     
                                       		<option value="${park.park_ID}">${park.park_Name}</option>
                                       </c:forEach>
                                    </select>     
                                    </div>
                                    <div class="ui-select span5">
                                     <select id="region_ID" name="region_ID" onclick="branchtwo(this);">
                                    	<option value="">请选择</option> 
                     	          	   <c:forEach items="${areas}" var="area" varStatus="status">
                                       		<option value="${area.region_ID}">${area.region_Name}</option>
                                       </c:forEach>
                                      
                                     </select>                                                     
                                    </div>
                                    <div class="ui-select span5">
                                     <select id="build_ID" name="build_ID" onclick="branchthree(this);">
                                    	<option value="">请选择</option> 
                                       <c:forEach items="${buildings}" var="building" varStatus="status">
                                       		<option value="${building.build_ID}">${building.build_Name}</option>
                                       </c:forEach>
                                    </select> 
                                    </div>
                                    <div class="ui-select span5">
                                    <select id="room_ID" name="room_ID">
                                    	<option value="">请选择</option> 
                                       <c:forEach items="${rooms}" var="room" varStatus="status">
                                       		<option value="${room.room_ID}">${room.room_Name}</option>
                                       </c:forEach>
                                    </select>  
                                    </div>
                                </div>
                                <div class="col-md-12 field-box">
                                    <label id="startTime" class="lable1">起止时间:</label>
                                    <input class="laydate-icon " onclick="laydate()" name="startTime" style="display: inline-block;">
                                    <p style="display: inline-block;">--</p>
                                    <input id="endTime" class="laydate-icon" name="endTime" style="display: inline-block;">
                                </div>
                                <div class="col-md-12 field-box">
                                    <label class="lable1">总能耗量:</label>
                                    <input id="result" class="col-md-3 " style="border:1px solid #C6C6C6;" type="text"/><span>kWh</span>
                                </div>
                                <div class="col-md-11 field-box actions">
                                    <input id="query" type="button" class="btn-glow primary" value="查询">
                                    <span>OR</span>
                                    <input type="reset" value="取消" class="reset">
                                </div>
                            </form>
                        </div>
                    </div>
                    <!--end 能耗查询-->
                </div>
        
                <!-- echarts饼状图 -->
                <div class="col-md-6">
                    <div style="height: 520px; border-left: 1px solid #e6e6e6;" id="pie"></div>
                </div>
                <!-- end echarts饼状图 --> 
            </div>
            
            <div class="hr hr32 hr-dotted"></div>

            <div class="row">
                <!--设备能耗列表-->
                <div class="col-md-6">
                    <div class="row header" style="margin-left: 0px;margin-bottom: 20px">
                        <h4>设备能耗列表</h4>
                        <div class="btn-group pull-right" style="margin-top: 10px;margin-right: 15px">
                            <button id="date" class="glow left active" onclick="getEqupmentConsumptionList(this.id);">日</button>
                            <button id="month" class="glow middle " onclick="getEqupmentConsumptionList(this.id);">月</button>
                            <button id="year" class="glow right" onclick="getEqupmentConsumptionList(this.id);">年 </button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12" id="test">
                            <table id="example" class="table table-hover">
                                <thead>
                                    <tr>
                                        <th class="col-md-4 sortable text-center">
                                           	<span class="line"></span> 设备名称
                                        </th>
                                        <th class="col-md-4 sortable text-center">
                                            <span class="line"></span>能耗/kWh
                                        </th>
                                        <th class="col-md-4 sortable text-center">
                                            <span class="line"></span>自动检测耗能
                                        </th>
                                        
                                    </tr>
                                </thead>
                                <tbody id="showEnergyConsumptionList">
	                                <!-- row -->
	                                <tr class="first">
	                                    <td>
	                                        <span id="equipment_Name" class="subtext,text-center"></span>
	                                    </td>
	                                    <td id="energ_Consumption" class="text-center"></td>
	                                    <td id="equipment_Auto" class="text-center"></td>
	                                </tr>
	                               
                                </tbody>
                            </table>
                        </div>                
                    </div>
                </div>
                <!--end 设备能耗列表-->
                
                <!--echarts 柱状图-->
                <div class="col-md-6">
                    <div class="row header" style="margin-left: 0px;margin-bottom: 20px">
                        <h4>能耗统计</h4>
                        <div class="btn-group pull-right" style="margin-top: 10px;margin-right: 15px">
                            <button id="area" class="glow left active" onclick="getBarChartData(this.id);">区域</button>
                            <button id="building" class="glow middle " onclick="getBarChartData(this.id);">建筑</button>
                            <button id="room" class="glow right" onclick="getBarChartData(this.id);">房间</button>
                        </div>
                    </div>
                    <!--echarts 设备能耗-->
                    <div style="height: 500px; border: 1px solid #e6e6e6; background-color: #fff;" id="bar"></div>
                    <!--end echarts 设备能耗-->
                </div>
                <!--end echarts 柱状图-->
            </div>
                
        </div>

        
    </div>
    <!--end main container -->
    
 
    <!-- 日历部分js -->
    <script>
	    !function(){
	    laydate({
	       elem: '#endTime'
	    })
	    }();
    </script>
    <!-- end 日历部分js -->
    
    <!-- dataTables -->
    <script type="text/javascript">
    	$(document).ready(function(){
    		var table = $('#example').dataTable({
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
				},
				"sAjaxSource": "<%=basePath %>superadmin/findEquipmentEnergyConsumptionList/date",
		        "aoColumns": [
		            { "mData": "equipment_Name" },
		            { "mData": "energ_Consumption" },
		            { "mData": "equipment_Auto" }
		        ]
    		});
    	});
    </script> 
    <!-- end dataTables -->
    
    <!-- 查询 -->
    <script type="text/javascript">
        $(function () {
            // toggle form between inline and normal inputs
        	$("#query").click(function () {
                $.ajax({
                	url:"<%=basePath %>superadmin/queryEnergyConsumption",
                	type : "get",
                	data :$('#new_user_form1').serialize(),
                	dataType:"json",
                	success:function(msg){
                			var result = document.getElementById("result");
                			result.value=msg;
                	},
                	error:function(){
                		alert("失败");
                	}
                });
                
            });
        });
    </script>
    <!-- end 查询 -->
    
    <!-- 设备能耗表 -->
    <script type="text/javascript">
    function getEqupmentConsumptionList(id){
		$("#date").removeClass("active");
		$("#month").removeClass("active");
		$("#year").removeClass("active");
		$("#"+ id).addClass("active");
		
	    $("#test").html('');
	    	//重新载入<table>
			$("#test").html('<table id="example" class="table table-hover"><thead>' + '<tr> <th class="col-md-4 sortable"><span class="line"></span>设备名称</th><th class="col-md-4 sortable text-center"><span class="line"></span>能耗/kWh</th><th class="col-md-4 sortable text-center"><span class="line"></span>自动检测耗能</th></tr></thead><tbody id="showEnergyConsumptionList"><!-- row --><tr class="first"><td><span id="equipment_Name" class="subtext,text-center"></span></td><td id="energ_Consumption" class="text-center"></td><td id="equipment_Auto" class="text-center"></td></tr></tbody></table>');
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
				},
				"sAjaxSource": "<%=basePath %>superadmin/findEquipmentEnergyConsumptionList/" + id,
		        "aoColumns": [
		            { "mData": "equipment_Name" },
		            { "mData": "energ_Consumption" },
		            { "mData": "equipment_Auto" }
		        ]
			}); 
			
		}
    </script>
	<!-- end 设备能耗表 --> 
	   
    <!-- echarts pie饼状图 -->
    <script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	var myChartt = echarts.init(document.getElementById('pie'));
	myChartt.showLoading();
	//通过ajax获取数据 
	$.ajax({
		type:"get",
		url:"<%=basePath %>superadmin/findPieTotalData",//请求路径
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
					data:[],
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
    <!-- end echarts pie -->
    
    <!-- echarts bar柱状图 -->
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
		var optiont = myChart.getOption();
		$.ajax({
			type:"get",
			url:"<%=basePath %>superadmin/findDataTotalData/area",
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
				url:"<%=basePath %>superadmin/findDataTotalData/"+id,//请求路径
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
		};
		
    </script>
	
	 <script type="text/javascript">
    	function branchone(e){
    		var park_ID=e.value;    //得到点击的park_ID的值
    		var sel=$("#region_ID");
    		sel.empty();
    			$.ajax({
    				url:"branchOne/"+park_ID,
    				type : "get",
    				success:function(data){
    	                    for ( var i = 0; i < data.length; i++) {  
    	                		var col = data[i];    				
    	        				sel.append("<option value=" + data[i].region_ID + ">" + data[i].region_Name + "</option>");              
    	                    }   				
    				}
    			});
    	};    
    </script>
    
   <script type="text/javascript">
    	function branchtwo(e){
    		var region_ID=e.value;    //得到点击的region_ID的值
    		var sel=$("#build_ID");
    		sel.empty();
    			$.ajax({
    				url:"branchTwo/"+region_ID,
    				type : "get",
    				success:function(data){
    	                    for ( var i = 0; i < data.length; i++) {  
    	                		var col = data[i];  
//    	                if(selVal==data[i].region_ID) {  
//    	 sel2.append("<option value=" + data[i].region_ID + " selected=\"true\">" + data[i].region_Name + "</option>");  
//    	                }else {  
//    	sel2.append("<option value=" + data[i].region_ID + ">" + data[i].region_Name + "</option>");  
//    	                }   
    				
    	        				sel.append("<option value=" + data[i].build_ID + ">" + data[i].build_Name + "</option>");              
    	                    }   				
    				}
    			});
    	};    
    </script>
    
    <script type="text/javascript">
    	function branchthree(e){
    		var build_ID=e.value;    //得到点击的build_ID的值
    		var sel=$("#room_ID");
    		sel.empty();
    			$.ajax({
    				url:"branchThree/"+build_ID,
    				type : "get",
    				success:function(data){
    	                    for ( var i = 0; i < data.length; i++) {  
    	                		var col = data[i];  
//    	                if(selVal==data[i].region_ID) {  
//    	 sel2.append("<option value=" + data[i].region_ID + " selected=\"true\">" + data[i].region_Name + "</option>");  
//    	                }else {  
//    	sel2.append("<option value=" + data[i].region_ID + ">" + data[i].region_Name + "</option>");  
//    	                }   
    				
    	        				sel.append("<option value=" + data[i].room_ID + ">" + data[i].room_Name + "</option>");              
    	                    }   				
    				}
    			});
    	};    
    </script>
</body>
</html>