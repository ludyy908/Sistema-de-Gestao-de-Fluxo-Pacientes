/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.model;

/**
 *
 * @author Amarilda Chihepe
 */
public class Internamento {
    
    private String dataInter, doenca;
    private int codPacient, codFuncionario, idInternamento;

    public String getDataInter() {
        return dataInter;
    }

    public void setDataInter(String dataInter) {
        this.dataInter = dataInter;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public int getCodPacient() {
        return codPacient;
    }

    public void setCodPacient(int codPacient) {
        this.codPacient = codPacient;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getIdInternamento() {
        return idInternamento;
    }

    public void setIdInternamento(int idInternamento) {
        this.idInternamento = idInternamento;
    }
    
    
    
}
