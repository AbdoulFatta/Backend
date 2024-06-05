package com.example.test9.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.test9.dtos.TypeDeclarationDto;
import com.example.test9.model.TypeDeclaration;
import com.example.test9.repo.TypeDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TypeDeclarationServiceImpl implements TypeDeclarationService{

    @Autowired
    private TypeDeclarationRepository typeDeclarationRepo;

    @Override
    public List<TypeDeclarationDto> lesTypes() {
        return typeDeclarationRepo.findAll().stream().map(TypeDeclaration::getId_type_declaration).collect(Collectors.toList());
    }

}