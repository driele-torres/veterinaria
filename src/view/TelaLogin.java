package view;

import controller.VeterinariaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.GrupoAcesso;
import model.Usuario;

public class TelaLogin extends JFrame{
    private VeterinariaController cont  = new VeterinariaController();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    JButton btnLogin = new JButton("Login");
    JButton btnCancelar = new JButton("Cancelar");
    JLabel lblUsuario = new JLabel("Usuário");
    JLabel lblSenha = new JLabel("Senha");
    JTextField txtUsuario = new JTextField();
    JPasswordField password = new JPasswordField(10);
    JPanel panel;
    private boolean click = false;
    public static final TelaPrincipalClass telaPrincipal = new TelaPrincipalClass();
    public static Usuario usuarioLogado = new Usuario();
    
    public TelaLogin(){
        inicializar();
    }
    
    public void inicializar(){
        this.setTitle("Tela de Login");
        this.setLayout(new GridBagLayout());
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        lblSenha.setFont(fonte);
        lblUsuario.setFont(fonte);
        
        txtUsuario.setPreferredSize(new Dimension(115, 20));
        password.setPreferredSize(new Dimension(115, 20));
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUsuario.setText("");
                password.setText("");
            }
        });
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 clickedLogin();
            }
        });
        
        panel.add(lblUsuario, genConstraint(0, 1, 1, 1));
        panel.add(txtUsuario, genConstraint(1, 1, 1, 1));
        panel.add(lblSenha, genConstraint(0, 2, 1, 1));
        panel.add(password, genConstraint(1, 2, 1, 1));
        panel.add(btnCancelar, genConstraint(0, 3, 1, 1));
        panel.add(btnLogin, genConstraint(1, 3, 1, 1));
        
        this.add(panel);
    }
    
    public GridBagConstraints genConstraint(int x, int y, int w, int h){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.insets = new Insets(10, 10, 10, 10);
        return c;
    }
    
    public void clickedLogin(){
        if(loga()){
            List<GrupoAcesso> grupos = cont.recuperarGrupos();
            TelaPrincipalClass telaPrincipal = TelaLogin.telaPrincipal;
            telaPrincipal.setBounds(450, 150, 600, 600);
            telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JScrollPane scroll = new JScrollPane();
            telaPrincipal.add(scroll);
            telaPrincipal.setVisible(true);
//            this.setVisible(false);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }else{
            JOptionPane.showMessageDialog(null, "Nao foi possivel fazer o Login");
        }
    }  
    
    public boolean loga(){
        String user = txtUsuario.getText();
        String senha = password.getText();
        List<GrupoAcesso> grupos = cont.recuperarGrupos();
        if (grupos.isEmpty()){
            GrupoAcesso grupo1 = new GrupoAcesso();
            grupo1.setDescricao("Total");
            cont.salvarGrupo(grupo1);
            GrupoAcesso grupo2 = new GrupoAcesso();
            grupo2.setDescricao("Parcial");
            cont.salvarGrupo(grupo2);
        }
        
        if(user.equals("admin") && senha.equals("admin")){
            GrupoAcesso grupo = cont.recuperarGrupoID(1);
            usuarioLogado.setUsername("admin");
            usuarioLogado.setGrupoAcesso(grupo);
            usuarioLogado.setSenha("admin");
            usuarioLogado.setCpf("");
            usuarioLogado.setEndereco("");
            usuarioLogado.setNome("");
            usuarioLogado.setTelefone("");
            return true;
        }else{
            Usuario usuario = cont.procuraUsuarioPorUsername(user);
            if(usuario != null){
                if(usuario.getSenha().equals(senha)){
                    usuarioLogado = usuario;
                    return true;
                }
                JOptionPane.showMessageDialog(null, "Senha incorreta!");
                return false;
            }
            JOptionPane.showMessageDialog(null, "Usuario nao encontrado!");
            return false;
        }
    }
}
