/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.*;
import clinica.controller.*;
import clinica.view.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ludmila Mucavele
 */
public class Registo extends JDialog implements ActionListener {
    private JLabel medico, dataC, horaC, nomeD, l1, l2, pontos;
    private JTextField tf1, tf2, tf3;
    private JSpinner mes, ano, dia, horas, minutos;
    private JComboBox tipo, codigo;
    private JPanel p1, p2, p3, p4;
    private JButton b1, b2, b3, b4, b5;
    private JLabel nrC, estado, nome, contagio;
    private JRadioButton rS, rN;
    private ButtonGroup radio;
    private Container c;
   
    
    public Registo(){
        
    setModal(true);
    setTitle("Registo");
    setSize (500, 500); setLocation (300, 150);
    setIconImage(new ImageIcon("iconeprincipal.png").getImage());
    
    p1 = new JPanel ();
    p1.setLayout(null);
    p1.setBackground(new Color(8,84, 121));
    p1.setBounds(0, 0, 700, 75);
    
    l1 = new JLabel("Registo de Consulta/Cirurgia"); 
    l1.setBounds(70,0, 400, 75); 
    l1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 28));
    l1.setForeground(Color.black);
    
    p1.add(l1);
   
    
    
    p2 = new JPanel (); p2.setLayout(null);
    p2.setBounds(0, 75, 700, 425);
    p2.setBackground(Color.WHITE);
    
    l2 = new JLabel ("Tipo de Registo:");
    l2.setBounds(70, 10, 300, 30);
    l2.setFont(new Font("Segoe UI", Font.BOLD, 15));
    l2.setForeground(Color.GRAY);
    
    tipo = new JComboBox(new String[]{"Consulta", "Cirurgia"});
    tipo.setBackground(Color.WHITE);
    tipo.setBounds(70, 50, 270,25);
    
    
    medico = new JLabel ("Nome do Medico Que Realizara a Cirurgia:");
    medico.setBounds(70, 85, 300, 30);
    medico.setFont(new Font("Segoe UI", Font.BOLD, 15));
    medico.setForeground(Color.GRAY);
    
    tf1 = new JTextField(20);
    tf1.setBounds(70, 115, 300, 30);
    tf1.setForeground(Color.GRAY);
    tf1.setText("Introduza o Nome Completo");
    tf1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    tf1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    
    dataC = new JLabel ("Data:");
    dataC.setBounds(70, 150, 300, 30);
    dataC.setFont(new Font("Segoe UI", Font.BOLD, 15));
    dataC.setForeground(Color.GRAY);
    
    String [] anoo = new String[2];
    anoo[0]= "2021"; anoo[1]="2022";
    SpinnerListModel listaAno = new SpinnerListModel(anoo);
    ano = new JSpinner (listaAno);
    ano.setBounds(250, 180, 60, 30);
    ano.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    ano.setForeground(Color.GRAY);
    ano.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    
    Month[] mess = Month.values();
    SpinnerListModel listaMes = new SpinnerListModel(mess);
    mes = new JSpinner (listaMes);
    mes.setBounds(130, 180, 100, 30);
    mes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    mes.setForeground(Color.GRAY);
    mes.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    
    String[] diaa = new String [31];
    for (int i = 0; i < 31; i++)
        diaa[i]= Integer.toString(i+1);
    SpinnerListModel listaDia = new SpinnerListModel(diaa);
    dia = new JSpinner (listaDia);
    dia.setBounds(70, 180, 60, 30);
    dia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    dia.setForeground(Color.GRAY);
    dia.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray)); 
    
    horaC = new JLabel ("Horas:");
    horaC.setBounds(70, 215, 300, 30);
    horaC.setFont(new Font("Segoe UI", Font.BOLD, 15));
    horaC.setForeground(Color.GRAY);
    
    String[] hora = new String [24];
    for (int i = 0; i < 24; i++)
        hora[i]= Integer.toString(i);
    SpinnerListModel listaHora = new SpinnerListModel(hora);
    horas = new JSpinner (listaHora);
    horas.setBounds(70, 245, 60, 30);
    horas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    horas.setForeground(Color.GRAY);
    horas.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    
    String[] minuto = new String [60];
    for (int i = 0; i < 60; i++)
        minuto[i]= Integer.toString(i);
    SpinnerListModel listaMinuto = new SpinnerListModel(minuto);
    minutos = new JSpinner (listaMinuto);
    minutos.setBounds(130, 245, 60, 30);
    minutos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    minutos.setForeground(Color.GRAY);
    minutos.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    minutos.setName("Minutos");
    
    pontos = new JLabel (":");
    pontos.setBounds(120,245, 100, 30);
    pontos.setFont(new Font("Segoe UI", Font.BOLD, 15));
    pontos.setForeground(Color.GRAY);

    b1 = new JButton("Cancelar");
    b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
    b1.setForeground(Color.WHITE);
    b1.setBounds(50, 320, 175, 30);
    b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
    b1.setBackground(new Color(255, 0, 0));
    b1.addActionListener(this);
    
    b2 = new JButton("Seguinte");
    b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
    b2.setForeground(Color.WHITE);
    b2.setBounds(270, 320, 175, 30);
    b2.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
    b2.setBackground(new Color(0, 100, 0));
    b2.addActionListener(this);
   
    
    p2.add(horaC); p2.add(horas); p2.add(minutos); p2.add(dataC);
    p2.add(dia); p2.add(mes); p2.add(ano); p2.add(pontos); p2.add(b1);
    p2.add(b2);  p2.add(medico); p2.add(tf1); p2.add(l2); p2.add(tipo);
    
    c = getContentPane();
    c.setLayout(null);
    c.add(p1); c.add(p2);
    
    setResizable(false);
    if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("registo");
        }
    setVisible(true);
    }
   
    private void InterfaceReg1(){
        setSize (500, 300); setLocation (300, 150);
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        setTitle("Registo");

        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(Color.WHITE);
        p3.setBounds(0, 0, 700, 700);
        
        nrC = new JLabel("Numero de Consulta/Cirurgia:");
        nrC.setBounds(20, 10, 300, 30);
        nrC.setFont(new Font("Segoe UI", Font.BOLD, 15));
        nrC.setForeground(Color.GRAY);
        
        estado = new JLabel("Estado de Consulta/Cirurgia:");
        estado.setBounds(20, 50, 300, 30);
        estado.setFont(new Font("Segoe UI", Font.BOLD, 15));
        estado.setForeground(Color.GRAY);
        
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(20, 100, 300, 30);
        
        nome = new JLabel ("Nome do Paciente:");
        nome.setBounds(20, 110, 300, 30);
        nome.setFont(new Font("Segoe UI", Font.BOLD, 15));
        nome.setForeground(Color.GRAY);
        
        
        tf2 = new JTextField(20);
        tf2.setBounds(20, 150, 300, 30);
        tf2.setForeground(Color.GRAY);
        tf2.setText("Introduza o Nome Completo");
        tf2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tf2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        
        
        codigo = new JComboBox();
        codigo.setBackground(Color.WHITE);
        codigo.setBounds(20, 190, 270,25);
    
    
        b3 = new JButton("Voltar");
        b3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b3.setForeground(Color.WHITE);
        b3.setBounds(70, 200, 150, 30);
        b3.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b3.setBackground(new Color(255, 0, 0));
        b3.addActionListener(this);

        b4 = new JButton("Seguinte");
        b4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b4.setForeground(Color.WHITE);
        b4.setBounds(250, 200, 150, 30);
        b4.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b4.setBackground(new Color(0, 100, 0));
        b4.addActionListener(this);
        
        p3.add(b3); p3.add(b4); p3.add(nome); p3.add(tf1); p3.add(nrC); p3.add(estado); 
        p3.add(separador);
         
                
        Container c = getContentPane();
        c.setLayout(null);
        c.add(p3);


        setVisible(true);
        if (this.getDefaultCloseOperation() == 0){
            int op = 0;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Registo?", "Message", JOptionPane.YES_NO_OPTION);
            if(op == JOptionPane.YES_OPTION){
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                new Menu("registo");
            }
        }
        setResizable(false);
    }
    
    private void InterfaceReg2(){
        
        setSize (300, 400); setLocation (300, 150);
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        setTitle("Registo");

        p4 = new JPanel();
        p4.setLayout(null);
        p4.setBackground(Color.WHITE);
        p4.setBounds(0, 0, 300, 400);
        
        nomeD= new JLabel("Nome de Doenca:");
        nomeD.setBounds(20, 10, 300, 30);
        nomeD.setFont(new Font("Segoe UI", Font.BOLD, 15));
        nomeD.setForeground(Color.GRAY);
        
        tf3 = new JTextField(20);
        tf3.setBounds(720, 40, 300, 30);
        tf3.setForeground(Color.GRAY);
        tf3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tf3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        
        contagio = new JLabel("Doenca Contagiosa?:");
        contagio.setBounds(20, 70, 300, 30);
        contagio.setFont(new Font("Segoe UI", Font.BOLD, 15));
        contagio.setForeground(Color.GRAY);
        
        radio = new ButtonGroup(); 
        rS = new JRadioButton("Sim");
        rN = new JRadioButton("Nao");
        rS.setFont(new Font("Segoe UI", Font.BOLD, 15));
        rN.setForeground(Color.GRAY);
        rS.setFont(new Font("Segoe UI", Font.BOLD, 15));
        rN.setForeground(Color.GRAY);
        radio.add(rS);
        radio.add(rN);
        rS.setBounds(20,90,100,30);
        rN.setBounds(70,90,100,30);
        rS.setBackground(null);
        rN.setBackground(null);
        
        b5 = new JButton("Seguinte");
        b5.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b5.setForeground(Color.WHITE);
        b5.setBounds(200, 130, 150, 30);
        b5.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b5.setBackground(new Color(0, 100, 0));
        b5.addActionListener(this);
        
        p4.add(rS);
        p4.add(rN);
        p4.add(nome); p4.add(contagio); p4.add(b5);
        
        add(p4);
        setVisible(true);
        setResizable(true);
        if (this.getDefaultCloseOperation() == 0){
            int op = 0;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Registo?", "Message", JOptionPane.YES_NO_OPTION);
            if(op == JOptionPane.YES_OPTION){
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                new Menu("registo");
            }
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String resp;
        PacController pacControl = new PacController();
        if (e.getSource() == b1){
            int op;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Registo?", "Message", JOptionPane.YES_NO_OPTION);
            if(op == JOptionPane.YES_OPTION)
               // new Menu("registo");
                dispose();
            
        }
        
        if (e.getSource() == b2){
            InterfaceReg1();
            p4.setVisible(false);
        }
        
        
        if (e.getSource() == b4){
            if(p3.isShowing() == true)
                if (tipo.getSelectedItem() == "Cirurgia"){
                    p3.setVisible(false);
                    InterfaceReg2();
                }
            }
            else 
                JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso.");
        
        
        
            if (e.getSource() == b4){
                if (tf2.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Introduza o Nome de Paciente.");
                else{
                    Dados dad = new Dados();
                    resp = dad.resp(tf2.getText());
                    if (resp.equalsIgnoreCase("N")){
                        JOptionPane.showMessageDialog(null, "Paciente Nao Cadastrado No Sistema. Por Favor, Registe o Paciente");
                        p3.setVisible(false);
                        new CadastroPac();
                    }
                }
            
            }
            
            if (e.getSource()== tf2){
                if (tf2.getText().isBlank() == false){
                    try {
                        codigo.addItem(pacControl.getCodPacientes(tf2.getText()));
                    } catch (SQLException ex) {
                        Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        
        
        
            
    }

    
}
