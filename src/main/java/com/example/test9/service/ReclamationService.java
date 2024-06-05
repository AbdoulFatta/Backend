package com.example.test9.service;

import java.util.List;


import com.example.test9.dtos.ReclamationDto;
import com.example.test9.dtos.ReclamtionResponse;
import com.example.test9.dtos.UpdateSolutionRecDto;
import com.example.test9.model.Reclamation;

public interface ReclamationService {
    Reclamation saveReclamation(ReclamationDto r);
    List<ReclamtionResponse> getAllReclamation();
    Reclamation updateSolution(UpdateSolutionRecDto rd);
    List<Reclamation> reclamationByContribuable(int matriculeFiscale);
    boolean updateEtat(Long id);
    boolean refusEtat(Long id);
}