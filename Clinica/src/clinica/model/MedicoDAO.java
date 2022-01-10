/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Ludmila Mucavele
 */
public class MedicoDAO {
    
    ResultSet rs;
    Connection conexao;
    
    public MedicoDAO(){
        try{ 
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }   
    }
    
    //Carregar os nomes dos medicos para tela registo alta
    public ArrayList<Medico> lerDados(){
        ArrayList<Medico> medicos = new ArrayList<Medico>();
        
        try{
            
            String q = "select nome from funcionario, medico where medico.codFuncionario = funcionario.codFuncionario";
            PreparedStatement ps = conexao.prepareStatement(q);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Medico med = new Medico();
                med.setFuncionario(rs.getString("nome"));
            
                medicos.add(med);
            }
            rs.close();
            ps.close();
          
            
        }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }      
        
          return medicos;
    }
    
    //id Do medico de acordo com o nome fornecido para guaradar na tabela de registo de alta
    public int getMedId(String medNome){
         int id = 0;
         
         try{
             String query = "select m.codFuncionario from funcionario f, medico m where nome = "+medNome+" and f.codFuncionario = m.codFuncionario";
             PreparedStatement ps = conexao.prepareStatement(query);
             rs = ps.executeQuery();
             
             rs.next();
             id = rs.getInt("codFuncionario");
             
            rs.close();
            ps.close();
         
         }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }   
         
         return id;
     
     
     }
    
}
