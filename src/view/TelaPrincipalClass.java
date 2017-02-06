package view;

import controller.VeterinariaController;
import java.awt.Color;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import model.Especie;
import model.Proprietario;
import model.Raca;

public class TelaPrincipalClass extends JFrame{
    private VeterinariaController controller = new VeterinariaController();
    
    private PanelEspecie panelEspecie;
    private PanelRaca panelRaca;
    private PanelAnimal panelAnimal;
    private PanelProprietario panelProprietario;
    private PanelItem panelItem;
    private PanelExame panelExame;
    private PanelFuncionario panelFuncionario;
    private PanelProntuario panelProntuario;
    private PanelVeterinario panelVeterinario;
    private PanelRelatorio panelRelatorio;
    private JPanel panelInicial;
    private JPanel panelPrincipal;

    public TelaPrincipalClass(){
        String nome = "Consultório Veterinário";
        this.setTitle(nome);
        this.setLayout(new GridBagLayout());
        panelPrincipal = new JPanel();
        
          // Cria uma barra de menu para o JFrame
        JMenuBar menuVeterinaria = new JMenuBar();
        
        // Adiciona a barra de menu ao  frame
        setJMenuBar(menuVeterinaria);
        
        // Define e adiciona dois menus drop down na barra de menus
        JMenu cadastrosMenu = new JMenu("Cadastros");
        JMenu relatoriosMenu = new JMenu("Relatórios");
        
           relatoriosMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedRelatorioMenu();
            }
        });
        menuVeterinaria.add(cadastrosMenu);
        menuVeterinaria.add(relatoriosMenu);
        
        
        // Cria e adiciona um item simples para o menu
        JMenuItem especieAction = new JMenuItem("Espécie");
        especieAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               clickedEspecieMenu();
            }
        });
        JMenuItem racaAction = new JMenuItem("Raça");
        racaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedRacaMenu();
            }
        });
        JMenuItem animalAction = new JMenuItem("Animal");
        animalAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedAnimalMenu();
            }
        });        
        JMenuItem donoAction = new JMenuItem("Proprietário");
        donoAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedDonoMenu();
                
            }
        });
        JMenuItem itemAction = new JMenuItem("Item");
        itemAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedItemMenu();
            }
        });
        JMenuItem exameAction = new JMenuItem("Exame");
        exameAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedExameMenu();
            }
        });
        JMenuItem funcionarioAction = new JMenuItem("Funcionário");
        funcionarioAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedFuncionarioMenu();
            }
        });
        JMenuItem prontuarioAction = new JMenuItem("Prontuário");
        prontuarioAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedProntuarioMenu();
            }
        });
        JMenuItem veterinarioAction = new JMenuItem("Veterinário");
        veterinarioAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedVeterinarioMenu();
            }
        });
        
        cadastrosMenu.add(especieAction);
        cadastrosMenu.add(racaAction);
        cadastrosMenu.add(animalAction);
        cadastrosMenu.add(donoAction);
        cadastrosMenu.add(itemAction);
        cadastrosMenu.add(exameAction);
        cadastrosMenu.add(funcionarioAction);
        cadastrosMenu.add(prontuarioAction);
        cadastrosMenu.add(veterinarioAction);
        
        JLabel lblIcone = new JLabel();
        ImageIcon imagePrincipal = new ImageIcon(new ImageIcon("resources/animal-paw-print.png").getImage().
                getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        lblIcone.setIcon(imagePrincipal);
        lblIcone.setAlignmentX(TOP_ALIGNMENT);
        panelInicial = new JPanel(); 
        panelInicial.setLayout(new GridBagLayout());
        Font fonte = new Font("Serif", Font.PLAIN, 50);
        JLabel labelClinica = new JLabel("Clínica Veterinária");
        JLabel labelNome = new JLabel("Santa Luzia");
        
        labelClinica.setFont(fonte);
        labelNome.setFont(fonte);
        labelClinica.setForeground(Color.DARK_GRAY);
        labelNome.setForeground(Color.DARK_GRAY);
        panelInicial.add(lblIcone, genConstraint(0, 1, 4 , 4));
        panelInicial.add(labelClinica, genConstraint(0, 5, 3, 3));
        panelInicial.add(labelNome, genConstraint(0, 8, 3, 3));
        this.add(panelInicial, genConstraint(0, 0, 1, 1));       
        
        panelPrincipal.add(panelInicial);
        this.add(panelPrincipal);
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
      
      public void clickedEspecieMenu(){
           panelEspecie = new PanelEspecie();
                panelPrincipal.removeAll();
                panelPrincipal.add(panelEspecie.setPainelEspecie());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
          
      }
      
      public void clickedRelatorioMenu(){
          panelRelatorio = new PanelRelatorio();
          panelPrincipal.removeAll();
          panelPrincipal.add(panelRelatorio.setJTable(controller.recuperarProntuarios()));
          panelPrincipal.repaint();
          panelPrincipal.revalidate();
      }
      
      public void clickedRacaMenu(){
          panelRaca = new PanelRaca();
                List<Especie> allEspecies = controller.recuperarEspecies();
                panelPrincipal.removeAll();
                panelPrincipal.add(panelRaca.setPainelRaca(allEspecies));
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
      }
      
      public void clickedAnimalMenu(){
                panelAnimal = new PanelAnimal();
                List<Raca> allRacas = controller.recuperarRacas();
                List<Proprietario> allProprietarios = controller.recuperarProprietarios();
                panelPrincipal.removeAll();
                panelPrincipal.add(panelAnimal.setPainelAnimal(allRacas, allProprietarios));
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
      }
      
      public void clickedDonoMenu(){
          panelProprietario = new PanelProprietario();
                panelPrincipal.removeAll();
                panelPrincipal.add(panelProprietario.setPanelProprietario());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
      }
      
      public void clickedItemMenu(){
          panelItem = new PanelItem();
                panelPrincipal.removeAll();
                panelPrincipal.add(panelItem.setPanelItem(controller.recuperarExames()));
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
      }
      
      public void clickedExameMenu(){
                      panelExame = new PanelExame();
                panelPrincipal.removeAll();
                panelPrincipal.add(panelExame.setPanelExame());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
      }
      
      public void clickedFuncionarioMenu(){
          panelFuncionario = new PanelFuncionario();
                panelPrincipal.removeAll();
                panelPrincipal.add(panelFuncionario.setPanelFuncionario());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
      }
              
        public void clickedProntuarioMenu(){
            panelProntuario = new PanelProntuario();
          panelPrincipal.removeAll();
          panelPrincipal.add(panelProntuario.setPanelProntuario(controller.recuperarVeterinarios(), controller.recuperarPets()));
          panelPrincipal.repaint();
          panelPrincipal.revalidate();
        }
        
        public void clickedVeterinarioMenu(){
                          panelVeterinario = new PanelVeterinario();
                panelPrincipal.removeAll();
                panelPrincipal.add(panelVeterinario.setPanelVeterinario());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
                     }
                              
}