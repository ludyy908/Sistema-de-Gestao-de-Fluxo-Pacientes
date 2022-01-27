/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.model;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Ludmila Mucavele
 */
public class MedicoDAO {
    
    ResultSet rs;
    Connection conexao;
    
    public MedicoDAO(){
        try{ 
            conexao=BDconexao.getConnection();
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println("Erro de conexao: "+ex.getMessage());           
        }   
    }
    
    
    
    //guardar todos dados dos medicos inseridos no cadastrado (Na tabela dos funcionarios)
    
    public void inserirMed(Medico m){
        
        String query1;
        query1 = "insert into Funcionario(codFuncionario, nome, sexo, contacto, morada, Nacionalidade, departamento) values(?,?,?,?,?,?,?)";
        
         try{
            PreparedStatement ps = conexao.prepareStatement(query1);
            
            ps.setInt(1, m.getIdFuncionario());
            ps.setString(2, m.getNomeFunc());
            ps.setString(3, m.getSexo());
            ps.setString(4, m.getContacto());
            ps.setString(5, m.getMorada());
            ps.setString(6, m.getNacionalidade());
            ps.setString(7, m.getDepartamento());
            
       
            ps.executeUpdate();
            ps.close();
            //conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
    
         
    }
    //(Na tabela dos medicos)
       public void inserirMed2(Medico m){
        
        String query2;
        query2 = "insert into medico(codFuncionario, especializacao) values(?,?)";
        
         try{
            PreparedStatement ps2 = conexao.prepareStatement(query2);
            
            ps2.setInt(1, m.getIdFuncionario());
            ps2.setString(2, m.getEspecialidade());
            

            ps2.executeUpdate();
            ps2.close();
            conexao.close();
        }
        catch(SQLException sqle){
            System.out.println("Problemas na insercao de dados no banco de dados "+sqle.getMessage());
        }
        
     }
       
       
       //ler todos os dados dos Medicos da clinica
        public ArrayList<Medico> lerDadosMed(){
        ArrayList<Medico> med  = new ArrayList<>();     
       
       try{
          String query = "select medico.codFuncionario, nome, sexo, contacto, morada, Nacionalidade, departamento, especializacao from medico , funcionario "
                  +"where medico.codFuncionario = funcionario.codFuncionario";
          
          PreparedStatement stmt = conexao.prepareStatement(query);         
          rs = stmt.executeQuery();
          
            while(rs.next()){
                Medico m = new Medico();
                m.setIdFuncionatio(rs.getInt("medico.codFuncionario"));
                m.setNomeFunc(rs.getString("nome"));
                m.setSexo(rs.getString("sexo"));
                m.setContacto(rs.getString("contacto"));
                m.setMorada(rs.getString("morada"));
                m.setNacionalidade(rs.getString("Nacionalidade"));           
                m.setDepartamento(rs.getString("departamento"));
                m.setEspecialidade(rs.getString("especializacao"));
                
               med.add(m);
             
       }
          rs.close();
          stmt.close();
       
       }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        } 
       
       return med;
}
        
    //Carregar os nomes dos medicos para tela registo alta
    public ArrayList<Medico> lerDados(){
        ArrayList<Medico> medicos = new ArrayList<Medico>();
        
        try{
            
            String q = "select nome from funcionario, medico where medico.codFuncionario = funcionario.codFuncionario";
            PreparedStatement ps = conexao.prepareStatement(q);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Medico med = new Medico();
                med.setFuncionario(rs.getString("nome"));
            
                medicos.add(med);
            }
            rs.close();
            ps.close();
          
            
        }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }      
        
          return medicos;
    }
    
    //id Do medico de acordo com o nome fornecido para guaradar na tabela de registo de alta
    public int getMedId(String medNome){
         int id = 0;
         
         try{
             String query = "select m.codFuncionario from funcionario f ,medico m where f.nome = '"+medNome+"' and f.codFuncionario = m.codFuncionario";
             PreparedStatement ps = conexao.prepareStatement(query);
             rs = ps.executeQuery();
             
             rs.next();
             id = rs.getInt("m.codFuncionario");
             
            rs.close();
            ps.close();
         
         }catch(SQLException e){
            System.out.println("Falha na leitura dos dados "+e.getMessage());
        }   
         
         return id;
     
     
     }
    
    public ArrayList<Medico> getMedicos(String tipo){
        ArrayList <Medico> lista = new ArrayList<>();
        if (tipo.equalsIgnoreCase("Cirurgia")){
            String query = "select medico_cirurgia.codFuncionario, nome, especializacao "
                    + "from medico, funcionario, medico_cirurgia where "
                    + "medico.codFuncionario = medico_cirurgia.codFuncionario "
                    + "and medico_cirurgia.codFuncionario = funcionario.codFuncionario";
            try{ 
                PreparedStatement stmt = conexao.prepareStatement(query);         
                rs = stmt.executeQuery();

                while(rs.next()){
                    Medico m = new Medico();
                    m.setIdFuncionatio(rs.getInt("codFuncionario"));
                    m.setNomeFunc(rs.getString("nome"));
                    m.setEspecialidade(rs.getString("especializacao"));
                    
                   lista.add(m);
                }
              rs.close();
              stmt.close();


            }catch(SQLException es){
                System.out.println("Falha na leitura dos dados "+es.getMessage());
            } 
            return lista;
        }
        
        if (tipo.equalsIgnoreCase("Consulta")){
            String query = "select consulta_funcionario.codFuncionario, nome, especializacao from medico, "
                    + "funcionario, consulta_funcionario where "
                    + "medico.codFuncionario = consulta_funcionario.codFuncionario";
            try{ 
                PreparedStatement stmt = conexao.prepareStatement(query);         
                rs = stmt.executeQuery();

                while(rs.next()){
                    Medico m = new Medico();
                    m.setIdFuncionatio(rs.getInt("codFuncionario"));
                    m.setNomeFunc(rs.getString("nome"));
                    m.setEspecialidade(rs.getString("especializacao"));
                    
                   lista.add(m);
                }
              rs.close();
              stmt.close();


            }catch(SQLException es){
                System.out.println("Falha na leitura dos dados "+es.getMessage());
            } 
            return lista;
        }
        
        return lista;
    }
    
    
    
    public ArrayList<Integer> getCodMed(String nome){
    ArrayList<Integer> codigo = new ArrayList<>();
        
        try{
            String query = "select m.codFuncionario from funcionario f, medico m where f.nome = '"+nome+"' and f.codFuncionario = m.codFuncionario";
            PreparedStatement ps = conexao.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()){
                codigo.add(rs.getInt("codFuncionario"));
                codigo.trimToSize();
            }
        }
        catch(SQLException e){
             System.out.println("Falha na leitura dos dados "+e.getMessage());
        }
        return codigo;
    }
    
    public ArrayList<String> getHoras (int cod){
        ArrayList<String> horas = new ArrayList<>();
        try{
            String query = "select Hora from agenda where codFuncionario ='"+cod+"'";
            PreparedStatement ps = conexao.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()){
                horas.add(rs.getString("Hora"));
            }
        }
        catch(SQLException e){
             System.out.println("Falha na leitura dos dados "+e.getMessage());
        }
        return horas;
    }
    
    public ArrayList<String> getData (int cod){
        ArrayList<String> data = new ArrayList<>();
        try{
            String query = "select Data from agenda where codFuncionario ='"+cod+"'";
            PreparedStatement ps = conexao.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()){
                data.add(rs.getString("Data"));
            }
        }
        catch(SQLException e){
             System.out.println("Falha na leitura dos dados "+e.getMessage());
        }
        return data;
    }
    
    
}
