package com.samikshya.practice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String author;
    protected String isbn;
    protected String title;
    protected String subject;
    protected String language;
    protected int numberOfPages;
}
