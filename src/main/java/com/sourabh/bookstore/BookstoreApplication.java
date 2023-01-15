package com.sourabh.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}


// Data Layer Start
// Flyway would be used to version control database changes
record Book(@Id Long id, String title) {
}

interface BookRepository extends CrudRepository<Book, Long> {
}
// Data Layer End