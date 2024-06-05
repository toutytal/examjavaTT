package services;

import java.util.List;
import entities.Cours;
import repository.CoursRepository;

public class CoursServices {
    CoursRepository coursRepository = new CoursRepository();
   
    public List<Cours> listerCours() {
        return coursRepository.selectionnerTous();
    }

    public void ajouterCours(Cours cours) {
        coursRepository.inserer(cours);
    }

    public List<Cours> listerCoursParModuleEtProfesseur(int moduleId, int professeurId) {
        return coursRepository.selectByModuleAndProfesseur(moduleId, professeurId);
    }
}
