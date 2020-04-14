package com.voxxeddays.ksource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coffee {

    private final String id, roast, name, modifier;
}
