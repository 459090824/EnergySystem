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
	<title>建筑列表</title>
	<meta name="keywords" content="显示所有建筑" />
	<meta name="description" content="显示所有建筑" />
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
        
        <div id="pad-wrapper" class="adminList">
        	<div class="row head">
                <div class="col-md-12">
                    <h3 class="date">建筑列表</h3>
                </div>
            </div>
            <div class="row filter-block" style="line-height:60px">
                <div class="pull-right" style="padding-bottom:9px;padding-right:15px">
                    <a class="btn-flat success new-product" href="#" id="addBuilding"> 添加建筑</a>
                </div>
            </div>
            <!--<div class="row header">
                <h3>建筑列表</h3>
                <div class="col-md-10 col-sm-12 col-xs-12 pull-right">
                    <input type="text" class="col-md-5 search" placeholder="Type a user's name...">
                   
                   <a href="<%=basePath %>superadmin/onClickAddBuilding" class="btn-flat success pull-right">
                        <span>&#43;</span>
                      		  添加建筑
                    </a>
                </div>
            </div>-->

            <!-- Users table -->
            <div class="row">
                <div class="col-md-12">
                    <table cellpadding="0" cellspacing="0" border="0" class="" id="example">
                        <thead >
                            <tr>
                                <th class="col-md-2 text-center" >
                                   	<span class="line"></span>建筑名
                                </th>
                                <th class="col-md-2 text-center">
                                    <span class="line"></span>建筑类型
                                </th>
                                <th class="col-md-2 text-center">
                                    <span class="line"></span>所在区域
                                </th>
                                <th class="col-md-2 text-center">
                                    <span class="line"></span>地上层数
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>地下层数
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>操作
                                </th>
                            </tr>
                        </thead>
                        <tbody id="showBuilding">
                        	<c:forEach items="${buildingUnions}" var="buildingUnion" varStatus="status">
                        		
                        <!-- row -->
                        <tr class="first">
                            <td class="text-center">
                             	${buildingUnion.build_Name}
                            </td>
                            <td class="text-center">                            	
                                ${buildingUnion.buildingType.buildType_Name}                            
                            </td>
                            <td class="text-center">
                                ${buildingUnion.area.region_Name}
                            </td>
                            <td class="text-center">
                               ${buildingUnion.buildUp_Floor}
                            </td>
                            <td class="text-center">
                               ${buildingUnion.buildDown_Floor}
                            </td>
                            <td class="text-center">
                                <i class="table-edit"  name="edit" value="${buildingUnion.build_ID}" href="#" title="编辑" style="cursor: pointer;"></i> | <i class="table-delete" name="delete" id="deleteArea${buildingUnion.build_ID}" value="${buildingUnion.build_ID}" href="" title="删除" style="cursor: pointer;"></i>
                            </td>
                                
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
            $("#showBuilding").bind('click','i', function(e){
                var th = e.target.getAttribute('name');
                var build_ID = e.target.getAttribute('value');
                console.log(th);
                console.log(build_ID);
                if (th == 'delete') {
                	$.ajax({
	    				url:"<%=basePath %>superadmin/judgedeleteBuilding",
	    				type:"GET",
	    				//data:{_method:'delete'},
	    				//dataType:"json",
	    				async:false,
	    				success:function(msg){
	    					if(msg.success == '1'){	 
	    						if(confirm("你确信要删除该建筑？")){	    		    							
	    							$.ajax({
	    			    				url:"deleteBuilding/"+build_ID,
	    			    				type:"DELETE",
	    			    				async:false,
	    			    				success:function(msg){		    					
	    		    					    if(msg.success == '1'){
	    		    						   alert("删除成功！");
	    		    						   window.location.href="allBuilding"; 
	    			    				    }else{
	    		    		    			      alert("删除失败！");	
	    		    		    			      }
	    		    						return false;
	    				    			 },
	    				    			 error:function(status,data){	    					
	    				    				  alert("删除失败1");
	    				    				  return false;
	    				    			 }	    		    				    				
	    				    			});
	    						
	    						}else{
	    							 alert("已取消！");
	    							 return false;
	    						}	    		    						    		    		
	    					}else{
	    						alert("您没有此权限！");	
	    					}
	    					return false;
	    				},
	    				error:function(status,data){
	    					
	    					alert("删除失败2");
	    					return false;
	    				}
	    				
	    			});			         
                }
                if(th == 'edit' ){
                    $.ajax({
                        url:"judgeeditBuilding",
                        type:"GET",
                        //data:{_method:'delete'},
                        //dataType:"json",
                        async:false,
                        success:function(msg){
                            if(msg.success == '1'){
                                 if(confirm("你确信要编辑该建筑？")){
                                     window.location.href="editBuilding/" + build_ID;                         
                                 }else{
                                     alert("已取消！");
                                     return false;
                                 }
                            }else{
                                alert("您没有该权限");
                            }
                            return false;
                        },
                        error:function(status,data){
                            
                            alert("编辑失败！");
                            return false;
                        }
                    }); 
                }
            });  
        });
    </script>
   <script type="text/javascript">
        $(function () {
            // toggle form between inline and normal inputs
            $("#addBuilding").click(function () {
                $.ajax({
                	url:"judgeonClickAddBuilding",
                	type : "GET",
                	success:function(msg){  
                		if(msg.success == '1'){
                			if(confirm("你确信要添加建筑？")){
   							 window.location.href="<%=basePath %>superadmin/onClickAddBuilding";    						
   						 }else{
   							 alert("已取消！");
   							 return false;
   						 }
                		}else{
                			alert("您没有此权限！");
                		}
                		return false;
                	},
                	error:function(){
                		alert("添加失败！");
                		return false;
                	}
                });
                
            });
        });
    </script>    
</body>
</html>