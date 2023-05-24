package com.imgai.kaka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KakaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KakaApplication.class, args);
	}

}
