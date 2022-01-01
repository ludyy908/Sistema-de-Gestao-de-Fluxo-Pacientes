
package clinica.model;
import java.io.Serializable;



public class Paciente implements Serializable{
    private String nome, endereco, bi, estado;
    private int idPaciente;
    private String[] telefone;
    private char sexo;
    private byte idade;
    private Doenca doenca;
   
    
    public Paciente(String nome, int idPaciente, char sexo, String[] telefone, String endereco, String bi, byte idade, String estado){
        this.nome = nome;
        this.idPaciente = idPaciente;
        this.telefone = telefone;
        this.endereco = endereco; 
        this.bi = bi;
        this.idade = idade;
        this.sexo = sexo;
        this.estado = estado;
      
        
    } 
    
    public Paciente(){
        this("", 0, '0', null, "", "",(byte) 0, "");
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setIdPaciente(int idPaciente) {
           this.idPaciente = idPaciente;
           
    }
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
    
    public char getSexo() {
        return sexo;
    }
    
    public void setSexo(char sexo) {
           this.sexo = sexo;
    }
    public String getTelefone(){
        String c = "";
        for(byte i = 0; i < telefone.length; i++){
            c += telefone[i] +"";;
        }
        return c;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEndereco() {
        return endereco;
    }
    
    public void setBI(String bi) {
        this.bi = bi;
    }
    
    public String getBI(){
        return bi;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public void setTelefone(String telefone[]) {
           this.telefone = telefone;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca; 
    }
    
    @Override
    public String toString() {
        return "Nome do Paciente: " + nome + "\nCodigo do Paciente: " + idPaciente + "\nTelefone: " + getTelefone() + "\nSexo: " 
                + sexo + "\nEndereco: " + endereco + "\nNumero de BI: " + bi+"\n"+doenca.toString()+
                "\nEstado de Paciente: "+estado; 
    } 

    

    

   
    
}
