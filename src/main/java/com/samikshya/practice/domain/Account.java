package com.samikshya.practice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data

public abstract class Account {

    protected String password;
    protected boolean status;
    protected String name;
    protected String email;





}
