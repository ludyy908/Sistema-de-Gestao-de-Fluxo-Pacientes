
package sistemadegestao;
import java.io.File;
import java.io.IOException;


public class SistemaDeGestao {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        File clinica = new File("src/sistemadegestao/Clinica.dat"); 
        Menu men = new Menu(clinica);
        System.out.println("Fecho de Sistema.");
    }
    
}
