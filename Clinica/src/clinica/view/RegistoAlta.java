/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;

import clinica.controller.AltaPacienteControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import clinica.controller.MedController;
import clinica.controller.PacController;
import clinica.controller.Validacao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import clinica.controller.InterControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Amarilda Chihepe
 */
public class RegistoAlta extends JDialog implements ActionListener, ItemListener, MouseListener{
    
    JLabel lId, ldata, lMedico, lTitulo, l1, lNomePac;
    JTextField tfId, tfMedico, tfPac;
   String [] mes = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    String[] ano = {"2021","2022"};
    String [] medico,pacId;
    JComboBox  comboMes, comboAno, comboMedico, comboId;
    JPanel p1, painel2,painel1, painelPrinc;
    JButton bSalvar, bCancel;
    JSpinner dia, sMes, sAno;
    MedController mc = new MedController();
    InterControl i = new InterControl();
    PacController pc = new PacController();
    String data;


    public RegistoAlta() {
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("paciente");
        }
        
        setModal(true);
        setBounds(430,130,550, 500);
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
        
        lNomePac = new JLabel ("Nome do Paciente:");
        lNomePac.setBounds(70, 150, 300, 30);
        lNomePac.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lNomePac.setForeground(Color.GRAY);
        painel1.add(lNomePac);
        
        ldata = new JLabel("Data da alta:");
        ldata.setBounds(70,220,100,20);
        ldata.setFont(new Font("Segoe UI", Font.BOLD, 15));
        ldata.setForeground(Color.GRAY);
        painel1.add(ldata);
        
        lMedico = new JLabel("Medico Responsavel:");
        lMedico.setBounds(70,290,150,20);
        lMedico.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lMedico.setForeground(Color.GRAY);
        painel1.add(lMedico);
        
        tfId = new JTextField();
        tfId.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tfId.setBounds(70, 110,70,23);
        //painel1.add(tfId);
        
        medico = new String[mc.getMedico().size()];
        for(int i =0; i<mc.getMedico().size();i++){
            medico[i] = mc.getMedico().get(i);
        }
        
        comboMedico = new JComboBox(medico);
        comboMedico.setBackground(null);
        comboMedico.setBounds(70,320,270,36);
        comboMedico.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboMedico.setForeground(Color.GRAY);
        comboMedico.setFocusable(false);
        painel1.add(comboMedico);
        
        pacId = new String[pc.getIds().size()];
        for(int i =0; i<pc.getIds().size();i++){
           pacId[i] = pc.getIds().get(i).toString();
        }
        
        comboId = new JComboBox(pacId);
        comboId.setBackground(null);        
        comboId.setBounds(70, 110,130,31);
        comboId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboId.setForeground(Color.GRAY);
        comboId.addItemListener(this);
        comboId.setFocusable(false);
        painel1.add(comboId);
        
        tfPac = new JTextField();
        tfPac.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tfPac.setBounds(70, 180,270,23); 
        tfPac.setFont(new Font("Segoe UI", Font.PLAIN,15));
        tfPac.addMouseListener(this);
        painel1.add(tfPac);
        
        //Definr a data        
 
        dia = new JSpinner(new SpinnerNumberModel(1,1,31,1));
        dia.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        dia.setBounds(70,250,50,25);
        dia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        dia.setForeground(Color.GRAY);
        painel1.add(dia);
        
        sMes = new JSpinner(new SpinnerNumberModel(1,1,12,1));
        //sMes = new JSpinner(new SpinnerListModel(mes));
        sMes.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        sMes.setBounds(150,250,100,25);
        sMes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        sMes.setForeground(Color.GRAY);
        painel1.add(sMes);
        
        sAno = new JSpinner(new SpinnerListModel(ano));
        sAno.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        sAno.setBounds(270,250,70,25);
        sAno.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        sAno.setForeground(Color.GRAY);
        
        painel1.add(sAno);
        
        bSalvar = new JButton("Salvar");
        bSalvar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        bSalvar.setForeground(Color.WHITE);
        bSalvar.setBounds(270, 390, 175, 30);
        bSalvar.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        bSalvar.setBackground(new Color(0, 100, 0));
        bSalvar.setBorderPainted(false);
        bSalvar.setFocusable(false);
        bSalvar.addActionListener(this);
        
        bCancel = new JButton("Cancelar");
        bCancel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        bCancel.setForeground(Color.WHITE);
        bCancel.setBounds(50, 390, 175, 30);
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
      //O nome do paciente no campo de texto ira aparecer de acordo com o id selecionado no comboBox, este evento cuida disso
    public void itemStateChanged(ItemEvent e) {
        
        if(e.getSource() == comboId){
            int id = Integer.parseInt(comboId.getSelectedItem().toString());
            tfPac.setText(pc.getPacNome(id));
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Validacao va = new Validacao();
        if(e.getSource() == bCancel){
            int op = 0;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Registo?", "Mensagem de Confirmacao", JOptionPane.YES_NO_OPTION);
            if(op == JOptionPane.YES_OPTION){
                dispose();
                
            }
        }
        if(e.getSource() == bSalvar){
            int codPac = Integer.parseInt(comboId.getSelectedItem().toString());
            int codFunc, idAlta; String nomeMed;
            idAlta = va.gerarCodigo();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           
            try {
                data = va.validarData(Integer.parseInt(dia.getValue().toString()),
                        Integer.parseInt(sMes.getValue().toString()), Integer.parseInt(sAno.getValue().toString()));
            } catch (IOException ex) {
                Logger.getLogger(RegistoAlta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String dataInter = i.getD(codPac);
                
            try {
                Date dA = (Date) sdf.parse(data);
                Date dInter = (Date) sdf.parse(dataInter);
            } catch (ParseException ex) {
                Logger.getLogger(RegistoAlta.class.getName()).log(Level.SEVERE, null, ex);
            }
            nomeMed = comboMedico.getSelectedItem().toString();
            codFunc = mc.getIdMed(nomeMed);

            if(tfPac.getText().isEmpty() || tfPac.getText() == null)
                JOptionPane.showMessageDialog(null, "Por Favor, Preencha Todos Campos.");
            else{          
                new AltaPacienteControl(idAlta, data, codPac, codFunc);
                JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso ");
                i.InterRemove(codPac);
                tfPac.setText("");

            }
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
                        for(int i = 0; i < arr.size(); i++)
                            comboId.addItem(arr.get(i));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegistoAlta.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
