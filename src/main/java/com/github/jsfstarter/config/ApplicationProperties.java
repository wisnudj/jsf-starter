package com.github.jsfstarter.config;

import javax.ws.rs.DefaultValue;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.FIRST)
@Sources({"classpath:application.properties"})
public interface ApplicationProperties extends Config {
    @Key("db.jdbcurl")
	String jdbcUrl();

	@Key("db.driverClass")
	String dbDriverClass();

	@Key("db.username")
	String dbUsername();

	@Key("db.password")
	String dbPassword();

	@Key("db.maxpool")
	@DefaultValue("100")
	int maxPool();


	@Key("db.autocommit")
	@DefaultValue("true")
	boolean dbAutoCommit();

	@Key("db.automigration")
	@DefaultValue("false")
	boolean dbAutomigration();
}
