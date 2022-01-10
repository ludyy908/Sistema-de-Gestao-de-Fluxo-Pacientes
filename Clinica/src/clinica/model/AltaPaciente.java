/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.model;

import java.sql.Date;

/**
 *
 * @author Amarilda Chihepe
 */
public class AltaPaciente {
    
    private int idAlta, idPaciente, idfuncionario;
    private String nomeMedico;
    private String dataAlta;

    public int getIdAlta() {
        return idAlta;
    }

    public void setIdAlta(int idAlta) {
        this.idAlta = idAlta;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    
    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

   /* public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }*/

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }
    
    
    
    
    
}
