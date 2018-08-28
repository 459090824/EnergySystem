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
	 * ��string����ת����date����
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
	 * ��õ�ǰ����
	 * @return
	 */
	public static String getNowDate(){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(sdf.format(date));
		return sdf.format(date);
	}
	
	
	/**
	 * ��string����ת����date����
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
	 * ��õ�ǰ���ڵ�ǰһ�� 
	 * @return
	 */
	public static String getProDay(){
		Calendar calendar=Calendar.getInstance();  //��õ�ǰ����
		calendar.add(Calendar.DATE, -1);
		Date date=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(sdf.format(date2));
		return sdf.format(date);
	}
	
	/**
	 * ��õ�ǰ����ǰһ����
	 * @return
	 */
	public static String getProMonth(){
		Calendar calendar=Calendar.getInstance();  //��õ�ǰ����
		calendar.add(Calendar.MONTH, -1);
		Date date=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(sdf2.format(date3));
		return sdf.format(date);
	}
	
	/**
	 * ��õ�ǰ���ڵ�ǰһ��
	 * @return
	 */
	public static String getProYear(){
		Calendar calendar=Calendar.getInstance();  //��õ�ǰ����
		calendar.add(Calendar.YEAR, -1);
		Date date=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(sdf3.format(date4));
		return sdf.format(date);
	}
	
	
	/**
	 * ��json����ת��Ϊ����
	 * @param jsonStr
	 * @return
	 */
	public static DataCollectorDataContent JsonToBean(String jsonStr){
		DataCollectorDataContent dataCollectorDataContent=JSON.parseObject(jsonStr,DataCollectorDataContent.class);
			return dataCollectorDataContent;
	}
	
	/**
	 * ������ת��Ϊjson����
	 * @param dataCollectorDataContent
	 * @return
	 */
	public static String BeanToJson(DataCollectorDataContent dataCollectorDataContent){
		String jsString=JSON.toJSONString(dataCollectorDataContent);
		 	return jsString;
	}
	
	/**
	 * ����admin���û�״̬���ֵ���Ϣ
	 */
	//��¼״̬Ϊ1������״̬Ϊ0
	public static final Integer STATUS_ONLINE = 1;
	public static final Integer STATUS_OFFLINE = 0;
	
	/**
	 * �豸����ģʽ״̬��Ϣ
	 */
	//�ֶ�����ģʽΪ1�����ܿ���ģʽΪ2,��ʼģʽΪ3
	public static final Integer STATUS_HM=1;
	public static final Integer STATUS_AUTO=2;
	public static final Integer STATUS_START=3;
	
	/**
	 * �û�/ϵͳ �豸״̬��Ϣ
	 */
	//�豸��������״̬Ϊ2��δ����״̬Ϊ1�����ڹ���״̬Ϊ3���ǹ���״̬�Ҵ�������״̬Ϊ4������״̬Ϊ5��ɾ��״̬Ϊ6
	public static final Integer STATUS_CONNECT=2;
	public static final Integer STATUS_DISCONNECT=1;
	public static final Integer STATUS_WORK=3;
	public static final Integer STATUS_NONWORK=4;
	public static final Integer STATUS_ERROR=5;
	public static final Integer STATUS_DELETE=6;
	
	/**
	 * ������״̬����
	 */
	//����״̬Ϊ1��ɾ��״̬Ϊ2
	public static final Integer Type_NORMAL=1;
	public static final Integer Type_Delete=2;
	
	/**
	 * ����״̬
	 */
	//�ݶ�����״̬1
	public static final Integer BUILD_STATE=1;
	
	/**
	 * ����״̬
	 */
	//������ʾ״̬Ϊ1�����ܾ���������״̬Ϊ2��ȡ����������״̬Ϊ3
	public static final Integer WARNING_NOTICE=1;
	public static final Integer WARNING_HANDLE=2;
	public static final Integer WARNIGN_CANCLE=3;
	
	/**
	 * �豸����
	 */
	//�ɵ����豸Ϊ1�����ɵ����豸Ϊ2
	public static final Integer DISPATCH_ALLOW=1;
	public static final Integer DISPATCH_FORBID=2;
	
	/**
	 * Ȩ������
	 */
	// ��ʾ  �༭  ɾ��  ���  ����  ����  ����  ȡ��
	public static final Integer SHOW=1; 
	public static final Integer EDIT=2;
	public static final Integer DELETE=3;
	public static final Integer ADD=4;
	public static final Integer CONTROL=5;
	public static final Integer DISPATCH=6;
	public static final Integer HANDLE=7;
	public static final Integer CANCLE=8;
	
	/**
	 * Ȩ��״̬
	 */
	//����״̬��1
	public static final Integer AUTHORITY_NORMAL=1;
	
	/**
	 * ��̨���ܼ���
	 */
	//һ������Ϊ1  ��������Ϊ2
	public static final Integer AdminFunctionLevel_1 = 1;
	public static final Integer AdminFunctionLevel_2 = 2;
	
	/**
	 * ��̨����״̬
	 */
	public static final Integer Function_Status=1;
	
	/**
	 * һ����̨���ܵĸ�����ID
	 */
	public static final Integer AdminFunctionParent = 0;
	
	/**
	 * ��̨�����Ƿ�Ϊ�˵�
	 */
	public static final String isAdminFunctionMeun = "��";
	public static final String noAdminFunctionMeun = "��";
	
	/**
	 * ��̨���ܵ�ͼ��
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
	 *  ���ӻ�������
	 */
	//ʵʱ���   �ܺ�ͳ��    �ܺ�Ԥ��
	public static final Integer EnergyConsumptionMonitor=3;
	public static final Integer EnergyConsumptionTotal=4;
