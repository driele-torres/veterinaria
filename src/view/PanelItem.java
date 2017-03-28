package view;

import controller.VeterinariaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
    
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }; 
    private JTable table = new JTable(modelo);
    private JScrollPane barraRolagem;
    private Map <Integer, Item>  itemTable = new HashMap<Integer, Item>();
    private Item item;
     
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
        cmbExame.setPreferredSize(new Dimension(200, 24));
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
        if(txtNomeItem.getText().isEmpty() || txtReferencia.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
            return null;
        }
        if(this.item == null){
            item = new Item();
        }

        ComboItem cb = (ComboItem) cmbExame.getSelectedItem();
        item.setExame(cont.recuperarExameporID(cb.getValue()));
        item.setNome(txtNomeItem.getText());
        item.setReferencia(txtReferencia.getText());
        boolean salvou = false;
        if(item.getIditem() == null)
           salvou = cont.salvarItem(item);
        else
            salvou  = cont.atualizaItem(item);
        if(salvou){
            return item;
        }else{
            return null;
        }        
    }
    
    public JPanel setPanelPesquisarItem(){ 
        panelItem = new JPanel();
        panelItem.setLayout(layout);
        JLabel lblTitle = new JLabel("Consulta Item");
        JLabel lblNome = new JLabel("Digite o nome do Item: ");
        lblTitle.setFont(fonteTitle);
        lblNome.setFont(fonte);
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnEditar = new JButton("Editar");
       
       table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        
        modelo.addColumn("ID");
        modelo.addColumn("EXAME");
	modelo.addColumn("NOME");
	modelo.addColumn("REFERENCIA");
        
        barraRolagem = new JScrollPane(table);
        barraRolagem.createVerticalScrollBar();
        barraRolagem.createHorizontalScrollBar();
        
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               clickedBtnPesquisar();
            }
        });
        
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clickedBtnEditar();
            }
        });
        
        txtNomeItem.setPreferredSize(new Dimension(200, 24));
        panelItem.add(lblTitle, genConstraint(0, 0, 2, 1));
       panelItem.add(lblNome, genConstraint(0, 1, 1, 1));
       panelItem.add(txtNomeItem, genConstraint(1, 1, 1, 1));
       panelItem.add(barraRolagem, genConstraint(0, 2, 2, 1));
       panelItem.add(btnPesquisar, genConstraint(0, 3, 1, 1));
       panelItem.add(btnEditar, genConstraint(1, 3, 1, 1));
       return panelItem;
    }
    
     public void clickedBtnPesquisar(){
                 modelo.setNumRows(0);

        List<Item> items = new ArrayList<Item>();
        String nome = "%" + txtNomeItem.getText() + "%";
        items = cont.recuperarItemsPorDescricao(nome);
        for (int i = 0; i < items.size(); i++) {
            modelo.addRow(new Object[]{items.get(i).getIditem(), items.get(i).getExame().getNome(), items.get(i).getNome(), 
                items.get(i).getReferencia()});
            itemTable.put(i, items.get(i));
	}
        TelaLogin.telaPrincipal.setJPanel(panelItem);
    }
    
    public void clickedBtnEditar(){
        Integer row = table.getSelectedRow();
        if(row < 0){
             JOptionPane.showMessageDialog(null, "Selecione um para editar");
             return;
        }
        panelItem.removeAll();
        
        Item item = itemTable.get(row);
        JPanel panel = setPanelItem();
        
        txtNomeItem.setText(item.getNome());
        txtReferencia.setText(item.getReferencia());
        ComboBoxModel modelRaca = cmbExame.getModel();
        for(int i = 0; i < modelRaca.getSize(); i++){
            ComboItem itemCMB = (ComboItem) modelRaca.getElementAt(i);
            if(item.getExame().getIdexame().equals(itemCMB.getValue())){
                cmbExame.setSelectedIndex(i);
                break;
            }
        }
        
        this.item = item; 
        TelaLogin.telaPrincipal.setJPanel(panel);
    }
    
    
}