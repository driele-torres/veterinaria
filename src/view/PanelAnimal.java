package view;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Raca;

/**
 *
 * @author gmcore
 */
public class PanelAnimal {
    private JPanel panelAnimal = new JPanel();
    private JLabel lblNomeAnimal = new JLabel("Nome do Animal:");
    private  JTextField txtNomeAnimal = new JTextField();
    private JLabel lblDataNascimento = new JLabel("Data de Nascimento do Animal:");
    private JTextField txtDataNascimento = new JTextField();
    private JLabel lblRacaAnimal = new JLabel("Raça do Animal:");
    private JComboBox cmbRacaAnimal = new JComboBox();
    
    public JPanel setPainelAnimal(List<Raca> allRacas){
       
       for(Raca item: allRacas){
           cmbRacaAnimal.addItem(item.getDescricao());
       }
       panelAnimal.add(lblNomeAnimal);
       panelAnimal.add(txtNomeAnimal);
       panelAnimal.add(lblDataNascimento);
       panelAnimal.add(txtDataNascimento);
       panelAnimal.add(lblRacaAnimal);
       panelAnimal.add(cmbRacaAnimal);

       return panelAnimal;
    }
    
}
