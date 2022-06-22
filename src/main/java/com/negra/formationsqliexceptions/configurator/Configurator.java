package com.negra.formationsqliexceptions.configurator;

import com.negra.formationsqliexceptions.mapper.IDocumentDtoSelmaMapper;
import fr.xebia.extras.selma.Selma;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurator {

    @Bean
    public IDocumentDtoSelmaMapper getDocumentDtoSelmaMapper(){
        return Selma.builder(IDocumentDtoSelmaMapper.class).build();
    }

}
