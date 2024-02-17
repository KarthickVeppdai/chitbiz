package com.villagebiz.chit.service;

import com.villagebiz.chit.model.Member;
import com.villagebiz.chit.repositories.MemberRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    @Autowired
    private MemberRepo memberRepo;

    public Member saveMember(Member member)
    {
      return memberRepo.save(member);
    }
    public List<Member> getAllMembers()
    {
        return memberRepo.findAll();
    }


}
