/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import clinica.model.LoginDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
/**
 *
 * @author Ludmila Mucavele
 */
public class Login implements ActionListener, FocusListener, MouseListener {
    private JPanel p1, p2;
    private JLabel l1, l2, l3, l5, l6;
    private JTextField t1, t2;
    private JPasswordField pf1 = new JPasswordField ();
    private JButton b1, close; 
    private JFrame janelaLogin;
    private static ImageIcon icone, icone1, icone2;

    //Novo Login
    public Login(){
        
 // }
        
      // public void novoLogin(){
        
        JLabel fundo = new JLabel(new ImageIcon("Group1.png"));
        fundo.setBounds(0, 0, 330, 400);
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 330, 400);
        p1.add(fundo);

        
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(330, 0, 330, 400);
        l2 = new JLabel ("Bem-Vindo(a)!");
        l2.setFont(new Font("Segoe UI", 1, 24)); 
        l2.setForeground(new Color(1, 96, 128));
        l2.setBounds(80, 45, 170, 32); 
        
        
        JLabel l3 = new JLabel("Usuário", new ImageIcon("User.png"), JLabel.CENTER);
        l3.setFont(new java.awt.Font("Segoe UI", 1, 18));
        l3.setBounds(23, 112, 100, 30);
        
        t2 = new JTextField();
        t2.setBounds(3, 3, 0, 0);
                       
        l6 = new JLabel ("Senha", new ImageIcon("Locker.png"), JLabel.CENTER);
        l6.setFont(new Font("Segoe UI", 1, 18)); 
        l6.setBounds(17, 200, 100, 30);
        
        t1 = new JTextField (20);
        t1.setBounds(30, 150, 260, 23);
        t1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        t1.setForeground(Color.GRAY);
        t1.setText("Introduza Nome");
        t1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        t1.addActionListener(this);
        t1.addFocusListener(this);            
        
        //pf1 = new JPasswordField ();
        pf1.setBounds(30, 238, 260, 23);
        pf1.setFont(new Font("Segoe UI", 0, 14));
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
        close.setBounds(280, 10, 39, 30);
        close.addActionListener(this);
        close.addMouseListener(this);
               
        b1  = new JButton("Entrar");
        b1.setFont(new Font("Segoe UI", 1, 18));
        b1.setForeground(Color.WHITE);
        b1.setBounds(66, 310, 192, 33);
        b1.setBackground(new Color(1, 96, 128));
        b1.setFocusable(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        
        
        p2.add(l2); p2.add(l3); p2.add(l6); p2.add(t1); p2.add(t2);
        p2.add(pf1); p2.add(b1); p2.add(close);
        p2.setBackground(Color.WHITE);
        p2.setBorder(new LineBorder(new Color(1, 96, 128), 1, true));
        
        
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
    
    
    
    public int getPassworsLogin(){
        return Integer.parseInt(String.valueOf(pf1.getPassword()));
    }
        
    
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == t1){
            if(t1.getText().equals("Introduza Nome")){
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
            if(t1.getText().equals("Introduza Nome") || t1.getText().equals("")){
                t1.setText("Introduza Nome");
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
