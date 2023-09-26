
package sistemadegestao.servidorInterface;

import sistemadegestao.servidorOperacoes.Dados;
import java.io.File;
import java.io.IOException;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import sistemadegestao.servidorValidacao.Validacao;
import sistemadegestao.servidorOperacoes.Impressoes;
import sistemadegestao.servidorOperacoes.services.DadosHelper;


public class Menu {
    
    Validacao validar = new Validacao(); 
    Impressoes imp;
    Dados dad ;
    sistemadegestao.servidorOperacoes.services.Dados dados;

    public Menu() throws IOException, InvalidName, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed{
        //Usando o servico de nomes
        String[] argv = { "-ORBInitialPort", "900", "-ORBInitialHost", "127.0.0.1" };
        ORB orb = ORB.init(argv, null);

        // obtém a referência para o serviço de nomes
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService"); 
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
        // Obtém a referência para o Objeto do servidor (IOR), através do serviço de nomes 
        String objNome = "OpServer";
        NameComponent path[] = ncRef.to_name(objNome);
        //org.omg.CORBA.Object obj = ncRef.resolve(path);
        org.omg.CORBA.Object obj = ncRef.resolve_str(objNome);
        dados = DadosHelper.narrow(obj);

        
        //Usando IOR Manualmente
        /*
        ORB orb = ORB.init(argv, null);
        String ior = "IOR:000000000000001749444c3a73657276696365732f4461646f733a312e300000000000010000000000000082000102000000000a3132372e302e302e3100095f00000031afabcb0000000020cd22a15d00000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002";
        org.omg.CORBA.Object objRef = orb.string_to_object(ior);
        dados = DadosHelper.narrow(objRef);
    
        //dad = new Dados();
        dados.lerDados();
        //dad.lerDados();*/
        System.out.print("Dados do array "+dados.getdados());
    }
    
    public void MenuPrincipal() throws IOException{
        byte opcao;
        
        do{
            System.out.println("\n<<<<<<< SISTEMA DE GESTAO DA CLINICA BOA SAUDE >>>>>>>\n");
            opcao = validar.validarByte((byte) 0,(byte) 5, ""+
                                                           "\n1. Registar Consulta "+
                                                           "\n2. Registar Cirurgia"+
                                                           "\n3. Actualizar/Verificar Dados de Pacientes "+
                                                           "\n4. Actualizar/Verificar Dados de Medicos" +
                                                           "\n5. Actualizar/Verificar Dados de Enfermeiros"+
                                                           "\n0. Fechar Sistema\n\n>>Escolha:");
            if (opcao != 0){
                
                switch (opcao){
                    case 1:
                        dados.agendarConsulta();
                    break;
                    case 2:
                        dados.agendarCirurgia();
                    break;
                    case 3:
                        verificarPacientes();
                    break;
                    case 4:
                        //verificarMedicos();
                    break;
                    case 5:
                       // verificarEnfermeiros();
                    break;
                }
                opcao = validar.validarByte((byte) 0, (byte) 1, "\n>>Voltar ao Menu Principal? (1:Sim / 0:Nao(Fechar o Sistema))\n");
            }
            if (opcao == 0)
                opcao = validar.validarByte((byte) 0, (byte) 1, ">>Tem Certeza Que Deseja Encerrar? (0:Sim / 1:Nao)");
        }while (opcao == 1); 
        dados.gravarDados(); 
    }

   
    
   
    private void verificarPacientes() throws IOException {
        byte opcao;
        do{
            opcao = validar.validarByte((byte)0,(byte) 7, "\nActualizar/Verificar Dados de Pacientes"+
                                                          "\n-----------------------------------------"+
                                                          "\n1. Adicionar novo PAc"+ 
                                                          "\n2. Verificar Pacientes com Cirurgia"+ 
                                                          "\n3. Registar Paciente Internado"+ 
                                                          "\n4. Registar Pacientes com Alta"+ 
                                                          "\n5. Cancelar Consulta com Paciente"+
                                                          "\n6. Cancelar Cirurgia com Paciente"+
                                                          "\n7. Ver lista de Todos Pacientes"+
                                                          "\n0. Voltar\n\n>>Escolha:\t");
            if(opcao !=0){
                switch (opcao){
                    case 1:
                      //  imp.ImprimirCons();
                        dados.registarPaciente();
                    break;
                    case 2:
                        //imp.ImprimirCir();
                    break;
                    case 3:
                       //dad.setInternamento();
                    break;
                    case 4:
                        //dad.darAlta();
                    break;
                    case 5:
                        //dad.cancelar("consulta");
                    break;
                    case 6:
                       // dad.cancelar("cirurgia");
                    break;
                    case 7:
                       // imp.getPacientes();
                    break;
                }
                 opcao = validar.validarByte((byte) 0, (byte) 1, "\nContinuar? (1:Sim / 0:Nao)");
            }
        }while (opcao == 1);
    }    

//    private void verificarMedicos() throws IOException {
//        byte opcao;
//        do{
//            opcao = validar.validarByte ((byte) 0, (byte) 5, "\nActualizar/Verificar Dados de Medicos"+
//                                                             "\n-------------------------------------------"+
//                                                             "\n1. Adicionar Novo Medico"+
//                                                             "\n2. Verificar Medicos com Consulta"+
//                                                             "\n3. Verificar Medicos com Cirurgia"+
//                                                             "\n4. Verificar Todos Medicos"
//                                                             + "\n5. Ver Agenda de um Medico"+
//                                                             "\n0. Voltar \n\n>>Escolha:\t");
//            if(opcao !=0){
//                switch (opcao){
//                    case 1:
//                        dad.adicionarMed();
//                    break;
//                    case 2:
//                        imp.ImprimirMedico("consulta");           
//                    break;
//                    case 3:
//                        imp.ImprimirMedico("cirurgia");
//                    break;
//                    case 4:
//                        imp.ImprimirAllMed();
//                    break;
//                    case 5:
//                        imp.agenda();
//                        break;
//                }
//                 opcao = validar.validarByte((byte) 0, (byte) 1, "\nContinuar? (1:Sim / 0:Nao)");
//            }
//        }while (opcao == 1);
//    }
//       
//    private void verificarEnfermeiros() throws IOException {
//        byte opcao;
//        do{
//            opcao = validar.validarByte ((byte) 0, (byte) 4, "\nActualizar/Verificar Dados de Enfermeiros "+
//                                                             "\n-------------------------------------------------"+
//                                                             "\n1. Adicionar um novo Enfermeiro"+
//                                                             "\n2. Verificar Enfermeiros com Pacientes em cuidados"+ 
//                                                             "\n3. Verificar Todos Enfermeiros"+
//                                                             "\n4. Ver Pacientes cuidado por um determinado enfermeiro"+
//                                                             "\n0. Voltar"
//                                                             + "\n\n>>Escolha:\t");
//            if(opcao !=0){
//            
//                switch (opcao){
//                    case 1:
//                        dad.adicionarEnf();
//                        break;
//                    case 2:
//                        imp.EnfComPacientes();
//                    break;
//                    case 3:
//                        imp.ImprimirEnf();
//                    break;
//                    case 4:
//                        imp.verPacientesEnf();
//                        break;
//                }
//                opcao = validar.validarByte((byte) 0, (byte) 1, "\nContinuar? (1:Sim / 0:Nao)");
//            }
//        } while (opcao == 1);        
//    }
//    
//    
}

   