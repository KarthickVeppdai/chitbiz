package com.villagebiz.chit.service;

import com.villagebiz.chit.model.Chit;
import com.villagebiz.chit.model.Member;
import com.villagebiz.chit.repositories.ChitRepo;
import com.villagebiz.chit.repositories.MemberRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChitService {

    @Autowired
    private ChitRepo chitRepo;
    public Chit saveMember(Chit chit)
    {
        return chitRepo.save(chit);
    }
    public List<Chit> getAllChit()
    {
        return chitRepo.getallChit();
    }
    public Chit getByID(Long id)
    {
        return chitRepo.getChitByID(id);
    }

}
