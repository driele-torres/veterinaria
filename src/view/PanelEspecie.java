package view;

import controller.EspecieController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Especie;

public class PanelEspecie implements ActionListener{
    private final EspecieController cntEspecie = new EspecieController();
    private final JPanel panelEspecie = new JPanel();
    private final Font fonte = new Font("Serif", Font.PLAIN, 14);
    private final Font fonteTitle = new Font("Serif", Font.CENTER_BASELINE, 20);
    
    private final JLabel lblTitulo = new JLabel("Cadastro de Espécie");
    private final JLabel lbldescricaoEspecie = new JLabel("Descrição da Espécie:");
    private final JTextField txtdescricaoEspecie = new JTextField();
    private final JLabel lblNomeEspecie = new JLabel("Nome Científico da Espécie:");
    private final JTextField txtNomeEspecie = new JTextField();
    private final JButton btnLimpar = new JButton("Limpar");
    private final JButton btnSalvar = new JButton("Salvar"); 
    private final GridBagLayout layout = new GridBagLayout();
    
    public GridBagConstraints genConstraint(int x, int y, int w, int h){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.insets = new Insets(10, 10, 10, 10);
        return c;
     }
    
    public JPanel setPainelEspecie(){
        panelEspecie.setLayout(layout);
 
        lblNomeEspecie.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        lbldescricaoEspecie.setFont(fonte);
        
        txtNomeEspecie.setPreferredSize(new Dimension(200, 24));
        txtdescricaoEspecie.setPreferredSize(new Dimension(200, 24));
        
        panelEspecie.add(lblTitulo, genConstraint(0, 0, 1, 1));
        panelEspecie.add(lblNomeEspecie, genConstraint(0, 1, 1, 1));
        panelEspecie.add(txtNomeEspecie, genConstraint(1, 1, 1, 1));
        panelEspecie.add(lbldescricaoEspecie, genConstraint(0, 2, 1, 1));
        panelEspecie.add(txtdescricaoEspecie, genConstraint(1, 2, 1, 1));
        panelEspecie.add(btnLimpar, genConstraint(0, 3, 1, 1));
        panelEspecie.add(btnSalvar, genConstraint(1, 3, 1, 1));
        
        btnSalvar.addActionListener(this);

        return panelEspecie;
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        Especie especie = new Especie();
        especie.setDescricao(txtNomeEspecie.getText());
        especie.setNomeCientifico(txtdescricaoEspecie.getText());
        cntEspecie.salvarEspecie(especie);
    }
}
