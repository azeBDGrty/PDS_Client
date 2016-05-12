/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.graphics;

/**
 *
 * @author Nodaro
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nodaro
 */

//Ajouter droits 
//GRANT ALL PRIVILEGES ON nom_db.* TO "nom_utilisateur"@"localhost" IDENTIFIED BY 'mot_de_passe';
public class DbConnection {
    static String url = "jdbc:mysql://localhost:3306/pds";
    static String username = "java";
    static String password = "password";
    static Connection connection;
    
    public static void  connection(){
        System.out.println("Connecting database...");
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    

}