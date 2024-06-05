package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Module;

public class ModuleRepository {

    public void insert(Module module) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_exam", "root", "root");
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO Modules (id, nomMod) VALUES (" + module.getIdMod() + ", '" + module.getNomMod() + "')";
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion a la BD");
        }
    }

    public List<Module> selectAll() {
        List<Module> modules = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_exam2", "root", "root");
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM Modules";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Module module = new Module();
                module.setIdMod(rs.getInt("id"));
                module.setNomMod(rs.getString("nomMod"));
                modules.add(module);
            }
            statement.close();
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion a la BD");
        }
        return modules;
    }
}
