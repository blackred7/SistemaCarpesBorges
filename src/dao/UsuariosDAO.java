/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import teste.testeJDBC;
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
public class UsuariosDAO extends DAO_Abstract{
public  UsuariosDAO(){



}
    @Override
    public void insert(Object object) {
        Usuarios usuarios = (Usuarios) object;
       try{
             String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "insert into usuario values(?,?,?,?,?,?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, usuarios.getIdusuario());
            pstm.setString(2, usuarios.getNome());  
             pstm.setString(3, usuarios.getApelido()); 
             pstm.setString(4, usuarios.getCpf());
             pstm.setInt(5, usuarios.getNivel()); 
             pstm.setString(6, usuarios.getAtivo());      
            pstm.setString(7, usuarios.getSenha()); 
            pstm.setDate(8, (java.sql.Date)  new Date(2023, 01, 01));
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Object object) {
       
        Usuarios usuarios = (Usuarios) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "update usuario set nome=?,apelido=?,cpf=?,nivel=?,"
                    + "ativo=?,senha=?,data_nasc=? where idusuario=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(8, usuarios.getIdusuario());
            pstm.setString(1, usuarios.getNome());  
             pstm.setString(2, usuarios.getApelido()); 
             pstm.setString(3, usuarios.getCpf());
             pstm.setInt(4, usuarios.getNivel()); 
             pstm.setString(5, usuarios.getAtivo());      
            pstm.setString(6, usuarios.getSenha()); 
            pstm.setDate(7, (java.sql.Date) new Date(2023, 01, 01));
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void delete(Object object) {
      
        Usuarios usuarios = (Usuarios) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "delete from usuario where idusuario=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, usuarios.getIdusuario());
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public Object list(int id) {
        Usuarios usuarios = new Usuarios();
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "select * from usuario where idusuario=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()==true){
            usuarios.setIdusuario(rs.getInt("idusuario"));
            usuarios.setNome(rs.getString("nome"));
            usuarios.setApelido(rs.getString("apelido"));
            usuarios.setCpf(rs.getString("cpf"));
            usuarios.setNivel(rs.getInt("nivel"));
            usuarios.setAtivo(rs.getString("ativo"));
            usuarios.setSenha(rs.getString("senha"));
            usuarios.setData_nasc(rs.getDate("data_nasc"));
            }
            
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
        
    }

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Usuarios usuarios = new Usuarios();
        usuarios.setIdusuario(88);
        usuarios.setNome("Bakarakas");
        usuarios.setApelido("bks");
        usuarios.setCpf("345");
        usuarios.setNivel(2);
        usuarios.setAtivo("s");
        usuarios.setSenha("1qs453");
        
        UsuariosDAO usuariosDAO = new UsuariosDAO();
       usuariosDAO.delete(usuarios);
        System.out.println(usuarios);
    }
}
    