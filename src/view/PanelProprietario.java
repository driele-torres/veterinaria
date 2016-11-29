package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelProprietario {
    private JPanel panelProprietario = new JPanel();
            
    public JPanel setPanelProprietario(){
        JLabel lblNomeProprietario = new JLabel("Nome:");
        JTextField txtNomeProprietario = new JTextField();
        JLabel lblCPFProprietario = new JLabel("CPF:");
        JTextField txtCPFProprietario = new JTextField();
        JLabel lblEnderecoProprietario = new JLabel("Endereço:");
        JTextField txtEnderecoProprietario = new JTextField();
        JLabel lblTelefoneProprietario = new JLabel("Telefone:");
        JTextField txtTelefoneProprietario = new JTextField();
        
        panelProprietario.add(lblNomeProprietario);
        panelProprietario.add(txtNomeProprietario);
        panelProprietario.add(lblCPFProprietario);
        panelProprietario.add(txtCPFProprietario);
        panelProprietario.add(lblEnderecoProprietario);
        panelProprietario.add(txtEnderecoProprietario);
        panelProprietario.add(lblTelefoneProprietario);
        panelProprietario.add(txtTelefoneProprietario);
        
        return panelProprietario;
    }
    
}
