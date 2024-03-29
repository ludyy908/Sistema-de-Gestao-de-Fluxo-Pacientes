/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.controller;


import clinica.model.Consulta;
import clinica.model.ConsultaDAO;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ludmila Mucavele
 */
public class ConsultaControl {
    Consulta c;
    ConsultaDAO cd  = new ConsultaDAO();
    Validacao validar = new Validacao();

    public ConsultaControl(int idPaciente, String nomePac ,String nomeMed, String hora, String data, String estado,  int idConsulta, int idMedico) 
    {
        c  = new Consulta();
        c.setMedico(nomeMed);
        c.setNrConsulta(idConsulta);
        c.setPaciente(nomePac);
        c.setIdPaciente(idPaciente);
        c.setHora(hora);
        c.setData(data);
        c.setEstado(estado);
   
        cd.inserirConsulta(c);
        cd.inserirMedConsulta(idConsulta, idMedico);
    }
    
    public ConsultaControl(){ }
       
    
    
    //preenchimento de listas de cirurgia

    public ArrayList<Consulta> getDados() {
        return cd.lerDados();
    }
    
    //validacao do id e verificacao de existencia de id antes de remover
    public int cancelar(int id) throws IOException {
        ArrayList <Consulta> lista = getDados(); int c = 0;
        id = validar.validarInt(100, 999, id);
        if (id == 0)
            return id;
        for (int i = 0; i < lista.size(); i++){
            c++;
            if (lista.get(i).getNrConsulta() == id){
                cd.cancelarCirurgia(id);
                return id;
            }
            if ( c == lista.size())
                return 0;
        }
        return id;
    }

   
    
    
    //dados de cirurgia de um determinado paciente
    public ArrayList<Consulta> getDadosCons(int cod){
        return cd.getDadosCons(cod);
    }
    
}
