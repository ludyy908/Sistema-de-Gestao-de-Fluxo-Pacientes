/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import clinica.controller.EnfControl;
import clinica.model.Enfermeiro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ludmila Mucavele
 */
public class ListaEnf extends JDialog implements ActionListener{
  JPanel p1, p2;
    JLabel l0;
    JButton b1;
    JTable tabela;
    Font f = new Font("Segoe UI",Font.BOLD,16);
   
   public ListaEnf(){
       if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("enfermeiro");
        }
       p1 = new JPanel(null);

         setModal(true);
        setSize(1020, 600);
        setLocation(135, 70);
        setTitle("Lista de Enfermeiros");
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
        l0 = new JLabel ("Lista de Enfermeiros na Clinica:");
        l0.setBounds(20, 10, 300, 30);
        l0.setFont(new Font("Segoe UI", Font.BOLD, 16));
        l0.setForeground(Color.GRAY);
        
       String [] nomeColuna = {"Codigo", "Nome", "Genero", "Nacionalidade", "Telefone", "Morada" ,"Categoria","Departamento"};
      
        
        DefaultTableModel tb = new DefaultTableModel(null,nomeColuna);
        //tb.setColumnCount(8);
        //tb.setRowCount(30);
       
        tabela = new JTable(tb);
        tabela.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tabela.setForeground(Color.GRAY);
        JScrollPane scrol = new JScrollPane(tabela);
        scrol.setBounds(20,80, 960,300);
        inserirDadosTabela(tb);
          
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
       setVisible(true);
       setResizable(false);
   }   
    
   public void inserirDadosTabela(  DefaultTableModel modelo){
       modelo.setNumRows(0);
       EnfControl ec = new EnfControl();
       ArrayList<Enfermeiro> lista = ec.getDados();
       for(int i=0;i<lista.size();i++){
          // String [] enf =  ec.getDados().get(i);
           modelo.addRow(new String[]{String.valueOf(lista.get(i).getIdFuncionario()),
                                        lista.get(i).getNomeFunc(), 
                                        lista.get(i).getSexo(),
                                        lista.get(i).getContacto(),
                                        lista.get(i).getMorada(),
                                        lista.get(i).getNacionalidade(),
                                        lista.get(i).getDepartamento(),
                                        lista.get(i).getCategoria()});
        }
   
   }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            byte ab = 0;
            ab = (byte) JOptionPane.showConfirmDialog(null, "Deseja Fechar A Lista?", "Message", JOptionPane.YES_NO_OPTION);
            if (ab == JOptionPane.YES_OPTION) {
                dispose();
               // new Menu("enfermeiro");
                
            }
        }
    }

}
