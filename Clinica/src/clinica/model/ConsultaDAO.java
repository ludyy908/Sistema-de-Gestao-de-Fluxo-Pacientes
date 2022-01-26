/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ludmila Mucavele
 */
public class ConsultaDAO {
    private Connection conexao;
    private Consulta c;
    private ResultSet rs;
    
    public ConsultaDAO(){
        
        try{
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    
    public void inserirConsulta(Consulta c){
    String query = "INSERT INTO consulta VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1, c.getNrConsulta());
            ps.setInt(2, c.getidPaciente());
            ps.setString(3, c.getPaciente() );
            ps.setString(4, c.getMedico());
            ps.setString(5, c.getData());
            ps.setString(6,c.getHora());
            ps.setString(7,c.getEstado());
            
            
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    
    }
    
    //Ler todos os dados para tela LISTACir
    public ArrayList<Consulta> lerDados(){
        ArrayList<Consulta> con  = new ArrayList<Consulta>();
        
        String query = "select * from consulta";
        try{
          
          PreparedStatement stmt = conexao.prepareStatement(query);         
            rs = stmt.executeQuery();
          
            while(rs.next()){
              c = new Consulta();
                
                c.setIdPaciente(rs.getInt("codPaciente"));
                c.setPaciente(rs.getString("nomePac"));
                c.setNrConsulta(rs.getInt("numeroConsulta"));
                c.setMedico(rs.getString("nomeMed"));
                c.setData(rs.getString("data"));
                c.setHora(rs.getString ("hora"));
                c.setEstado(rs.getString("estado"));
                con.add(c);
       }
          rs.close();
          stmt.close();
       
       }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
       
       return con;
}

    public void cancelarCirurgia(int id){
        String query = "UPDATE consulta SET estado = 'Cancelado' WHERE numeroConsulta = "+id;
        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.executeQuery();
        }
        catch(SQLException e){
            System.out.println("Falha na actualizacao dos dados "+e.getMessage());
        } 
    }
    
    //ler da consulta de um determinado paciente
    public ArrayList<Consulta> getDadosCons(int idPac){
            
            ArrayList<Consulta> cons = new ArrayList();

        try{
            String query = "Select numeroConsulta, nomeMed, data, hora from consulta where codPaciente = "+idPac;
            PreparedStatement stmt = conexao.prepareStatement(query);
             rs = stmt.executeQuery();
             
             rs.next();
             c  = new Consulta();
             c.setNrConsulta(rs.getInt("numeroConsulta"));
             c.setMedico(rs.getString("nomeMed"));
             c.setData(rs.getString("data"));
             c.setHora(rs.getString("hora"));
             
             cons.add(c);

        }catch(SQLException e){
                System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
        
        return cons;
    }  
}

