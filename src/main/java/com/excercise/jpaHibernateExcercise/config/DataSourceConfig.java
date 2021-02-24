package com.excercise.jpaHibernateExcercise.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "datasource.oracle")
public class DataSourceConfig {
	
	Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
    private String username;
    private String password;
    private String url;
    private String driver;

    @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(16);
        ds.setDriverClassName(this.getDriver());
        ds.setJdbcUrl(this.getUrl());
        ds.setUsername(this.getUsername());
        ds.setPassword(this.getPassword());
        ds.setAutoCommit(false);
        ds.setPoolName("hikariP00l-1" + Math.random());
      //  ds.setInitializationFailFast(false);
        logger.info("HikariDataSource=" + ds);
        
        return ds;
    }

    @Bean(value = "transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public JdbcTemplate jdbcTemplate()  {
        return new JdbcTemplate(dataSource());
    }
}
