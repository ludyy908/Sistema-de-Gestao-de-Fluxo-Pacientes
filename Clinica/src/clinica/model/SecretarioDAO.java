/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.model;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Amarilda Chihepe
 */
public class SecretarioDAO {
    Connection conexao;
    ResultSet rs;
    Secretario s;
  
    
    public SecretarioDAO(){
            try{ 
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }   
    
    }
    
    //Carregar dados do secretario que fara o login
   public Secretario getSecretario(int codSecr){
       
       s = new Secretario();
       
       try{
          String query = "select codFuncionario, nome, email, cargo from secretario where codFuncionario ="+codSecr;
          
          PreparedStatement stmt = conexao.prepareStatement(query);         
          rs = stmt.executeQuery();
         
          rs.next();
          s.setIdFuncionatio(rs.getInt("codFuncionario"));
          s.setNomeFunc(rs.getString("nome"));
          s.setEmail(rs.getString("email"));
          s.setCargo(rs.getString("cargo"));       
          
          
          rs.close();
          stmt.close();
       
       }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
   
       return s;
   } 
   
}
