/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import clinica.controller.PacController;
import clinica.model.Paciente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ludmila Mucavele Celestino
 */
public class ListaPac extends JDialog implements ActionListener {
    JPanel p1, p2;
    JLabel l0;
    JButton b1;
    JTable tabela;
    Font f = new Font("Segoe UI",Font.BOLD,16);
   
   public ListaPac(){
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("paciente");
        };
        p1 = new JPanel();
        p1.setLayout(null);

        setModal(true);
        setSize(1150, 600);
        setLocation(115, 75);
        setTitle("Lista de Pacientes");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        l0 = new JLabel ("Lista de Pacientes da Clinica:");
        l0.setBounds(20, 10, 300, 30);
        l0.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l0.setForeground(Color.GRAY);
        
       String [] nomeColuna = {"Codigo", "Apelido","Nome", "Genero", "Idade", "Nacionalidade", "BI", "Estado Civil", "Telefone", "Endereco/Morada"};
      
        
        DefaultTableModel tb = new DefaultTableModel(null,nomeColuna);
        tb.setColumnCount(10);
        tb.setRowCount(30);
       
        tabela = new JTable(tb);
        tabela.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tabela.setForeground(Color.GRAY);
        JScrollPane scrol = new JScrollPane(tabela);
        
        inserirDadosTabela(tb);
        scrol.setBounds(20,80, 1100,400);
        
        b1 = new JButton("Fechar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(900, 500, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBackground(new Color(255, 0, 0));
       
       b1.addActionListener(this);
       
       p1.setBackground(Color.WHITE);
       p1.add(l0); p1.add(scrol); p1.add(b1);
       add(p1);
       setVisible(true);
       setResizable(false);
   } 
   
   
    //metodo para adcionar os dados na tabela
   public void inserirDadosTabela(  DefaultTableModel modelo){
       int count = 0;
       modelo.setNumRows(0);
       PacController pc = new PacController();
        ArrayList<Paciente> p = pc.getDados();
       for(int i=0;i<pc.getDados().size();i++){
           //String [] pac =  pc.getDados().get(i);
           modelo.addRow(new String[]{String.valueOf(p.get(i).getIdPaciente()),
                                p.get(i).getApelido(),
                                p.get(i).getNome(),
                                p.get(i).getSexo(),
                                String.valueOf(p.get(i).getIdade()),
                                p.get(i).getNacionalidade(),
                                p.get(i).getBi(),
                                p.get(i).getEstadoCivil(),                            
                                p.get(i).getTel1(),
                                p.get(i).getEndereco()});
                             count ++;
                               
                                
                                //p.get(i).getTel2()});
       }
       
   }      
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            byte ab = 0;
            ab = (byte) JOptionPane.showConfirmDialog(null, "Deseja Fechar A Lista?", "Message", JOptionPane.YES_NO_OPTION);
            if (ab == JOptionPane.YES_OPTION) {
                dispose();
                //new Menu("paciente");
                
            }
        }
    }
 
}
