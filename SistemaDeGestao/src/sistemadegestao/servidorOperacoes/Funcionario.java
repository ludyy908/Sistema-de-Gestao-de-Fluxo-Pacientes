
package sistemadegestao.servidorOperacoes;

import java.io.Serializable;



public class Funcionario implements Serializable{
    protected int idFuncionario;
    public String nomeFunc;
    
    public Funcionario(String nome, int idFuncionario){
        this.nomeFunc = nome;
        this.idFuncionario = idFuncionario;
        
    }
    
    public Funcionario(){
        this("", 0);
    }
    
    public void setFuncionario(String nome){
        nomeFunc = nome; 
    }
    
    public void setIdFuncionatio(int idFuncionario){
        this.idFuncionario = idFuncionario;
    }
    
    public String getFuncionario(){
        return nomeFunc;
    }
    
    public int getIdFuncionario(){
        return idFuncionario;
        
    }
    
    @Override
    public String toString(){
        return "Nome do Funcionario: "+nomeFunc+"\nCodigo de Funcionario: "+idFuncionario;
    }
    
}
