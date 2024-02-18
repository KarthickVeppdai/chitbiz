package com.villagebiz.chit.repositories;

import com.villagebiz.chit.model.Member;
import com.villagebiz.chit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {


    Member save(Member member);


    @Query("SELECT m FROM Member m")
    List<Member> getallMember();

    @Query("SELECT m FROM Member m where m.id =:id")
    Member getMemberByID(Long id);
}
