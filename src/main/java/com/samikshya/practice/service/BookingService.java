package com.samikshya.practice.service;

import com.samikshya.practice.domain.Book;
import com.samikshya.practice.domain.Booking;
import com.samikshya.practice.domain.Member;
import com.samikshya.practice.repository.BookRepository;
import com.samikshya.practice.repository.BookingReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingReposiory bookingReposiory;

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService memberService;

    public Booking getBookingByBookId(Long bookId) {
        return bookingReposiory.findLastByBookId(bookId);
    }

    public List<Booking> getBookingByMember(Long memberId) {
        return bookingReposiory.findLastThreeByMemberId(memberId);
    }

    public List<Booking> getAllBookings() {
        return bookingReposiory.findAll();
    }

    public List<Booking> getActiveBookings() {
        List<Booking> bookingList = bookingReposiory.findActiveBookings();
        return bookingList;
    }

    public List<Booking> getDelayedBookings() {
        List<Booking> getDelayedList = bookingReposiory.findDelayedBookings();
        return getDelayedList;
    }

    public Booking reserveBook(Long memberId, Long bookId) throws Exception {
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            throw new Exception("Book not found");
        }

        Booking booking = getBookingByBookId(bookId);
        if (booking != null) {
            if (booking.getReturnedDate() == null) {
                throw new Exception("Book is not available at this moment");
            }

        }

        Member member = memberService.getMemberById(memberId);
        if (member == null) {
            throw new Exception("Please register as a Member");
        }
        List<Booking> bookings = getBookingByMember(memberId);
        if (bookings.size() > 2) {
            for (Booking booking1 : bookings) {
                if (booking1.getReturnedDate() == null) {
                    throw new Exception("Please return a book to take another one. Thank you!");
                }
            }


        }

        Booking booking1 = new Booking();
        booking1.setMemberId(memberId);
        booking1.setBookId(bookId);
        booking1.setIssuedDate(LocalDate.now());
        booking1.setReturnDate(LocalDate.now().plusDays(15));
        return bookingReposiory.save(booking1);


    }

    public Booking getBookingByMemberIdAndBookId(Long memberId, Long bookId) {
        Booking booking = bookingReposiory.findByMemberIdAndBookId(memberId, bookId);
        return booking;
    }

    public Booking returnBook(Long memberId, Long bookId) throws Exception {
        Member member = memberService.getMemberById(memberId);
        if (member == null) {
            throw new Exception("No member record found!");
        }
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            throw new Exception("Book not found!");
        }
        Booking booking = getBookingByMemberIdAndBookId(memberId, bookId);
        if (booking == null) {
            throw new Exception("No booking record found!");
        }

        booking.setReturnedDate(LocalDate.now());
        return bookingReposiory.save(booking);
    }
}
