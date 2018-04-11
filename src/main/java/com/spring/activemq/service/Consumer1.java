package com.spring.activemq.service;

import org.springframework.jms.JmsException;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by liuhongbing on 2018/4/10.
 */

public class Consumer1 {
    public void receive1(TextMessage message) throws JmsException, JMSException {
        System.out.print("Consumer1----------------");

        String object = (String)message.getText();
        System.out.println("test2:->recive:"+object);


    }


    public  static  void  main(String[] args)
    {
        int[] arr={1,0,8,7,9,3,2,99,222,74};
        for (int i=0;i<arr.length-1;i++)
        {
            for (int j=0;j<arr.length-1-i;j++)
            {
                int temp=0;
                if (arr[j]>arr[j+1])
                {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for (int t:arr)
        {
            System.out.println(t);
        }
    }
}