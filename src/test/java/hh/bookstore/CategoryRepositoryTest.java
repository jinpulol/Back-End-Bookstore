package hh.bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

import hh.bookstore.domain.Category;
import hh.bookstore.domain.CategoryRepository;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = categoryRepository.findByName("Fantasy");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
    }

    @Test
    public void createNewCategory() {
        Category category = new Category("Horror");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void deleteCategory() {
        List<Category> categories = categoryRepository.findByName("Science");
        categoryRepository.delete(categories.get(0));

        List<Category> updatedCategories = categoryRepository.findByName("Science");
        assertThat(updatedCategories).hasSize(0);
    }
}