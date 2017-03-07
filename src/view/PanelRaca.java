package view;

import controller.VeterinariaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Especie;
import model.Raca;

public class PanelRaca extends PanelMae{
    private JPanel panelRaca = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    private VeterinariaController cont = new VeterinariaController();
    
    JLabel lblTitulo = new JLabel("Cadastro de Raças");
    JLabel lbldescricaoRaca = new JLabel("Nome da Raça:");
    JTextField txtdescricaoRaca = new JTextField();
    JLabel lblNomeEspecie = new JLabel("Nome da Espécie:");
    JComboBox cmbnomeEspecie = new JComboBox();
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnSalvar = new JButton("Salvar"); 
    private GridBagLayout layout = new GridBagLayout();
    
    
     public JPanel setPainelRaca(){  
         List<Especie> allEspecies = cont.recuperarEspecies();
         if(allEspecies.size() < 0){
             return null;
         }
        panelRaca.setLayout(layout);
        lblNomeEspecie.setFont(fonte);
        lbldescricaoRaca.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        
        txtdescricaoRaca.setPreferredSize(new Dimension(200, 24));
        cmbnomeEspecie.setPreferredSize(new Dimension(200, 24));
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparPanelRaca();
            }
        });
        
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(salvarPanelRaca()!= null){
                    JOptionPane.showMessageDialog(null, "Raça salva com sucesso!");
                    limparPanelRaca();
                }else{
                    JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
                }
            }
        });
       
        for(Especie item: allEspecies){
           cmbnomeEspecie.addItem(new ComboItem(item.getIdespecie(), item.getNomeCientifico()));
        }
       panelRaca.add(lblTitulo, genConstraint(0, 1, 3, 3));
       panelRaca.add(lbldescricaoRaca, genConstraint(0, 4, 1, 1));
       panelRaca.add(txtdescricaoRaca, genConstraint(1, 4, 1, 1));
       panelRaca.add(lblNomeEspecie, genConstraint(0, 5, 1, 1));
       panelRaca.add(cmbnomeEspecie, genConstraint(1, 5, 1, 1));
       panelRaca.add(btnLimpar, genConstraint(0, 6, 1, 1));
       panelRaca.add(btnSalvar, genConstraint(1, 6, 1, 1));

       return panelRaca;  
    }
     
    public void limparPanelRaca(){
        txtdescricaoRaca.setText("");
        cmbnomeEspecie.setSelectedIndex(0);
    }
    
    public Raca salvarPanelRaca(){
        Raca raca = new Raca();
        ComboItem cb = (ComboItem) cmbnomeEspecie.getSelectedItem();
        raca.setEspecie(cont.recuperarEspeciePorID(cb.getValue()));
        raca.setDescricao(txtdescricaoRaca.getText());
        limparPanelRaca();
        if(cont.salvarRaca(raca)){
            return raca;
        }else{
            return null;
        }
        
    }
    
}