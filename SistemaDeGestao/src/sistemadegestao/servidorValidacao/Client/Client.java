/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadegestao.servidorValidacao.Client;

/**
 *
 * @author ludmi
 */

import sistemadegestao.servidorValidacao.Server.validacao.Validacao;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import sistemadegestao.servidorValidacao.Server.validacao.ValidacaoHelper;

public class Client {
    public static void main(String[] args) {
        String argv[] = { "-ORBInitialPort", "900", "-ORBInitialHost", "192.168.157.1" };
        try {
            // Initialize the ORB
            ORB orb = ORB.init(argv, null);

            // Get the Naming Service (CosNaming) context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolve the CORBA server object reference using its name
            String serverName = "ValidacaoService";
            Validacao serverObj = ValidacaoHelper.narrow(ncRef.resolve_str(serverName));

            // Invoke remote methods on serverObj
             // Invoke remote methods on serverObj
            byte byteResult = serverObj.validarByte((byte) 0, (byte) 10, "byteValue");
            char charResult = serverObj.validarChar('A', 'Z', "charValue");
            String stringResult = serverObj.validarString(3, 30, "stringValue");
            int intResult = serverObj.validarInt(1, 100, "intvalue");
            String dataResult = serverObj.validarData();
            String horaResult = serverObj.validarHora();
            String[] telefoneResult = serverObj.validarTelefone();

            // Handle the results as needed
            // For example, print them to the console
            System.out.println("Byte Result: " + byteResult);
            System.out.println("Char Result: " + charResult);
            System.out.println("String Result: " + stringResult);
            System.out.println("Int Result: " + intResult);
            System.out.println("Data Result: " + dataResult);
            System.out.println("Hora Result: " + horaResult);
            System.out.println("Telefone Result: " + String.join(", ", telefoneResult));

            // Don't forget to cleanup and disconnect from the ORB
            orb.shutdown(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

