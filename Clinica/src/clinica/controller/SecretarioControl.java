/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controller;

import clinica.model.Secretario;
import clinica.model.SecretarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Amarilda Chihepe
 */
public class SecretarioControl {
    
    public SecretarioControl(){ 
   }
    
    public  ArrayList<String> dadosSecretario(int codigo){
        SecretarioDAO sd = new SecretarioDAO();
        ArrayList<String> lista = new ArrayList<String>();
        ArrayList<Secretario> sec = sd.getSecreatrio(codigo);
        
        for(int i=0; i<sec.size();i++){
            lista.add(String.valueOf(sec.get(i).getIdFuncionario()));
            lista.add(sec.get(i).getNomeFunc()); 
            lista.add(sec.get(i).getEmail());
            lista.add(sec.get(i).getCargo());
           
        }
        
        return lista;
    }
}
