package br.com.challenge.challengestarwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ChallengeStarwarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeStarwarsApplication.class, args);
	}

}
