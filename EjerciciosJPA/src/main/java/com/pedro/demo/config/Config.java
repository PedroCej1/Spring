package com.pedro.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

/**
 * Clase de configuración de Spring.
 * Habilita la gestión de transacciones y define el TransactionManager
 * utilizado por JPA en la aplicación.
 */
@Configuration
@EnableTransactionManagement
public class Config {

    /**
     * Define el gestor de transacciones para JPA.
     *
     * @param emf fábrica de EntityManager proporcionada por JPA
     * @return instancia de PlatformTransactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

}