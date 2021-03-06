package com.revature;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class OrmConfiguration {
	
	// spring will return this everytime we make the object
	// USE THIS AS THE DRIVER FOR TESTS
	@Bean
	public DataSource dataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setUrl("jdbc:h2:mem:testdb=-1");
			// this is an in memory database
			dataSource.setDriverClassName("org.h2.Driver");
			return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		// This pulls back any @Entity
		sessionFactory.setPackagesToScan("com.revature.beans");
		// This is from other places
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		//TODO add oracle dialect and maybe remove h2 after testing
//		hibernateProperties.setProperty("hibernate.dialect", "ORACLE DIALECT");
		hibernateProperties.setProperty("hibernate.show-sql", "true");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		return hibernateProperties;
	
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	transactionManager.setSessionFactory(sessionFactory().getObject());
	return transactionManager;
	
	}

}
