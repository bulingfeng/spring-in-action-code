package org.example.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
@Data
@Profile("prod")
@Configuration
public class ProdConfig {
    @Value("${prod-value}")
    private String prodValue;
}
