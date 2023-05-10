package com.chris.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chris.booksapi.models.Book;
import com.chris.booksapi.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId")Long bookId) {
		
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
		List<Book> books = bookService.allBooks();
		
		model.addAttribute("book", book);
		model.addAttribute("books", books);
		
		return "index.jsp";
	}

}
