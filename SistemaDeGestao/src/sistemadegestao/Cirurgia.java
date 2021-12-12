
package sistemadegestao;

public class Cirurgia extends Registo {
    private  int nrCirurgia;
    
    public Cirurgia(String data, String hora, String nomeMedico, String estado, String nomePaciente, int idPaciente, int nrCirurgia) {
        super(data, hora, nomeMedico, estado, nomePaciente, idPaciente);
        this.nrCirurgia = nrCirurgia;
    }
    
    public Cirurgia(){
        this("", "", "", "", "", 0, 0);
    }
    
    public void setNrCirurgia(int nrCirurgia){
        this.nrCirurgia = nrCirurgia;
    }
    
    public int getNrCirurgia(){
        return nrCirurgia;
    }
    
    @Override
    public String toString(){
        return "Codigo de Cirurgia: "+nrCirurgia+super.toString()+"\nEstado de Cirurgia: "+estado;
                
                
    }
   

    
}
