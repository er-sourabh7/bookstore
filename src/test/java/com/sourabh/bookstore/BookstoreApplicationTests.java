package com.sourabh.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"spring.datasource.url=jdbc:tc:postgresql:13:///", "spring.datasource.driver-class-named=org.testcontainers.jdbc.ContainerDatabaseDriver"})
class BookstoreApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void test_addBookToCatalog() {
		var bookToCreate = new Book(null, "Data intensive application");

		webTestClient
				.post().uri("/books")
				.bodyValue(bookToCreate)
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBody(Book.class).value(actualBook -> {
					assertThat(actualBook.id()).isNotNull();
					assertThat(actualBook.title()).isEqualTo(bookToCreate.title());
				});
	}

}
