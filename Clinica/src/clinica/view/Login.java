/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import clinica.model.LoginDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Ludmila Mucavele
 */
public class Login implements ActionListener, FocusListener, MouseListener {
    private JPanel p1, p2;
    private JLabel l1, l2, l3, l4, l5, l6;
    private JTextField t1;
    private JPasswordField pf1;
    private JButton b1, close; 
    private JFrame janelaLogin;
    private static ImageIcon icone, fundo, icone1, icone2;

    
    public Login(){
        
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 310, 400); 
        l1 = new JLabel();
        fundo = new ImageIcon ("Group1.png");
        l1.setBounds(0, 0, 310, 400);
        l1.setIcon(fundo);
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(310, 0, 350, 420);
        l2 = new JLabel ("Bem-Vindo(a)!");
        l2.setFont(new Font("Segoe UI", Font.BOLD, 26)); 
        l2.setForeground(new Color(8, 84, 121));
        l2.setBounds(85, 0, 200, 140); 
        
        l3 = new JLabel ();
        icone1 = new ImageIcon("User.png");
        l3.setIcon(icone1);
        l3.setBounds(20,0, 200,320);
        
        l4 = new JLabel ("Usuário");
        l4.setFont(new Font("Segoe UI", Font.BOLD, 16)); 
        l4.setForeground(Color.GRAY);
        l4.setBounds(60, 0, 200, 320);
        
        l5 = new JLabel ();
        icone2 = new ImageIcon("Locker.png");
        l5.setIcon(icone2);
        l5.setBounds(20,0, 200,490);
        
        l6 = new JLabel ("Senha");
        l6.setFont(new Font("Segoe UI", Font.BOLD, 16)); 
        l6.setForeground(Color.GRAY);
        l6.setBounds(60, 0, 200, 490);
        
        t1 = new JTextField (20);
        t1.setBounds(20, 180, 290, 30);
        t1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        t1.setForeground(Color.GRAY);
        t1.setText("Introduza o Nome");
        t1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        t1.addActionListener(this);
        t1.addFocusListener(this);
        
        pf1 = new JPasswordField (20);
        pf1.setBounds(20, 265, 290, 30);
        pf1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        pf1.setForeground(Color.GRAY);
        pf1.setText("Introduza a Senha");
        pf1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        pf1.addActionListener(this);
        pf1.addFocusListener(this);
        
        close = new JButton("X");
        close.setBackground(Color.white);
        close.setFont(new Font("Segoe UI", 1, 18));
        close.setForeground(Color.LIGHT_GRAY);
        close.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        close.setFocusable(false);
        close.setBounds(305, 0, 39, 30);
        close.addActionListener(this);
        close.addMouseListener(this);
        
        b1  = new JButton("Entrar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(90, 340, 175, 40);
        b1.setBackground(new Color(8, 84, 121));
        b1.setFocusable(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        
        
        p2.add(l2); p2.add(l3); p2.add(l4); p2.add(l5); p2.add(l6); p2.add(t1);
        p2.add(pf1); p2.add(b1); p2.add(close);
        p2.setBackground(Color.WHITE);
        
        
        janelaLogin = new JFrame("Janela de Login");
        janelaLogin.setSize(660,400);
        janelaLogin.setLocationRelativeTo(null);
        janelaLogin.setIconImage((new ImageIcon(("iconeprincipal.png"))).getImage());
        janelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaLogin.setResizable(false);
        janelaLogin.setUndecorated(true);
        janelaLogin.setLayout(null);
        janelaLogin.add(p1); janelaLogin.add(p2);
        janelaLogin.setVisible(true);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        LoginDAO lg = new LoginDAO();
        JButton b = (JButton) e.getSource();
        String p = null;
         
        if(e.getSource() == close)
            System.exit(0);
        
        if (b == b1){
            p = new String(pf1.getPassword());
            if(p.isEmpty() == false){
                if ((t1.getText()).isEmpty() == false){
                    if (lg.getFuncionario(p).equalsIgnoreCase(t1.getText())){
                            janelaLogin.dispose();
                            new Menu();
                    }
                    else
                        JOptionPane.showMessageDialog(janelaLogin, "Codigo ou Nome de Funcionario Invalido.");
                }
                else 
                JOptionPane.showMessageDialog(janelaLogin, "Introduza o Nome de Funcionario.");
            }
            else 
                    if(new String(pf1.getPassword()).isBlank())
                        JOptionPane.showMessageDialog(janelaLogin, "Introduza o Codigo de Funcionario.");
            
         }
         
         
         
         
    }
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == t1){
            if(t1.getText().equals("Introduza o Nome")){
                t1.setText("");
                t1.setForeground(new Color(0, 0, 0));
            }
        }else if(e.getSource() == pf1){
            if(pf1.getText().equals("Introduza a Senha")){
                pf1.setForeground(new Color(0, 0, 0));
                pf1.setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource() == t1){
            if(t1.getText().equals("Introduza o Nome") || t1.getText().equals("")){
                t1.setText("Introduza o Nome");
                t1.setForeground(new Color(153, 153, 153));
            }    
        }
        if(e.getSource() == pf1){
           if(pf1.getText().equals("Introduza a Senha") || pf1.getText().equals("")){
                pf1.setText("Introduza a Senha");
                pf1.setForeground(new Color(153, 153, 153));    
            }  
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == close){
            close.setFont(new Font("Segoe UI", 1, 20));
            close.setForeground(Color.red);
            close.setBackground(Color.LIGHT_GRAY);   
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == close){
            close.setBackground(Color.white);
            close.setFont(new Font("Segoe UI", 1, 18));
            close.setForeground(Color.GRAY);
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
