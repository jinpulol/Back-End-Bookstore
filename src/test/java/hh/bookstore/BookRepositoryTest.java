package hh.bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.CategoryRepository;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = bookRepository.findByTitle("Why We Sleep: The New Science of Sleep and Dreams");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Matthew Walker");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("ABC-book", "Not Me", 2000, "978-01234546789", 19.95,
                categoryRepository.findByName("Kids").get(0));
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        List<Book> books = bookRepository.findByTitle("PREORDER The Last One");
        bookRepository.delete(books.get(0));

        List<Book> updatedBooks = bookRepository.findByTitle("PREORDER The Last One");
        assertThat(updatedBooks).hasSize(0);
    }
}