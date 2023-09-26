
package sistemadegestao.servidorValidacao.Server;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import sistemadegestao.servidorValidacao.App.Output.Output;
import sistemadegestao.servidorValidacao.App.Output.OutputHelper;

public class Validacao extends sistemadegestao.servidorValidacao.App.Validacao.ValidacaoPOA{
     
     BufferedReader x  = new BufferedReader(new InputStreamReader(System.in));
     private ORB orb;
     private ORB OrbOutput;
     private Output output;
     
     public void setOrb(ORB orb_val){
         orb = orb_val;
     }
     
    public Validacao(){
        try {
            String[] args = new String[0];
            // Initialize the ORB
            OrbOutput = ORB.init(args, null);

            // Get the Naming Service (CosNaming) context
            org.omg.CORBA.Object objRef = OrbOutput.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolve the CORBA server object reference using its name
            String serverName = "OutputService";
            output = OutputHelper.narrow(ncRef.resolve_str(serverName));
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void shutdownORB() {
        // Shutdown the ORB when you're done
        OrbOutput.shutdown(false);
    }
  
       
     @Override
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
    
     @Override
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
    
     @Override
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
   
     @Override
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
    
     @Override
    public String validarData() throws IOException{
        String data; int dia, mes, ano;
        dia = validarInt(1,31,"Introduza o Dia:  ");
        mes = validarInt(1, 12, "Introduza o mes (O numero correspondente):  ");
        ano = validarInt(2021, 2022,"Introduza o Ano:  ");
        data = dia+"-"+mes+"-"+ano;
        return data;
    }
    
     @Override
    public String validarHora () throws IOException{
        String horas;
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        data.setHours(validarByte((byte)1,(byte)24,"Introduza a Hora:"));
        data.setMinutes(validarByte((byte)0,(byte)60,"Introduza os Minutos:"));
        horas = sdf.format(data);
        return horas;
    }
    
     @Override
    public String[] validarTelefone() throws IOException{
        byte n = validarByte((byte)1,(byte)3 , "Numero de Contactos a Introduzir:");
        String[] tel  = new String [n];
        for(byte i = 0; i < tel.length; i++)
            tel[i] = validarString(9, 9,(i+1)+".o Contacto:");
        return tel; 
        
    }
}

