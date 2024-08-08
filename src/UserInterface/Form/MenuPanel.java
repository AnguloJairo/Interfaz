package UserInterface.Form;

import UserInterface.CustomerControl.PatButton;
import UserInterface.IAStyle;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPanel extends JPanel {
    public PatButton   
            btnHome     = new PatButton("Home"),
            btnCamaras  = new PatButton("Cámaras"),
            btnConfiguracion = new PatButton("Configuración"),
            btnGrabaciones = new PatButton("Ver Grabaciones"),
            btnUsuarios = new PatButton("Usuarios");

    public MenuPanel() {
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, getHeight())); 

        // Add logo
        try {
            Image logo = ImageIO.read(IAStyle.URL_LOGO);
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addButton(btnHome);
        addButton(btnConfiguracion);
        addButton(btnCamaras);
        addButton(btnGrabaciones);
        addButton(btnUsuarios);

        // Add copyright
        JLabel copyright = new JLabel("\u00A9 2024 Jairo");
        copyright.setFont(IAStyle.FONT_SMALL); 
        copyright.setForeground(IAStyle.COLOR_FONT); 
        add(Box.createRigidArea(new Dimension(0, 10))); 
        add(copyright);
    }

    private void addButton(PatButton button) {
        button.setFont(IAStyle.FONT); 
        button.setForeground(IAStyle.COLOR_FONT); 
        button.setBackground(IAStyle.COLOR_FONT_LIGHT); 
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
        button.setCursor(IAStyle.CURSOR_HAND); 
        
        button.setPreferredSize(new Dimension(200, 40)); 

        add(button);
        add(Box.createRigidArea(new Dimension(0, 10))); 
    }
}
