/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import sistemadegestao.servidorValidacao.Server.Validacao;
import sistemadegestao.servidorValidacao.Server.validacao.ValidacaoHelper;

public class Server {
    public static void main(String[] args) {
        String argv[] = { "-ORBInitialPort", "900", "-ORBInitialHost", "192.168.157.1" };
        try {
            // Create and initialize the ORB
            ORB orb = ORB.init(argv, null);

            // Create the servant object
            Validacao servidorValidacao = new Validacao(); // Replace with your actual implementation class

            // Get the root POA (Portable Object Adapter)
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            // Activate the servant object
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(servidorValidacao);
            sistemadegestao.servidorValidacao.Server.validacao.Validacao href = ValidacaoHelper.narrow(ref);

            // Get the Naming Service (CosNaming) context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Create a NameComponent for your object's name
            NameComponent[] path = ncRef.to_name("ValidacaoService");

            // Bind your object to the Naming Service
            ncRef.rebind(path, (Object) href);

            System.out.println("Servidor pronto...");

            // Run the ORB
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


