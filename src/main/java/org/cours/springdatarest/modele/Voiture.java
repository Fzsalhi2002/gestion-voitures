package org.cours.springdatarest.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Déclaration correcte de la clé primaire

    @NonNull
    private String marque;
    @NonNull
    private String modele;
    @NonNull
    private String couleur;
    @NonNull
    private String immatricule;
    @NonNull
    private int annee;
    @NonNull
    private int prix;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id") // Utilisation d'un nom de colonne approprié
    @JsonIgnore
    private Proprietaire proprietaire;

    // Constructeur personnalisé pour inclure le propriétaire
    public Voiture(String marque, String modele, String couleur, String matricule, int annee, int prix, Proprietaire proprietaire) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.immatricule = matricule;
        this.annee = annee;
        this.prix = prix;
        this.proprietaire = proprietaire;
    }



}
