package com.samikshya.practice.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Booking {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private Long bookId;
    private Long memberId;
    private LocalDate issuedDate;
    private LocalDate returnDate;
    private LocalDate returnedDate;





}


