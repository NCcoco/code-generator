package com.codegenerator.components;


import com.codegenerator.core.Generator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基础组件配置
 * @author nc
 */
@Configuration
public class BaseComponentsConfig {

    @Bean
    public Generator generator(){
        return new Generator();
    }
}
