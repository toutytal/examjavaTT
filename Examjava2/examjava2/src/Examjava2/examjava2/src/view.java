import java.util.List;
import java.util.Scanner;
import entities.Module;
import entities.Cours;
import entities.Professeur;
import services.ModuleServices;
import services.CoursServices;
import services.ProfesseurServices;
import repository.CoursRepository;

public class view {
    public static void main(String[] args) {
        int choix;
        Scanner sc = new Scanner(System.in);

        ModuleServices moduleService = new ModuleServices();
        CoursServices coursService = new CoursServices();
        ProfesseurServices professeurService = new ProfesseurServices();

        do {
            System.out.println("1-Ajouter un Module");
            System.out.println("2-Lister Tous les Modules");
            System.out.println("3-Créer un Cours");
            System.out.println("4-Lister Tous les Cours");
            System.out.println("5-Lister les Cours d'un Module et d'un Professeur");
            System.out.println("6-Ajouter un Professeur");
            System.out.println("7-Quitter");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Entrer un identifiant pour un module");
                    int idMod = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entrer un nom de module ");
                    String nomMod = sc.nextLine();
                    Module module = new Module();
                    moduleService.ajouterModule(module);
                    break;

                case 2:
                    List<Module> modules = moduleService.listerModules();
                    for (Module mod : modules) {
                        System.out.println("ID du Module : " + mod.getIdMod());
                        System.out.println("Nom du Module : " + mod.getNomMod());
                        System.out.println("=========================");
                    }
                    break;

                case 3:
                    System.out.println("Entrer l'identifiant du cours : ");
                    int idCours = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("Entrer la date du cours (sous forme YYYY-MM-DD) : ");
                    String date = sc.nextLine();
                    System.out.println("Entrer l'heure de début du cours (sous forme HH:MM:SS) : ");
                    String heureDebut = sc.nextLine();
                    System.out.println("Entrer l'heure de fin du cours (sous forme HH:MM:SS) : ");
                    String heureFin = sc.nextLine();
                    System.out.println("Entrer l'identifiant du module du cours : ");
                    int idModule = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entrer l'identifiant du professeur du cours : ");
                    int idProfesseur = sc.nextInt();
                    sc.nextLine();
                    Cours cours = new Cours();
                    coursService.ajouterCours(cours);
                    break;

                case 4:
                    List<Cours> coursListe = coursService.listerCours();
                      for(Cours cours:coursListe){
                        System.out.println("ID du Cours : " + cours.getIdC());
                        System.out.println("Date : " + cours.getDate());
                        System.out.println("Heure de début : " + cours.getHeureDebut());
                        System.out.println("Heure de fin : " + cours.getHeureFin());
                        System.out.println("=========================");
                    }
                    break;

                case 5:
                List<Cours> coursList = coursService.listerCoursParModuleEtProfesseur(idModule, idProfesseur);
                for (Cours cours : coursListe) {
                    System.out.println("ID du Cours : " + cours.getIdC());
                    System.out.println("Date : " + cours.getDate());
                    System.out.println("Heure de début : " + cours.getHeureDebut());
                    System.out.println("Heure de fin : " + cours.getHeureFin());
                    System.out.println("=========================");
                }
                    break;

                case 6:
                    System.out.println("Entrer un identifiant de professeur (id)");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entrer un nom de professeur");
                    String nom = sc.nextLine();
                    System.out.println("Entrer un prénom de professeur");
                    String prenom = sc.nextLine();
                    System.out.println("Entrer un numéro de téléphone de professeur");
                    String tel = sc.nextLine();
                    Professeur professeur = new Professeur();
                    professeurService.ajouterProfesseur(professeur);
                    break;

                case 7:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        } while (choix != 7);
        sc.close();
    }
}

