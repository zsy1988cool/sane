package com.sane.partake.config.app;

import com.sane.partake.config.db.DataSourceConfig;
import com.sane.partake.config.db.RedisConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import({DataSourceConfig.class, RedisConfig.class})
@ComponentScan(basePackages = { "com.sane.partake" },
                            excludeFilters = {
                                 @ComponentScan.Filter(type= FilterType.ANNOTATION, value= EnableWebMvc.class)
                            })
public class RootConfig {
}
