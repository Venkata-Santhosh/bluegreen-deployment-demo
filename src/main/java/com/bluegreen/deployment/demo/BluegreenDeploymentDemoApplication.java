package com.bluegreen.deployment.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BluegreenDeploymentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluegreenDeploymentDemoApplication.class, args);
	}
}


@RestController
@RequestMapping(value = "api")
class BookController {
	private BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping(value = "books")
	public List<Book> queryAllBooks() {
		return bookService.retrieveAllBooks();
	}

	@PostMapping(value = "/book")
	public void insertBook(@RequestBody Book book){
		bookService.addBook(book);
	}

	@GetMapping(value = "/book/{id}")
	public Book queryBook(@PathVariable String id) {
		Optional<Book> book = bookService.retrieveBook(id);
		return book.orElseGet(Book::new);
	}
}

@Service
class BookService {

	private List<Book> books;

	public BookService() {
		books = Arrays.asList(
			new Book("1","The Da Vinci Code ", "Dan Brown"),
				new Book("2", "Java 8", "Satheesh"),
				new Book("3", "MongoDB","Santhosh")

		);
	}

	Optional<Book> retrieveBook(String id) {
		return books.stream()
				.filter( b -> b.getId().equals(id))
				.findFirst();

	}

	List<Book> retrieveAllBooks() {
		return books;
	}

	void addBook(Book book){
		books.add(book);
	}
}

class Book {
	private String id;
	private String title;
	private String author;

	Book(){

	}
	Book(String id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}