package com.hss.activemq.test.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class Producer {

    @Test
    public void send() throws Exception{
//1.初始化spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-activemq.xml");
        //2.获取到jmstemplate的对象
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        //3.获取destination
        Destination destination = (Destination) context.getBean(Destination.class);
        //4.发送消息
        jmsTemplate.send(destination, new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("通过spring发送的消息123");
            }
        });
        Thread.sleep(100000);
    }

}
