package get;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class MicroserviceGetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGetApplication.class, args);
	}
}

