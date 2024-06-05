package com.example.test9;
/*
import com.example.test9.model.Declaration;
import com.example.test9.repo.DeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DeclarationController {
    @Autowired
    DeclarationRepository repo;

    @CrossOrigin(origins = "*")
    @PostMapping("/declaration/ajout")
    public void addDeclaration(@RequestBody Declaration declaration){
        repo.save(declaration);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/declarations")
    public List<Declaration> getDeclarations(){
        return repo.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/declarations/{numero}")
    public Optional<Declaration> getDeclarationByNumero(@PathVariable String id_declaration){
        return repo.findById(Long.valueOf(id_declaration));
    }

   /* @CrossOrigin(origins = "*")
    @PutMapping("updateDeclaration/{id_declaration}")
    public ResponseEntity<Declaration> updateDeclaration(@PathVariable String iddeclaration, @RequestBody Declaration declaration) {
        Optional<Declaration> updateDeclaration = repo.findById(iddeclaration);
              // .orElseThrow(() -> new ResourceNotFoundException("La Declaration est introuvable - Iddeclaration : " + iddeclaration));


        repo.save(declaration);

        return (ResponseEntity<Declaration>) ResponseEntity.ok();
    }*/
/*
    @CrossOrigin(origins = "*")
    @DeleteMapping("deleteDeclaration/{iddeclaration}")
    public ResponseEntity<String> deleteDeclaration(@PathVariable String id_declaration){
        repo.deleteById(Long.valueOf(id_declaration));
        return ResponseEntity.ok("La Declaration a bien été supprimé !");
    }
}
*/