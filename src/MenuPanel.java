import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Box;

public class MenuPanel extends JFrame {
    public PatButton btnInicio = new PatButton("Inicio");
    public PatButton btnIniciarGrabacion = new PatButton("Iniciar Grabacion");
    public PatButton btnDetenerGrabacion = new PatButton("Detener Grabacion");
    public PatButton btnVerGrabaciones = new PatButton("Ver Grabaciones");
    public PatButton btnConfiguracion = new PatButton("Configuracion");

    public MenuPanel() {
        setTitle("Sistema de Seguridad con Cámaras IP");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        leftPanel.setBackground(Color.BLACK);
        
        customizeComponent(leftPanel);
        
        add(leftPanel, BorderLayout.WEST);
    }

    private void customizeComponent(JPanel panel) {
        panel.setPreferredSize(new Dimension(300, getHeight()));

        // Create a panel to hold the logo and center it
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        logoPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        logoPanel.setBackground(Color.WHITE); // Same as leftPanel background
        
        try {
            Image logo = ImageIO.read(IAStyle.URL_LOGO); // Actualiza esta línea con la ruta correcta
            logo = logo.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            logoPanel.add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        panel.add(logoPanel);

        customizeButton(btnInicio, Color.ORANGE);
        customizeButton(btnIniciarGrabacion, Color.ORANGE);
        customizeButton(btnDetenerGrabacion, Color.ORANGE);
        customizeButton(btnVerGrabaciones, Color.ORANGE);
        customizeButton(btnConfiguracion, Color.ORANGE);

        panel.add(btnInicio);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons
        panel.add(btnIniciarGrabacion);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons
        panel.add(btnDetenerGrabacion);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons
        panel.add(btnVerGrabaciones);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons
        panel.add(btnConfiguracion);

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Space before copyright
        JLabel copyright = new JLabel("\u00A9 2024 Secure Vision");
        copyright.setForeground(Color.BLACK);
        panel.add(copyright);
    }

    private void customizeButton(JButton button, Color foreground) {
        button.setForeground(foreground);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
    }

}


