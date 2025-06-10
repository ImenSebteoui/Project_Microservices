package tn.esprit.configServer;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("GIT_USERNAME", dotenv.get("GIT_USERNAME"));
		System.setProperty("GIT_PASSWORD", dotenv.get("GIT_PASSWORD"));
		System.out.println(System.getProperty("GIT_USERNAME"));
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
