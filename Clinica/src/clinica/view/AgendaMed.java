/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import clinica.controller.MedController;
import clinica.controller.AgendaControl;
import clinica.model.Agenda;
import java.util.*;

/**
 *
 * @author Ludmila Mucavele
 */
public class AgendaMed  extends JDialog implements ActionListener, ItemListener{
    JPanel p1, p2;
    JLabel l0, l1, l2;
    JTextField t1, t2;
    JButton b1, b2, b3;
    JTable tabela; String [] medico;
    JComboBox comboMedico;
    MedController mc = new MedController();
    AgendaControl ac = new AgendaControl();
    
   Font f = new Font("Segoe UI",Font.BOLD,16);
   
    public AgendaMed(){
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("medico");
        }
        p1 = new JPanel();
        p2 = new JPanel();
          
         setModal(true);
        setSize(520, 300);
        setLocation(420, 200);
        setTitle("Agenda de Médico");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        l1 = new JLabel("Selecione o Médico Para Ver a Agenda:");
        l1.setBounds(90, 20, 500, 30);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l1.setForeground(Color.GRAY);

       /* t1 = new JTextField(50); 
        t1.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
        t1.setBounds(20,60,300,25);
        t1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        t1.setForeground(Color.GRAY);*/
       
       medico = new String[mc.getMedico().size()];
        for(int i =0; i<mc.getMedico().size();i++){
            medico[i] = mc.getMedico().get(i);
        }
        
       // Object ob = "-- Selecione o Nome do Medico --";
        
        comboMedico = new JComboBox(medico);
        //comboMedico.setSelectedItem(ob);
        comboMedico.setBackground(null);
        comboMedico.setBounds(90,60,270,35);
        comboMedico.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboMedico.setForeground(Color.GRAY);
        comboMedico.setRequestFocusEnabled(false);
        comboMedico.addItemListener(this);
        comboMedico.setFocusable(false);

        
        l2 = new JLabel("Codigo de Médico:");
        l2.setBounds(90, 100, 500, 30);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l2.setForeground(Color.GRAY);

        t2 = new JTextField(50); 
        t2.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
        t2.setBounds(90,140,300,25);
        t2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        

        b1 = new JButton("Cancelar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 200, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBackground(new Color(255, 0, 0));
        b1.setBorderPainted(false);

        b2 = new JButton("Seguinte");
        b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b2.setForeground(Color.WHITE);
        b2.setBounds(270, 200, 175, 30);
        b2.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        b2.setBackground(new Color(0, 100, 0));
        b2.setBorderPainted(false);

        b1.addActionListener(this);
        b2.addActionListener(this);

        p1.add(l1); p1.add(comboMedico); p1.add(b1); p1.add(b2); p1.add(l2); p1.add(t2);
        add(p1);

        setVisible(true);
        setResizable(false);
       
    }
    
     //Inserir os dados da agenda na tabela
    public void inserirDadosTableAgnda(DefaultTableModel model){
        Agenda a = new Agenda();
        ArrayList<Agenda> agenda = ac.getAgenda(Integer.parseInt(t2.getText()));
        model.setNumRows(0);
        
        if(agenda.isEmpty()){         
            JOptionPane.showMessageDialog(null, "Agenda Vazia.");
        }else{
        for(int i=0; i<agenda.size(); i++){
            model.addRow(new String[]{agenda.get(i).getData(),
                                      agenda.get(i).getHora(),
                                      agenda.get(i).getTipoReg()});
        }

        }
    }

    
    public void getAgenda(){
        setSize(500, 500);
        setLocation(440, 140);
        setModal(true);
        setResizable(false);
        setTitle("Agenda de Médico");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        p2.setLayout(null);
        p2.setBackground(Color.WHITE);
 
        
        l0 = new JLabel ("Agenda de Medico "+comboMedico.getSelectedItem().toString()+":");
        l0.setBounds(20, 10, 300, 30);
        l0.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l0.setForeground(Color.GRAY);
        
        String [] nomeColuna = {"Data", "Hora", "Tipo de Registo"};
      
        
        DefaultTableModel tb = new DefaultTableModel(null,nomeColuna);
        tb.setColumnCount(3);
        tb.setRowCount(20);
       
        tabela = new JTable(tb);
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tabela.setForeground(Color.GRAY);
        JScrollPane scrol = new JScrollPane(tabela);
        scrol.setBounds(20,70, 420,310);
       inserirDadosTableAgnda(tb);
        
        
        b1 = new JButton("Fechar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(250, 405, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBackground(new Color(255, 0, 0));
        b1.setBorderPainted(false);
       
       b1.addActionListener(this);
       
       p2.setBackground(Color.WHITE);
       p2.add(l0); p2.add(scrol); p2.add(b1);
       add(p2);
       setResizable(false);
       if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("medico");
        }
       setVisible(true);
    }

    @Override
    //metodos do evento do click de um elemeto do combobox
    public void itemStateChanged(ItemEvent e) {
    
     if(e.getSource() == comboMedico){
         
         String nomeMed;          
         nomeMed = comboMedico.getSelectedItem().toString();
         t2.setText(Integer.toString(mc.getIdMed(nomeMed)));
        }
    }
    

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
           int op = 0;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Cadastro?", "Message", JOptionPane.YES_NO_OPTION);
            if(op == JOptionPane.YES_OPTION)
                dispose();           
        }
        
        if(e.getSource() == b2){
            if(t2.getText().isEmpty()){
               JOptionPane.showMessageDialog(null, "Por Favor, Selecione o Medico.");
           }else {
              p1.setVisible(false);
              getAgenda();
            
            }
            
        }
    }
    
    
}


