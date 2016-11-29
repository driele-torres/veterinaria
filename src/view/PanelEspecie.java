package view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelEspecie {
    private JPanel panelEspecie = new JPanel();
    private JLabel lblTitulo = new JLabel("Cadastro de Espécie");
    private JLabel lbldescricaoEspecie = new JLabel("Descrição da Espécie:");
    private JTextField txtdescricaoEspecie = new JTextField();
    private JLabel lblNomeEspecie = new JLabel("Nome Científico da Espécie:");
    private JTextField txtNomeEspecie = new JTextField();
    private JButton btnLimpar = new JButton();
    private JButton btnSalvar = new JButton();
    
    public JPanel setPainelEspecie(){
        panelEspecie.setLayout(new GridLayout(3, 3));
        panelEspecie.add(lblNomeEspecie);
        panelEspecie.add(txtNomeEspecie);
        panelEspecie.add(lbldescricaoEspecie);
        panelEspecie.add(txtdescricaoEspecie);

        return panelEspecie;
    }
    
}
