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
	<title>创建管理员设置权限</title>
	<meta name="keywords" content="显示权限空白表单" />
	<meta name="description" content="显示权限空白表单" />
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
    <script type="text/javascript">
        function selectAll(){
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
                    <h3>创建管理员</h3>
                </div>
			</div>
            <div class="row filter-block" style="line-height:60px">
                <!-- side right column -->
	            <div class="col-md-3 form-sidebar">
	                <div class="btn-group toggle-inputs hidden-tablet">
	                    <button id="button-infor" class="glow left" data-input="normal" style="width: 65px; height: 31px;font-size=12px;" >信息</button>
	                    <button id="button-author" class="glow right active" data-input="inline" style="width: 65px; height: 31px;font-size=12px;">权限</button>
	                </div>
	        	</div>
             
                <div class="pull-right" style="padding-bottom:9px;padding-right:15px">        
                    <a class="btn-flat success new-product" href="<%=basePath %>admin_authority/showaddauthority/3" title="保存权限"  style="margin-left:15px">保存权限</a>
                </div>
                
            </div>
            
            <div class="row">
                <div class="col-md-12">

                    <table  class="table" cellpadding="0" cellspacing="0" border="0" class="" id="example">
                        <thead>
                            <tr role="row">
                                <th class="col-md-2">
                                	<input id="checkAll" type="checkbox" onClick="selectAll()"></input>
                                    <span class="line"></span>权限名称
                                </th>
                                <th class="col-md-3 center">
                                    <span class="line"></span>权限列表
                                </th>
                                <th class="col-md-1 center">
                                    <span class="line"></span>权限描述
                                </th>               
                                <th class="col-md-1 center">
                                    <span class="line"></span>是否菜单
                                </th>                                                     
                   <!--              <th class="col-md-1 center">
                                    <span class="line"></span>排序
                                </th>
                                <th class="col-md-1 center">
                                    <span class="line "></span>操作
                                </th>
                    -->             
                            </tr>
                        </thead>
                        <tbody id="AddAuthority">
                        	<c:forEach items="${AdminFunctionAuthorities}" var="AdminFunctionAuthority" varStatus="status">
	                            <tr>
	                                <td>
	                                	 <input id="${AdminFunctionAuthority.adminFunction_ID}" value="${AdminFunctionAuthority.adminFunction_ID}" name="subBox" type="checkbox"></input>
	                                    				${AdminFunctionAuthority.function_Name }
	                                </td>
	                                <td>
	                                	<form  id="id${AdminFunctionAuthority.adminFunction_ID }">
		                                    <c:forEach items="${AdminFunctionAuthority.adminFunctionAuthorityList }" var="authority" varStatus="status">
		                                    	<input id="${authority.authorityid}" value="${authority.authorityid}" name="selectedAuthority" type="checkbox">
		                                    	<span name="edit" value="${authority.authorityid}" title="${authority.authoritydescription}" style="cursor: pointer;">${authority.authorityname}</span>
		                                    </c:forEach>	                                	
	                                	</form>
	                                </td>
	                                <td class="center">
	                                    ${AdminFunctionAuthority.function_Description}
	                                </td>
	                               	<td class="center">
	                                    ${AdminFunctionAuthority.iS_Menu}	                              	                                   
	                                </td>	
	                                
	                                	                                
	                         <!--         <td class="center">
	                                    <span class="label label-success">${adminFunctionAuthority.adminFunctionLocation }</span>
	                                </td>
	                               
	                                <td class="center">
	                                	<i class="table-delete" name="delete" id="deleteAdminFunction${adminFunctionAuthority.adminFunctionId }" value="${adminFunctionAuthority.adminFunctionId }" href="#" title="删除该导航所选权限" style="cursor: pointer;"></i>
	                                </td>
	                                 -->
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
            });
        });
    </script>

    <script type="text/javascript">
    	$(function(){
    		$("#AddAuthority").bind('click','i', function(e){
    			var th = e.target.getAttribute('name');
    			var adminFunctionId = e.target.getAttribute('value');
    			var result = $("#id"+adminFunctionId).serialize();
    			console.log(th);
    			console.log(adminFunctionId);
    			if (th == 'delete') {
	    			$.ajax({
	    				url:"deleteauthoritiesofone",
	    				type:"POST",
	                	data : result,
	    				dataType:"json",
	    				async:false,
	    				success:function(msg){
	    					if(msg.success == '1'){
	    						alert("成功删除");
	    						window.location.href="adminfunctionauthority"; 
	    					}else{
	    						alert("删除失败1");
	    					}
	    				},
	    				error:function(status,data){
	    					
	    					alert("删除失败2");
	    				}
	    				
	    			});					
				} 				
    		});
    		
    	});
    </script>
    <script type="text/javascript">
        $(function () {

            // toggle form between inline and normal inputs
            var $buttonsSubsystem = $("#button-subsystem");
            $buttonsSubsystem.click(function () {
            	window.location.href="subsystemauthority";
            });
            var $buttonsOther = $("#button-other");
            $buttonsOther.click(function () {
            	window.location.href="otherauthority";
            });
            var $batchDeleteAdminFunctionAuthority = $("#batchDeleteAdminFunctionAuthority");
            $batchDeleteAdminFunctionAuthority.click(function () {
                var obj = document.getElementsByName("subBox");
                var selectlist = new Array();
                for(var i=0,j=0; i<obj.length; i++) 
                {
                    if(obj[i].checked){
                    	selectlist.push(obj[i].getAttribute("value"));
                    	j++;
                    }
                };
    			$.ajax({
    				url:"deleteadminfunctionauthorities",
    				type:"POST",
    				traditional:true,
                	data : {'num':j,'selectlist':selectlist},
    				dataType:"json",
    				async:false,
    				success:function(msg){
    					if(msg.success == '1'){
    						alert("成功删除");
    						window.location.href="adminfunctionauthority"; 
    					}else{
    						alert("删除失败1");
    					}
    				},
    				error:function(status,data){
    					
    					alert("删除失败2");
    				}
    				
    			});		            	
            });
        });
    </script>
</body>
</html>