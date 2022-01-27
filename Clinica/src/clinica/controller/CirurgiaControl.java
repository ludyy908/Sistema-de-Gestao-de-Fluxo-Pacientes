/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.controller;

import java.util.ArrayList;
import clinica.model.Cirurgia;
import clinica.model.CirurgiaDAO;
import java.io.IOException;

/**
 *
 * @author Ludmila Mucavele
 */
public class CirurgiaControl {
    Cirurgia c;
    CirurgiaDAO cd  = new CirurgiaDAO();
    Validacao validar = new Validacao();

    public CirurgiaControl(int idPaciente, String nomePac ,String nomeMed, String hora, String data, String estado,  int idCirurgia, int idMedico) 
    {
        c  = new Cirurgia();
        c.setMedico(nomeMed);
        c.setNrCirurgia(idCirurgia);
        c.setPaciente(nomePac);
        c.setIdPaciente(idPaciente);
        c.setHora(hora);
        c.setData(data);
        c.setEstado(estado);
   
        cd.inserirCirurgia(c);
        cd.inserirMedCirurgia(idMedico, idCirurgia);
    }
    
    public CirurgiaControl(){ }
       
    
    
    //preenchimento de listas de cirurgia

    public ArrayList<Cirurgia> getDados() {
        return cd.lerDados(); 
    }
    
    public int cancelar(int id) throws IOException {
        ArrayList <Cirurgia> lista = getDados();
        id = validar.validarInt(100, 999, id);
        if (id == 0)
            return id;
        for (int i = 0; i < lista.size(); i++)
            if (lista.get(i).getNrCirurgia() == id)
                cd.cancelarCirurgia(id);
        return id;
    }
    
    //Cirurgia de um determinado paciente
     public ArrayList<Cirurgia> getDadosCons(int cod){
        return cd.getDadosCir(cod);
    }
}
