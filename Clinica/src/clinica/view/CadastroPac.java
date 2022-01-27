/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import clinica.controller.PacController;
import clinica.controller.Dados;
import clinica.controller.Validacao;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Amarilda Chihepe
 */
public class CadastroPac extends JDialog implements ActionListener{
    
    JTextField tNome, tIdade, tBi,tTel,tNacionalidade, tTelAlt,tApelido;
    JTextArea tend ;
    JLabel lNome, lIdade, lBi, lTel,lTelAlt, lNacionalidade,lApelido, lSexo, lEstado, imgPac, lEnd, lTitulo;
    JTextArea end;
    JComboBox comboEstado;
    String[] estado = {"-- Estado Civil -- ", "Solteiro(a)", "Casado(a)", "Viuvo(a)"};
    JRadioButton radioF, radioM; 
    ButtonGroup grupoRadio;
    JPanel painel1, painel2, painel3;
    JButton bSalvar, bClean,bCancelar,bClose;
    JSpinner idade;
    JProgressBar progresso;
    int idPac;
    

    public CadastroPac(int idPac) {
        this.idPac = idPac;
        setTitle ("Cadastro de Paciente");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage()); 
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("paciente");
        }
        
        setModal(true);
        setBounds(250,70, 870, 590);
        setResizable(false);
        
        //Inicilaizacaco e layouts dos paineis
        painel1 = new JPanel(); 
        painel2 = new JPanel(); 
        
        painel1.setLayout(null);
        painel1.setBounds(30,0,850,720);
        painel1.setBorder(BorderFactory.createEtchedBorder());
        painel1.setBackground(new Color(255,255,255));
            
        painel2.setLayout(null);
        painel2.setBounds(0,0,870,75);
        painel2.setBackground(new Color(8,84, 121));
        
        

        imgPac = new JLabel("Cadastro de Paciente"); 
        imgPac.setBounds(70,0, 400, 75); 
        imgPac.setFont(new Font("Imprint MT Shadow", Font.BOLD, 28));
        imgPac.setForeground(Color.black);
        
       
        painel2.add(imgPac);
    
        
        lApelido = new JLabel("Apelido:");
        lApelido.setBounds(60, 100,70,30);
        lApelido.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lApelido.setForeground(Color.GRAY);
        painel1.add(lApelido);
        
        lNome = new JLabel("Nome:"); 
        lNome.setBounds(60,150,50, 30);
        lNome.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lNome.setForeground(Color.GRAY);
        painel1.add(lNome);
        
        lNacionalidade = new JLabel("Nacionalidade:"); 
        lNacionalidade.setBounds(60,200,130,30);
        lNacionalidade.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lNacionalidade.setForeground(Color.GRAY);
        painel1.add(lNacionalidade);
        
        lIdade = new JLabel("Idade:");
        lIdade.setBounds(500, 100,70,30);
        lIdade.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lIdade.setForeground(Color.GRAY);
        painel1.add(lIdade);
        
        lSexo = new JLabel("Genero:");
        lSexo.setBounds(500,150,80,30);
        lSexo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lSexo.setForeground(Color.GRAY);
        painel1.add(lSexo);
        
        lBi = new JLabel("Numero de BI:");
        lBi.setBounds(60,250,130,30);
        lBi.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lBi.setForeground(Color.GRAY);
        painel1.add(lBi);
        
        lTel = new JLabel("Telefone 1:");
        lTel.setBounds(500,250,100,30);
        lTel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lTel.setForeground(Color.GRAY);
        painel1.add(lTel);
        
        lTelAlt = new JLabel("Telefone 2:");
        lTelAlt.setBounds(500,300,150,30);
        lTelAlt.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lTelAlt.setForeground(Color.GRAY);
        painel1.add(lTelAlt);
       
        lEstado = new JLabel("Estado Civil:");
        lEstado.setBounds(60,300,100,20);
        lEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lEstado.setForeground(Color.GRAY);
        painel1.add(lEstado);
        
       comboEstado = new JComboBox(estado);
       comboEstado.setBounds(190,300,232,35);
       comboEstado.setFocusable(true);
       comboEstado.setBackground(null);
       comboEstado.setFocusable(false);
       comboEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
       comboEstado.setForeground(Color.GRAY);
       painel1.add(comboEstado);
       
       lEnd = new JLabel("Endereco/Morada:");
       lEnd.setBounds(60,350,150,30);
       lEnd.setFont(new Font("Segoe UI", Font.BOLD, 15));
       lEnd.setForeground(Color.GRAY);
       painel1.add(lEnd);
       
       //Definicao dos radios
        grupoRadio = new ButtonGroup(); 
        radioM = new JRadioButton("Masculino");
        radioF = new JRadioButton("Femenino");
        radioF.setFont(new Font("Segoe UI", Font.BOLD, 15));
        radioF.setForeground(Color.GRAY);
        radioM.setFont(new Font("Segoe UI", Font.BOLD, 15));
        radioM.setForeground(Color.GRAY);
        grupoRadio.add(radioF);
        grupoRadio.add(radioM);
        radioF.setBounds(610,150,100,30);
        radioM.setBounds(710,150,100,30);
        radioF.setBackground(null);
        radioM.setBackground(null);
        painel1.add(radioF);
        painel1.add(radioM);
        
        //Iniclaizacao dos campos de texto      
        
        
        tApelido = new JTextField();
        tApelido.setBounds(190,100,230,23);
        tApelido.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tApelido.setFont(new Font("Segoe UI", Font.PLAIN,15));
        painel1.add(tApelido);
        
        tNome = new JTextField();
        tNome.setBounds(190,150,230,23); 
        tNome.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        tNome.setFont(new Font("Segoe UI", Font.PLAIN,15));
        painel1.add(tNome);
        
        tNacionalidade = new JTextField();
        tNacionalidade.setBounds(190,200,230,23);
        tNacionalidade.setFont(new Font("Segoe UI", Font.PLAIN,15));
        tNacionalidade.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        painel1.add(tNacionalidade);
        
        idade = new JSpinner(new SpinnerNumberModel(1,1,100,1));  
        idade.setBounds(610,100,70,30);
        idade.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        painel1.add(idade);
        
        tBi = new JTextField();
        tBi.setBounds(190,250,230,23);
        tBi.setFont(new Font("Segoe UI", Font.PLAIN,15));
        tBi.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        painel1.add(tBi);
        
        tTel = new JTextField();
        tTel.setBounds(610,250,170,23);
        tTel.setFont(new Font("Sigoe UI", Font.PLAIN,15));
        tTel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        painel1.add(tTel);
        
        tTelAlt = new JTextField();
        tTelAlt.setBounds(610,300,170,23);
        tTelAlt.setFont(new Font("Sigoe UI", Font.PLAIN,15));
        tTelAlt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        painel1.add(tTelAlt);
            
        tend = new JTextArea();
        tend.setBounds(200,350,240,60);
        tend.setFont(new Font("Segoe UI", 0,15));
        tend.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        painel1.add(tend);
        
        //Botoes
       bSalvar = new JButton("Salvar");
        bSalvar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        bSalvar.setForeground(Color.WHITE);
        bSalvar.setBounds(450, 480, 175, 30);
        bSalvar.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        bSalvar.setBackground(new Color(0, 100, 0));
        bSalvar.setBorderPainted(false);
        bSalvar.setFocusable(false);
        bSalvar.addActionListener(this);
        painel1.add(bSalvar);
        
        bCancelar = new JButton("Cancelar");
        bCancelar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        bCancelar.setForeground(Color.WHITE);
        bCancelar.setBounds(200, 480, 175, 30);
        bCancelar.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        bCancelar.setBackground(new Color(255, 0, 0));
        bCancelar.setForeground(Color.white);
        bCancelar.addActionListener(this);
        bCancelar.setBorderPainted(false);
        bCancelar.setFocusable(false);
        painel1.add(bCancelar);
        
       painel1.add(painel2);
       add(painel1);
       show();      
        
    }
    
   

    ///Eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        Validacao va = new Validacao();
        if(e.getSource() == bCancelar){
            int op = 0;
            op = JOptionPane.showConfirmDialog(null, "Deseja Cancelar o Cadastro?", "Message", JOptionPane.YES_NO_OPTION);
            if(op == JOptionPane.YES_OPTION){
                dispose();
               // new Menu("paciente");
            }
        }
        if(e.getSource() == bSalvar){
            Random r = new Random();
       
            if (idPac == 0)
            idPac = va.gerarCodigo();
            String nome = tNome.getText();
            String nacionalidade = tNacionalidade.getText();
            String apelido = tApelido.getText();
            String end =  tend.getText();
            String bi = tBi.getText();
            int idad = (Integer) idade.getValue();
            String estadoCivil = comboEstado.getSelectedItem().toString();
            String tel1 = tTel.getText();
            String tel2 = tTelAlt.getText();
            String genero;
            
           
            if(radioF.isSelected()){
                 genero = "Femenino";
            } else{
                genero = "Masculino";
            }
            
            if(tNome.getText().isEmpty() || tApelido.getText().isEmpty()|| tBi.getText().isEmpty() ||   tTel.getText().isEmpty() || 
                 tNacionalidade.getText().isEmpty() || tTelAlt.getText().isEmpty() || tend.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Por Favor Preencha Todos Campos.. ");
            }else{
                //Chamar o metodo que grava os dados na base de dados
                try{
                    PacController pc = new PacController(idPac,nome,nacionalidade, apelido, genero, end, bi, idad,estadoCivil, tel1, tel2);
                    
                }catch (Exception ex) {
                      Logger.getLogger(CadastroPac.class.getName()).log(Level.SEVERE, null, ex);
                }
                 JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso ");
                 
                 tNome.setText("");
                 tApelido.setText("");
                 tBi.setText("");
                 tTel.setText("");
                 tNacionalidade.setText("");
                 tTelAlt.setText(""); 
                 tend.setText("") ;
                 
                 Object ob,SpinerIdade;
                 ob = estado[0];                
                 comboEstado.setSelectedItem(ob);
                 //pinerIdade = "1";
                 //idade.setValue(SpinerIdade);
                 
                 if(radioF.isSelected()){
                     radioF.setSelected(false);
                } else{
                     radioM.setSelected(false);
                }
            }
       
        }
    }
}

