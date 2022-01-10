/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Ludmila Mucavele
 */
public class EnfermeiroDAO {
    
    ResultSet rs; Connection conexao;

    public EnfermeiroDAO() {
        try{ 
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        } 
    }
    
    public void inserirEnf(Enfermeiro e){
        
        String query1;
        query1 = "insert into Funcionario(codFuncionario, nome, sexo, contacto, morada, Nacionalidade, departamento) values(?,?,?,?,?,?,?)";
        
         try{
            PreparedStatement ps = conexao.prepareStatement(query1);
            
            ps.setInt(1, e.getIdFuncionario());
            ps.setString(2, e.getNomeFunc());
            ps.setString(3, e.getSexo());
            ps.setString(4, e.getContacto());
            ps.setString(5, e.getMorada());
            ps.setString(6, e.getNacionalidade());
            ps.setString(7, e.getDepartamento());
            
       
            ps.executeUpdate();
            ps.close();
            //conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    
         
    }
       public void inserirEnf2(Enfermeiro e){
        
        String query2;
        query2 = "insert into enfermeiro(codFuncionario, categoria) values(?,?)";
        
         try{
            PreparedStatement ps2 = conexao.prepareStatement(query2);
            
            ps2.setInt(1, e.getIdFuncionario());
            ps2.setString(2, e.getCategoria());
            

            ps2.executeUpdate();
            ps2.close();
            conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    
         
       }
       
       
       //ler todos os dados dos enfermeiros da clinica
        public ArrayList<Enfermeiro> lerDados(){
        ArrayList<Enfermeiro> enfermeiro  = new ArrayList<Enfermeiro>();     
       
       try{
          String query = "select enfermeiro.codFuncionario, nome, sexo, contacto, morada, Nacionalidade, departamento, categoria from enfermeiro , funcionario "
                  +"where enfermeiro.codFuncionario = funcionario.codFuncionario";
          
          PreparedStatement stmt = conexao.prepareStatement(query);         
          rs = stmt.executeQuery();
          
            while(rs.next()){
                Enfermeiro enf = new Enfermeiro();
                enf.setIdFuncionatio(rs.getInt("enfermeiro.codFuncionario"));
                enf.setNomeFunc(rs.getString("nome"));
                enf.setSexo(rs.getString("sexo"));
                enf.setContacto(rs.getString("contacto"));
                enf.setMorada(rs.getString("morada"));
                enf.setNacionalidade(rs.getString("Nacionalidade"));           
                enf.setDepartamento(rs.getString("departamento"));
                enf.setCategoria(rs.getString("categoria"));
                
               enfermeiro.add(enf);
             
       }
          rs.close();
          stmt.close();
       
       }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
       
       return enfermeiro;
}
        
       //Retorna os nomes de todos os Enfermeiros
    
     public ArrayList<Enfermeiro> lerNomeEnf(){
        ArrayList<Enfermeiro> enf = new ArrayList<Enfermeiro>();
        
        try{
            
            String q = "select nome from funcionario, enfermeiro where enfermeiro.codFuncionario = funcionario.codFuncionario";
            PreparedStatement ps = conexao.prepareStatement(q);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Enfermeiro e = new Enfermeiro();
                e.setFuncionario(rs.getString("nome"));
            
                enf.add(e);
            }
            rs.close();
            ps.close();
          
            
        }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }      
        
          return enf;
    }
    
     
      
    //id Do enfermeiro de acordo com o nome fornecido para guaradar na tabela de registo de Internamentos
    public int getEnfId(String medEnf){
         int id = 0;
         
         try{
             String query = "select enfermeiro.codFuncionario from funcionario, enfermeiro where funcionario.nome = "+medEnf;
             PreparedStatement ps = conexao.prepareStatement(query);
             rs = ps.executeQuery();
             
             rs.next();
             id = rs.getInt("enfermeiro.codFuncionario");
             
            rs.close();
            ps.close();
         
         }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }   
         
         return id;
     
     
     }
    
    
}
