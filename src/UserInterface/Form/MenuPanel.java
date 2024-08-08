
// package UserInterface.Form;

// import UserInterface.CustomerControl.PatButton;
// import UserInterface.IAStyle;
// import java.awt.Dimension;
// import java.awt.Image;
// import java.io.IOException;
// import javax.imageio.ImageIO;
// import javax.swing.Box;
// import javax.swing.BoxLayout;
// import javax.swing.ImageIcon;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.border.EmptyBorder;

// public class MenuPanel extends JPanel {
//     public PatButton   
//             btnHome     = new PatButton("Home"),
//             btnCamaras  = new PatButton("Cámaras"),
//             btnConfiguracion = new PatButton("Configuración"),
//             btnGrabaciones = new PatButton("Ver Grabaciones"),
//             btnUsuarios = new PatButton("Usuarios");

//     public MenuPanel() {
//         customizeComponent();
//     }

//     private void customizeComponent() {
//         setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//         setPreferredSize(new Dimension(350, getHeight()));

//         // Add logo
//         try {
//             Image logo = ImageIO.read(IAStyle.URL_LOGO);
//             logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//             add(new JLabel(new ImageIcon(logo)));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         // Customize and add buttons with vertical spacing
//         addButton(btnHome);
//         addButton(btnConfiguracion);
//         addButton(btnCamaras);
//         addButton(btnGrabaciones);
//         addButton(btnUsuarios);

//         // Add copyright
//         JLabel copyright = new JLabel("\u00A9 2024 Jairo");
//         copyright.setFont(IAStyle.FONT_SMALL); // Small font for copyright
//         copyright.setForeground(IAStyle.COLOR_FONT); // Use color from IAStyle
//         add(Box.createRigidArea(new Dimension(0, 10))); // Space before copyright
//         add(copyright);
//     }

//     private void addButton(PatButton button) {
//         button.setFont(IAStyle.FONT); // Apply the same font as in LoginPanel
//         button.setForeground(IAStyle.COLOR_FONT); // Apply the same text color
//         button.setBackground(IAStyle.COLOR_FONT_LIGHT); // Apply background color
//         button.setBorder(new EmptyBorder(5, 20, 5, 20)); // Apply custom padding
//         button.setCursor(IAStyle.CURSOR_HAND); // Change cursor to hand on hover
        
//         add(button);
//         add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons
//     }
// }
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
        setPreferredSize(new Dimension(200, getHeight())); // Adjusted width for the panel

        // Add logo
        try {
            Image logo = ImageIO.read(IAStyle.URL_LOGO);
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Customize and add buttons with vertical spacing
        addButton(btnHome);
        addButton(btnConfiguracion);
        addButton(btnCamaras);
        addButton(btnGrabaciones);
        addButton(btnUsuarios);

        // Add copyright
        JLabel copyright = new JLabel("\u00A9 2024 Jairo");
        copyright.setFont(IAStyle.FONT_SMALL); // Small font for copyright
        copyright.setForeground(IAStyle.COLOR_FONT); // Use color from IAStyle
        add(Box.createRigidArea(new Dimension(0, 10))); // Space before copyright
        add(copyright);
    }

    private void addButton(PatButton button) {
        button.setFont(IAStyle.FONT); // Apply the same font as in LoginPanel
        button.setForeground(IAStyle.COLOR_FONT); // Apply the same text color
        button.setBackground(IAStyle.COLOR_FONT_LIGHT); // Apply background color
        button.setBorder(new EmptyBorder(5, 15, 5, 15)); // Apply custom padding to reduce width
        button.setCursor(IAStyle.CURSOR_HAND); // Change cursor to hand on hover
        
        button.setPreferredSize(new Dimension(200, 40)); // Adjust button width and height

        add(button);
        add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons
    }
}
