/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;

import clinica.controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


/**
 *
 * @author Amarilda Chihepe
 */
public class CadastroInternamento extends JDialog implements ActionListener, ItemListener, MouseListener{
    
    JLabel lId, ldata, lMedico, lTitulo, imgPac, ldoenca, lNomePac;
    JTextField tfId, tfMedico,tfdoenca, tfPac;
    String [] mes = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Stembro", "Outubro", "Novembro", "Dezembro"};
    String[] ano = {"2022","2021"};
    JComboBox  comboMes, comboAno,comboId, comboMedico;
    String [] medico ,pacId; 
    JPanel painel1, painel2,painel3, painelPrinc;
    JButton bSalvar, bCancel;
    JSpinner dia, sMes, sAno;
    MedController mc = new MedController();
    PacController pc = new PacController();
    EnfControl ec = new EnfControl();
    String data, doenca;

    public CadastroInternamento() {
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("paciente");
        }
          setModal(true);
        setBounds(435,110, 520, 550);
        setResizable(false);
        setTitle("Registo de Pacientes Internados");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage()); 
        
       painel3 = new JPanel();
       painel3.setLayout(null);
       painel3.setBounds(0,0,870,75);
       painel3.setBackground(new Color(8,84, 121));
     
       
        imgPac = new JLabel("Registo de Paciente Internado"); 
        imgPac.setBounds(70,0, 400, 75); 
        imgPac.setFont(new Font("Imprint MT Shadow", Font.BOLD, 28));
        imgPac.setForeground(Color.black);
        
             
       painel3.add(imgPac);
        
        painel1 = new JPanel();
        painel1.setLayout(null);
        painel1.setBackground(new Color(255,255,255));
      
        lId = new JLabel ("Codigo de Paciente:");
        lId.setBounds(70, 80, 300, 30);
        lId.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lId.setForeground(Color.GRAY);
        painel1.add(lId);
        
        ldata = new JLabel("Data de Internamento:");
        ldata.setBounds(70,220,250,20);
        ldata.setFont(new Font("Segoe UI", Font.BOLD, 15));
        ldata.setForeground(Color.GRAY);
        painel1.add(ldata);
        
        lMedico = new JLabel("Enfermeiro Responsavel Pelo Paciente Internado:");
        lMedico.setBounds(70,290,450,37);
        lMedico.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lMedico.setForeground(Color.GRAY);
        painel1.add(lMedico);
        
        tfId = new JTextField();
        tfId.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tfId.setBounds(70, 110,70,23);
        //painel1.add(tfId);
        
        pacId = new String[pc.getIdInter().size()];
        for(int i =0; i<pc.getIdInter().size();i++){
           pacId[i] = pc.getIdInter().get(i).toString();
        }
        
        comboId = new JComboBox(pacId);
        comboId.setBackground(null);        
        comboId.setBounds(70, 110,100,30);
        comboId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboId.setForeground(Color.GRAY);
        comboId.addItemListener(this);
        painel1.add(comboId);
        
        lNomePac = new JLabel ("Nome do Paciente:");
        lNomePac.setBounds(70, 150, 300, 30);
        lNomePac.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lNomePac.setForeground(Color.GRAY);
        painel1.add(lNomePac);
        
        tfPac = new JTextField();
        tfPac.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tfPac.setBounds(70, 180,270,23); 
        tfPac.setFont(new Font("Segoe UI", Font.PLAIN,17));
        painel1.add(tfPac);
        tfPac.addMouseListener(this);
        
        //Definr a data        
        dia = new JSpinner(new SpinnerNumberModel(1,1,31,1));
        dia.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        dia.setBounds(70,250,50,25);
        dia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        dia.setForeground(Color.GRAY);
        dia.setFocusable(false);
        painel1.add(dia);
        
        //sMes = new JSpinner(new SpinnerListModel(mes));
        sMes = new JSpinner(new SpinnerNumberModel(1,1,12,1));
        sMes.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        sMes.setBounds(150,250,100,25);
        sMes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        sMes.setForeground(Color.GRAY);
        sMes.setFocusable(false);
        painel1.add(sMes);
        
        sAno = new JSpinner(new SpinnerListModel(ano));
        sAno.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        sAno.setBounds(270,250,70,25);
        sAno.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        sAno.setForeground(Color.GRAY);
        sAno.setFocusable(false);
        
        //Enfemeiro
        medico = new String[ec.getEnfs().size()];
        for(int i =0; i<ec.getEnfs().size();i++){
            medico[i] = ec.getEnfs().get(i);
        }
        
        comboMedico = new JComboBox(medico);
        comboMedico.setBackground(null);
        comboMedico.setBounds(70,320,270,30);
        comboMedico.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboMedico.setForeground(Color.GRAY);
        comboMedico.setFocusable(false);
        painel1.add(comboMedico);
        
        
        
        ldoenca = new JLabel("Doenca do Paciente:");
        ldoenca.setBounds(70,360,150,20);
        ldoenca.setFont(new Font("Segoe UI", Font.BOLD, 15));
        ldoenca.setForeground(Color.GRAY);
        painel1.add(ldoenca);
        
     
                                                                                              
        painel1.add(comboMedico);
        
        tfdoenca  = new JTextField();
        tfdoenca.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tfdoenca.setBounds(70,390,270,23);
        tfdoenca.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        painel1.add(tfdoenca);
               
        
        
        painel1.add(sAno);
        
        bSalvar = new JButton("Salvar");
        bSalvar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        bSalvar.setForeground(Color.WHITE);
        bSalvar.setBounds(270, 450, 175, 30);
        bSalvar.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        bSalvar.setBackground(new Color(0, 100, 0));
        bSalvar.setBorderPainted(false);
        bSalvar.setFocusable(false);
        bSalvar.addActionListener(this);
        
        bCancel = new JButton("Cancelar");
        bCancel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        bCancel.setForeground(Color.WHITE);
        bCancel.setBounds(50, 450, 175, 30);
        bCancel.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        bCancel.setBackground(new Color(255, 0, 0));
        bCancel.setForeground(Color.white);
        bCancel.addActionListener(this);
        bCancel.setBorderPainted(false);
        bCancel.setFocusable(false);
        
        painel1.add(bSalvar);
        painel1.add(bCancel);
      
       painel1.add(painel3);
       add(painel1);

         show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Validacao va = new Validacao();
        DoencaControl dc = new DoencaControl();
         if(e.getSource() == bCancel){
            int op = 0;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Registo?", "Mensagem de Confirmacao", JOptionPane.YES_NO_OPTION);
            if(op == JOptionPane.YES_OPTION){
                dispose();
            }
        }
         
        if(e.getSource() == bSalvar){
            int idP, idF;
            String  nomeEnf; boolean internado = false;
                
            try {
                data = va.validarData(Integer.parseInt(dia.getValue().toString()), 
                        Integer.parseInt(sMes.getValue().toString()), Integer.parseInt(sAno.getValue().toString()));
            } catch (IOException ex) {
                Logger.getLogger(CadastroInternamento.class.getName()).log(Level.SEVERE, null, ex);
            }
 
            idP = Integer.parseInt(comboId.getSelectedItem().toString());
            try {
                doenca = va.validarString(3, 30, tfdoenca.getText());
                int codDoe = dc.getDoenca(doenca);
                String contag = "Nao";
                
                if (doenca != null && codDoe != 0)
                    new DoencaControl (codDoe, doenca, contag);
                    
            } catch (IOException ex) {
                Logger.getLogger(CadastroInternamento.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                nomeEnf = comboMedico.getSelectedItem().toString();
                idF = ec.getIdEnf(nomeEnf);

                for(int i=0; i<pc.getIds().size();i++){                  
                    if(pc.getIds().get(i) == idP){
                        internado = true;
                    }
                }
                
            if(tfPac.getText().isEmpty() || tfdoenca.getText().isEmpty() || tfPac.getText() == null || tfdoenca.getText() == null ){
                JOptionPane.showMessageDialog(null, "Por Favor Preencha Todos Campos.");
            }else if(internado){
                JOptionPane.showMessageDialog(null, "Paciente Internado Ja Registado.");
            }else{                                              
                new InterControl(data,idP, va.gerarCodigo(), idF, doenca);
                JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso.");
                tfdoenca.setText("");
                tfPac.setText("");
                 
            }
        }    
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == comboId){
                int id = Integer.parseInt(comboId.getSelectedItem().toString());
                tfPac.setText(pc.getPacNomeInter(id));
            }
        }
    
    @Override
    public void mouseExited(MouseEvent e) { 
            PacController pacControl = new PacController();
            ArrayList <Integer> arr = new ArrayList <>();
            
            if (e.getSource()== tfPac){
                comboId.removeAllItems();
                if (tfPac.getText().isEmpty() == false){
                    
                    try {
                        arr = pacControl.getCodPacientes(tfPac.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastroInternamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        for(int i = 0; i < arr.size(); i++)
                            comboId.addItem(arr.get(i));
                    
                }
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}
