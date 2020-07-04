package com.configserverdemo.ConfigServerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.config.VaultConfiguration;

import com.configserverdemo.configuration.VaultConfigurationClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
@SpringBootApplication
@EnableConfigServer
@EnableConfigurationProperties(VaultConfigurationClass.class)
public class ConfigServerDemoApplication  implements CommandLineRunner{

	private final VaultConfigurationClass vaultConfiguration;
	public ConfigServerDemoApplication(VaultConfigurationClass configuration) {
	    this.vaultConfiguration = configuration;
	  }

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerDemoApplication.class, args);
	}
	@Override
	public void run(String... args) {

	  Logger logger = LoggerFactory.getLogger(ConfigServerDemoApplication.class);

	  logger.info("----------------------------------------");
	  logger.info("Configuration properties");
	  logger.info("   mysql.username is {}", vaultConfiguration.getUsername());
	  logger.info("   mysql.password is {}", vaultConfiguration.getPassword());
	  logger.info("----------------------------------------");
	}
}

