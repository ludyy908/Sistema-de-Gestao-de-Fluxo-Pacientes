/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import clinica.controller.CirurgiaControl;
import clinica.controller.ConsultaControl;
import clinica.model.Cirurgia;
import clinica.model.Consulta;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ludmila Mucavele
 */
public class CancelarReg  extends JDialog implements ActionListener, ItemListener, MouseListener {
    
    private ArrayList<Cirurgia> cir;
    private ArrayList<Consulta> con;
    private JLabel l1, l2, codigo, dataC, horaC, pontos ;
    private JTextField  tf1;
    private JPanel p1, p2;
    private JComboBox tipo;
    private JButton b1, b2;
    
    public CancelarReg(){
        
        setModal(true);
        setTitle("Cancelar Registo");
        setSize (500, 350); setLocation (400, 180);
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
       

        p1 = new JPanel ();
        p1.setLayout(null);
        p1.setBackground(new Color(8,84, 121));
        p1.setBounds(0, 0, 500, 75);
        

        l1 = new JLabel("Cancelar Consulta/Cirurgia"); 
        l1.setBounds(70,0, 400, 75); 
        l1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 28));
        l1.setForeground(Color.black);
        
        p1.add(l1);
    
        p2 = new JPanel (); 
        p2.setLayout(null);
        p2.setBounds(0, 75, 500, 275);
        p2.setBackground(Color.WHITE);
        
        l2 = new JLabel ("Tipo de Registo que Deseja Cancelar:");
        l2.setBounds(70, 10, 300, 30);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        l2.setForeground(Color.GRAY);

        tipo = new JComboBox(new String[]{"Consulta", "Cirurgia"});
        tipo.setBackground(Color.WHITE);
        tipo.setEditable(true);
        tipo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
       // tipo.setForeground(Color.GRAY);
        tipo.setBounds(70, 50, 270,35);
        tipo.setFont(new Font("Segoe UI",Font.BOLD,16));
        tipo.setFocusable(false);
        tipo.setSelectedIndex(0);
        tipo.addItemListener(this);

        codigo = new JLabel ("Codigo de Consulta no Qual Deseja Cancelar:");
        codigo.setBounds(70, 85, 350, 30);
        codigo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        codigo.setForeground(Color.GRAY);

        tf1 = new JTextField(20);
        tf1.setBounds(70, 115, 300, 30);
        tf1.setForeground(Color.GRAY);
        tf1.setText("Introduza o Codigo");
        tf1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tf1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tf1.addMouseListener(this);

        

        b1 = new JButton("Cancelar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 180, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBorderPainted(false);
        b1.setBackground(new Color(255, 0, 0));
        b1.addActionListener(this);

        b2 = new JButton("Seguinte");
        b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b2.setForeground(Color.WHITE);
        b2.setBounds(270, 180, 175, 30);
        b2.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        b2.setBorderPainted(false);
        b2.setBackground(new Color(0, 100, 0));
        b2.addActionListener(this);


        
        p2.add(b1); p2.add(b2);  p2.add(codigo); p2.add(tf1); p2.add(l2); p2.add(tipo);

        Container c = getContentPane();
        c.setLayout(null);
        c.add(p1); c.add(p2);


        setVisible(true);
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("registo");
        }
        setResizable(false);
        
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            CirurgiaControl cc = new CirurgiaControl();
            ConsultaControl cn = new ConsultaControl();
            if(e.getSource() == b1){
                dispose();

            }

            if(e.getSource() == b2){
                if(tf1.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Por Favor, Preencha os Espacos em Branco.");
                else {
                    if (tipo.getSelectedItem() == "Cirurgia"){
                        try {
                            if (cc.cancelar(Integer.parseInt(tf1.getText()))!= 0){
                                JOptionPane.showMessageDialog(null, tipo.getSelectedItem() +" Cancelada Com Sucesso.");
                                dispose();
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Cirurgia Nao Indentificada.");
                        } catch (IOException ex) {
                            Logger.getLogger(CancelarReg.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (tipo.getSelectedItem() == "Consulta"){
                        try {
                            if (cn.cancelar(Integer.parseInt(tf1.getText()))!= 0){
                                JOptionPane.showMessageDialog(null, tipo.getSelectedItem() +" Cancelada Com Sucesso.");
                                dispose();
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Consulta Nao Indentificada.");
                        } catch (IOException ex) {
                            Logger.getLogger(CancelarReg.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
            }
        }
        
    /**
     *
     * @param e
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if (e.getSource() == this.tipo){
            if ("Cirurgia".equals(this.tipo.getSelectedItem().toString())){
                codigo.setText("Codigo de Cirurgia no Qual Deseja Cancelar:");
               
            }
            if ("Consulta".equals(this.tipo.getSelectedItem().toString())){
                codigo.setText("Codigo de Consulta no Qual Deseja Cancelar:");
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tf1){
            tf1.setText("");
        }
        
    } 
    
    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
