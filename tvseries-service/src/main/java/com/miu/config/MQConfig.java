package com.miu.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Bean
    public Queue queue() {
        return new Queue("deleteSeries", true);
    }

    @Bean
    FanoutExchange userFanoutExchange() {
        return new FanoutExchange("deleteSeries-fanout-exchange");
    }


    @Bean
    public Binding binding(Queue queue, FanoutExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange);
    }

}
