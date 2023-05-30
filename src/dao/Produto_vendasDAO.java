/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Compras;
import teste.testeJDBC;
import bean.Produto_vendas;
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
public class Produto_vendasDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Produto_vendas produto_vendas = (Produto_vendas) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "insert into produto_vendas values(?,?,?,?,?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, produto_vendas.getFk_produto());
            pstm.setInt(2, produto_vendas.getFk_venda());
            pstm.setInt(3, produto_vendas.getQuantidade());           
            pstm.setInt(5, produto_vendas.getValor_unitario());
            pstm.setDate(4, (java.sql.Date) new Date(2023, 01, 01)); 
             pstm.setInt(6, produto_vendas.getValor_total());
             pstm.setInt(7, produto_vendas.getIdProduto_vendas());
             
             
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//ARRUMAR BAMCO, ID
    @Override
    public void update(Object object) {
       
        Produto_vendas produto_vendas = (Produto_vendas) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "update produto_vendas set fk_venda=?, quantidade=?, valor_unitario=?, data_hora=?, valor_total=?"
                    + "where id_produto_vendas=?";
            pstm = cnt.prepareStatement(sql);
        pstm.setInt(6, produto_vendas.getFk_produto());
            pstm.setInt(1, produto_vendas.getFk_venda());
            pstm.setInt(2, produto_vendas.getQuantidade());           
            pstm.setInt(3, produto_vendas.getValor_unitario());
            pstm.setDate(4, (java.sql.Date) new Date(2023, 01, 01)); 
             pstm.setInt(5, produto_vendas.getValor_total());
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
     public void delete(Object object) {
      
          Produto_vendas produto_vendas = (Produto_vendas) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "delete from vendas where id_produto_vendas=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, produto_vendas.getFk_produto());
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
     public Object list(int id) {
        Produto_vendas produto_vendas  = new Produto_vendas();
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "select * from usuario where id_produto_vendas=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()==true){
            produto_vendas.setIdProduto_vendas(rs.getInt("id_produto_vendas"));
           
            }
            
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto_vendas;
        
    }
    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Produto_vendas produto_vendas = new Produto_vendas();
        produto_vendas.setQuantidade(523);
        produto_vendas.setValor_unitario(67);
        produto_vendas.setValor_total(1234);
        produto_vendas.setIdProduto_vendas(3);
        produto_vendas.setFk_produto(2);
        produto_vendas.setFk_venda(1);
 

        
        Produto_vendasDAO produto_vendasDAO = new Produto_vendasDAO();
       produto_vendasDAO.insert(produto_vendasDAO);
        System.out.println(produto_vendasDAO);
    }
}
    