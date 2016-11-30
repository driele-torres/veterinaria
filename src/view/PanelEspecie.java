package view;

import controller.VeterinariaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Especie;

public class PanelEspecie extends PanelMae{
    private JPanel panelEspecie = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    private VeterinariaController cont = new VeterinariaController();
    
    private JLabel lblTitulo = new JLabel("Cadastro de Espécie");
    private JLabel lbldescricaoEspecie = new JLabel("Descrição da Espécie:");
    private JTextField txtdescricaoEspecie = new JTextField();
    private JLabel lblNomeEspecie = new JLabel("Nome Científico da Espécie:");
    private JTextField txtNomeEspecie = new JTextField();
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnSalvar = new JButton("Salvar"); 
    private GridBagLayout layout = new GridBagLayout();
    
    
    public JPanel setPainelEspecie(){
        panelEspecie.setLayout(layout);
 
        lblNomeEspecie.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        lbldescricaoEspecie.setFont(fonte);
        
        txtNomeEspecie.setPreferredSize(new Dimension(200, 24));
        txtdescricaoEspecie.setPreferredSize(new Dimension(200, 24));
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparPanelEspecie();
            }
        });
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(salvarPanelEspecie()!= null){
                    JOptionPane.showMessageDialog(null, "Espécie salvo com sucesso!");
                    limparPanelEspecie();
                }else{
                    JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
                }
            }
        });
        
        panelEspecie.add(lblTitulo, genConstraint(0, 0, 1, 1));
        panelEspecie.add(lblNomeEspecie, genConstraint(0, 1, 1, 1));
        panelEspecie.add(txtNomeEspecie, genConstraint(1, 1, 1, 1));
        panelEspecie.add(lbldescricaoEspecie, genConstraint(0, 2, 1, 1));
        panelEspecie.add(txtdescricaoEspecie, genConstraint(1, 2, 1, 1));
        panelEspecie.add(btnLimpar, genConstraint(0, 3, 1, 1));
        panelEspecie.add(btnSalvar, genConstraint(1, 3, 1, 1));

        return panelEspecie;
    }
    
    public void limparPanelEspecie(){
        txtNomeEspecie.setText("");
        txtdescricaoEspecie.setText("");        
    }
    
    public Especie salvarPanelEspecie(){
        Especie especie = new Especie();
        especie.setDescricao(txtdescricaoEspecie.getText());
        especie.setNomeCientifico(txtNomeEspecie.getText());
        cont.salvarEspecie(especie);
        return especie;
    }
}