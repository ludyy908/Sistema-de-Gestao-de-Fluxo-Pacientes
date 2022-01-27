
package clinica.view;
import clinica.controller.CirurgiaControl;
import clinica.controller.ConsultaControl;
import clinica.controller.PacController;
import clinica.model.Cirurgia;
import clinica.model.Consulta;
import clinica.model.Paciente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Amarilda Chihepe
 */
public class GerarRelatorioPac extends JDialog implements ActionListener, ItemListener{
    
    JButton b1, b2;
    JComboBox comboPac;
    JTextField t2;
    JPanel p1, p2;
    JLabel l0,l1, l2;
    String [] p;
    PacController pac = new PacController();
    ConsultaControl cc = new ConsultaControl(); 
    CirurgiaControl circ = new CirurgiaControl();
    Font f = new Font("Segoe UI",Font.BOLD,16);

    public GerarRelatorioPac() {
        setTitle("Relatorio do Paciente");
        setModal(true);
        setSize(600, 300);
        setLocation(420, 200);
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        
        p1 = new JPanel();
        p2 = new JPanel();      
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        l1 = new JLabel("Selecione o Nome do Paciente");
        l1.setBounds(20, 20, 500, 30);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l1.setForeground(Color.GRAY);
        
        p= new String[pac.getPacNome().size()];
        for(int i =0; i<pac.getPacNome().size();i++){
            p[i] = pac.getPacNome().get(i);
        }
        
        comboPac = new JComboBox(p); // combo com  o nome dos pacientes
        comboPac.setBounds(20,60,350,35);
        comboPac.setFont(new Font("Segoe UI", Font.BOLD, 15));
        comboPac.setForeground(Color.GRAY);
        comboPac.setRequestFocusEnabled(false);
        comboPac.addItemListener(this);
        comboPac.setFocusable(false);
        comboPac.setBackground(null);
        
        l2 = new JLabel("Codigo do Paciente:");
        l2.setBounds(20, 100, 500, 30);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l2.setForeground(Color.GRAY);

        t2 = new JTextField(50); 
        t2.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
        t2.setBounds(20,140,300,25);
        t2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        
        b1 = new JButton("Cancelar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 200, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBackground(new Color(255, 0, 0));

        b2 = new JButton("Seguinte");
        b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b2.setForeground(Color.WHITE);
        b2.setBounds(270, 200, 175, 30);
        b2.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        b2.setBackground(new Color(0, 100, 0));


        b1.addActionListener(this);
        b2.addActionListener(this);
        
        p1.add(l1); p1.add(comboPac); p1.add(b1); p1.add(b2); p1.add(l2); p1.add(t2);
        add(p1);
        
        setVisible(true);
        setResizable(false);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == b1){
            dispose();
        }
        
        if(e.getSource() == b2){
            if(t2.getText().isEmpty()){
               JOptionPane.showMessageDialog(null, "Por Favor, Selecione o Paciente.");
           }else {
                ArrayList<Paciente> listaPac = pac.getPacDados(Integer.parseInt(t2.getText()));
                String idp = String.valueOf(listaPac.get(0).getIdPaciente()); 
                String nP = listaPac.get(0).getNome();
                String gp = listaPac.get(0).getGenero();
                String morp = listaPac.get(0).getEndereco();
                String idadp = String.valueOf(listaPac.get(0).getIdade());
                String biP = listaPac.get(0).getBI();
                String civilp = listaPac.get(0).getEstadoCivil();
                String nacioP = listaPac.get(0).getNacionalidade(); 
                String telp = listaPac.get(0).getTel1();
                String telAlt = listaPac.get(0).getTel2();
                String apelip = listaPac.get(0).getApelido();
                
                
                ArrayList<Consulta> listCons = cc.getDadosCons(Integer.parseInt(t2.getText()));
               
                ArrayList<Cirurgia> listCir = circ.getDadosCir(Integer.parseInt(t2.getText()));
                                        
                RelatorioPac rp = new RelatorioPac();
                
                try {
                    rp.gerarRelatorio(nP,idp, nP, gp, morp, idadp, biP, civilp, nacioP, telp, telAlt, apelip,listCons, listCir);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GerarRelatorioPac.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GerarRelatorioPac.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                t2.setText("");
               // p1.setVisible(false);
            
        }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       if(e.getSource() == comboPac){
         
         String nomep;          
         nomep = comboPac.getSelectedItem().toString();
         t2.setText(Integer.toString(pac.getPacId(nomep)));
        }
    }
    
}
