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
	<title>能量管理系统后台管理系统首页左侧功能导航栏</title>
	<meta name="keywords" content="左侧功能导航栏" />
	<meta name="description" content="左侧功能导航栏" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	
	
    <!-- bootstrap -->
    <link href="<%=basePath %>admin/css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="<%=basePath %>admin/css/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet" />

    <!-- libraries -->
    <link href="<%=basePath %>admin/css/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />   
    <link href="<%=basePath %>admin/css/lib/font-awesome.css" type="text/css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>admin/css/compiled/icons.css">

    <!-- this page specific styles -->
    <link rel="stylesheet" href="<%=basePath %>admin/css/compiled/index.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- lato font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>

    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>

    <!-- sidebar -->
    <div id="sidebar-nav">
        <ul id="dashboard-menu">
            <li class="active">
            	<div class="pointer">
                    <div class="arrow"></div>
                    <div class="arrow_border"></div>
                </div>
                <a class="active" href="<%=basePath %>superadmin/index">
                    <i class="icon-home"></i>
                    <span>首页</span>
                </a>
            </li>            
            <li>               
                <a class="dropdown-toggle" href="#">
                    <i class="icon-group"></i>
                    <span>可视化管理</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                	<li><a href="<%=basePath %>superadmin/energyconsumptionmonitor">实时监测</a></li>
                    <li><a href="<%=basePath %>superadmin/energyconsumptiontotal">能耗统计</a></li>
                    <li><a href="<%=basePath %>">能耗预测</a></li>
                </ul>
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-group"></i>
                    <span>用户设备</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                	<li><a href="<%=basePath %>superadmin/allEquipmentType">设备类型列表</a></li>
                	<li><a href="<%=basePath %>superadmin/onClickAddEquipmentType">设备类型添加</a></li>
                	<li><a href="<%=basePath %>superadmin/allEquipmentSubType">设备子类型列表</a></li>
                	<li><a href="<%=basePath %>superadmin/onClickAddEquipmentSubType">设备子类型添加</a></li>
                	<li><a href="<%=basePath %>superadmin/allEquipment">设备列表</a></li>
                	<li><a href="<%=basePath %>superadmin/onClickAddEquipment">设备添加</a></li>
                    <li><a href="<%=basePath %>superadmin/showSetEquipmentModel">设备控制</a></li> 
                    <li><a href="<%=basePath %>superadmin/showAUTOModelEquipment">设备控制列表</a></li>               
                </ul>
            </li>
            
  <!--           
            
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-group"></i>
                    <span>设备管理</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="nav nav-second-level">
                
                <li ><a href="<%=basePath %>">设备信息管理</a>
                <ul class="dropdown-menu">                	               	
                	<li class="dropdown-submenu"><a href="<%=basePath %>superadmin/allEquipmentType">设备类型列表</a></li>
                	<li><a href="<%=basePath %>superadmin/onClickAddEquipmentType">设备类型添加</a></li>
                	<li><a href="<%=basePath %>superadmin/allEquipmentSubType">设备子类型列表</a></li>
                	<li><a href="<%=basePath %>superadmin/onClickAddEquipmentSubType">设备子类型添加</a></li>
                	<li><a href="<%=basePath %>superadmin/allEquipment">设备列表</a></li>
                	<li><a href="<%=basePath %>superadmin/onClickAddEquipment">设备添加</a></li>               	
                </ul>
                </li>
                <li><a href="<%=basePath %>">设备控制管理</a>	  
                 <ul class="dropdown-menu">               	                	                	
                    <li class="dropdown-submenu"><a href="<%=basePath %>superadmin/showSetEquipmentModel">设备控制</a></li> 
                    <li><a href="<%=basePath %>superadmin/showAUTOModelEquipment">设备控制列表</a></li>                               	
                </ul>
                </li>
               </ul>
            </li>
            
            
  -->           
                                                           
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-group"></i>
                    <span>调度管理</span>
                    <i class="icon-chevron-down"></i>
                </a>
              	 <ul class="submenu">
                	<li><a href="<%=basePath %>superadmin/allNormalEquipment">设备调度</a></li>
                    <li><a href="<%=basePath %>superadmin/showNormalDispatch">调度列表</a></li>
                 </ul>
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-edit"></i>
                    <span>警报管理</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                	<li><a href="<%=basePath %>superadmin/allWarningType">警报类型列表</a></li>
                    <li><a href="<%=basePath %>superadmin/onClickAddWarningType">警报类型添加</a></li>
                    <li><a href="<%=basePath %>superadmin/allWarning">警报列表</a></li>
                </ul>
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-th-large"></i>
                    <span>权限管理</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                  	<li><a href="<%=basePath %>superadmin/allAdmin">管理员列表</a></li>
                  	<li><a href="<%=basePath %>superadmin/onClickAddAdmin">创建管理员</a></li>
                  	<li><a href="<%=basePath %>superadmin/onClickAddAdmin">权限列表</a></li>
                </ul>
            </li>
             <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-edit"></i>
                    <span>系统设置</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
      <!--           	<li><a href="<%=basePath %>">园区信息设置</a></li>                    --> 
                    <li><a href="<%=basePath %>superadmin/allArea">区域信息设置</a></li>
                    <li><a href="<%=basePath %>superadmin/allBuildingType">建筑类型设置</a></li>
                    <li><a href="<%=basePath %>superadmin/allBuilding">建筑信息设置</a></li>
                    <li><a href="<%=basePath %>superadmin/allRoom">房间信息设置</a></li>
                    <li><a href="<%=basePath %>superadmin/allEnergy">能源信息设置</a></li>
                </ul>
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-edit"></i>
                    <span>系统设备</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
<!--                  	<li><a href="<%=basePath %>superadmin/AllMeterType">设备类型表</a></li>   -->
                	<li><a href="<%=basePath %>superadmin/showSystemEquipmentType">设备类型表</a></li>
                	<li><a href="<%=basePath %>superadmin/showSystemEquipmentSubType">设备子类型表</a></li>
<!--                     <li><a href="<%=basePath %>superadmin/onClickAddMeterType">设备类型添加</a></li>   --> 
                    <li><a href="<%=basePath %>superadmin/onClickAddSystemEquipmentType">设备类型添加</a></li>
                    <li><a href="<%=basePath %>superadmin/onClickAddSystemEquipmentSubType">设备子类型添加</a></li>
                    <li><a href="<%=basePath %>superadmin/allMeter">设备列表</a></li>
                    <li><a href="<%=basePath %>superadmin/onClickAddMeter">设备添加</a></li>                                                                    
                </ul>
            </li>
            <li>
                <a href="personal-info.html">
                    <i class="icon-cog"></i>
                    <span>我的信息</span>
                </a>
            </li>
            <li>
                <a class="dropdown-toggle" href="#">
                    <i class="icon-share-alt"></i>
                    <span>其他</span>
                    <i class="icon-chevron-down"></i>
                </a>
                <ul class="submenu">
                    <li><a href="code-editor.html">代码编辑器</a></li>
                    <li><a href="grids.html">网格</a></li>
                    <li><a href="signin.html">登录</a></li>
                    <li><a href="signup.html">注册</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!-- end sidebar -->
</body>
</html>