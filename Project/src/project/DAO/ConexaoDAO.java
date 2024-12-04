/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    
    Connection conn;
    
    private static final String url = "jdbc:mysql://localhost/nome da base de dados";
    private static final String user = "root";
    private static final String pass = "alunolab";

    public Connection conectaBD(){
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "ConexaiDAo: " +e);
        }
        return conn;
    }
}
