/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.controller;
import clinica.model.Doenca;
import clinica.model.DoencaDAO;
import java.util.ArrayList;
/**
 *
 * @author Ludmila Mucavele
 */
public class DoencaControl {
    private Doenca d;
    private DoencaDAO dDao = new DoencaDAO();
    
    public DoencaControl(int codD, String nomeD, String contagio) {
        d = new Doenca();
        d.setId_Doenca(codD);
        d.setNome(nomeD);
        d.setContagio(contagio);
   
        dDao.inserirCirurgia(d);
    }
    
    public DoencaControl (){
        
    }

    public int getDoenca(String nomeD) {
        Validacao va = new Validacao();
        int cod = 0, c = 1;
        ArrayList<String> nomes = new ArrayList<>(dDao.getNome());
        
        for (int i = 0; i < nomes.size(); i++){
            if (nomes.get(i).equalsIgnoreCase(nomeD))
                return 0;
            else
                c++;
        }
        if (c == nomes.size())
            cod = va.gerarCodigo();
        
        return cod;
    }
    
}
