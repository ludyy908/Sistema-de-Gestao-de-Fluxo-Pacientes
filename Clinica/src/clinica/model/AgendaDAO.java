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
            //a.setIdAgenda(rs.getInt("idAgenda"));
            //a.setCodFuncionar(rs.getInt("agenda,codFuncionario"));
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
    
    }
}

