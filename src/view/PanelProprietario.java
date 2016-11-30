package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Proprietario;

public class PanelProprietario extends PanelMae{
    private JPanel panelProprietario = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    
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
                salvarPanelProprietario();
            }
        });
       
        panelProprietario.add(lblTitulo, genConstraint(0, 0, 1, 1));
        panelProprietario.add(lblNomeProprietario, genConstraint(0, 1, 1, 1));
        panelProprietario.add(txtNomeProprietario, genConstraint(1, 1, 1, 1));
        panelProprietario.add(lblCPFProprietario, genConstraint(0, 2, 1, 1));
        panelProprietario.add(txtCPFProprietario, genConstraint(1, 2, 1, 1));
        panelProprietario.add(lblEnderecoProprietario, genConstraint(0, 3, 1, 1));
        panelProprietario.add(txtEnderecoProprietario, genConstraint(1, 3, 1, 1));
        panelProprietario.add(lblTelefoneProprietario, genConstraint(0, 4, 1, 1));
        panelProprietario.add(txtTelefoneProprietario, genConstraint(1, 4, 1, 1));
        panelProprietario.add(btnLimpar, genConstraint(0, 5, 1, 1));
        panelProprietario.add(btnSalvar, genConstraint(1, 5, 1, 1));
        
        return panelProprietario;
    }
    
    public void limparPanelProprietario(){
        txtCPFProprietario.setText("");
        txtEnderecoProprietario.setText("");
        txtNomeProprietario.setText("");
        txtTelefoneProprietario.setText("");
    }
    
    public Proprietario salvarPanelProprietario(){
        Proprietario prop = new Proprietario();
        prop.setCpf(txtCPFProprietario.getText());
        prop.setEndereco(txtEnderecoProprietario.getText());
        prop.setNome(txtNomeProprietario.getText());
        prop.setTelefone(txtTelefoneProprietario.getText());
        return prop;
    }
    
}