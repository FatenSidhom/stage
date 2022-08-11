package com.wevioo.generator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix="spring.demo")
@Configuration
@Getter
@Setter
public class DemoProperties {
        private String output;
        private String input;

}
