package com.spring.activemq.service;

import org.springframework.jms.JmsException;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by liuhongbing on 2018/4/10.
 */

public class Consumer {
    public void receive(TextMessage message) throws JmsException, JMSException {
        System.out.print("Consumer----------------");

        String object = (String)message.getText();
        System.out.println("test1:->recive:"+object);


    }
}
