/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinica.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Month;
/**
 *
 * @author Ludmila Mucavele
 */
public class CancelarReg  extends JDialog implements ActionListener {
    
    
    private JLabel l1, l2, nome, dataC, horaC, pontos ;
    private JTextField  tf1;
    private JSpinner mes, ano, dia, horas, minutos;
    private JPanel p1, p2;
    private JComboBox tipo;
    private JButton b1, b2;
    
    public CancelarReg(){
        setTitle("Cancelar Registo");
        setSize (500, 500); setLocation (300, 150);
        setIconImage(new ImageIcon("iconeprincipal.png").getImage());
       

        p1 = new JPanel ();
        p1.setLayout(null);
        p1.setBackground(new Color(8,84, 121));
        p1.setBounds(0, 0, 700, 75);
        

        l1 = new JLabel("Cancelar Consulta/Cirurgia"); 
        l1.setBounds(70,0, 400, 75); 
        l1.setFont(new Font("Imprint MT Shadow", Font.BOLD, 28));
        l1.setForeground(Color.black);
        
        p1.add(l1);
    
        p2 = new JPanel (); p2.setLayout(null);
        p2.setBounds(0, 75, 700, 425);
        p2.setBackground(Color.WHITE);
        
        l2 = new JLabel ("Tipo de Registo que Deseja Cancelar:");
        l2.setBounds(70, 10, 300, 30);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        l2.setForeground(Color.GRAY);

        tipo = new JComboBox(new String[]{"Consulta", "Cirurgia"});
        tipo.setBackground(Color.WHITE);
        tipo.setEditable(true);
        tipo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        tipo.setForeground(Color.GRAY);
        tipo.setBounds(70, 50, 270,25);

        nome = new JLabel ("Nome do Paciente que Deseja Cancelar a Cirurgia:");
        nome.setBounds(70, 85, 300, 30);
        nome.setFont(new Font("Segoe UI", Font.BOLD, 15));
        nome.setForeground(Color.GRAY);

        tf1 = new JTextField(20);
        tf1.setBounds(70, 115, 300, 30);
        tf1.setForeground(Color.GRAY);
        tf1.setText("Introduza o Nome Completo");
        tf1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tf1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));

        dataC = new JLabel ("Data:");
        dataC.setBounds(70, 150, 300, 30);
        dataC.setFont(new Font("Segoe UI", Font.BOLD, 15));
        dataC.setForeground(Color.GRAY);

        String [] anoo = new String[2];
        anoo[0]= "2021"; anoo[1]="2022";
        SpinnerListModel listaAno = new SpinnerListModel(anoo);
        ano = new JSpinner (listaAno);
        ano.setBounds(250, 180, 60, 30);
        ano.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        ano.setForeground(Color.GRAY);
        ano.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));

        Month[] mess = Month.values();
        SpinnerListModel listaMes = new SpinnerListModel(mess);
        mes = new JSpinner (listaMes);
        mes.setBounds(130, 180, 100, 30);
        mes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        mes.setForeground(Color.GRAY);
        mes.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));

        String[] diaa = new String [31];
        for (int i = 0; i < 31; i++)
            diaa[i]= Integer.toString(i+1);
        SpinnerListModel listaDia = new SpinnerListModel(diaa);
        dia = new JSpinner (listaDia);
        dia.setBounds(70, 180, 60, 30);
        dia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        dia.setForeground(Color.GRAY);
        dia.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray)); 

        horaC = new JLabel ("Horas:");
        horaC.setBounds(70, 215, 300, 30);
        horaC.setFont(new Font("Segoe UI", Font.BOLD, 15));
        horaC.setForeground(Color.GRAY);

        String[] hora = new String [24];
        for (int i = 0; i < 24; i++)
            hora[i]= Integer.toString(i);
        SpinnerListModel listaHora = new SpinnerListModel(hora);
        horas = new JSpinner (listaHora);
        horas.setBounds(70, 245, 60, 30);
        horas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        horas.setForeground(Color.GRAY);
        horas.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));

        String[] minuto = new String [60];
        for (int i = 0; i < 60; i++)
            minuto[i]= Integer.toString(i);
        SpinnerListModel listaMinuto = new SpinnerListModel(minuto);
        minutos = new JSpinner (listaMinuto);
        minutos.setBounds(130, 245, 60, 30);
        minutos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        minutos.setForeground(Color.GRAY);
        minutos.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
        minutos.setName("Minutos");

        pontos = new JLabel (":");
        pontos.setBounds(120,245, 100, 30);
        pontos.setFont(new Font("Segoe UI", Font.BOLD, 15));
        pontos.setForeground(Color.GRAY);

        b1 = new JButton("Cancelar");
        b1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 320, 175, 30);
        b1.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 51)));
        b1.setBackground(new Color(255, 0, 0));

        b2 = new JButton("Seguinte");
        b2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        b2.setForeground(Color.WHITE);
        b2.setBounds(270, 320, 175, 30);
        b2.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
        b2.setBackground(new Color(0, 100, 0));


        p2.add(horaC); p2.add(horas); p2.add(minutos); p2.add(dataC);
        p2.add(dia); p2.add(mes); p2.add(ano); p2.add(pontos); p2.add(b1);
        p2.add(b2);  p2.add(nome); p2.add(tf1); p2.add(l2); p2.add(tipo);

        Container c = getContentPane();
        c.setLayout(null);
        c.add(p1); c.add(p2);


        setVisible(true);
        if (this.getDefaultCloseOperation() == 0){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            new Menu("registo");
        }
        setResizable(false);
        
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1){

                new Menu("enfermeiro");
                dispose();

            }

            if(e.getSource() == b2){
                if(tf1.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Por Favor, Preencha os Espacos em Branco.");
                else {
                    dispose();
                    JOptionPane.showMessageDialog(null, "Dados Actualizados Com Sucesso.");
                    new Menu("registo");

                }
            }
        }
}
