
package clinica.model;
import java.sql.*;
//import java.util.Date;

/**
 *
 * @author Amarilda Chihepe
 */
public class AltaPacienteDAO {
    
    ResultSet rs;
    Connection conexao;

    public AltaPacienteDAO() {
        try{ 
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }  
    }
    
    //Inserir dados dos pacientes que tiveram Alta na tabela Alta
     public void inserirPac(AltaPaciente ap){
        String query = "INSERT INTO Alta(idAlta, dataAlta,codPaciente, codFuncionario) "
                + "VALUES(?,?,?,?)";
        try{
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1, ap.getIdAlta());
            ps.setString(2, ap.getDataAlta());
            ps.setInt(3, ap.getIdPaciente());
            ps.setInt(4, ap.getIdfuncionario());
                      
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    
    }
    
    
}
