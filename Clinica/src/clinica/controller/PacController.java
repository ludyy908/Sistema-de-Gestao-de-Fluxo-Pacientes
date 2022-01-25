
package clinica.controller;

import java.util.*;
import clinica.model.Paciente;
import clinica.model.PacienteDAO;
import java.sql.SQLException;

/**
 *
 * @author Amarilda Chihepe
 */
public class PacController {
    Paciente p;
    PacienteDAO pd  = new PacienteDAO();

    public PacController(int idPaciente, String nome ,String nacionalidade, String apelido, String sexo, String endereco, String bi, int idade, String estadoCivil, String tel1, String tel2) 
    {
        p  = new Paciente();
        p.setIdPaciente(idPaciente);
        p.setNome(nome);
        p.setSexo(sexo);
        p.setEndereco(endereco);
        p.setIdade(idade);
        p.setBI(bi);
        p.setEstadoCivil(estadoCivil);
        p.setNacionalidade(nacionalidade);
        p.setTel1(tel1);
        p.setTel2(tel2);
        p.setApelido(apelido);
        
        Salvar();
    }
    
    public PacController(){ }
       
    
    public void Salvar(){
     
        pd.inserirPac(p);       
    }
    
    //lista so com os id dos pacientes
    public   ArrayList<Integer> getIds(){
        
        ArrayList<Integer> listPac = new ArrayList<Integer>();
        ArrayList<Paciente> m = pd.lerIdPac();
        
        for(int i=0;i<pd.lerIdPac().size();i++){
        
            listPac.add(m.get(i).getIdPaciente());
          
        }
        return listPac;
    }
    
    //Nomes dos Pacientes de acordo com o id Registo Alta   
    public String getPacNome(int codpac){
       return pd.getNomePac(codpac);
    }
    
    //Nome e id dos pacientes a serem internaos
     public   ArrayList<Integer> getIdInter(){
        
        ArrayList<Integer> listPac = new ArrayList<Integer>();
        ArrayList<Paciente> m = pd.lerIdPInter();
        
        for(int i=0;i<pd.lerIdPInter().size();i++){
        
            listPac.add(m.get(i).getIdPaciente());
          
        }
        return listPac;
    }
    
    //Nomes dos Pacientes de acordo com o id Registo Alta   
    public String getPacNomeInter(int codpac){
       return pd.getNomePInter(codpac);
   
    }
        
    
    //Todos os Dados dos pacientes
    public ArrayList<Paciente> getDados(){  
        ArrayList<Paciente> listaPac = pd.lerDados();       
        return listaPac;
    
    }
    
    //pacientes em cuidados de um determinao enfermeiro
    public  ArrayList<Paciente> getPacCuidados(int codF){
        return pd.getPacCuidados(codF);
    }
    
    public ArrayList <Integer> getCodPacientes (String nome) throws SQLException{
        return pd.getCodPaciente(nome);
    }
}
