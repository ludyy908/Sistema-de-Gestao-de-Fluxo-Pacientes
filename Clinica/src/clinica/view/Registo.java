/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import clinica.controller.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ludmila Mucavele
 */
public class Registo extends JDialog implements ActionListener, ItemListener, MouseListener {
    private JLabel medico, dataC, horaC, nomeD, l1, l2, pontos, codP, codM;
    private JTextField tf1, tf2, tf3;
    private JSpinner mes, ano, dia, horas, minutos;
    private JComboBox tipo, codigoP, codigoM;
    private JPanel p1, p2, p3, p4;
    private JButton b1, b2, b3, b4, b5, b6;
    private JLabel nrC, estado, nome, contagio;
    JRadioButton rS, rN;
    ButtonGroup radio;
    private Container c;
    private String nomeP, nomeM, data, hora, estad, nomed, contag;
    int m, codC, codPac, codMed, codDoe;
    private final String[] mess;
   
    
    public Registo(){
        
    setModal(true);
    setTitle("Registo");
    setSize (500, 590); setLocation (500, 100);
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
    p2.setBounds(0, 75, 700, 625);
    p2.setBackground(Color.WHITE);
    
    l2 = new JLabel ("Tipo de Registo:");
    l2.setBounds(70, 10, 300, 30);
    l2.setFont(new Font("Segoe UI", Font.BOLD, 15));
    l2.setForeground(Color.GRAY);
    
    tipo = new JComboBox(new String[]{"Consulta", "Cirurgia"});
    tipo.setBackground(Color.WHITE);
    tipo.setBounds(70, 47, 300,35);
    tipo.setFocusable(false);
    tipo.setFont(new Font("Segoe UI", Font.BOLD, 16));
    tipo.setSelectedIndex(0);
    tipo.addItemListener(this);
    
    
    medico = new JLabel ("Nome do Medico Que Realizara a Consulta:");
    medico.setBounds(70, 87, 350, 30);
    medico.setFont(new Font("Segoe UI", Font.BOLD, 16));
    medico.setForeground(Color.GRAY);
   
    
    tf1 = new JTextField(20);
    tf1.setBounds(70, 115, 300, 30);
    tf1.setForeground(Color.GRAY);
    tf1.setText("Introduza o Nome Completo");
    tf1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    tf1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    tf1.addMouseListener(this);
    
    codM = new JLabel ("Codigo de Medico / Medicos de Mesmo Nome:");
    codM.setBounds(70, 155, 500, 30);
    codM.setFont(new Font("Segoe UI", Font.BOLD, 15));
    codM.setForeground(Color.GRAY);
        
    codigoM = new JComboBox();
    codigoM.setBackground(Color.WHITE);
    codigoM.setBounds(70, 195, 300,35);
    codigoM.setFocusable(false);
    codigoM.setFont(new Font("Segoe UI", Font.BOLD, 16));
    codigoM.addActionListener(this);
    
    
    dataC = new JLabel ("Data:");
    dataC.setBounds(70, 235, 300, 30);
    dataC.setFont(new Font("Segoe UI", Font.BOLD, 15));
    dataC.setForeground(Color.GRAY);
    
    String [] anoo = new String[2];
    anoo[0]= "2022"; anoo[1]="2023";
    SpinnerListModel listaAno = new SpinnerListModel(anoo);
    ano = new JSpinner (listaAno);
    ano.setBounds(250, 260, 80, 30);
    ano.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    ano.setForeground(Color.GRAY);
    ano.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    
    mess = new String[]{"Janeiro","Fevereiro","Marco","Abril","Maio","Junho",
        "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
    SpinnerListModel listaMes = new SpinnerListModel(mess);
    mes = new JSpinner (listaMes);
    mes.setBounds(140, 260, 100, 30);
    mes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    mes.setForeground(Color.GRAY);
    mes.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    
    String[] diaa = new String [31];
    for (int i = 0; i < 31; i++)
        diaa[i]= Integer.toString(i+1);
    SpinnerListModel listaDia = new SpinnerListModel(diaa);
    dia = new JSpinner (listaDia);
    dia.setBounds(70, 260, 60, 30);
    dia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    dia.setForeground(Color.GRAY);
    dia.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray)); 
    
    horaC = new JLabel ("Horas:");
    horaC.setBounds(70, 295, 300, 30);
    horaC.setFont(new Font("Segoe UI", Font.BOLD, 15));
    horaC.setForeground(Color.GRAY);
    
