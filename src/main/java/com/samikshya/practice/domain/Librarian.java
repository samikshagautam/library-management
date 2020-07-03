package com.samikshya.practice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Librarian extends Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    private Date dateOfBirth;
    private Date employmentDate;


}
