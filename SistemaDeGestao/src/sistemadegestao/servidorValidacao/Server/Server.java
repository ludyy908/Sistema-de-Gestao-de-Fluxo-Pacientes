package sistemadegestao.servidorValidacao.Server;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Properties;
import java.util.stream.Stream;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import sistemadegestao.servidorValidacao.Server.Validacao;
import sistemadegestao.servidorValidacao.App.Validacao.ValidacaoHelper;

public class Server {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("org.omg.CORBA.ORBInitialHost", "172.21.34.78");
        props.put("org.omg.CORBA.ORBInitialPort", "1050");
        try {
            // Create and initialize the ORB
            ORB orb = ORB.init(args, props);


            // Get the root POA (Portable Object Adapter)
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            
            // Create the servant object
            Validacao servidorValidacao = new Validacao();
            servidorValidacao.setOrb(orb);

            // Activate the servant object
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(servidorValidacao);
            sistemadegestao.servidorValidacao.App.Validacao.Validacao href = ValidacaoHelper.narrow(ref);

            // Get the Naming Service (CosNaming) context
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Create a NameComponent for your object's name
            NameComponent[] path = ncRef.to_name("ValidacaoService");

            // Bind your object to the Naming Service
            ncRef.rebind(path, (Object) href);

            System.out.println("Servidor pronto...");

            // Run the ORB & wait for invocations from client
            for(;;){
                orb.run();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


