
package sistemadegestao;

import java.io.File;
import java.io.IOException;


public class Menu {
    
    Validacao validar = new Validacao(); 
    Dados dad ;
   
    
    public Menu(File file) throws IOException{
        dad = new Dados();
        dad.lerDados(file);
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
                        dad.agendarConsulta();
                    break;
                    case 2:
                        dad.agendarCirurgia();
                    break;
                    case 3:
                        verificarPacientes();
                    break;
                    case 4:
                        verificarMedicos();
                    break;
                    case 5:
                        verificarEnfermeiros();
                    break;
                }
                opcao = validar.validarByte((byte) 0, (byte) 1, "\n>>Voltar ao Menu Principal? (1:Sim / 0:Nao(Fechar o Sistema))\n");
            }
            if (opcao == 0)
                opcao = validar.validarByte((byte) 0, (byte) 1, ">>Tem Certeza Que Deseja Encerrar? (0:Sim / 1:Nao)");
        }while (opcao == 1); 
        dad.gravarDados(file); 
    }
   
    
   
    private void verificarPacientes() throws IOException {
        byte opcao;
        do{
            opcao = validar.validarByte((byte)0,(byte) 7, "\nActualizar/Verificar Dados de Pacientes"+
                                                          "\n-----------------------------------------"+
                                                          "\n1. Verificar Pacientes com Consulta"+ 
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
                        dad.ImprimirCons();
                    break;
                    case 2:
                        dad.ImprimirCir();
                    break;
                    case 3:
                        dad.setInternamento();
                    break;
                    case 4:
                        dad.darAlta();
                    break;
                    case 5:
                        dad.cancelar("consulta");
                    break;
                    case 6:
                        dad.cancelar("cirurgia");
                    break;
                    case 7:
                        dad.getPacientes();
                    break;
                }
                 opcao = validar.validarByte((byte) 0, (byte) 1, "\nContinuar? (1:Sim / 0:Nao)");
            }
        }while (opcao == 1);
    }    

    private void verificarMedicos() throws IOException {
        byte opcao;
        do{
            opcao = validar.validarByte ((byte) 0, (byte) 5, "\nActualizar/Verificar Dados de Medicos"+
                                                             "\n-------------------------------------------"+
                                                             "\n1. Adicionar Novo Medico"+
                                                             "\n2. Verificar Medicos com Consulta"+
                                                             "\n3. Verificar Medicos com Cirurgia"+
                                                             "\n4. Verificar Todos Medicos"
                                                             + "\n5. Ver Agenda de um Medico"+
                                                             "\n0. Voltar \n\n>>Escolha:\t");
            if(opcao !=0){
                switch (opcao){
                    case 1:
                        dad.adicionarMed();
                    break;
                    case 2:
                        dad.ImprimirMedico("consulta");           
                    break;
                    case 3:
                        dad.ImprimirMedico("cirurgia");
                    break;
                    case 4:
                        dad.ImprimirAllMed();
                    break;
                    case 5:
                        dad.agenda();
                        break;
                }
                 opcao = validar.validarByte((byte) 0, (byte) 1, "\nContinuar? (1:Sim / 0:Nao)");
            }
        }while (opcao == 1);
    }
       
    private void verificarEnfermeiros() throws IOException {
        byte opcao;
        do{
            opcao = validar.validarByte ((byte) 0, (byte) 4, "\nActualizar/Verificar Dados de Enfermeiros "+
                                                             "\n-------------------------------------------------"+
                                                             "\n1. Adicionar um novo Enfermeiro"+
                                                             "\n2. Verificar Enfermeiros com Pacientes em cuidados"+ 
                                                             "\n3. Verificar Todos Enfermeiros"+
                                                             "\n4. Ver Pacientes cuidado por um determinado enfermeiro"+
                                                             "\n0. Voltar"
                                                             + "\n\n>>Escolha:\t");
            if(opcao !=0){
            
                switch (opcao){
                    case 1:
                        dad.adicionarEnf();
                        break;
                    case 2:
                        dad.EnfComPacientes();
                    break;
                    case 3:
                        dad.ImprimirEnf();
                    break;
                    case 4:
                        dad.verPacientesEnf();
                        break;
                }
                opcao = validar.validarByte((byte) 0, (byte) 1, "\nContinuar? (1:Sim / 0:Nao)");
            }
        } while (opcao == 1);        
    }
    
    
}

   