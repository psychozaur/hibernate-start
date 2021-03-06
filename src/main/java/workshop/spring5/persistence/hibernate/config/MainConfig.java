package workshop.spring5.persistence.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


/*
    TODO 2 - dodaj adnotacje
    @EnableTransactionManagement
    @ComponentScan, przeskanuj pakiety:
                                workshop.spring5.persistence.hibernate,
                                workshop.spring5.persistence.hibernate.service
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"workshop.spring5.persistence.hibernate.dao", "workshop.spring5.persistence.hibernate.service"})
public class MainConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/h2/my-dbs/persons.db");
        dataSource.setUsername("sa");
        dataSource.setPassword("qwerty");
        return dataSource;
    }

    /*
        TODO 3
        Utwórz metodę private final Properties hibernateProperties(){}

        W ciele metody utwórz  obiekt java.util.Properties
        Metodą setProperty ustaw
                                hibernate.hbm2ddl.auto na create-drop
                                hibernate.dialect na org.hibernate.dialect.PostgreSQLDialect
        Zwróć obiekt Properties.

     */
    private final Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","create");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");

        return properties;
    }

    /*
        TODO 4
        Utwórz definicję ziarna dla Springa - LocalSessionFactoryBean

        public LocalSessionFactoryBean sessionFactory(){}

        W metodzie ustaw w obiekcie LocalSessionFactoryBean:
                        setDataSource - DataSource (już napisana w tej klasie definicja)
                        setPackagesToScan - pakiety do przeskanowania: workshop.spring5.persistence.hibernate.model
                        setHibernateProperties - obiekt Properties, zdefiniowany wcześniej w klasie

     */

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("workshop.spring5.persistence.hibernate.model");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());

        return localSessionFactoryBean;
    }

    /*
        TODO 5
        Utwórz definicję ziarna dla Springa - PlatformTransactionManager

        public PlatformTransactionManager hibernateTransactionManager(){}

        Zwróć z metody obiekt HibernateTransactionManager z ustawioną SessionFactory
        (pobrana z definicji bean'a sessionFactory() ).
     */

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}