package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lala
 */
public class PanelItem {
    
    private JPanel panelItem = new JPanel();
    
    public JPanel setPanelItem(){
        JLabel lblNomeProprietario = new JLabel("Nome:");
        JTextField txtNomeProprietario = new JTextField();
        JLabel lblCPFProprietario = new JLabel("CPF:");
        JTextField txtCPFProprietario = new JTextField();
        JLabel lblEnderecoProprietario = new JLabel("Endereço:");
        JTextField txtEnderecoProprietario = new JTextField();
        JLabel lblTelefoneProprietario = new JLabel("Telefone:");
        JTextField txtTelefoneProprietario = new JTextField();
        
        panelItem.add(lblNomeProprietario);
        panelItem.add(txtNomeProprietario);
        return panelItem;
    }
    
    
}
