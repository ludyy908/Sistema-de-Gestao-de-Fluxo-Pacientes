/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import clinica.controller.SecretarioControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Ludmila Mucavele
 */

//Nvo Menu

public class Menu implements MouseListener, ActionListener {
    
    final private JFrame frame;
    private JButton home, registo, paciente, medico, enfermagem, logOut1, logOut2;
    private JButton btnPaciente, btnRegisto, btnMedico, btnEnfermeiro;
    private JButton btnAdicionarPaciente, btnPacienteInternado, btnPacienteRecuperado, btnListaPaciente;
    private JButton btnAdicionarMedico, btnMedicoConsulta, btnMedicoCirurgia, btnAgendaMedico, btnListaMedico;
    private JButton btnAdicionarEnfermeiro, btnEnfermeiroActivo, btnListaEnfermeiro, btnPacienteDeEnfermeiro;
    private JButton btnMarcar, btnCancelar, btnListar;
    private JPanel painelEsquerdo, leftPanel, rightPanel, painelPrincipal, painelPaciente, painelMedico, painelEnfermeiro, painelRegisto;
    
    Menu(){
        frame = new JFrame("Menu");
        frame.setSize(1200, 700);
        frame.setIconImage((new ImageIcon(("iconeprincipal.png"))).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        
        menuMedico();
        painelMedico.setVisible(false);
        menuEnfermagem();
        painelEnfermeiro.setVisible(false);
        menuRegisto();
        painelRegisto.setVisible(false);
        menuPaciente();
        painelPaciente.setVisible(false);
        painelEsquerdo();
        painelEsquerdo.setVisible(false);

        menuPrincipal();
        frame.setVisible(true);

    }
    
    //Para que as outras Janelas nao abram o menu principal instataneamente
    public Menu(String menu){
        frame = new JFrame("Menu");
        frame.setSize(1200, 700);
        frame.setIconImage((new ImageIcon(("iconeprincipal.png"))).getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        
        painelEsquerdo();
        painelEsquerdo.setVisible(true);
        
        switch (menu){
            case "medico":
                menuMedico();
                painelMedico.setVisible(true);
                menuEnfermagem();
                painelEnfermeiro.setVisible(false);
                menuRegisto();
                painelRegisto.setVisible(false);
                menuPaciente();
                painelPaciente.setVisible(false);
                menuPrincipal();
                painelPrincipal.setVisible(false);
                break;
            case "enfermeiro":
                menuMedico();
                painelMedico.setVisible(false);
                menuEnfermagem();
                painelEnfermeiro.setVisible(true);
                menuRegisto();
                painelRegisto.setVisible(false);
                menuPaciente();
                painelPaciente.setVisible(false);
                menuPrincipal();
                painelPrincipal.setVisible(false);
                break;
            case "registo":
                menuMedico();
                painelMedico.setVisible(false);
                menuEnfermagem();
                painelEnfermeiro.setVisible(false);
                menuRegisto();
                painelRegisto.setVisible(true);
                menuPaciente();
                painelPaciente.setVisible(false);
                menuPrincipal();
                painelPrincipal.setVisible(false);
                break;
            case "paciente":
                menuMedico();
                painelMedico.setVisible(false);
                menuEnfermagem();
                painelEnfermeiro.setVisible(false);
                menuRegisto();
                painelRegisto.setVisible(false);
                menuPaciente();
                painelPaciente.setVisible(true);
                menuPrincipal();
                painelPrincipal.setVisible(false);
                break;
            
       }
        
    }
    
    //Método que configura O Cabeçalho dos menus
    private void cabecalho(JPanel panel, String titulo){
        JTextField tituloPrincipal = new JTextField(titulo);
        tituloPrincipal.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(1, 96, 128)));
        tituloPrincipal.setFont(new Font("Segoe UI", 1, 30));
        tituloPrincipal.setHorizontalAlignment(JTextField.CENTER);
        tituloPrincipal.setEnabled(false);
        tituloPrincipal.setBounds(70, 50, 790, 60);

        panel.add(tituloPrincipal);
    }
    
    
    
      
    //Método que configura as características/atributos padrão do botão lateral
    private void configurarBotaoEsquerdo(JButton botaoLateral){
        botaoLateral.setFont(new Font("Segoe UI", 1, 18));
        botaoLateral.setIconTextGap(5);
        botaoLateral.setHorizontalAlignment(JButton.LEFT);
        botaoLateral.setContentAreaFilled(false);
        botaoLateral.setOpaque(false);
        botaoLateral.addMouseListener(this);
        botaoLateral.addActionListener(this);    
    }
    
