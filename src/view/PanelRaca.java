package view;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Especie;

public class PanelRaca {
    private JPanel panelRaca = new JPanel();
    JLabel lbldescricaoRaca = new JLabel("Nome da Raça:");
    JTextField txtdescricaoRaca = new JTextField();
    JLabel lblNomeEspecie = new JLabel("Nome da Espécie:");
    JComboBox cmbnomeEspecie = new JComboBox();
    
     public JPanel setPainelRaca(List<Especie> allEspecies){       
       for(Especie item: allEspecies){
           cmbnomeEspecie.addItem(item.getDescricao());
       }
       panelRaca.add(lbldescricaoRaca);
       panelRaca.add(txtdescricaoRaca);
       panelRaca.add(lblNomeEspecie);
       panelRaca.add(cmbnomeEspecie);

       return panelRaca;  
    }
    
}
