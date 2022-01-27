/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controller;
import clinica.model.*;
import java.util.ArrayList;

/**
 *
 * @author Amarilda Chihepe
 */
public class AgendaControl {
    
    Agenda a = new Agenda();
    AgendaDAO aDao = new AgendaDAO();

    public AgendaControl() {
        
    }
      
    //Inserir dados na Ag
    public AgendaControl(int idAgenda, int codF, String data, String hora, String tipo){
        a = new Agenda();
        a.setIdAgenda(idAgenda);
        a.setCodFuncionar(codF);
        a.setData(data);
        a.setHora(hora);
        a.setTipoReg(tipo);
        aDao.inserirAgenda(a);
       
    }
    
    public ArrayList<Agenda> getAgenda(int codMed){
        return aDao.lerAgendaMed(codMed);
    }
}
