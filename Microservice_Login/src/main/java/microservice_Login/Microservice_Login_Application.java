package microservice_Login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class Microservice_Login_Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice_Login_Application.class, args);
	}
}
