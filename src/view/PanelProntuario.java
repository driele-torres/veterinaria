package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.Veterinaria;
import model.Pet;
import model.Prontuario;
import model.Veterinario;

public class PanelProntuario extends PanelMae{
    private JPanel panelProntuario = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    
    JLabel lblTitulo = new JLabel("Cadastro de Prontuário");
    JLabel lblData = new JLabel("Data de realização:");
    JTextField txtData = new JTextField();
    JLabel lblObservacao = new JLabel("Observação:");
    JTextField txtObservacao = new JTextField();
    JLabel lblRealizado = new JLabel("Foi realizado:");
    JComboBox cmbRealizado = new JComboBox();
    JLabel lblVeterinario = new JLabel("Veterinário Responsável:");
    JComboBox cmbVeterinario = new JComboBox();
    JLabel lblAnimal = new JLabel("Animal Consultado:");
    JComboBox cmbAnimal = new JComboBox();
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnSalvar = new JButton("Salvar"); 
    private GridBagLayout layout = new GridBagLayout();
    
    public JPanel setPanelProntuario(List<Veterinario> allVeterinarios, List<Pet> allPets){
        
        panelProntuario.setLayout(layout);
        
        lblAnimal.setFont(fonte);
        lblData.setFont(fonte);
        lblObservacao.setFont(fonte);
        lblRealizado.setFont(fonte);
        lblVeterinario.setFont(fonte);
        lblTitulo.setFont(fonteTitle);
        
        txtData.setPreferredSize(new Dimension(200, 24));
        txtObservacao.setPreferredSize(new Dimension(200, 24));
        cmbAnimal.setPreferredSize(new Dimension(200, 24));
        cmbRealizado.setPreferredSize(new Dimension(200, 24));
        cmbVeterinario.setPreferredSize(new Dimension(200, 24));
        cmbAnimal.addItem("Selecione");
        for(Veterinario item: allVeterinarios){
//           cmbVeterinario.addItem(item.getIdVeterinarioUsuario().getNome());
        }
        cmbRealizado.addItem("Selecione");
        for(Pet item: allPets){
           cmbAnimal.addItem(item.getDescricao());
        }
        cmbVeterinario.addItem("Selecione");
        for(Veterinario item: allVeterinarios){
//           cmbVeterinario.addItem(item.getIdVeterinarioUsuario().getNome());
        }
        cmbRealizado.addItem("Sim");
        cmbRealizado.addItem("Não");
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparPanelProntuario();
            }
        });
        
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarPanelProntuario();
            }
        });
        panelProntuario.add(lblTitulo, genConstraint(0, 0, 1, 1));
        panelProntuario.add(lblData, genConstraint(0, 1, 1, 1));
        panelProntuario.add(txtData, genConstraint(1, 1, 1, 1));
        panelProntuario.add(lblAnimal, genConstraint(0, 2, 1, 1));
        panelProntuario.add(cmbAnimal, genConstraint(1, 2, 1, 1));
        panelProntuario.add(lblObservacao, genConstraint(0, 3, 1, 1));
        panelProntuario.add(txtObservacao, genConstraint(1, 3, 1, 1));
        panelProntuario.add(lblVeterinario, genConstraint(0, 4, 1, 1));
        panelProntuario.add(cmbVeterinario, genConstraint(1, 4, 1, 1));
        panelProntuario.add(lblRealizado, genConstraint(0, 5, 1, 1));
        panelProntuario.add(cmbRealizado, genConstraint(1, 5, 1, 1));
        panelProntuario.add(btnLimpar, genConstraint(0, 6, 1, 1));
        panelProntuario.add(btnSalvar, genConstraint(1, 6, 1, 1));
        
        return panelProntuario;
    }
    
    public void limparPanelProntuario(){
        txtData.setText("");
        txtObservacao.setText("");
        cmbAnimal.setSelectedItem("Selecione");
        cmbRealizado.setSelectedItem("Selecione");
        cmbVeterinario.setSelectedItem("Selecione");
    }
    
    public Prontuario salvarPanelProntuario(){
        Prontuario pront = new Prontuario();
//        pront.setData(txtData.getText());
        pront.setObservacao(txtObservacao.getText());
//        pront.setRealizado();
        return pront;
    }
}