
package sistemadegestao.servidorDados;

public class Consulta extends Registo {
    private  int nrConsulta;
    
    public Consulta(String data, String hora, String nomeMedico, String estado, String nomePaciente, int idPaciente, int nrConsulta) {
        super(data, hora, nomeMedico, estado, nomePaciente, idPaciente);
        this.nrConsulta = nrConsulta;
    }
    
    public Consulta(){
        this("", "", "", "", "", 0, 0);
    }
    
    public void setNrConsulta(int nrConsulta){
        this.nrConsulta = nrConsulta;
    }
    
    public int getNrConsulta(){
        return nrConsulta;
    }

    @Override
    public String toString(){
        return "Codigo de Consulta: "+nrConsulta+super.toString()+"\nEstado de Consulta: "+estado;
                
                
    }

    
    
    
    
}
