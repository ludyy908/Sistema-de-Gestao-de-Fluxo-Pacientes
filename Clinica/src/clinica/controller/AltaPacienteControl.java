/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controller;

import clinica.model.AltaPaciente;
import clinica.model.AltaPacienteDAO;
//import java.util.Date;
import java.sql.Date;

/**
 *
 * @author Amarilda Chihepe
 */
public class AltaPacienteControl {
    
   AltaPaciente ap;
   AltaPacienteDAO apDao = new AltaPacienteDAO();

    public AltaPacienteControl(int idAlta, String dataAlta, int idPac, int idFunc) {
        
        ap = new AltaPaciente();
        ap.setIdAlta(idAlta);
        ap.setDataAlta(dataAlta);
        ap.setIdPaciente(idPac);
        ap.setIdfuncionario(idFunc);    
        apDao.inserirPac(ap);
        
    }
   
   
    
}
