
package sistemadegestao;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validacao {
     BufferedReader x  = new BufferedReader(new InputStreamReader(System.in));
    
     
       
    public byte validarByte(byte a, byte b, String s)throws IOException{
        byte num = 0;
        System.out.println(s);
        do{
            num = Byte.parseByte(x.readLine());
            if(num < a || num > b){
                System.out.println("Invalido. Introduza novamente.");
            }
        }while(num < a || num > b); 
        return num;
    }
    
    public String validarString(int a, int b, String s) throws IOException {
        String nome;
        System.out.println(s);
        do{
            nome = x.readLine();
            if(nome.length() < a ||nome.length() > b){
                System.out.println("Invalido. Introduza novamente.");
            }
        }while(nome.length() < a ||nome.length() > b);
        return nome;
   }
    
   public int validarInt(int a, int b, String s)throws IOException{
        int i = 0;
        System.out.println(s);
        do{
            i = Integer.parseInt(x.readLine());
            if(i < a || i > b){
                System.out.println("Invalido. Introduza novamente.");
            }
        }while(i < a || i > b); 
        return i;
    }
   
    public char validarChar(char a, char b, String c) throws IOException{
         char n;
         System.out.println(c);
         do{
            n = x.readLine().charAt(0);
            if(n != a && n != b){
                System.out.println("Invalido, introduza novamente... ");
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

