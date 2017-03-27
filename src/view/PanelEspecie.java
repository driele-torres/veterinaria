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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
    
    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }; 
    private JTable table = new JTable(modelo);
    private JScrollPane barraRolagem;
    private Map <Integer, Especie>  especieTable = new HashMap<Integer, Especie>();
    private Especie especie;
  
    
    
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
        
        panelEspecie.add(lblTitulo, genConstraint(0, 1, 4, 4));
        panelEspecie.add(lblNomeEspecie, genConstraint(0, 5, 1, 1));
        panelEspecie.add(txtNomeEspecie, genConstraint(1, 5, 1, 1));
        panelEspecie.add(lbldescricaoEspecie, genConstraint(0, 6, 1, 1));
        panelEspecie.add(txtdescricaoEspecie, genConstraint(1, 6, 1, 1));
        panelEspecie.add(btnLimpar, genConstraint(0, 7, 1, 1));
        panelEspecie.add(btnSalvar, genConstraint(1, 7, 1, 1));

        return panelEspecie;
    }
    
    public void limparPanelEspecie(){
        txtNomeEspecie.setText("");
        txtdescricaoEspecie.setText("");        
    }
    
    public Especie salvarPanelEspecie(){
        if(txtNomeEspecie.getText().isEmpty() || txtdescricaoEspecie.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
            return null;
        }
        if(this.especie == null){
            especie = new Especie();
        }
        especie.setDescricao(txtdescricaoEspecie.getText());
        especie.setNomeCientifico(txtNomeEspecie.getText());
        if(especie.getIdespecie().equals(0))
            cont.salvarEspecie(especie);
        else
            cont.atualizaEspecie(especie);
        limparPanelEspecie();
        return especie;
    }
    
    public JPanel setPanelPesquisarEspecie(){
       panelEspecie = new JPanel();
        panelEspecie.setLayout(layout);
        JLabel lblTitle = new JLabel("Consulta Especie");
        JLabel lblNome = new JLabel("Digite a descricao da Especie: ");
        lblTitle.setFont(fonteTitle);
        lblNome.setFont(fonte);
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnEditar = new JButton("Editar");
       
       table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        
        modelo.addColumn("ID");
	modelo.addColumn("NOME CIENTIFICO");
        modelo.addColumn("DESCRICAO");
        
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
        
        txtdescricaoEspecie.setPreferredSize(new Dimension(200, 24));
        panelEspecie.add(lblTitle, genConstraint(0, 0, 2, 1));
       panelEspecie.add(lblNome, genConstraint(0, 1, 1, 1));
       panelEspecie.add(txtdescricaoEspecie, genConstraint(1, 1, 1, 1));
       panelEspecie.add(barraRolagem, genConstraint(0, 2, 2, 1));
       panelEspecie.add(btnPesquisar, genConstraint(0, 3, 1, 1));
       panelEspecie.add(btnEditar, genConstraint(1, 3, 1, 1));
       return panelEspecie;
    }
    
     public void clickedBtnPesquisar(){
                 modelo.setNumRows(0);
        List<Especie> especies = new ArrayList<Especie>();
        String nome = "%" + txtdescricaoEspecie.getText() + "%";
        especies = cont.recuperarEspeciesPorDescricao(nome);
        for (int i = 0; i < especies.size(); i++) {
            modelo.addRow(new Object[]{especies.get(i).getIdespecie(), especies.get(i).getDescricao(), especies.get(i).getNomeCientifico()});
            especieTable.put(i, especies.get(i));
	}
        TelaLogin.telaPrincipal.setJPanel(panelEspecie);
    }
    
    public void clickedBtnEditar(){
        Integer row = table.getSelectedRow();
        if(row < 0){
             JOptionPane.showMessageDialog(null, "Selecione um para editar");
             return;
        }
        panelEspecie.removeAll();
        
        Especie especie = especieTable.get(row);
        JPanel panel = setPainelEspecie();
        
        txtdescricaoEspecie.setText(especie.getDescricao());
        txtNomeEspecie.setText(especie.getNomeCientifico());
       
        this.especie = especie; 
        TelaLogin.telaPrincipal.setJPanel(panel);
    }
}