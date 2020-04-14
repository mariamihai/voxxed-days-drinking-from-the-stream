package com.voxxeddays.ksource;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class CoffeeMachine {

    private final String[] roast = "Light roast, Dark roast, Medium roast, Italian roast, French roast".split(", ");
    private final String[] names = "Colombian, Ethiopian, Guatemalan, Kona, Brazilian, Turkish, Cuban, Java".split(", ");
    private final String[] modifiers = "Select Batch, Black Label, Premium Blend, Limited Run, Platinum Edition".split(", ");

    private final Random rand = new Random();
    private int i = 0, j = 0, k = 0;

    Coffee pour() {
        i = rand.nextInt(roast.length);
        j = rand.nextInt(names.length);
        k = rand.nextInt(modifiers.length);

        return new Coffee(
                UUID.randomUUID().toString(),
                roast[i],
                names[j],
                modifiers[k]);
    }
}
