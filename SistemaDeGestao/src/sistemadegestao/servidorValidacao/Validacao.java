
package sistemadegestao.servidorValidacao;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import sistemadegestao.servidorInterface.Output;

public class Validacao {
     Output output = new Output();
     BufferedReader x  = new BufferedReader(new InputStreamReader(System.in));
    
     
       
    public byte validarByte(byte a, byte b, String s)throws IOException{
        byte num = 0;
        do{
            num = output.mensagemByte(s);
            if(num < a || num > b){
                output.mensagem("Invalido. Introduza novamente.");
            }
        }while(num < a || num > b); 
        return num;
    }
    
    public String validarString(int a, int b, String s) throws IOException {
        String nome;
        do{
            nome = output.mensagemString(s);
            if(nome.length() < a ||nome.length() > b){
                output.mensagem("Invalido. Introduza novamente.");
            }
        }while(nome.length() < a ||nome.length() > b);
        return nome;
   }
    
   public int validarInt(int a, int b, String s)throws IOException{
        int i = 0;
        
        do{
            i = output.mensagemInt(s);
            if(i < a || i > b){
                output.mensagem("Invalido. Introduza novamente.");
            }
        }while(i < a || i > b); 
        return i;
    }
   
    public char validarChar(char a, char b, String c) throws IOException{
         char n;
         do{
            n = output.mensagemString(c).charAt(0);
            if(n != a && n != b){
                output.mensagem("Invalido. Introduza novamente.");
            }
        }while(n != a && n != b); 
        return n;
    }
    
    public String validarData() throws IOException{
        String data; int dia, mes, ano;
        dia = validarInt(1,31,"Introduza o Dia:  ");
        mes = validarInt(1, 12, "Introduza o mes (O numero correspondente):  ");
        ano = validarInt(2021, 2022,"Introduza o Ano:  ");
        data = dia+"-"+mes+"-"+ano;
        return data;
    }
    
    public String validarHora () throws IOException{
        String horas;
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        data.setHours(validarByte((byte)1,(byte)24,"Introduza a Hora:"));
        data.setMinutes(validarByte((byte)0,(byte)60,"Introduza os Minutos:"));
        horas = sdf.format(data);
        return horas;
    }
    
    public String[] validarTelefone() throws IOException{
        byte n = validarByte((byte)1,(byte)3 , "Numero de Contactos a Introduzir:");
        String[] tel  = new String [n];
        for(byte i = 0; i < tel.length; i++)
            tel[i] = validarString(9, 9,(i+1)+".o Contacto:");
        return tel; 
        
    }
    
}    

