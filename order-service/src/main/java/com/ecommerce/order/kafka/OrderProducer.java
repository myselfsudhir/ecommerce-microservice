package com.ecommerce.order.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private final KafkaTemplate<String,String> template;
    public  OrderProducer(KafkaTemplate<String,String> template){
        this.template = template;
    }

    public void sendOrderEvent(String message){
        template.send("order-created",message);
    }

}
