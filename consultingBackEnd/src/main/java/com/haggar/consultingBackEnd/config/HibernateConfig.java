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
@ComponentScan(basePackages={"com.haggar.consultingBackEnd.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	
	//
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/Database_Vente"; 
	private final static String DATABASE_DRIVER = "org.h2.Driver"; 
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect"; 
	private final static String DATABASE_USERNAME = "haggar"; 
	private final static String DATABASE_PASSWORD = ""; 
	
	
	
	// dataSource bean will be  available  //seulement private(sauf erreur de ma part)
		@Bean
		public DataSource getDataSource () {
			
			BasicDataSource dataSource = new BasicDataSource ();
			
			// providing the database connection information
			dataSource.setUrl(DATABASE_URL);
			dataSource.setDriverClassName(DATABASE_DRIVER);
			dataSource.setUsername(DATABASE_USERNAME);
			dataSource.setPassword(DATABASE_PASSWORD);
			
			return dataSource;
			
		}
		
		//session factory bean will be  available
		
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource) {
			
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
			
			
			builder.addProperties(getHibernateProperties());
			builder.scanPackages("com.haggar.consultingBackEnd.dto");
			
			
			return builder.buildSessionFactory();
			
		}
		
		//All the hibernate properties will be returned in this methode

		private Properties getHibernateProperties() {
			
			Properties properties = new Properties();
			
			properties.put("hibernate.dialect", DATABASE_DIALECT);
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");
	 
			return properties;
		}
		
		
		// Transaction Manager Bean
		@Bean	
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)	{
			
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			
			return transactionManager;
		}
			
			

}