    String[] hora = new String [24];
    for (int i = 0; i < 24; i++)
        hora[i]= Integer.toString(i);
    SpinnerListModel listaHora = new SpinnerListModel(hora);
    horas = new JSpinner (listaHora);
    horas.setBounds(70, 325, 60, 30);
    horas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    horas.setForeground(Color.GRAY);
    horas.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    
    String[] minuto = new String [60];
    for (int i = 0; i < 60; i++)
        minuto[i]= Integer.toString(i);
    SpinnerListModel listaMinuto = new SpinnerListModel(minuto);
    minutos = new JSpinner (listaMinuto);
    minutos.setBounds(140, 325, 60, 30);
    minutos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    minutos.setForeground(Color.GRAY);
    minutos.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    minutos.setName("Minutos");
    
    pontos = new JLabel (":");
    pontos.setBounds(130,325, 100, 30);
    pontos.setFont(new Font("Segoe UI", Font.BOLD, 15));
    pontos.setForeground(Color.GRAY);

    b1 = new JButton("Cancelar");
    b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
    b1.setForeground(Color.WHITE);
    b1.setBounds(50, 395, 175, 30);
    b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
    b1.setBackground(new Color(255, 0, 0));
    b1.setBorderPainted(false);
    b1.addActionListener(this);
    
    b2 = new JButton("Seguinte");
    b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
    b2.setForeground(Color.WHITE);
    b2.setBounds(270, 395, 175, 30);
    b2.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
    b2.setBackground(new Color(0, 100, 0));
    b2.setBorderPainted(false);
    b2.addActionListener(this);
   
    
    p2.add(horaC); p2.add(horas); p2.add(minutos); p2.add(dataC);
    p2.add(dia); p2.add(mes); p2.add(ano); p2.add(pontos); p2.add(b1);
    p2.add(b2);  p2.add(medico); p2.add(tf1); p2.add(l2); p2.add(tipo);
    p2.add(codigoM); p2.add(codM);
    
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
        setSize (500, 375); setLocation (450, 180);
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        setTitle("Registo");
        setModal(true);

        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(Color.WHITE);
        p3.setBounds(0, 0, 700, 700);
        
        nrC = new JLabel();
        nrC.setBounds(20, 10, 300, 30);
        nrC.setFont(new Font("Segoe UI", Font.BOLD, 15));
        nrC.setForeground(Color.GRAY);
        
        estado = new JLabel("Estado de "+tipo.getSelectedItem().toString()+": Activo");
        estado.setBounds(20, 50, 300, 30);
        estado.setFont(new Font("Segoe UI", Font.BOLD, 15));
        estado.setForeground(Color.GRAY);
        
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(20, 100, 440, 30);
        
        nome = new JLabel ("Nome do Paciente:");
        nome.setBounds(20, 110, 300, 30);
        nome.setFont(new Font("Segoe UI", Font.BOLD, 15));
        nome.setForeground(Color.GRAY);
        
        
        tf2 = new JTextField(20);
        tf2.setBounds(20, 140, 300, 30);
        tf2.setForeground(Color.GRAY);
        tf2.setText("Introduza o Nome Completo");
        tf2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tf2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tf2.addActionListener(this);
        tf2.addMouseListener(this);
        
        codP = new JLabel ("Codigo de Paciente / Pacientes Cadrastrados de Mesmo Nome:");
        codP.setBounds(20, 180, 500, 30);
        codP.setFont(new Font("Segoe UI", Font.BOLD, 15));
        codP.setForeground(Color.GRAY);
        
        codigoP = new JComboBox();
        codigoP.setBackground(Color.WHITE);
        codigoP.setBounds(20, 220, 270,25);
        codigoP.addActionListener(this);
        codigoP.addItemListener(this);
    
    
        b3 = new JButton("Voltar");
        b3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b3.setForeground(Color.WHITE);
        b3.setBounds(70, 280, 150, 30);
        b3.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b3.setBackground(new Color(255, 0, 0));
        b3.setBorderPainted(false);
        b3.addActionListener(this);

        b4 = new JButton("Seguinte");
        b4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b4.setForeground(Color.WHITE);
        b4.setBounds(250, 280, 150, 30);
        b4.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b4.setBackground(new Color(0, 100, 0));
        b4.setBorderPainted(false);
        b4.addActionListener(this);
        
        p3.add(b3); p3.add(b4); p3.add(nome); p3.add(tf2); p3.add(nrC); p3.add(estado); 
        p3.add(separador); p3.add(codigoP); p3.add(codP);
         
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
        
        setSize (400,285); setLocation (700, 400);
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        setTitle("Registo");
        setModal(true);

        p4 = new JPanel();
        p4.setLayout(null);
        p4.setBackground(Color.WHITE);
        p4.setBounds(0, 0, 400, 285);
        
