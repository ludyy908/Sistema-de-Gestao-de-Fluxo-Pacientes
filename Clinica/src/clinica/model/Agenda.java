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
public class Agenda {
    
    private int idAgenda, codFuncionar;
    private String data, hora, tipoReg;

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public int getCodFuncionar() {
        return codFuncionar;
    }

    public void setCodFuncionar(int codFuncionar) {
        this.codFuncionar = codFuncionar;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoReg() {
        return tipoReg;
    }

    public void setTipoReg(String tipoReg) {
        this.tipoReg = tipoReg;
    }
    
    
    
    
}
