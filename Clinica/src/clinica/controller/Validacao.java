
package clinica.controller;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.Random;

public class Validacao {
    
    
    public byte validarByte(byte a, byte b, byte num)throws IOException{
        do{
            if(num < a || num > b){
                return 0;
            }
        }while(num < a || num > b); 
        return num;
    }
    
    public String validarString(int a, int b, String nome) throws IOException {
        do{
            if(nome.length() < a ||nome.length() > b){
                return null;
            }
        }while(nome.length() < a ||nome.length() > b);
        return nome;
   }
    
   public int validarInt(int a, int b, int i)throws IOException{
        do{
            if(i < a || i > b){
                return 0;
            }
        }while(i < a || i > b); 
        return i;
    }
   
    public char validarChar(char a, char b, char c) throws IOException{
         do{
            if(c != a && c != b){
                return 0;
            }
        }while(c != a && c != b); 
        return c;
    }
    
    public String validarData(int d, int m, int a) throws IOException{
        String data; int dia, mes, ano;
        dia = validarInt(1,31,d);
        mes = validarInt(1, 12, m);
        ano = validarInt(2022, 2023, a);
        data = ano+"-"+mes+"-"+dia;
        if (mes < 10 && dia < 10)
            data = ano+"-0"+mes+"-0"+dia;
        if (mes < 10 && dia > 9)
            data = ano+"-0"+mes+"-"+dia;
        if (mes > 9 && dia < 10)
            data = ano+"-"+mes+"-0"+dia;
            
        return data;
    }
    
    public String validarHora (int h, int m) throws IOException{
        String horas;
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        data.setHours(validarByte((byte)1,(byte)24, (byte)h));
        data.setMinutes(validarByte((byte)0,(byte)60,(byte) m));
        horas = sdf.format(data);
        return horas;
    }
    
    public String[] validarTelefone(String t1, String t2) throws IOException{
        String tel[] = new String[2];
        for(int i = 0; i < 2; i++)
            if (i == 0)
                tel[i] = validarString(9, 9,t1);
            else
                tel[i] = validarString(9, 9,t2);
        return tel; 
        
    }
    
    public String validarDataAlta(String inicio, String fim) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dInicio = sdf.parse(inicio);
        Date dFim = sdf.parse(fim);            
        if (dFim.after(dInicio) == false)
            JOptionPane.showMessageDialog(null, "Data de Alta Invalida.");
        else
            return fim;
        return null;
    }
             
    public int gerarCodigo(){
        int cod;
        Random r = new Random();
        do {
            cod = r.nextInt(999);
        } while (cod < 100);
        return cod;
    }
    
}    

