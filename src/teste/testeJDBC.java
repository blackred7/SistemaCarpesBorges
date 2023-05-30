package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.oi
 */
/**
 *
 * @author u13766540670
 */
public class testeJDBC {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges";
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}