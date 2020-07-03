package com.samikshya.practice.repository;

import com.samikshya.practice.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {


}
