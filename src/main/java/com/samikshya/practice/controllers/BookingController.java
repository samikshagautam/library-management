package com.samikshya.practice.controllers;

import com.samikshya.practice.domain.Booking;
import com.samikshya.practice.repository.BookingReposiory;
import com.samikshya.practice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PutMapping("{memberId}/{bookId}")
    public Booking reserveBook(@PathVariable("memberId") Long memberId, @PathVariable("bookId") Long bookId) throws Exception{
        return bookingService.reserveBook(memberId,bookId);

    }

    @PutMapping("return/{memberId}/{bookId}")
    public Booking returnBook(@PathVariable("memberId") Long memberId, @PathVariable("bookId") Long bookId) throws Exception{
        return  bookingService.returnBook(memberId,bookId);

    }

    @GetMapping("")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("active")
    public List<Booking> getActiveBookings(){
        return bookingService.getActiveBookings();
    }

    @GetMapping("delayed")
    public  List<Booking> getDelayedBookings(){
        return bookingService.getDelayedBookings();
    }

}
