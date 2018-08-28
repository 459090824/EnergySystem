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
	<title>编辑管理员权限</title>
	<meta name="keywords" content="显示权限表单" />
	<meta name="description" content="显示权限表单" />
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
                    <h3>编辑管理员</h3>
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
                    <a id="batchSetAdminFunctionAuthority" class="btn-flat success new-product" title="为管理员保存权限"  style="margin-left:15px">保存权限</a>
                </div>
                
            </div>
            
            <div class="row">
                <div class="col-md-12">
					<input type="hidden" id="systemadminid" name="systemadminid" value="${systemadminid}">
                    <table  class="table" cellpadding="0" cellspacing="0" border="0" class="" id="example">
                        <thead>
                            <tr role="row">
                                <th class="col-md-2">
                        <!--          	<input id="checkAll" type="checkbox" onClick="selectAll()"></input>   -->
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
                        <tbody id="setAdminAuthority">
                        	<c:forEach items="${AdminFunctionAuthorities}" var="AdminFunctionAuthority" varStatus="status">
	                            <tr>
	                                <td>
	                                  	 <input id="mainBox" value="subBox${AdminFunctionAuthority.adminFunction_ID}" name="subBox" type="checkbox" onclick="selectAll(this);"></input>  
	                                    				${AdminFunctionAuthority.function_Name }
	                                </td>
	                                <td>
	                                	<form  id="id${AdminFunctionAuthority.adminFunction_ID }">
		                                    <c:forEach items="${AdminFunctionAuthority.adminFunctionAuthorityList }" var="authority" varStatus="status">
		                                    	<c:if test="${authority.adminAuthority == true}">
		                                    		<input id="${authority.authorityid}" value="${authority.authorityid}" name="subBox${AdminFunctionAuthority.adminFunction_ID}" type="checkbox" checked="checked">	
		                                    	</c:if>
		                                    	<c:if test="${authority.adminAuthority == false}">
		                                    		<input id="${authority.authorityid}" value="${authority.authorityid}" name="subBox${AdminFunctionAuthority.adminFunction_ID}" type="checkbox">
		                                    	</c:if>		                                  	
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
    	var systemadminid = document.getElementById("systemadminid").getAttribute('value');
        // toggle form between inline and normal inputs
        var $buttons = $("#button-infor");
        $buttons.click(function () {
        	window.location.href="../editAdmin/"+systemadminid;
        });
        
        
        var inputs = document.getElementsByTagName("input");
        var preSelectlist = new Array();
        for(var i=0,j=0; i<inputs.length; i++) 
        {
        	var obj = inputs[i];
            if(obj.type == 'checkbox' && obj.id != 'mainBox' && obj.checked){
            	preSelectlist.push(obj.getAttribute("value"));
            	j++;
            }
        };
        
        var $example_length = $("#example_length");
        $example_length.click(function () {
        	preSelectlist = new Array();
            for(var i=0,j=0; i<inputs.length; i++) 
            {
            	var obj = inputs[i];
                if(obj.type == 'checkbox' && obj.id != 'mainBox' && obj.checked){
                	preSelectlist.push(obj.getAttribute("value"));
                	j++;
                }
            };
        });
        
        var $example_paginate = $("#example_paginate");
        $example_paginate.click(function () {
        	preSelectlist = new Array();
            for(var i=0,j=0; i<inputs.length; i++) 
            {
            	var obj = inputs[i];
                if(obj.type == 'checkbox' && obj.id != 'mainBox' && obj.checked){
                	preSelectlist.push(obj.getAttribute("value"));
                	j++;
                }
            };
        });
        
        var $example_paginate = $("#example_filter");
        $example_paginate.change(function () {
        	preSelectlist = new Array();
            for(var i=0,j=0; i<inputs.length; i++) 
            {
            	var obj = inputs[i];
                if(obj.type == 'checkbox' && obj.id != 'mainBox' && obj.checked){
                	preSelectlist.push(obj.getAttribute("value"));
                	j++;
                }
            };
        }); 
        
        
        var $batchDeleteAuthority = $("#batchSetAdminFunctionAuthority");
        $batchDeleteAuthority.click(function () {
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
				url:"../submitEditAdminAuthority",
				type:"POST",
				traditional:true,
            	data : {'num':j,'selectlist':selectlist,'systemadminid':systemadminid,'preSelectlist':preSelectlist},
				dataType:"json",
				async:false,
				success:function(msg){
					if(msg.success == '1'){
						alert("成功赋予该管理员所选中的权限");
						window.location.href="../allAdmin"; 
					}else{
						alert("赋予该管理员所选中的权限失败1");
					}
				},
				error:function(status,data){
					alert("赋予该管理员所选中的权限失败2");
				}
				
			});		            	
        });
        
    });
    </script>
</body>
</html>