        nomeD= new JLabel("Nome de Doenca:");
        nomeD.setBounds(20, 10, 300, 30);
        nomeD.setFont(new Font("Segoe UI", Font.BOLD, 15));
        nomeD.setForeground(Color.GRAY);
        
        tf3 = new JTextField(20);
        tf3.setBounds(20, 40, 300, 30);
        tf3.setForeground(Color.GRAY);
        tf3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tf3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        
        contagio = new JLabel("Doenca Contagiosa?:");
        contagio.setBounds(20, 80, 300, 30);
        contagio.setFont(new Font("Segoe UI", Font.BOLD, 15));
        contagio.setForeground(Color.GRAY);
        
        radio = new ButtonGroup(); 
        
        rS = new JRadioButton("Sim");
        rN = new JRadioButton("Nao");
        rS.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        rN.setForeground(Color.GRAY);
        rS.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        rN.setForeground(Color.GRAY);
        rS.setBounds(20,110,100,30);
        rN.setBounds(90,110,100,30);
        rS.setBackground(null);
        rN.setBackground(null);
        radio.add(rS);
        radio.add(rN);
       
        
        
        b5 = new JButton("Seguinte");
        b5.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b5.setForeground(Color.WHITE);
        b5.setBounds(210, 170, 150, 30);
        b5.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b5.setBackground(new Color(0, 100, 0));
        b5.setBorderPainted(false);
        b5.addActionListener(this);
        
        b6 = new JButton("Voltar");
        b6.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b6.setForeground(Color.WHITE);
        b6.setBounds(30, 170, 150, 30);
        b6.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b6.setBackground(new Color(255, 0, 0));
        b6.setBorderPainted(false);
        b6.addActionListener(this);
        
