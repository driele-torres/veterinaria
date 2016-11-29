package view;

import controller.VeterinariaController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.Veterinaria;
import model.Especie;
import model.Raca;

public class TelaPrincipalClass extends JFrame{
    private VeterinariaController controller = new VeterinariaController();
    
    private PanelEspecie panelEspecie = new PanelEspecie();
    private PanelRaca panelRaca = new PanelRaca();
    private PanelAnimal panelAnimal = new PanelAnimal();
    private PanelProprietario panelProprietario = new PanelProprietario();
    private PanelItem panelItem = new PanelItem();
    private PanelExame panelExame = new PanelExame();
    private PanelFuncionario panelFuncionario = new PanelFuncionario();
    private PanelProntuario panelProntuario = new PanelProntuario();
    private PanelVeterinario panelVeterinario = new PanelVeterinario();
    
    private JPanel panelInicial = new JPanel();
    private JPanel panelPrincipal = new JPanel();
   
    public GridBagConstraints genConstraint(int x, int y, int w, int h){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.insets = new Insets(10, 10, 10, 10);
        return c;
     }

    public TelaPrincipalClass(){
        String nome = "Consultório Veterinário";
        this.setTitle(nome);
        this.setLayout(new GridLayout(3, 3));
        
          // Cria uma barra de menu para o JFrame
        JMenuBar menuVeterinaria = new JMenuBar();
        
        // Adiciona a barra de menu ao  frame
        setJMenuBar(menuVeterinaria);
        
        // Define e adiciona dois menus drop down na barra de menus
        JMenu cadastrosMenu = new JMenu("Cadastros");
        JMenu relatoriosMenu = new JMenu("Relatórios");
        menuVeterinaria.add(cadastrosMenu);
        menuVeterinaria.add(relatoriosMenu);
        
        // Cria e adiciona um item simples para o menu
        JMenuItem especieAction = new JMenuItem("Espécie");
        especieAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(panelEspecie.setPainelEspecie());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
            }
        });
        JMenuItem racaAction = new JMenuItem("Raça");
        racaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Especie> allEspecies = controller.recuperarEspecies();
                panelPrincipal.removeAll();
                panelPrincipal.add(panelRaca.setPainelRaca(allEspecies));
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
            }
        });
        JMenuItem animalAction = new JMenuItem("Animal");
        animalAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Raca> allRacas = controller.recuperarRacas();
                panelPrincipal.removeAll();
                panelPrincipal.add(panelAnimal.setPainelAnimal(allRacas));
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
            }
        });        
        JMenuItem donoAction = new JMenuItem("Proprietário");
        donoAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(panelProprietario.setPanelProprietario());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
            }
        });
        JMenuItem itemAction = new JMenuItem("Item");
        itemAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(panelItem.setPanelItem());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
            }
        });
        JMenuItem exameAction = new JMenuItem("Exame");
        exameAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(panelExame.setPanelExame());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
            }
        });
        JMenuItem funcionarioAction = new JMenuItem("Funcionário");
        funcionarioAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(panelFuncionario.setPanelFuncionario());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
            }
        });
        JMenuItem prontuarioAction = new JMenuItem("Prontuário");
        prontuarioAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(panelProntuario.setPanelProntuario());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
            }
        });
        JMenuItem veterinarioAction = new JMenuItem("Veterinário");
        veterinarioAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.removeAll();
                panelPrincipal.add(panelVeterinario.setPanelVeterinario());
                panelPrincipal.repaint();
                panelPrincipal.revalidate();
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
        
        JLabel labelClinica = new JLabel("Clínica Veterinária");
        Font fonte = new Font("Serif", Font.PLAIN, 100);
        labelClinica.setFont(fonte);
        labelClinica.setForeground(Color.DARK_GRAY);
        panelInicial.add(labelClinica);
        this.add(panelInicial, genConstraint(0, 0, 1, 1));       
        
        panelPrincipal.add(panelInicial);
        this.add(panelPrincipal);
        
    }
    
}
