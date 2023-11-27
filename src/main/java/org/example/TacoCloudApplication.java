package org.example;

import org.example.config.DevConfig;
import org.example.config.ProdConfig;
import org.example.entity.WriteEntity;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
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


        DevConfig devConfig = applicationContext.getBean(DevConfig.class);
        System.out.println(devConfig);
        ProdConfig prodConfig = applicationContext.getBean(ProdConfig.class);

        System.out.println(prodConfig);

        // use fluent api launch springboot application
//        new SpringApplicationBuilder()
//                .sources(TacoCloudApplication.class)
//                .run(args);

        // shutdown application gracefully
//        System.exit(SpringApplication.exit(SpringApplication.run(TacoCloudApplication.class, args)));



    }

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 42;
    }

    @Bean
    @Lazy(value = false)
    public WriteEntity getWriteEntity(){
        return new WriteEntity("test-entity");
    }
}