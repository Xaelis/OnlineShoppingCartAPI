package com.model.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
@Configuration
@EnableTransactionManagement(mode=AdviceMode.PROXY)
@EnableJpaRepositories(basePackages="com.model.repositories.dao", entityManagerFactoryRef="entityManagerFactoryBean")
@ComponentScan(basePackages = {"com.model.repositories"})
public class EntityManagerConfig
{
    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     * @generated
     */
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf)
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		
		return transactionManager;
	}
	
	/**
	 * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
	 * @generated
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
	{
		LocalContainerEntityManagerFactoryBean factory =
			new LocalContainerEntityManagerFactoryBean();
		
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		factory.setJpaVendorAdapter(jpaVendorAdapter);
		
		factory.setDataSource(dataSource());
		factory.setPersistenceUnitName("gmmPersistenceUnit");
		Properties persistenceProperties = new Properties();
		persistenceProperties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		persistenceProperties.put("hibernate.hbm2ddl.auto","update");
		persistenceProperties.put("hibernate.id.new_generator_mappings","true");
		persistenceProperties.put("hibernate.show_sql","false");
		// cache
		persistenceProperties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
		persistenceProperties.put("hibernate.cache.use_second_level_cache","true");
		persistenceProperties.put("hibernate.cache.use_query_cache","true");
		factory.setPersistenceProvider(new HibernatePersistenceProvider());
		factory.setJpaProperties(persistenceProperties);
		factory.setPackagesToScan("com.model.repositories.entities");
		
		return factory;
	}
	
	/**
	 * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
	 * @generated
	 */
	@Bean
	public DataSource dataSource()
	{
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties persistenceProperties = new Properties();
		persistenceProperties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
		persistenceProperties.put("hibernate.connection.url", System.getProperty("JDBC_CONNECTION_STRING"));
		
		
		return new DriverManagerDataSource(System.getProperty("JDBC_CONNECTION_STRING"),
			persistenceProperties);
	}

}

