package com.app.shoping_backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.app.shoping_backend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	//change the below based on the DB you choose
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshoppping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASWORD = "";


/*	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/ifinances";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME = "infinite";
	private final static String DATABASE_PASWORD = "skills";
*/
	
	//DataSource Bean
	@Bean
	private DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		
		//providing the database connection information
		
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASWORD);
		
		
		
		return datasource;
		
	}
	
	//sessionFactory Bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperies());
		builder.scanPackages("com.app.shoping_backend.dto");
		return builder.buildSessionFactory();
	
	}

	// All the hinernate properties will be returned in this method
	private Properties getHibernateProperies() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hinermate.show.sql","true");
		properties.put("hibenrate.format.sql", "true");

		return properties;
	}
	
	//Transaction Manager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManger = new org.springframework.orm.hibernate5.HibernateTransactionManager(sessionFactory);
		
		
		return transactionManger;		
	}
	
}

