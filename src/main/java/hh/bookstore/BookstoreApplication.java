package hh.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.Category;
import hh.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			log.info("Save some categories");
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Science"));
			categoryRepository.save(new Category("Kids"));

			log.info("Save few books");
			bookRepository.save(new Book("Why We Sleep: The New Science of Sleep and Dreams", "Matthew Walker", 2018,
					"978-0141983769", 28.53));
			bookRepository
					.save(new Book("PREORDER The Last One", "Rachel Howzell Hall", 2024, "978-1649374400", 31.90));
			bookRepository.save(new Book("Just Because", "Matthew McConaughey", 2023, "978-0593622032", 15.72));

			log.info("Fetch all categories");

			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			
			log.info("Fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
