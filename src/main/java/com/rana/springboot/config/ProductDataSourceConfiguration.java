package com.rana.springboot.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rana.springboot.entites.Product;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "productEntityManagerFactory",transactionManagerRef = "productTransactionManager",basePackages = {"com.rana.springboot.*"})
public class ProductDataSourceConfiguration {
	@Primary
	@Bean(name="productDatasourceproperties")
	@ConfigurationProperties("spring.datasource-product")
	public DataSourceProperties productDatasourceproperties() {
		return new DataSourceProperties();
	
	}
	
	@Primary
	@Bean(name="productDataSource")
	public DataSource productDataSource() {
		return productDatasourceproperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Primary
	@Bean(name="productEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		
		//return builder.dataSource(productDataSource()).packages(Product.class).persistenceUnit("productDataSource").build();
		return builder.dataSource(productDataSource()).packages("com.rana.springboot.*").build();
	}
	
	@Primary
	@Bean(name="productTransactionManager")
	public PlatformTransactionManager productTransactionManager(@Qualifier("productEntityManagerFactory") EntityManagerFactory productEntityManagerFactory) {
		return new JpaTransactionManager(productEntityManagerFactory);
	}
}
