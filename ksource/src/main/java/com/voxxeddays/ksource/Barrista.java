package com.voxxeddays.ksource;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableBinding(Source.class)
@EnableScheduling
@AllArgsConstructor
public class Barrista {

    private final Source source;
    private final CoffeeMachine coffeeMachine;

    @Scheduled(fixedRate = 1000)
    private void serve() {
        source.output().send(MessageBuilder.withPayload(coffeeMachine.pour()).build());
    }
}
