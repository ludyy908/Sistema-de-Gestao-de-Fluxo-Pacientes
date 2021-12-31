/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agostinho
 */
public class ListaReg extends JDialog implements ActionListener{
    
    private JPanel pn1;
    private JLabel l1;
    private JComboBox tipo;
    private JTable tabela;
    private JButton b1;
    
    public ListaReg(){
        
        setTitle("Lista de Registos");
        l1 = new JLabel ("Lista de:");
        l1.setBounds(20, 10, 300, 30);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        l1.setForeground(Color.GRAY);

        tipo = new JComboBox(new String[]{"Consulta", "Cirurgia"});
        tipo.setBackground(Color.WHITE);
        tipo.setBounds(20, 50, 270,25);
        
        
        String [] nomeColuna = {"Codigo","Data","Hora","Nome do Paciente",
            "codigo do Paciente", "Nome do Medico", "Estado"};
        
        DefaultTableModel tb = new DefaultTableModel(null,nomeColuna);
        tb.setColumnCount(7);
        tb.setRowCount(30);
        tabela = new JTable(tb);
        tabela.setBounds(20, 80, 820, 610);
        JScrollPane scrol = new JScrollPane(tabela);
        scrol.setBounds(20,80,820,430);
        
       
        b1 = new JButton("Fechar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(570, 530, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBackground(new Color(255, 0, 0));
        b1.addActionListener(this);
        
        pn1 = new JPanel();
        pn1.setLayout(null);
        pn1.setBounds(0, 0, 700, 100);
        pn1.setBackground(Color.white);
        pn1.add(l1); pn1.add(tipo); pn1.add(scrol); pn1.add(b1); 
        
        add(pn1);
        
        
        setSize(870,630);
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        setResizable(false);
        setLocationRelativeTo(null);
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("registo");
        }
        setVisible(true);
        setTitle("Lista");
        
    }

    @Override
     public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            int op = 0;
            op = JOptionPane.showConfirmDialog(null, "Deseja Fechar a Lista?", "Message", JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.YES_OPTION) {
                dispose();
                new Menu("registo");
            }
        }
        
        
    }
}
