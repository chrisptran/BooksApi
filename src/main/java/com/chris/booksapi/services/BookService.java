package com.chris.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chris.booksapi.models.Book;
import com.chris.booksapi.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> booksContaining(String search) {
		return bookRepository.findByDescriptionContaining(search);
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}
