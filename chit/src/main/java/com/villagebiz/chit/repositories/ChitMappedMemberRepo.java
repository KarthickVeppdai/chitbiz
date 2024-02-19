package com.villagebiz.chit.repositories;

import com.villagebiz.chit.model.Chit;
import com.villagebiz.chit.model.ChitMappedMember;
import com.villagebiz.chit.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChitMappedMemberRepo extends JpaRepository<ChitMappedMember, Long> {
    ChitMappedMember save(ChitMappedMember member);
}
