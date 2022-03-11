package com.colin.annotation.configuration;

import com.colin.annotation.configuration.impl.IntegerStore;
import com.colin.annotation.configuration.impl.StringStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.colin.annotation.configuration")
@Configuration
public class StoreConfig {
    @Bean
    public StringStore stringStore(){
        return new StringStore();
    }

    @Bean
    public IntegerStore integerStore(){
        return new IntegerStore();
    }
}
