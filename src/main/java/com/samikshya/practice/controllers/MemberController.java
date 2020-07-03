package com.samikshya.practice.controllers;

import com.samikshya.practice.domain.Member;
import com.samikshya.practice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("")
    public Member addMember(@RequestBody() Member member){
      return   service.addMember(member);

    }

    @GetMapping("{id}")
    public Member getMemberById(@PathVariable("id") Long id){
       return service.getMemberById(id);
    }

    @GetMapping("")
    public List<Member> getAllMembers(){
        return service.findAllMembers();
    }

    @DeleteMapping("{id}")
    public Member deleteMemberById(@PathVariable("id") Long id) throws Exception{
        return service.deleteMember(id);
    }
    @PatchMapping("{id}")
    public Member updateMember(@PathVariable("id") Long id, @RequestBody() Member member) throws Exception{
        return  service.updateMember(id,member);
    }
}
