package com.spring.sourcecode.eventpublisher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        EventPublisher eventPublisher= (EventPublisher) ctx.getBean("eventPublisher");
        eventPublisher.say();
    }
}
