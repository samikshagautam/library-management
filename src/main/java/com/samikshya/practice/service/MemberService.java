package com.samikshya.practice.service;

import com.samikshya.practice.domain.Member;
import com.samikshya.practice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

  public Member addMember(Member member){
      return repository.save(member);
  }

  public Member getMemberById(Long id){
      return  repository.findById(id).get();
  }

  public List<Member> findAllMembers(){
      return  repository.findAll();
  }

  public Member deleteMember(Long id) throws Exception {
      Member member = getMemberById(id);
      if(member == null){
          throw new Exception("Member does not exist");
      }

       repository.deleteById(id);
      return member;
  }

  public Member updateMember(Long id, Member member) throws Exception {
      Member member1 = getMemberById(id);
      if(member1 == null){
          throw  new Exception("Member does not exist");
      }
      if(member.getName() != null){
          member1.setName(member.getName());
      }
      if(member.getPassword() != null){
          member1.setPassword(member.getPassword());
      }

      if(member.getRegisteredDate() != null){
          member1.setRegisteredDate(member.getRegisteredDate());
      }

      if(member.getTotalBooksBorrowed() >= 0){
          member1.setTotalBooksBorrowed(member.getTotalBooksBorrowed());
      }

      if(member.getEmail() != null){
          member1.setEmail(member.getEmail());
      }


      return repository.save(member1);
  }



}
