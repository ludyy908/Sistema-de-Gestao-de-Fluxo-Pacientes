
package clinica.model;

import java.io.Serializable;



public class Funcionario implements Serializable{
    protected int idFuncionario;
    public String nomeFunc;
    protected String sexo, contacto, morada, nacionalidade, departamento;
    
    public Funcionario(String nome, int idFuncionario, String sexo, String conct, String morada, String nacio, String dept){
        this.nomeFunc = nome;
        this.idFuncionario = idFuncionario;
        this.sexo = sexo;
        this.contacto = conct;
        this.morada  = morada;
        this.nacionalidade = nacio;
        this.departamento = dept;
        
    }
    
    public Funcionario(){
        this("", 0,"","","","","");
    }
    
    public void setFuncionario(String nome){
        nomeFunc = nome; 
    }
    
    public void setIdFuncionatio(int idFuncionario){
        this.idFuncionario = idFuncionario;
    }
    
    
    public int getIdFuncionario(){
        return idFuncionario;
        
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
    @Override
    public String toString(){
        return "Nome do Funcionario: "+nomeFunc+"\nCodigo de Funcionario: "+idFuncionario;
    }
    
}
