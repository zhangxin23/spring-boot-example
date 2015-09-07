package org.sandbox.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * Author: zhangxin
 * Date:   15-9-7
 */
@Configuration
public class JmsConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }
}
