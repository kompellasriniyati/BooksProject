package com.niit.booksback.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.booksback.model.Cartitems;
import com.niit.booksback.model.Category;
import com.niit.booksback.model.Product;
import com.niit.booksback.model.Supplier;
import com.niit.booksback.model.User;



@Configuration
@ComponentScan
@EnableTransactionManagement
public class Dbconfig {
	
	@Bean(name="ds")
	public DataSource getDataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/booksdb");
		ds.setUsername("sa");
		ds.setPassword("password");
		System.out.println("Database Propeties");
		return ds;
	}
    private Properties getHibernateProperties()
    {
    	Properties prop=new Properties();
    	prop.put("hibernate.show_sql","true");
    	prop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
    	prop.put("hibernate.hbm2ddl.auto","update");
        System.out.println("Hibernate Properties");
        return prop;
    }
    @Autowired
    @Bean(name="sessionFactory")
    public SessionFactory getSessionFactory(DataSource datasource)
    {
        LocalSessionFactoryBuilder sf=new LocalSessionFactoryBuilder(datasource);
        sf.addProperties(getHibernateProperties());
        sf.addAnnotatedClass(User.class);
        sf.addAnnotatedClass(Category.class);
        sf.addAnnotatedClass(Supplier.class);
        sf.addAnnotatedClass(Product.class);
        sf.addAnnotatedClass(Cartitems.class);
        System.out.println("Session Factory Properties");
        return sf.buildSessionFactory();
    }
    @Bean(name="txManager")
    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
    {
    	System.out.println("==============================HibernateTransactionManager object Created===================");
    	return new HibernateTransactionManager(sessionFactory);
    }
    }
