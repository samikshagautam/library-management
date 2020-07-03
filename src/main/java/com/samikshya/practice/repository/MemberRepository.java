package com.samikshya.practice.repository;

import com.samikshya.practice.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface MemberRepository extends JpaRepository<Member,Long>{





}
