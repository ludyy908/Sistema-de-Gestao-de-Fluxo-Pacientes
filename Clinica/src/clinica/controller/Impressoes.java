
package clinica.controller;
import java.io.*;
import java.util.Vector;
import clinica.model.*;
        
public class Impressoes {
     Validacao validar = new Validacao();
     
     
     
     public void getConsultas(Vector lista) {
        Registo r; Consulta c; 
        int i, j = 0; String cons[][] = new String [100][7];
        System.out.println("Pacientes Com Consultas");
        for(i = 0; i < lista.size(); i++)
            if(lista.elementAt(i) instanceof Registo){
                r = (Registo) lista.elementAt(i);
                if (r instanceof Consulta){
                        c = (Consulta) r;
                        if (c.getEstado().equalsIgnoreCase("Cancelada") == false){
                        cons[j][0] = Integer.toString(c.getNrConsulta());
                        cons[j][1] = c.getData();
                        cons[j][2] = c.getHora();
                        cons[j][3] = c.getPaciente();
                        cons[j][4] = Integer.toString(c.getidPaciente());
                        cons[j][5] = c.getMedico();
                        cons[j][6] = c.getEstado();
                        j++; }
                }    
            }
        System.out.println(String.format("|%-20s|", "Codigo de Consulta") +String.format("%-15s|", "Data")+String.format("%-10s|", "Hora")+
                String.format("%-30s|", "Nome De Paciente")+String.format("%-20s|", "Codigo De Paciente")+String.format("%-30s|", "Nome De Medico")
                +String.format("%-20s|", "Estado"));
        for (i = 0; i < j; i++){
                System.out.print(String.format("|%-20s|", cons[i][0]));
                System.out.print(String.format("%-15s|", cons[i][1]));
                System.out.print(String.format("%-10s|", cons[i][2]));
                System.out.print(String.format("%-30s|", cons[i][3]));
                System.out.print(String.format("%-20s|", cons[i][4]));
                System.out.print(String.format("%-30s|", cons[i][5]));
                System.out.print(String.format("%-20s|", cons[i][6])+"\n");
        }   
        System.out.println(" Total De Pacientes com cirurga marcada: "+j);
        
   }

    public void getCirurgias(Vector lista) {
        Registo r; Cirurgia c; 
        int j = 0, i; String cir [][] = new String[100][7];
        System.out.println("Pacientes Com Cirurgias");
        for( i = 0; i < lista.size(); i++)
            if(lista.elementAt(i) instanceof Registo){
                r = (Registo) lista.elementAt(i);
                if (r instanceof Cirurgia){
                    c = (Cirurgia) r;
                    if (c.getEstado().equalsIgnoreCase("Cancelada") == false){
                        cir[j][0] = Integer.toString(c.getNrCirurgia());
                        cir[j][1] = c.getData();
                        cir[j][2] = c.getHora();
                        cir[j][3] = c.getPaciente();
                        cir[j][4] = Integer.toString(c.getidPaciente());
                        cir[j][5] = c.getMedico();
                        cir[j][6] = c.getEstado();
                        j++; }
                }    
            }
        System.out.println(String.format("|%-20s|", "Codigo de Cirurgia") +String.format("%-15s|", "Data")+String.format("%-10s|", "Hora")+
                String.format("%-30s|", "Nome De Paciente")+String.format("%-20s|", "Codigo De Paciente")+String.format("%-30s|", "Nome De Medico")
                +String.format("%-20s|", "Estado"));
        for (i = 0; i < j; i++){
                System.out.print(String.format("|%-20s|", cir[i][0]));
                System.out.print(String.format("%-15s|", cir[i][1]));
                System.out.print(String.format("%-10s|", cir[i][2]));
                System.out.print(String.format("%-30s|", cir[i][3]));
                System.out.print(String.format("%-20s|", cir[i][4]));
                System.out.print(String.format("%-30s|", cir[i][5]));
                System.out.print(String.format("%-20s|", cir[i][6])+"\n");
        }   
        System.out.print("Total De Pacientes Com Cirurgias: "+j);
    }

