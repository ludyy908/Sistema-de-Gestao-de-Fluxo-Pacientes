
package clinica.model;


public class Paciente {
    private String nome, endereco, bi, estado, nacionalidade, apelido, genero,estadoCivil, tel1, tel2;
    private int idPaciente;
    //private String[] telefone;
    private int idade;
    private Doenca doenca;
   
    //Acrescentar atributos na classe paciente
    public Paciente(String nacionalidade, String apelido, String nome, int idPaciente, String genero, String[] telefone, String endereco, String bi, int idade, String estado, String estadoCivil, String tel1, String tel2){
      
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.genero = genero;
        this.endereco = endereco;       
        this.idade = idade;
        this.bi = bi;
        this.estadoCivil = estadoCivil;
        this.nacionalidade = nacionalidade;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.estado = estado;     
        this.apelido = apelido;
       
        
    } 
    
    public Paciente(){
        this("","","", 0, "", null, "", "",(byte) 0, "", "", "","");
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
    
    public String getSexo() {
        return genero;
    }
    
    public void setSexo(String sexo) {
           this.genero = sexo;
    }
    
   /* public String getTelefone(){
        String c = "";
        for(byte i = 0; i < telefone.length; i++){
            c += telefone[i] +"";
        }
        return c;
    }*/
    
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

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public int getIdade(){
        return idade;
    }
    
    /*public void setTelefone(String telefone[]) {
           this.telefone = telefone;
    }*/

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca; 
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }
    
    
    
    @Override
    public String toString() {
        return "Nome do Paciente: " + nome + "\nCodigo do Paciente: " + idPaciente + "\nTelefone: " + tel1 + "\nSexo: " 
                + genero + "\nEndereco: " + endereco + "\nNumero de BI: " + bi+"\n"+doenca.toString()+
                "\nEstado de Paciente: "+estado; 
    } 

    

    

   
    
}
