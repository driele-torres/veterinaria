package view;

import controller.VeterinariaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
        Usuario usuario = new Usuario();
        GrupoAcesso ga = cont.recuperarGrupoID(2);
        usuario.setCpf(txtCPF.getText());
        usuario.setEndereco(txtEndereco.getText());
        usuario.setNome(txtNome.getText());
        usuario.setTelefone(txtTelefone.getText());
        usuario.setUsername(txtUser.getText());
        usuario.setSenha(txtSenha.getText());
        usuario.setGrupoAcesso(ga);        
        if(cont.salvarUsuario(usuario)){
            return usuario;
        }
        return null;
    }
    
    public JPanel setPanelPesquisarFuncionario(){
        return panelFuncionario;
    }
 
}