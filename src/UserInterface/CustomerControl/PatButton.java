// package UserInterface.CustomerControl;
// import javax.swing.JButton;

// import UserInterface.IAStyle;

// public class PatButton extends JButton {
//     public PatButton(String text) {
//         super(text);
//         setFont(IAStyle.FONT);
//         setForeground(IAStyle.COLOR_FONT);
//         setCursor(IAStyle.CURSOR_HAND);
//         setBorder(IAStyle.createBorderRect());
//     }
// }
package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PatButton extends JButton {

    public PatButton(String text) {
        super(text);
        setBorderPainted(false); // No pintar el borde
        setFocusPainted(false);  // No pintar el enfoque
        setContentAreaFilled(false); // No rellenar el área del botón
        setOpaque(false); // Hacer que el botón sea opaco
        setHorizontalAlignment(SwingConstants.LEFT); // Alinear el texto a la izquierda
        setFont(new Font("Arial", Font.PLAIN, 16)); // Ajustar fuente según sea necesario
        setForeground(Color.BLACK); // Ajustar color del texto
        setBorder(new EmptyBorder(10, 10, 10, 10)); // Espacio interno
    }
}

