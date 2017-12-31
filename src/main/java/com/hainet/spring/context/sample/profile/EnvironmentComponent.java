package com.hainet.spring.context.sample.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentComponent implements BaseComponent {

    private final String env;

    public EnvironmentComponent(@Value("${env}") final String env) {
        this.env = env;
    }

    @Override
    public String getEnv() {
        return env;
    }
}
