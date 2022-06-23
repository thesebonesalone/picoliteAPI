package com.picolite.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan({"com.picolite.controllers"})
public class MVCconfig extends WebMvcConfigurerAdapter {
}
