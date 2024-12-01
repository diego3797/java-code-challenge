package com.prueba.antifraude.msantifraude.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.concurrent.ThreadFactory;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/BdPrueba");
        config.setUsername("postgres");
        config.setPassword("1234");
        config.setDriverClassName("org.postgresql.Driver");
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);
        config.setConnectionTimeout(20000);
        config.setPoolName("PoolTransactionAnti");

        ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
        config.setThreadFactory(virtualThreadFactory);

        return new HikariDataSource(config);
    }
}
