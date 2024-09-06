package projekti.bookstoreproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import projekti.bookstoreproject.domain.Book;
import projekti.bookstoreproject.domain.BookRepository;

@SpringBootApplication
public class BookstoreprojectApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreprojectApplication.class, args);
	}

	@Bean

	public CommandLineRunner bookDemo(BookRepository repository){
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", "1232323-21", 1929, 11.99));
			repository.save(new Book("Animal Farm", "George Orwell", "2212343-5", 1945, 16.99));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};

	}

}
