package view;

import controller.VeterinariaController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
    private JTextField txtNomeAnimal = new JTextField();
    private JLabel lblDataNascimento = new JLabel("Data de Nascimento do Animal:");
    private Format format = new SimpleDateFormat("dd/MM/yyyy");
    private JFormattedTextField txtDataNascimento = new JFormattedTextField(format);
    private JLabel lblRacaAnimal = new JLabel("Raça do Animal:");
    private JComboBox cmbRacaAnimal = new JComboBox();
    private JLabel lblProprietarioAnimal = new JLabel("Proprietário do Animal:");
    private JComboBox cmbProprietarioAnimal = new JComboBox();
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
    private Map <Integer, Pet>  animalTable = new HashMap<Integer, Pet>();
    private Pet pet;
  
    public JPanel setPainelAnimal(){
        List<Raca> allRacas = cont.recuperarRacas();
        List<Proprietario> allProprietarios = cont.recuperarProprietarios();
        if(allProprietarios.size() < 0 && allRacas.size() < 0){
            return null;
        }
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
               if(salvarPanelAnimal() != null){
                   JOptionPane.showMessageDialog(null, "Animal salvo com sucesso!");
                   limparPanelAnimal();
               }else
                   JOptionPane.showMessageDialog(null, "Cadastro não realizado!");
               
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
    
    public Pet salvarPanelAnimal(){
        if(txtDataNascimento.getText().isEmpty() || txtNomeAnimal.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
            return null;
        }
        if(this.pet == null){
            pet = new Pet();
        }
        
        ComboItem cb = (ComboItem) cmbRacaAnimal.getSelectedItem();
        pet.setRaca(cont.recuperarRacaPorID(cb.getValue()));
        
        cb = (ComboItem) cmbProprietarioAnimal.getSelectedItem();
        pet.setProprietario(cont.recuperarProprietarioID(cb.getValue()));
        
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            pet.setDataNascimento(format.parse(txtDataNascimento.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite uma data valida");
            return null;
        }
        pet.setDescricao(txtNomeAnimal.getText());
        boolean salvou = false;
        if(pet.getIdpet().equals(0)){
            salvou = cont.salvarPet(pet);
        }else{
            salvou= cont.atualizarPet(pet);
        }
        if(salvou){
            limparPanelAnimal();
            return pet;
        }        
        return null;
    }
    
    public JPanel setPanelPesquisarAnimal(){
        panelAnimal = new JPanel();
        panelAnimal.setLayout(layout);
        JLabel lblTitle = new JLabel("Consulta Animal");
        JLabel lblNome = new JLabel("Digite o nome do Animal: ");
        lblTitle.setFont(fonteTitle);
        lblNome.setFont(fonte);
        JButton btnPesquisar = new JButton("Pesquisar");
        JButton btnEditar = new JButton("Editar");
       
       table.setPreferredScrollableViewportSize(new Dimension(400, 300));
        
        modelo.addColumn("ID");
        modelo.addColumn("PET");
	modelo.addColumn("PROPRIETÁRIO");
	modelo.addColumn("RAÇA");
	modelo.addColumn("NASCIMENTO");
        
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
        
        txtNomeAnimal.setPreferredSize(new Dimension(200, 24));
        panelAnimal.add(lblTitle, genConstraint(0, 0, 2, 1));
       panelAnimal.add(lblNome, genConstraint(0, 1, 1, 1));
       panelAnimal.add(txtNomeAnimal, genConstraint(1, 1, 1, 1));
       panelAnimal.add(barraRolagem, genConstraint(0, 2, 2, 1));
       panelAnimal.add(btnPesquisar, genConstraint(0, 3, 1, 1));
       panelAnimal.add(btnEditar, genConstraint(1, 3, 1, 1));
       return panelAnimal;
    }    
    
    
    public void clickedBtnPesquisar(){
        modelo.setNumRows(0);
        List<Pet> pets = new ArrayList<Pet>();
        String nome = "%" + txtNomeAnimal.getText() + "%";
        pets = cont.recuperarPetsPorDescricao(nome);
        for (int i = 0; i < pets.size(); i++) {
            modelo.addRow(new Object[]{pets.get(i).getIdpet(), pets.get(i).getDescricao(), pets.get(i).getProprietario().getNome(), 
                pets.get(i).getRaca().getDescricao(), format.format(pets.get(i).getDataNascimento())});
            animalTable.put(i, pets.get(i));
	}
        TelaLogin.telaPrincipal.setJPanel(panelAnimal);
    }
    
    public void clickedBtnEditar(){
        Integer row = table.getSelectedRow();
        if(row < 0){
             JOptionPane.showMessageDialog(null, "Selecione um para editar");
             return;
        }
        panelAnimal.removeAll();
        Pet pet = animalTable.get(row);
        JPanel panel = setPainelAnimal();
        
        txtNomeAnimal.setText(pet.getDescricao());
        txtDataNascimento.setText(format.format(pet.getDataNascimento()));
        ComboBoxModel modelRaca = cmbRacaAnimal.getModel();
        for(int i = 0; i < modelRaca.getSize(); i++){
            ComboItem item = (ComboItem) modelRaca.getElementAt(i);
            if(pet.getRaca().getIdraca().equals(item.getValue())){
                cmbRacaAnimal.setSelectedIndex(i);
                break;
            }
        }
        
        ComboBoxModel modelProp = cmbProprietarioAnimal.getModel();
        for(int j = 0; j < modelProp.getSize(); j++){
            ComboItem item = (ComboItem) modelProp.getElementAt(j);
            if(pet.getProprietario().getIdproprietario().equals(item.getValue())){
                cmbProprietarioAnimal.setSelectedIndex(j);
                break;
            }
        }
        this.pet = pet; 
        TelaLogin.telaPrincipal.setJPanel(panel);
    }
}