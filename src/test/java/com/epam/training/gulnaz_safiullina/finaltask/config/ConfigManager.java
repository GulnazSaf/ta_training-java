package com.epam.training.gulnaz_safiullina.finaltask.config;

import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration manager to handle environment-specific properties.
 */
public class ConfigManager {
    private static AppConfig config;
    private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);

    private ConfigManager() {
    }

    public static AppConfig getInstance() {
        if (config == null) {
            String env = System.getProperty("env");
            logger.info("Current environment property value: {}", env);
            
            if (env == null) {
                env = "dev"; // Default to dev if not set
                System.setProperty("env", env);
                logger.info("Setting default environment to: {}", env);
            }

            config = ConfigFactory.create(AppConfig.class);
            logger.info("ConfigManager instance created with environment: {}", env);

        }
        return config;
    }
} 