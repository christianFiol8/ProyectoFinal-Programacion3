package Main;

import Controllers.AuthController;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AuthController prueba = new AuthController();
                prueba.login();
            }
        });
    }
}
