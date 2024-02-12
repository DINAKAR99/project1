package mvcproj.config;

import java.sql.Driver;
import java.util.Properties;

import javax.sql.DataSource;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "mvcproj.*")
public class AppConfig {

    @Bean("viewResolver")
    InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
    }

    @Bean
    DriverManagerDataSource getDataSource() {

        DriverManagerDataSource d1 = new DriverManagerDataSource();
        d1.setDriverClassName("org.postgresql.Driver");
        d1.setUsername("postgres");
        d1.setPassword("dinakar1.");
        d1.setUrl("jdbc:postgresql://localhost:5433/todos");
        return d1;

    }

    @Bean
    LocalSessionFactoryBean getFactory() {

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        localSessionFactoryBean.setDataSource(getDataSource());

        localSessionFactoryBean.setHibernateProperties(getHibeprops());
        localSessionFactoryBean.setPackagesToScan("mvcproj.model");

        return localSessionFactoryBean;
    }

    @Bean
    Properties getHibeprops() {

        Properties p1 = new Properties();

        p1.setProperty("hibernate.hbm2ddl.auto", "update");
        p1.setProperty("hibernate.show_sql", "true");
        p1.setProperty("hibernate.format_sql", "true");

        return p1;

    }

    @Bean
    HibernateTransactionManager getTransaction() {

        return new HibernateTransactionManager(getFactory().getObject());

    }

}
