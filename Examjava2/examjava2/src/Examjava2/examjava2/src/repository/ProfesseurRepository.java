package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Professeur;

public class ProfesseurRepository {

    public void inserer(Professeur professeur) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_exam", "root", "root");
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO Professeurs (id, nom, prenom, tel) VALUES ("
                        + professeur.getId() + ", '"
                        + professeur.getNom() + "', '"
                        + professeur.getPrenom() + "', '"
                        + professeur.getTel() + "')";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la BD");
        }
    }
}
