package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lala
 */
public class PanelExame extends PanelMae{
    
    private JPanel panelExame = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    private JLabel lblTitulo = new JLabel("Cadastro de Exames");
    JLabel lblNomeExame = new JLabel("Nome do Exame:");
    JTextField txtNomeExame = new JTextField();
    JLabel lblAreaExame = new JLabel("Area do Exame:");
    JTextField txtAreaExame = new JTextField();
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnSalvar = new JButton("Salvar"); 
    private GridBagLayout layout = new GridBagLayout();
    
    public JPanel setPanelExame(){
        panelExame.setLayout(layout);
        
        lblAreaExame.setFont(fonte);
        lblNomeExame.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        
        txtAreaExame.setPreferredSize(new Dimension(200, 24));
        txtNomeExame.setPreferredSize(new Dimension(200, 24));
       
        panelExame.add(lblTitulo, genConstraint(0, 0, 1, 1));
        panelExame.add(lblNomeExame , genConstraint(0, 1, 1, 1));
        panelExame.add(txtNomeExame, genConstraint(1, 0, 1, 1));
        panelExame.add(lblAreaExame, genConstraint(0, 1, 1, 1));
        panelExame.add(txtAreaExame, genConstraint(1, 1, 1, 1));
        panelExame.add(btnLimpar, genConstraint(0, 2, 1, 1));
        panelExame.add(btnSalvar, genConstraint(1, 2, 1, 1));
        return panelExame;
    }
    
}