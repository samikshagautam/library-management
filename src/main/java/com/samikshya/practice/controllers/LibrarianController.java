package com.samikshya.practice.controllers;

import com.samikshya.practice.domain.Librarian;
import com.samikshya.practice.domain.Member;
import com.samikshya.practice.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarians")
public class LibrarianController {

    @Autowired
    private LibrarianService service;

    @PostMapping("")
    public Librarian addLibrarian(@RequestBody() Librarian librarian){
        return service.addLibrarian(librarian);
    }

    @GetMapping("{id}")
    public Librarian getLibrarianById(@PathVariable("id") Long id){
        return service.getLibrarianById(id);
    }

    @GetMapping("")
    public List<Librarian> getAll(){
        return service.getAllLibrarian();
    }

    @DeleteMapping("{id}")
    public  Librarian deleteLibrarian(@PathVariable("id") Long id) throws Exception{
        return service.deleteLibrarian(id);
    }

    @PatchMapping("{id}")
    public Librarian updateLibrarian(@PathVariable("id") Long id, @RequestBody Librarian librarian) throws Exception{
        return service.updateLibrarian(id,librarian);
    }



}
