/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadegestao.servidorOperacoes.server;

import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import sistemadegestao.servidorInterface.Output;
import sistemadegestao.servidorOperacoes.Cirurgia;
import sistemadegestao.servidorOperacoes.Consulta;
import sistemadegestao.servidorOperacoes.Dados;
import sistemadegestao.servidorOperacoes.Enfermeiro;
import sistemadegestao.servidorOperacoes.Funcionario;
import sistemadegestao.servidorOperacoes.Medico;
import sistemadegestao.servidorOperacoes.Paciente;
import sistemadegestao.servidorOperacoes.Registo;
import sistemadegestao.servidorOperacoes.services.DadosHelper;
import sistemadegestao.servidorOperacoes.services.ImprimirDadosHelper;
import sistemadegestao.servidorOperacoes.services.ImprimirDadosPOA;
import sistemadegestao.servidorValidacao.Validacao;
// sistemadegestao.servidorOperacoes.services.L

/**
 *
 * @author HP
 */
public class ClinicaImpressoes extends ImprimirDadosPOA{
    Validacao validar = new Validacao();
    ClinicaOperacoes cOp;
    Vector dados;
    private ORB orb;
    Output output = new Output();

    
    public void setOrb(ORB orb) {
            this.orb = orb;
    }
    
    public Vector<Object> convertToVector(Any[] corbaLista){
        Vector<Object> vector = new Vector<>();
         if (corbaLista != null) {
            for (Any any : corbaLista) {
                Object obj = any.extract_Object();
                vector.add(obj);
            }
        }
        return vector;
    }
    
    
//    public static Any[] vectorToCorbaLista(Vector<Object> vector) {
//        Any[] corbaLista = null;
//        for (Object obj : vector) {
//            Any any = ORB.init().create_any();
//            any.insert_Object((org.omg.CORBA.Object) obj);
//            corbaLista.add(any);
//        }
//        return corbaLista;
//    }
    
