/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;

import clinica.controller.EnfControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;


public class AdicionarEnf extends JDialog implements ActionListener {

    JPanel p1, p2, p3;
    JLabel l1, l2, l3, l0, l4, l5, l6, l7, l8, l9, l10, lb[];
    JTextField t1, t2, t3, t4, t5, t6, t7, t0[];
    JButton b1, b2, b3, b[];
    JTable t;
    String [] categ = {" -- Categoria --", "Auxiliar De Enfermagem","Tecnico(a) De Dnfermagem"};
    JComboBox c1, c2;
    JComboBox <String> caixa1;
    JRadioButton[] r;
    ButtonGroup g;
    Font f = new Font("Segoe UI",Font.PLAIN,17);
    Font f1 = new Font("Segoe UI",Font.BOLD,17);
    
    Random random;
    
    BorderFactory br;
     String s[] = new String[2];
    
    public AdicionarEnf(){
      
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        p1= new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        g = new ButtonGroup();
        
      

          setModal(true);
        setTitle("Registo de Enfermeiro");
        getContentPane().setBackground(new Color(0,250,220));
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        setSize(800,680);
        setLocation(290, 30);
       
        
        p2.setFont(f);
        p2.setBackground(Color.WHITE);
        
        
        p2.setBounds(0, 5, 800, 650);
        
        caixa1 = new JComboBox(categ);
        //caixa1.addItem("Auxiliar de Enfermagem");
       // caixa1.addItem("Parteira");
        //caixa1.addItem("Tecnico de enfermagem");
        caixa1.setFocusable(false);
        caixa1.setForeground(Color.WHITE);
        caixa1.setBackground(null);
     
        l2 = new JLabel("Nome de Enfermeiro:");l2.setFont(f1);
        l2.setForeground(Color.GRAY);
        l4 = new JLabel("Nacionalidade:");l4.setFont(f1);
        l4.setForeground(Color.GRAY);
        l5 = new JLabel("Telefone:");l5.setFont(f1);
        l5.setForeground(Color.GRAY);
        l6 = new JLabel("Morada:");l6.setFont(f1);
        l6.setForeground(Color.GRAY);
        l7 = new JLabel("Categoria:");l7.setFont(f1);
        l7.setForeground(Color.GRAY);
        caixa1.setFont(f);
        caixa1.setForeground(Color.GRAY);
        l8 = new JLabel("Departamento:");l8.setFont(f1);
        l8.setForeground(Color.GRAY);
        l9 = new JLabel("Gênero:");l9.setFont(f1);
        l9.setForeground(Color.GRAY);


        t2 = new JTextField(25);
        t3 = new JTextField(30);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);
        t7 = new JTextField(10);


        t1.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
        //t1.setForeground(Color.GRAY);
        t2.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
        //t2.setForeground(Color.GRAY);
        t3.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
       // t2.setForeground(Color.GRAY);
        t4.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
       // t4.setForeground(Color.GRAY);
        t5.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
        //t5.setForeground(Color.GRAY);
        t6.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
        //t5.setForeground(Color.GRAY);
        t7.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
       //s t7.setForeground(Color.GRAY);

        b3 = new JButton("Salvar");
        b3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b3.setForeground(Color.WHITE);
        b3.setBounds(430,580, 175, 30);
        b3.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        b3.setBackground(new Color(0, 100, 0));
        b3.setBorderPainted(false);
        b3.setFocusable(false);

        b2 = new JButton("Cancelar");
        b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b2.setForeground(Color.WHITE);
        b2.setBounds(180, 580, 175, 30);
        b2.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b2.setBackground(new Color(255, 0, 0));
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        b2.setBorderPainted(false);

        r = new JRadioButton[2];
        r[0] = new JRadioButton("Feminino"); r[0].setBackground(Color.white);
        r[1] = new JRadioButton("Masculino"); r[1].setBackground(Color.white);

