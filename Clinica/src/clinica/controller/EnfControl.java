/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controller;

import clinica.model.Enfermeiro;
import clinica.model.EnfermeiroDAO;
import clinica.model.Paciente;
import java.util.ArrayList;

/**
 *
 * @author Amarilda Chihepe
 */
public class EnfControl {
    
    EnfermeiroDAO e = new EnfermeiroDAO();
    Enfermeiro enf = new Enfermeiro();
    Enfermeiro enf2 = new Enfermeiro();
    
    //inserir enfermeiros
    public EnfControl(int cod, String nome, String s, String contact, String morada, String nacio, String dpt, String categoria){
        
        enf.setIdFuncionatio(cod);
        enf.setNomeFunc(nome);
        enf.setSexo(s);
        enf.setContacto(contact);
        enf.setMorada(morada);
        enf.setNacionalidade(nacio);
        enf.setDepartamento(dpt);
        
        enf2.setIdFuncionatio(cod);
        enf2.setCategoria(categoria);
        
        e.inserirEnf(enf);
        e.inserirEnf2(enf2);
    
    }

    public EnfControl() {

    }
    
    
    //ler dados de todos os enfermeiros
    
     public ArrayList<Enfermeiro> getDados(){
            
        return e.lerDados();
    
    }    
     
     
     //Lista dos enfermeiros activos/ com pacientes 
     public ArrayList<Enfermeiro> getDadosEnfAct(){
        return e.getEnfActivos(); 
    }
     
     
     //lista so com os nomes dos enfermerios cadastrados
     public   ArrayList<String> getEnfs(){
        
        ArrayList<String> listEnf = new ArrayList<String>();
        ArrayList<Enfermeiro> m = e.lerNomeEnf();
        
        for(int i=0;i<m.size();i++){
        
            listEnf.add(m.get(i).getNomeFunc());
          
        }
        return listEnf;
    }
    
     
     //id de um determindo Enfermeiro
    public int getIdEnf(String n){
       return e.getEnfId(n);
    }
}
