package com.example.test9.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.test9.dtos.DetailDeclarationDto;
import com.example.test9.dtos.SaveDeclaration;
import com.example.test9.dtos.SaveMontant;
import com.example.test9.enums.TypeDeclarationEnum;
import com.example.test9.model.Declaration;
import com.example.test9.model.DetailDeclaration;
import com.example.test9.model.DetailImpot;
import com.example.test9.model.ObligationFiscale;
import com.example.test9.repo.DeclarationRepository;
import com.example.test9.repo.DetailDeclarationRepository;
import com.example.test9.repo.DetailImpotRepository;
import com.example.test9.repo.ObligationFiscaleRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeclarationServiceImpl implements DeclarationService{


    @Autowired
    private ObligationFiscaleRepository obligationRepo;
    @Autowired
    private DetailImpotRepository detailimpotRepo;
    @Autowired
    private DetailDeclarationRepository detailDeclarationRepo;
    @Autowired
    private DeclarationRepository declarationRepo;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DeclarationServiceImpl.class);

    @Override
    public Map<DetailImpot, DetailDeclarationDto> saveDeclaration(SaveDeclaration dc) {
        Optional<ObligationFiscale> obligation = obligationRepo.findById(dc.getIdObligation());

        // Initialize detailMap here
        Map<DetailImpot, DetailDeclarationDto> detailMap = new HashMap<>();

        if (obligation.isPresent()) {
            Optional<Declaration> declaration = declarationRepo.findByMoiseffetAndAnneeeffetAndObligation(dc.getMoisEffet(), dc.getAnneeEffet(), obligation.get());
            if (!declaration.isPresent()) {
                Declaration newDeclaration = new Declaration();
                newDeclaration.setObligation(obligation.get());
                newDeclaration.setAnneeeffet(String.valueOf(dc.getAnneeEffet()));
                newDeclaration.setMoiseffet(String.valueOf(dc.getMoisEffet()));
                newDeclaration.setDatedeclaration(String.valueOf(new Date()));
                newDeclaration.setType(dc.getType());
                this.declarationRepo.save(newDeclaration);
                List<DetailImpot> lesDetailsImpot = detailimpotRepo.findByTypeImpot(obligation.get().getImpot());

                for (DetailImpot detail : lesDetailsImpot) {
                    DetailDeclaration newDetailDeclaration = new DetailDeclaration();
                    newDetailDeclaration.setValeur(""); // Set valeur if needed

                    // Assuming you have setters for detailImpot and declaration in DetailDeclaration class
                    newDetailDeclaration.setDetailImpot(detail);


                    newDetailDeclaration.setDeclaration(newDeclaration);

                    this.detailDeclarationRepo.save(newDetailDeclaration);
                    DetailDeclarationDto dto = new DetailDeclarationDto();
                    dto.setIddetailDeclaration(newDetailDeclaration.getId_detaildeclaration());
                    dto.setValeur(null);
                    dto.setIddeclaration(Long.valueOf(newDeclaration.getId_declaration()));// Put the DetailImpot object as key and DetailDeclaration object as value into the map
                    detailMap.put(detail, dto);
                }
                return detailMap;
            } else {
                if (dc.getType().getLibelle() == TypeDeclarationEnum.Initial) {

                    return new HashMap<>();
                } else {

                    declaration.get().setType(dc.getType());
                    this.declarationRepo.save(declaration.get());
                    List<DetailImpot> lesDetailsImpot = detailimpotRepo.findByTypeImpot(declaration.get().getObligation().getImpot());

                    // Fetch all detail declarations associated with the given declaration
                    List<DetailDeclaration> lesdetailsDeclaration = detailDeclarationRepo.findByDeclaration(declaration.get());

                    // Map DetailImpot to DetailDeclaration
                    for (DetailImpot detail : lesDetailsImpot) {
                        Optional<DetailDeclaration> relatedDetail = lesdetailsDeclaration.stream()
                                .filter(detailDeclaration -> detailDeclaration.getDetailImpot().getId_detailimpot() == detail.getId_detailimpot())
                                .findFirst();

                        // If a matching DetailDeclaration is found, create a DetailDeclarationDto
                        relatedDetail.ifPresent(detailDeclaration -> {
                            DetailDeclarationDto dto = new DetailDeclarationDto();
                            dto.setIddetailDeclaration(detailDeclaration.getId_detaildeclaration());
                            dto.setValeur(detailDeclaration.getValeur());
                            dto.setIddeclaration(Long.valueOf(declaration.get().getId_declaration()));
                            // Put the DetailImpot object as the key and DetailDeclarationDto object as the value into the map
                            detailMap.put(detail, dto);
                        });
                    }

                    return detailMap;
                }
            }
        }
        return new HashMap<>();
    }

    @Override
    public boolean updateMontantaCalculer(SaveMontant di) {
        Optional<Declaration> declaration=declarationRepo.findById(di.getIdDeclaration());
        if(declaration.isPresent()) {
            declaration.get().setMontantaCalculer(di.getMontantApayer());
            declarationRepo.save(declaration.get());
            return true;
        }else return false;
    }

    @Override
    public List<Declaration> getDeclarationsByMatriculeFiscale(int matriculeFiscale) {
        return declarationRepo.findByObligation_Contribuable_MatriculeFiscale(matriculeFiscale);
    }

}