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
	public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {// (CustomerRepository customerRepository)
		return (args) -> {

			jdbcTemplate.update("INSERT INTO customer (firstname, lastname, email) VALUES (?, ?, ?)",
					"Anna", "Mattila", "anna@anna.fi");
			jdbcTemplate.update("INSERT INTO customer (firstname, lastname, email) VALUES (?, ?, ?)",
					"Milla", "Vaara", "milla@milla.fi");
			jdbcTemplate.update("INSERT INTO customer (firstname, lastname, email) VALUES (?, ?, ?)",
					"Juhani", "Suomi", "juhani@juhani.fi");

			// Customer customer1 = new Customer("Anna", "Mattila", "anna@anna.fi");
			// Customer customer2 = new Customer("Milla", "Vaara", "milla@milla.fi");
			// Customer customer3 = new Customer("Juhani", "Suomi", "juhani@juhani.fi");

			// repository.save(customer1);
			// repository.save(customer2);
			// repository.save(customer3);
			// };
		};

	}
}