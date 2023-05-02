/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import teste.testeJDBC;
import bean.Produto_compra;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u03402615100
 */
public class Produto_compraDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Produto_compra produto_compra = (Produto_compra) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "insert into usuario values(?,?,?,?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, produto_compra.getFk_produto());
            pstm.setInt(2, produto_compra.getFk_compra());
            pstm.setInt(3, produto_compra.getQuantidade());
            pstm.setDate(4, (java.sql.Date) new Date(2023, 01, 01));            
            pstm.setInt(5, produto_compra.getValor_unitario()); 
             pstm.setInt(6, produto_compra.getValor_total());
             
             
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Produto_compra produto_compra = new Produto_compra();
        produto_compra.setQuantidade(523);
        produto_compra.setValor_unitario(67);
        produto_compra.setValor_total(1234);
 

        
        Produto_compraDAO produto_compraDAO = new Produto_compraDAO();
       produto_compraDAO.insert(produto_compraDAO);
        System.out.println(produto_compraDAO);
    }
}
    