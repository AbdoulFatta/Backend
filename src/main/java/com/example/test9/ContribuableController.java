/*package com.example.test9;

import com.example.test9.model.Contribuable;
import com.example.test9.repo.ContribuableRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContribuableController {
    @Autowired
    ContribuableRepository repo;

    @CrossOrigin(origins = "*")
    @PostMapping("/inscription")
    public void addContribuable(@RequestBody Contribuable contribuable){
        repo.save(contribuable);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/contribuables")
    public List<Contribuable> getContribuables(){
        return repo.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/contribuables/{numerofiscal}")
    public Optional<Contribuable> getContribuableByNumeroFisc(@PathVariable String numerofiscal){
        return repo.findById(numerofiscal);
    }

   /* @CrossOrigin(origins = "*")
    @PutMapping("updateContribuable/{numerofiscal}")
    public ResponseEntity<Contribuable> updateContribuable(@PathVariable String numerofiscal, @RequestBody Contribuable contribuable) {
        Contribuable updateContribuable = repo.findById(numerofiscal)
                .orElseThrow(() -> new ResourceNotFoundException("Le contribuable est introuvable - Numero Fiscal: " + numerofiscal));

        //updateContribuable.setFirstName(contribuable.getFirstName());
        //updateContribuable.setLastName(contribuable.getLastName());
        //updateContribuable.setEmailId(contribuable.getEmailId());

        repo.save(contribuable);

        return ResponseEntity.ok(updateContribuable);
    }*/

  /*  @CrossOrigin(origins = "*")
    @DeleteMapping("deleteContribuable/{numerofiscal}")
    public ResponseEntity<String> deleteContribuable(@PathVariable String numerofiscal){
        repo.deleteById(numerofiscal);
        return ResponseEntity.ok("Le contribuable a bien été supprimé !");
    }
}
*/