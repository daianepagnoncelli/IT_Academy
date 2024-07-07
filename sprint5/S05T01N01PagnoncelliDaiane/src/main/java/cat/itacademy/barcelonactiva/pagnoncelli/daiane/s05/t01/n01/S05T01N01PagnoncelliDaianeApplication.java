package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.repository")
@ComponentScan(basePackages = "cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01")
@EntityScan(basePackages = "cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.domain")
public class S05T01N01PagnoncelliDaianeApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N01PagnoncelliDaianeApplication.class, args);
	}
}


