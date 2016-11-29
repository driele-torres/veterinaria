package main;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import view.TelaPrincipalClass;

public class Veterinaria {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaPrincipalClass telaPrincipal = new TelaPrincipalClass();
                telaPrincipal.setBounds(20, 20, 1800, 1000);
                telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JScrollPane scroll = new JScrollPane();
                telaPrincipal.add(scroll);
                telaPrincipal.setVisible(true);
            }
        });
    }
}
