package com.registro.registro.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.util.Objects;

@Configuration
public class DatabaseLoader {

    @Bean
    public CommandLineRunner loadDatabase(JdbcTemplate jdbcTemplate) {
        return args -> {
            // Ejecutar el script SQL al inicio de la aplicación
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
            populator.addScript(new ClassPathResource("data.sql"));
            populator.execute(Objects.requireNonNull(jdbcTemplate.getDataSource()));
        };
    }
}