    //Método que configura os atributos do botão lateral aquando da entrada do mouse
    public void configurarBotaoEsquerdoEntradaMouse(JButton botaoLateralTemporario){
        botaoLateralTemporario.setBackground(Color.GRAY);
        botaoLateralTemporario.setContentAreaFilled(true);
        botaoLateralTemporario.setFont(new Font("Segoe UI", 1, 20));
        botaoLateralTemporario.setFocusable(false);
        botaoLateralTemporario.setOpaque(false);     
    }
    
    //Método que configura os atributos do botão lateral após saída do mouse
    public void configurarBotaoEsquerdoSaidaMouse(JButton button){
        button.setContentAreaFilled(false);
        button.setFont(new Font("Segoe UI", 1, 18)); 
        button.setOpaque(false);
    }
    
    //Método que configura os atributos do botão lateral do menu em uso
    private void configurarBotaoEsquerdoActual(JButton botaoActualLateral){
        botaoActualLateral.setBackground(Color.WHITE);
        botaoActualLateral.setFont(new Font("Segoe UI", 1, 20));
        botaoActualLateral.setFocusable(true);
        botaoActualLateral.setContentAreaFilled(true);
        botaoActualLateral.setOpaque(false);        
    }
    
    //Método que configura os atributos do botão por padrão
    private void configurarBotaoDireiro(JButton botaoCentral){
        botaoCentral.setFont(new Font("Segoe UI", 1, 18));
        botaoCentral.setHorizontalTextPosition(JButton.CENTER);
        botaoCentral.setVerticalTextPosition(JButton.BOTTOM);
        botaoCentral.setIconTextGap(7);
        botaoCentral.setContentAreaFilled(false);
        botaoCentral.addMouseListener(this);
        botaoCentral.addActionListener(this);       
    }
    
    //Método que configura os atributos do botão aquando da entranda do mouse
    private void configurarBotaoDireitoEntradaMouse(JButton button, ImageIcon imagem){
        button.setBackground(new Color(240, 240, 240));
        button.setIcon(imagem);
        button.setContentAreaFilled(true);
        button.setOpaque(false);
        button.setFocusable(false);     
    }
   
    //Método que configura os atributos do botão após a saída do mouse
    private void configurarBotaoDireitolSaidaMouse(JButton button, ImageIcon imagem){
        button.setIcon(imagem);
        button.setContentAreaFilled(false);       
    }
    
    
    //Métodos de Perfomance de Menus
    
    private void habilitarComponentes(JPanel painel, JButton button){
        configurarBotaoEsquerdoActual(button);
        painel.setVisible(true);        
    }
    
    private void desabilitarComponentes(JPanel painel, JButton button){
        configurarBotaoEsquerdo(button);
        painel.setVisible(false);        
    }
    
    
    //Métodos de Definição de Menus
    
    private void menuPrincipal(){
        
        SecretarioControl sc = new SecretarioControl();
         String [] dados = sc.dadosSecretario(202001).toArray(new String [sc.dadosSecretario(202001).size()]);
         //dificuldades em pegar a palavra passe introduzida pelo secretario que faz login
        
        JLabel usuario = new JLabel("Dados Pessoais", new ImageIcon("Icon 2 - User.png"), JLabel.CENTER);
        usuario.setFont(new Font("Segoe UI", 3, 24));
        usuario.setForeground(new Color(255, 255, 255));;
        usuario.setHorizontalTextPosition(JLabel.CENTER);
        usuario.setVerticalTextPosition(JLabel.BOTTOM);
        usuario.setIconTextGap(15);
        usuario.setBounds(42, 45, 190, 187);
        
        JLabel linha = new JLabel(new ImageIcon("long Line.png"), 2);
        linha.setBounds(27, 227, 200, 25);
        
        JLabel id = new JLabel("ID:");
        id.setForeground(Color.white);
        id.setFont(new Font("Segoe UI", 1, 14));
        id.setBounds(27, 270, 62, 20);
        JLabel idUser = new JLabel("xxxx");
        idUser.setForeground(Color.lightGray);
        idUser.setFont(new Font("Segoe UI", 3, 14));
        idUser.setBounds(100, 270, 130, 20);
        idUser.setText(dados[0]);
        
        JLabel name = new JLabel("Nome:");
        name.setForeground(Color.white);
        name.setFont(new Font("Segoe UI", 1, 14));
        name.setBounds(27, 308, 62, 20);
        JLabel userName = new JLabel("Nome Próprio");
        userName.setForeground(Color.lightGray);
        userName.setFont(new Font("Segoe UI", 3, 14));
        userName.setBounds(100, 308, 130, 20);
        userName.setText(dados[1]);
        
        /*JLabel surname = new JLabel("Apelido:");
        surname.setForeground(Color.white);
        surname.setFont(new Font("Segoe UI", 1, 14));
        surname.setBounds(27, 346, 62, 20);
        JLabel userSurname = new JLabel("Apelido do Usuario");
        userSurname.setForeground(Color.lightGray);
        userSurname.setFont(new Font("Segoe UI", 3, 14));
        userSurname.setBounds(105, 346, 130, 20);*/
        
        JLabel cargo = new JLabel("Cargo:");
        cargo.setForeground(Color.white);
        cargo.setFont(new Font("Segoe UI", 1, 14));        
        cargo.setBounds(27, 384, 62, 20);
        JLabel userJob = new JLabel("Cargo Ocupado");
        userJob.setForeground(Color.lightGray);
        userJob.setFont(new Font("Segoe UI", 3, 14));
        userJob.setBounds(100, 384, 130, 20);
        userJob.setText(dados[3]);
        
        JLabel email = new JLabel("E-mail:");
        email.setForeground(Color.white);
        email.setFont(new Font("Segoe UI", 1, 14));        
        email.setBounds(27, 346, 62, 20);
        JLabel userEmail = new JLabel("E-mail do Usuário");
        userEmail.setForeground(Color.lightGray);
        userEmail.setFont(new Font("Segoe UI", 3, 14));
        userEmail.setBounds(100, 346, 170, 20);
        userEmail.setText(dados[2]);
        
        logOut1 = new JButton("Log Out", new ImageIcon("Icone - LogOut 48px.png"));
        logOut1.setBounds(53, 566, 148, 58);
        logOut1.setBackground(new Color(255, 0, 0));
        logOut1.setFont(new Font("Segoe UI", 1, 18));
        logOut1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logOut1.setFocusable(false);
        logOut1.addActionListener(this);
        
        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(1, 96, 128));
        leftPanel.setBounds(0, 0, 260, 700);
        leftPanel.setLayout(null);
        leftPanel.add(usuario);
        leftPanel.add(linha);
        leftPanel.add(id);
        leftPanel.add(idUser);
        leftPanel.add(name);
        leftPanel.add(userName);
       // leftPanel.add(surname);
        //leftPanel.add(userSurname);
        leftPanel.add(cargo);
        leftPanel.add(userJob);
        leftPanel.add(email);
        leftPanel.add(userEmail);
        leftPanel.add(logOut1);
        
