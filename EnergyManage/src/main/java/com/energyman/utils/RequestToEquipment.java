package com.energyman.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class RequestToEquipment {
	 
    public boolean handler(int equipment_Code) throws UnknownHostException, IOException{  
          
        //向设备端发送请求，设备端IP地址和设备端监听的端口号  
        Socket client = new Socket(InetAddress.getLocalHost(), 9090);  
          
                  //通过printWriter 来向设备端发送消息  
        PrintWriter printWriter = new PrintWriter(client.getOutputStream());  
        System.out.println("发出建立连接请求...");  
                    
                  //发送消息  
        printWriter.println(equipment_Code);  
          
        printWriter.flush();  
          
        //InputStreamReader是低层和高层串流之间的桥梁  
        //client.getInputStream()从Socket取得输入串流  
        InputStreamReader streamReader = new InputStreamReader(client.getInputStream());  
          
        //链接数据串流，建立BufferedReader来读取，将BufferReader链接到InputStreamReder  
        BufferedReader reader = new BufferedReader(streamReader);  
        String advice =reader.readLine();            
        System.out.println("接收到设备端的消息 ："+advice);
        
        reader.close(); 
        client.close();
        
        System.out.println(advice);
        
        if(Integer.parseInt(advice)==equipment_Code){
        	System.out.println("建立连接完成...");
        		return true;
        }else{
        	System.out.println("建立连接失败...");
        		return false;
        }
        
    }  
      
//    public static void main(String[] args) throws UnknownHostException, IOException {  
//        RequestToEquipment c = new RequestToEquipment();  
//        c.handler(12345);  
//    }  
}
