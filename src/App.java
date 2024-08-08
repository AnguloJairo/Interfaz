import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatLightLaf;

import UserInterface.Form.SplashScreenForm;
import UserInterface.Form.LoginPanel;

public class App {
    public static void main(String[] args) throws Exception {
        // Personalización
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        //le oculte para ahorrar tiempo xd
        SplashScreenForm.show();

        // Iniciar la ventana de login
        LoginPanel usuario = new LoginPanel();
        SwingUtilities.invokeLater(() -> usuario.login());
    }
}
