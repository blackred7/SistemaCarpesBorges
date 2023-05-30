/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import teste.testeJDBC;
import bean.Fornecedor;
import bean.Usuarios;
import dao.DAO_Abstract;
import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u03402615100
 */
public class FornecedorDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Fornecedor fornecedor = (Fornecedor) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "insert into fornecedor values(?,?,?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, fornecedor.getId_fornecedor());
            pstm.setString(2, fornecedor.getNome());
            pstm.setString(3, fornecedor.getEmail());
            pstm.setString(4, fornecedor.getCpf_cnpj());
              pstm.setString(5, fornecedor.getEnd());
           
             
              
             
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Object object) {
       
        Fornecedor fornecedor = (Fornecedor) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "update fornecedor set nome=?,email=?,cpf_cnpj=?,end=? "
                    + "where id_fornecedor=?";
            pstm = cnt.prepareStatement(sql);
             pstm.setInt(5, fornecedor.getId_fornecedor());
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getEmail());
            pstm.setString(3, fornecedor.getCpf_cnpj());
              pstm.setString(4, fornecedor.getEnd());
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void delete(Object object) {
      
        Fornecedor fornecedor = (Fornecedor) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "delete from fornecedor where id_fornecedor=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, fornecedor.getId_fornecedor());
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public Object list(int id) {
        Fornecedor fornecedor = new Fornecedor();
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "select * from fornecedor where id_fornecedor=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()==true){
            fornecedor.setId_fornecedor(rs.getInt("id_fornecedor"));
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setEmail(rs.getString("email"));
            fornecedor.setCpf_cnpj(rs.getString("cpf_cnpj"));
            fornecedor.setEnd(rs.getString("end"));
            
            }
            
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedor;
        
    }
    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId_fornecedor(3);
        fornecedor.setNome("Baraka");
        fornecedor.setCpf_cnpj("gh");
        fornecedor.setEmail("aobfbao");
        fornecedor.setEnd("huh");
        
        
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
       fornecedorDAO.update(fornecedor);
        System.out.println(fornecedor);
    }
}
    