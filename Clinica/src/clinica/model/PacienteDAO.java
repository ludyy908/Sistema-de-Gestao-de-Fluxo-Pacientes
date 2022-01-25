/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ludmila Mucavele
 */
public class PacienteDAO {
    
    ResultSet rs;
    Connection conexao;
    
    public PacienteDAO(){
         try{ 
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }   
    }
    
    public void inserirPac(Paciente p){
        String query = "INSERT INTO paciente(codPaciente, nome, genero, morada,idade, Bi, Estado_Civil, Nacionalidade, Telefone, Tel_Alternativo, Apelido) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1, p.getIdPaciente());
            ps.setString(2, p.getNome());
            ps.setString(3, p.getSexo());
            ps.setString(4, p.getEndereco());
            ps.setInt(5, p.getIdade());
            ps.setString(6, p.getBi());
            ps.setString(7, p.getEstadoCivil());
            ps.setString(8, p.getNacionalidade());
            ps.setString(9, p.getTel1());
            ps.setString(10, p.getTel2());
            ps.setString(11, p.getApelido());
            
            ps.executeUpdate();
            
            ps.close();
            conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    
    }
    
    //Ler todos os dados dos pacientes para tela LISTAPAC
    public ArrayList<Paciente> lerDados(){
        ArrayList<Paciente> paciente  = new ArrayList<Paciente>();
   
       try{
          String query = "select codPaciente, Apelido,nome, genero, morada,idade,BI, Estado_Civil, Nacionalidade,  Telefone from paciente";
          
          PreparedStatement stmt = conexao.prepareStatement(query);         
          rs = stmt.executeQuery();
          
            while(rs.next()){
               Paciente p = new Paciente();
       
                p.setIdPaciente(rs.getInt("codPaciente"));
                p.setApelido(rs.getString("Apelido"));
                p.setNome(rs.getString("nome"));
                p.setSexo(rs.getString("genero"));
                p.setEndereco(rs.getString("morada"));
                p.setIdade(rs.getInt("idade"));   
                p.setBi(rs.getString("bi"));
                p.setEstadoCivil(rs.getString("Estado_Civil"));
                p.setNacionalidade(rs.getString("Nacionalidade"));
                p.setTel1(rs.getString("telefone"));
                //p.setTel2(rs.getString("Tel_Alternativo"));
                p.setApelido(rs.getString("Apelido"));
                
                paciente.add(p);
             
       }
          rs.close();
          stmt.close();
       
       }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
       
       return paciente;
}
   
   
    
    //Carregar id de todos os pacientes internados para Tela de registo alta
     public ArrayList<Paciente> lerIdPac(){
        ArrayList<Paciente> Pac = new ArrayList<Paciente>();
        
        try{
            
            String q = "select codPaciente from internamento";
            PreparedStatement ps = conexao.prepareStatement(q);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Paciente p = new Paciente();
                p.setIdPaciente(rs.getInt("codPaciente"));
            
               Pac.add(p);
            }
            rs.close();
            ps.close();
          
            
        }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }      
        
          return Pac;
    }
     
     //id de todos os pacientes a serem internados
     public ArrayList<Paciente> lerIdPInter(){
        ArrayList<Paciente> Pac = new ArrayList<Paciente>();
        
        try{
            
            String q = "select codPaciente from paciente";
            PreparedStatement ps = conexao.prepareStatement(q);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Paciente p = new Paciente();
                p.setIdPaciente(rs.getInt("codPaciente"));
            
               Pac.add(p);
            }
            rs.close();
            ps.close();
          
            
        }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }      
        
          return Pac;
    }
     
     //carregar o nome dos paciente de acordo com id selecionado no comboBox na tela Regsito Alta
     
     public String getNomePac(int codPac){
         String nome = "";
         
         try{
             String query = "select nome from paciente p, internamento i where p.codPaciente = i.codPaciente and i.codPaciente = "+codPac;
             PreparedStatement ps = conexao.prepareStatement(query);
             rs = ps.executeQuery();
             
             rs.next();
             nome = rs.getString("nome");
             
            rs.close();
            ps.close();
         
         }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }   
         
         return nome;
     
     
     }
     
     //Nome dos paciente a ser internados de acordo com o id fornecido
     public String getNomePInter(int codPac){
         String nome = "";
         
         try{
             String query = "select nome from paciente where codPaciente = "+codPac;
             PreparedStatement ps = conexao.prepareStatement(query);
             rs = ps.executeQuery();
             
             rs.next();
             nome = rs.getString("nome");
             
            rs.close();
            ps.close();
         
         }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }   
         
         return nome;
     }
    
     //Pacientes em cuidados de um determinado enfermeiro
     
     public ArrayList<Paciente> getPacCuidados(int codF){
         ArrayList<Paciente> pacCuidados  =  new ArrayList<>();
     
         try{
             String q = "Select p.codPaciente, p.nome from paciente p, internamento i where p.codPaciente = i.codPaciente and i.codFuncionario = "+codF;
             
             PreparedStatement ps = conexao.prepareStatement(q);
             rs = ps.executeQuery();
             
             while(rs.next()){
                 Paciente p = new Paciente();
                 p.setIdPaciente(rs.getInt("p.codPaciente"));
                 p.setNome(rs.getString("p.Nome"));
                 
                 pacCuidados.add(p);
             }
         
         }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
         
         return pacCuidados;
     }
    
    public ArrayList <Integer> getCodPaciente (String nome) throws SQLException{
        ArrayList<Integer> codigo = new ArrayList<>();
        
        try{
            String query = "Select codPaciente from paciente where nome ='"+nome+"';";
            PreparedStatement ps = conexao.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()){
                codigo.add(rs.getInt("codPaciente"));
            }
        }
        catch(SQLException e){
             System.out.println("Falha na leitura dos dados "+e.getMessage());
        }
        return codigo;
    }
}
