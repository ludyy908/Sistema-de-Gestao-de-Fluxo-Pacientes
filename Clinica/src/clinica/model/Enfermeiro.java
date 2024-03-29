
package clinica.model;



public class Enfermeiro extends Funcionario{
    private String categoria;
    private String cuidados[]; //o enfermeiro pode cuidar no maximo de 5 pacientes, dai um array unidimensional [5] para cada enfermeiro

    public Enfermeiro(String categoria, String nome, int idFuncionario, String sexo, String conct, String morada, String nacio, String dept) {
        super(nome, idFuncionario, sexo, conct, morada, nacio, dept);
        this.categoria = categoria;
    }
    
   
    public Enfermeiro(){
        this("","", 0, "","","","","");
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public String[] getCuidados(){
        return cuidados;
    }
    
     private String[] preecherPacientes() {
        this.cuidados = new String [5];
        for (int i = 0; i < 5; i++){
            cuidados[i] = " ";
        }   
        return cuidados;
    }
     
    public void setCuidadosEnf(int i, String paciente){
        this.cuidados[i] = paciente;
    }
    @Override
    public String toString(){
        return super.toString() + "\nCategoria: "+categoria;
    }
}


    
    
   