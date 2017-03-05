package view;

import controller.VeterinariaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Pet;
import model.Proprietario;
import model.Raca;

public class PanelAnimal extends PanelMae{
    private JPanel panelAnimal = new JPanel();
    private Font fonte = new Font("Serif", Font.PLAIN, 14);
    private Font fonteTitle = new Font("Serif", Font.BOLD, 20);
    
    private VeterinariaController cont = new VeterinariaController();
    
    private JLabel lblTitulo = new JLabel("Cadastro de Animais");
    private JLabel lblNomeAnimal = new JLabel("Nome do Animal:");
    private  JTextField txtNomeAnimal = new JTextField();
    private JLabel lblDataNascimento = new JLabel("Data de Nascimento do Animal:");
    private JTextField txtDataNascimento = new JTextField();
    private JLabel lblRacaAnimal = new JLabel("Raça do Animal:");
    private JComboBox cmbRacaAnimal = new JComboBox();
    private JLabel lblProprietarioAnimal = new JLabel("Proprietário do Animal:");
    private JComboBox cmbProprietarioAnimal = new JComboBox();
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnSalvar = new JButton("Salvar"); 
    private GridBagLayout layout = new GridBagLayout();
    
    public JPanel setPainelAnimal(List<Raca> allRacas, List<Proprietario> allProprietarios){
       panelAnimal.setLayout(layout);
       
       lblDataNascimento.setFont(fonte);
       lblNomeAnimal.setFont(fonte);
       lblRacaAnimal.setFont(fonte);
       lblTitulo.setFont(fonteTitle);
       
       txtDataNascimento.setPreferredSize(new Dimension(200, 24));
       txtNomeAnimal.setPreferredSize(new Dimension(200, 24));
       cmbRacaAnimal.setPreferredSize(new Dimension(200, 24));
       cmbProprietarioAnimal.setPreferredSize(new Dimension(200, 24));
       
       for(Raca item: allRacas){
           cmbRacaAnimal.addItem(new ComboItem(item.getIdraca(), item.getDescricao()));
       }
       for(Proprietario item : allProprietarios){
           cmbProprietarioAnimal.addItem(new ComboItem(item.getIdproprietario(), item.getCpf()));
       }
       
       btnLimpar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               limparPanelAnimal();
           }
       });
       btnSalvar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   if(salvarPanelAnimal() != null){
                       JOptionPane.showMessageDialog(null, "Animal salvo com sucesso!");
                       limparPanelAnimal();
                   }else{
                       JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
                   }
               } catch (ParseException ex) {
                   Logger.getLogger(PanelAnimal.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });
       panelAnimal.add(lblTitulo, genConstraint(0, 1, 3, 3));
       panelAnimal.add(lblNomeAnimal, genConstraint(0, 4, 1, 1));
       panelAnimal.add(txtNomeAnimal, genConstraint(1, 4, 1, 1));
       panelAnimal.add(lblDataNascimento, genConstraint(0, 5, 1, 1));
       panelAnimal.add(txtDataNascimento, genConstraint(1, 5, 1, 1));
       panelAnimal.add(lblRacaAnimal, genConstraint(0, 6, 1, 1));
       panelAnimal.add(cmbRacaAnimal, genConstraint(1, 6, 1, 1));
       
       panelAnimal.add(lblProprietarioAnimal, genConstraint(0, 7, 1, 1));
       panelAnimal.add(cmbProprietarioAnimal, genConstraint(1, 7, 1, 1));
       
       panelAnimal.add(btnLimpar, genConstraint(0, 8, 1, 1));
       panelAnimal.add(btnSalvar, genConstraint(1, 8, 1, 1));

       return panelAnimal;
    }
    
    public void limparPanelAnimal(){
        txtDataNascimento.setText("");
        txtNomeAnimal.setText("");     
    }
    
    public Pet salvarPanelAnimal() throws ParseException{
        Pet pet = new Pet();
        
        ComboItem cb = (ComboItem) cmbRacaAnimal.getSelectedItem();
        pet.setRaca(cont.recuperarRacaPorID(cb.getValue()));
        
        cb = (ComboItem) cmbProprietarioAnimal.getSelectedItem();
        pet.setProprietario(cont.recuperarProprietarioID(cb.getValue()));
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        pet.setDataNascimento(format.parse(txtDataNascimento.getText()));
        pet.setDescricao(txtNomeAnimal.getText());
        if(cont.salvarPet(pet)){
        limparPanelAnimal();
            return pet;
        }
        return null;
    }
    
}