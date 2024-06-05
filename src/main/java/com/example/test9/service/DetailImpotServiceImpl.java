package com.example.test9.service;

import java.util.List;
import java.util.Optional;

import com.example.test9.dtos.DetailImpotDto;
import com.example.test9.dtos.PeriodeDto;
import com.example.test9.dtos.TypeImpotDto;
import com.example.test9.enums.Periode;
import com.example.test9.enums.TypedeDetailImpot;
import com.example.test9.model.DetailImpot;
import com.example.test9.model.TypeImpot;
import com.example.test9.repo.DetailImpotRepository;
import com.example.test9.repo.TypeImpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DetailImpotServiceImpl implements DetailImpotService{


    @Autowired
    private TypeImpotRepository typeimpotrepo;
    @Autowired
    private DetailImpotRepository detailrepo;

    @Override
    public DetailImpotDto saveDetailImpot(DetailImpotDto di) {
        TypeImpot   impot= typeimpotrepo.findByLibelle(di.getTypeImpot().getLibelle())
                .orElseThrow(() -> new IllegalArgumentException("Invalid periodicite"));
        DetailImpot detail=new DetailImpot();
        detail.setLibelle(di.getLibelle());
        detail.setCalculable(di.isCalculable());
        detail.setFormule(di.getFormule());
        detail.setObligatoire(di.isObligatoire());
        detail.setOrdre(di.getOrdre());
        detail.setType_detail(String.valueOf(di.getTypeDetail()));
        detail.setTypeImpot(impot);
        DetailImpot detailcree=detailrepo.save(detail);
        DetailImpotDto detaildto=new DetailImpotDto();

        detaildto.setIdDetailImpot(detailcree.getId_detailimpot());
        detaildto.setLibelle(detailcree.getLibelle());
        detaildto.setCalculable(detailcree.isCalculable());
        detaildto.setFormule(detailcree.getFormule());
        detaildto.setObligatoire(detailcree.isObligatoire());
        detaildto.setOrdre(detailcree.getOrdre());
        detaildto.setTypeDetail(TypedeDetailImpot.valueOf(detailcree.getType_detail()));


        TypeImpotDto savedImpot=new TypeImpotDto();

        savedImpot.setLibelle(detailcree.getTypeImpot().getLibelle());
        PeriodeDto pd=new PeriodeDto();
        pd.setIdPeriodicite(detailcree.getTypeImpot().getPeriodicite().getId_periodicite());
        pd.setPeriode(Periode.valueOf(detailcree.getTypeImpot().getPeriodicite().getPeriode()));
        savedImpot.setPeriodicite(pd);


        detaildto.setTypeImpot(savedImpot);

        return detaildto;




    }

    @Override
    public List<DetailImpot> findbytypeImpot(String libelle) {
        // TODO Auto-generated method stub
        Optional<TypeImpot> typetrouve=typeimpotrepo.findByLibelle(libelle);
        if(typetrouve.get()!=null) {

            List<DetailImpot> listtrouve=detailrepo.findByTypeImpot(typetrouve.get());
            return listtrouve;
        }else return null;

    }

}