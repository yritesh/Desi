package com.desi.application.dbManagers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.desi.application.utilityClasses.RSAUtil;
import com.google.common.base.Preconditions;

@Configuration
@EnableJpaRepositories(basePackages = "com.desi.application.repository", entityManagerFactoryRef = "postgresEntityManager", transactionManagerRef = "postgresTransactionManager")
public class DbConfig {

	@Autowired
	private Environment env;
	
	public DbConfig() {
		super();
	}
	
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean postgresEntityManager() {
		
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(postgresDataSource());
		entityManagerFactoryBean.setPackagesToScan("com.desi.application.model");
		
		final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		
		final HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("org.hibernate.envers.audit_table_suffix", "_aud");;
		properties.put("hibernate.listeners.envers.autoRegister", true);
		properties.put("hibernate.envers.autoRegisterListeners", true);
		entityManagerFactoryBean.setJpaPropertyMap(properties);
		
		return entityManagerFactoryBean;
	}
	
	@Primary
	@Bean
	public DataSource postgresDataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("spring.datasource.driverClassName")));
		dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("spring.datasource.url")));
		try {
			dataSource.setUsername(
					Preconditions.checkNotNull(RSAUtil.decrypt(env.getProperty("spring.datasource.username"), RSAUtil.privateKey)));
			dataSource.setPassword(
					Preconditions.checkNotNull(RSAUtil.decrypt(env.getProperty("spring.datasource.password"), RSAUtil.privateKey)));
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataSource;
	}

	@Primary
	@Bean
	public PlatformTransactionManager postgresTransactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(postgresEntityManager().getObject());
		return transactionManager;
	}
}
