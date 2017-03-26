package view;

import controller.VeterinariaController;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.event.MenuListener;
import model.Especie;
import model.GeradorPDF;


public class TelaPrincipalClass extends JFrame{
    
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
        JMenu pesquisaMenu = new JMenu("Pesquisa");
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
        
        menuVeterinaria.add(inicioMenu);
        menuVeterinaria.add(cadastrosMenu);
        menuVeterinaria.add(pesquisaMenu);
        menuVeterinaria.add(relatoriosMenu);
        
        // Cria e adiciona um item simples para o menu
        JMenuItem especiePesquisaAction = new JMenuItem("Espécie");
        especiePesquisaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedEspeciePesquisaMenu();
            }
        });
        JMenuItem racaPesquisaAction = new JMenuItem("Raça");
        racaPesquisaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedRacaPesquisaMenu();
            }
        });
        JMenuItem animalPesquisaAction = new JMenuItem("Animal");
        animalPesquisaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clickedAnimalPesquisaMenu();
            }
        });
        JMenuItem donoPesquisaAction = new JMenuItem("Proprietário");
        donoPesquisaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedDonoPesquisaMenu();
                
            }
        });
        JMenuItem itemPesquisaAction = new JMenuItem("Item");
        itemPesquisaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedItemPesquisaMenu();
            }
        });
        JMenuItem examePesquisaAction = new JMenuItem("Exame");
        examePesquisaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedExamePesquisaMenu();
            }
        });
        JMenuItem funcionarioPesquisaAction = new JMenuItem("Funcionário");
        funcionarioPesquisaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedFuncionarioPesquisaMenu();
            }
        });
        JMenuItem prontuarioPesquisaAction = new JMenuItem("Prontuário");
        prontuarioPesquisaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedProntuarioPesquisaMenu();
            }
        });
        JMenuItem veterinarioPesquisaAction = new JMenuItem("Veterinário");
        veterinarioPesquisaAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickedVeterinarioPesquisaMenu();
            }
        });
        
        pesquisaMenu.add(especiePesquisaAction);
        pesquisaMenu.add(racaPesquisaAction);
        pesquisaMenu.add(animalPesquisaAction);
        pesquisaMenu.add(donoPesquisaAction);
        pesquisaMenu.add(itemPesquisaAction);
        pesquisaMenu.add(examePesquisaAction);
        pesquisaMenu.add(funcionarioPesquisaAction);
        pesquisaMenu.add(prontuarioPesquisaAction);
        pesquisaMenu.add(veterinarioPesquisaAction);
        
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
        
        JMenuItem visualizarRelatorio = new JMenuItem("Visualizar Relatorio");
        visualizarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clickedRelatorioMenu();
            }
        });
        
        JMenuItem exportarPDF = new JMenuItem("Imprimir relatorio em PDF");
        exportarPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clickedCriarPDF();
            }
        });
        relatoriosMenu.add(visualizarRelatorio);
        relatoriosMenu.add(exportarPDF);
        
        inicializaJPanelInicial();
        
        panelPrincipal.add(panelInicial, CENTER_ALIGNMENT);
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
        panelPrincipal.add(panelRelatorio.setJTable());
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public void clickedRacaMenu(){
        panelRaca = new PanelRaca();
        List<Especie> allEspecies = new ArrayList<Especie>();
        JPanel panel = panelRaca.setPainelRaca();
        if(panel != null){
            panelPrincipal.removeAll();
            panelPrincipal.add(panel);
            panelPrincipal.repaint();
            panelPrincipal.revalidate();
        }else{
            JOptionPane.showMessageDialog(null, "É necessário informar uma Espécie para cadastrar a Raça!");
            clickedEspecieMenu();
            return;
        }
    }
    
    public void clickedAnimalMenu(){
        panelAnimal = new PanelAnimal();
        JPanel panel = panelAnimal.setPainelAnimal();
        if(panel != null){
            panelPrincipal.removeAll();
            panelPrincipal.add(panel);
            panelPrincipal.repaint();
            panelPrincipal.revalidate();
        }else{
            JOptionPane.showMessageDialog(null, "É necessário informar uma Raça e uma Espécie para cadastrar um Animal!");
            clickedEspecieMenu();
            return;
        }
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
        JPanel panel = panelItem.setPanelItem();
        if(panel != null){
            panelPrincipal.add(panel);
            panelPrincipal.repaint();
            panelPrincipal.revalidate();
            
        }else{
            JOptionPane.showMessageDialog(null, "É necessário informar um Exame para cadastrar um Item!");
            clickedRacaMenu();
            return;
            
        }
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
        JPanel panel = panelProntuario.setPanelProntuario();
        if(panel != null){
            panelPrincipal.add(panel);
            panelPrincipal.repaint();
            panelPrincipal.revalidate();
        }else{
            JOptionPane.showMessageDialog(null, "É necessário informar o Animal e o Veterinario para cadastrar um Prontuário!");
            clickedVeterinarioMenu();
            return;
        }
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
    
    public void clickedCriarPDF(){
        VeterinariaController cont = new VeterinariaController();
        GeradorPDF gerador = new GeradorPDF();
        gerador.gerarPDF(cont.recuperarProntuarios());
        JOptionPane.showMessageDialog(null, "Relatorio Gerado com Sucesso! Salvo em: " + System.getProperty("user.home")+ "/RelatorioProntuario"+ new Date().toString());
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
    
    public void setJPanel(JPanel panel){
        panelPrincipal.removeAll();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panel, BorderLayout.CENTER);
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public void clickedAnimalPesquisaMenu(){
        panelAnimal = new PanelAnimal();
        panelPrincipal.removeAll();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panelAnimal.setPanelPesquisarAnimal(), BorderLayout.CENTER);
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public void clickedEspeciePesquisaMenu(){
        panelEspecie = new PanelEspecie();
        panelPrincipal.removeAll();
        panelPrincipal.add(panelEspecie.setPanelPesquisarEspecie());
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public void clickedRacaPesquisaMenu(){
        panelRaca = new PanelRaca();
        panelPrincipal.removeAll();
        panelPrincipal.add(panelRaca.setPanelPesquisarRaca());
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public void clickedDonoPesquisaMenu(){
        panelProprietario = new PanelProprietario();
        panelPrincipal.removeAll();
        panelPrincipal.add(panelProprietario.setPanelPesquisarProprietario());
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public void clickedItemPesquisaMenu(){
        panelItem = new PanelItem();
        panelPrincipal.removeAll();
        panelPrincipal.add(panelItem.setPanelPesquisarItem());
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public void clickedExamePesquisaMenu(){
        panelExame = new PanelExame();
        panelPrincipal.removeAll();
        panelPrincipal.add(panelExame.setPanelPesquisarExame());
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public void clickedFuncionarioPesquisaMenu(){
        panelFuncionario = new PanelFuncionario();
        panelPrincipal.removeAll();
        panelPrincipal.add(panelFuncionario.setPanelPesquisarFuncionario());
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public void clickedProntuarioPesquisaMenu(){
        panelProntuario = new PanelProntuario();
        panelPrincipal.removeAll();
        panelPrincipal.add(panelProntuario.setPanelPesquisarProntuario());
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
    public void clickedVeterinarioPesquisaMenu(){
        panelVeterinario = new PanelVeterinario();
        panelPrincipal.removeAll();
        panelPrincipal.add(panelVeterinario.setPanelPesquisarVeterinario());
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }
    
}