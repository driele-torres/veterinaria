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
                }
            }
        });
        
        panelVeterinario.add(lblTitulo, genConstraint(0, 0, 1, 1));
        panelVeterinario.add(lblNome, genConstraint(0, 1, 1, 1));
        panelVeterinario.add(txtNome, genConstraint(1, 1, 1, 1));
        panelVeterinario.add(lblCPF, genConstraint(0, 2, 1, 1));
        panelVeterinario.add(txtCPF, genConstraint(1, 2, 1, 1));
        panelVeterinario.add(lblEndereco, genConstraint(0, 3, 1, 1));
        panelVeterinario.add(txtEndereco, genConstraint(1, 3, 1, 1) );
        panelVeterinario.add(lblTelefone, genConstraint(0, 4, 1, 1));
        panelVeterinario.add(txtTelefone, genConstraint(1, 4, 1, 1));
        panelVeterinario.add(lblUser, genConstraint(0, 5, 1, 1));
        panelVeterinario.add(txtUser, genConstraint(1, 5, 1, 1));
        panelVeterinario.add(lblSenha, genConstraint(0, 6, 1, 1));
        panelVeterinario.add(txtSenha, genConstraint(1, 6, 1, 1));
        panelVeterinario.add(lblEspecialidade, genConstraint(0, 7, 1, 1));
        panelVeterinario.add(txtEspecialidade, genConstraint(1, 7, 1, 1));
        panelVeterinario.add(lblCRV, genConstraint(0, 8, 1, 1));
        panelVeterinario.add(txtCRV, genConstraint(1, 8, 1, 1));
        panelVeterinario.add(btnLimpar, genConstraint(0, 9, 1, 1));
        panelVeterinario.add(btnSalvar, genConstraint(1, 9, 1, 1));
        
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
        Veterinario vet = new Veterinario();
        Usuario usuario = new Usuario();
        usuario.setCpf(txtCPF.getText());
        usuario.setEndereco(txtEndereco.getText());
        usuario.setNome(txtNome.getText());
        usuario.setTelefone(txtTelefone.getText());
        usuario.setUsername(txtUser.getText());
        usuario.setSenha(txtSenha.getText());
        vet.setCrv(txtCRV.getText());
        vet.setEspecialidade(txtEspecialidade.getText());
        vet.setUsuario(usuario);
        cont.salvarVeterinario(vet);
        return vet;
    }
    
}