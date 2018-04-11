package com.spring.activemq.service;

import org.junit.runner.RunWith;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.junit.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liuhongbing on 2018/4/10.
 */

@Service
/*
* Spring中进行单元测试
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:activemq-Consumer1.xml","classpath:activemq.xml"})
public class Producer {



    /*Spring中进行单元测试*/
    @Test
    public void send(){
        sendMsg(null,"1234567890");
    }


    @Resource
    private JmsTemplate jmsTemplate;

    public void sendMsg(Destination destination , final String msg) {
        System.out.println("开始调用发送消息....");
        for (int i = 0; i < 5; i++) {
            if(null == destination){
                destination = jmsTemplate.getDefaultDestination();
            }
            jmsTemplate.send(destination,new MessageCreator() {
                                 @Override
                                 public Message createMessage(Session session) throws JMSException {
                                     return session.createTextMessage(msg);
                                 }
                             }
            );
        }

    }
}
