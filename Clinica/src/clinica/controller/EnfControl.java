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
         
    
        /*ArrayList<String[]> listaEnf = new ArrayList<String []>();
        ArrayList<Enfermeiro> lista = e.lerDados();
        
        for(int i=0;i<e.lerDados().size();i++){
            String[] dado = new String[8];
            dado[0] = String.valueOf(lista.get(i).getIdFuncionario());
            dado[1] = lista.get(i).getNomeFunc();
            dado[2] = lista.get(i).getSexo();
            dado[3] = lista.get(i).getContacto();
            dado[4] = lista.get(i).getMorada();
            dado[5] = lista.get(i).getNacionalidade();
            dado[6] = lista.get(i).getDepartamento();
            dado[7] = lista.get(i).getCategoria();
            
            listaEnf.add(dado);
            
        }*/
        
        return e.lerDados();
    
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
