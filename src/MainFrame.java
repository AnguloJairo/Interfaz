import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setTitle("Sistema de Seguridad con Cámaras IP");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        leftPanel.setBackground(Color.LIGHT_GRAY);

        String[] buttonLabels = {"Menu", "Cámaras", "Configuración", "Usuarios", "Registro"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.addActionListener(new NavigationListener());
            leftPanel.add(button);
            leftPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre botones
        }

        add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new CardLayout());

        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("¡Bienvenido a Security Vision!"));
        centerPanel.add(homePanel, "Home");

        JPanel cameraPanel = new JPanel();
        cameraPanel.add(new JLabel("Visualización de Cámaras IP"));
        centerPanel.add(cameraPanel, "Cámaras");

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private class NavigationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            CardLayout cl = (CardLayout)(getContentPane().getLayout());
            cl.show(getContentPane(), command);
        }
    }

}
