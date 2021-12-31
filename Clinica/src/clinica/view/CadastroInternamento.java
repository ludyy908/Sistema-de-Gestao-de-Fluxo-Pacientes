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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


/**
 *
 * @author Amarilda Chihepe
 */
public class CadastroInternamento extends JDialog implements ActionListener{
    
    JLabel lId, ldata, lMedico, lTitulo, imgPac, ldoenca;
    JTextField tfId, tfMedico, tfdoenca;
    String [] mes = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Stembro", "Outubro", "Novembro", "Dezembro"};
    String[] ano = {"2021","2022"};
    JComboBox  comboMes, comboAno, comboMedico;
    String [] medico = {"Medico1", "Medico2", "MedicoN"}; //Nomes dos medicos que serao carrgeados da base de dado
    JPanel painel1, painel2,painel3, painelPrinc;
    JButton bSalvar, bCancel;
    JSpinner dia, sMes, sAno;
  //  JDateChooser data;

    public CadastroInternamento() {
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("paciente");
        }
        setBounds(300,100, 500, 500);
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
        ldata.setBounds(70,150,100,20);
        ldata.setFont(new Font("Segoe UI", Font.BOLD, 15));
        ldata.setForeground(Color.GRAY);
        painel1.add(ldata);
        
        lMedico = new JLabel("Enfermeiro Responsavel:");
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
        
        ldoenca = new JLabel("Doenca do Paciente:");
        ldoenca.setBounds(70,290,150,20);
        ldoenca.setFont(new Font("Segoe UI", Font.BOLD, 15));
        ldoenca.setForeground(Color.GRAY);
        painel1.add(ldoenca);
        
     
                                                                                              
        painel1.add(comboMedico);
        
        tfdoenca  = new JTextField();
        tfdoenca.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tfdoenca.setBounds(70,320,270,23);
        painel1.add(tfdoenca);
               
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
        bSalvar.setBounds(270, 400, 175, 30);
        bSalvar.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        bSalvar.setBackground(new Color(0, 100, 0));
        bSalvar.setBorderPainted(false);
        bSalvar.setFocusable(false);
        bSalvar.addActionListener(this);
        
        bCancel = new JButton("Cancelar");
        bCancel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        bCancel.setForeground(Color.WHITE);
        bCancel.setBounds(50, 400, 175, 30);
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
         if(e.getSource() == bCancel){
            int op = 0;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Registo?", "Mensagem de Confirmacao", JOptionPane.YES_NO_OPTION);
            if(op == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
        if(e.getSource() == bSalvar){
            if(tfId.getText().isEmpty() || tfdoenca.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Por Favor Preencha Todos Campos.");
            }else{
                //Chamar o metodo que grava os dados na base de dados
                 JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso.");
                 tfId.setText("");
                 tfMedico.setText("");
                 tfdoenca.setText("");
                 
            }
        }    
    }
    
    
    
    
    
}
