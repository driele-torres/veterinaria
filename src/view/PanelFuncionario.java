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
import model.GrupoAcesso;
import model.Usuario;

/**
 *
 * @author lala
 */
public class PanelFuncionario extends PanelMae{
    
    private JPanel panelFuncionario = new JPanel();
    VeterinariaController cont = new VeterinariaController();
    
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    
    JLabel lblTitulo = new JLabel("Cadastro de Funcionario");
    JLabel lblNome = new JLabel("Nome:");
    JTextField txtNome = new JTextField();
    JLabel lblCPF = new JLabel("CPF:");
    JTextField txtCPF = new JTextField();
    JLabel lblEndereco = new JLabel("Endereço:");
    JTextField txtEndereco = new JTextField();
    JLabel lblTelefone = new JLabel("Telefone:");
    JTextField txtTelefone = new JTextField();
    JLabel lblUser = new JLabel("Username:");
    JTextField txtUser = new JTextField();
    JLabel lblSenha = new JLabel("Senha:");
    JTextField txtSenha = new JTextField();
    
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
    private Map <Integer, Usuario>  usuarioTable = new HashMap<Integer, Usuario>();
    private Usuario usuario;
    
    public JPanel setPanelFuncionario(){
        
        panelFuncionario.setLayout(layout);
        
        lblCPF.setFont(fonte);
        lblEndereco.setFont(fonte);
        lblNome.setFont(fonte);
        lblSenha.setFont(fonte);
        lblTelefone.setFont(fonte);
        lblUser.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        
        txtCPF.setPreferredSize(new Dimension(200, 24));
        txtEndereco.setPreferredSize(new Dimension(200, 24));
        txtNome.setPreferredSize(new Dimension(200, 24));
        txtSenha.setPreferredSize(new Dimension(200, 24));
        txtTelefone.setPreferredSize(new Dimension(200, 24));
        txtUser.setPreferredSize(new Dimension(200, 24));
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparPanelFuncionario();
            }
        });
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(salvarPanelFuncionario() != null){
                    JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
                    limparPanelFuncionario();
                }else{
                    JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
                }
            }
        });
        panelFuncionario.add(lblTitulo, genConstraint(0, 1, 3, 3));
        panelFuncionario.add(lblNome, genConstraint(0, 4, 1, 1));
        panelFuncionario.add(txtNome, genConstraint(1, 4, 1, 1));
        panelFuncionario.add(lblCPF, genConstraint(0, 5, 1, 1));
        panelFuncionario.add(txtCPF, genConstraint(1, 5, 1, 1));
        panelFuncionario.add(lblEndereco, genConstraint(0, 6, 1, 1));
        panelFuncionario.add(txtEndereco, genConstraint(1, 6, 1, 1) );
        panelFuncionario.add(lblTelefone, genConstraint(0, 7, 1, 1));
        panelFuncionario.add(txtTelefone, genConstraint(1, 7, 1, 1));
        panelFuncionario.add(lblUser, genConstraint(0, 8, 1, 1));
        panelFuncionario.add(txtUser, genConstraint(1, 8, 1, 1));
        panelFuncionario.add(lblSenha, genConstraint(0, 9, 1, 1));
        panelFuncionario.add(txtSenha, genConstraint(1, 9, 1, 1));
        panelFuncionario.add(btnLimpar, genConstraint(0, 10, 1, 1));
        panelFuncionario.add(btnSalvar, genConstraint(1, 10, 1, 1));
        
        return panelFuncionario;
    }
    
    public void limparPanelFuncionario(){
        txtCPF.setText("");
        txtEndereco.setText("");
        txtNome.setText("");
        txtSenha.setText("");
        txtTelefone.setText("");
        txtUser.setText("");
    }
    
    public Usuario salvarPanelFuncionario(){
        if(txtCPF.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtNome.getText().isEmpty() || 
                txtTelefone.getText().isEmpty() || txtUser.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
            return null;
        }
        if(this.usuario == null){
            usuario = new Usuario();
        }
        GrupoAcesso ga = cont.recuperarGrupoID(2);
        usuario.setCpf(txtCPF.getText());
        usuario.setEndereco(txtEndereco.getText());
        usuario.setNome(txtNome.getText());
        usuario.setTelefone(txtTelefone.getText());
        usuario.setUsername(txtUser.getText());
        usuario.setSenha(txtSenha.getText());
        usuario.setGrupoAcesso(ga);

        boolean salvou = false;
        if(usuario.getIdusuario() == null){
            salvou = cont.salvarUsuario(usuario);
        }else{
            salvou= cont.atualizarUsuario(usuario);
        }
        if(salvou){
            return usuario;
        }
        return null;
    }
    
    public JPanel setPanelPesquisarFuncionario(){
        panelFuncionario = new JPanel();
        panelFuncionario.setLayout(layout);
        JLabel lblTitle = new JLabel("Consulta Funcionario");
        JLabel lblNome = new JLabel("Digite o nome do Funcionario: ");
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
        modelo.addColumn("USERNAME");

        
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
        
        txtNome.setPreferredSize(new Dimension(200, 24));
        panelFuncionario.add(lblTitle, genConstraint(0, 0, 2, 1));
       panelFuncionario.add(lblNome, genConstraint(0, 1, 1, 1));
       panelFuncionario.add(txtNome, genConstraint(1, 1, 1, 1));
       panelFuncionario.add(barraRolagem, genConstraint(0, 2, 2, 1));
       panelFuncionario.add(btnPesquisar, genConstraint(0, 3, 1, 1));
       panelFuncionario.add(btnEditar, genConstraint(1, 3, 1, 1));
       return panelFuncionario;
    }    
    
    
    public void clickedBtnPesquisar(){
                modelo.setNumRows(0);

        List<Usuario> funcionarios = new ArrayList<Usuario>();
        String nome = "%" + txtNome.getText() + "%";
        funcionarios = cont.procurarUsuariosPorDescricao(nome);
                System.out.println(funcionarios.size());

        for (int i = 0; i < funcionarios.size(); i++) {
            modelo.addRow(new Object[]{funcionarios.get(i).getIdusuario(), funcionarios.get(i).getNome(), funcionarios.get(i).getEndereco(),
                funcionarios.get(i).getTelefone(), funcionarios.get(i).getCpf(), funcionarios.get(i).getUsername()});
            usuarioTable.put(i, funcionarios.get(i));
	}
        TelaLogin.telaPrincipal.setJPanel(panelFuncionario);
    }
    
    public void clickedBtnEditar(){
        Integer row = table.getSelectedRow();
        if(row< 0){
             JOptionPane.showMessageDialog(null, "Selecione um para editar");
             return;
        }
        panelFuncionario.removeAll();
        
        Usuario funcionario = usuarioTable.get(row);
        JPanel panel = setPanelFuncionario();
        
        txtNome.setText(funcionario.getNome());
        txtCPF.setText(funcionario.getCpf());
        txtEndereco.setText(funcionario.getEndereco());
        txtTelefone.setText(funcionario.getTelefone());
        txtUser.setText(funcionario.getUsername());
        
        this.usuario = funcionario; 
        TelaLogin.telaPrincipal.setJPanel(panel);
    }
}