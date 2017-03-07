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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
        TelaPrincipalClass telaPrincipal = new TelaPrincipalClass();
        telaPrincipal.setBounds(20, 20, 600, 600);
        telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scroll = new JScrollPane();
        telaPrincipal.add(scroll);
        telaPrincipal.setVisible(true);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }  
    
    public void loga(){
        
    }
}
