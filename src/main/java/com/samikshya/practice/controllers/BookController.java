package com.samikshya.practice.controllers;

import com.samikshya.practice.domain.Book;
import com.samikshya.practice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

  @PostMapping("")
    public Book addBook(@RequestBody() Book book){
      return bookService.addBook(book);

    }

    @DeleteMapping("{id}")
    public Book deleteBookById(@PathVariable("id") Long id) throws Exception{
       return  bookService.deleteBookById(id);

    }

    @GetMapping("")
    public List<Book> getAllBooks(){
      return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable("id") Long id){
      return bookService.getBookById(id);
    }

    @PatchMapping("{id}")
    public Book updateBook(@RequestBody() Book book ,  @PathVariable("id") Long id) throws  Exception{
      return bookService.updateBook(id,book);

  }


}
