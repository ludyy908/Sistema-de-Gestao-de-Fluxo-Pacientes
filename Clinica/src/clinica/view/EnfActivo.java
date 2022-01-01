/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ludmila Mucavele
 */
public class EnfActivo extends JDialog implements ActionListener {
    
    private JTable table;
    
    private JPanel painel3;
    private JButton botao;
    private JLabel l1;
    
    public EnfActivo() {
        setLayout(new FlowLayout());
        String[] columns = {"Codigo", "Nome", "Categoria", "Departamento"};
        
        DefaultTableModel tabela = new DefaultTableModel(null, columns);
        tabela.setColumnCount(4);
        tabela.setRowCount(20);
        
        table = new JTable(tabela);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(30, 60, 700, 300);
        
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        
        l1 = new JLabel();
        l1 = new JLabel ("Lista de Enfermeiros Activos:");
        l1.setBounds(30, 10, 300, 30);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        l1.setForeground(Color.GRAY);
        
        
        
        painel3 = new JPanel();
        painel3.setLayout(null);
        painel3.setBounds(0, 0, 800, 500);
        painel3.add(scroll);
        painel3.setBackground(Color.WHITE);
        
        
        botao = new JButton("Fechar");
        botao.setBounds(550, 400, 175, 30);
        botao.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        botao.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botao.addActionListener(this);
        botao.setForeground(Color.white);
        botao.setBackground(new Color(0, 100, 0));
        botao.setBorderPainted(false);
        botao.setFocusable(false);
        painel3.add(botao); painel3.add(l1);
        
        
        this.setTitle("Enfermeiros Ativos");
        this.setSize(800, 500);
        
        this.add(painel3);
       
        this.setResizable(false);
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("enfermeiro");
        }
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botao) {
            byte ab = 0;
            ab = (byte) JOptionPane.showConfirmDialog(null, "Deseja Fechar A Lista?", "Message", JOptionPane.YES_NO_OPTION);
            if (ab == JOptionPane.YES_OPTION) {
                dispose();
                new Menu("enfermeiro");
                
            }
        }
    }
    
}
