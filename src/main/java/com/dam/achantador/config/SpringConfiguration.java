package com.dam.achantador.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableEurekaClient
@ComponentScan("com.dam.achantador")
@EnableJpaRepositories("com.dam.achantador.dao")
public class SpringConfiguration {


}
