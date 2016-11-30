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
import model.Raca;

public class PanelAnimal extends PanelMae{
    private JPanel panelAnimal = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    
    private JLabel lblTitulo = new JLabel("Cadastro de Animais");
    private JLabel lblNomeAnimal = new JLabel("Nome do Animal:");
    private  JTextField txtNomeAnimal = new JTextField();
    private JLabel lblDataNascimento = new JLabel("Data de Nascimento do Animal:");
    private JTextField txtDataNascimento = new JTextField();
    private JLabel lblRacaAnimal = new JLabel("Raça do Animal:");
    private JComboBox cmbRacaAnimal = new JComboBox();
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnSalvar = new JButton("Salvar"); 
    private GridBagLayout layout = new GridBagLayout();
    
    public JPanel setPainelAnimal(List<Raca> allRacas){
       panelAnimal.setLayout(layout);
       
       lblDataNascimento.setFont(fonte);
       lblNomeAnimal.setFont(fonte);
       lblRacaAnimal.setFont(fonte);
       lblTitulo.setFont(fonteTitle);
       
       txtDataNascimento.setPreferredSize(new Dimension(200, 24));
       txtNomeAnimal.setPreferredSize(new Dimension(200, 24));
       cmbRacaAnimal.setPreferredSize(new Dimension(200, 24));
       
       for(Raca item: allRacas){
           cmbRacaAnimal.addItem(item.getDescricao());
       }
       panelAnimal.add(lblTitulo, genConstraint(0, 0, 1, 1));
       panelAnimal.add(lblNomeAnimal, genConstraint(0, 1, 1, 1));
       panelAnimal.add(txtNomeAnimal, genConstraint(1, 1, 1, 1));
       panelAnimal.add(lblDataNascimento, genConstraint(0, 2, 1, 1));
       panelAnimal.add(txtDataNascimento, genConstraint(1, 2, 1, 1));
       panelAnimal.add(lblRacaAnimal, genConstraint(0, 3, 1, 1));
       panelAnimal.add(cmbRacaAnimal, genConstraint(1, 3, 1, 1));
       panelAnimal.add(btnLimpar, genConstraint(0, 4, 1, 1));
       panelAnimal.add(btnSalvar, genConstraint(1, 4, 1, 1));

       return panelAnimal;
    }
    
}