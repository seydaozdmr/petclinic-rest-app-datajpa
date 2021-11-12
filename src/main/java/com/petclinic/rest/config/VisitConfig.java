package com.petclinic.rest.config;

import com.petclinic.rest.aspects.Helper;
import com.petclinic.rest.aspects.VisitCounter;
import com.petclinic.rest.aspects.VisitLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class VisitConfig {

    @Bean
    public Helper helper(){
        System.out.println("creating helper");
        return new Helper();
    }

//    @Bean
//    public VisitCounter visitCounter(){
//        return new VisitCounter();
//    }

//    @Bean
//    public VisitLogger visitLogger(){
//        return new VisitLogger();
//    }
}
