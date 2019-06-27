package workshop.spring5.persistence.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
/*
    TODO 2 - dodaj adnotacje
    @EnableTransactionManagement
    @ComponentScan, przeskanuj pakiety:
                                workshop.spring5.persistence.hibernate,
                                workshop.spring5.persistence.hibernate.service
 */
public class MainConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/bookee");
        dataSource.setUsername("my_user");
        dataSource.setPassword("my_password");
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

    /*
        TODO 4
        Utwórz definicję ziarna dla Springa - LocalSessionFactoryBean

        public LocalSessionFactoryBean sessionFactory(){}

        W metodzie ustaw w obiekcie LocalSessionFactoryBean:
                        setDataSource - DataSource (już napisana w tej klasie definicja)
                        setPackagesToScan - pakiety do przeskanowania: workshop.spring5.persistence.hibernatemodel
                        setHibernateProperties - obiekt Properties, zdefiniowany wcześniej w klasie

     */

    /*
        TODO 5
        Utwórz definicję ziarna dla Springa - PlatformTransactionManager

        public PlatformTransactionManager hibernateTransactionManager(){}

        Zwróć z metody obiekt HibernateTransactionManager z ustawioną SessionFactory
        (pobrana z definicji bean'a sessionFactory() ).
     */
}