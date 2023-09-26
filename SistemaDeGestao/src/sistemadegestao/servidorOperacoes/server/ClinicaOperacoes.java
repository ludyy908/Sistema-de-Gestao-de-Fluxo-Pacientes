/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadegestao.servidorOperacoes.server;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.Any;
import org.omg.CORBA.AnySeqHolder;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import sistemadegestao.servidorInterface.Output;
import sistemadegestao.servidorOperacoes.Cirurgia;
import sistemadegestao.servidorOperacoes.Consulta;
import sistemadegestao.servidorOperacoes.Doenca;
import sistemadegestao.servidorOperacoes.Enfermeiro;
import sistemadegestao.servidorOperacoes.Funcionario;
import sistemadegestao.servidorOperacoes.Medico;
import sistemadegestao.servidorOperacoes.Paciente;
import sistemadegestao.servidorOperacoes.Registo;
import sistemadegestao.servidorOperacoes.VerificarDataHora;
import sistemadegestao.servidorOperacoes.services.Dados;
import sistemadegestao.servidorOperacoes.services.DadosHelper;
import sistemadegestao.servidorOperacoes.services.DadosPOA;
import sistemadegestao.servidorOperacoes.services.ListaHolder;
import sistemadegestao.servidorValidacao.Validacao;


/**
 *
 * @author HP
 */
public class ClinicaOperacoes extends DadosPOA {
    
    Vector lista = new Vector();
    Funcionario func = new Funcionario();
    Paciente pac;
    Doenca d  = new Doenca();
    VerificarDataHora vdh = new VerificarDataHora();
    Validacao validar = new Validacao();
    Output output = new Output();
    private ORB orb;
       
    
    public void setOrb(ORB orb) {
            this.orb = orb;
    }
    
