
package clinica.controller;

import java.util.*;
import clinica.model.Paciente;
import clinica.model.PacienteDAO;

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
       /* ArrayList<Paciente> p = pd.lerDados();
        
        for(int i=0;i<pd.lerDados().size();i++){
            String[] dado = new String[11];
            dado[0] = String.valueOf(p.get(i).getIdPaciente());
            dado[1] = p.get(i).getApelido();
            dado[2] = p.get(i).getNome();
            dado[3] = p.get(i).getSexo();
            dado[4] = p.get(i).getEndereco();
            dado[5] = String.valueOf(p.get(i).getIdade());
            dado[6] = p.get(i).getBi();
            dado[7] = p.get(i).getEstadoCivil();
            dado[8] = p.get(i).getNacionalidade();
            dado[9] = p.get(i).getTel1();
            dado[10] = p.get(i).getTel2();
            
            listaPac.add(dado);
            
        }*/
        
        return listaPac;
    
    }
}
