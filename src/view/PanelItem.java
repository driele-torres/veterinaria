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
import model.Exame;

/**
 *
 * @author lala
 */
public class PanelItem extends PanelMae{
    
    private JPanel panelItem = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    
    private JLabel lblTitulo = new JLabel("Cadastro de Itens");

    JLabel lblNomeItem = new JLabel("Nome do Item:");
    JTextField txtNomeItem = new JTextField();
    JLabel lblReferencia = new JLabel("Referência:");
    JTextField txtReferencia = new JTextField();
    JLabel lblExame = new JLabel("Exame:");
    JComboBox cmbExame = new JComboBox();
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnSalvar = new JButton("Salvar"); 
    private GridBagLayout layout = new GridBagLayout();
     
    public JPanel setPanelItem(List<Exame> allExames){
        panelItem.setLayout(layout);
        
        lblExame.setFont(fonte);
        lblNomeItem.setFont(fonte);
        lblReferencia.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        
        txtNomeItem.setPreferredSize(new Dimension(200, 24));
        txtReferencia.setPreferredSize(new Dimension(200, 24));
        for(Exame item: allExames){
           cmbExame.addItem(item.getNome());
        }
        
        panelItem.add(lblTitulo, genConstraint(0, 0, 1, 1));
        panelItem.add(lblNomeItem, genConstraint(0, 1, 1, 1));
        panelItem.add(txtNomeItem, genConstraint(1, 1, 1, 1));
        panelItem.add(lblReferencia, genConstraint(0, 2, 1, 1));
        panelItem.add(txtReferencia, genConstraint(1, 2, 1, 1));
        panelItem.add(lblExame, genConstraint(0, 3, 1, 1));
        panelItem.add(cmbExame, genConstraint(0, 3, 1, 1));
        panelItem.add(btnLimpar, genConstraint(0, 4, 1, 1));
        panelItem.add(btnSalvar, genConstraint(1, 4, 1, 1));
        
        return panelItem;
    }
    
    
}