    @Override
    public void agendarCirurgia(){
        Consulta cons = new Consulta(); Paciente p; int c1 = 0, c2 = 0; // c1 e c2 sao contadores. 
        String nome;
        try {
            nome = verificarExistenciaMedico("Nome do medico que realizara a consulta:  "); //Ao agendar a consulta, o paciente diz com que medico deseja ter a conulta e se verica a sua existencia
            if(nome.isEmpty() == false){ // se nome for vazio ou em branco vai cancelar a operacao
            cons.setMedico(nome);
            String data = vdh.verificarData(nome,lista); // verificar data na agenda do medico. Se o dia esta todo ocupado ou nao
            if(data.isEmpty()  == false){ // se for vazio vai cancelar
                String hora = vdh.verificarHora(nome, data,lista);//verificar a hora na agenda do medico em funcao da data. Se 
                if (hora.isEmpty() == false){  // se for vazio vai cancelar. se tudo for aprovado, vai meter nos dados da consulta.
                    cons.setData(data); 
                    cons.setHora(hora);
                    cons.setNrConsulta(Id("c"));
                    cons.setEstado("Activa");
                    nome = (validar.validarString(3, 30, "Introduza o Nome do Paciente:"));
                    for(int i = 0; i < lista.size(); i++){
                        if(lista.elementAt(i) instanceof Paciente){
                            c1++; 
                            p = (Paciente)lista.elementAt(i);
                            if(p.getNome().equalsIgnoreCase(nome)){
                                cons.setPaciente(p.getNome());
                                cons.setIdPaciente(p.getIdPaciente());
                                output.mensagem("Paciente Ja Registado no Sistema da Clinica.\nConsulta Registada."); 
                                lista.addElement(cons); lista.trimToSize();  }
                            else c2++;}} 
                    if(c2 == c1){ 
                        registarPaciente();
                        cons.setPaciente(pac.getNome());
                        cons.setIdPaciente(pac.getIdPaciente());
                        d.setNome("Doenca Nao Diagnosticada");
                        d.setContagio("Doenca Nao Diagnosticada");
                        d.setId_Doenca(000);
                        pac.setDoenca(d);
                        pac.setEstado("Nao Internado");
                        lista.addElement(pac); lista.addElement(cons); lista.trimToSize();
                        output.mensagem("Consulta Registada\nCodigo de Consulta: " + cons.getNrConsulta());  }}
                
            }
        }
        } catch (IOException ex) {
            Logger.getLogger(ClinicaOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String verificarExistenciaMedico(String n) throws IOException {
        boolean existencia = false; byte opcao; String nome; Funcionario f; Medico m; 
        int c1 = 0, c2 = 0; 
        do{
            nome = validar.validarString(3, 30, n);
            for (int i = 0; i < lista.size(); i++)
                if(lista.elementAt(i) instanceof Funcionario){
                    f = (Funcionario) lista.elementAt(i);
                    if (f instanceof Medico){
                        c1++; 
                        m = (Medico) f;
                        if (m.getFuncionario().equalsIgnoreCase(nome))
                            existencia = true;
                        else
                            c2++; }} 
            if (c2 == c1) {       
                opcao = validar.validarByte((byte)0, (byte)1,"Medico Nao Existente."+
                                                              "\n1. Introduzir Nome de Medico Novamente"+
                                                              "\n0. Cancelar Procedimento");
                if (opcao == 0)
                    return "";  } 
        }while(existencia == false);
        return nome;  
    }

    public String verificarEnfermeiro() throws IOException{
        boolean exis = false; byte op = 0; Funcionario f; Enfermeiro e;
        String nomeEnf;
        do{
            nomeEnf = validar.validarString(3, 30, "Nome do enfermeiro que cuidara do paciente a ser internado");
            for(byte i=0;i<lista.size();i++){
                if(lista.elementAt(i) instanceof Funcionario){
                    f = (Funcionario) lista.elementAt(i);
                   if(f instanceof Enfermeiro){
                       e = (Enfermeiro) f;
                       if(e.getFuncionario().equalsIgnoreCase(nomeEnf)){
                           exis = true;
                       }
                    }  
                }   
            }
            if(exis == false ){
                output.mensagem("Enfermeiro Nao Encontrado.");
                op = validar.validarByte((byte)0,(byte)1, "\t1. Introduzir o nome do enfermeiro novamente\n\t0. Cancelar operacao");
                if(op == 0)
                    return "";
            }
        }while(op == 1 && exis == false);
        
       return nomeEnf; 
    }
    
    @Override
    public void agendarConsulta() {
        Consulta cons = new Consulta(); Paciente p; int c1 = 0, c2 = 0; // c1 e c2 sao contadores. 
        try{
            String nome = verificarExistenciaMedico("Nome do medico que realizara a consulta:  "); //Ao agendar a consulta, o paciente diz com que medico deseja ter a conulta e se verica a sua existencia
            if(nome.isEmpty() == false){ // se nome for vazio ou em branco vai cancelar a operacao
                cons.setMedico(nome);
                String data = vdh.verificarData(nome,lista); // verificar data na agenda do medico. Se o dia esta todo ocupado ou nao
                if(data.isEmpty()  == false){ // se for vazio vai cancelar
                    String hora = vdh.verificarHora(nome, data,lista);//verificar a hora na agenda do medico em funcao da data. Se 
                    if (hora.isEmpty() == false){  // se for vazio vai cancelar. se tudo for aprovado, vai meter nos dados da consulta.
                        cons.setData(data); 
                        cons.setHora(hora);
                        cons.setNrConsulta(Id("c"));
                        cons.setEstado("Activa");
                        nome = (validar.validarString(3, 30, "Introduza o Nome do Paciente:"));
                        for(int i = 0; i < lista.size(); i++){
                            if(lista.elementAt(i) instanceof Paciente){
                                c1++; 
                                p = (Paciente)lista.elementAt(i);
                                if(p.getNome().equalsIgnoreCase(nome)){
                                    cons.setPaciente(p.getNome());
                                    cons.setIdPaciente(p.getIdPaciente());
                                    output.mensagem("Paciente Ja Registado no Sistema da Clinica.\nConsulta Registada."); 
                                    lista.addElement(cons); lista.trimToSize();  }
                                else c2++;}} 
                        if(c2 == c1){ 
                            registarPaciente();
                            cons.setPaciente(pac.getNome());
                            cons.setIdPaciente(pac.getIdPaciente());
                            d.setNome("Doenca Nao Diagnosticada");
                            d.setContagio("Doenca Nao Diagnosticada");
                            d.setId_Doenca(000);
                            pac.setDoenca(d);
                            pac.setEstado("Nao Internado");
                            lista.addElement(pac); lista.addElement(cons); lista.trimToSize();
                            output.mensagem("Consulta Registada\nCodigo de Consulta: " + cons.getNrConsulta());  }}

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClinicaOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cancelar(String tipo) {
        Registo r; Funcionario f; Medico m; String cancel = " ";
        String data = "", hora = ""; boolean exN = false, exDH = false; byte op = 0;
        try{
           do{
            String nome = validar.validarString(3, 20, "Introduza o Nome Do Paciente Que Deseja Cancelar:"); 
            if (tipo.equalsIgnoreCase("consulta")){
                Consulta c;
                for(int i = 0; i < lista.size(); i++){
                    if(lista.elementAt(i) instanceof Registo){
                        r = (Registo) lista.elementAt(i);
                        if (r instanceof Consulta){
                            c = (Consulta) r;
                            if(c.getPaciente().equalsIgnoreCase(nome)){ 
                                exN = true;
                                data = validar.validarData(); hora = validar.validarHora(); //introduz- se a data e hora da consulta a cancelar. Porque um ppaciente pode ter uma ou mais consultas
                            if ((c.getData().equalsIgnoreCase(data)) && (c.getHora().equalsIgnoreCase(hora))){ //se corresponder, vai a agenda do medico, e procurar a da e hora para substituir por vazio e eliminar a consulta do vector
                                exDH = true;
                                for( int j = 0; j < lista.size(); j++){
                                    if(lista.elementAt(j) instanceof Funcionario){
                                        f = (Funcionario) lista.elementAt(j);
                                        if (f instanceof Medico){
                                            m = (Medico) f;
                                            String[][] agenda = m.getAgenda();
                                            for (int n = 0; n < agenda.length; n++){
                                                for (int k = 1; k < agenda[n].length; k++){
                                                    if(agenda[n][0].equalsIgnoreCase(data)){
                                                        if(agenda[n][k].equalsIgnoreCase(hora)){
                                                            agenda[n][k] = " ";
                                                            m.setAgenda(n,k," ");
                                                            c.setEstado("Cancelada");
                                                            lista.setElementAt(m , j);lista.trimToSize();
                                                            cancel = "Consulta Cancelada.";

                                                        }
                                                    }
                                                }}}}}}}}}}

            }
            else{
                Cirurgia ci;
                for( int i = 0; i < lista.size(); i++){
                    if(lista.elementAt(i) instanceof Registo){
                        r = (Registo) lista.elementAt(i);
                        if (r instanceof Cirurgia){
                            ci = (Cirurgia) r;
                            if(ci.getPaciente().equalsIgnoreCase(nome)){
                                exN = true;
                                data = validar.validarData(); hora = validar.validarHora();
                                 if ((ci.getData().equalsIgnoreCase(data)) && (ci.getHora().equalsIgnoreCase(hora))){
                                   exDH = true;
                                    for( int j = 0; j < lista.size(); j++){
                                       if(lista.elementAt(j) instanceof Funcionario){
                                           f = (Funcionario) lista.elementAt(j);
                                           if (f instanceof Medico){
                                               m = (Medico) f;
                                               String[][] agenda = m.getAgenda();
                                                   for (int k = 0; k < agenda.length; k++){
                                                          for (int n = 1; n < agenda[k].length; n++){
                                                               if(agenda[k][0].equalsIgnoreCase(data)){
                                                                   if(agenda[k][n].equalsIgnoreCase(hora)){
                                                                        agenda[k][n] = " ";
                                                                        m.setAgenda(n,k," ");
                                                                        ci.setEstado("Cancelada");
                                                                        lista.setElementAt(m,j); lista.trimToSize();
                                                                        output.mensagem("*0*Cirurgia Cancelada.");
                                                   }}}}}}}}}}}}}
            if(exDH == false || exN == false){
                output.mensagem("Dados Nao Encontrados.");
                op = validar.validarByte((byte)0,(byte)1, "\t1. Introduzir Nome Novamente\n0. Cancelar Procedimento.");
                } 
            }while(op == 1); 
            
        }catch (IOException ex) {
            Logger.getLogger(ClinicaOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void darAltaPaciente() {
        Paciente p; Funcionario f; byte op = 0; int c = 0;
        try{
            do{
        String nome = validar.validarString(3, 20, "Introduza o Nome Do Paciente Que Recebeu alta:"); 
        for(int i = 0; i < lista.size(); i++){
            if(lista.elementAt(i) instanceof Paciente){
                p = (Paciente)lista.elementAt(i);
                if (p.getNome().equalsIgnoreCase(nome)){ 
                    output.mensagem(p.getNome() + "- Codigo de Identificacao: "+p.getIdPaciente());
                    c++;
                }}}
        if(c == 1){
            for(int i = 0; i < lista.size(); i++)
            if(lista.elementAt(i) instanceof Paciente){
                p = (Paciente)lista.elementAt(i);
                if (p.getNome().equalsIgnoreCase(nome))
                    Alta(p, i);}}
        
        if(c>1){
            int id = validar.validarInt(100, 999, "Introduza o Codigo de Identificacao do Paciente:");
            for(int i = 0; i < lista.size(); i++)
            if(lista.elementAt(i) instanceof Paciente){
                p = (Paciente)lista.elementAt(i);
                if (p.getIdPaciente() == id)
                    Alta(p, i);
                     
                }}
        if(c==0){
            output.mensagem("Paciente Nao Encontrado.");
            op = validar.validarByte((byte)0,(byte)1, "\t1. Introduzir Nome Novamente\n0. Cancelar Procedimento.");
            }
        }while(op == 1 && c == 0);
        }catch (IOException ex) {
            Logger.getLogger(ClinicaOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void Alta(Paciente p, int i) throws IOException{
        Enfermeiro e; Funcionario f; String pacientes[];
        if(p.getEstado().equalsIgnoreCase("Internado"))
            for(int j = 0; j < lista.size(); j++)
                if(lista.elementAt(j) instanceof Funcionario){
                    f = (Funcionario) lista.elementAt(j);
                    if (f instanceof Enfermeiro){
                        e = (Enfermeiro) f;
                        pacientes = e.getCuidados();
                        for (int k = 0; k < pacientes.length;k++)
                            if(pacientes[k].equalsIgnoreCase(p.getNome())){
                                e.setCuidadosEnf(k, " "); 
                                p.setEstado("Recebeu Alta");
                                lista.setElementAt(p, i);
                                lista.setElementAt(e,j); lista.trimToSize();
                                output.mensagem("Paciente Registado com Alta"); }}}}
    
    
    @Override
    public void internarPaciente() {
        Paciente p; Enfermeiro e; Funcionario f; String pacientes[]; String enfermeiro = "";
        boolean exi = false; int id, c = 0; byte op = 0;
        try{
            String nome = validar.validarString(3, 20, "Introduza o Nome Do Paciente Que Ficou internado:");
        for(int i = 0; i < lista.size(); i++){
            if(lista.elementAt(i) instanceof Paciente){
                p = (Paciente)lista.elementAt(i);
                if (p.getNome().equalsIgnoreCase(nome))
                    c++;}}
         if(c == 1) {
            for(int i = 0; i < lista.size(); i++)
                if(lista.elementAt(i) instanceof Paciente){
                    pac = (Paciente)lista.elementAt(i);
                    if (pac.getNome().equalsIgnoreCase(nome))
                        Internamento(i); }}
         
        if(c > 1){
            id = validar.validarInt(100, 999, "Introduza o Codigo de Identificacao do Paciente:");
            for(int i = 0; i < lista.size(); i++){
                if(lista.elementAt(i) instanceof Paciente){
                    pac = (Paciente)lista.elementAt(i);
                    if (pac.getIdPaciente() == id)
                        Internamento(i);}}
        }   
        
        if (c == 0){
            registarPaciente();
            lista.addElement(pac); lista.trimToSize();
            Internamento(lista.size()-1);}
        }catch (IOException ex) {
            Logger.getLogger(ClinicaOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public int Id(String tipo){
        Random r = new Random(); boolean igual = false;
        int id = 0; 
        switch (tipo){
            case "p": Paciente p;
                do{
                    id = r.nextInt(999);
                    for (int i = 0; i < lista.size(); i++)
                        if(lista.elementAt(i) instanceof Paciente){
                            p = (Paciente) lista.elementAt(i);
                            if (id == p.getIdPaciente())
                                igual = true;}
                } while (igual == true);    
                     break;
            case "d": Doenca dc;
                do{
                    id = r.nextInt(999);
                    for (int i = 0; i < lista.size(); i++)
                        if(lista.elementAt(i) instanceof Doenca){
                            dc = (Doenca) lista.elementAt(i);
                            if (id == d.getIdDoenca())
                                igual = true;}
                } while (igual == true);break;
            case "f" :Funcionario f;
                do{
                    id = r.nextInt(999);
                    for (int i = 0; i < lista.size(); i++)
                        if(lista.elementAt(i) instanceof Funcionario){
                            f = (Funcionario) lista.elementAt(i);
                            if (id == f.getIdFuncionario())
                                igual = true;}
                } while (igual == true);
                 break;
            case "c" : Registo re; Consulta c;
                do{
                    id = r.nextInt(999);
                    for (int i = 0; i < lista.size(); i++)
                        if(lista.elementAt(i) instanceof Registo){
                            re = (Registo) lista.elementAt(i);
                                if(re instanceof Consulta){
                                   c = (Consulta) re; 
                                   if (id == c.getNrConsulta())
                                        igual = true;}}
                } while (igual == true); break;   
            case "cir": Registo reg; Cirurgia cir;
                do{
                    id = r.nextInt(999);
                    for (int i = 0; i < lista.size(); i++)
                        if(lista.elementAt(i) instanceof Registo){
                            reg = (Registo) lista.elementAt(i);
                                if(reg instanceof Cirurgia){
                                   cir = (Cirurgia) reg; 
                                   if (id == cir.getNrCirurgia())
                                        igual = true;}}
                } while (igual == true); break;
        } return id;
    }
   
    public void Internamento(int i) throws IOException{
        Enfermeiro e; Funcionario f;  String pacientes[]; String enfermeiro; 
        int c = 0; boolean exi = false;
        byte op = 0;
        String nome = (validar.validarString(3, 30, "Nome da doenca que o paciente possui: "));
                    for (int l = 0; l < lista.size(); l++){
                        if (lista.elementAt(l) instanceof Doenca){
                            d = (Doenca) lista.elementAt(l);
                            if(nome.equalsIgnoreCase(d.getNome()))
                                pac.setDoenca(d); exi = true;
                        }
                    }
                    if (exi == false){
                        d = new Doenca();
                        d.setNome(nome);
                        d.setId_Doenca(Id("d"));
                        d.setContagio(validar.validarString(1, 3, "Doenca contagiosoa? (SIM/NAO):  "));
                        pac.setDoenca(d);
                        lista.addElement(d); lista.trimToSize(); i = lista.size();
                        
                    }
                    do{
                    enfermeiro = verificarEnfermeiro();
                    for(int j = 0; j < lista.size(); j++)
                        if(lista.elementAt(j) instanceof Funcionario){
                            f = (Funcionario) lista.elementAt(j);
                            if (f instanceof Enfermeiro){
                                e = (Enfermeiro) f;
                                if(e.getFuncionario().equalsIgnoreCase(enfermeiro)){
                                    pacientes = e.getCuidados(); 
                                    for (int k = 0; k < pacientes.length; k++)
                                        if(pacientes[k].isEmpty() && c == 0){  
                                            e.setCuidadosEnf(k, pac.getNome()); 
                                            pac.setEstado("Internado");
                                            lista.setElementAt(pac, i);
                                            lista.setElementAt(e, j); lista.trimToSize();
                                            output.mensagem("Paciente Internado."); 
                                            c++;}
                                    if(c == 0){
                                        output.mensagem("O Enfermeiro "+enfermeiro+" Atingiu o Limite de Pacientes Por Cuidar");
                                        op = validar.validarByte((byte)0,(byte)1, "\t1. Introduzir Outro Enfermeiro Novamente\n\t0. Cancelar Procedimento.");
                                    }}}    }                                                             
                    } while(op == 1 && c == 0);
    }
    
    
    @Override
    public void registarPaciente() {
        pac = new Paciente();
        try{
            System.out.println("Paciente Nao Registado no Sistema.");
            pac.setNome(validar.validarString(3, 20, "Introduza o Nome Do Novo Paciente:"));
            pac.setIdPaciente(Id("p"));
            pac.setSexo(validar.validarChar('M', 'F', "Sexo do Paciente (M/F)"));
            pac.setTelefone(validar.validarTelefone());
            pac.setEndereco(validar.validarString(5, 30, "Endereco do Paciente:"));
            pac.setBI(validar.validarString(8, 12, "Numero de BI do Paciente:"));
            pac.setIdade(validar.validarByte((byte)0,(byte) 100, "Idade da Paciente:"));
            output.mensagem("Codigo De identificacao De Paciente: " +pac.getIdPaciente());
        }catch (IOException ex) {
            Logger.getLogger(ClinicaOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void registarEnf() {
        Enfermeiro enf = new Enfermeiro();
        try{
            
            enf.setFuncionario(validar.validarString(3, 30, "Introduza o Nome do Enfermeiro:"));
            enf.setIdFuncionatio(Id("f"));
            enf.setCategoria(validar.validarString(3, 20, "Introduza a Categoria do Endermeiro:"));
            lista.addElement(enf); lista.trimToSize();
            output.mensagem("\nEnfermeiro Adicionado.\nCodigo de Enfermeiro: " +enf.getFuncionario());
        }catch (IOException ex) {
            Logger.getLogger(ClinicaOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void registarMed() {
        Medico med = new Medico();
        try{
            
            med.setFuncionario(validar.validarString(3, 30, "Introduza o Nome do Medico:"));
            med.setIdFuncionatio(Id("f"));
            med.setEspecialidade(validar.validarString(3, 20, "Introduza a Especialidade Do Medico:"));
            lista.addElement(med); lista.trimToSize();
            output.mensagem("\nMedico Adicionado.\nCodigo de Medico: " +med.getIdFuncionario());
        }catch (IOException ex) {
            Logger.getLogger(ClinicaOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void lerDados() {
        try{
            File clinica = new File("src/sistemadegestao/Clinica.dat"); 
            FileInputStream fis = new FileInputStream (clinica);
            ObjectInputStream ois = new ObjectInputStream (fis);
            lista = (Vector) ois.readObject();
           
            ois.close();
        }
        catch (ClassNotFoundException | IOException x){
            try {
                output.mensagem(x.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(ClinicaOperacoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void gravarDados() {
        try{
            File clinica = new File("src/sistemadegestao/Clinica.dat"); 
            FileOutputStream fos = new FileOutputStream (clinica);
            ObjectOutputStream oos = new ObjectOutputStream (fos);
            oos.writeObject(lista);
            
            oos.close();
        }
        
        catch(IOException x){
            try {
                output.mensagem(x.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(ClinicaOperacoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Any[] convertVectorToCorbaList(Vector vector){
        Any[] myArray = (Any[]) vector.toArray(new Any[vector.size()]);
        ORB orb = ORB.init();
        ListaHolder corbaSeq  = new ListaHolder();
        corbaSeq.value = new Any[myArray.length];
        for(int i=0; i<myArray.length; i++){
            corbaSeq.value[i] = myArray[i];
        }
       return corbaSeq.value;
    }
    

    @Override
    public Any[] getdados() {
        return convertVectorToCorbaList(lista);
    }
    
     public static void main(String[] args) {
        try {
              
           //Usando o serviço de nomes
           String[] argv = { "-ORBInitialPort", "900", "-ORBInitialHost", "127.0.0.1" };
            ORB orb = ORB.init(argv, null);

            // Obtém referência a rootpoa (Portable Object Adapter) e ativa o Gerenciador POA
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Cria o serviço e registra ele com o ORB (Object Request Broker)
           ClinicaOperacoes ServidorOp = new ClinicaOperacoes();
           //ServidorOp .setOrb(orb);

            // obtém a referência do serviço a ser disponibilizado pelo servidor
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(ServidorOp );
            Dados href = DadosHelper.narrow(ref);

            // Obtém a referência para o serviço de nomes
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // vincula a referencia do objeto a um nome, no servidor de nomes
            String objNome = "OpServer";
            NameComponent path[] = ncRef.to_name(objNome);
            ncRef.rebind(path, href);
            //ncRef.rebind(path, ref);

            System.out.println("Servidor de impressoes pronto e aguardando ...");
            orb.run();
            
            
            //  Usando IOR manualmente
           /* 
            ORB orb = ORB.init(args, null); //cria e inicializa o ORB
            org.omg.CORBA.Object obj = orb.resolve_initial_references("RootPOA");
            POA rootPOA = POAHelper.narrow(obj); //Obtem referencia a rootPoa e actia o gerenciador POA
            //rootPOA.the_POAManager().activate();

            ClinicaOperacoes cOp = new ClinicaOperacoes(); //cria o servico e o regista com o ORB

            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(cOp);

            System.out.println("Referencia do Servidor de operações:\n "+orb.object_to_string(ref));

            rootPOA.the_POAManager().activate();
            orb.run();*/
           

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
