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
	<title>智能模式设备列表</title>
	<meta name="keywords" content="显示自动控制设备" />
	<meta name="description" content="显示所有自动控制设备" />
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
            <div class="row head">
                <div class="col-md-12">
                    <h3 class="date">智能模式设备列表</h3>
                </div>
            </div>

            <div class="row filter-block" style="line-height:60px">
     		<div class="col-md-3 form-sidebar">
	                <div class="btn-group toggle-inputs hidden-tablet">
	                    <button id="button-auto" class="glow left active" data-input="normal" style="width: 65px; height: 31px;font-size=12px;" >智能</button>
	                    <button id="button-hm" class="glow right" data-input="inline" style="width: 65px; height: 31px;font-size=12px;">手动</button>
	                </div>
	        </div>
			</div>
 <!--           <div class="pull-right" style="padding-bottom:9px;padding-right:15px">
                    <a class="btn-flat success new-product" href="<%=basePath %>superadmin/onClickAddAdmin" id="addAdmin">添加管理员</a>
                </div>					-->
           

            <div class="row">
                <div class="col-md-12">

                    <table cellpadding="0" cellspacing="0" border="0" class="" id="example">
                        <thead>
                            <tr role="row">
                                <th class="col-md-1 text-center" >
                                   	<span class="line"></span>设备名
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>设备编号
                                </th> 
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>是否自动检测能耗
                                </th>
                                <th class="col-md-1 text-center">
                                    <span class="line"></span>设备状态
                                </th>
                                 <th class="col-md-1 text-center">
                                    <span class="line"></span>设备位置
                                </th>
                                <th class="col-xs-1 text-center">
                                    <span class="line "></span>操作
                                </th>
                            </tr>
                        </thead>
                        <tbody id="showAUTOEquipment">
                        	<c:forEach items="${equipmentUnions}" var="equipmentUnion" varStatus="status">
	                            <!-- row -->
	                          <tr>
	                            <td class="text-center">
                                	${equipmentUnion.equipment_Name}
                            	</td>
                            	<td class="text-center">
                                	${equipmentUnion.equipment_Code}
                            	</td>
                            	<td class="text-center">
                                	${equipmentUnion.isAuto_Equipment}
                            	</td>
                            	<td class="text-center">
                               		${equipmentUnion.state.state_Name}
                            	</td>
                            	<td class="text-center">
                                	${equipmentUnion.room.room_Name}
                            	</td>                          	
	                                <td class="center">
	                                	 <i class="table-delete" name="delete" id="deleteNavigation${equipmentUnion.equipment_ID}" value="${equipmentUnion.equipment_ID }" href="" title="移除列表" style="cursor: pointer;"></i>
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
                }
            });
        });
    </script>

    <script type="text/javascript">
    	$(function(){
    		$("#showAUTOEquipment").bind('click','i', function(e){
    			var th = e.target.getAttribute('name');
    			var equipment_ID = e.target.getAttribute('value');
    			console.log(th);
    			console.log(equipment_ID);
    			if (th == 'delete') {
    				$.ajax({
	    				url:"<%=basePath %>superadmin/judgedeleteEquipmentControlModel",
	    				type:"GET",
	    				//data:{_method:'delete'},
	    				//dataType:"json",
	    				async:false,
	    				success:function(msg){
	    					if(msg.success == '1'){	 
	    						if(confirm("你确信要将该设备移除列表？")){	    		    							
	    							$.ajax({
	    			    				url:"deleteEquipmentAutoModel/"+equipment_ID,
	    			    				type:"DELETE",
	    			    				async:false,
	    			    				success:function(msg){		    					
	    		    					    if(msg.success == '1'){
	    		    						   alert("移除成功！");
	    		    						   window.location.href="showAUTOModelEquipment"; 
	    			    				    }else{
	    		    		    			      alert("移除失败！");	
	    		    		    			      }
	    		    						return false;
	    				    			 },
	    				    			 error:function(status,data){	    					
	    				    				  alert("移除失败1");
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
	    					
	    					alert("移除失败2");
	    					return false;
	    				}
	    				
	    			});			  			
	    											
				} 
				if(th == 'edit' ){
	    			$.ajax({
	    				url:"judgeEdit",
	    				type:"GET",
	    				//data:{_method:'delete'},
	    				//dataType:"json",
	    				async:false,
	    				success:function(msg){
	    					if(msg.success == '1'){
	    						 if(confirm("你确信要编辑该子系统？")){
	    							 window.location.href="editAdmin/" + equipment_ID;    						
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
	    					alert("编辑失败");
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
            var $buttons = $("#button-hm");
            $buttons.click(function () {
            	window.location.href="showHMModelEquipment";
            });
        });
 </script>   
</body>
</html>