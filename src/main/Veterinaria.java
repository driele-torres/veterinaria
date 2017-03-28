package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.TelaLogin;

public class Veterinaria {
    public static TelaLogin login;

    public static TelaLogin getLogin() {
        return login;
    }

    public static void setLogin(TelaLogin login) {
        Veterinaria.login = login;
    }
    
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                login = new TelaLogin();
                login.setBounds(550, 250, 300, 300);
                login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JScrollPane scroll = new JScrollPane();
                login.add(scroll);
                login.setVisible(true);
            }
        });
    }
}
