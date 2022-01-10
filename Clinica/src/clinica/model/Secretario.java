/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.model;

/**
 *
 * @author Amarilda Chihepe
 */
public class Secretario extends Funcionario{
    private String cargo, email;
    int balcao;

    public Secretario(String cargo, String email, int balcao, String nome, int idFuncionario, String sexo, String conct, String morada, String nacio, String dept) {
        super(nome, idFuncionario, sexo, conct, morada, nacio, dept);
        this.cargo = cargo;
        this.email = email;
        this.balcao = balcao;
    }
    
    public Secretario(){}

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalcao() {
        return balcao;
    }

    public void setBalcao(int balcao) {
        this.balcao = balcao;
    }
    
    
}
