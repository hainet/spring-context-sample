package com.hainet.spring.context.profile.sample;

import com.hainet.spring.context.profile.sample.environment.BaseEnvironment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileTest {

    // プロファイルがprodでない場合、devEnvironmentは生成され、prodEnvironmentは生成されない。
    // よってBaseEnvironment型のBeanはdevEnvironmentのみとなり注入に成功する。
    @Autowired
    private BaseEnvironment environment;

    @Test
    public void devEnvironment() {
        assertThat(
                environment.getEnv(),
                is("dev")
        );
    }
}
