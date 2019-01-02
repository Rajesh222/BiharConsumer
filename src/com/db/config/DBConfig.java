package com.db.config;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_IDLE_TEST_PERIOD;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
import static org.hibernate.cfg.AvailableSettings.GLOBALLY_QUOTED_IDENTIFIERS;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.POOL_SIZE;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class DBConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("com.model.location"));
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("hibernate.connection.driver_class"));
		dataSource.setUrl(env.getProperty("hibernate.connection.url"));
		dataSource.setUsername(env.getProperty("hibernate.connection.username"));
		dataSource.setPassword(env.getProperty("hibernate.connection.password"));
		return dataSource;
	}

	public Properties hibernateProperties() {
		Properties properties = new Properties();
		// Setting Hibernate properties
		properties.put(DIALECT, env.getProperty("hibernate.dialect"));
		properties.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		properties.put(FORMAT_SQL, env.getProperty("hibernate.format_sql"));
		properties.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put(POOL_SIZE, env.getProperty("hibernate.connection.pool_size"));
		properties.put(CURRENT_SESSION_CONTEXT_CLASS, env.getProperty("hibernate.current_session_context_class"));
		properties.put("hibernate.connection.autoReconnect", env.getProperty("hibernate.connection.autoReconnect"));
		properties.put(GLOBALLY_QUOTED_IDENTIFIERS, env.getProperty("hibernate.globally_quoted_identifiers"));
		// Setting C3P0 properties
		properties.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		properties.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		properties.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		properties.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
		properties.put(C3P0_IDLE_TEST_PERIOD, env.getProperty("hibernate.c3p0.idle_test_period"));
		properties.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		properties.put("hibernate.jdbc.lob.non_contextual_creation", "true");
		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
