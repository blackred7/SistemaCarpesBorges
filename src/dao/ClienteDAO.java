/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import teste.testeJDBC;
import bean.Cliente;
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
            String sql = "insert into cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            pstm.setString(11, cliente.getPremiun());
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
            String sql = "update cliente set historico_compra=?,email=?,sexo=?,"
                    + "data_cadastro=?,end=?,rg=?,porte_pessoal=?,foto=?,descricao=?,premiun=?,"+
                    "indentificacao=?,criminal=?,preferencias=?,fk_idusuario=?,nome=? where id_cliente=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(16, cliente.getId_cliente());
            pstm.setString(1, cliente.getHistorico_compra());  
            pstm.setString(2, cliente.getEmail()); 
            pstm.setString(3, cliente.getSexo());
            pstm.setDate(4, (java.sql.Date) new Date(2023, 01, 01));
            pstm.setString(5, cliente.getEnd());
            pstm.setString(6, cliente.getRg());
            pstm.setString(7, cliente.getPorte_pessoal());      
            pstm.setString(8, cliente.getFoto());
            pstm.setString(9, cliente.getDescricao());
            pstm.setString(10, cliente.getPremiun());
            pstm.setInt(11, cliente.getIndentificacao());
            pstm.setString(12, cliente.getCriminal());
            pstm.setString(13, cliente.getPreferencias());    
              pstm.setInt(14, cliente.getFk_usuario());
            pstm.setString(15, cliente.getNome());
            
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void delete(Object object) {
      
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
            String sql = "delete from cliente where id_cliente=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, cliente.getId_cliente());
            
            pstm.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public Object list(int id) {
         Cliente cliente = new Cliente();
       try{
            String url, use, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_maycon_borges";
            use = "maycon_borges";
            password = "maycon_borges"; 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, use, password);
            PreparedStatement pstm;
            String sql = "select * from cliente where id_cliente=?";
            pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            
            ResultSet rs = pstm.executeQuery();
            if(rs.next()==true){
            cliente.setId_cliente(rs.getInt("id_cliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setHistorico_compra(rs.getString("historico_compra"));
            cliente.setEmail(rs.getString("email"));
            cliente.setSexo(rs.getString("sexo"));
            cliente.setData_cadastro(rs.getDate("data_cadastro"));
            cliente.setEnd(rs.getString("end"));
            cliente.setRg(rs.getString("rg"));
            cliente.setPorte_pessoal(rs.getString("porte_pessoal"));
            cliente.setFoto(rs.getString("foto"));
            cliente.setDescricao(rs.getString("descricao"));
            cliente.setPremiun(rs.getString("premiun"));
            cliente.setIndentificacao(rs.getInt("indentificacao"));
            cliente.setCriminal(rs.getString("criminal"));
            cliente.setPreferencias(rs.getString("preferencias"));
            cliente.setFk_usuario(rs.getInt("fk_idusuario"));
           
            }
            
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testeJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
        
    }

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setId_cliente(12);
        cliente.setHistorico_compra("Baraka");
        cliente.setEmail("bb6");
        cliente.setSexo("m");
        cliente.setEnd("103453");
        cliente.setRg("qnidnnin");
        cliente.setPorte_pessoal("nnin");
        cliente.setFoto("vibu");
        cliente.setDescricao("nini");
        cliente.setPremiun("S");
        cliente.setIndentificacao(2);
        cliente.setCriminal("S");
        cliente.setPreferencias("jb");
        cliente.setNome("bub");
        cliente.setFk_usuario(2);
        
        ClienteDAO clienteDAO = new ClienteDAO();
       clienteDAO.update(cliente);
        System.out.println(cliente);
    }
}
    