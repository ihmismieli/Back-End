package fi.ahlgren.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.ahlgren.customer.domain.Customer;
import fi.ahlgren.customer.domain.CustomerDAO;

@SpringBootApplication
public class CustomerApplication {

	private static final Logger log = LoggerFactory.getLogger(CustomerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerDAO customerDAO) {
		return (args) -> {
			
	        customerDAO.save(new Customer("John", "West", "john.west@west.com"));
	        customerDAO.save(new Customer("Mike", "Mars", "mike.mars@mars.com"));
	        customerDAO.save(new Customer("Kate", "Johnson", "kate.johnson@kate.com"));
	       
		};

}
}