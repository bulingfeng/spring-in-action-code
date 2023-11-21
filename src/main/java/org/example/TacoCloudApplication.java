package org.example;

import org.example.entity.WriteEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
public class TacoCloudApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TacoCloudApplication.class, args);
        System.out.println("applicationContext init success");
        WriteEntity writeEntity = applicationContext.getBean(WriteEntity.class);
        writeEntity.print("hello world");
    }


    @Bean
    @Lazy(value = false)
    public WriteEntity getWriteEntity(){
        return new WriteEntity("test-entity");
    }
}