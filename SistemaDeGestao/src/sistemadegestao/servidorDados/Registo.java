
package sistemadegestao.servidorDados;

import java.io.Serializable;


public class Registo implements Serializable {
    protected String data, hora, nomeMedico, estado, nomePaciente;
    protected int idPaciente;
    
    public Registo(String data, String hora, String nomeMedico, String estado, String nomePaciente, int idPaciente){
        this.data = data;
        this.estado = estado;
        this.hora = hora;
        this.nomePaciente = nomePaciente;
        this.idPaciente = idPaciente;
        this.nomeMedico = nomeMedico;
    }
    
    public Registo(){
        this("", "", "", "", "", 0);
    }
    
     public void setData(String data){
         this.data = data;
     }
     
      public void setHora(String hora){
         this.hora = hora;
     }
    
    public String getMedico(){
        return nomeMedico;
    }
    
    public void setMedico(String nomeMedico){
        this.nomeMedico = nomeMedico;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
     public int getidPaciente(){
        return idPaciente;
    }
     
     public String getPaciente(){
        return nomePaciente;
    }
     
    public void setPaciente(String nomePaciente){
        this.nomePaciente = nomePaciente;
    }
    
    public void setIdPaciente(int idPaciente){
        this.idPaciente = idPaciente;
    }
    
    public String getData(){
        return data;
    }
    
    public String getHora() {
        return hora;
    }

    @Override
   public String toString(){
       return "\nNome do Paciente: "+nomePaciente+"\nCodigo de Paciente: "+idPaciente+
                "\nData e Hora de Cirurgia: "+data+", "+hora+"\nMedico que Realizara a Cirurgia: "+
                nomeMedico;
    }
   
}
