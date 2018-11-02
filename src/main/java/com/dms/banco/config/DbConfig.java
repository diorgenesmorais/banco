package com.dms.banco.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dms.banco.model.Grupo;

/**
 * Estou usando um <code>EntityManagerFactory</code> ao invés de um
 * <code>JdbcTemplate</code>
 * 
 * <pre>
 * &#64;Bean
 * public JdbcTemplate jdbcTemplate(DataSource dataSource) {
 * 	System.out.println("JDBC Template no DbConfig...");
 * 	return new JdbcTemplate(dataSource);
 * }
 * </pre>
 * 
 * @author diorgenes
 *
 */
@EnableAutoConfiguration
@Configuration
@EnableTransactionManagement
public class DbConfig {

	private static String ip = "192.168.102.106";
	// TODO automatizar conforme o ambiente
	//private static String url = "jdbc:firebirdsql:192.168.102.119/3050:c:/users/laudeci/downloads/CLIPP.FDB?charSet=utf8";
	//private static String url = "jdbc:firebirdsql:192.168.0.121/3050:c:/Program Files (x86)/CompuFour/Clipp/Base/CLIPP.FDB?charSet=utf8";
	private static String url = String.format("jdbc:firebirdsql:%s/3050:c:/Program Files (x86)/CompuFour/Clipp/Base/CLIPP.FDB?charSet=utf8", ip);

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.firebirdsql.jdbc.FBDriver");
		dataSource.setUrl(url);
		dataSource.setUsername("sysdba");
		dataSource.setPassword("masterkey");
		return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabasePlatform("org.hibernate.dialect.FirebirdDialect");
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		return adapter;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setJpaVendorAdapter(jpaVendorAdapter);
		factory.setPackagesToScan(Grupo.class.getPackage().getName());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	public static String getUrl() {
		return url;
	}
}
