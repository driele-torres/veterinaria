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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;
import model.Especie;
import model.Exame;
import model.Pet;
import model.Proprietario;
import model.Raca;
import model.Veterinario;

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
    private JLabel lblIcone;
    private ImageIcon imagePrincipal;
    private JLabel labelClinica;
    private JLabel labelNome;
    private Font fonte;

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
        JMenu inicioMenu = new JMenu("Início");
        JMenu cadastrosMenu = new JMenu("Cadastros");
        JMenu relatoriosMenu = new JMenu("Relatórios");
        
        inicioMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                clickedInicioMenu();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });      

        relatoriosMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                clickedRelatorioMenu();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
        
        menuVeterinaria.add(inicioMenu);
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
        
        inicializaJPanelInicial();
        
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
          List<Especie> allEspecies = new ArrayList<Especie>();
          try{
              allEspecies = controller.recuperarEspecies();
          }catch(Exception e){
              JOptionPane.showMessageDialog(null, "É necessário informar uma Espécie para cadastrar a Raça!");
              clickedEspecieMenu();
              return;
          }
          panelPrincipal.removeAll();
          panelPrincipal.add(panelRaca.setPainelRaca(allEspecies));
          panelPrincipal.repaint();
          panelPrincipal.revalidate();
      }
      
      public void clickedAnimalMenu(){
                panelAnimal = new PanelAnimal();
                List<Raca> allRacas = new ArrayList<Raca>();
                List<Proprietario> allProprietarios = new ArrayList<Proprietario>();
                try{
                    allRacas = controller.recuperarRacas();                
                    allProprietarios = controller.recuperarProprietarios();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "É necessário informar uma Raça e uma Espécie para cadastrar um Animal!"); 
                    clickedEspecieMenu();
                    return;
                }
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
          List<Exame> exames = new ArrayList<Exame>();
          try{
              exames = controller.recuperarExames();
          }catch(Exception e){
             JOptionPane.showMessageDialog(null, "É necessário informar um Exame para cadastrar um Item!"); 
             clickedRacaMenu();
             return; 
          }
          panelPrincipal.add(panelItem.setPanelItem(exames));
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
          List<Pet> pets = new ArrayList<Pet>();
          List<Veterinario> veterinarios = new ArrayList<Veterinario>();
            try {
                veterinarios = controller.recuperarVeterinarios(); 
                pets = controller.recuperarPets();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "É necessário informar o Animal e o Veterinario para cadastrar um Prontuário!"); 
                clickedVeterinarioMenu();
                return;
            }
          panelPrincipal.add(panelProntuario.setPanelProntuario(veterinarios, pets));
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
        
        public void clickedInicioMenu(){
            panelPrincipal.removeAll();
            inicializaJPanelInicial();
            panelPrincipal.add(panelInicial);
            panelPrincipal.repaint();
            panelPrincipal.revalidate();
        }
        
        public void inicializaJPanelInicial(){
            lblIcone = new JLabel();
            imagePrincipal = new ImageIcon(new ImageIcon("resources/animal-paw-print.png").getImage().
                    getScaledInstance(200, 200, Image.SCALE_DEFAULT));
            lblIcone.setIcon(imagePrincipal);
            lblIcone.setAlignmentX(TOP_ALIGNMENT);
            panelInicial = new JPanel(); 
            panelInicial.setLayout(new GridBagLayout());
            fonte = new Font("Serif", Font.PLAIN, 50);
            labelClinica = new JLabel("Clínica Veterinária");
            labelNome = new JLabel("Santa Luzia");

            labelClinica.setFont(fonte);
            labelNome.setFont(fonte);
            labelClinica.setForeground(Color.DARK_GRAY);
            labelNome.setForeground(Color.DARK_GRAY);
            panelInicial.add(lblIcone, genConstraint(0, 1, 4 , 4));
            panelInicial.add(labelClinica, genConstraint(0, 5, 3, 3));
            panelInicial.add(labelNome, genConstraint(0, 8, 3, 3));
            this.add(panelInicial, genConstraint(0, 0, 1, 1));  
        }
}