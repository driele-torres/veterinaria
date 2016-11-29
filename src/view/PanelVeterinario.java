package view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lala
 */
public class PanelVeterinario {
    
    private JPanel panelVeterinario = new JPanel();
    JTextField txfCRV, txtfEspecialidade;
    JLabel lblInfo, lblCRV, lblEspecialidade;
    JButton btnConfirma;
    
    public JPanel setPanelVeterinario(){
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
        
        panelVeterinario.setLayout(new GridBagLayout());
        panelVeterinario.add(txfCRV);
        panelVeterinario.add(txtfEspecialidade);
        panelVeterinario.add(lblInfo);
        panelVeterinario.add(lblCRV);
        panelVeterinario.add(lblEspecialidade);
        panelVeterinario.add(btnConfirma);
        
        return panelVeterinario;
    }
    
}
