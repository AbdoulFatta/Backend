package com.example.test9.repo;

import com.example.test9.model.DetailImpot;
import com.example.test9.model.TypeImpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailImpotRepository extends JpaRepository<DetailImpot,Long> {


    List<DetailImpot> findByTypeImpot(TypeImpot typeImpot);


}
