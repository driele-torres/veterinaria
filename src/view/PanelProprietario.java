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
import model.Proprietario;

public class PanelProprietario extends PanelMae{
    private JPanel panelProprietario = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    private VeterinariaController cont = new VeterinariaController();
    
    private JLabel lblTitulo = new JLabel("Cadastro de Proprietários"); 
    JLabel lblNomeProprietario = new JLabel("Nome:");
    JTextField txtNomeProprietario = new JTextField();
    JLabel lblCPFProprietario = new JLabel("CPF:");
    JTextField txtCPFProprietario = new JTextField();
    JLabel lblEnderecoProprietario = new JLabel("Endereço:");
    JTextField txtEnderecoProprietario = new JTextField();
    JLabel lblTelefoneProprietario = new JLabel("Telefone:");
    JTextField txtTelefoneProprietario = new JTextField();
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
    private Map <Integer, Proprietario>  proprietarioTable = new HashMap<Integer, Proprietario>();
    private Proprietario proprietario;
            
    public JPanel setPanelProprietario(){
        panelProprietario.setLayout(layout);
        
        lblCPFProprietario.setFont(fonte);
        lblEnderecoProprietario.setFont(fonte);
        lblNomeProprietario.setFont(fonte);
        lblTelefoneProprietario.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        
        txtCPFProprietario.setPreferredSize(new Dimension(200, 24));
        txtEnderecoProprietario.setPreferredSize(new Dimension(200, 24));
        txtNomeProprietario.setPreferredSize(new Dimension(200, 24));
        txtTelefoneProprietario.setPreferredSize(new Dimension(200, 24));
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparPanelProprietario();
            }
        });
        
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(salvarPanelProprietario() != null){
                    JOptionPane.showMessageDialog(null, "Proprietário salvo com sucesso!");
                    limparPanelProprietario();
                }else{
                    JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
                }
            }
        });
       
        panelProprietario.add(lblTitulo, genConstraint(0, 1, 3, 3));
        panelProprietario.add(lblNomeProprietario, genConstraint(0, 4, 1, 1));
        panelProprietario.add(txtNomeProprietario, genConstraint(1, 4, 1, 1));
        panelProprietario.add(lblCPFProprietario, genConstraint(0, 5, 1, 1));
        panelProprietario.add(txtCPFProprietario, genConstraint(1, 5, 1, 1));
        panelProprietario.add(lblEnderecoProprietario, genConstraint(0, 6, 1, 1));
        panelProprietario.add(txtEnderecoProprietario, genConstraint(1, 6, 1, 1));
        panelProprietario.add(lblTelefoneProprietario, genConstraint(0, 7, 1, 1));
        panelProprietario.add(txtTelefoneProprietario, genConstraint(1, 7, 1, 1));
        panelProprietario.add(btnLimpar, genConstraint(0, 8, 1, 1));
        panelProprietario.add(btnSalvar, genConstraint(1, 8, 1, 1));
        
        return panelProprietario;
    }
    
    public void limparPanelProprietario(){
        txtCPFProprietario.setText("");
        txtEnderecoProprietario.setText("");
        txtNomeProprietario.setText("");
        txtTelefoneProprietario.setText("");
    }
    
    public Proprietario salvarPanelProprietario(){
         if(txtCPFProprietario.getText().isEmpty() || txtEnderecoProprietario.getText().isEmpty() || txtNomeProprietario.getText().isEmpty()
                 || txtTelefoneProprietario.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
            return null;
        }
        if(this.proprietario == null){
            proprietario = new Proprietario();
        }
        proprietario.setCpf(txtCPFProprietario.getText());
        proprietario.setEndereco(txtEnderecoProprietario.getText());
        proprietario.setNome(txtNomeProprietario.getText());
        proprietario.setTelefone(txtTelefoneProprietario.getText());
        boolean salvou = false;
        if(proprietario.getIdproprietario().equals(0))
           salvou = cont.salvarProprietario(proprietario);
        else
            salvou = cont.atualizarProprietario(proprietario);
        if(salvou){
            limparPanelProprietario();
            return proprietario; 
        }else{
            return null;
        }   
    }
    
    public JPanel setPanelPesquisarProprietario(){ 
        panelProprietario = new JPanel();
        panelProprietario.setLayout(layout);
        JLabel lblTitle = new JLabel("Consulta Proprietario");
        JLabel lblNome = new JLabel("Digite o nome do Proprietario: ");
        lblTitle.setFont(fonteTitle);
        lblNome.setFont(fonte);
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnEditar = new JButton("Editar");
       
       table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        
        modelo.addColumn("ID");
        modelo.addColumn("NOME");
	modelo.addColumn("ENDERECO");
	modelo.addColumn("TELEFONE");
	modelo.addColumn("CPF");
        
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
        
        txtNomeProprietario.setPreferredSize(new Dimension(200, 24));
        panelProprietario.add(lblTitle, genConstraint(0, 0, 2, 1));
       panelProprietario.add(lblNome, genConstraint(0, 1, 1, 1));
       panelProprietario.add(txtNomeProprietario, genConstraint(1, 1, 1, 1));
       panelProprietario.add(barraRolagem, genConstraint(0, 2, 2, 1));
       panelProprietario.add(btnPesquisar, genConstraint(0, 3, 1, 1));
       panelProprietario.add(btnEditar, genConstraint(1, 3, 1, 1));
       return panelProprietario;
    }
    
     public void clickedBtnPesquisar(){
                 modelo.setNumRows(0);

         List<Proprietario> proprietarios = new ArrayList<Proprietario>();
        String nome = "%" + txtNomeProprietario.getText() + "%";
        proprietarios = cont.recuperarProprietariosPorDescricao(nome);
        for (int i = 0; i < proprietarios.size(); i++) {
            modelo.addRow(new Object[]{proprietarios.get(i).getIdproprietario(), proprietarios.get(i).getNome(), 
                proprietarios.get(i).getEndereco(), proprietarios.get(i).getTelefone(),proprietarios.get(i).getCpf()});
            proprietarioTable.put(i, proprietarios.get(i));
	}
        TelaLogin.telaPrincipal.setJPanel(panelProprietario);
    }
    
    public void clickedBtnEditar(){
        Integer row = table.getSelectedRow();
        System.out.println(row);
        if(row < 0){
             JOptionPane.showMessageDialog(null, "Selecione um para editar");
             return;
        }
        panelProprietario.removeAll();
        
        Proprietario proprietario = proprietarioTable.get(row);
        JPanel panel = setPanelProprietario();
        
        txtNomeProprietario.setText(proprietario.getNome());
        txtCPFProprietario.setText(proprietario.getCpf());
        txtEnderecoProprietario.setText(proprietario.getEndereco());
        txtTelefoneProprietario.setText(proprietario.getTelefone());
        
        this.proprietario = proprietario; 
        TelaLogin.telaPrincipal.setJPanel(panel);
    }
    
}