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
	<title>编辑建筑信息</title>
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
                    <h3>编辑建筑</h3>
                </div>                
            </div>
            
              
            <div class="row form-wrapper">
                <!-- left column -->
                <div class="col-md-9 with-sidebar">
                    <div class="container">
                        <form id="new_user_form1" class="new_user_form">
                            <div class="col-md-12 field-box">
                                <label>建筑名:</label>
                                 <input type="hidden" name="build_ID" value="${building.build_ID}">
                                <input class="form-control" type="text" id="build_Name" name="build_Name" value="${building.build_Name}"/>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>建筑类型:</label>
                                <div class="ui-select span5">
                                    <select id="buildType_ID" name="buildType_ID">                                   	
                                       <c:forEach items="${buildingTypes}" var="buildingType" varStatus="status">
                                       	  <c:if test="${building.buildType_ID ==buildingType.buildType_ID}">
                                       	  	<option value="${buildingType.buildType_ID}" selected="selected">${buildingType.buildType_Name}</option>
                                       	  </c:if>
                                       	  <c:if test="${building.buildType_ID !=buildingType.buildType_ID}">                                      		
                                       		<option value="${buildingType.buildType_ID}">${buildingType.buildType_Name}</option>
                                       	  </c:if>
                                       </c:forEach>
                                    </select>
                                </div>
                            </div>
                                                        
                            <div class="col-md-12 field-box">
                                <label>所在区域:</label>
                                <div class="ui-select span5">
                                    <select id="region_ID" name="region_ID">                                    	
                                       <c:forEach items="${areas}" var="area" varStatus="status">
                                       	  <c:if test="${building.region_ID == area.region_ID}">
                                       	  	<option value="${area.region_ID}" selected="selected">${area.region_Name}</option>
                                       	  </c:if>
                                       	  <c:if test="${building.region_ID != area.region_ID}">                                       		 
                                       		<option value="${area.region_ID}">${area.region_Name}</option>
                                       	  </c:if>
                                       </c:forEach>
                                    </select>
                                </div>
                            </div>
                             
                            <div class="col-md-12 field-box">
                                <label>建筑地上层数:</label>                  
                                <input class="form-control" type="text" id="buildUp_Floor" name="buildUp_Floor" value="${building.buildUp_Floor}"/>
                            </div>
                            
                            <div class="col-md-12 field-box">
                                <label>建筑地下层数:</label>
                                <input class="form-control" type="text" id="buildDown_Floor" name="buildDown_Floor" value="${building.buildDown_Floor}"/>
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
                	url:"../submitEditBuilding",
                	type : "post",
                	data : $('#new_user_form1').serialize(),
                	success:function(msg){
                		if(msg.success == '1'){
                			alert("编辑成功！");
	                		setTimeout(function tiaozhuan(){
	                			window.location.href='../allBuilding'
	                		});
                		}else{
                			alert("添加失败");
                		}
                		return false;
                	},
                	error:function(){
                		alert("提交失败");
                		return false;
                	}
                });
                
            });
                             
         });
    </script>
    
    
    <script type="text/javascript">
        $(function () {
            // toggle form between inline and normal inputs
            $("#connect-form").click(function () {
                $.ajax({
                	url:"equipmentConnect",
                	type : "get",
                	data : $('#new_user_form1').serialize(),
                	success:function(msg){
                		if(msg.success == '1'){
                			alert("连接成功，可以进行添加");
	                		setTimeout(function tiaozhuan(){
//	                			window.location.href='allArea'
	                		});
                		}else{
                			alert("连接失败");
                		}
                		return false;
                	},
                	error:function(){
                		alert("提交失败");
                		return false;
                	}
                });
                
            });
                  
            });
    </script>
</body>
</html>