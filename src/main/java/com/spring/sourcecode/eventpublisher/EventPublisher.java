package com.spring.sourcecode.eventpublisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * 2.编写事件发布者
 */
public class EventPublisher implements ApplicationEventPublisherAware{

    private String word;

    public void setWord(String word) {
        this.word = word;
    }

    private ApplicationEventPublisher tradeEventPublisher;

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.tradeEventPublisher=applicationEventPublisher;
    }

    public void say(){
        System.out.println("say:"+this.word);
        TradeEvent tradeEvent = new TradeEvent(new String(word));
        this.tradeEventPublisher.publishEvent(tradeEvent);


    }
}
