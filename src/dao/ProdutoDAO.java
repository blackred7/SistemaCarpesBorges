/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import teste.testeJDBC;
import bean.Produto;
import dao.DAO_Abstract;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u03402615100
 */
public class ProdutoDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Produto produto = (Produto) object;
       try{
            String url, use, password;
             url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "insert into usuario values(?,?,?,?,?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, produto.getId_produto());
            pstm.setString(2, produto.getNome());
            pstm.setString(3, produto.getDescricao());
            pstm.setString(4, produto.getTipo());
              pstm.setInt(5, produto.getPreco());
            pstm.setInt(6, produto.getQuantidade());  
             pstm.setString(7, produto.getFoto());
             
              
             
            
            
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
        Produto produto = new Produto();
        produto.setId_produto(3);
        produto.setNome("Bakaraka");
        produto.setDescricao("jqbjdb");
        produto.setTipo("pesado");
        produto.setPreco(723);
        produto.setQuantidade(76);
        produto.setFoto("//foto.org");
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
       produtoDAO.insert(produto);
        System.out.println(produto);
    }
}
    