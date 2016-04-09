package ro.tremend.poets.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;

@SpringBootApplication
@ComponentScan(basePackages = {"ro.tremend.poets"})
@EnableJpaRepositories("ro.tremend.poets.domain")
@EntityScan("ro.tremend.poets.domain")
public class FridgeNsaApplication {

	public static String ROOT = "upload";

	public static void main(String[] args) {
		SpringApplication.run(FridgeNsaApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return (String[] args) -> {
			new File(ROOT).mkdir();
		};
	}
}
