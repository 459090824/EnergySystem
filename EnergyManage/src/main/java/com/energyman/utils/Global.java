package com.energyman.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.springframework.context.support.StaticApplicationContext;

import com.alibaba.fastjson.JSON;
import com.energyman.bean.DataCollectorDataContent;
import com.mysql.jdbc.StatementInterceptor;

public class Global {
	
	/**
	 * 将string类型转换成date方法
	 * @param str
	 * @return date
	 * @throws ParseException
	 */
	public static Date StringToData(String str) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
		Date date=sdf.parse(str);
		sdf.format(date);
		return date;
	}
	
	/**
	 * 获得当前日期
	 * @return
	 */
	public static String getNowDate(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(sdf.format(date));
		return sdf.format(date);
	}
	
	
	/**
	 * 将string类型转换成date方法
	 * @param str
	 * @return date
	 * @throws ParseException
	 */
	public static Date StringTo(String str) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=sdf.parse(str);
		sdf.format(date);
		return date;
	}
	
	/**
	 * 获得当前日期的前一天 
	 * @return
	 */
	public static String getProDay(){
		Calendar calendar=Calendar.getInstance();  //获得当前日期
		calendar.add(Calendar.DATE, -1);
		Date date=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(sdf.format(date2));
		return sdf.format(date);
	}
	
	/**
	 * 获得当前日期前一个月
	 * @return
	 */
	public static String getProMonth(){
		Calendar calendar=Calendar.getInstance();  //获得当前日期
		calendar.add(Calendar.MONTH, -1);
		Date date=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(sdf2.format(date3));
		return sdf.format(date);
	}
	
	/**
	 * 获得当前日期的前一年
	 * @return
	 */
	public static String getProYear(){
		Calendar calendar=Calendar.getInstance();  //获得当前日期
		calendar.add(Calendar.YEAR, -1);
		Date date=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(sdf3.format(date4));
		return sdf.format(date);
	}
	
	
	/**
	 * 将json对象转换为对象
	 * @param jsonStr
	 * @return
	 */
	public static DataCollectorDataContent JsonToBean(String jsonStr){
		DataCollectorDataContent dataCollectorDataContent=JSON.parseObject(jsonStr,DataCollectorDataContent.class);
			return dataCollectorDataContent;
	}
	
	/**
	 * 将对象转换为json对象
	 * @param dataCollectorDataContent
	 * @return
	 */
	public static String BeanToJson(DataCollectorDataContent dataCollectorDataContent){
		String jsString=JSON.toJSONString(dataCollectorDataContent);
		 	return jsString;
	}
	
	/**
	 * 设置admin中用户状态数字的信息
	 */
	//登录状态为1，下线状态为0
	public static final Integer STATUS_ONLINE = 1;
	public static final Integer STATUS_OFFLINE = 0;
	
	/**
	 * 设备控制模式状态信息
	 */
	//手动控制模式为1，智能控制模式为2,初始模式为3
	public static final Integer STATUS_HM=1;
	public static final Integer STATUS_AUTO=2;
	public static final Integer STATUS_START=3;
	
	/**
	 * 用户/系统 设备状态信息
	 */
	//设备处于连接状态为2，未连接状态为1，处于工作状态为3，非工作状态且处于连接状态为4，故障状态为5，删除状态为6
	public static final Integer STATUS_CONNECT=2;
	public static final Integer STATUS_DISCONNECT=1;
	public static final Integer STATUS_WORK=3;
	public static final Integer STATUS_NONWORK=4;
	public static final Integer STATUS_ERROR=5;
	public static final Integer STATUS_DELETE=6;
	
	/**
	 * 对类型状态定义
	 */
	//正常状态为1，删除状态为2
	public static final Integer Type_NORMAL=1;
	public static final Integer Type_Delete=2;
	
	/**
	 * 建筑状态
	 */
	//暂定建筑状态1
	public static final Integer BUILD_STATE=1;
	
	/**
	 * 警告状态
	 */
	//警报提示状态为1，接受警报并处理状态为2，取消警报提醒状态为3
	public static final Integer WARNING_NOTICE=1;
	public static final Integer WARNING_HANDLE=2;
	public static final Integer WARNIGN_CANCLE=3;
	
	/**
	 * 设备类型
	 */
	//可调度设备为1，不可调度设备为2
	public static final Integer DISPATCH_ALLOW=1;
	public static final Integer DISPATCH_FORBID=2;
	
	/**
	 * 权限类型
	 */
	// 显示  编辑  删除  添加  控制  调度  处理  取消
	public static final Integer SHOW=1; 
	public static final Integer EDIT=2;
	public static final Integer DELETE=3;
	public static final Integer ADD=4;
	public static final Integer CONTROL=5;
	public static final Integer DISPATCH=6;
	public static final Integer HANDLE=7;
	public static final Integer CANCLE=8;
	
	/**
	 * 权限状态
	 */
	//正常状态：1
	public static final Integer AUTHORITY_NORMAL=1;
	
	/**
	 * 后台功能级别
	 */
	//一级功能为1  二级功能为2
	public static final Integer AdminFunctionLevel_1 = 1;
	public static final Integer AdminFunctionLevel_2 = 2;
	
	/**
	 * 后台功能状态
	 */
	public static final Integer Function_Status=1;
	
	/**
	 * 一级后台功能的父功能ID
	 */
	public static final Integer AdminFunctionParent = 0;
	
	/**
	 * 后台功能是否为菜单
	 */
	public static final String isAdminFunctionMeun = "是";
	public static final String noAdminFunctionMeun = "否";
	
	/**
	 * 后台功能的图标
	 *
	 */
	public static final List<String> ICONCLASSNAME = new ArrayList<String>(Arrays.asList(
		    "icon-adjust", "icon-asterisk", "icon-ban-circle", "icon-bar-chart", "icon-barcode", "icon-beaker", 
		    "icon-beer", "icon-bell", "icon-bell-alt", "icon-bolt", "icon-book", "icon-bookmark", 
		    "icon-bookmark-empty", "icon-briefcase", "icon-bullhorn", "icon-calendar", "icon-camera",
		    "icon-camera-retro", "icon-certificate", "icon-check", "icon-check-empty", "icon-circle", 
		    "icon-circle-blank", "icon-cloud", "icon-cloud-download", "icon-cloud-upload", "icon-coffee", 
		    "icon-cog", "icon-cogs", "icon-comment", "icon-comment-alt", "icon-comments", "icon-comments-alt",
		    "icon-credit-card", "icon-dashboard", "icon-desktop", "icon-download", "icon-download-alt", 
		    "icon-edit", "icon-envelope", "icon-envelope-alt", "icon-exchange", "icon-exclamation-sign",
		    "icon-external-link", "icon-eye-close", "icon-eye-open", "icon-facetime-video", "icon-fighter-jet",
		    "icon-film", "icon-filter", "icon-fire", "icon-flag", "icon-folder-close", "icon-folder-open",
		    "icon-folder-close-alt", "icon-folder-open-alt", "icon-food", "icon-gift", "icon-glass", "icon-globe",
		    "icon-group", "icon-hdd", "icon-headphones", "icon-heart", "icon-heart-empty", "icon-home", 
		    "icon-inbox", "icon-info-sign", "icon-key", "icon-leaf", "icon-laptop", "icon-legal",
		    "icon-lemon", "icon-lightbulb", "icon-lock", "icon-unlock", "icon-magic", "icon-magnet",
		    "icon-map-marker", "icon-minus", "icon-minus-sign", "icon-mobile-phone", "icon-money",
		    "icon-move", "icon-music", "icon-off", "icon-ok", "icon-ok-circle", "icon-ok-sign", 
		    "icon-pencil", "icon-picture", "icon-plane", "icon-plus", "icon-plus-sign", "icon-print",
		    "icon-pushpin", "icon-qrcode", "icon-question-sign", "icon-quote-left", "icon-quote-right",
		    "icon-random", "icon-refresh", "icon-remove", "icon-remove-circle", "icon-remove-sign", 
		    "icon-reorder", "icon-reply", "icon-resize-horizontal", "icon-resize-vertical", "icon-retweet",
		    "icon-road", "icon-rss", "icon-screenshot", "icon-search", "icon-share", "icon-share-alt",
		    "icon-shopping-cart", "icon-signal", "icon-signin", "icon-signout", "icon-sitemap", "icon-sort",
		    "icon-sort-down", "icon-sort-up", "icon-spinner", "icon-star", "icon-star-empty", "icon-star-half",
		    "icon-tablet", "icon-tag", "icon-tags", "icon-tasks", "icon-thumbs-down", "icon-thumbs-up",
		    "icon-time", "icon-tint", "icon-trash", "icon-trophy", "icon-truck", "icon-umbrella",
		    "icon-upload", "icon-upload-alt", "icon-user", "icon-user-md", "icon-volume-off", "icon-volume-up",
		    "icon-warning-sign", "icon-wrench", "icon-zoom-in", "icon-zoom-out", "icon-play-circle", "icon-play",
		    "icon-pause", "icon-stop", "icon-step-backward", "icon-fast-backward", "icon-backward", "icon-forward", "icon-fast-forward", 
		    "icon-step-forward", "icon-eject", "icon-fullscreen", "icon-resize-full", "icon-resize-small",
		    "icon-html5", "icon-phone-sign", "icon-facebook", "icon-facebook-sign", "icon-twitter", 
		    "icon-twitter-sign", "icon-github", "icon-css3", "icon-github-sign", "icon-linkedin", 
		    "icon-linkedin-sign", "icon-pinterest", "icon-pinterest-sign", "icon-google-plus", 
		    "icon-google-plus-sign", "icon-sign-blank"));
	
	/**
	 *  可视化管理功能
	 */
	//实时监测   能耗统计    能耗预测
	public static final Integer EnergyConsumptionMonitor=3;
	public static final Integer EnergyConsumptionTotal=4;
