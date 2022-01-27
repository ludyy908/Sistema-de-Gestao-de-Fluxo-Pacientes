/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.controller;
import clinica.model.LoginDAO;
import clinica.view.Menu;
/**
 *
 * @author Ludmila Mucavele
 */
public class LoginControl {
    LoginDAO login = new LoginDAO();
    
    public int getFuncionario(String password, String nome){
        if (login.getFuncionario(password).equalsIgnoreCase(nome)){
            Menu menu = new Menu();
            menu.setSecretario(Integer.parseInt(password));
            return 1;
        }
        return 0;
    }
}
