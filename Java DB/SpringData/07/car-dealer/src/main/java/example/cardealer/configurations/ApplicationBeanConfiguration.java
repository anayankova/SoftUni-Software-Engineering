package example.cardealer.configurations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import example.cardealer.utils.ValidationUtil;
import example.cardealer.utils.ValidationUtilImpl;
import example.cardealer.utils.XMLParser;
import example.cardealer.utils.XMLParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public XMLParser xmlParser(){
        return new XMLParserImpl();
    }

    @Bean
    public ValidationUtil validationUtil(){
        return new ValidationUtilImpl();
    }

    @Bean
    public BufferedReader bufferedReader(){
        return new BufferedReader(new InputStreamReader(System.in));
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public Gson gson(){
        return new GsonBuilder().setPrettyPrinting().create();
    }

}
