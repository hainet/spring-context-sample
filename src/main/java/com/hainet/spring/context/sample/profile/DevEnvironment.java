package com.hainet.spring.context.sample.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
// @Profileで指定されたプロファイルの場合のみBeanが生成される。
// 指定はSpELで行うため、!を用いて排他条件で指定可能。
@Profile("dev")
public class DevEnvironment implements BaseEnvironment {

    private final String env;

    public DevEnvironment(@Value("${env}") final String env) {
        this.env = env;
    }

    @Override
    public String getEnv() {
        return env;
    }
}