        p4.add(rS); p4.add(rN);
        p4.add(nomeD); p4.add(contagio); p4.add(b5); p4.add(b6); p4.add(tf3);
        
        
        Container c = getContentPane();
        c.setLayout(null);
        c.add(p4);
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
    public void actionPerformed(ActionEvent e)  {
        Validacao va = new Validacao();
        PacController pacControl = new PacController();
        MedController medControl = new MedController();
        AgendaControl agenda;
        ConsultaControl con;
        CirurgiaControl cir;
        DoencaControl doenca = new DoencaControl();
        
        
        
        if (e.getSource() == b1){
            int op;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Registo?", "Message", JOptionPane.YES_NO_OPTION);
            if(op == JOptionPane.YES_OPTION)
                dispose();
                
            
        }
        
        if (e.getSource() == b2)
            if(p2.isShowing() == true){
                
            try {
                nomeM = va.validarString(3, 30, tf1.getText());
            } catch (IOException ex) {
                Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
            }
                    if(this.codigoM.getSelectedItem() == null)
                        codMed = 0;
                    else
                        codMed = Integer.parseInt(this.codigoM.getSelectedItem().toString());
                    
                    if ( dia.getValue() == null || mes.getValue() == null || ano.getValue() == null)
                        JOptionPane.showMessageDialog(null, "Introduza Todos os Dados.");
                    else{
                        m = 0;
                        for (int i = 0; i < mess.length; i++)
                            if (mes.getValue().toString().equalsIgnoreCase(mess[i]))
                                m = i+1;
                        try {
                            data = va.validarData(Integer.parseInt(dia.getValue().toString()),
                                    m, Integer.parseInt(ano.getValue().toString()));
                        
                        hora = va.validarHora(Integer.parseInt(horas.getValue().toString()), 
                            Integer.parseInt(minutos.getValue().toString()));
                        } catch (IOException ex) {
                                                    Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                        if (medControl.verificarDataAgenda(codMed, data, hora) == null)
                            JOptionPane.showMessageDialog(null, "Medico Nao Disponivel Nesta Hora.");
                        else{
                            codC = va.gerarCodigo();
                            estad = "Activo";
                            if (nomeM.isEmpty() || codMed == 0)
                                JOptionPane.showMessageDialog(null, "Introduza Todos os Dados.");
                            else{
                                if (tipo.getSelectedItem() == "Cirurgia"){
                                    p2.setVisible(false); p1.setVisible(false);
                                    InterfaceReg2();
                                    }
                                else
                                    if (tipo.getSelectedItem() == "Consulta"){
                                        p2.setVisible(false); p1.setVisible(false);
                                        InterfaceReg1();
                                        nrC.setText("Numero de "+tipo.getSelectedItem().toString()+": "+codC);
                                    }
                            }
                        }
                    }
               
                                
            }        
                         
        
        if(e.getSource() == b5){
            try {
                nomed = va.validarString(3, 30, tf3.getText());
            } catch (IOException ex) {
                Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
            }
                codDoe = doenca.getDoenca(nomed);
                contag = null;
                if (rS.isSelected())
                    contag = "Sim";
                if (rN.isSelected())
                    contag = "Nao";
                
                if(nomed == null|| contag == null)
                    JOptionPane.showMessageDialog(null, "Introduza os Dados de Doenca.");
                else{
                    if (codDoe != 0)
                        new DoencaControl (codDoe, nomed, contag);
                    p4.setVisible(false);
                    codC = va.gerarCodigo();
                    InterfaceReg1();
                    nrC.setText("Numero de "+tipo.getSelectedItem().toString()+": "+codC);
                }
        }
        
        if (e.getSource() == b6){
            p2.setVisible(true); p1.setVisible(true);
            setSize(500, 590); setLocation (400, 150);
            p4.setVisible(false);
        }
                    
        
        if (e.getSource() == b4){
            try {
                nomeP = va.validarString(3, 30, tf2.getText());
                if(nomeP.isEmpty())
                    JOptionPane.showMessageDialog(null, "Introduza o Nome de Paciente.");
                else{
                    if(codigoP.getSelectedItem()== null){
                        JOptionPane.showMessageDialog(null, "Paciente Nao Cadastrado No Sistema. Por Favor, Registe o Paciente");
                        p3.setVisible(true);
                        codPac = va.gerarCodigo();
                        new CadastroPac(codPac);
                        if (tipo.getSelectedItem() == "Consulta"){
                            con = new ConsultaControl(codPac, nomeP , nomeM, hora, data, estad, codC, codMed);
                            agenda = new AgendaControl(va.gerarCodigo(), codMed, data, hora, "Consulta");
                        }  
                        if (tipo.getSelectedItem() == "Cirurgia"){
                            cir = new CirurgiaControl(codPac, nomeP , nomeM, hora, data, estad, codC, codMed);
                            agenda = new AgendaControl(va.gerarCodigo(), codMed, data, hora, "Cirurgia");
                        }
                        dispose();
                    }
                    else{
                        codPac = Integer.parseInt(codigoP.getSelectedItem().toString());
                        JOptionPane.showMessageDialog(null, "Paciente Cadastrado No Sistema. "+tipo.getSelectedItem().toString()+" Registada com Sucesso.");
                        
                        if (tipo.getSelectedItem() == "Consulta"){
                            con = new ConsultaControl(codPac, nomeP , nomeM, hora, data, estad, codC, codMed);
                            agenda = new AgendaControl(va.gerarCodigo(), codMed, data, hora, "Consulta");
                        }  
                        if (tipo.getSelectedItem() == "Cirurgia"){
                            cir = new CirurgiaControl(codPac, nomeP , nomeM, hora, data, estad, codC, codMed);
                            agenda = new AgendaControl(va.gerarCodigo(), codMed, data, hora, "Cirurgia");
                        }
                        dispose();
                    }      
                }
            } catch (IOException ex) {
                Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        
        if (e.getSource() == b3){
            if (tipo.getSelectedItem() == "Cirurgia"){
                p4.setVisible(true);
                setSize(400, 285); setLocation (450, 180);
            }
            else{
                p1.setVisible(true); p2.setVisible(true);
                setSize(500, 590); setLocation (400, 150);
            }
        }
            
            
            
            
            
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        
            if (e.getSource() == tipo)
                if (tipo.getSelectedItem().toString().equalsIgnoreCase("Cirurgia"))
                    medico.setText("Nome do Medico Que Realizara a Cirurgia:");
                else
                    medico.setText("Nome do Medico Que Realizara a Consulta:");
            
        
    }
    
    /**
     *
     * @param e
     */
   
    @Override
        public void mouseExited(MouseEvent e) {
            MedController medControl = new MedController();  
            PacController pacControl = new PacController();
            ArrayList <Integer> arr = new ArrayList <>();
            
            if (e.getSource() == tf1){
                codigoM.removeAllItems();
                    if (tf1.getText().isBlank() == false){
                        arr = medControl.getCodMed(tf1.getText());
                        for(int i = 0; i < arr.size(); i++)
                            codigoM.addItem(arr.get(i));
                    }
                }
            
            if (e.getSource()== tf2){
                codigoP.removeAllItems();
                if (tf2.getText().isEmpty() == false){
                    try {
                        arr = pacControl.getCodPacientes(tf2.getText());
                        for(int i = 0; i < arr.size(); i++)
                            codigoP.addItem(arr.get(i));
                    } catch (SQLException ex) {
                        Logger.getLogger(Registo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tf1){
            tf1.setText("");
        }
        
        if (e.getSource() == tf2){
            tf2.setText("");
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

    
    
}
