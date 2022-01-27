/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Ludmila Mucavele
 */
public class DoencaDAO {
    private Connection conexao;
    public DoencaDAO(){
        
        try{
            conexao = BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    public void inserirCirurgia(Doenca d) {
        String query = "INSERT INTO doenca VALUES(?,?,?)";
        try{
            try (PreparedStatement ps = conexao.prepareStatement(query)) {
                ps.setInt(1, d.getIdDoenca());
                ps.setString(2, d.getNome());
                ps.setString(3, d.getContagio());
                
                ps.executeQuery();
            }
            conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    
    }

    public ArrayList<String> getNome() {
        ArrayList<String> nomes = new ArrayList<>();
        String query = "Select nome from doenca";
        try{
          
            try (PreparedStatement stmt = conexao.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    nomes.add(rs.getString("nome"));
                }
                rs.close();
            }
       
       }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
        
        
        return nomes;
    }
    
    
    
    
}