     public void Pacientes(Vector lista) {
        Paciente p;   int j = 0; String pac[][] = new String [100][9];
        System.out.println("Pacientes Registados");
        for(int i = 0; i < lista.size(); i++){
            if(lista.elementAt(i) instanceof Paciente){
                p = (Paciente) lista.elementAt(i);
                        pac[j][0] = p.getNome();
                        pac[j][1] = Integer.toString(p.getIdPaciente());
                        pac[j][2] = Integer.toString(p.getIdade());
                       // pac[j][3] = Character.toString(p.getSexo());
                        pac[j][4] = p.getBI();
                        pac[j][5] = p.getEndereco();
                        pac[j][6] = p.getTel1();
                        pac[j][7] = p.getEstado();
                        pac[j][8] = (p.getDoenca()).getNome();
                        j++;
            }    
        }
        System.out.println(String.format("|%-30s|", "Nome") +String.format("%-20s|", "Codigo de Paciente")+String.format("%-6s|", "Idade")+String.format("%-5s|", "Sexo")+
                String.format("%-30s|", "Numero de Identidade")+String.format("%-30s|", "Endereco")+String.format("%-30s|", "Telefone")
                +String.format("%-20s|", "Estado")+String.format("%-30s|", "Doenca"));
        for (int i = 0; i < j; i++){{
                System.out.print(String.format("|%-30s|", pac[i][0]));
                System.out.print(String.format("%-20s|", pac[i][1]));
                System.out.print(String.format("%-6s|", pac[i][2]));
                System.out.print(String.format("%-5s|", pac[i][3]));
                System.out.print(String.format("%-30s|", pac[i][4]));
                System.out.print(String.format("%-30s|", pac[i][5]));
                System.out.print(String.format("%-30s|", pac[i][6]));
                System.out.println(String.format("%-20s|", pac[i][7]));
                System.out.println(String.format("%-30s|", pac[i][8])+"\n");
            }
        }
        System.out.print("Total De Pacientes Nos Registos da Clinica: "+j);
    }
     

    public  void getMedicos(String tipo, Vector lista) {
        Registo r;  String t = "-----------------------------------------------";
        if (tipo.equalsIgnoreCase("consulta")){
            Consulta c;
            for(int i = 0; i < lista.size(); i++){
                if(lista.elementAt(i) instanceof Registo){
                    r = (Registo) lista.elementAt(i);
                    if (r instanceof Consulta){
                            c = (Consulta) r;
                            t += "\n"+c.getMedico()+"\n"; }  
                }}}
        else{
            Cirurgia c;
            for(int i = 0; i < lista.size(); i++){
                if(lista.elementAt(i) instanceof Registo){
                    r = (Registo) lista.elementAt(i);
                    if (r instanceof Cirurgia){
                            c = (Cirurgia) r;
                            t += "\n"+c.getMedico(); } 
                }}}
     System.out.print("Total De Medicos Com "+tipo+":\n"+t);   
    }

    public void getMedicos(Vector lista) {
        Medico m; Funcionario f; String t = "Medicos da Clinica";
        String med[][] = new String[100][3]; int j = 0;
        for(int i = 0; i < lista.size(); i++){
            if(lista.elementAt(i) instanceof Funcionario){
                f = (Funcionario) lista.elementAt(i);
                if (f instanceof Medico){
                        m = (Medico) f;
                        med[j][0] = m.getNomeFunc();
                        med[j][1] = Integer.toString(m.getIdFuncionario());
                        med[j][2] = m.getEspecialidade();
                        j++;
                }
            }
        }
        System.out.println(t);
        System.out.println(String.format("|%-30s|", "Nome") +String.format("%-10s|", "Codigo")+String.format("%-30s|", "Especialidade"));
        for (int i = 0; i < j; i++){{
                System.out.print(String.format("|%-30s|", med[i][0]));
                System.out.print(String.format("%-10s|", med[i][1]));
                System.out.println(String.format("%-30s|", med[i][2])+"\n");
            }
        }
        
        System.out.print("Total De Medicos Na Clinica:  "+j);
    }

    public void VerAgendaMedico(Vector lista) throws IOException{
        
        String nome, dtHoras = " "; Funcionario f; Medico m;
        String agenda[][];
        boolean ex = false;
        nome = validar.validarString(3, 30,"Digite o nome do medico do qual deseja ver a agenda. ");
        for(int i=0;i<lista.size();i++){
            if(lista.elementAt(i) instanceof Funcionario){
                f = (Funcionario)lista.elementAt(i);
                    if(f instanceof Medico){
                        m = (Medico) f;
                        if(m.getNomeFunc().equalsIgnoreCase(nome)){
                            agenda= m.getAgenda();
                            dtHoras = imprimeAgenda(agenda);
                            ex = true;
                        }
                 }
            }
        }
        
            if(ex == true){
                System.out.println("Agenda do Medico(a) "+nome+" :\n\n"+dtHoras);
            }else{
                System.out.println("Medico Nao Encontrado. ");
            }
            
    }
    
