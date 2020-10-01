package com.spring.sourcecode.eventpublisher;

import org.springframework.context.ApplicationListener;

/**
 * 3.最后编写 事件的接收者EventReceiver
 */
public class EventReceiver2 implements ApplicationListener<TradeEvent>{

    public void onApplicationEvent(TradeEvent tradeEvent) {
        System.out.println("监听到的事件2："+tradeEvent.getSource());
        System.out.println("我又干了点别的事儿");
    }
}
