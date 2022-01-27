/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controller;

import clinica.model.Internamento;
import clinica.model.InternamentoDAO;

/**
 *
 * @author Amarilda Chihepe
 */
public class InterControl {
    
    Internamento i;
  InternamentoDAO iDao = new InternamentoDAO();
  
  public InterControl() {
    }
    

    public InterControl( String dataInter, int idPac,int idInter, int idFunc, String doenca) {
        
        i = new Internamento();
        i.setDataInter(dataInter);
        i.setCodPacient(idPac);
        i.setIdInternamento(idInter);
        i.setCodFuncionario(idFunc);
        i.setDoenca(doenca);
        
        
        iDao.inserirPac(i);
        
    }

   
    
    public String getD(int cod){
        return iDao.getDataInter(cod);
    
    }
    
    public void InterRemove(int c){
        iDao.removerInter(c);
    }
}
