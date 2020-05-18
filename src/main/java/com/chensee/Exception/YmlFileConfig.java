package com.chensee.Exception;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class YmlFileConfig {
    @Bean
    public PropertySourcesPlaceholderConfigurer yaml1() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("sysExceptionConfig.yml"),new ClassPathResource("customExceptionConfig.yml"));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }
}
