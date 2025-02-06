package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner printBooks(BookRepository repository) {
    return (args) -> {
        Book s1 = new Book("Zeus", "Ilkka Remes", 2024, "1234-1", 30);
		Book s2 = new Book("Varaustu viisaasti", "Esa Juntunenn", 2024, "1234-2", 40);
		Book s3 = new Book("Rautaliekki", "Rebecca Yarros", 2024, "1234-3", 50);
		
		repository.save(s1);
		repository.save(s2);
		repository.save(s3);

		};
		
}
}