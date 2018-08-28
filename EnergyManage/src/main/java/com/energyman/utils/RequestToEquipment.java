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
          
        //���豸�˷��������豸��IP��ַ���豸�˼����Ķ˿ں�  
        Socket client = new Socket(InetAddress.getLocalHost(), 9090);  
          
                  //ͨ��printWriter �����豸�˷�����Ϣ  
        PrintWriter printWriter = new PrintWriter(client.getOutputStream());  
        System.out.println("����������������...");  
                    
                  //������Ϣ  
        printWriter.println(equipment_Code);  
          
        printWriter.flush();  
          
        //InputStreamReader�ǵͲ�͸߲㴮��֮�������  
        //client.getInputStream()��Socketȡ�����봮��  
        InputStreamReader streamReader = new InputStreamReader(client.getInputStream());  
          
        //�������ݴ���������BufferedReader����ȡ����BufferReader���ӵ�InputStreamReder  
        BufferedReader reader = new BufferedReader(streamReader);  
        String advice =reader.readLine();            
        System.out.println("���յ��豸�˵���Ϣ ��"+advice);
        
        reader.close(); 
        client.close();
        
        System.out.println(advice);
        
        if(Integer.parseInt(advice)==equipment_Code){
        	System.out.println("�����������...");
        		return true;
        }else{
        	System.out.println("��������ʧ��...");
        		return false;
        }
        
    }  
      
//    public static void main(String[] args) throws UnknownHostException, IOException {  
//        RequestToEquipment c = new RequestToEquipment();  
//        c.handler(12345);  
//    }  
}
