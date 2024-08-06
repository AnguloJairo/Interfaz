// import java.awt.*;
// import javax.swing.*;

// public class MainFrame extends JFrame {

//     public MainFrame() {
//         // Configuración de la ventana principal
//         setTitle("Sistema de Seguridad con Cámaras IP");
//         setSize(1200, 800);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);
//         setLayout(new BorderLayout());

//         // Panel de navegación a la izquierda
//         JPanel leftPanel = new JPanel();
//         leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
//         leftPanel.setBackground(Color.LIGHT_GRAY);
//         leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espacio alrededor del panel

//         // Crear etiquetas para el panel de navegación
//         String[] buttonLabels = {"Menu", "Cámaras", "Configuración", "Usuarios", "Registro"};
//         for (String label : buttonLabels) {
//             JLabel labelButton = new JLabel(label);
//             labelButton.setFont(new Font("Arial", Font.PLAIN, 16));
//             labelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//             labelButton.setAlignmentX(Component.LEFT_ALIGNMENT); // Alinear a la izquierda
//             labelButton.setHorizontalAlignment(SwingConstants.LEFT); // Alinear el texto a la izquierda
//             labelButton.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Espacio alrededor del texto
//             labelButton.addMouseListener(new java.awt.event.MouseAdapter() {
//                 @Override
//                 public void mouseClicked(java.awt.event.MouseEvent e) {
//                     // Navegación a las diferentes secciones
//                     CardLayout cl = (CardLayout)(getContentPane().getLayout());
//                     cl.show(getContentPane(), label);
//                 }
//             });
//             leftPanel.add(labelButton);
//         }

//         // Añadir panel de navegación al marco
//         add(leftPanel, BorderLayout.WEST);

//         // Panel central con tarjetas
//         JPanel centerPanel = new JPanel();
//         centerPanel.setLayout(new CardLayout());

//         // Panel de inicio
//         JPanel homePanel = new JPanel();
//         homePanel.add(new JLabel("¡Bienvenido a Security Vision!"));
//         centerPanel.add(homePanel, "Home");

//         // Panel de cámaras
//         JPanel cameraPanel = new JPanel();
//         cameraPanel.add(new JLabel("Visualización de Cámaras IP"));
//         centerPanel.add(cameraPanel, "Cámaras");

//         // Añadir panel central al marco
//         add(centerPanel, BorderLayout.CENTER);

//         // Hacer visible el marco
//         setVisible(true);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(MainFrame::new);
//     }
// }
import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        // Configuración de la ventana principal
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
        String[] buttonLabels = {"Menu", "Cámaras", "Configuración", "Usuarios", "Registro"};
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
                    CardLayout cl = (CardLayout)(getContentPane().getLayout());
                    cl.show(getContentPane(), label);
                }
            });
            leftPanel.add(labelButton);
        }

        // Añadir panel de navegación al marco
        add(leftPanel, BorderLayout.WEST);

        // Panel central con tarjetas
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new CardLayout());

        // Panel de inicio
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("¡Bienvenido a Security Vision!"));
        centerPanel.add(homePanel, "Home");

        // Panel de cámaras
        JPanel cameraPanel = new JPanel();
        cameraPanel.add(new JLabel("Visualización de Cámaras IP"));
        centerPanel.add(cameraPanel, "Cámaras");

        // Añadir panel central al marco
        add(centerPanel, BorderLayout.CENTER);

        // Hacer visible el marco
        setVisible(true);
    }

}
