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
    
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }; 
    private JTable table = new JTable(modelo);
    private JScrollPane barraRolagem;
    private Map <Integer, Raca>  racaTable = new HashMap<Integer, Raca>();
    private Raca raca;
    
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
        if(txtdescricaoRaca.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
            return null;
        }
        if(this.raca == null){
            raca = new Raca();
        }
        
        ComboItem cb = (ComboItem) cmbnomeEspecie.getSelectedItem();
        raca.setEspecie(cont.recuperarEspeciePorID(cb.getValue()));
        raca.setDescricao(txtdescricaoRaca.getText());
        limparPanelRaca();
        boolean salvou = false;
        if(raca.getIdraca().equals(0))
           salvou = cont.salvarRaca(raca);
        else
            salvou = cont.atualizarRaca(raca);
        if(salvou){
            return raca;
        }else{
            return null;
        }
    }
    
    public JPanel setPanelPesquisarRaca(){ 
        panelRaca = new JPanel();
        panelRaca.setLayout(layout);
        JLabel lblTitle = new JLabel("Consulta Raca");
        JLabel lblNome = new JLabel("Digite a descricao da Raca: ");
        lblTitle.setFont(fonteTitle);
        lblNome.setFont(fonte);
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnEditar = new JButton("Editar");
       
       table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        
        modelo.addColumn("ID");
        modelo.addColumn("DESCRICAO");
	modelo.addColumn("ESPECIE");
        
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
        
        txtdescricaoRaca.setPreferredSize(new Dimension(200, 24));
        panelRaca.add(lblTitle, genConstraint(0, 0, 2, 1));
       panelRaca.add(lblNome, genConstraint(0, 1, 1, 1));
       panelRaca.add(txtdescricaoRaca, genConstraint(1, 1, 1, 1));
       panelRaca.add(barraRolagem, genConstraint(0, 2, 2, 1));
       panelRaca.add(btnPesquisar, genConstraint(0, 3, 1, 1));
       panelRaca.add(btnEditar, genConstraint(1, 3, 1, 1));
       return panelRaca;
    }
    
    public void clickedBtnPesquisar(){
                modelo.setNumRows(0);

        List<Raca> racas = new ArrayList<Raca>();
        String nome = "%" + txtdescricaoRaca.getText() + "%";
        racas = cont.recuperarRacasDesc(nome);
        for (int i = 0; i < racas.size(); i++) {
            modelo.addRow(new Object[]{racas.get(i).getIdraca(), racas.get(i).getDescricao(), racas.get(i).getEspecie().getDescricao()});
            racaTable.put(i, racas.get(i));
	}
        TelaLogin.telaPrincipal.setJPanel(panelRaca);
    }
    
    public void clickedBtnEditar(){
        Integer row = table.getSelectedRow();
        if(row < 0){
             JOptionPane.showMessageDialog(null, "Selecione um para editar");
             return;
        }
        panelRaca.removeAll();
        Raca raca = racaTable.get(row);
        JPanel panel = setPainelRaca();
        
        txtdescricaoRaca.setText(raca.getDescricao());
        ComboBoxModel modelRaca = cmbnomeEspecie.getModel();
        for(int i = 0; i < modelRaca.getSize(); i++){
            ComboItem item = (ComboItem) modelRaca.getElementAt(i);
            if(raca.getEspecie().getIdespecie().equals(item.getValue())){
                cmbnomeEspecie.setSelectedIndex(i);
                break;
            }
        }
        this.raca = raca; 
        TelaLogin.telaPrincipal.setJPanel(panel);
    }
    
}