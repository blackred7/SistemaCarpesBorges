/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Usuarios;
import teste.testeJDBC;
import bean.Vendas;
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
public class VendasDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Vendas vendas = (Vendas) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "insert into vendas values(?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendas.getId_vendas());
            pstm.setInt(2, vendas.getFk_cliente());
             pstm.setInt(3, vendas.getFk_funcionario());
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Object object) {
       
        Vendas vendas = (Vendas) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "update vendas set fk_cliente=?,fk_funcionario=?"
                    + " where id_vendas=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(3, vendas.getId_vendas());
            pstm.setInt(1, vendas.getFk_cliente());
             pstm.setInt(2, vendas.getFk_funcionario());
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
     public void delete(Object object) {
      
         Vendas vendas = (Vendas) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "delete from vendas where id_vendas=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, vendas.getId_vendas());
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
     public Object list(int id) {
        Vendas vendas = new Vendas();
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "select * from usuario where id_vendas=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()==true){
            vendas.setId_vendas(rs.getInt("id_vendas"));
            vendas.setFk_funcionario(rs.getInt("fk_funcionario"));
           vendas.setFk_cliente(rs.getInt("fk_cliente"));

            }
            
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
        
    }

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
       Vendas vendas = new Vendas();
        vendas.setId_vendas(3);
        vendas.setFk_funcionario(1);
        vendas.setFk_cliente(11);
        
        
        VendasDAO vendasDAO = new VendasDAO();
       vendasDAO.delete(vendas);
        System.out.println(vendas);
    }
}
    