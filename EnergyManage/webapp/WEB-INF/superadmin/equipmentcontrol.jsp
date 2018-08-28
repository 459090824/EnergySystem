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
	<title>设备控制列表</title>
	<meta name="keywords" content="显示所有设备" />
	<meta name="description" content="显示所有设备" />
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
    <link href="<%=basePath%>admin/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />
    <link href="<%=basePath %>admin/css/lib/jquery.dataTables.css" type="text/css" rel="stylesheet" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="<%=basePath%>admin/css/compiled/adminList.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="<%=basePath %>admin/css/compiled/datatables.css" type="text/css" media="screen" />
	
    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- scripts -->
   	<script src="http://code.jquery.com/jquery-latest.js"></script>  
    <script src="<%=basePath %>admin/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>admin/js/jquery.dataTables.js"></script> 
    <script src="<%=basePath %>admin/js/theme.js"></script>
    
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
        
        <!-- settings changer -->
        <!--
        <div class="skins-nav">
            <a href="#" class="skin first_nav selected">
                <span class="icon"></span><span class="text">Default</span>
            </a>
            <a href="#" class="skin second_nav" data-file="css/compiled/skins/dark.css">
                <span class="icon"></span><span class="text">Dark skin</span>
            </a>
        </div>
        -->
        <div id="pad-wrapper" class="adminList">
            <!-- <div class="row header">
                <h3>设备控制设置列表</h3>
                <div class="col-md-10 col-sm-12 col-xs-12 pull-right">
                     <input type="text" class="col-md-5 search" placeholder="Type a user's name...">  
                     
                    <div class="pull-right" style="padding-bottom:9px;padding-right:15px">         
                    <a id="setting_HMModel" class="btn-flat success new-product"> 手动模式</a>
                    <a id="setting_AUTOModel" class="btn-flat success new-product">智能模式</a>
                   	</div>
                </div>
            </div> -->
            <div class="row head">
                <div class="col-md-12">
                    <h3 class="date">设备控制设置列表</h3>
                </div>
            </div>
            <div class="row filter-block" style="line-height:60px">
                <div class="pull-right" style="padding-bottom:9px;padding-right:15px">
                    <a id="setting_HMModel" class="btn-flat success new-product">手动模式</a>
                    <a id="setting_AUTOModel" class="btn-flat success new-product">智能模式</a>
                </div>
            </div>

            <!-- Users table -->
            <div class="row">
                <div class="col-md-12">
                    <table cellpadding="0" cellspacing="0" border="0" class="" id="example">
                        <thead >
                            <tr>
                                <th class="col-md-1 text-center" >
                                	<input id="checkAll" type="checkbox" onClick="selectAll(this)"></input>
                                   	<span class="line"></span>设备名
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>设备编号
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>设备类型
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>设备子类型
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>是否自动检测能耗
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>设备状态
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>设备控制模式
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>设备位置
                                </th>
                            </tr>
                        </thead>
                        <tbody id="setEquipmentModel">
                        	<c:forEach items="${equipmentunions}" var="equipmentunion" varStatus="status">                        		
                        <!-- row -->
                        <tr class="first">
                            <td class="text-center">
                             	<input id="mainBox" value="${equipmentunion.equipment_ID}" name="subBox" type="checkbox"></input>   
                             		${equipmentunion.equipment_Name}
                            </td>
                            <td class="text-center">                            	
                                ${equipmentunion.equipment_Code}                             
                            </td>
                            <td class="text-center">                           	
                                ${equipmentunion.equipmentType.equipmentType_Name}                             
                            </td> 
                            <td class="text-center">                            	
                                ${equipmentunion.equipmentSubType.equipmentSubType_Name}                             
                            </td> 
                            <td class="text-center">                            	
                                ${equipmentunion.isAuto_Equipment}                             
                            </td> 
                            <td class="text-center">                            	
                                ${equipmentunion.state.state_Name}                             
                            </td> 
                            <td class="text-center">                            	
                                ${equipmentunion.equipmentControlModel.equipmentControlModel_Name}                             
                            </td>
                            <td class="text-center">                            	
                                ${equipmentunion.room.room_Name}                            
                            </td>                                                   
          <!--              <td class="text-center">
                                <i class="table-edit"  name="edit" value="${equipmentunion.equipment_ID}" href="#" title="编辑" style="cursor: pointer;"></i> | <i class="table-delete" name="delete" id="deleteEquipment${equipmentunion.equipment_ID}" value="${equipmentunion.equipment_ID}" href="" title="删除" style="cursor: pointer;"></i>
                            </td>
          -->                       
                        </tr>
                        </c:forEach>
                      
                        </tbody>
                    </table>
                </div>                
            </div>
            <!-- end users table -->
        </div>
    </div>
    <!-- end main container -->


	<!-- scripts -->
    <script type="text/javascript">
        $(document).ready(function() {
            $('#example').dataTable({
                "sPaginationType": "full_numbers",
                "bSort": false,
                "oLanguage": {
                	"sSearch":"搜索:",
                	"sLengthMenu": "每页显示 _MENU_ 条记录",
                	"sZeroRecords": "当前没有任何数据记录",
                	"sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                	"sInfoEmpty": "没有数据",
                	"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                	"oPaginate": {
                	"sFirst": "首页",
                	"sPrevious": "前一页",
                	"sNext": "后一页",
                	"sLast": "尾页"
                	},
                }
            });
        });
    </script>

    <!--edit/delete button-->
    <script type="text/javascript">
        $(function(){
           $("#setting_HMModel").click(function(){
        	   var inputs = document.getElementsByTagName("input");
               var selectlist = new Array();
               for(var i=0,j=0; i<inputs.length; i++) 
               {
               	var obj = inputs[i];
                   if(obj.type == 'checkbox' && obj.id != mainBox && obj.checked){
                   	selectlist.push(obj.getAttribute("value"));
                   	j++;
                   }
               };
               
               $.ajax({
   			   			url:"<%=basePath %>superadmin/judgesetControlModel",
	  					type:"GET",
	  					async:false,
	  				 success:function(msg){
	  					if(msg.success == '1'){
	  					 	if(!selectlist.length){
	  	            	   		alert("请选择设备！");	  	               	 	
	  	            	    }else{
	  							if(confirm("你确定要将所选设备设备为手动模式吗？")){ 
               						$.ajax({
   										url:"setHMModel",
   										type:"POST",
   										traditional:true,
               							data : {'num':j,'selectlist':selectlist },
   										dataType:"json",
   										async:false,
   									success:function(msg){
   										if(msg.success == '1'){
   											alert("所选设备工作模式设置为手动模式！");
   											window.location.href="showSetEquipmentModel"; 
   										}else{
   											alert("设备工作模式设置失败!");
   										}
   									  },
   									error:function(status,data){
   										alert("设备工作模式设置失败1");
   									}   				
   								});		 
	  						  }else{
	   		  						alert("已取消");
 		  						}
	  	            	      }
	  					     }else{
	   		  						alert("您没有此权限！");
	   		  					}
	   		  					  return false;
	   		  				  },
	   		  				error:function(status,data){
	    						
	    						alert("设备工作模式设置失败2");
	    						return false;           
	    					} 
           				});
	  	            });
        			
           
           $("#setting_AUTOModel").click(function(){
        	   var inputs = document.getElementsByTagName("input");
               var selectlist = new Array();
               for(var i=0,j=0; i<inputs.length; i++) 
               {
               	var obj = inputs[i];
                   if(obj.type == 'checkbox' && obj.id != mainBox && obj.checked){
                   	selectlist.push(obj.getAttribute("value"));
                   	j++;
                   }
               };
               
               $.ajax({
			   	    url:"<%=basePath %>superadmin/judgesetControlModel",
 					type:"GET",
 					async:false,
 				 success:function(msg){
 					if(msg.success == '1'){
 					 	if(!selectlist.length){
 	            	   		alert("请选择设备！");	  	               	 	
 	            	    }else{
 							if(confirm("你确定要将所选设备设备为自动模式吗？")){ 
          						$.ajax({
										url:"setAUTOModel",
										type:"POST",
										traditional:true,
          							data : {'num':j,'selectlist':selectlist },
										dataType:"json",
										async:false,
									success:function(msg){
										if(msg.success == '1'){
											alert("所选设备工作模式设置为自动模式！");
											window.location.href="showSetEquipmentModel"; 
										}else{
											alert("设备工作模式设置失败!");
										}
									  },
									error:function(status,data){
										alert("设备工作模式设置失败1");
									}   				
								});		 
 						  }else{
  		  						alert("已取消");
	  						}
 	            	      }
 					     }else{
  		  						alert("您没有此权限！");
  		  					}
  		  					  return false;
  		  				  },
  		  				error:function(status,data){
   						
   						alert("设备工作模式设置失败2");
   						return false;           
   					} 
      				});
 	            });
         });
    </script>
    
    <script type="text/javascript">
        function selectAll(e){
        	 var obj = document.getElementsByName("subBox");
             var flag = true; 
            for(var i=0; i<obj.length; i++) 
            {
                if(!obj[i].checked){
                    flag = false;
                }
                obj[i].checked = true; 
            }
            if(flag){
                for(var i=0; i<obj.length; i++) 
                {
                    obj[i].checked = false; 
                }
            } 
        }
    </script>
    
</body>
</html>