        g.add(r[0]); g.add(r[1]);
        r[0].setFocusable(false);
        r[1].setFocusable(false);


        //r[0].addActionListener(this);
        //r[1].addActionListener(this);

        b2.addActionListener(this);
        b3.addActionListener(this);

        p1.setBounds(0,0,870,75);
        p1.setBackground(new Color(8,84, 121));

        l0= new JLabel("Registo de Enfermeiro"); 
        l0.setBounds(100,0, 400, 75); 
        l0.setFont(new Font("Imprint MT Shadow", Font.BOLD, 28));
        l0.setForeground(Color.black);

        p1.setLayout(null);
        p2.setLayout(null);
        

        l2.setBounds(100, 100, 200, 27); t2.setBounds(100, 130, 380, 25);t2.setFont(f);
        l4.setBounds(100, 170, 250, 27); t3.setBounds(100, 200, 380, 25);t3.setFont(f);
        l5.setBounds(100, 240, 250, 27); t4.setBounds(100, 270, 380, 25);t4.setFont(f);
        l6.setBounds(100, 310, 200, 27); t5.setBounds(100, 340, 380, 25);t5.setFont(f);
        l7.setBounds(100, 380, 200, 27); caixa1.setBounds(100, 410, 380, 35);
        l8.setBounds(100, 450, 200, 27); t7.setBounds(100,480, 380, 25);t7.setFont(f);
        l9.setBounds(550, 100, 100, 27);



        r[0].setBounds(530, 130, 125, 20);r[0].setFont(f);
        r[0].setForeground(Color.gray);
        r[1].setBounds(660, 130, 120, 20);r[1].setFont(f);
        r[1].setForeground(Color.gray);
        b2.addActionListener(this);
        b3.addActionListener(this);

        p1.add(l0);p2.add(r[0]); p2.add(r[1]);
        p2.add(l9); p2.add(l7);
        p2.add(l5);p2.add(l6);p2.add(t5);p2.add(t4);
        p2.add(t2);p2.add(b2);p2.add(t6);
        p2.add(l4);p2.add(t3);p2.add(b3);p2.add(l8);p2.add(t7);
        p2.add(l2); p2.add(caixa1);
        
        
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("enfermeiro");
        }
        this.setLayout(null);
        this.setResizable(false);
        add(p1); add(p2);
        this.setVisible(true);

        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = ""; 
        boolean b = false;
        /*if(e.getSource() == b3){
            if( e.getSource() == r[0]) {s = "Feminino"; b = true;}
            else if( e.getSource() == r[1]) {s = "Masculino"; b = true;}
            
        }*/
       
        if(e.getSource() == b2){
           int op = 0;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Registo?", "Messagem de confimacao", JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.YES_OPTION) {
               // new Menu("enfermeiro");
                dispose();
               
            }
        }
        
       if(e.getSource() == b3){  
                 
               random = new Random();
               
               String nome,sexo, end,nacio, dpt, tel, categoria;
               int id = random.nextInt(999);              
               categoria = caixa1.getSelectedItem().toString();
               nome = t2.getText();
               nacio = t3.getText();
               tel = t4.getText();
               end = t5.getText();
               dpt = t7.getText();

                if(r[0].isSelected()){
                     sexo = "Femenino";
                } else{
                     sexo = "Masculino";
                }

             if(t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() ||t5.getText().isEmpty() || t7.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Por Favor, Preencha Todos os campos.");
             
             }else{
                              
                EnfControl ec = new EnfControl(id, nome, sexo,tel, end, nacio,dpt, categoria);
                   
                JOptionPane.showMessageDialog(null,"Dados Salvos Com Sucesso!!!!");
                t2.setText("");   
                t3.setText("");  
                t4.setText("");  
                t5.setText("");  
                t7.setText("");
                
                r[0].setSelected(false);
                r[1].setSelected(false);
                Object ob = categ[0];                
                caixa1.setSelectedItem(ob);
           }
       }   
       
          
    }

}
