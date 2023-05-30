/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import teste.testeJDBC;
import bean.Adm;
import bean.Usuarios;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u03402615100
 */
public class AdmDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Adm adm = (Adm) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "insert into adm values(?,?,?,?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, adm.getIdadm());
            pstm.setString(2, adm.getNome());  
             pstm.setString(3, adm.getEmail()); 
             pstm.setString(4, adm.getSexo());
             pstm.setInt(5, adm.getNumero_tel());
             pstm.setInt(6, adm.getFk_usuario());
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
     public void update(Object object) {
       
        Adm adm = (Adm) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "update adm set nome=?,email=?,sexo=?,numero_tel=?,"
                    + "fk_usuario=? where idadm=?";
            pstm = cnt.prepareStatement(sql);
           pstm.setInt(6, adm.getIdadm());
            pstm.setString(1, adm.getNome());  
             pstm.setString(2, adm.getEmail()); 
             pstm.setString(3, adm.getSexo());
             pstm.setInt(4, adm.getNumero_tel());
             pstm.setInt(5, adm.getFk_usuario());
             
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void delete(Object object) {
      
        Adm adm = (Adm) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "delete from adm where idadm=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, adm.getIdadm());
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
     public Object list(int id) {
        Adm adm = new Adm();
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "select * from adm where idadm=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()==true){
            adm.setIdadm(rs.getInt("idadm"));
            adm.setNome(rs.getString("nome"));
            adm.setEmail(rs.getString("email"));
            adm.setSexo(rs.getString("sexo"));
            adm.setNumero_tel(rs.getInt("numero_tel"));
           
            
            }
            
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adm;
        
    }

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Adm adm = new Adm();
        adm.setIdadm(3);
        adm.setNome("dd");
        adm.setEmail("s");
        adm.setSexo("m");
        adm.setNumero_tel(1213);
        adm.setFk_usuario(3);
        
        AdmDAO admDAO = new AdmDAO();
       admDAO.update(adm);
        System.out.println(adm);
    }
}
    