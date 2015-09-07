package org.sandbox.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Author: zhangxin
 * Date:   15-9-7
 */
@Service
public class JmsConsumerService {

    @JmsListener(destination = "sample.queue")
    public void recvQueue(String txt) {
        System.out.println("consumer receive msg: " + txt);
    }
}
