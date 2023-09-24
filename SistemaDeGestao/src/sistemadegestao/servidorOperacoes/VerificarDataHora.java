
package sistemadegestao.servidorOperacoes;
import java.io.*;
import java.util.Vector;
import sistemadegestao.servidorDados.Funcionario;
import sistemadegestao.servidorDados.Medico;
import sistemadegestao.servidorOperacoes.Validacao;


public class VerificarDataHora {
    
     Validacao validar = new Validacao();
     
      public String verificarData (String nome, Vector lista) throws IOException{
        String data, dt = ""; int pos = 0, c1= 0, c2= 0, i, j,l;  byte opcao = 0; 
        Funcionario f; Medico m;  
        String agenda[][];
        
     
        do{
            data = validar.validarData();
            for(int k = 0; k < lista.size(); k++){
                if(lista.elementAt(k) instanceof Funcionario){
                    f = (Funcionario) lista.elementAt(k);
                    if (f instanceof Medico){
                        m = (Medico) f;
                        if (m.nomeFunc.equalsIgnoreCase(nome)){ 
                            agenda = m.getAgenda();  pos= k;
                            for(i = 0; i < agenda.length; i++){
                                for(j = 0; j < agenda[0].length; j++){                                                                                                          
                                    if (agenda[i][0].equalsIgnoreCase(data)){
                                        if(j > 0 && agenda[i][j].isEmpty() == false){
                                            c1++;
                                            if(c1== 10)
                                            opcao = validar.validarByte((byte)1, (byte)2,"Medico Com Agenda Lotada Neste Dia."+
                                                                            "\n1. Introduzir Outra Data Novamente\n"
                                                                                +"0. Cancelar Procedimento  ");
                                        }          

                                    }else
                                        c2++;      
                                }  
                            } 
                        }
                    } } }}while(opcao == 1);
            if(c2 == 29){
                System.out.println("Medico Com Toda Agenda Lotada.");
                        return "";}
            if (c1 < 10){
                c1 = 0;
                m = (Medico)((Funcionario)lista.elementAt(pos));
                agenda = m.getAgenda();
                for(l = 0; l < agenda.length; l++){
                    if (agenda[l][0].equalsIgnoreCase(data))
                        return data;
                    if(agenda[l][0].isEmpty() && c1 == 0){
                        m.setAgenda(l, 0, data);
                        lista.setElementAt(m, pos);
                        lista.trimToSize();
                        dt = data;
                        c1++;
                    }  }                      
            }    
        return dt;
    } 
            
    
    public String verificarHora (String nome, String dt, Vector lista) throws IOException{
        String horas, data = dt; int lin = 0, i, j,k, c = 0, pos = 0; 
        boolean ocupado = false; byte opcao = 0;
        Funcionario f; Medico m;
        String agenda[][];
        
        do{
            horas = validar.validarHora();
            for(i = 0; i < lista.size(); i++)
                if(lista.elementAt(i) instanceof Funcionario){
                    f = (Funcionario) lista.elementAt(i);
                    if (f instanceof Medico){
                        m = (Medico) f;
                        if (m.nomeFunc.equalsIgnoreCase(nome)){
                            agenda = m.getAgenda(); pos = i;
                            for(k = 0; k < agenda.length; k++)
                                for(j = 0; j < agenda[0].length; j++)
                                    if (agenda[k][0].equalsIgnoreCase(data)){//usa adata aprovada no metodo anterior
                                        lin = k;
                                        if(j > 0 && agenda[k][j].equalsIgnoreCase(horas)){ //se encontrar a mesma hora na data nao vai aceita
                                            ocupado = true;
                                            opcao = validar.validarByte((byte)0, (byte)1, ""+
                                                                          "Medico Ja Ocupado a Estas Horas."+
                                                                          "\n1. Introduzir Outra Hora Novamente"+
                                                                          "\n0. Cancelar Procedimento");
                                        }

                                    }   
                                
                               
                        }
                    }
                }
             

        }while(opcao == 1);
        
        if (ocupado == false){
            System.out.println("Medico Disponivel na Data e Hora Marcada.\n");
            m = (Medico)((Funcionario)lista.elementAt(pos));
            agenda = m.getAgenda();
            for (i = 0; i < agenda[lin].length; i++){
                if (i > 0 && agenda[lin][i].isEmpty() && c == 0){ //usa a posicao da data e a primeira coluna vazia para adicionar as horas novas
                    m.setAgenda(lin, i, horas);
                    lista.setElementAt(m, pos); lista.trimToSize();
                    c++;
                } 
            }    
        }     
       return horas;
    }
    
    
}
