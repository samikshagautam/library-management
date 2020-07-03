package com.samikshya.practice.domain;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Member  extends  Account{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    private LocalDateTime registeredDate;
    private int totalBooksBorrowed;

}
