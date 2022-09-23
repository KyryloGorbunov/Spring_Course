package com.kyrylo.springcourse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.kyrylo.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
}
