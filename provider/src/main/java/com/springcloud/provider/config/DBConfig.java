package com.springcloud.provider.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * Created by odfly on 2017/6/8.
 */
@Configuration
public class DBConfig {
    /**
     * 连接地址
     */
    @Value("${spring.datasource.url}")
    private String dbUrl;
    /**
     * 用户名
     */
    @Value("${spring.datasource.username}")
    private String username;
    /**
     * 密码
     */
    @Value("${spring.datasource.password}")
    private String password;
    /**
     * 连接驱动
     */
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        System.out.println("正在建立数据库连接...");
        System.out.println("连接中:" + dbUrl);
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(dbUrl);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);

        hikariConfig.setPoolName("springHikariCP");
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");
        hikariConfig.setAutoCommit(true);

        hikariConfig.setMinimumIdle(5);
        hikariConfig.setMaximumPoolSize(15);
        hikariConfig.setConnectionTimeout(30000);
        hikariConfig.setIdleTimeout(30000);
        hikariConfig.setMaxLifetime(1800000);
        hikariConfig.setConnectionTestQuery("SELECT 1");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        System.out.println("连接完成...");
        return dataSource;
    }
}
