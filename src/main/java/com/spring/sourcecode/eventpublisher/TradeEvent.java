package com.spring.sourcecode.eventpublisher;

import org.springframework.context.ApplicationEvent;

/**
 * 1.事件Event
 */
public class TradeEvent extends ApplicationEvent {

    public TradeEvent(Object source) {
        super(source);
        System.out.println("事件：TradeEvent event !!"+source);
    }
}
