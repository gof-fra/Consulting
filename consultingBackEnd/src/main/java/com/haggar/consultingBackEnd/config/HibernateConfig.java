package com.haggar.consultingBackEnd.config;

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
	@ComponentScan(basePackages= {"com.haggar.consultingBackEnd.dto"})
	@EnableTransactionManagement
	public class HibernateConfig {
		
		private static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/Database_consulting";
		private static final String DATABASE_DRIVER = "org.h2.Driver";
		private static final String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
		private static final String	DATABASE_USERNAME = "haggar";
		private static final String	DATABASE_PASSWORD = "";
		
		
		@Bean
		private static final DataSource getDatasource () {
			
			BasicDataSource datasource = new BasicDataSource();
			
			
			// datasource connection information
			
			datasource.setDriverClassName(DATABASE_DRIVER);
			datasource.setUrl(DATABASE_URL);
			datasource.setUsername(DATABASE_USERNAME);
			datasource.setPassword(DATABASE_PASSWORD);
			
			
			return datasource;
			
		}
		
		
		// sessionFactory part
		
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource) {
			
			
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
			
			builder.addProperties(getHibernateProperties());
			builder.scanPackages("com.haggar.consultingBackEnd.dto");
			
			return builder.buildSessionFactory();
		}
		
		// all hibernate properties will be return in this method

		private Properties getHibernateProperties() {
			
			Properties properties = new Properties();
			
			
			properties.put("hibernate.dialect", DATABASE_DIALECT);
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");
			
			return properties;
		}
		
		
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			
			return transactionManager;
			
		}
		
		
		
		
		
	
	

}
