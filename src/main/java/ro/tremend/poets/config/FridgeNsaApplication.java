package ro.tremend.poets.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ro.tremend.poets"})
public class FridgeNsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FridgeNsaApplication.class, args);
	}
}
