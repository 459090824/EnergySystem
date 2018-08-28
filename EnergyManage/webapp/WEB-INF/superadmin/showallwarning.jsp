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
	<title>警报列表</title>
	<meta name="keywords" content="显示所有警报" />
	<meta name="description" content="显示所有警报" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <!-- libraries -->
    <link href="<%=basePath %>admin/css/lib/jquery.dataTables.css" type="text/css" rel="stylesheet" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="<%=basePath %>admin/css/compiled/datatables.css" type="text/css" media="screen" />

    <!-- self definition -->
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/self/center.css"> 

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
    
	
    <!-- sidebar -->
    <jsp:include page="include/lefter.jsp"/>
    <!-- end sidebar -->
    

	<!-- main container -->
    <div class="content">
        
        <div id="pad-wrapper">
            <div class="row header">
                <h3>警报列表</h3>             
            </div>

            <!-- Users table -->
            <div class="row">
                <div class="col-md-12">
                    <table class="table" cellpadding="0" cellspacing="0" border="0" class="" id="example">
                        <thead >
                             <tr role="row">
                                <th class="col-md-1 text-center" >
                                   	<span class="line"></span>警报编号
                                </th>
                                <th class="col-md-2 text-center">
                                    <span class="line"></span>警报内容
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>警报类型
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>警报等级
                                </th>
                                <th class="col-md-2 text-center">
                                    <span class="line"></span>警报发出时间
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>警报处理状态
                                </th>
                   
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>操作
                                </th>
                                   
                            </tr>
                        </thead>
                        <tbody id="showWarning">
                        	<c:forEach items="${warnings}" var="warning" varStatus="status">
                        		
                        <!-- row -->
                         <tr>
                            <td class="text-center">
                             	${warning.warningid}
                            </td>
                            <td class="text-center">                            	
                                ${warning.warningcontent}                            
                            </td>
                            <td class="text-center">
                                ${warning.warningType.warningtypename}
                            </td>
                            <td class="text-center">
                                <span class="label label-success ">${warning.warninglevel}级</span>
                            </td>                            	                                                                              
                            <td class="text-center">                             
                               <fmt:formatDate value="${warning.warningtime}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
                            </td>
                            <td class="text-center">
                               <c:if test="${warning.processstate==1}">提醒状态</c:if>
                               <c:if test="${warning.processstate==2}">接受提醒状态</c:if>
                               <c:if test="${warning.processstate==3}">取消提醒状态</c:if>
                            </td>                           
                        	<td class="text-center">
                                <i class="icon-cog"  name="handle" value="${warning.warningid}" href="" title="确认处理" style="cursor: pointer;"></i> | <i class="icon-bell-alt" name="cancle" id="deleteArea${warning.warningid}" value="${warning.warningid}" href="" title="取消提醒" style="cursor: pointer;"></i>
                            </td>
                                
                        </tr>
                        </c:forEach>
                      
                        </tbody>
                    </table>
                </div>                
            </div>
      
        </div>
    </div>
    <!-- end main container -->

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
                },
            });
        });
    </script>
	

    <!--handle/cancle button-->
    <script type="text/javascript">
        $(function(){
            $("#showWarning").bind('click','i', function(e){
                var th = e.target.getAttribute('name');
                var warningid = e.target.getAttribute('value');
                console.log(th);
                console.log(warningid);
                if (th == 'handle') {
                	$.ajax({
	    				url:"<%=basePath %>superadmin/judgeHandlewarning",
	    				type:"GET",
	    				//data:{_method:'delete'},
	    				//dataType:"json",
	    				async:false,
	    				success:function(msg){
	    					if(msg.success == '1'){	 
	    						if(confirm("你确信要处理该警报？")){	    		    							
	    							$.ajax({
	    			    				url:"Handlewarning/"+warningid,
	    			    				type:"DELETE",
	    			    				async:false,
	    			    				success:function(msg){		    					
	    		    					    if(msg.success == '1'){
	    		    						   alert("操作成功！");
	    		    						   window.location.href="allWarning"; 
	    			    				    }else{
	    		    		    			      alert("操作失败！");	
	    		    		    			      }
	    		    						return false;
	    				    			 },
	    				    			 error:function(status,data){	    					
	    				    				  alert("操作失败1");
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
	    					
	    					alert("操作失败2");
	    					return false;
	    				}
	    				
	    			});			           
                }
                if(th == 'cancle' ){
                	$.ajax({
	    				url:"<%=basePath %>superadmin/judgeCanclewarning",
	    				type:"GET",
	    				//data:{_method:'delete'},
	    				//dataType:"json",
	    				async:false,
	    				success:function(msg){
	    					if(msg.success == '1'){	 
	    						if(confirm("你确信要取消该警报提醒？")){	    		    							
	    							$.ajax({
	    			    				url:"Canclewarning/"+warningid,
	    			    				type:"DELETE",
	    			    				async:false,
	    			    				success:function(msg){		    					
	    		    					    if(msg.success == '1'){
	    		    						   alert("操作成功！");
	    		    						   window.location.href="allWarning"; 
	    			    				    }else{
	    		    		    			      alert("操作失败！");	
	    		    		    			      }
	    		    						return false;
	    				    			 },
	    				    			 error:function(status,data){	    					
	    				    				  alert("操作失败1");
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
	    					
	    					alert("操作失败2");
	    					return false;
	    				}
	    				
	    			});			           
                }
            });  
        });
    </script>
    
</body>
</html>