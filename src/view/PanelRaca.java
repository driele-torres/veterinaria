package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Especie;

public class PanelRaca extends PanelMae{
    private JPanel panelRaca = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    
    JLabel lblTitulo = new JLabel("Cadastro de Raças");
    JLabel lbldescricaoRaca = new JLabel("Nome da Raça:");
    JTextField txtdescricaoRaca = new JTextField();
    JLabel lblNomeEspecie = new JLabel("Nome da Espécie:");
    JComboBox cmbnomeEspecie = new JComboBox();
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnSalvar = new JButton("Salvar"); 
    private GridBagLayout layout = new GridBagLayout();
    
    
     public JPanel setPainelRaca(List<Especie> allEspecies){  
        panelRaca.setLayout(layout);
        lblNomeEspecie.setFont(fonte);
        lbldescricaoRaca.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        
        txtdescricaoRaca.setPreferredSize(new Dimension(200, 24));
        cmbnomeEspecie.setPreferredSize(new Dimension(200, 24));
       
        for(Especie item: allEspecies){
           cmbnomeEspecie.addItem(item.getDescricao());
       }
       panelRaca.add(lblTitulo, genConstraint(0, 0, 1, 1));
       panelRaca.add(lbldescricaoRaca, genConstraint(0, 1, 1, 1));
       panelRaca.add(txtdescricaoRaca, genConstraint(1, 1, 1, 1));
       panelRaca.add(lblNomeEspecie, genConstraint(0, 2, 1, 1));
       panelRaca.add(cmbnomeEspecie, genConstraint(1, 2, 1, 1));
       panelRaca.add(btnLimpar, genConstraint(0, 3, 1, 1));
       panelRaca.add(btnSalvar, genConstraint(1, 3, 1, 1));

       return panelRaca;  
    }
    
}