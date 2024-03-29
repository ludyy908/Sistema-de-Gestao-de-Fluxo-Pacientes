/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amarilda Chihepe
 */
public class InternamentoDAO {
    
     ResultSet rs;
    Connection conexao;

    public InternamentoDAO() {
        try{ 
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }  
    }
    
    //Guadar da dos dos pacientes internados na Base de dados
    public void inserirPac(Internamento i){
        String query = "INSERT INTO Internamento(dataInternamento, codPaciente, idInternamento, codFuncionario, doenca) "
                + "VALUES(?,?,?,?,?)";
        try{
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1, i.getDataInter());
            ps.setInt(2, i.getCodPacient());
            ps.setInt(3, i.getIdInternamento());
            ps.setInt(4, i.getCodFuncionario());
            ps.setString(5, i.getDoenca());
                  
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    
    }
    
    public String getDataInter(int codp){
        String d = "";
        
        try{
        String query = "select dataInternamento from internamento where codPaciente = "+codp;
         PreparedStatement ps = conexao.prepareStatement(query);
         rs = ps.executeQuery();
            
         rs.next();
         d = rs.getString("dataInternamento");
         
         ps.close();
         rs.close();
        }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }  
        
        return d;
    }
    
    public void removerInter(int cod){
        try{
            String q = "delete from internamento where codPaciente = "+cod;
            PreparedStatement stmt=conexao.prepareStatement(q);
            stmt.execute();
            stmt.close();
        
        }catch(SQLException e){
		throw new RuntimeException(e);
	}
    }
    
}
