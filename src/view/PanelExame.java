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
import model.Exame;

public class PanelExame extends PanelMae{
    
    private JPanel panelExame = new JPanel();
    private VeterinariaController cont = new VeterinariaController();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    private JLabel lblTitulo = new JLabel("Cadastro de Exames");
    JLabel lblNomeExame = new JLabel("Nome do Exame:");
    JTextField txtNomeExame = new JTextField();
    JLabel lblAreaExame = new JLabel("Area do Exame:");
    JTextField txtAreaExame = new JTextField();
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
    private Map <Integer, Exame>  exameTable = new HashMap<Integer, Exame>();
    private Exame exame;
    
    public JPanel setPanelExame(){
        panelExame.setLayout(layout);
        
        lblAreaExame.setFont(fonte);
        lblNomeExame.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        
        txtAreaExame.setPreferredSize(new Dimension(200, 24));
        txtNomeExame.setPreferredSize(new Dimension(200, 24));
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparPanelExame();
            }
        });
        
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(salvarPanelExame() != null){
                    JOptionPane.showMessageDialog(null, "Exame cadastrado com sucesso!");
                    limparPanelExame();
                }else{
                    JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
                }
            }
        });
       
        panelExame.add(lblTitulo, genConstraint(0, 1, 3, 3));
        
        panelExame.add(lblNomeExame , genConstraint(0, 4, 1, 1));
        panelExame.add(txtNomeExame, genConstraint(1, 4, 1, 1));
        
        panelExame.add(lblAreaExame, genConstraint(0, 5, 1, 1));
        panelExame.add(txtAreaExame, genConstraint(1, 5, 1, 1));
        panelExame.add(btnLimpar, genConstraint(0, 6, 1, 1));
        panelExame.add(btnSalvar, genConstraint(1, 6, 1, 1));
        
        return panelExame;
    }
    
    public void limparPanelExame(){
        txtAreaExame.setText("");
        txtNomeExame.setText("");
    }
    
    public Exame salvarPanelExame(){
        if(txtAreaExame.getText().isEmpty() || txtNomeExame.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
            return null;
        }
        if(this.exame == null){
            exame = new Exame();
        }
        
        exame.setArea(txtAreaExame.getText());
        exame.setNome(txtNomeExame.getText());
        
        boolean salvou = false;
        if(exame.getIdexame() == null){
            salvou = cont.salvarExame(exame);
        }else{
            salvou= cont.atualizarExame(exame);
        }
        if(salvou){
        limparPanelExame();
            return exame;
        }else{
            return null;
        }
        
    } 
    
    public JPanel setPanelPesquisarExame(){
        panelExame = new JPanel();
        panelExame.setLayout(layout);
        JLabel lblTitle = new JLabel("Consulta Exame");
        JLabel lblNome = new JLabel("Digite o nome do Exame: ");
        lblTitle.setFont(fonteTitle);
        lblNome.setFont(fonte);
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnEditar = new JButton("Editar");
       
        table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        
        modelo.addColumn("ID");
        modelo.addColumn("NOME");
	modelo.addColumn("AREA");
        
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
        
        txtNomeExame.setPreferredSize(new Dimension(200, 24));
        panelExame.add(lblTitle, genConstraint(0, 0, 2, 1));
       panelExame.add(lblNome, genConstraint(0, 1, 1, 1));
       panelExame.add(txtNomeExame, genConstraint(1, 1, 1, 1));
       panelExame.add(barraRolagem, genConstraint(0, 2, 2, 1));
       panelExame.add(btnPesquisar, genConstraint(0, 3, 1, 1));
       panelExame.add(btnEditar, genConstraint(1, 3, 1, 1));
       return panelExame;
    }    
    
    
    public void clickedBtnPesquisar(){
                modelo.setNumRows(0);

        List<Exame> exames = new ArrayList<Exame>();
        String nome = "%" + txtNomeExame.getText() + "%";
        exames = cont.recuperarExamesPorDescricao(nome);
        for (int i = 0; i < exames.size(); i++) {
            modelo.addRow(new Object[]{exames.get(i).getIdexame(), exames.get(i).getNome(), exames.get(i).getArea()});
            exameTable.put(i, exames.get(i));
	}
        TelaLogin.telaPrincipal.setJPanel(panelExame);
    }
    
    public void clickedBtnEditar(){
        Integer row = table.getSelectedRow();
        if(row < 0){
             JOptionPane.showMessageDialog(null, "Selecione um para editar");
             return;
        }
        panelExame.removeAll();
        
        Exame exame = exameTable.get(row);
        JPanel panel = setPanelExame();
        
        txtNomeExame.setText(exame.getNome());
        txtAreaExame.setText(exame.getArea());
        
        this.exame = exame; 
        TelaLogin.telaPrincipal.setJPanel(panel);
    }
    
}