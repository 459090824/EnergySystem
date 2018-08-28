<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html class="login-bg">
<head>
	<title>智慧园区能量管理系统</title>
	<meta name="keywords" content="智慧园区能量管理系统" />
	<meta name="description" content="智慧园区能量管理系统" />
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
    <link rel="stylesheet" href="<%=basePath %>admin/css/compiled/signin.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>


    <!-- background switcher -->
    <div class="bg-switch visible-desktop">
        <div class="bgs">
            <a href="#" data-img="landscape.jpg" class="bg active">
                <img src="<%=basePath %>admin/img/bgs/landscape.jpg" />
            </a>
            <a href="#" data-img="blueish.jpg" class="bg">
                <img src="<%=basePath %>admin/img/bgs/blueish.jpg" />
            </a>            
            <a href="#" data-img="7.jpg" class="bg">
                <img src="<%=basePath %>admin/img/bgs/7.jpg" />
            </a>
            <a href="#" data-img="8.jpg" class="bg">
                <img src="<%=basePath %>admin/img/bgs/8.jpg" />
            </a>
            <a href="#" data-img="9.jpg" class="bg">
                <img src="<%=basePath %>admin/img/bgs/9.jpg" />
            </a>
            <a href="#" data-img="10.jpg" class="bg">
                <img src="<%=basePath %>admin/img/bgs/10.jpg" />
            </a>
            <a href="#" data-img="11.jpg" class="bg">
                <img src="<%=basePath %>admin/img/bgs/11.jpg" />
            </a>
        </div>
    </div>


    <div class="login-wrapper">
<!--      
        <a href="<%=basePath %>adminLogin/toIndex">
            <img class="logo" src="<%=basePath %>admin/img/logo-white.png">
        </a>
-->
        <div class="box">
            <div class="content-wrap">
                <h6>登录</h6>
                <form id="new_consultation_form1" class="new_user_form">
                <input class="form-control" id="username" name="username" type="text" placeholder="用户名">
                <input class="form-control" id="password" name="password" type="password" placeholder="密码">
                <a href="#" class="forgot">忘记密码?</a>
                <div class="remember">
                    <input id="remember-me" type="checkbox">
                    <label for="remember-me">记住密码</label>
                </div>
                <a class="btn-glow primary login" id="submit-form" type="button" href="#">登录</a>
                </form>
            </div>
        </div>

       
    </div>

	<!-- scripts -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<%=basePath %>admin/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>admin/js/theme.js"></script>
    <script src="<%=basePath %>admin/js/selfdefine/jquery.cookie.js" ></script>  

    <!-- pre load bg imgs -->
    <script type="text/javascript">
        $(function () {
            // bg switcher
            var $btns = $(".bg-switch .bg");
            $btns.click(function (e) {
                e.preventDefault();
                $btns.removeClass("active");
                $(this).addClass("active");
                var bg = $(this).data("img");

                $("html").css("background-image", "url('<%=basePath %>admin/img/bgs/" + bg + "')");
            });

        });
    </script>
    
    <script type="text/javascript">
        $(function () {
            // toggle form between inline and normal inputs
            $("#submit-form").click(function () {
                $.ajax({
                	url:"toLogin",
                	type : "post",
                	data : $('#new_consultation_form1').serialize(),
                	dataType:"json",
                    async:false,  
                	success:function(msg){
                		if(msg.success == '1'){
                			//alert("添加成功");
                			window.location.href='index';
                		}else{
                			alert("用户名或密码错误!!!");
                		}
                		return false;
                	},
                	error:function(){
                		alert("网络原因，请重试！！");
                		return false;
                	}
                });
                
            });
        });
    </script>
</body>
</html>