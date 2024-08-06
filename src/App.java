import java.util.Scanner;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightIJTheme;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        //Splash
        SplashScreenForm.show();
        SwingUtilities.invokeLater(MainFrame::new);

        
        //Sistema sistema = new Sistema();
        //sistema.mostrarMenu();
        Usuario usuario = new Usuario();
        usuario.login();

    }
}

