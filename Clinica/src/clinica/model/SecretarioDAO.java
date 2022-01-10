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
import java.util.ArrayList;

/**
 *
 * @author Amarilda Chihepe
 */
public class SecretarioDAO {
    Connection conexao;
    ResultSet rs;
  
    
    public SecretarioDAO(){
            try{ 
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }   
    
    }
    
    //Carregar dados do secretario que fara o login
   public ArrayList<Secretario>  getSecreatrio(int codSecr){
       ArrayList<Secretario> secretario  = new ArrayList<Secretario>();
       Secretario s = new Secretario();
       
       try{
          String query = "select secretario.codFuncionario, secretario.nome, email, cargo from secretario , funcionario   where secretario.codFuncionario = "+codSecr+
                        " and secretario.codFuncionario = funcionario.codFuncionario";
          
          PreparedStatement stmt = conexao.prepareStatement(query);         
          rs = stmt.executeQuery();
          
          rs.next();
          s.setIdFuncionatio(rs.getInt("codFuncionario"));
          s.setNomeFunc(rs.getString("nome"));
          s.setEmail(rs.getString("email"));
          s.setCargo(rs.getString("cargo"));       
          
          secretario.add(s);
          
          rs.close();
          stmt.close();
       
       }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
   
       return secretario;
   } 
   
}
