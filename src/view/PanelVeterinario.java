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
import model.Veterinario;

/**
 *
 * @author lala
 */
public class PanelVeterinario extends PanelMae{
    
    private JPanel panelVeterinario = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    private VeterinariaController cont = new VeterinariaController();
    
    JLabel lblTitulo = new JLabel("Cadastro de Veterinário");
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
    JLabel lblCRV = new JLabel("CRV:");
    JTextField txtCRV = new JTextField();
    JLabel lblEspecialidade = new JLabel("Especialidade:");
    JTextField txtEspecialidade = new JTextField();
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
    private Map <Integer, Veterinario>  veterinarioTable = new HashMap<Integer, Veterinario>();
    private Veterinario veterinario;
    
    public JPanel setPanelVeterinario(){
        
        panelVeterinario.setLayout(layout);
        
        lblCPF.setFont(fonte);
        lblCRV.setFont(fonte);
        lblEndereco.setFont(fonte);
        lblEspecialidade.setFont(fonte);
        lblNome.setFont(fonte);
        lblSenha.setFont(fonte);
        lblTelefone.setFont(fonte);
        lblUser.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        
        txtCPF.setPreferredSize(new Dimension(200, 24));
        txtCRV.setPreferredSize(new Dimension(200, 24));
        txtEndereco.setPreferredSize(new Dimension(200, 24));
        txtEspecialidade.setPreferredSize(new Dimension(200, 24));
        txtNome.setPreferredSize(new Dimension(200, 24));
        txtSenha.setPreferredSize(new Dimension(200, 24));
        txtTelefone.setPreferredSize(new Dimension(200, 24));
        txtUser.setPreferredSize(new Dimension(200, 24));
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparPanelVet();
            }
        });
        
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(salvarPanelVet() != null){
                    JOptionPane.showMessageDialog(null, "Veterinário(a) salvo com sucesso!");
                    limparPanelVet();
                }else{
                    JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
                }
            }
        });
        
        panelVeterinario.add(lblTitulo, genConstraint(0, 1, 3, 3));
        panelVeterinario.add(lblNome, genConstraint(0, 4, 1, 1));
        panelVeterinario.add(txtNome, genConstraint(1, 4, 1, 1));
        panelVeterinario.add(lblCPF, genConstraint(0, 5, 1, 1));
        panelVeterinario.add(txtCPF, genConstraint(1, 5, 1, 1));
        panelVeterinario.add(lblEndereco, genConstraint(0, 6, 1, 1));
        panelVeterinario.add(txtEndereco, genConstraint(1, 6, 1, 1) );
        panelVeterinario.add(lblTelefone, genConstraint(0, 7, 1, 1));
        panelVeterinario.add(txtTelefone, genConstraint(1, 7, 1, 1));
        panelVeterinario.add(lblUser, genConstraint(0, 8, 1, 1));
        panelVeterinario.add(txtUser, genConstraint(1, 8, 1, 1));
        panelVeterinario.add(lblSenha, genConstraint(0, 9, 1, 1));
        panelVeterinario.add(txtSenha, genConstraint(1, 9, 1, 1));
        panelVeterinario.add(lblEspecialidade, genConstraint(0, 10, 1, 1));
        panelVeterinario.add(txtEspecialidade, genConstraint(1, 10, 1, 1));
        panelVeterinario.add(lblCRV, genConstraint(0, 11, 1, 1));
        panelVeterinario.add(txtCRV, genConstraint(1, 11, 1, 1));
        panelVeterinario.add(btnLimpar, genConstraint(0, 12, 1, 1));
        panelVeterinario.add(btnSalvar, genConstraint(1, 12, 1, 1));
        
        return panelVeterinario;
    }
    
    private void limparPanelVet() {
        txtCPF.setText("");
        txtCRV.setText("");
        txtEndereco.setText("");
        txtEspecialidade.setText("");
        txtNome.setText("");
        txtSenha.setText("");
        txtTelefone.setText("");
        txtUser.setText("");
    }
    
    private Veterinario salvarPanelVet(){
        if(txtCPF.getText().isEmpty() || txtEndereco.getText().isEmpty() || txtNome.getText().isEmpty() || 
                txtTelefone.getText().isEmpty() || txtUser.getText().isEmpty() || txtCRV.getText().isEmpty() || txtEspecialidade.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
            return null;
        }
        if(this.veterinario == null){
            veterinario = new Veterinario();
        }
        
        GrupoAcesso ga = cont.recuperarGrupoID(1);
        Usuario usuario = new Usuario();
        usuario.setCpf(txtCPF.getText());
        usuario.setEndereco(txtEndereco.getText());
        usuario.setNome(txtNome.getText());
        usuario.setTelefone(txtTelefone.getText());
        usuario.setUsername(txtUser.getText());
        usuario.setSenha(txtSenha.getText());
        usuario.setGrupoAcesso(ga);
        veterinario.setCrv(txtCRV.getText());
        veterinario.setEspecialidade(txtEspecialidade.getText());
        veterinario.setUsuario(usuario);
        boolean salvou = false;
        if(veterinario.getIdveterinario() == null)
           salvou = cont.salvarVeterinario(veterinario); 
        else
            salvou = cont.atualizaVeterinario(veterinario);
        if(salvou){
        limparPanelVet();
           return veterinario; 
        }
        return null;
    }
    
    public JPanel setPanelPesquisarVeterinario(){
        panelVeterinario = new JPanel();
        panelVeterinario.setLayout(layout);
        JLabel lblTitle = new JLabel("Consulta Veterinario");
        JLabel lblNome = new JLabel("Digite o nome do Veterinario: ");
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
        modelo.addColumn("ESPECIALIDADE");
        modelo.addColumn("CRV");
        
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
        panelVeterinario.add(lblTitle, genConstraint(0, 0, 2, 1));
       panelVeterinario.add(lblNome, genConstraint(0, 1, 1, 1));
       panelVeterinario.add(txtNome, genConstraint(1, 1, 1, 1));
       panelVeterinario.add(barraRolagem, genConstraint(0, 2, 2, 1));
       panelVeterinario.add(btnPesquisar, genConstraint(0, 3, 1, 1));
       panelVeterinario.add(btnEditar, genConstraint(1, 3, 1, 1));
       return panelVeterinario;
    }    
    
    
    public void clickedBtnPesquisar(){
                modelo.setNumRows(0);

        List<Veterinario> veterinarios = new ArrayList<Veterinario>();
        String nome = "%" + txtNome.getText() + "%";
        veterinarios = cont.procurarVeterinariosPorDescricao(nome);
        for (int i = 0; i < veterinarios.size(); i++) {
            modelo.addRow(new Object[]{veterinarios.get(i).getUsuario().getIdusuario(), veterinarios.get(i).getUsuario().getNome(), 
                veterinarios.get(i).getUsuario().getEndereco(),veterinarios.get(i).getUsuario().getTelefone(), 
                veterinarios.get(i).getUsuario().getCpf(), veterinarios.get(i).getUsuario().getUsername(), 
            veterinarios.get(i).getEspecialidade(), veterinarios.get(i).getCrv()});
            veterinarioTable.put(i, veterinarios.get(i));
	}
        TelaLogin.telaPrincipal.setJPanel(panelVeterinario);
    }
    
    public void clickedBtnEditar(){
        Integer row = table.getSelectedRow();
        if(row < 0){
             JOptionPane.showMessageDialog(null, "Selecione um para editar");
             return;
        }
        panelVeterinario.removeAll();
        
        Veterinario veterinario = veterinarioTable.get(row);
        JPanel panel = setPanelVeterinario();
        
        txtNome.setText(veterinario.getUsuario().getNome());
        txtCPF.setText(veterinario.getUsuario().getCpf());
        txtEndereco.setText(veterinario.getUsuario().getEndereco());
        txtTelefone.setText(veterinario.getUsuario().getTelefone());
        txtUser.setText(veterinario.getUsuario().getUsername());
        txtCRV.setText(veterinario.getCrv());
        txtEspecialidade.setText(veterinario.getEspecialidade());
        
        this.veterinario = veterinario; 
        TelaLogin.telaPrincipal.setJPanel(panel);
    }
}