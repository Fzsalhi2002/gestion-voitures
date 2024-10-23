package org.cours.springdatarest;

import org.cours.springdatarest.modele.Proprietaire;
import org.cours.springdatarest.repository.VoitureRepo;
import org.cours.springdatarest.repository.ProprietaireRepo;
import org.cours.springdatarest.modele.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataRestApplication {
    @Autowired
    private VoitureRepo voitureRepository;

    @Autowired
    private ProprietaireRepo proprietaireRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Créer deux propriétaires
            Proprietaire proprietaire1 = new Proprietaire("Ali", "Hassan");
            Proprietaire proprietaire2 = new Proprietaire("Najat", "Bani");

            // Sauvegarder les propriétaires en base de données
            proprietaireRepository.save(proprietaire1);
            proprietaireRepository.save(proprietaire2);

            // Sauvegarder les voitures en les associant aux propriétaires
            voitureRepository.save(new Voiture("Toyota", "Corolla", "Grise", "A-1-9090", 2018, 95000, proprietaire1));
            voitureRepository.save(new Voiture("Ford", "Fiesta", "Rouge", "A-2-8090", 2015, 90000, proprietaire1));
            voitureRepository.save(new Voiture("Honda", "CRV", "Bleu", "A-3-7090", 2016, 140000, proprietaire2));
        };
    }
}