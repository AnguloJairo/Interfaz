// package UserInterface.Form;

// import UserInterface.CustomerControl.PatButton;
// import UserInterface.IAStyle;
// import java.awt.BorderLayout;
// import java.awt.Color;
// import java.awt.Dimension;
// import javax.swing.BorderFactory;
// import javax.swing.Box;
// import javax.swing.BoxLayout;
// import javax.swing.JPanel;

// public class CamaraPanel extends JPanel {
//     private PatButton btnIniciarGrabacion;
//     private PatButton btnDetenerGrabacion;

//     private JPanel videoPanel;
//     private JPanel buttonPanel;

//     public CamaraPanel() {
//         setLayout(new BorderLayout());
//         setPreferredSize(new Dimension(600, 800)); // Tamaño ajustado según necesidades
//         setBorder(IAStyle.createBorderRect());
//         setBackground(Color.WHITE); // Fondo blanco para un look más relajado

//         // Panel para el video en la parte superior
//         videoPanel = new JPanel();
//         videoPanel.setPreferredSize(new Dimension(600, 500)); // Tamaño del área del video
//         videoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Borde negro para el área del video
//         videoPanel.setBackground(Color.BLACK); // Fondo negro para el área del video

//         // Panel para los botones de control
//         buttonPanel = new JPanel();
//         buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
//         buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//         buttonPanel.setBackground(Color.LIGHT_GRAY); // Color de fondo más suave para los botones

//         // Crear y personalizar botones
//         btnIniciarGrabacion = createStyledButton("Iniciar Grabación");
//         btnDetenerGrabacion = createStyledButton("Detener Grabación");

//         // Añadir botones al panel con espaciado
//         buttonPanel.add(Box.createHorizontalGlue());
//         buttonPanel.add(btnIniciarGrabacion);
//         buttonPanel.add(Box.createRigidArea(new Dimension(20, 0)));
//         buttonPanel.add(btnDetenerGrabacion);
//         buttonPanel.add(Box.createHorizontalGlue());

//         // Añadir los paneles a la interfaz principal
//         add(videoPanel, BorderLayout.CENTER);
//         add(buttonPanel, BorderLayout.SOUTH);
//     }

//     private PatButton createStyledButton(String text) {
//         PatButton button = new PatButton(text);
//         button.setForeground(Color.WHITE); // Color del texto en blanco para contrastar con el fondo azul
//         button.setFont(IAStyle.FONT_BOLD);
//         button.setCursor(IAStyle.CURSOR_HAND);
//         button.setBackground(IAStyle.COLOR_FONT); // Usar color definido en IAStyle
//         button.setOpaque(true);
//         button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Espaciado interno del botón
//         button.setPreferredSize(new Dimension(200, 40)); // Tamaño preferido del botón
//         return button;
//     }
// }


package UserInterface.Form;

import UserInterface.CustomerControl.PatButton;
import UserInterface.IAStyle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class CamaraPanel extends JPanel {
    private PatButton btnIniciarGrabacion;
    private PatButton btnDetenerGrabacion;

    private JPanel videoPanel;
    private JPanel buttonPanel;

    public CamaraPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600, 800)); // Tamaño ajustado según necesidades
        setBorder(IAStyle.createBorderRect());
        setBackground(Color.WHITE); // Fondo blanco para un look más relajado

        // Panel para el video en la parte superior
        videoPanel = new JPanel();
        videoPanel.setPreferredSize(new Dimension(600, 500)); // Tamaño del área del video
        videoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Borde negro para el área del video
        videoPanel.setBackground(Color.BLACK); // Fondo negro para el área del video

        // Panel para los botones de control
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(new Color(240, 240, 240)); // Color de fondo claro para los botones

        // Crear y personalizar botones
        btnIniciarGrabacion = createStyledButton("Iniciar Grabación", new Color(0, 150, 0), Color.BLACK); // Verde brillante
        btnDetenerGrabacion = createStyledButton("Detener Grabación", new Color(255, 69, 58), Color.BLACK); // Rojo brillante

        // Añadir botones al panel con espaciado
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(btnIniciarGrabacion);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        buttonPanel.add(btnDetenerGrabacion);
        buttonPanel.add(Box.createHorizontalGlue());

        // Añadir los paneles a la interfaz principal
        add(videoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private PatButton createStyledButton(String text, Color backgroundColor, Color foregroundColor) {
        PatButton button = new PatButton(text);
        button.setForeground(foregroundColor); // Color del texto
        button.setFont(IAStyle.FONT_BOLD);
        button.setCursor(IAStyle.CURSOR_HAND);
        button.setBackground(backgroundColor); // Color de fondo del botón
        button.setOpaque(true);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(foregroundColor.darker()), // Borde más oscuro
            BorderFactory.createEmptyBorder(10, 20, 10, 20))); // Espaciado interno del botón
        button.setPreferredSize(new Dimension(200, 40)); // Tamaño preferido del botón
        return button;
    }
}
