package com.jehad.ticket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helth {
    @GetMapping("health")
    public String health() {
        return "health check, every thing is OK";
    }

}

