package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CadastroVeterinario extends JFrame{//implements ActionListener
    
    JTextField txfCRV, txtfEspecialidade;
    JLabel lblInfo, lblCRV, lblEspecialidade;
    JButton btnConfirma;
    public CadastroVeterinario(){
        setTitle("Cadastro Veterinario");
        setSize(400,300);
        setLocation(100,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblInfo = new JLabel("Dados do Veterinario");
        lblInfo.setLocation(50,20);
        lblInfo.setSize(200,20);
        
        lblCRV = new JLabel("CRV:");
        lblCRV.setLocation(50,20);
        lblCRV.setSize(200,20);

        lblEspecialidade = new JLabel("CRV:");
        lblEspecialidade.setLocation(50,20);
        lblEspecialidade.setSize(200,20);
        
        txfCRV = new JTextField("");
        txfCRV.setSize(150,20);
        txfCRV.setLocation(100,60);
        
        txtfEspecialidade = new JTextField("");
        txtfEspecialidade.setSize(150,20);
        txtfEspecialidade.setLocation(100,60);
        
        btnConfirma = new JButton("Sair");
        btnConfirma.setSize(80,40);
        btnConfirma.setLocation(130,200);
        btnConfirma.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Cadastrado");
                System.exit(0);
            }
        });
        btnConfirma.setBackground(Color.orange);
        
        getContentPane().setLayout(null);
        getContentPane().add(txfCRV);
        getContentPane().add(txtfEspecialidade);
        getContentPane().add(lblInfo);
        getContentPane().add(lblCRV);
        getContentPane().add(lblEspecialidade);
        getContentPane().add(btnConfirma);
    }
}