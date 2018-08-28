<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>能量管理系统后台管理系统首页</title>
	<meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文,后台管理系统模版,后台模版下载,后台管理系统,后台管理模版" />
	<meta name="description" content="JS代码网提供Bootstrap模版,后台管理系统模版,后台管理界面,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <!-- bootstrap -->
    <link href="<%=basePath %>admin/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="<%=basePath %>admin/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="<%=basePath %>admin/css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath %>admin/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/icons.css">

    <!-- this page specific styles -->
    <link rel="stylesheet" href="<%=basePath %>admin/css/compiled/index.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- lato font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>

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

        <!-- settings changer
        <div class="skins-nav">
            <a href="#" class="skin first_nav selected">
                <span class="icon"></span><span class="text">默认皮肤</span>
            </a>
            <a href="#" class="skin second_nav" data-file="css/compiled/skins/dark.css">
                <span class="icon"></span><span class="text">深色皮肤</span>
            </a>
        </div>
         -->

        <!-- upper main stats -->
        <div id="main-stats">
            <div class="row stats-row">
                <div class="col-md-3 col-sm-3 stat">
                    <div class="data">
                        <span class="number">2457</span>
                        访问
                    </div>
                    <span class="date">今天</span>
                </div>
                <div class="col-md-3 col-sm-3 stat">
                    <div class="data">
                        <span class="number">3240</span>
                        用户
                    </div>
                    <span class="date">2013年11月</span>
                </div>
                <!--  -->
                <div class="col-md-3 col-sm-3 stat">
                    <div class="data">
                        <span class="number">3</span>
                        子系统
                    </div>
                    <span class="date">当前</span>
                </div>
                <div class="col-md-3 col-sm-3 stat last">
                    <div class="data">
                        <span class="number">2,34000</span>
                        访问
                    </div>
                    <span class="date">最近30天</span>
                </div>
            </div>
        </div>
        <!-- end upper main stats -->

        <div id="pad-wrapper">
        
            <!-- statistics chart built with jQuery Flot 
            <div class="row chart">
                <div class="col-md-12">
                    <h4 class="clearfix">
                        Statistics
                         <div class="btn-group pull-right">
                            <button class="glow left">日</button>
                            <button class="glow middle active">月</button>
                            <button class="glow right">年</button>
                        </div>
                    </h4>
                </div>
                <div class="col-md-12">
                    <div id="statsChart"></div>
                </div>
            </div>
            -->
            <!-- end statistics chart -->
 			
            <!-- UI Elements section 
            <div class="row section ui-elements">
                <div class="col-md-12">
                    <h4>UI Elements</h4>
                </div>                
                <div class="col-md-5 knobs">
                    <div class="knob-wrapper">
                        <input type="text" value="50" class="knob" data-thickness=".3" data-inputColor="#333" data-fgColor="#30a1ec" data-bgColor="#d4ecfd" data-width="150">
                        <div class="info">
                            <div class="param">
                                <span class="line blue"></span>
                                Active users
                            </div>
                        </div>
                    </div>
                    <div class="knob-wrapper">
                        <input type="text" value="75" class="knob second" data-thickness=".3" data-inputColor="#333" data-fgColor="#3d88ba" data-bgColor="#d4ecfd" data-width="150">
                        <div class="info">
                            <div class="param">
                                <span class="line blue"></span>
                                % disk space usage
                            </div>
                        </div>
                    </div>                        
                </div>
                <div class="col-md-6 showcase">
                    <div class="ui-sliders">
                        <div class="slider slider-sample1 vertical-handler"></div>
                        <div class="slider slider-sample2"></div>
                        <div class="slider slider-sample3"></div>
                    </div>
                    <div class="ui-group">
                        <a class="btn-flat inverse">Large Button</a>
                        <a class="btn-flat gray">Large Button</a>
                        <a class="btn-flat default">Large Button</a>
                        <a class="btn-flat primary">Large Button</a>
                    </div>                        

                    <div class="ui-group">
                        <a class="btn-flat icon">
                            <i class="tool"></i> Icon button
                        </a>
                        <a class="btn-glow small inverse">
                            <i class="shuffle"></i>
                        </a>
                        <a class="btn-glow small primary">
                            <i class="setting"></i>
                        </a>
                        <a class="btn-glow small default">
                            <i class="attach"></i>
                        </a>
                        <div class="ui-select">
                            <select>
                                <option selected>Dropdown</option>
                                <option>Custom selects</option>
                                <option>Pure css styles</option>
                            </select>
                        </div>

                        <div class="btn-group">
                            <button class="glow left">LEFT</button>
                            <button class="glow right">RIGHT</button>
                        </div>
                    </div>
                </div>
            </div>
            -->
            <!-- end UI elements section -->

            <!-- table sample -->
            <!-- the script for the toggle all checkboxes from header is located in js/theme.js 
            <div class="table-products section">
                <div class="row head">
                    <div class="col-md-12">
                        <h4>Products <small>Table sample</small></h4>
                    </div>
                </div>

                <div class="row filter-block">
                    <div class="col-md-8 col-md-offset-5">
                        <div class="ui-select">
                            <select>
                              <option>Filter users</option>
                              <option>Signed last 30 days</option>
                              <option>Active users</option>
                            </select>
                        </div>
                        <input type="text" class="search">
                        <a class="btn-flat new-product">+ Add product</a>
                    </div>
                </div>

                <div class="row">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th class="col-md-3">
                                    <input type="checkbox">
                                    Product
                                </th>
                                <th class="col-md-3">
                                    <span class="line"></span>Description
                                </th>
                                <th class="col-md-3">
                                    <span class="line"></span>Status
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- row 
                            <tr class="first">
                                <td>
                                    <input type="checkbox">
                                    <div class="img">
                                        <img src="img/table-img.png">
                                    </div>
                                    <a href="#">There are many variations </a>
                                </td>
                                <td class="description">
                                    if you are going to use a passage of Lorem Ipsum.
                                </td>
                                <td>
                                    <span class="label label-success">Active</span>
                                    <ul class="actions">
                                        <li><i class="table-edit"></i></span></li>
                                        <li><i class="table-settings"></i></li>
                                        <li class="last"><i class="table-delete"></i></li>
                                    </ul>
                                </td>
                            </tr>
                            <!-- row 
                            <tr>
                                <td>
                                    <input type="checkbox">
                                    <div class="img">
                                        <img src="img/table-img.png">
                                    </div>
                                    <a href="#">Internet tend</a>
                                </td>
                                <td class="description">
                                    There are many variations of passages.
                                </td>
                                <td>
                                    <ul class="actions">
                                        <li><i class="table-edit"></i></span></li>
                                        <li><i class="table-settings"></i></li>
                                        <li class="last"><i class="table-delete"></i></li>
                                    </ul>
                                </td>
                            </tr>
                            <!-- row 
                            <tr>
                                <td>
                                    <input type="checkbox">
                                    <div class="img">
                                        <img src="img/table-img.png">
                                    </div>
                                    <a href="#">Many desktop publishing </a>
                                </td>
                                <td class="description">
                                    if you are going to use a passage of Lorem Ipsum.
                                </td>
                                <td>
                                    <ul class="actions">
                                        <li><i class="table-edit"></i></span></li>
                                        <li><i class="table-settings"></i></li>
                                        <li class="last"><i class="table-delete"></i></li>
                                    </ul>
                                </td>
                            </tr>
                            <!-- row
                            <tr>
                                <td>
                                    <input type="checkbox">
                                    <div class="img">
                                        <img src="img/table-img.png">
                                    </div>
                                    <a href="#">Generate Lorem </a>
                                </td>
                                <td class="description">
                                    There are many variations of passages.
                                </td>
                                <td>
                                    <span class="label label-info">Standby</span>
                                    <ul class="actions">
                                        <li><i class="table-edit"></i></span></li>
                                        <li><i class="table-settings"></i></li>
                                        <li class="last"><i class="table-delete"></i></li>
                                    </ul>
                                </td>
                            </tr>
                            <!-- row 
                            <tr>
                                <td>
                                    <input type="checkbox">
                                    <div class="img">
                                        <img src="img/table-img.png">
                                    </div>
                                    <a href="#">Internet tend</a>
                                </td>
                                <td class="description">
                                    There are many variations of passages.
                                </td>
                                <td>                                        
                                    <ul class="actions">
                                        <li><i class="table-edit"></i></span></li>
                                        <li><i class="table-settings"></i></li>
                                        <li class="last"><i class="table-delete"></i></li>
                                    </ul>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <ul class="pagination">
                    <li><a href="#">&laquo;</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>
            -->
            <!-- end table sample -->
        </div>
    </div>


	<!-- scripts -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<%=basePath %>admin/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>admin/js/jquery-ui-1.10.2.custom.min.js"></script>
    <!-- knob -->
    <script src="<%=basePath %>admin/js/jquery.knob.js"></script>
    <!-- flot charts -->
    <script src="<%=basePath %>admin/js/jquery.flot.js"></script>
    <script src="<%=basePath %>admin/js/jquery.flot.stack.js"></script>
    <script src="<%=basePath %>admin/js/jquery.flot.resize.js"></script>
    <script src="<%=basePath %>admin/js/theme.js"></script>

    <script type="text/javascript">
        $(function () {

            // jQuery Knobs
            $(".knob").knob();



            // jQuery UI Sliders
            $(".slider-sample1").slider({
                value: 100,
                min: 1,
                max: 500
            });
            $(".slider-sample2").slider({
                range: "min",
                value: 130,
                min: 1,
                max: 500
            });
            $(".slider-sample3").slider({
                range: true,
                min: 0,
                max: 500,
                values: [ 40, 170 ],
            });

            

            // jQuery Flot Chart
            var visits = [[1, 50], [2, 40], [3, 45], [4, 23],[5, 55],[6, 65],[7, 61],[8, 70],[9, 65],[10, 75],[11, 57],[12, 59]];
            var visitors = [[1, 25], [2, 50], [3, 23], [4, 48],[5, 38],[6, 40],[7, 47],[8, 55],[9, 43],[10,50],[11,47],[12, 39]];

            var plot = $.plot($("#statsChart"),
                [ { data: visits, label: "Signups"},
                 { data: visitors, label: "Visits" }], {
                    series: {
                        lines: { show: true,
                                lineWidth: 1,
                                fill: true, 
                                fillColor: { colors: [ { opacity: 0.1 }, { opacity: 0.13 } ] }
                             },
                        points: { show: true, 
                                 lineWidth: 2,
                                 radius: 3
                             },
                        shadowSize: 0,
                        stack: true
                    },
                    grid: { hoverable: true, 
                           clickable: true, 
                           tickColor: "#f9f9f9",
                           borderWidth: 0
                        },
                    legend: {
                            // show: false
                            labelBoxBorderColor: "#fff"
                        },  
                    colors: ["#a7b5c5", "#30a0eb"],
                    xaxis: {
                        ticks: [[1, "JAN"], [2, "FEB"], [3, "MAR"], [4,"APR"], [5,"MAY"], [6,"JUN"], 
                               [7,"JUL"], [8,"AUG"], [9,"SEP"], [10,"OCT"], [11,"NOV"], [12,"DEC"]],
                        font: {
                            size: 12,
                            family: "Open Sans, Arial",
                            variant: "small-caps",
                            color: "#697695"
                        }
                    },
                    yaxis: {
                        ticks:3, 
                        tickDecimals: 0,
                        font: {size:12, color: "#9da3a9"}
                    }
                 });

            function showTooltip(x, y, contents) {
                $('<div id="tooltip">' + contents + '</div>').css( {
                    position: 'absolute',
                    display: 'none',
                    top: y - 30,
                    left: x - 50,
                    color: "#fff",
                    padding: '2px 5px',
                    'border-radius': '6px',
                    'background-color': '#000',
                    opacity: 0.80
                }).appendTo("body").fadeIn(200);
            }

            var previousPoint = null;
            $("#statsChart").bind("plothover", function (event, pos, item) {
                if (item) {
                    if (previousPoint != item.dataIndex) {
                        previousPoint = item.dataIndex;

                        $("#tooltip").remove();
                        var x = item.datapoint[0].toFixed(0),
                            y = item.datapoint[1].toFixed(0);

                        var month = item.series.xaxis.ticks[item.dataIndex].label;

                        showTooltip(item.pageX, item.pageY,
                                    item.series.label + " of " + month + ": " + y);
                    }
                }
                else {
                    $("#tooltip").remove();
                    previousPoint = null;
                }
            });
        });
    </script>
</body>

</html>