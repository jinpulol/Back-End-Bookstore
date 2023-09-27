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

			Category cat1 = new Category("Fantasy");
			Category cat2 = new Category("Science");
			Category cat3 = new Category("Kids");

			categoryRepository.save(cat1);
			categoryRepository.save(cat2);
			categoryRepository.save(cat3);

			log.info("Save few books");

			Book book1 = new Book("Why We Sleep: The New Science of Sleep and Dreams", "Matthew Walker", 2018,
					"978-0141983769", 28.53, cat2);
			Book book2 = new Book("PREORDER The Last One", "Rachel Howzell Hall", 2024, "978-1649374400", 31.90, cat1);
			Book book3 = new Book("Just Because", "Matthew McConaughey", 2023, "978-0593622032", 15.72, cat3);

			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);

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
