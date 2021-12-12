
package sistemadegestao;



public class Medico extends Funcionario {
    private String especialidade; 
    private String agenda[][]; 
    public Medico(String nome, int idFuncionario, String especialidade){
        super(nome, idFuncionario);
        this.especialidade = especialidade; 
       agenda = preecherAgenda(); 
    }

    public Medico() {
        this("", 0, "");
    }

    public String getEspecialidade() {
        return especialidade;
    }
    
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    
    public String[][] getAgenda(){
        return agenda;
    }
    
    private String [][] preecherAgenda() {
        this.agenda = new String[30][11];
        for (int i = 0; i < 30; i++){
            for (int j = 0; j < 11; j++){
                agenda[i][j] = " ";
            }
        }
        return agenda;
    }
    
    public void setAgenda(int i, int j, String data){
        this.agenda[i][j] = data;
    }
    @Override
    public String toString(){
        return super.toString() + "\nEspecialidade do: "+especialidade;
    }

    
    
    
    
}
