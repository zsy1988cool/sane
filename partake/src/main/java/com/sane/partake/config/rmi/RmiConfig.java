package com.sane.partake.config.rmi;

import com.sane.partake.service.intellisense.ThesaurusService;
import com.sane.partake.service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@Configuration
public class RmiConfig {

    @Bean
    public RmiServiceExporter rmiServiceExporter(UserService userService){
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(UserService.class);
        rmiServiceExporter.setService(userService);
        rmiServiceExporter.setServiceName("userService");
        rmiServiceExporter.setRegistryPort(1799);

        return rmiServiceExporter;
    }

    @Bean
    public HandlerMapping hessionHandlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties properties = new Properties();
        properties.setProperty("/thea.service", "hessianServiceExporter");
        mapping.setMappings(properties);

        return mapping;
    }
    @Bean
    public HessianServiceExporter hessianServiceExporter(ThesaurusService thesaurusService) {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(thesaurusService);
        exporter.setServiceInterface(ThesaurusService.class);
        return exporter;
    }
}
