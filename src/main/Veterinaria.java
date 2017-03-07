package main;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import view.TelaLogin;

public class Veterinaria {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLogin login = new TelaLogin();
                login.setBounds(20, 20, 300, 300);
                login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JScrollPane scroll = new JScrollPane();
                login.add(scroll);
                login.setVisible(true);
            }
        });
    }
}
