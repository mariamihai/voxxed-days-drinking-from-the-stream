package com.voxxeddays.kprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.SendTo;

@Slf4j
@EnableBinding(Processor.class)
@MessageEndpoint
public class CoffeeTransformer {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    Coffee transform(Coffee inCoffee) {
        Coffee outCoffee = new Coffee(
                inCoffee.getId(),
                inCoffee.getRoast().toLowerCase(),
                inCoffee.getName().toUpperCase(),
                inCoffee.getModifier().toLowerCase());

        log.info(outCoffee.toString());

        return outCoffee;
    }
}
