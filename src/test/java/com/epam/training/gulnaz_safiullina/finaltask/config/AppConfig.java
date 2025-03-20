package com.epam.training.gulnaz_safiullina.finaltask.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;

@LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "classpath:config/config.properties", 
    "classpath:config/config-${env}.properties", 
    "system:properties"
})
public interface AppConfig extends Config {
    @Key("baseUrl")
    String baseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("timeout")
    @DefaultValue("5")
    int timeout();
}