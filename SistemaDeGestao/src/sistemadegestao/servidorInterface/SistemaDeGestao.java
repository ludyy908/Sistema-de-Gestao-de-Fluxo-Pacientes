
package sistemadegestao.servidorInterface;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;


public class SistemaDeGestao {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        Menu men = null;
        try {
            men = new Menu();
        } catch (InvalidName ex) {
            Logger.getLogger(SistemaDeGestao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(SistemaDeGestao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFound ex) {
            Logger.getLogger(SistemaDeGestao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotProceed ex) {
            Logger.getLogger(SistemaDeGestao.class.getName()).log(Level.SEVERE, null, ex);
        }
        men.MenuPrincipal();
        System.out.println("Fecho de Sistema.");
    }
    
}
