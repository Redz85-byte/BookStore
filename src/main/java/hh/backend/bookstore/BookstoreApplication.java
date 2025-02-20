package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category scifi = new Category("Sci-Fi");
			Category horror = new Category("Horror");
			Category thriller = new Category("Thriller");

			categoryRepository.save(scifi);
			categoryRepository.save(horror);
			categoryRepository.save(thriller);

			log.info("fetch all the categories");
			for (Category category : categoryRepository.findAll()) {
    		log.info(category.toString());
			}
			

			log.info(""); 
            
			Book book1 = new Book("Zeus", "Ilkka Remes", 2024, "1234-1", 29.99, thriller);
			Book book2 = new Book("Pimeällä puolella", "Stephen King", 2025, "1234-2", 39.99, horror);
			Book book3 = new Book("Dyynin Messias", "Frank Herbert", 2023, "1234-3", 14.99, scifi);

			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);

			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
            
        };
}
}