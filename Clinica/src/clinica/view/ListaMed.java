/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ludmila Mucavele
 */
public class ListaMed extends JDialog implements ActionListener{
    JPanel p1, p2;
    JLabel l0;
    JButton b1;
    JTable tabela;
    Font f = new Font("Segoe UI",Font.BOLD,16);
    private String tipo;
   
   public ListaMed(){
       if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("medico");
        }
       p1 = new JPanel(null);
         setModal(true);
     
   }
     public void MedConCir(String tipo){ //tipo vem como parametro no metodo. pode ser Cirurgia ou Consulta
        setSize(650, 600);
        setLocation(300, 100);
        setTitle("Lista de Medicos");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        l0 = new JLabel ("Lista de Medicos Com "+tipo +":");
        l0.setBounds(20, 10, 300, 30);
        l0.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l0.setForeground(Color.GRAY);
        
        
        this.tipo = tipo;
        String [] nomeColuna = {"Codigo de Funcionario", "Nome","Especialidade","Departamento",("Codigo de "+tipo)};
        DefaultTableModel tb = new DefaultTableModel(null,nomeColuna);
        tb.setColumnCount(5);
        tb.setRowCount(30);
       
        tabela = new JTable(tb);
        tabela.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tabela.setForeground(Color.GRAY);
        JScrollPane scrol = new JScrollPane(tabela);
        scrol.setBounds(20,80, 590,400);
        
        b1 = new JButton("Fechar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(430, 500, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBackground(new Color(255, 0, 0));
       
       b1.addActionListener(this);
       
       p1.setBackground(Color.WHITE);
       p1.add(l0); p1.add(scrol); p1.add(b1);
       add(p1);
       if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("medico");
        }
       setResizable(false);
       setVisible(true);
    }

    
    
    public void getMedicos(){
        setSize(1020, 600);
        setLocation(300, 100);
        setTitle("Lista de Medicos");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        l0 = new JLabel ("Lista de Medicos na Clinica:");
        l0.setBounds(20, 10, 300, 30);
        l0.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l0.setForeground(Color.GRAY);
        
       String [] nomeColuna = {"Codigo", "Nome", "Genero", "Nacionalidade", "Telefone", "Morada" ,"Especialidade","Departamento"};
      
        
        DefaultTableModel tb = new DefaultTableModel(null,nomeColuna);
        tb.setColumnCount(8);
        tb.setRowCount(30);
       
        tabela = new JTable(tb);
        tabela.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tabela.setForeground(Color.GRAY);
        JScrollPane scrol = new JScrollPane(tabela);
        scrol.setBounds(20,80, 960,400);
        
        b1 = new JButton("Fechar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(730, 500, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBackground(new Color(255, 0, 0));
       
       b1.addActionListener(this);
       
       p1.setBackground(Color.WHITE);
       p1.add(l0); p1.add(scrol); p1.add(b1);
       add(p1);
       if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("medico");
        }
       setVisible(true);
       setResizable(false);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            byte ab = 0;
            ab = (byte) JOptionPane.showConfirmDialog(null, "Deseja Fechar A Lista?", "Message", JOptionPane.YES_NO_OPTION);
            if (ab == JOptionPane.YES_OPTION) {
                dispose();
                //new Menu("medico");
                
            }
        }
    }
}
