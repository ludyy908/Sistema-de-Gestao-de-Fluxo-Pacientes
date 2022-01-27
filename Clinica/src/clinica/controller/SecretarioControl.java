/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controller;

import clinica.model.Secretario;
import clinica.model.SecretarioDAO;


/**
 *
 * @author Amarilda Chihepe
 */
public class SecretarioControl {
    
    public SecretarioControl(){ 
   }
    
    public  Secretario dadosSecretario(int codigo){
        SecretarioDAO sd = new SecretarioDAO();
        Secretario sec = sd.getSecretario(codigo);
        
        return sec;
    }
}
