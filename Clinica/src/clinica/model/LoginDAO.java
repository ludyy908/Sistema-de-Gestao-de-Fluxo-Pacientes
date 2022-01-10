/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Ludmila Mucavele
 */

public class LoginDAO{
    private Connection conexao;

        public LoginDAO(){

            try{
                conexao = BDconexao.getConnection();
            }catch(SQLException|ClassNotFoundException ex){
                System.out.println("Erro de conexao: "+ex.getMessage());
            }
        }
        
        public String getFuncionario(String password){
            String query=("Select nome from secretario where codFuncionario ="+password);               
            try {
                PreparedStatement stmt = conexao.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                query = rs.getString(1);
                
            }
            catch (SQLException ex) {
                System.out.println("Erro de seleccao da base de dados:: "+ex.getMessage());
            }
            return query;
            
        }
}



