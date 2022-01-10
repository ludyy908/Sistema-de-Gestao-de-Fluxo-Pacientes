/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controller;
import clinica.model.Medico;
import clinica.model.MedicoDAO;
import java.util.*;

/**
 *
 * @author Amarilda Chihepe
 */
public class MedController {
    
     MedicoDAO md = new MedicoDAO();

    public MedController() {
        
    }
    
    //lista so com nomes dos medicos para tela resgito Alta
    public   ArrayList<String> getMedico(){
        
        ArrayList<String> listMed = new ArrayList<String>();
        ArrayList<Medico> m = md.lerDados();
        
        for(int i=0;i<md.lerDados().size();i++){
        
            listMed.add(m.get(i).getNomeFunc());
          
        }
        return listMed;
    }
    
    //id de um determindo medico
    public int getIdMed(String n){
       return md.getMedId(n);
    }
    
}
