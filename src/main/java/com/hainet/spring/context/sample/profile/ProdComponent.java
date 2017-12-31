package com.hainet.spring.context.sample.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
// @Profileを付与することで指定のプロファイルの場合のみBean生成に成功するようになる。
// 指定はSpELで行うため、!を付与することで「指定のプロファイルでない場合」といった記述も可能。
@Profile("prod")
public class ProdComponent implements BaseComponent {

    private final String env;

    public ProdComponent(@Value("${env}") final String env) {
        this.env = env;
    }

    @Override
    public String getEnv() {
        return env;
    }
}
