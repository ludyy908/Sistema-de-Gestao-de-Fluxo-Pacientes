/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.model;
import java.sql.*;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author Amarilda Chihepe
 */
public class AgendaDAO {
    
    ResultSet rs;
    Connection conexao;
    
    public AgendaDAO(){
         try{ 
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }   
    
    }
    
    public ArrayList<Agenda> lerAgendaMed(int codMed){
        
        ArrayList<Agenda> agenda = new ArrayList<>();
        
        try{
        String query = "Select data, hora, tipo_registo from Agenda , medico where agenda.codFuncionario = medico.codFuncionario"
                + " and agenda.codFuncionario = "+codMed;
        PreparedStatement ps = conexao.prepareStatement(query);
        rs = ps.executeQuery();
        
        while(rs.next()){
            Agenda a = new Agenda(); 
            a.setData(rs.getString("data"));
            a.setHora(rs.getString("hora"));
            a.setTipoReg(rs.getString("tipo_registo"));
            agenda.add(a);
            
        }
        
        }catch(SQLException e){
          System.out.println("Falha na leitura dos dados "+e.getMessage());
        }
        
        return agenda;
    }
    
    public void inserirAgenda(Agenda a){
        String query = "INSERT INTO agenda VALUES(?,?,?,?,?)";
        try{
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1, a.getIdAgenda());
            ps.setInt(2, a.getCodFuncionar());
            ps.setString(3, a.getData() );
            ps.setString(4, a.getHora());
            ps.setString(5, a.getTipoReg());
            
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    }
}

