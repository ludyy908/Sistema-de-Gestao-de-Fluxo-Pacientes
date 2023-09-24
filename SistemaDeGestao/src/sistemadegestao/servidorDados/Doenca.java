
package sistemadegestao.servidorDados;
import java.io.Serializable;


public class Doenca implements Serializable {
    
    private String nome;
    private int id_Doenca;
    private  String contagio;
  
    public Doenca(String nome, int id_Doenca, String contagio) {
        this.nome = nome;
        this.id_Doenca = id_Doenca;
        this.contagio = contagio;
    }

    public Doenca() {
        this(" ", 0, " ");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome (){
        return nome;
    }


    public void setId_Doenca(int idDoenca) {
        this.id_Doenca = idDoenca;
    }
      
     public int getIdDoenca (){
        return id_Doenca;
    }

    public String getContagio() {
        return contagio;
    }

    public void setContagio(String contagio) {
        this.contagio = contagio;
    }

    @Override
    public String toString() {
        return "Nome da doenca :" + nome + "\nNumero de identificacao da doenca: " + id_Doenca + "\nDoenca contagiosa:" + contagio;
    }
    
    
    
    
    
}
