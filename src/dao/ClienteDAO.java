/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import teste.testeJDBC;
import bean.Cliente;
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
public class ClienteDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Cliente cliente = (Cliente) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "insert into usuario values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, cliente.getId_cliente());
            pstm.setString(2, cliente.getHistorico_compra());  
            pstm.setString(3, cliente.getEmail()); 
            pstm.setString(4, cliente.getSexo());
            pstm.setDate(5, (java.sql.Date) new Date(2023, 01, 01));
            pstm.setString(6, cliente.getEnd());
            pstm.setString(7, cliente.getRg());
            pstm.setString(8, cliente.getPorte_pessoal());      
            pstm.setString(9, cliente.getFoto());
            pstm.setString(10, cliente.getDescricao());
            pstm.setInt(11, cliente.getPremiun());
            pstm.setInt(12, cliente.getIndentificacao());
            pstm.setString(13, cliente.getCriminal());
            pstm.setString(14, cliente.getPreferencias());    
              pstm.setInt(15, cliente.getFk_usuario());
            pstm.setString(16, cliente.getNome());
                    
                    
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
        Cliente cliente = new Cliente();
        cliente.setId_cliente(12);
        cliente.setHistorico_compra("Bakaraka");
        cliente.setEmail("bb");
        cliente.setSexo("aobfbao");
        cliente.setEnd("103453");
        cliente.setRg("qnidnnin");
        cliente.setPorte_pessoal("nnin");
        cliente.setFoto("vibu");
        cliente.setDescricao("nini");
        cliente.setPremiun(2);
        cliente.setIndentificacao(231);
        cliente.setCriminal("by");
        cliente.setPreferencias("jb");
        cliente.setNome("bub");
        
        ClienteDAO clienteDAO = new ClienteDAO();
       clienteDAO.insert(cliente);
        System.out.println(cliente);
    }
}
    