    @Override
    public void getConsultas(Any[] lista) {
        dados = convertToVector(lista);
        Registo r; Consulta c; 
        int i, j = 0; String cons[][] = new String [100][7];
        try {
            output.mensagem("Pacientes Com Consultas");
        } catch (IOException ex) {
            Logger.getLogger(ClinicaImpressoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(i = 0; i < dados.size(); i++)
            if(dados.elementAt(i) instanceof Registo){
                r = (Registo) dados.elementAt(i);
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
    }
    
    @Override
    public void getCirurgias(Any[] lista) {
        dados = convertToVector(lista);
        Registo r; Cirurgia c; 
        int j = 0, i; String cir [][] = new String[100][7];
        try{
            output.mensagem("Pacientes Com Cirurgias");
            for( i = 0; i < dados.size(); i++)
                if(dados.elementAt(i) instanceof Registo){
                    r = (Registo) dados.elementAt(i);
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
            output.mensagem(String.format("|%-20s|", "Codigo de Cirurgia") +String.format("%-15s|", "Data")+String.format("%-10s|", "Hora")+
                    String.format("%-30s|", "Nome De Paciente")+String.format("%-20s|", "Codigo De Paciente")+String.format("%-30s|", "Nome De Medico")
                    +String.format("%-20s|", "Estado"));
            for (i = 0; i < j; i++){
                    output.mensagem(String.format("|%-20s|", cir[i][0]));
                    output.mensagem(String.format("%-15s|", cir[i][1]));
                    output.mensagem(String.format("%-10s|", cir[i][2]));
                    output.mensagem(String.format("%-30s|", cir[i][3]));
                    output.mensagem(String.format("%-20s|", cir[i][4]));
                    output.mensagem(String.format("%-30s|", cir[i][5]));
                    output.mensagem(String.format("%-20s|", cir[i][6])+"\n");
            }   
            output.mensagem("Total De Pacientes Com Cirurgias: "+j);
        } catch (IOException ex) {
            Logger.getLogger(ClinicaImpressoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getPacientes(Any[] lista) {
        dados = convertToVector(lista);
        Paciente p;   int j = 0; String pac[][] = new String [100][9];
        try{
            output.mensagem("Pacientes Registados");
            for(int i = 0; i < dados.size(); i++){
                if(dados.elementAt(i) instanceof Paciente){
                    p = (Paciente) dados.elementAt(i);
                            pac[j][0] = p.getNome();
                            pac[j][1] = Integer.toString(p.getIdPaciente());
                            pac[j][2] = Integer.toString(p.getIdade());
                            pac[j][3] = Character.toString(p.getSexo());
                            pac[j][4] = p.getBI();
                            pac[j][5] = p.getEndereco();
                            pac[j][6] = p.getTelefone();
                            pac[j][7] = p.getEstado();
                            pac[j][8] = (p.getDoenca()).getNome();
                            j++;
                }    
            }
            output.mensagem(String.format("|%-30s|", "Nome") +String.format("%-20s|", "Codigo de Paciente")+String.format("%-6s|", "Idade")+String.format("%-5s|", "Sexo")+
                    String.format("%-30s|", "Numero de Identidade")+String.format("%-30s|", "Endereco")+String.format("%-30s|", "Telefone")
                    +String.format("%-20s|", "Estado")+String.format("%-30s|", "Doenca"));
            for (int i = 0; i < j; i++){{
                    output.mensagem(String.format("|%-30s|", pac[i][0]));
                    output.mensagem(String.format("%-20s|", pac[i][1]));
                    output.mensagem(String.format("%-6s|", pac[i][2]));
                    output.mensagem(String.format("%-5s|", pac[i][3]));
                    output.mensagem(String.format("%-30s|", pac[i][4]));
                    output.mensagem(String.format("%-30s|", pac[i][5]));
                    output.mensagem(String.format("%-30s|", pac[i][6]));
                    output.mensagem(String.format("%-20s|", pac[i][7]));
                    output.mensagem(String.format("%-30s|", pac[i][8])+"\n");
                }
            }
            output.mensagem("Total De Pacientes Nos Registos da Clinica: "+j);
        }catch (IOException ex) {
            Logger.getLogger(ClinicaImpressoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getMedicosConsulta(String tipo, Any[] lista) {
        dados = convertToVector(lista);
        try{
            Registo r;  String t = "-----------------------------------------------";
        if (tipo.equalsIgnoreCase("consulta")){
            Consulta c;
            for(int i = 0; i < dados.size(); i++){
                if(dados.elementAt(i) instanceof Registo){
                    r = (Registo) dados.elementAt(i);
                    if (r instanceof Consulta){
                            c = (Consulta) r;
                            t += "\n"+c.getMedico()+"\n"; }  
                }}}
        else{
            Cirurgia c;
            for(int i = 0; i < dados.size(); i++){
                if(dados.elementAt(i) instanceof Registo){
                    r = (Registo) dados.elementAt(i);
                    if (r instanceof Cirurgia){
                            c = (Cirurgia) r;
                            t += "\n"+c.getMedico(); } 
                }}}
     output.mensagem("Total De Medicos Com "+tipo+":\n"+t);   
        }catch (IOException ex) {
           Logger.getLogger(ClinicaImpressoes.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
    @Override
    public void getMedicos(Any[] lista) {
        dados = convertToVector(lista);
       try{
           Medico m; Funcionario f; String t = "Medicos da Clinica";
        String med[][] = new String[100][3]; int j = 0;
        for(int i = 0; i < dados.size(); i++){
            if(dados.elementAt(i) instanceof Funcionario){
                f = (Funcionario) dados.elementAt(i);
                if (f instanceof Medico){
                        m = (Medico) f;
                        med[j][0] = m.getFuncionario();
                        med[j][1] = Integer.toString(m.getIdFuncionario());
                        med[j][2] = m.getEspecialidade();
                        j++;
                }
            }
        }
        output.mensagem(t);
        output.mensagem(String.format("|%-30s|", "Nome") +String.format("%-10s|", "Codigo")+String.format("%-30s|", "Especialidade"));
        for (int i = 0; i < j; i++){{
                output.mensagem(String.format("|%-30s|", med[i][0]));
                output.mensagem(String.format("%-10s|", med[i][1]));
                output.mensagem(String.format("%-30s|", med[i][2])+"\n");
            }
        }
        
        output.mensagem("Total De Medicos Na Clinica:  "+j);
        }catch (IOException ex) {
           Logger.getLogger(ClinicaImpressoes.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }

    @Override
    public void VerAgendaMedico(Any[] lista) {
        dados = convertToVector(lista);
       try{
            String nome, dtHoras = " "; Funcionario f; Medico m;
        String agenda[][];
        boolean ex = false;
        nome = validar.validarString(3, 30,"Digite o nome do medico do qual deseja ver a agenda. ");
        for(int i=0;i<dados.size();i++){
            if(dados.elementAt(i) instanceof Funcionario){
                f = (Funcionario)dados.elementAt(i);
                    if(f instanceof Medico){
                        m = (Medico) f;
                        if(m.getFuncionario().equalsIgnoreCase(nome)){
                            agenda= m.getAgenda();
                            dtHoras = imprimeAgenda(agenda);
                            ex = true;
                        }
                 }
            }
        }
        
            if(ex == true){
                output.mensagem("Agenda do Medico(a) "+nome+" :\n\n"+dtHoras);
            }else{
                output.mensagem("Medico Nao Encontrado. ");
            }
        }catch (IOException ex) {
           Logger.getLogger(ClinicaImpressoes.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }

     public String imprimeAgenda(String vect[][]){
         //dados = convertToVector(lista);
        String t = "";
        t+=(String.format("|%-30s|", "Data") +String.format("%-100s|", "Horas"));
        for(int i = 0; i < vect.length; i++){
            t+= "\n"+(String.format("|%-30s|", vect[i][0]));
            for(int j = 0; j < vect[0].length; j++){
                if(j > 0 && vect[i][j].isEmpty() == false){
                     t += (String.format("%-10s|", vect[i][j])); 
                }
            }
        }
        return t;
    }
    
    @Override
    public void getEnfComPac(Any[] lista) {
        dados = convertToVector(lista);
       try{
           Funcionario f; Enfermeiro e; String t = "--------------------------------------------------";
        int c = 0; boolean ex = false;
        for(int i = 0; i < dados.size(); i++){
            if(dados.elementAt(i) instanceof Funcionario){
                f = (Funcionario) dados.elementAt(i);
                if (f instanceof Enfermeiro){
                    e = (Enfermeiro) f;
                    String[] pacientes = e.getCuidados();
                    for(i = 0;i < pacientes.length; i++){
                        if(pacientes[i].isEmpty() == false){
                            c++;
                            ex = true;}
                    }    
                    if(c > 0)
                        t += "\n\t-"+e.getFuncionario();   
            }}
        } 
        if(ex == false){
            output.mensagem("Nao Existe Nenhum Enfermeiro(a) Com Pacientes Por Cuidar. ");
        } else
            output.mensagem("Total De Enfermeiros Com Pacientes:\n"+t);
        }catch (IOException ex) {
           Logger.getLogger(ClinicaImpressoes.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public void getEnfermeiros(Any[] lista) {
        dados = convertToVector(lista);
        try{
            Funcionario f; Enfermeiro e; String t = "Enfermeiros Na Clinica";
          byte count = 0; String enf [][]= new String [100][3]; int j=0;
        for(int i = 0; i < dados.size(); i++){
            if(dados.elementAt(i) instanceof Funcionario){
                f = (Funcionario) dados.elementAt(i);
                if (f instanceof Enfermeiro){
                    e = (Enfermeiro) f;
                        enf[j][0] = e.getFuncionario();
                        enf[j][1] = Integer.toString(e.getIdFuncionario());
                        enf[j][2] = e.getCategoria();
                        j++;
                }
            }
        }
        output.mensagem(t);
        output.mensagem(String.format("|%-30s|", "Nome") +String.format("%-10s|", "Codigo")+String.format("%-30s|", "Categoria"));
        for (int i = 0; i < j; i++){{
                output.mensagem(String.format("|%-30s|", enf[i][0]));
                output.mensagem(String.format("%-10s|", enf[i][1]));
                output.mensagem(String.format("%-30s|", enf[i][2])+"\n");
            }
        }
        output.mensagem("Total De Enfermeiros Na Clinica: "+count);
        }catch (IOException ex) {
           Logger.getLogger(ClinicaImpressoes.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public void verPacEnf(Any[] lista) {
        dados = convertToVector(lista);
        try{
             String nome, p[], pacientes = null; boolean enf = false; int id, c = 0;
        Funcionario f; Enfermeiro e;
        nome = validar.validarString(3, 50, "Introduza o Nome do Enfermeiro do Qual Deseja Ver os Pacientes "
                + "Em Seus Cuidados:");
        for(int i=0; i<dados.size(); i++){
            if(dados.elementAt(i) instanceof Funcionario){
                f = (Funcionario)dados.elementAt(i);
                if(f instanceof Enfermeiro){
                    e = (Enfermeiro) f;
                    if(e.getFuncionario().equalsIgnoreCase(nome)){
                        System.out.println(e.getFuncionario() +" - Codigo de Funcionario: " +e.getIdFuncionario());
                        enf = true;}}}}
        if (enf == true){
            id = validar.validarInt(100, 999, "Introduza o Codigo de Funcionario:");
            for(int i=0; i < dados.size(); i++){
            if(dados.elementAt(i) instanceof Funcionario){
                f = (Funcionario)dados.elementAt(i);
                if(f instanceof Enfermeiro){
                    e = (Enfermeiro) f;
                    if(e.getFuncionario().equalsIgnoreCase(nome) && id == e.getIdFuncionario()){
                        p = e.getCuidados();
                        pacientes = imprimeCuidados(p);
                        for(int k = 0; k < p.length; k++)
                            if (p[k].isEmpty() == false)
                                c++;
                    }
                }
            }   
        }
        if(enf == false)
            output.mensagem("\nEnfermeiro Nao Encontrado.");
        else{ 
            if(c == 0)
                output.mensagem("O(a) Enfermeiro(a) "+nome+" Actualmente Nao Possui Pacientes Em Cuidados.");
            else
                output.mensagem("Pacientes Cuidados Por "+nome+":\n"+pacientes);
        } 
        }    
        }catch (IOException ex) {
           Logger.getLogger(ClinicaImpressoes.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
     public String imprimeCuidados(String pa[]){
        String imp ="";
        for(int j = 0; j<pa.length; j++){
            if(pa[j].isEmpty() == false){
                imp += "- "+pa[j]+"\n";
            }   
        }
        return imp;
    }    
    
    public void agenda() throws IOException{
        VerAgendaMedico(cOp.getdados());
    }
    
    public void getPacientes() throws IOException{
        getPacientes(cOp.getdados());
    }
    public void ImprimirCons() throws IOException{
        getConsultas(cOp.getdados());
    }
    
    public void ImprimirCir() throws IOException{
        getCirurgias(cOp.getdados());
    }
     
    public void ImprimirMedico(String tipo) throws IOException{
        getMedicosConsulta(tipo, cOp.getdados());
    }
    
     public void ImprimirEnf() throws IOException{
         getEnfermeiros(cOp.getdados());
    }
    
     public void EnfComPacientes() throws IOException{
         getEnfComPac(cOp.getdados());
     }
     
    public void ImprimirAllMed() throws IOException{
        getMedicos(cOp.getdados());
    }
    
    public void verPacientesEnf()throws IOException{
       verPacEnf(cOp.getdados());
   } 
    
    public static void main(String[] args) {
        try {
             String[] argv = { "-ORBInitialPort", "900", "-ORBInitialHost", "127.0.0.1" };
            ORB orb = ORB.init(argv, null);

            // Obtém referência a rootpoa (Portable Object Adapter) e ativa o Gerenciador POA
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Cria o serviço e registra ele com o ORB (Object Request Broker)
           ClinicaImpressoes ServidorImp = new ClinicaImpressoes();
           //ServidorOp .setOrb(orb);

            // obtém a referência do serviço a ser disponibilizado pelo servidor
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(ServidorImp);
            sistemadegestao.servidorOperacoes.services.ImprimirDados href = ImprimirDadosHelper.narrow(ref);

            // Obtém a referência para o serviço de nomes
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // vincula a referencia do objeto a um nome, no servidor de nomes
            String objNome = "ImpServer";
            NameComponent path[] = ncRef.to_name(objNome);
            ncRef.rebind(path, href);
            //ncRef.rebind(path, ref);

            System.out.println("Servidor de impressoes pronto e aguardando ...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
