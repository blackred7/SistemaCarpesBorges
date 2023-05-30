/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Adm;
import teste.testeJDBC;
import bean.Funcionario;
import dao.DAO_Abstract;
import java.awt.List;
import java.sql.Connection;
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
public class FuncionarioDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Funcionario funcionario = (Funcionario) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges";
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "insert into funcionario values(?,?,?,?,?,?,?,?)";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, funcionario.getIdFuncinario());
            pstm.setString(2, funcionario.getSexo());
            pstm.setString(3, funcionario.getEmail());
            pstm.setInt(4, funcionario.getNumero_tel());
              pstm.setString(5, funcionario.getFoto());
              pstm.setInt(6, funcionario.getFk_usuario());
            pstm.setString(7, funcionario.getNome());  
             pstm.setString(8, funcionario.getCpf()); 
             
              
             
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
   public void update(Object object) {
       
        Funcionario funcionario = (Funcionario) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "update funcionario set sexo=?,email=?,numero_tel=?,foto=?,fk_usuario=?,nome=?,cpf=?"
                    + "where id_funcionario=?";
            pstm = cnt.prepareStatement(sql);
             pstm.setInt(8, funcionario.getIdFuncinario());
            pstm.setString(1, funcionario.getSexo());
            pstm.setString(2, funcionario.getEmail());
            pstm.setInt(3, funcionario.getNumero_tel());
              pstm.setString(4, funcionario.getFoto());
              pstm.setInt(5, funcionario.getFk_usuario());
            pstm.setString(6, funcionario.getNome());  
             pstm.setString(7, funcionario.getCpf());  
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void delete(Object object) {
      
        Funcionario funcionario = (Funcionario) object;
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "delete from funcionario where id_funcionario=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, funcionario.getIdFuncinario());
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
   public Object list(int id) {
         Funcionario funcionario = new Funcionario();
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "select * from funcionario where id_funcionario=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()==true){
            funcionario.setIdFuncinario(rs.getInt("id_funcionario"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setEmail(rs.getString("email"));
            funcionario.setSexo(rs.getString("sexo"));
            funcionario.setFoto(rs.getString("foto"));
            funcionario.setNumero_tel(rs.getInt("numero_tel"));
            funcionario.setFk_usuario(rs.getInt("fk_usuario"));
            funcionario.setCpf(rs.getString("cpf"));
           
            
            }
            
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
        
    }

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncinario(3);
        funcionario.setNome("Baraka");
        funcionario.setCpf("4r");
        funcionario.setEmail("aobfbao");
        funcionario.setNumero_tel(7994-345);
        funcionario.setSexo("M");
        funcionario.setFoto("//foto.org");
        funcionario.setFk_usuario(5);
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
       funcionarioDAO.delete(funcionario);
        System.out.println(funcionario);
    }
}
    