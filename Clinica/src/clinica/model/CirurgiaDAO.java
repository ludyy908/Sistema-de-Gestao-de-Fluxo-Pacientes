/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Ludmila Mucavele
 */
public class CirurgiaDAO {
    private Connection conexao;
    Cirurgia c;
     ResultSet rs;
    
    public CirurgiaDAO(){
        
        try{
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }
    }
    
    public void inserirCirurgia(Cirurgia c){
        String query = "INSERT INTO cirurgia VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1, c.getNrCirurgia());
            ps.setInt(2, c.getidPaciente());
            ps.setString(3, c.getPaciente() );
            ps.setString(4, c.getMedico());
            ps.setString(5, c.getData());
            ps.setString(6,c.getHora());
            ps.setString(7,c.getEstado());
            
            
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    
    }
    
    //Ler todos os dados para tela LISTACir
    public ArrayList<Cirurgia> lerDados(){
        ArrayList<Cirurgia> cir  = new ArrayList<Cirurgia>();
        
        String query = "select * from cirurgia";
        try{
          
          PreparedStatement stmt = conexao.prepareStatement(query);         
         rs = stmt.executeQuery();
          
            while(rs.next()){
              c = new Cirurgia();
                
                c.setIdPaciente(rs.getInt("codPaciente"));
                c.setPaciente(rs.getString("nomePac"));
                c.setNrCirurgia(rs.getInt("numeroCirurgia"));
                c.setMedico(rs.getString("nomeMed"));
                c.setData(rs.getString("data"));
                c.setHora(rs.getString ("hora"));
                c.setEstado(rs.getString("estado"));
                cir.add(c);
       }
          rs.close();
          stmt.close();
       
       }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
       
       return cir;
}

    public void cancelarCirurgia(int id){
        String query = "UPDATE cirurgia SET estado = 'Cancelado' WHERE numeroCirurgia = "+id;
        try{
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Falha na actualizacao dos dados "+e.getMessage());
        } 
    }
<<<<<<< Updated upstream
   
    
    //Cirurgia de um determinado paciente
    public ArrayList<Cirurgia> getDadosCir(int idPac){
            
            ArrayList<Cirurgia> cir = new ArrayList();

        try{
            String query = "Select c.numeroCirurgia, nomeMed, data, hora, f.nome from cirurgia c, enfermeiro_cirurgia ec, funcionario f "
                    + "where c.numeroCirurgia = ec.numeroCirurgia and codPaciente = "+idPac;
            PreparedStatement stmt = conexao.prepareStatement(query);
             rs = stmt.executeQuery();
             
             rs.next();
             c  = new Cirurgia();
             Enfermeiro enf = new Enfermeiro();
             
             c.setNrCirurgia(rs.getInt("numeroCirurgia"));
             c.setData(rs.getString("data"));
             c.setHora(rs.getString("hora"));
             c.setMedico(rs.getString("nomeMed"));
             enf.setNomeFunc(rs.getString("f.nome"));
             
             cir.add(c);
            //cir.add(enf);
             

        }catch(SQLException e){
                System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
        
        return cir;
    }  
=======
    
    public void inserirMedCirurgia(int idMedico, int idCirurgia) {
        String query = "INSERT INTO medico_cirurgia VALUES(?,?)";
        try{
            try (PreparedStatement ps = conexao.prepareStatement(query)) {
                ps.setInt(1, idCirurgia);
                ps.setInt(2, idMedico);
                
                ps.executeUpdate();
            }
            conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    }
>>>>>>> Stashed changes
}
