package com.villagebiz.chit.service;

import com.villagebiz.chit.model.ChitMappedMember;
import com.villagebiz.chit.repositories.ChitMappedMemberRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChitMappedMemberService  {

    @Autowired
    private ChitMappedMemberRepo chitMappedMemberRepo;


}
