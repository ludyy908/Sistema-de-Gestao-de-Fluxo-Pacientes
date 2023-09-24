/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadegestao.servidorInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 *
 * @author ludmi
 */
public class Output {
    BufferedReader x  = new BufferedReader(new InputStreamReader(System.in));
    
    public void mensagem(String mensagem) throws IOException {
        System.out.println( mensagem);
    } 
    
    public String mensagemString(String mensagem) throws IOException {
        System.out.println( mensagem);
        return x.readLine();
    }
     
     public Byte mensagemByte(String mensagem) throws IOException {
        System.out.println( mensagem);
        return Byte.valueOf(x.readLine());
    }
     
     public int mensagemInt(String mensagem) throws IOException {
        System.out.println( mensagem);
        return Integer.parseInt(x.readLine());
    }
     
     public String mensagemChar(String mensagem) throws IOException {
        System.out.println( mensagem);
        return x.readLine();
    }
    
}
