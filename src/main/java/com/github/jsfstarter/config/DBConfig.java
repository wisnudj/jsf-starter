package com.github.jsfstarter.config;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.aeonbits.owner.ConfigFactory;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.omnifaces.cdi.Startup;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

@ApplicationScoped
@Startup
public class DBConfig {
    private Jdbi jdbi;

    @PostConstruct
    public void init() {
        ApplicationProperties properties = ConfigFactory.create(ApplicationProperties.class);

        HikariConfig hConfig = new HikariConfig();
        hConfig.setJdbcUrl(properties.jdbcUrl());
        hConfig.setDriverClassName(properties.dbDriverClass());
        hConfig.setUsername(properties.dbUsername());
        hConfig.setPassword(properties.dbPassword());
        hConfig.setMaximumPoolSize(properties.maxPool());
        hConfig.setConnectionTestQuery("select 'abc123'");
        hConfig.setAutoCommit(properties.dbAutoCommit());
        hConfig.setAutoCommit(properties.dbAutoCommit());
        hConfig.addDataSourceProperty("cachePrepStmts", true);
        hConfig.addDataSourceProperty("prepStmtCacheSize",499);
        hConfig.addDataSourceProperty("useServerPrepStmts",true);
        hConfig.setLeakDetectionThreshold(35000);

        HikariDataSource hikari = new HikariDataSource(hConfig);

        jdbi = Jdbi.create(hikari).installPlugin(new SqlObjectPlugin());

        if(properties.dbAutomigration()) startDatabaseMigration();
    }

    private void startDatabaseMigration() {
        try(Liquibase liquibase = new Liquibase("/database-migration/master-changelog.xml", new ClassLoaderResourceAccessor(), new JdbcConnection(jdbi.open().getConnection()))) {
            liquibase.update("");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Produces
    public Jdbi getJdbi() {
        return jdbi;
    }
}
