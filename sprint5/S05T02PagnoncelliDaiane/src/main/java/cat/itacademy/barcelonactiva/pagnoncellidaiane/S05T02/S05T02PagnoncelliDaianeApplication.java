package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository")
@EnableMongoRepositories(basePackages = "cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository")
public class S05T02PagnoncelliDaianeApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T02PagnoncelliDaianeApplication.class, args);
	}
}

