package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 1. @SpringBootApplication:
// Esta é a anotação principal. Ela combina três outras anotações:
//   @Configuration: Marca a classe como fonte de definições de beans.
//   @EnableAutoConfiguration: Tenta configurar automaticamente o Spring
//                            (ex: detecta o H2 e o Tomcat).
//   @ComponentScan: Procura por outros componentes (@Controller, @Service,
//                  @Repository) no pacote 'org.example' e seus subpacotes.
@SpringBootApplication
@EnableJpaRepositories("org.example.Service")
@EntityScan("org.example.Models")
public class CrudApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrudApplication.class, args);
    }
}