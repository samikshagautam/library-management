package com.samikshya.practice.repository;

import com.samikshya.practice.domain.Booking;
import org.hibernate.annotations.Where;
import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingReposiory extends JpaRepository<Booking, Long> {
    Booking findLastByBookId(Long bookId);

    List<Booking> findLastThreeByMemberId(Long memberId);

    Booking findByMemberIdAndBookId(Long memberId, Long bookId);

    @Query(value = "SELECT * FROM booking where returned_date is null order by id desc ", nativeQuery = true)
    List<Booking> findActiveBookings();

    @Query(value = "select  * from  booking where return_date <= CURRENT_DATE AND returned_date is null order by  id desc ", nativeQuery = true)

    List<Booking> findDelayedBookings();
}
