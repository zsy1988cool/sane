package com.sane.partake.config.rmi;

import com.sane.partake.service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

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
}
