/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import teste.testeJDBC;
import bean.Compras;
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
public class ComprasDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Compras compras = (Compras) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "insert into compras values(?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, compras.getId_compra());
             pstm.setInt(2, compras.getFk_funcionario());
             pstm.setInt(3, compras.getFk_fornecedor());
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Object object) {
       
       Compras compras = (Compras) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "update compras set fk_funcionario=?,fk_fornecedor=? where id_compra=?";
            pstm = cnt.prepareStatement(sql);
         pstm.setInt(3, compras.getId_compra());
             pstm.setInt(1, compras.getFk_funcionario());
             pstm.setInt(2, compras.getFk_fornecedor());
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
     public void delete(Object object) {
      
          Compras compras = (Compras) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "delete from compras where id_compra=?";
            pstm = cnt.prepareStatement(sql);
           pstm.setInt(1, compras.getId_compra());
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
     public Object list(int id) {
        Compras compras = new Compras();
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "select * from usuario where id_compra=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()==true){
            compras.setId_compra(rs.getInt("id_compra"));
            compras.setFk_funcionario(rs.getInt("fk_funcionario"));
           compras.setFk_fornecedor(rs.getInt("fk_fornecedor"));
            }
            
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compras;
        
    }

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
       Compras compras = new Compras();
        compras.setId_compra(2);
        compras.setFk_fornecedor(1);
        compras.setFk_funcionario(1);
        
        
        ComprasDAO comprasDAO = new ComprasDAO();
       comprasDAO.update(compras);
        System.out.println(compras);
    }
}
    