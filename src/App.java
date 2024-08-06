import java.util.Scanner;
import javax.swing.SwingUtilities;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //Splash
        SplashScreenForm.show();
        SwingUtilities.invokeLater(MainFrame::new);

        
        //Sistema sistema = new Sistema();
        //sistema.mostrarMenu();
        Usuario usuario = new Usuario();
        usuario.login();

    }
}