        btnRegisto = new JButton("Registo", new ImageIcon("Icone - Registo 187px.png"));
        btnRegisto.setBounds(150, 121, 253, 247);
        configurarBotaoDireiro(btnRegisto);
        
        btnPaciente = new JButton("Paciente", new ImageIcon("Icone - Paciente 187px.png"));
        btnPaciente.setBounds(525, 121, 253, 247);
        configurarBotaoDireiro(btnPaciente);
        
        btnMedico = new JButton("Médico", new ImageIcon("Icone - Medico 187px.png"));
        btnMedico.setBounds(150, 390, 257, 247);
        configurarBotaoDireiro(btnMedico);
        
        btnEnfermeiro = new JButton("Enfermeiro", new ImageIcon("Icone - Enfermeiro 187px.png"));
        btnEnfermeiro.setBounds(525, 390, 257, 247);
        configurarBotaoDireiro(btnEnfermeiro);
        
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(260, 0, 940, 700);
        rightPanel.setBackground(new Color(255, 255, 255));
        cabecalho(rightPanel, "Sistema de Gestão da Clinica");
        rightPanel.add(btnPaciente);
        rightPanel.add(btnRegisto);
        rightPanel.add(btnMedico);
        rightPanel.add(btnEnfermeiro);
        
        
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBounds(0, 0, 1200, 700);
        painelPrincipal.add(leftPanel);
        painelPrincipal.add(rightPanel);
        frame.add(painelPrincipal);
        
    }
    
    private void painelEsquerdo(){
        JLabel topo = new JLabel("Clínica Boa Saúde", new ImageIcon("Icone 1 - logo.png"), 2);
        topo.setFont(new java.awt.Font("Segoe UI", 3, 18));
        topo.setForeground(new Color(255, 255, 255));
        topo.setHorizontalTextPosition(JLabel.CENTER);
        topo.setVerticalTextPosition(JLabel.BOTTOM);
        topo.setIconTextGap(10);
        topo.setBounds(42, 19, 170, 154);
        
        JLabel linha1 = new JLabel(new ImageIcon("long Line.png"), 2);
        linha1.setBounds(27, 170, 200, 25);
        
        home = new JButton("Menu Principal", new ImageIcon("Icone - Home 48px.png"));
        home.setBounds(5, 210, 250, 48);
        configurarBotaoEsquerdo(home);
        
        registo = new JButton("Registo", new ImageIcon("Icone - Registo 48px.png"));
        registo.setBounds(5, 276, 250, 48);
        configurarBotaoEsquerdo(registo);
        
        paciente = new JButton("Paciente", new ImageIcon("Icone - Paciente 48px.png"));
        paciente.setBounds(5, 342, 250, 48);
        configurarBotaoEsquerdo(paciente);
             
        medico = new JButton("Médico", new ImageIcon("Icone - Doctor 48px.png"));
        medico.setBounds(5, 408, 250, 48);
        configurarBotaoEsquerdo(medico);
        
        enfermagem = new JButton("Enfermagem", new ImageIcon("Icone - Enfermagem 48px.png"));
        enfermagem.setBounds(5, 474, 250, 48);
        configurarBotaoEsquerdo(enfermagem);
        
        logOut2 = new JButton("Log Out", new ImageIcon("Icone - LogOut 48px.png"));
        logOut2.setBounds(53, 566, 148, 58);
        logOut2.setBackground(new Color(255, 0, 0));
        logOut2.setFont(new Font("Segoe UI", 1, 18));
        logOut2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logOut2.setFocusable(false);
        logOut2.addActionListener(this);
        
        painelEsquerdo = new JPanel();
        painelEsquerdo.setBackground(new Color(1, 96, 128));
        painelEsquerdo.setBounds(0, 0, 260, 700);
        painelEsquerdo.setLayout(null);
        painelEsquerdo.add(topo);
        painelEsquerdo.add(linha1);
        painelEsquerdo.add(home);
        painelEsquerdo.add(registo);
        painelEsquerdo.add(paciente);
        painelEsquerdo.add(medico);
        painelEsquerdo.add(enfermagem);
        painelEsquerdo.add(logOut2);
                
        frame.add(painelEsquerdo);
    }
    
    private void menuRegisto(){
         
        btnMarcar = new JButton("Agendar Cirurgia/Consulta", new ImageIcon("Icone - Marcar 187px.png"));
        btnMarcar.setBounds(20, 215, 260, 247);
        configurarBotaoDireiro(btnMarcar);
                
        btnCancelar = new JButton("Cancelar Cirurgia/Consulta", new ImageIcon("Icone - Cancelar 187px.png"));
        btnCancelar.setBounds(335, 215, 260, 247);
        configurarBotaoDireiro(btnCancelar);
        
        btnListar = new JButton("Lista de Cirurgias/Consultas", new ImageIcon("Icone - Listagem 187px.png"));
        btnListar.setBounds(641, 215, 266, 247);
        configurarBotaoDireiro(btnListar);
        
        painelRegisto = new JPanel();
        painelRegisto.setLayout(null);
        painelRegisto.setBounds(260, 0, 940, 700);
        painelRegisto.setBackground(new Color(255, 255, 255));
        cabecalho(painelRegisto, "MENU REGISTO");
        painelRegisto.add(btnMarcar);
        painelRegisto.add(btnCancelar);
        painelRegisto.add(btnListar);
        frame.add(painelRegisto);
        
    }
    
    private void menuPaciente(){
        
        btnAdicionarPaciente = new JButton("Adicionar Paciente", new ImageIcon("Icone - Adicionar 187px.png"));
        btnAdicionarPaciente.setBounds(150, 121, 265, 247);
        configurarBotaoDireiro(btnAdicionarPaciente);
        
        btnPacienteInternado = new JButton("Adicionar Paciente Internado", new ImageIcon("Icone - PacienteInternado 187px.png"));
        btnPacienteInternado.setBounds(525, 121, 280, 247);
        configurarBotaoDireiro(btnPacienteInternado);
                
        btnPacienteRecuperado = new JButton("Registar Alta", new ImageIcon("Icone - PacienteRecuperado 187px.png"));
        btnPacienteRecuperado.setBounds(150, 390, 265, 247);
        configurarBotaoDireiro(btnPacienteRecuperado);
        
        btnListaPaciente = new JButton("Lista de Pacientes", new ImageIcon("Icone - Lista 187px.png"));
        btnListaPaciente.setBounds(525, 390, 265, 247);
        configurarBotaoDireiro(btnListaPaciente);
        
        painelPaciente = new JPanel();
        painelPaciente.setLayout(null);
        painelPaciente.setBounds(260, 0, 940, 700);
        painelPaciente.setBackground(new Color(255, 255, 255));
        cabecalho(painelPaciente, "MENU PACIENTE");
        painelPaciente.add(btnAdicionarPaciente);
        painelPaciente.add(btnPacienteInternado);
        painelPaciente.add(btnPacienteRecuperado);
        painelPaciente.add(btnListaPaciente);
        frame.add(painelPaciente);
    }
    
    private void menuMedico(){
        
        btnAdicionarMedico = new JButton("Adicionar Médico", new ImageIcon("Icone - Adicionar 187px.png"));
        btnAdicionarMedico.setBounds(30, 121, 253, 247);
        configurarBotaoDireiro(btnAdicionarMedico);
        
        btnMedicoConsulta = new JButton("Médicos com Consulta", new ImageIcon("Icone - Consulta 187px.png"));
        btnMedicoConsulta.setBounds(346, 121, 253, 247);
        configurarBotaoDireiro(btnMedicoConsulta);
        
        btnMedicoCirurgia = new JButton("Médicos com Cirurgia", new ImageIcon("Icone - Cirurgia 187px.png"));
        btnMedicoCirurgia.setBounds(659, 121, 253, 247);
        configurarBotaoDireiro(btnMedicoCirurgia);
        
        btnAgendaMedico = new JButton("Agenda dos Médicos", new ImageIcon("Icone - Agenda 187px.png"));
        btnAgendaMedico.setBounds(164, 390, 253, 247);
        configurarBotaoDireiro(btnAgendaMedico); 
        
        btnListaMedico = new JButton("Lista de Médicos", new ImageIcon("Icone - Lista 187px.png"));
        btnListaMedico.setBounds(500, 390, 253, 247);
        configurarBotaoDireiro(btnListaMedico);          
        
        painelMedico = new JPanel();
        painelMedico.setLayout(null);
        painelMedico.setBounds(260, 0, 940, 700);
        painelMedico.setBackground(new Color(255, 255, 255));
        cabecalho(painelMedico, "MENU MÉDICO");
        painelMedico.add(btnAdicionarMedico);
        painelMedico.add(btnMedicoConsulta);
        painelMedico.add(btnMedicoCirurgia);
        painelMedico.add(btnAgendaMedico);
        painelMedico.add(btnListaMedico);
        frame.add(painelMedico);
    }

    private void menuEnfermagem(){

        btnAdicionarEnfermeiro = new JButton("Adicionar Enfermeiro", new ImageIcon("Icone - Adicionar 187px.png"));
        btnAdicionarEnfermeiro.setBounds(150, 121, 253, 247);
        configurarBotaoDireiro(btnAdicionarEnfermeiro);
                
        btnEnfermeiroActivo = new JButton("Enfermeiros Activos", new ImageIcon("Icone - EnfermeiroActivo 187px.png"));
        btnEnfermeiroActivo.setBounds(525, 121, 253, 247);
        configurarBotaoDireiro(btnEnfermeiroActivo);
        
        btnPacienteDeEnfermeiro = new JButton("Pacientes Cuidados", new ImageIcon("Icone - EnfereiroPaciente 187px.png"));
        btnPacienteDeEnfermeiro.setBounds(150, 390, 257, 247);
        configurarBotaoDireiro(btnPacienteDeEnfermeiro);
        
        btnListaEnfermeiro = new JButton("Lista de Enfermeiros", new ImageIcon("Icone - Lista 187px.png"));
        btnListaEnfermeiro.setBounds(525, 390, 257, 247);
        configurarBotaoDireiro(btnListaEnfermeiro);
        
        painelEnfermeiro = new JPanel();
        painelEnfermeiro.setLayout(null);
        painelEnfermeiro.setBounds(260, 0, 940, 700);
        painelEnfermeiro.setBackground(new Color(255, 255, 255));
        cabecalho(painelEnfermeiro, "MENU ENFERMAGEM");
        painelEnfermeiro.add(btnAdicionarEnfermeiro);
        painelEnfermeiro.add(btnEnfermeiroActivo);
        painelEnfermeiro.add(btnPacienteDeEnfermeiro);
        painelEnfermeiro.add(btnListaEnfermeiro);
        frame.add(painelEnfermeiro);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        
        if(e.getSource()==home){
            if(painelRegisto.isShowing()){
                desabilitarComponentes(painelRegisto, registo);
                
            }else if(painelPaciente.isShowing()){
                desabilitarComponentes(painelPaciente, paciente);

            }else if(painelMedico.isShowing()){
                desabilitarComponentes(painelMedico, medico);
                
            }else if(painelEnfermeiro.isShowing()){
                desabilitarComponentes(painelEnfermeiro, enfermagem);                
            }
            
            painelEsquerdo.setVisible(false);
            painelPrincipal.setVisible(true);
            
        }else if(e.getSource()==registo){
            if(painelPaciente.isShowing()){
                desabilitarComponentes(painelPaciente, paciente);  
                
            }else if(painelMedico.isShowing()){
                desabilitarComponentes(painelMedico, medico);
               
            }else if(painelEnfermeiro.isShowing()){
                desabilitarComponentes(painelEnfermeiro, enfermagem);                   
            }
            
            habilitarComponentes(painelRegisto, registo);
            
        }else if(e.getSource()==paciente){

            if(painelRegisto.isShowing()){
                desabilitarComponentes(painelRegisto, registo);
                
            }else if(painelMedico.isShowing()){
                desabilitarComponentes(painelMedico, medico);

            }else if(painelEnfermeiro.isShowing()){
                desabilitarComponentes(painelEnfermeiro, enfermagem);                   
            }
            
            habilitarComponentes(painelPaciente, paciente);

        }else if(e.getSource()==medico){
            
            if(painelRegisto.isShowing()){
                desabilitarComponentes(painelRegisto, registo);
                
            }else if(painelPaciente.isShowing()){
                desabilitarComponentes(painelPaciente, paciente);

            }else if(painelEnfermeiro.isShowing()){
                desabilitarComponentes(painelEnfermeiro, enfermagem);                
            }
            
            habilitarComponentes(painelMedico, medico);

        } else if(e.getSource()==enfermagem){
            
            if(painelPrincipal.isShowing()){
                painelPrincipal.setVisible(false);
            }
            if(painelRegisto.isShowing()){
                desabilitarComponentes(painelRegisto, registo);
                
            }
            if(painelPaciente.isShowing()){
                desabilitarComponentes(painelPaciente, paciente);
                
            }else if(painelMedico.isShowing()){
                desabilitarComponentes(painelMedico, medico);  
            }
            
            habilitarComponentes(painelEnfermeiro, enfermagem);

        }else if(button==logOut1 || button==logOut2){
            
            int i = JOptionPane.showConfirmDialog(frame, "Deseja Realmente Fazer Log Out?", "Log Out", JOptionPane.YES_NO_OPTION);
            if(i==0){
                frame.dispose();
                new Login();
            }
            
        }else if(e.getSource()==btnPaciente){
            painelPrincipal.setVisible(false);
            painelEsquerdo.setVisible(true);
            habilitarComponentes(painelPaciente, paciente);
            
        }else if(e.getSource()==btnRegisto){
            painelPrincipal.setVisible(false);
            painelEsquerdo.setVisible(true);
            habilitarComponentes(painelRegisto, registo);
            
        }else if(e.getSource()==btnMedico){
            painelPrincipal.setVisible(false);
            painelEsquerdo.setVisible(true);
            habilitarComponentes(painelMedico, medico);
            
        }else if(e.getSource()==btnEnfermeiro){
            painelPrincipal.setVisible(false);
            painelEsquerdo.setVisible(true);
            habilitarComponentes(painelEnfermeiro, enfermagem);
        }
        
        if(e.getSource()== btnAdicionarPaciente){
            new CadastroPac();
            //frame.dispose();                          
        }
        
        if(e.getSource() ==  btnPacienteInternado){
            new CadastroInternamento();
        }
        
        if(e.getSource()== btnPacienteRecuperado){
            new RegistoAlta();
            //frame.dispose();
        }
        
        if(e.getSource()== btnListaPaciente){
            new ListaPac();
            //frame.dispose();
        }
        
        
        if(e.getSource()== btnAdicionarMedico){
            new AdicionarMed();
            //frame.dispose();
        }
        
        if(e.getSource()== btnMedicoConsulta){
            ListaMed lista = new ListaMed();
            lista.MedConCir("Consulta");
            //frame.dispose();
        }
        
        if(e.getSource()== btnMedicoCirurgia){
            ListaMed lista = new ListaMed();
            lista.MedConCir("Cirurgia");
            //frame.dispose();
        }
        
        if(e.getSource()== btnListaMedico){
            ListaMed lista = new ListaMed();
            lista.getMedicos();
            //frame.dispose();
        }
        
        if(e.getSource()== btnAgendaMedico){
            new AgendaMed();
            //frame.dispose();
        }
        
        
        if(e.getSource()== btnAdicionarEnfermeiro){
            new AdicionarEnf();
            //frame.dispose();
        }
        
        if(e.getSource()== btnEnfermeiroActivo){
            new EnfActivo();
            //frame.dispose();
        }
        
        if(e.getSource()== btnPacienteDeEnfermeiro){
            new ListaPacCuidados();
            //frame.dispose();
        }
        
        if(e.getSource()== btnListaEnfermeiro){
            new ListaEnf();
            //frame.dispose();
        }
        
        
        if(e.getSource()== btnMarcar){
            new Registo();
            //frame.dispose();
        }
        
        if(e.getSource()== btnCancelar){
            new CancelarReg();
            //frame.dispose();
        }
        
        if(e.getSource()== btnListar){
            new ListaReg();
            //frame.dispose();
        }
    }

    // Método que define o comportamento dos botões ao serem "envadidos" pelo Mouse
    @Override
    public void mouseEntered(MouseEvent e) {
        
        JButton button = (JButton) e.getSource();             
       
       // Botões do Menu Lateral
       if(e.getSource()==home && !home.isContentAreaFilled()){
            configurarBotaoEsquerdoEntradaMouse(home);   
            
        }else if(e.getSource()==registo && !registo.isContentAreaFilled()){
            configurarBotaoEsquerdoEntradaMouse(registo);
            
        }else if(e.getSource()==paciente && !paciente.isContentAreaFilled()){
            configurarBotaoEsquerdoEntradaMouse(paciente); 
            
        }else if(e.getSource()==medico && !medico.isContentAreaFilled()){
            configurarBotaoEsquerdoEntradaMouse(medico);
            
        }else if(e.getSource()==enfermagem && !enfermagem.isContentAreaFilled()){
            configurarBotaoEsquerdoEntradaMouse(enfermagem);
         
        // Botões do Menu Paciente    
        }else if(button==btnAdicionarPaciente){
            configurarBotaoDireitoEntradaMouse(btnAdicionarPaciente, new ImageIcon("Icone - Adicionar 200px.png"));
            
        }else if(button==btnPacienteInternado){
            configurarBotaoDireitoEntradaMouse(btnPacienteInternado, new ImageIcon("Icone - PacienteInternado 200px.png"));
            
        }else if(button==btnPacienteRecuperado){
            configurarBotaoDireitoEntradaMouse(btnPacienteRecuperado, new ImageIcon("Icone - PacienteRecuperado 200px.png"));
            
        }else if(button==btnListaPaciente){
            configurarBotaoDireitoEntradaMouse(btnListaPaciente, new ImageIcon("Icone - Lista 200px.png"));

        // Botões do Menu Médico
        }else if(button==btnAdicionarMedico){
            configurarBotaoDireitoEntradaMouse(btnAdicionarMedico, new ImageIcon("Icone - Adicionar 200px.png"));
            
        }else if(button==btnMedicoConsulta){
            configurarBotaoDireitoEntradaMouse(btnMedicoConsulta, new ImageIcon("Icone - Consulta 200px.png"));
            
        }else if(button==btnMedicoCirurgia){
            configurarBotaoDireitoEntradaMouse(btnMedicoCirurgia, new ImageIcon("Icone - Cirurgia 200px.png"));
            
        }else if(button==btnAgendaMedico){
            configurarBotaoDireitoEntradaMouse(btnAgendaMedico, new ImageIcon("Icone - Agenda 200px.png"));
            
        }else if(button==btnListaMedico){
            configurarBotaoDireitoEntradaMouse(btnListaMedico, new ImageIcon("Icone - Lista 200px.png"));
  
        // Botões do Menu Enfermeiro
        }else if(button==btnAdicionarEnfermeiro){
            configurarBotaoDireitoEntradaMouse(btnAdicionarEnfermeiro, new ImageIcon("Icone - Adicionar 200px.png"));
            
        }else if(button==btnEnfermeiroActivo){
            configurarBotaoDireitoEntradaMouse(btnEnfermeiroActivo, new ImageIcon("Icone - EnfermeiroActivo 200px.png"));
            
        }else if(button==btnPacienteDeEnfermeiro){
            configurarBotaoDireitoEntradaMouse(btnPacienteDeEnfermeiro, new ImageIcon("Icone - EnfereiroPaciente 200px.png"));
            
        }else if(button==btnListaEnfermeiro){
            configurarBotaoDireitoEntradaMouse(btnListaEnfermeiro, new ImageIcon("Icone - Lista 200px.png"));

        // Botões do Menu Registo
        }else if(button==btnMarcar){
            configurarBotaoDireitoEntradaMouse(btnMarcar, new ImageIcon("Icone - Marcar 200px.png"));
            
        }else if(button==btnCancelar){
            configurarBotaoDireitoEntradaMouse(btnCancelar, new ImageIcon("Icone - Cancelar 200px.png"));
            
        }else if(button==btnListar){
            configurarBotaoDireitoEntradaMouse(btnListar, new ImageIcon("Icone - Listagem 200px.png"));
            
        // Botões do Menu Principal             
        }else if(button==btnRegisto){
            configurarBotaoDireitoEntradaMouse(btnRegisto, new ImageIcon("Icone - Registo 200px.png"));
            
        }else if(button==btnPaciente){
            configurarBotaoDireitoEntradaMouse(btnPaciente, new ImageIcon("Icone - Paciente 200px.png"));
            
        }else if(button==btnMedico){
            configurarBotaoDireitoEntradaMouse(btnMedico, new ImageIcon("Icone - Medico 200px.png"));
            
        }else if(button==btnEnfermeiro){
            configurarBotaoDireitoEntradaMouse(btnEnfermeiro, new ImageIcon("Icone - Enfermeiro 200px.png"));
        }
    }
    
    // Método que define o comportamento dos botões ao serem "deixados" pelo Mouse
    @Override
    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        
        // Botões do Menu Lateral Esquerdo
        if(e.getSource()==home && !home.isFocusable()){
            configurarBotaoEsquerdoSaidaMouse(home);
            
        }else if(e.getSource()==registo && !registo.isFocusable()){
            configurarBotaoEsquerdoSaidaMouse(registo);
            
        }else if(e.getSource()==paciente && !paciente.isFocusable()){
            configurarBotaoEsquerdoSaidaMouse(paciente);
            
        }else if(e.getSource()==medico && !medico.isFocusable()){
            configurarBotaoEsquerdoSaidaMouse(medico);
            
        }else if(e.getSource()==enfermagem && !enfermagem.isFocusable()){
            configurarBotaoEsquerdoSaidaMouse(enfermagem);
        
        // Botões do Menu Paciente
        }else if(button==btnAdicionarPaciente){
            configurarBotaoDireitolSaidaMouse(btnAdicionarPaciente, new ImageIcon("Icone - Adicionar 187px.png"));
            
        }else if(button==btnPacienteInternado){
            configurarBotaoDireitolSaidaMouse(btnPacienteInternado, new ImageIcon("Icone - PacienteInternado 187px.png"));
            
        }else if(button==btnPacienteRecuperado){
            configurarBotaoDireitolSaidaMouse(btnPacienteRecuperado, new ImageIcon("Icone - PacienteRecuperado 187px.png"));
            
        }else if(button==btnListaPaciente){
            configurarBotaoDireitolSaidaMouse(btnListaPaciente, new ImageIcon("Icone - Lista 187px.png"));
        
        // Botões do Menu Médico
        }else if(button==btnAdicionarMedico){
            configurarBotaoDireitolSaidaMouse(btnAdicionarMedico, new ImageIcon("Icone - Adicionar 187px.png"));
            
        }else if(button==btnMedicoConsulta){
            configurarBotaoDireitolSaidaMouse(btnMedicoConsulta, new ImageIcon("Icone - Consulta 187px.png"));
            
        }else if(button==btnMedicoCirurgia){
            configurarBotaoDireitolSaidaMouse(btnMedicoCirurgia, new ImageIcon("Icone - Cirurgia 187px.png"));
            
        }else if(button==btnAgendaMedico){
            configurarBotaoDireitolSaidaMouse(btnAgendaMedico, new ImageIcon("Icone - Agenda 187px.png"));
            
        }else if(button==btnListaMedico){
            configurarBotaoDireitolSaidaMouse(btnListaMedico, new ImageIcon("Icone - Lista 187px.png"));
        
        // Botões de Enfermeiro
        }else if(button==btnAdicionarEnfermeiro){
            configurarBotaoDireitolSaidaMouse(btnAdicionarEnfermeiro, new ImageIcon("Icone - Adicionar 187px.png"));
            
        }else if(button==btnEnfermeiroActivo){
            configurarBotaoDireitolSaidaMouse(btnEnfermeiroActivo, new ImageIcon("Icone - EnfermeiroActivo 187px.png"));
            
        }else if(button==btnPacienteDeEnfermeiro){
            configurarBotaoDireitolSaidaMouse(btnPacienteDeEnfermeiro, new ImageIcon("Icone - EnfereiroPaciente 187px.png"));
            
        }else if(button==btnListaEnfermeiro){
            configurarBotaoDireitolSaidaMouse(btnListaEnfermeiro, new ImageIcon("Icone - Lista 187px.png"));
        
        // Botões de Registo
        }else if(button==btnMarcar){
            configurarBotaoDireitolSaidaMouse(btnMarcar, new ImageIcon("Icone - Marcar 187px.png"));
            
        }else if(button==btnCancelar){
            configurarBotaoDireitolSaidaMouse(btnCancelar, new ImageIcon("Icone - Cancelar 187px.png"));
            
        }else if(button==btnListar){
            configurarBotaoDireitolSaidaMouse(btnListar, new ImageIcon("Icone - Listagem 187px.png"));
        }else if(button==btnAdicionarEnfermeiro){
            configurarBotaoDireitolSaidaMouse(btnAdicionarEnfermeiro, new ImageIcon("Icone - Adicionar 187px.png"));
        
        // Botões do Menu Principal    
        }else if(button==btnPaciente){
            configurarBotaoDireitolSaidaMouse(btnPaciente, new ImageIcon("Icone - Paciente 187px.png"));
            
        }else if(button==btnRegisto){
            configurarBotaoDireitolSaidaMouse(btnRegisto, new ImageIcon("Icone - Registo 187px.png"));
            
        }else if(button==btnMedico){
            configurarBotaoDireitolSaidaMouse(btnMedico, new ImageIcon("Icone - Medico 187px.png"));
            
        }else if(button==btnEnfermeiro){
            configurarBotaoDireitolSaidaMouse(btnEnfermeiro, new ImageIcon("Icone - Enfermeiro 187px.png"));
        }
    }

       
    // Métodos da interface MouseListener NÃO USADOS de implementação obrigatória.
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

