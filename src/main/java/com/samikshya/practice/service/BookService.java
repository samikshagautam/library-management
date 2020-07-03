package com.samikshya.practice.service;

import com.samikshya.practice.domain.Book;
import com.samikshya.practice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    public Book deleteBookById(Long id) throws Exception {
        //find a book
        Book book = getBookById(id);
        if (book == null) {
            throw new Exception("Book not found");
        }

        bookRepository.delete(book);
        return book;

    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    public Book updateBook(Long id, Book book) throws Exception {
        Book book1 = getBookById(id);
        if (book1 == null) {
            throw new Exception("Book not found");
        }
        if (book.getAuthor() != null) {
            book1.setAuthor(book.getAuthor());
        }
        if (book.getIsbn() != null) {
            book1.setIsbn(book.getIsbn());
        }

        if (book.getLanguage() != null) {
            book1.setLanguage(book.getLanguage());
        }

        if (book.getSubject() != null) {
            book1.setSubject(book.getSubject());
        }

        if (book.getNumberOfPages() != 0) {
            book1.setNumberOfPages(book.getNumberOfPages());

        }
        if (book.getTitle() != null) {
            book1.setTitle(book.getTitle());
        }


        return bookRepository.save(book1);


    }
}
