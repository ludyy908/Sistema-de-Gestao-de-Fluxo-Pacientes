/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


/**
 *
 * @author Amarilda Chihepe
 */
public class RegistoAlta extends JDialog implements ActionListener{
    
    JLabel lId, ldata, lMedico, lTitulo, l1;
    JTextField tfId, tfMedico;
    String [] mes = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    String[] ano = {"2021","2022"};
    String [] medico = {"Medico1", "Medico2", "MedicoN"}; //Nomes dos medicos que serao carrgeados da base de dados
    JComboBox  comboMes, comboAno, comboMedico;
    JPanel p1, painel2,painel1, painelPrinc;
    JButton bSalvar, bCancel;
    JSpinner dia, sMes, sAno;
  //  JDateChooser data;

    public RegistoAlta() {
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("paciente");
        }
        setSize(500, 430);
        setResizable(false);
        setTitle("Registo de Alta");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage()); 
        
        p1 = new JPanel ();
        p1.setLayout(null);
        p1.setBackground(new Color(8,84, 121));
        p1.setBounds(0, 0, 700, 75);
        

        l1 = new JLabel("Registo de Paciente Com Alta"); 
        l1.setBounds(70,0, 400, 75); 
        l1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 28));
        l1.setForeground(Color.black);
        
        p1.add(l1);
        
        painel1 = new JPanel();
        painel1.setLayout(null);
        painel1.setBackground(new Color(255,255,255));
     
        lId = new JLabel ("Codigo de Paciente:");
        lId.setBounds(70, 80, 300, 30);
        lId.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lId.setForeground(Color.GRAY);
        painel1.add(lId);
        
        ldata = new JLabel("Data da alta:");
        ldata.setBounds(70,150,100,20);
        ldata.setFont(new Font("Segoe UI", Font.BOLD, 15));
        ldata.setForeground(Color.GRAY);
        painel1.add(ldata);
        
        lMedico = new JLabel("Medico Responsavel:");
        lMedico.setBounds(70,220,150,20);
        lMedico.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lMedico.setForeground(Color.GRAY);
        painel1.add(lMedico);
        
        tfId = new JTextField();
        tfId.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tfId.setBounds(70, 110,70,23);
        painel1.add(tfId);
        
        comboMedico = new JComboBox(medico);
        comboMedico.setBackground(null);
        tfMedico = new JTextField();
        tfMedico.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        comboMedico.setBounds(70,250,270,23);
        comboMedico.setFont(new Font("Segoe UI", Font.BOLD, 15));
        comboMedico.setForeground(Color.GRAY);
        painel1.add(comboMedico);
        
        //Definr a data        
 
        dia = new JSpinner(new SpinnerNumberModel(1,1,31,1));
        dia.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        dia.setBounds(70,180,50,23);
        dia.setFont(new Font("Segoe UI", Font.BOLD, 15));
        dia.setForeground(Color.GRAY);
        painel1.add(dia);
        
        sMes = new JSpinner(new SpinnerListModel(mes));
        sMes.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        sMes.setBounds(150,180,100,23);
        sMes.setFont(new Font("Segoe UI", Font.BOLD, 15));
        sMes.setForeground(Color.GRAY);
        painel1.add(sMes);
        
        sAno = new JSpinner(new SpinnerListModel(ano));
        sAno.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        sAno.setBounds(270,180,70,23);
        sAno.setFont(new Font("Segoe UI", Font.BOLD, 15));
        sAno.setForeground(Color.GRAY);
        
        painel1.add(sAno);
        
        bSalvar = new JButton("Salvar");
        bSalvar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        bSalvar.setForeground(Color.WHITE);
        bSalvar.setBounds(270, 320, 175, 30);
        bSalvar.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        bSalvar.setBackground(new Color(0, 100, 0));
        bSalvar.setBorderPainted(false);
        bSalvar.setFocusable(false);
        bSalvar.addActionListener(this);
        
        bCancel = new JButton("Cancelar");
        bCancel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        bCancel.setForeground(Color.WHITE);
        bCancel.setBounds(50, 320, 175, 30);
        bCancel.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        bCancel.setBackground(new Color(255, 0, 0));
        bCancel.setForeground(Color.white);
        bCancel.addActionListener(this);
        bCancel.setBorderPainted(false);
        bCancel.setFocusable(false);
        
        painel1.add(bSalvar);
        painel1.add(bCancel);
        
      
       painel1.add(p1);
       add(painel1);
 
         show();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == bCancel){
            int op = 0;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Registo?", "Mensagem de Confirmacao", JOptionPane.YES_NO_OPTION);
            if(op == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
        if(e.getSource() == bSalvar){
            if(tfId.getText().isEmpty() || tfMedico.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Por Favor Preencha Todos Campos.. ");
            }else{
                //Chamar o metodo que grava os dados na base de dados
                 JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso ");
                 tfId.setText("");
                 tfMedico.setText("");
                 
            }
        }    
    }
        
    
    
    
    
    
}