//	public static final Integer EnergyConsumptionPredict=5;
	
	/**
	 * �û��豸������
	 */
	//�豸�����б�  ����豸����   �豸ֵ�����б�  ����豸������  �豸�б�  ����豸 �豸����  �豸�����б�
	public static final Integer EquipmentTypeList=7;
	public static final Integer AddEquipmentType=8;
	public static final Integer EquipmentSubTypeList=9;
	public static final Integer AddEquipmentSubType=10;
	public static final Integer EquipmentList=11;
	public static final Integer AddEquipment=12;
	public static final Integer EquipmentControl=13;
	public static final Integer EquipmentControlList=14;
	
	/**
	 * ���ȹ�����
	 */
	//�豸����  �����б�
	public static final Integer EquipmentDispatch=16;
	public static final Integer DispatchList=17;
	
	/**
	 * ����������
	 */
	//���������б�  �����������  �����б�
	public static final Integer WarningTypeList=19;
	public static final Integer AddWarningType=20;
	public static final Integer WarningList=21;
	
	/**
	 * Ȩ�޹�����
	 */
	//����Ա�б�   ��ӹ���Ա   Ȩ���б�
	public static final Integer AdminList=23;
	public static final Integer AddAdmin=24;
	public static final Integer AuthorityList=25;
	
	/**
	 * ϵͳ����
	 */
	//������Ϣ����  ������������ ������Ϣ���� ������Ϣ����  ������Ϣ����
	public static final Integer AreaInformation=27;
	public static final Integer BuildingTypeInformation=28;
	public static final Integer BuildingInformation=29;
	public static final Integer RoomInformation=30;
	public static final Integer EnergyInformation=31;
	
	/**
	 * ϵͳ�豸����
	 */
	//ϵͳ�豸�����б� ���ϵͳ�豸  ϵͳ�豸�б�  ���ϵͳ�豸
	public static final Integer SystemEquipmentTypeList=33;
	public static final Integer AddSystemEquipmentType=34;
	public static final Integer SystemEquipmentList=35;
	public static final Integer AddSystemEquipment=36;	
}
