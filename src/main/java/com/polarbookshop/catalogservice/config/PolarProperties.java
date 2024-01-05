package com.polarbookshop.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "polar")
// marks the class as source for config props starting with the prefix "polar"
public class PolarProperties {
    /**
     * A message to welcome users.
     */
    private String greeting; // field for custom polar.greeting(prefix + field name)

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
