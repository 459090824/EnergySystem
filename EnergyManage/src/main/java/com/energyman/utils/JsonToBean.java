package com.energyman.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.aop.aspectj.annotation.AbstractAspectJAdvisorFactory;
import org.w3c.dom.ls.LSInput;

import com.alibaba.fastjson.JSON;
import com.energyman.bean.DataCollectorDataContent;

public class JsonToBean {
	
	public static void main(String[] args) throws ParseException{
	
//		DataCollectorDataContent dataCollectorDataContent=new DataCollectorDataContent();
//		dataCollectorDataContent.setEquipment_Code(111234);
//		dataCollectorDataContent.setCurrent_data_meter(345);
//		
//		
//		String jsString=JSON.toJSONString(dataCollectorDataContent);
//		System.out.println(jsString);
//		
//		 
//		DataCollectorDataContent dataCollectorDataContent2=JSON.parseObject(jsString,DataCollectorDataContent.class);
//		System.out.println(dataCollectorDataContent2.toString());
//		
		
//			Date date=new Date();
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println(sdf.format(date));
//			System.out.println(sdf.parse(sdf.format(date)));
//		
//			
//			Calendar calendar=Calendar.getInstance();  //获得当前日期
//			calendar.add(Calendar.DATE, -1);
//			Date date2=calendar.getTime();
//			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println(sdf1.format(date2));
//			
//			
//			Calendar calendar1=Calendar.getInstance();  //获得当前日期
//			calendar1.add(Calendar.MONTH, -1);
//			Date date3=calendar1.getTime();
//			SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println(sdf2.format(date3));
//			
//			
//			Calendar calendar2=Calendar.getInstance();  //获得当前日期
//			calendar2.add(Calendar.YEAR, -1);
//			Date date4=calendar2.getTime();
//			SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd");
//			System.out.println(sdf3.format(date4));
			
			
			List<String> list=new ArrayList<String>();
			list.add("可调度");
			list.add("不可调度");
			list.add("可调度");
			list.add("可调度");
			list.add("不可调度");
			
			
			list =new ArrayList(new HashSet(list));
			System.out.println(list);
			
	}
	
	
}
