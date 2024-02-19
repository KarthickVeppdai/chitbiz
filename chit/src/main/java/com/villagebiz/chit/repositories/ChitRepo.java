package com.villagebiz.chit.repositories;

import com.villagebiz.chit.model.Chit;
import com.villagebiz.chit.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChitRepo extends JpaRepository<Chit, Long> {

    Chit save(Chit member);

    @Query("SELECT m FROM Chit m where m.id =:id")
    Chit getChitByID(Long id);

    @Query("SELECT m FROM Chit m")
    List<Chit> getallChit();
}
