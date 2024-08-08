package UserInterface.Form;

import UserInterface.CustomerControl.PatButton;
import UserInterface.IAStyle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CamaraPanel extends JPanel {
    public PatButton btnIniciarGrabacion = new PatButton("Iniciar Grabacion");
    public PatButton btnDetenerGrabacion = new PatButton("Detener Grabacion");

    public CamaraPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 700));
        setBorder(IAStyle.createBorderRect());
        setBackground(Color.WHITE); // Fondo blanco para un look más relajado

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(Color.LIGHT_GRAY); // Color de fondo más suave para los botones

        customizeButton(btnIniciarGrabacion);
        customizeButton(btnDetenerGrabacion);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnIniciarGrabacion);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnDetenerGrabacion);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void customizeButton(JButton button) {
        button.setForeground(new Color(100, 149, 237)); // Color más relajado (Cornflower Blue)
        button.setFont(IAStyle.FONT_BOLD);
        button.setCursor(IAStyle.CURSOR_HAND);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
    }
}