//	public static final Integer EnergyConsumptionPredict=5;
	
	/**
	 * 用户设备管理功能
	 */
	//设备类型列表  添加设备类型   设备值类型列表  添加设备子类型  设备列表  添加设备 设备控制  设备控制列表
	public static final Integer EquipmentTypeList=7;
	public static final Integer AddEquipmentType=8;
	public static final Integer EquipmentSubTypeList=9;
	public static final Integer AddEquipmentSubType=10;
	public static final Integer EquipmentList=11;
	public static final Integer AddEquipment=12;
	public static final Integer EquipmentControl=13;
	public static final Integer EquipmentControlList=14;
	
	/**
	 * 调度管理功能
	 */
	//设备调度  调度列表
	public static final Integer EquipmentDispatch=16;
	public static final Integer DispatchList=17;
	
	/**
	 * 警报管理功能
	 */
	//警报类型列表  警报类型添加  警报列表
	public static final Integer WarningTypeList=19;
	public static final Integer AddWarningType=20;
	public static final Integer WarningList=21;
	
	/**
	 * 权限管理功能
	 */
	//管理员列表   添加管理员   权限列表
	public static final Integer AdminList=23;
	public static final Integer AddAdmin=24;
	public static final Integer AuthorityList=25;
	
	/**
	 * 系统设置
	 */
	//区域信息设置  建筑类型设置 建筑信息设置 房间信息设置  能量信息设置
	public static final Integer AreaInformation=27;
	public static final Integer BuildingTypeInformation=28;
	public static final Integer BuildingInformation=29;
	public static final Integer RoomInformation=30;
	public static final Integer EnergyInformation=31;
	
	/**
	 * 系统设备管理
	 */
	//系统设备类型列表 添加系统设备  系统设备列表  添加系统设备
	public static final Integer SystemEquipmentTypeList=33;
	public static final Integer AddSystemEquipmentType=34;
	public static final Integer SystemEquipmentList=35;
	public static final Integer AddSystemEquipment=36;	
}
