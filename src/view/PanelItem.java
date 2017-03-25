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
import model.Exame;
import model.Item;

/**
 *
 * @author lala
 */
public class PanelItem extends PanelMae{
    
    private JPanel panelItem = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    private VeterinariaController cont = new VeterinariaController();
    
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
     
    public JPanel setPanelItem(){
        List<Exame> allExames = cont.recuperarExames();
        if(allExames.size() < 0){
            return null;
        }
        panelItem.setLayout(layout);
        
        lblExame.setFont(fonte);
        lblNomeItem.setFont(fonte);
        lblReferencia.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        
        txtNomeItem.setPreferredSize(new Dimension(200, 24));
        txtReferencia.setPreferredSize(new Dimension(200, 24));
        for(Exame item: allExames){
            ComboItem cb = new ComboItem(item.getIdexame(), item.getNome());
           cmbExame.addItem(cb);
        }
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparPanelItem();
            }
        });
        
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(salvarPanelItem() != null){
                    JOptionPane.showMessageDialog(null, "Item salvo com sucesso!");
                    limparPanelItem();
                }else{
                    JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
                }
            }
        });
        
        panelItem.add(lblTitulo, genConstraint(0, 1, 3, 3));
        panelItem.add(lblNomeItem, genConstraint(0, 4, 1, 1));
        panelItem.add(txtNomeItem, genConstraint(1, 4, 1, 1));
        panelItem.add(lblReferencia, genConstraint(0, 5, 1, 1));
        panelItem.add(txtReferencia, genConstraint(1, 5, 1, 1));
        panelItem.add(lblExame, genConstraint(0, 6, 1, 1));
        panelItem.add(cmbExame, genConstraint(1, 6, 1, 1));
        panelItem.add(btnLimpar, genConstraint(0, 7, 1, 1));
        panelItem.add(btnSalvar, genConstraint(1, 7, 1, 1));
        
        return panelItem;
    }
    
    public void limparPanelItem(){
        txtNomeItem.setText("");
        txtReferencia.setText("");
    }
    
    public Item salvarPanelItem(){
        Item item = new Item();
        ComboItem cb = (ComboItem) cmbExame.getSelectedItem();
        item.setExame(cont.recuperarExameporID(cb.getValue()));
        item.setNome(txtNomeItem.getText());
        item.setReferencia(txtReferencia.getText());
        if(cont.salvarItem(item)){
            return item;
        }else{
            return null;
        }        
    }
    
    public JPanel setPanelPesquisarItem(){ //TODO
        return panelItem;
    }
    
    
}