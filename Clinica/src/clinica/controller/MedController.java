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
     Medico med = new Medico();
     Medico med2 = new Medico();

    public MedController() {
        
    }
    
    //inserir enfermeiros
    public MedController(int cod, String nome, String s, String contact, String morada, String nacio, String dpt, String esp){
        
        med.setIdFuncionatio(cod);
        med.setNomeFunc(nome);
        med.setSexo(s);
        med.setContacto(contact);
        med.setMorada(morada);
        med.setNacionalidade(nacio);
        med.setDepartamento(dpt);
        
        med2.setIdFuncionatio(cod);
        med2.setEspecialidade(esp);
        
        md.inserirMed(med);
        md.inserirMed2(med2);
    
    }


    //dados de todos os medicos da clinica
    
    public ArrayList<Medico> getdDadosMed(){
        return md.lerDadosMed();  
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
    
    public ArrayList<Integer> getCodMed(String m){
        return md.getCodMed(m);
    }

    public String verificarDataAgenda(int cod, String d, String h) {
       ArrayList <String> data = md.getData(cod);
       ArrayList <String> hora;
       for (int i = 0; i < data.size(); i++)
           if (data.get(i).equalsIgnoreCase(d)){
                hora = verificarHoraAgenda(cod);
                for (int j = 0; j < hora.size(); j++)
                    if (hora.get(j).equalsIgnoreCase(h))
                        return null;
           }
        return d;
    }


    public ArrayList<String> verificarHoraAgenda(int cod) {
        ArrayList<String> hora = new ArrayList<>();
        hora = md.getHoras(cod);
        return hora;
    }

    public ArrayList <Medico> getMedTipo (String tipo){
        ArrayList <Medico> lista = null; 
        if (tipo.equalsIgnoreCase("Cirurgia"))
            lista = md.getMedicos(tipo);
        if (tipo.equalsIgnoreCase("Consulta"))
            lista = md.getMedicos(tipo);
    return lista;
    }
    
    
    
}