    public String imprimeAgenda(String vect[][]){
        String t = "";
        t+=(String.format("|%-30s|", "Data") +String.format("%-100s|", "Horas"));
        for(int i = 0; i < vect.length; i++){
            t+= "\n"+(String.format("|%-30s|", vect[i][0]));
            for(int j = 0; j < vect[0].length; j++){
                if(j > 0 && vect[i][j].isBlank() == false){
                     t += (String.format("%-10s|", vect[i][j])); 
                }
            }
        }
        return t;
    }
    
    public void getEnfComPac(Vector lista) {
        Funcionario f; Enfermeiro e; String t = "--------------------------------------------------";
        int c = 0; boolean ex = false;
        for(int i = 0; i < lista.size(); i++){
            if(lista.elementAt(i) instanceof Funcionario){
                f = (Funcionario) lista.elementAt(i);
                if (f instanceof Enfermeiro){
                    e = (Enfermeiro) f;
                    String[] pacientes = e.getCuidados();
                    for(i = 0;i < pacientes.length; i++){
                        if(pacientes[i].isBlank()== false){
                            c++;
                            ex = true;}
                    }    
                    if(c > 0)
                        t += "\n\t-"+e.getNomeFunc();   
            }}
        } 
        if(ex == false){
            System.out.println("Nao Existe Nenhum Enfermeiro(a) Com Pacientes Por Cuidar. ");
        } else
            System.out.println("Total De Enfermeiros Com Pacientes:\n"+t);
    } 

    public void getEnfermeiros(Vector lista) {
        Funcionario f; Enfermeiro e; String t = "Enfermeiros Na Clinica";
          byte count = 0; String enf [][]= new String [100][3]; int j=0;
        for(int i = 0; i < lista.size(); i++){
            if(lista.elementAt(i) instanceof Funcionario){
                f = (Funcionario) lista.elementAt(i);
                if (f instanceof Enfermeiro){
                    e = (Enfermeiro) f;
                        enf[j][0] = e.getNomeFunc();
                        enf[j][1] = Integer.toString(e.getIdFuncionario());
                        enf[j][2] = e.getCategoria();
                        j++;
                }
            }
        }
        System.out.println(t);
        System.out.println(String.format("|%-30s|", "Nome") +String.format("%-10s|", "Codigo")+String.format("%-30s|", "Categoria"));
        for (int i = 0; i < j; i++){{
                System.out.print(String.format("|%-30s|", enf[i][0]));
                System.out.print(String.format("%-10s|", enf[i][1]));
                System.out.println(String.format("%-30s|", enf[i][2])+"\n");
            }
        }
        System.out.print("Total De Enfermeiros Na Clinica: "+count);
    }
    
    
    
    public void verPacEnf(Vector lista) throws IOException{
        String nome, p[], pacientes = null; boolean enf = false; int id, c = 0;
        Funcionario f; Enfermeiro e;
        nome = validar.validarString(3, 50, "Introduza o Nome do Enfermeiro do Qual Deseja Ver os Pacientes "
                + "Em Seus Cuidados:");
        for(int i=0; i<lista.size(); i++){
            if(lista.elementAt(i) instanceof Funcionario){
                f = (Funcionario)lista.elementAt(i);
                if(f instanceof Enfermeiro){
                    e = (Enfermeiro) f;
                    if(e.getNomeFunc().equalsIgnoreCase(nome)){
                        System.out.println(e.getNomeFunc() +" - Codigo de Funcionario: " +e.getIdFuncionario());
                        enf = true;}}}}
        if (enf == true){
//            id = validar.validarInt(100, 999, "Introduza o Codigo de Funcionario:");
            for(int i=0; i < lista.size(); i++){
            if(lista.elementAt(i) instanceof Funcionario){
                f = (Funcionario)lista.elementAt(i);
                if(f instanceof Enfermeiro){
                    e = (Enfermeiro) f;
       //             if(e.getNomeFunc().equalsIgnoreCase(nome) && id == e.getIdFuncionario()){
                        p = e.getCuidados();
         //               pacientes = imprimeCuidados(p);
                        for(int k = 0; k < p.length; k++)
                            if (p[k].isBlank() == false)
                                c++;
                    }
                }
            }   
        }
        if(enf == false)
            System.out.println("\nEnfermeiro Nao Encontrado.");
        else{ 
            if(c == 0)
                System.out.println("O(a) Enfermeiro(a) "+nome+" Actualmente Nao Possui Pacientes Em Cuidados.");
            else
                System.out.print("Pacientes Cuidados Por "+nome+":\n"+pacientes);
        } 
        }    
    }
        
   /* public String imprimeCuidados(String pa[]){
        String imp ="";
        for(int j = 0; j<pa.length; j++){
            if(pa[j].isBlank() == false){
                imp += "- "+pa[j]+"\n";
            }   
        }
        return imp;
    }   
    
    
}*/
