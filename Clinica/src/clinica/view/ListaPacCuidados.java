/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import clinica.controller.*;
import clinica.model.Paciente;
import java.util.ArrayList;

/**
 *
 * @author Ludmila Mucavele
 */
public class ListaPacCuidados extends JDialog implements ActionListener, ItemListener {
    JPanel p1, p2;
    JLabel l0, l1, l2;
    JTextField t1, t2;
    JButton b1, b2;
    JTable tabela;
    String[] enf;
    JComboBox comboEnf;
    EnfControl ec = new EnfControl();
    
   Font f = new Font("Segoe UI",Font.BOLD,16);
   
    public ListaPacCuidados(){
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("enfermeiro");
        }
        p1 = new JPanel();
        p2 = new JPanel();
        
          setModal(true);
        setSize(630, 300);
        setLocation(420, 200);
        setTitle("Pacientes em Cuidados");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        l1 = new JLabel("Selecione o Nome do Enfermeiro:");
        l1.setBounds(20, 20, 600, 30);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l1.setForeground(Color.GRAY);

        /*t1 = new JTextField(50); 
        t1.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
        t1.setBounds(20,60,300,25);
        t1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        t1.setForeground(Color.GRAY);*/
        
        enf = new String[ec.getEnfs().size()];
        for(int i =0; i<ec.getEnfs().size();i++){
            enf[i] = ec.getEnfs().get(i);
        }
        
       // Object ob = "-- Selecione o Nome do Medico --";
        
        comboEnf = new JComboBox(enf);
        //comboMedico.setSelectedItem(ob);
         comboEnf.setBackground(null);
         comboEnf.setBounds(20,60,370,37);
         comboEnf.setFont(new Font("Segoe UI", Font.BOLD, 15));
        comboEnf.setForeground(Color.GRAY);
        comboEnf.setRequestFocusEnabled(false);
        comboEnf.setFocusable(false);
        comboEnf.addItemListener(this);
        
        l2 = new JLabel("Codigo de Enfermeiro:");
        l2.setBounds(20, 100, 600, 30);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l2.setForeground(Color.GRAY);

        t2 = new JTextField(50); 
        t2.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.gray));
        t2.setBounds(20,140,300,25);
        t2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        

        b1 = new JButton("Cancelar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(110, 200, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBackground(new Color(255, 0, 0));

        b2 = new JButton("Seguinte");
        b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b2.setForeground(Color.WHITE);
        b2.setBounds(330, 200, 175, 30);
        b2.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        b2.setBackground(new Color(0, 100, 0));


        b1.addActionListener(this);
        b2.addActionListener(this);

        p1.add(l1); p1.add(comboEnf); p1.add(b1); p1.add(b2); p1.add(l2); p1.add(t2);
        add(p1); 

        setVisible(true);
        setResizable(false);
       
    }

    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == comboEnf){
           String nome = comboEnf.getSelectedItem().toString();
           t2.setText(Integer.toString(ec.getIdEnf(nome)));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){           
            //new Menu("enfermeiro");
            dispose();
            
        }
        
        if(e.getSource() == b2){
            if(t2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Por Favor, Preencha os Espacos em Branco.");
            }else {
                p1.setVisible(false);
                getPacientes();
            
            }
            
        }
        
    }
    
    
    public void getPacientes(){
    setSize(550, 320);
        setLocation(420, 200);
        setTitle("Pacientes em Cuidados");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        p2.setLayout(null);
        p2.setBackground(Color.WHITE);
 
        
        l0 = new JLabel ("Pacientes em Cuidados do(a) Enfermeiro(a) "+comboEnf.getSelectedItem()+":");
        l0.setBounds(20, 10, 500, 30);
        l0.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l0.setForeground(Color.GRAY);
        
        String [] nomeColuna = {"Codigo", "Nome"};
      
        
        DefaultTableModel tb = new DefaultTableModel(null,nomeColuna);
        tb.setColumnCount(2);
        tb.setRowCount(5);
       
        tabela = new JTable(tb);
        tabela.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tabela.setForeground(Color.GRAY);
        JScrollPane scrol = new JScrollPane(tabela);
        scrol.setBounds(20,70, 450,120);
        
        inserirDadosTabela(tb);
        
        b1 = new JButton("Fechar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(300, 220, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBackground(new Color(255, 0, 0));
        b1.setFocusable(false);
       
       b1.addActionListener(this);
       
       p2.setBackground(Color.WHITE);
       p2.add(l0); p2.add(scrol); p2.add(b1);
       add(p2);
       setVisible(true);
    }

    
     public void inserirDadosTabela(DefaultTableModel modelo){
       modelo.setNumRows(0);
       PacController pc = new PacController();
       ArrayList<Paciente> lista = pc.getPacCuidados(Integer.parseInt(t2.getText()));
       if(lista.isEmpty()){
           
            JOptionPane.showMessageDialog(null, "Enfermeiro(a) Sem Pacientes.");
       }else{
       for(int i=0;i<lista.size();i++){
          // String [] enf =  ec.getDados().get(i);
           modelo.addRow(new String[]{String.valueOf(lista.get(i).getIdPaciente()),
                                        lista.get(i).getNome()});
        }
       }
   
   }
   

    

}
