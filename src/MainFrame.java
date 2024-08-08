
import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private MenuPanel menuPanel;

    public MainFrame() {
        customizeComponent();
        setupPanels();
    }

    private void customizeComponent() {
        setTitle("Sistema de Seguridad con Cámaras IP");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de navegación a la izquierda
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espacio alrededor del panel

        // Crear etiquetas para el panel de navegación usando IAStyle
        String[] buttonLabels = {"Home", "Cámaras", "Configuración", "Usuarios", "Ver Grbaciones"};
        for (String label : buttonLabels) {
            JLabel labelButton = new JLabel(label);
            labelButton.setFont(IAStyle.FONT); // Aplicar fuente personalizada
            labelButton.setForeground(IAStyle.COLOR_FONT); // Aplicar color de texto
            labelButton.setCursor(IAStyle.CURSOR_HAND); // Aplicar cursor personalizado
            labelButton.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinear a la izquierda
            labelButton.setHorizontalAlignment(IAStyle.ALIGNMENT_LEFT); // Alinear el texto a la izquierda
            labelButton.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Espacio alrededor del texto
            labelButton.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    // Navegación a las diferentes secciones
                    cardLayout.show(contentPanel, label);
                }
            });
            leftPanel.add(labelButton);
        }

        add(leftPanel, BorderLayout.WEST);
    }

    private void setupPanels() {
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        // Crear y añadir los paneles al CardLayout
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("¡Bienvenido a Security Vision!"));
        contentPanel.add(homePanel, "Home");

        // Crear y añadir el panel de cámaras
        menuPanel = new MenuPanel();
        contentPanel.add(menuPanel, "Cámaras");

        // Crear otros paneles si es necesario
        JPanel configuracionPanel = new JPanel();
        configuracionPanel.add(new JLabel("Panel de Configuración"));
        contentPanel.add(configuracionPanel, "Configuración");

        JPanel usuariosPanel = new JPanel();
        usuariosPanel.add(new JLabel("Panel de Usuarios"));
        contentPanel.add(usuariosPanel, "Usuarios");

        JPanel registroPanel = new JPanel();
        registroPanel.add(new JLabel("Panel de Registro"));
        contentPanel.add(registroPanel, "Registro");

        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}

