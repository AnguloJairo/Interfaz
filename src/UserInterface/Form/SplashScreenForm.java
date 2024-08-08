package UserInterface.Form;

import UserInterface.IAStyle;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public abstract class SplashScreenForm {
    private static JFrame frmSplash;
    private static JProgressBar prbLoading;
    private static ImageIcon iconImage;
    private static JLabel lblSplash;

    private static final int SPLASH_WIDTH = 600;
    private static final int SPLASH_HEIGHT = 500; 

    public static void show(){
        if (IAStyle.URL_SPLASH == null) {
            System.err.println("Error: La imagen no se pudo cargar. Verifica la ruta del recurso.");
            return;
        }

        // Load the image
        ImageIcon originalIcon = new ImageIcon(IAStyle.URL_SPLASH);
        Image image = originalIcon.getImage();

        // Scale the image
        Image scaledImage = image.getScaledInstance(SPLASH_WIDTH, SPLASH_HEIGHT, Image.SCALE_SMOOTH);
        iconImage = new ImageIcon(scaledImage);

        // Create the label and progress bar
        lblSplash = new JLabel(iconImage);
        prbLoading = new JProgressBar(0, 100);
        prbLoading.setStringPainted(true);

        // Setup the frame
        frmSplash = new JFrame();
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(prbLoading, BorderLayout.SOUTH);
        frmSplash.setSize(SPLASH_WIDTH, SPLASH_HEIGHT);
        frmSplash.setLocationRelativeTo(null);

        frmSplash.setVisible(true);

        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prbLoading.setValue(i);
        }

        frmSplash.setVisible(false);
    }
}

