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
	<title>警报类型列表</title>
	<meta name="keywords" content="显示所有警告类型" />
	<meta name="description" content="显示所有警告类型" />
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
        	<div class="row head">
                <div class="col-md-12">
                    <h3 class="date">警报类型列表</h3>
                </div>
            </div>
            <div class="row filter-block" style="line-height:60px">
                <div class="pull-right" style="padding-bottom:9px;padding-right:15px">
                    <a class="btn-flat success new-product" href="#" id="addWarningType">添加警报类型</a>
                </div>
            </div>
            <!--<div class="row header">
                <h3>警告类型列表</h3>
                <div class="col-md-10 col-sm-12 col-xs-12 pull-right">
                    <input type="text" class="col-md-5 search" placeholder="Type a user's name...">
                           
                    <a href="<%=basePath %>superadmin/onClickAddBuildingType" class="btn-flat success pull-right">
                        <span>&#43;</span>
                      		  添加警告类型
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
                                   	<span class="line"></span>警告类型名
                                </th>
                                <th class="col-md-4 text-center">
                                    <span class="line"></span>类型描述
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>操作
                                </th>
                            </tr>
                        </thead>
                        <tbody id="showWarningType">
                        	<c:forEach items="${warningTypes}" var="warningType" varStatus="status">                        		
                        <!-- row -->
                        <tr class="first">
                            <td class="text-center">
                             	${warningType.warningtypename}
                            </td>
                            <td class="text-center">                            	
                                ${warningType.warningtypedesc}                             
                            </td>                                                  
                            <td class="text-center">
                                <i class="table-edit"  name="edit" value="${warningType.warningtypeid}" href="#" title="编辑" style="cursor: pointer;"></i> | <i class="table-delete" name="delete" id="deleteEnergyType${warningType.warningtypeid}" value="${warningType.warningtypeid}" href="" title="删除" style="cursor: pointer;"></i>
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
            $("#showWarningType").bind('click','i', function(e){
                var th = e.target.getAttribute('name');
                var warningtypeid = e.target.getAttribute('value');
                console.log(th);
                console.log(warningtypeid);
                if (th == 'delete') {
                	$.ajax({
	    				url:"<%=basePath %>superadmin/judgedeletewarningType",
	    				type:"GET",
	    				//data:{_method:'delete'},
	    				//dataType:"json",
	    				async:false,
	    				success:function(msg){
	    					if(msg.success == '1'){	 
	    						if(confirm("你确信要删除该警报类型？")){	    		    							
	    							$.ajax({
	    			    				url:"deletewarningType/"+warningtypeid,
	    			    				type:"DELETE",
	    			    				async:false,
	    			    				success:function(msg){		    					
	    		    					    if(msg.success == '1'){
	    		    						   alert("删除成功！");
	    		    						   window.location.href="allWarningType"; 
	    			    				    }else{
	    		    		    			      alert("删除失败！");	
	    		    		    			      }
	    		    						return false;
	    				    			 },
	    				    			 error:function(status,data){	    					
	    				    				  alert("警报类型正在使用，不允许删除！");
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
                        url:"judgeonClickEditWarningType",
                        type:"GET",
                        //data:{_method:'delete'},
                        //dataType:"json",
                        async:false,
                        success:function(msg){
                            if(msg.success == '1'){
                                 if(confirm("你确信要编辑该警告类型？")){
                                     window.location.href="onClickEditWarningType/" + warningtypeid;                         
                                 }else{
                                     alert("已取消！");
                                     return false;
                                 }
                            }else{
                                alert("您没有该权限！");
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
            $("#addWarningType").click(function () {
                $.ajax({
                	url:"judgeonClickAddWarningType",
                	type : "GET",
                	success:function(msg){  
                		if(msg.success == '1'){
                			if(confirm("你确信要添加警报类型？")){
   							 window.location.href="<%=basePath %>superadmin/onClickAddWarningType";    						
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