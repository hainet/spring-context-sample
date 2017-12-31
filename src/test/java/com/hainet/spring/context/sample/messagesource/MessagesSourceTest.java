package com.hainet.spring.context.sample.messagesource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessagesSourceTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    public void defaultImplementation() {
        assertThat(
                messageSource,
                is(instanceOf(ResourceBundleMessageSource.class))
        );
    }

    @Test
    public void keyValue() {
        assertThat(
                messageSource.getMessage("key", null, null),
                is("value")
        );
    }

    @Test
    public void placeholder() {
        assertThat(
                messageSource.getMessage("placeholder", new String[]{"placeholder"}, null),
                is("placeholder")
        );
    }

    @Test
    public void multiplePlaceholder() {
        assertThat(
                messageSource.getMessage("multiple-placeholder", new String[]{"zero", "one"}, null),
                is("zero\tone")
        );
    }

    @Test
    public void defaultMessageSourceResolvable() {
        MessageSourceResolvable messageSourceResolvable = new DefaultMessageSourceResolvable("resolved-message");
        assertThat(
                messageSource.getMessage("resolved-placeholder", new MessageSourceResolvable[]{messageSourceResolvable}, null),
                is("resolved-message")
        );
    }

    @Test
    public void locale() {
        // messages.properties -> messages_XX.propertiesの順に呼び出される。
        // messages.propertiesが存在しない場合、org.springframework.context.NoSuchMessageExceptionが発生する。
        assertThat(
                messageSource.getMessage("language", null, Locale.JAPANESE),
                is("日本語")
        );
        assertThat(
                messageSource.getMessage("language", null, Locale.ENGLISH),
                is("English")
        );

        // LocaleをXXに指定した状態で、
        // messages.propertiesに存在し、messages_XX.propertiesに存在しないキーを指定した場合、
        // messages.propertiesの値が使用される。
        assertThat(
                messageSource.getMessage("key", null, Locale.JAPANESE),
                is("value")
        );
    }
}
