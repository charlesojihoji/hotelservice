package com.softel.hotel.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelConfig {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
