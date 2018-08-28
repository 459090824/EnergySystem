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
	<title>创建其它系统设备添加信息</title>
	<meta name="keywords" content="显示信息空白表单" />
	<meta name="description" content="显示信息空白表单" />
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
                    <h3>添加其它系统设备</h3>
                </div>                
            </div>
            
            <div class="row filter-block" style="line-height:10px;margin-bottom:40px">
				<div class="col-md-3 form-sidebar">
	                <div class="btn-group toggle-inputs hidden-tablet">
	                    <button id="button-meter" class="glow left" data-input="normal" style="width: 65px; height: 31px;font-size=12px;" >仪表</button>
	                    <button id="button-sensor" class="glow left" data-input="inline" style="width: 80px; height: 31px;font-size=12px;" >传感器</button>
	                    <button id="button-collector" class="glow right" data-input="inline" style="width: 80px; height: 31px;font-size=12px;">采集器</button>
	                    <button id="button-other" class="glow right active" data-input="inline" style="width: 80px; height: 31px;font-size=12px;">其它</button>
	                </div>
	        	</div> 
	        </div>   
              
            <div class="row form-wrapper">
                <!-- left column -->
                <div class="col-md-9 with-sidebar">
                    <div class="container">
                        <form id="new_user_form1" class="new_user_form">
                            <div class="col-md-12 field-box">
                                <label>设备名:</label>
                                <input class="form-control" type="text" id="systemEquipmentName" name="systemEquipmentName"/>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>设备编号:</label>
                                <input class="form-control" type="text" id="systemEquipmentCode" name="systemEquipmentCode"/>
                            </div>
                            
                            <div class="col-md-12 field-box">
                                <label>设备类型:</label>
                                <div class="ui-select span5">
                                    <select id="systemEquipmentType_ID" name="systemEquipmentType_ID" onclick="branchforSubType(this);">
                                    	<option value="">请选择</option> 
                                       <c:forEach items="${systemEquipmentTypes}" var="systemEquipmentType" varStatus="status">
                                       		<option value="${systemEquipmentType.systemEquipmentType_ID}">${systemEquipmentType.systemEquipmentType_Name}</option>
                                       </c:forEach>
                                    </select>
                                </div>
                            </div>
                            
                            <div class="col-md-12 field-box">
                                <label>设备子类型:</label>
                                <div class="ui-select span5">
                                    <select id="systemEquipmentSubType_ID" name="systemEquipmentSubType_ID">
                                    	<option value="">请选择</option> 
                                       <c:forEach items="${systemEquipmentSubTypes}" var="systemEquipmentSubType" varStatus="status">
                                       		<option value="${systemEquipmentSubType.systemEquipmentSubType_ID}">${systemEquipmentSubType.systemEquipmentSubType_Name}</option>
                                       </c:forEach>
                                    </select>
                                </div>
                            </div>
                                                                                  
                            <div class="col-md-12 field-box">
                                <label>设备位置:</label>
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
                            
         <!--               <div class="col-md-12 field-box">
                                 <input class="form-control" type="text" id="equipment_Name" name="equipment_Name"/>                      
                            </div>
          -->                    
                            <div class="col-md-11 field-box actions">
                            	<input id="connect-form" type="button" class="btn-glow primary" value="连接"/>
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
                	url:"submitAddOtherSystemEquipment",
                	type : "post",
                	data : $('#new_user_form1').serialize(),
                	success:function(msg){
                		if(msg.success == '1'){
                			alert("添加成功");
	                		setTimeout(function tiaozhuan(){
	                			window.location.href='allOtherSystemEquipment'
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
//    	                if(selVal==data[i].region_ID) {  
//    	 sel2.append("<option value=" + data[i].region_ID + " selected=\"true\">" + data[i].region_Name + "</option>");  
//    	                }else {  
//    	sel2.append("<option value=" + data[i].region_ID + ">" + data[i].region_Name + "</option>");  
//    	                }   
    				
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
    
    <script type="text/javascript">
    	function branchforSubType(e){
    		var systemEquipmentType_ID=e.value;    //得到点击的systemEquipmentType_ID的值
    		var sel=$("#systemEquipmentSubType_ID");
    		sel.empty();
    			$.ajax({
    				url:"branchforSubType/"+systemEquipmentType_ID,
    				type : "get",
    				success:function(data){
    	                    for ( var i = 0; i < data.length; i++) {  
    	                		var col = data[i];  
//    	                if(selVal==data[i].region_ID) {  
//    	 sel2.append("<option value=" + data[i].region_ID + " selected=\"true\">" + data[i].region_Name + "</option>");  
//    	                }else {  
//    	sel2.append("<option value=" + data[i].region_ID + ">" + data[i].region_Name + "</option>");  
//    	                }   
    				
    	        				sel.append("<option value=" + data[i].systemEquipmentSubType_ID + ">" + data[i].systemEquipmentSubType_Name + "</option>");              
    	                    }   				
    				}
    			});
    	};    
    </script>
  <script type="text/javascript">
        $(function () {
            // toggle form between inline and normal inputs
            var $buttons = $("#button-meter");
            $buttons.click(function () {
            	window.location.href="onClickAddMeter";
            });
            var $buttons = $("#button-collector");
            $buttons.click(function () {
            	window.location.href="onClickAddDataCollector";
            });
            var $buttons = $("#button-sensor");
            $buttons.click(function () {
            	window.location.href="onClickAddSensor";
            });
        });
 </script>  
</body>
</html>