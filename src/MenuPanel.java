
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
    public PatButton btnInicio = new PatButton("Inicio");
    public PatButton btnIniciarGrabacion = new PatButton("Iniciar Grabacion");
    public PatButton btnDetenerGrabacion = new PatButton("Detener Grabacion");
    public PatButton btnVerGrabaciones = new PatButton("Ver Grabaciones");
    public PatButton btnConfiguracion = new PatButton("Configuracion");

    public MenuPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 700));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        setBackground(Color.BLACK);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(Color.BLACK);

        customizeButton(btnInicio, Color.ORANGE);
        customizeButton(btnIniciarGrabacion, Color.ORANGE);
        customizeButton(btnDetenerGrabacion, Color.ORANGE);
        customizeButton(btnVerGrabaciones, Color.ORANGE);
        customizeButton(btnConfiguracion, Color.ORANGE);

        buttonPanel.add(btnInicio);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnIniciarGrabacion);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnDetenerGrabacion);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnVerGrabaciones);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnConfiguracion);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void customizeButton(JButton button, Color foreground) {
        button.setForeground(foreground);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
    }
}

