package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Prontuario;

public class PanelRelatorio extends PanelMae{
        private JPanel painelFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel(); 
        
        public JPanel setJTable(List<Prontuario> allProntuarios) {	
            tabela = new JTable(modelo);
                modelo.addColumn("ID");
		modelo.addColumn("NOME PET");
		modelo.addColumn("NOME VETERINARIO");
		modelo.addColumn("DATA");
		modelo.addColumn("OBSERVACAO");
                modelo.addColumn("STATUS");
                
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		modelo.setNumRows(0);
                for (Prontuario c : allProntuarios) {
			modelo.addRow(new Object[]{c.getIdprontuario(), c.getPet().getDescricao(), c.getVeterinario().getUsuario().getNome(), c.getData().toString(),c.getObservacao(), c.getRealizado()?"Realizado":"Nao Realizado"});
		}
                
                
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);

		return painelFundo;
	}
}
