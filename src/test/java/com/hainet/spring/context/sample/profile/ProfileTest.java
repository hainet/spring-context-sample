package com.hainet.spring.context.sample.profile;

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

    @Autowired
    private EnvironmentComponent environmentComponent;

    @Test
    public void prodComponent() {
        assertThat(
                environmentComponent.getEnv(),
                is("default")
        );
    }
}
