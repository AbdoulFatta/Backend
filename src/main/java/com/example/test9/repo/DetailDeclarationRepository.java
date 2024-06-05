package com.example.test9.repo;

import com.example.test9.model.Declaration;
import com.example.test9.model.DetailDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailDeclarationRepository extends JpaRepository<DetailDeclaration,Long> {

    List<DetailDeclaration> findByDeclaration(Declaration declaration);


}
