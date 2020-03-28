package com.example.cardealerxml.config;

import com.example.cardealerxml.utils.ValidationUtil;
import com.example.cardealerxml.utils.ValidationUtilImpl;
import com.example.cardealerxml.utils.XmlParser;
import com.example.cardealerxml.utils.XmlParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public XmlParser xmlParser(){
        return new XmlParserImpl();
    }


    @Bean
    public ValidationUtil validationUtil(){
        return new ValidationUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public Random random(){
        return  new Random();
    }
}
