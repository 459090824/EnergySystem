<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>编辑采集器类型信息</title>
	<meta name="keywords" content="显示信息表单" />
	<meta name="description" content="显示信息表单" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <!-- bootstrap -->
    <link href="<%=basePath %>admin/css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath %>admin/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet">

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/icons.css">

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/lib/font-awesome.css">
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="<%=basePath %>admin/css/compiled/new-user.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>

    <!-- navbar -->
    <jsp:include page="include/header.jsp"/>
    <!-- end navbar -->
	<jsp:include page="include/lefter.jsp"/>
    <!-- sidebar -->
    
    <!-- end sidebar -->


	<!-- main container -->
    <div class="content">
        
        <div id="pad-wrapper" class="new-user">
            <div class="row header">
                <div class="col-md-12">
                    <h3>编辑数据采集器类型</h3>
                </div>                
            </div>
 <!--             
             <div class="row filter-block" style="line-height:10px;margin-bottom:40px">
				<div class="col-md-3 form-sidebar">
	                <div class="btn-group toggle-inputs hidden-tablet">
	                    <button id="button-meter" class="glow left" data-input="normal" style="width: 65px; height: 31px;font-size=12px;" >仪表</button>
	                    <button id="button-sensor" class="glow left" data-input="inline" style="width: 80px; height: 31px;font-size=12px;" >传感器</button>
	                    <button id="button-collector" class="glow right active" data-input="inline" style="width: 80px; height: 31px;font-size=12px;">采集器</button>
	                </div>
	        	</div>    
             </div>
-->              
            <div class="row form-wrapper">
                <!-- left column -->
                <div class="col-md-9 with-sidebar">
                    <div class="container">
                        <form id="new_user_form1" class="new_user_form">
                            <div class="col-md-12 field-box">
                                <label>采集器类型名:</label>
                                <input type="hidden" name="collectionType_ID" value="${dataCollectorType.collectionType_ID}">
                                <input class="form-control" type="text" id="collectionType_Name" name="collectionType_Name" value="${dataCollectorType.collectionType_Name}"/>
                            </div>
                            
                             <div class="col-md-12 field-box">
                                <label>类型描述:</label>                 
                                   <div class="col-md-9" style="heigh:1000px;margin-left:-20px">
                                	  <textarea class="form-control" rows="6" id="collectionType_Desc" name="collectionType_Desc">${dataCollectorType.collectionType_Desc}</textarea>
                            	   </div>                               
                            </div>                                            
                            <div class="col-md-11 field-box actions">
                                <input id="submit-form" type="button" class="btn-glow primary" value="提交"/>
                                <span>OR</span>
                                <input type="reset" value="取消" class="reset">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end main container -->


	<!-- scripts -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<%=basePath %>admin/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>admin/js/theme.js"></script>

    <script type="text/javascript">
        $(function () {
            // toggle form between inline and normal inputs
            $("#submit-form").click(function () {
                $.ajax({
                	url:"../submitEditDataCollectorType",
                	type : "post",
                	data : $('#new_user_form1').serialize(),
                	success:function(msg){
                		if(msg.success == '1'){
                			alert("添加成功");
	                		setTimeout(function tiaozhuan(){
	                			window.location.href='../AllDataCollectorType'
	                		},500);
                		}else{
                			alert("提交失败1");
                		}
                		return false;
                	},
                	error:function(){
                		alert("提交失败2");
                		return false;
                	}
                });
                
            });
        });
    </script>
     <script type="text/javascript">
        $(function () {
            // toggle form between inline and normal inputs
            var $buttons = $("#button-meter");
            $buttons.click(function () {
            	window.location.href="onClickAddMeterType";
            });
            var $buttons = $("#button-sensor");
            $buttons.click(function () {
            	window.location.href="onClickAddSensorType";
            });
        });
 </script>  
</body>
</html>