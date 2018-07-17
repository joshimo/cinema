package com.joshimo.cinema;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CinemaApplication {

	@Bean(name = "sessionFactory")
	public SessionFactory entityManagerFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		return configuration.buildSessionFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}
}
