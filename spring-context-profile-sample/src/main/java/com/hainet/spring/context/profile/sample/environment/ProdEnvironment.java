package com.hainet.spring.context.profile.sample.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdEnvironment implements BaseEnvironment {

    private final String env;

    public ProdEnvironment(@Value("${env}") final String env) {
        this.env = env;
    }

    @Override
    public String getEnv() {
        return env;
    }
}
