package com.example.test9;

import com.example.test9.dtos.ReclamtionResponse;
import com.example.test9.dtos.UpdateSolutionRecDto;
import com.example.test9.model.DetailDeclaration;
import com.example.test9.model.Reclamation;
import com.example.test9.service.DetailDeclarationService;
import com.example.test9.service.NotificationService;
import com.example.test9.service.ReclamationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Responsable")
public class ResponsableController {


    @Autowired
    private ReclamationService reclamationservice;
    @Autowired
    private DetailDeclarationService detailservice;
    @Autowired
    private NotificationService notificationservice;




    @PutMapping("/updatereclamation")
    public ResponseEntity<?> saveReclamation(@RequestBody UpdateSolutionRecDto reclamationDto) {
        Reclamation saved = reclamationservice.updateSolution(reclamationDto);
        if (saved!=null) {
            notificationservice.creatNotification(reclamationDto.getIdReclamation(), reclamationDto.getSolution());
            return ResponseEntity.ok(saved);

        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("lesreclamations")
    public ResponseEntity<?> lesreclamations(){
        List<ReclamtionResponse> list=reclamationservice.getAllReclamation();
        return ResponseEntity.ok(list);
    }
    @GetMapping("lesdetailsdeclaration")
    public ResponseEntity<?> lesdetails(@RequestParam("declaration") Long iddeclaration){
        List<DetailDeclaration> list=detailservice.getdetailBydeclarationId(iddeclaration);
        return ResponseEntity.ok(list);
    }
}