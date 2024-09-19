package fi.ahlgren.customerlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class CustomerlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerlistApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
		return (args) -> {

			jdbcTemplate.update("INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)",
					"Anna", "Mattila", "anna@anna.fi");
			jdbcTemplate.update("INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)",
					"Milla", "Vaara", "milla@milla.fi");
			jdbcTemplate.update("INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)",
					"Juhani", "Suomi", "juhani@juhani.fi");

		
		};

	}
}