<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 时间格式转换 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String picPath =  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>编辑管理员信息</title>
	<meta name="keywords" content="显示管理员信息表单" />
	<meta name="description" content="显示管理员信息表单" />
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

	<!-- scripts -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>    
    <script src="<%=basePath %>admin/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>admin/js/theme.js"></script>
    
     <script src="<%=basePath %>admin/js/selfdefine/ajaxfileupload.js"></script>
    <script src="<%=basePath %>admin/js/ueditor1_4_3/ueditor.config.js"></script>
    <script src="<%=basePath %>admin/js/ueditor1_4_3/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script src="<%=basePath %>admin/js/ueditor1_4_3/lang/zh-cn/zh-cn.js"></script>
    
    <script src="<%=basePath %>admin/laydate/laydate.js"> </script>
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
        
        <div id="pad-wrapper" class="new-user">
            <div class="row header">
                <div class="col-md-12">
                    <h3>编辑管理员</h3>
                </div>                
            </div>
            
            
            <div class="row filter-block" style="padding-bottom:20px;padding-left:10px">
            <div class="col-md-3 form-sidebar">
	                <div class="btn-group toggle-inputs hidden-tablet">
	                    <button id="button-infor" class="glow left active" data-input="normal" style="width: 65px; height: 31px;font-size=12px;" >信息</button>
	                    <button id="button-author" class="glow right" data-input="inline" style="width: 65px; height: 31px;font-size=12px;">权限</button>
	                </div>
	        </div>
			</div>

            <div class="row form-wrapper">
                <!-- left column -->
                  <div class="col-md-9 with-sidebar">
                    <div class="container">
                    	<form name="form_uploadImg" action="" method="POST" enctype="multipart/form-data">
                         <div class="col-md-12 field-box">
                            <label>上传头像:</label>
                            <div style="margin-left:135px;">
                                 <div id="preview">
                                    <img id="imghead" width=130 height=130 border=0 src="<%=picPath%>energysystem/upload/img/${admin.littleheadportrait}" >  
                            	 </div>
	                                 <div style="margin-top:7px;margin-bottom:3px;">
	                                    <input id="uploadFileInput" name="uploadFileInput" class="input" type="file" onchange="previewImage(this)"> 	                                    
	                                 </div> 
                            </div>
                          </div>
                         </form>
                        <form id="new_user_form" class="new_user_form">
                        <input id="fileName" type="hidden" name="fileName" value="${admin.littleheadportrait}">
                            <div class="col-md-12 field-box">
                                <label>用户名:</label>
                                <input type="hidden" id="systemadminid" name="systemadminid" value="${admin.systemadminid}">
                                <input class="form-control" type="text" id="username" name="username" value="${admin.username }" onblur="checkUserName()"/>
                                <span id="username_msg"></span>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>性别:</label>
                                <div class="ui-select span5">
                                    <select id="gender" name="gender">  
                                       <c:if test="${admin.gender == 1}">
                                       	  <option value="${admin.gender}" selected="selected">男</option>
                                       </c:if> 
                                       <c:if test="${admin.gender == 0}">
                                       	  <option value="${admin.gender}" selected="selected">女</option>
                                       </c:if>
                                       <c:if test="${admin.gender != 0 || admin.gender != 1}">                              	                                	
                                     	<option value="1">男</option>
                                     	<option value="0">女</option>
                                       </c:if>     
                                    </select>
                                </div>
                            </div>
                  	    	<div class="col-md-12 field-box">
                                <label>生日:</label>
                                <input class="laydate-icon"  id="birthday" name="birthday" onclick="laydate()"  value="<fmt:formatDate value="${admin.birthday}" pattern="yyyy-MM-dd " />" />
                            </div>
                                                
                            <div class="col-md-12 field-box">
                                <label>密码:</label>
                                <input class="col-md-9 form-control" type="text" id="password" name="password" value="${admin.password }" onblur="checkPassword()"/>
                                <span id="password_msg"></span>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>Email:</label>
                                <input class="col-md-9 form-control" type="text" id="email" name="email" value="${admin.email }" onblur="checkEmail()"/>
                                <span id="email_msg"></span>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>电话:</label>
                                <input class="col-md-9 form-control" type="text" id="telephone" name="telephone" value="${admin.telephone }" onblur="checkMobilePhone()"/>
                                <span id="telephone_msg"></span>
                            </div>
                            <div class="col-md-12 field-box">
                                <label>地址:</label>
                                <input class="col-md-9 form-control" type="text" id="address" name="address" value="${admin.address }" onblur="checkAddress()"/>
                                <span id="address_msg"></span>
                            </div>                       
                            <div class="col-md-11 field-box actions">
                                <input type="button" class="btn-glow primary" value="提交" id="submit-form">
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

  
	<!-- scripts 
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<%=basePath %>admin/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>admin/js/theme.js"></script>
	-->
	
    <script type="text/javascript">
        $(function () {
            // toggle form between inline and normal inputs
            $("#submit-form").click(function () {
                $.ajax({
                	url:"../submitEditAdmin",
                	type : "post",
                	data : $('#new_user_form').serialize(),
                	dataType:"json",
                	success:function(msg){
                		if(msg.success == '1'){
                			alert("编辑成功");
	                		setTimeout(function tiaozhuan(){
	                			window.location.href='../allAdmin'
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
        	var systemadminid = document.getElementById("systemadminid").getAttribute('value');
            // toggle form between inline and normal inputs
            var $buttons = $("#button-author");
            $buttons.click(function () {
            	window.location.href="../editAdminAuthority/"+systemadminid;
            });
        });
    </script>
    
     <script type="text/javascript">  
    function ajaxFileUpload() {  
       $.ajaxFileUpload({  
	   		 url:"<%=basePath %>superadmin/upLoadImage", //需要链接到服务器地址
           secureuri:false,
           fileElementId:"uploadFileInput",  //文件选择框的id属性  
           dataType: "json",   //服务器返回的格式，可以是json  
           complete: function () {//只要完成即执行，最后执行  
  		 	altert("complete");
           }, 
           success:function(data, status)  //相当于java中try语句块的用法  
           {     
          	 if(data.success == '1'){
          		 alert("图片选取成功");
          	 	document.getElementById("fileName").value = data.fileName;  
          	 }else{
          		 alert("图片选取失败，请重新选取！！！\n否则将设置为默认图片！！！");
          		document.getElementById("fileName").value = data.fileName;
          	 }
           },  
           error:function(data, status, e)             //相当于java中catch语句块的用法  
           {  
          	 alert("图片选取失败，请重新选取！！！\n否则将设置为默认图片！！！");
      		document.getElementById("fileName").value = data.fileName;
           }  
         }  
       );  
    }  
    </script> 
    
    
     <script type="text/javascript">
        //图片上传预览    IE是用了滤镜。
        function previewImage(file)
        {
          var MAXWIDTH  = 260; 
          var MAXHEIGHT = 180;
          var div = document.getElementById('preview');
          if (file.files && file.files[0])
          {
              div.innerHTML ='<img id=imghead>';
              var img = document.getElementById('imghead');
              img.onload = function(){
                var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                img.width  =  rect.width;
                img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
                img.style.marginTop = rect.top+'px';
              }
              var reader = new FileReader();
              reader.onload = function(evt){img.src = evt.target.result;}
              reader.readAsDataURL(file.files[0]);       
          }
          else //兼容IE
          {
            var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
            file.select();
            var src = document.selection.createRange().text;
            div.innerHTML = '<img id=imghead>';
            var img = document.getElementById('imghead');
            img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
            var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
            status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
            div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
          }

          ajaxFileUpload();
        }
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight )
            {
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;
                 
                if( rateWidth > rateHeight )
                {
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else
                {
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }
             
            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        }
</script>
 <script type="text/javascript">
 function checkUserName(){  
	    //1. 获取文本框的值   
	    var name=document.getElementById("username").value;
	    var patt1=new RegExp("^[a-zA-Z0-9\u4E00-\u9FA5_]+$");
	    if(!name.length){
	    	$("#username_msg")[0].style.color="red";
	    	$("#username_msg").html("用户名不能为空");	   
	    }else if(!patt1.test(name)){
	    	  $("#username_msg")[0].style.color="red";  
	    	  $("#username_msg").html("由字母、数字、下划线、汉字组成");  
	    }else{
	    	  $("#username_msg").html(""); 
	    }
	  }
 
 function checkMobilePhone(){  
	    //1. 获取文本框的值   
	    var telephone=document.getElementById("telephone").value;
	    var patt2=new RegExp("(\\+\\d+)?1[3458]\\d{9}$");
	    if(!telephone.length){
	    	$("#telephone_msg")[0].style.color="red";
	    	$("#telephone_msg").html("手机号不能为空");
	    }else if(!patt2.test(telephone)){
	    	  $("#telephone_msg")[0].style.color="red";  
	    	  $("#telephone_msg").html("请输入正确的手机号");  
	    }else{
	    	 $("#telephone_msg").html("");
	    }
	    }
 function checkEmail(){  
	    //1. 获取文本框的值   
	    var email=document.getElementById("email").value;
	    var patt3=new RegExp("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$");
	    if(!email.length){
	    	  $("#email_msg")[0].style.color="red";  
	    	  $("#email_msg").html("邮箱不能为空");
	    }else if(!patt3.test(email)){
	    	  $("#email_msg")[0].style.color="red";  
	    	  $("#email_msg").html("请输入正确的邮箱");  
	    }else{
	    	$("#email_msg").html("");
	    }
	    }
 function checkAddress(){  
	    //1. 获取文本框的值   
	    var address=document.getElementById("address").value;
	    var patt4=new RegExp("^[0-9\u4E00-\u9FA5]+$");
	    if(!patt4.test(address)){
	    	  $("#address_msg")[0].style.color="red";  
	    	  $("#address_msg").html("请输入正确地址");  
	    }
	    else{
	    	$("#address_msg").html(""); 
	    }
	    }
 function checkPassword(){
	  //1. 获取文本框的值   
	    var password=document.getElementById("password").value;
//	    var patt4=new RegExp("^[0-9\u4E00-\u9FA5]+$");
	    if(!password.length){
	    	  $("#password_msg")[0].style.color="red";  
	    	  $("#password_msg").html("密码不能为空");  
	    }
	    else{
	    	$("#password_msg").html(""); 
	    }
 }
 </script>
</body>
</html>