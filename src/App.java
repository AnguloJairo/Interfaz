import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //Splash
        SplashScreenForm.show();


        
        Sistema sistema = new Sistema();
        sistema.mostrarMenu();
        Usuario usuario = new Usuario();
        usuario.login();

    }
}
