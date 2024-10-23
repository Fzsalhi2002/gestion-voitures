package org.cours.springdatarest.web;

import org.cours.springdatarest.modele.Voiture;
import org.cours.springdatarest.repository.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/voitures")

public class VoitureController {

    @Autowired
    private VoitureRepo voitureRepo;
    @GetMapping("/all")
    public List<Voiture> getAll() {
        return (List<Voiture>) voitureRepo.findAll();
    }


    @PostMapping("/add")
    public ResponseEntity<Voiture> addVoiture(@RequestBody Voiture voiture) {
        System.out.println("Voiture reçue : " + voiture);
        return ResponseEntity.ok(voitureRepo.save(voiture));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable Long id) {
        if (!voitureRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        voitureRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable Long id, @RequestBody Voiture updatedVoiture) {
        Optional<Voiture> optionalVoiture = voitureRepo.findById(id);

        if (!optionalVoiture.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Voiture existingVoiture = optionalVoiture.get();
        existingVoiture.setMarque(updatedVoiture.getMarque());
        existingVoiture.setModele(updatedVoiture.getModele());
        existingVoiture.setCouleur(updatedVoiture.getCouleur());
        existingVoiture.setImmatricule(updatedVoiture.getImmatricule());
        existingVoiture.setAnnee(updatedVoiture.getAnnee());
        existingVoiture.setPrix(updatedVoiture.getPrix());

        voitureRepo.save(existingVoiture);
        return ResponseEntity.ok(existingVoiture);
}


}
