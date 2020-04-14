package com.voxxeddays.ksink;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;

@Slf4j
@EnableBinding(Sink.class)
@MessageEndpoint
public class CoffeeDrinker {

    @StreamListener(Sink.INPUT)
    private void drink(Coffee coffee) {
        log.info(coffee.toString());
    }
}
