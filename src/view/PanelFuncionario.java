package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lala
 */
public class PanelFuncionario {
    
    private JPanel panelFuncionario = new JPanel();
    
    public JPanel setPanelFuncionario(){
        JLabel lblNomeProprietario = new JLabel("Nome:");
        JTextField txtNomeProprietario = new JTextField();
        JLabel lblCPFProprietario = new JLabel("CPF:");
        JTextField txtCPFProprietario = new JTextField();
        JLabel lblEnderecoProprietario = new JLabel("Endereço:");
        JTextField txtEnderecoProprietario = new JTextField();
        JLabel lblTelefoneProprietario = new JLabel("Telefone:");
        JTextField txtTelefoneProprietario = new JTextField();
        
        panelFuncionario.add(lblNomeProprietario);
        panelFuncionario.add(txtNomeProprietario);
        return panelFuncionario;
    }
    
}
