package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import entities.Cours;
import entities.Professeur;
import entities.Module;

public class CoursRepository {

    public void inserer(Cours cours) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_exam", "root", "root");
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO Cours (idC, date, heureDebut, heureFin, moduleId, professeurId) VALUES ("
                        + cours.getIdC() + ", '"
                        + cours.getDate() + "', '"
                        + cours.getHeureDebut() + "', '"
                        + cours.getHeureFin() + "', "
                        + cours.getModule().getIdMod() + ", "
                        + cours.getProfesseur().getId() + ")";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BD");
        }
    }

    public List<Cours> selectionnerTous() {
        List<Cours> coursListe = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_exam", "root", "root");
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM Cours";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Cours cours = new Cours();
                cours.setIdC(rs.getInt("idC"));
                cours.setDate(LocalDate.parse(rs.getString("date")));
                cours.setHeureDebut(LocalTime.parse(rs.getString("heureDebut")));
                cours.setHeureFin(LocalTime.parse(rs.getString("heureFin")));
                cours.setModule(new Module()); 
                cours.setProfesseur(new Professeur());  
                coursListe.add(cours);
            }
            statement.close();
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BD");
        }
        return coursListe;
    }

    public List<Cours> selectByModuleAndProfesseur(int moduleId, int professeurId) {
        List<Cours> coursListe = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_exam", "root", "root");
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM Cours WHERE moduleId = " + moduleId + " AND professeurId = " + professeurId;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Cours cours = new Cours();
                cours.setIdC(rs.getInt("idC"));
                cours.setDate(LocalDate.parse(rs.getString("date")));
                cours.setHeureDebut(LocalTime.parse(rs.getString("heureDebut")));
                cours.setHeureFin(LocalTime.parse(rs.getString("heureFin")));
                cours.setModule(new Module()); 
                cours.setProfesseur(new Professeur());
                coursListe.add(cours);
            }
            statement.close();
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BD");
        }
        return coursListe;
    }
}
