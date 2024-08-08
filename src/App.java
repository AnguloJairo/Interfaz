import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatLightLaf;

public class App {
    public static void main(String[] args) throws Exception {
        // Personalización
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SplashScreenForm.show();

        // Iniciar la ventana de login
        Usuario usuario = new Usuario();
        SwingUtilities.invokeLater(() -> usuario.login());
    }
}
