package microserviceSkel1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class MicroserviceSkel1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSkel1Application.class, args);
	}
}
