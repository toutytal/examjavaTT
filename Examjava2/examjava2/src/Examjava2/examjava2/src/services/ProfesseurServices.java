package services;

import entities.Professeur;
import repository.ProfesseurRepository;

public class ProfesseurServices {
    ProfesseurRepository professeurRepository = new ProfesseurRepository();

    public void ajouterProfesseur(Professeur professeur) {
        professeurRepository.inserer(professeur);
    }
}
