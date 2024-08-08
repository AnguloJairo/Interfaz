import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import UserInterface.IAStyle;

public class Usuario {

    private String usuario;
    private String clave;
    public String metodoPago;

    public void realizarCompra() {
        // Implementación del método realizarCompra
    }

    public void login() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400); // Tamaño aumentado
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new CardLayout());
        frame.add(panel);

        JPanel loginPanel = createLoginPanel(frame);
        JPanel registerPanel = createRegisterPanel();

        panel.add(loginPanel, "Login");
        panel.add(registerPanel, "Register");

        CardLayout cl = (CardLayout) (panel.getLayout());
        cl.show(panel, "Login");

        frame.setVisible(true);
    }

    private JPanel createLoginPanel(JFrame frame) {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER; // Alinea los componentes al centro

        // Imagen
        ImageIcon imageIcon = new ImageIcon("src/ImagenLogo/logo.jpeg");
        JLabel imageLabel = new JLabel(imageIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(imageLabel, gbc);

        // Usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(IAStyle.FONT); // Aplicar fuente personalizada
        userLabel.setForeground(IAStyle.COLOR_FONT); // Aplicar color de texto
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE; // Sin relleno
        loginPanel.add(userLabel, gbc);

        JTextField userText = new JTextField(25); // Aumenta el tamaño del campo
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Rellenar horizontalmente
        loginPanel.add(userText, gbc);

        // Contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(IAStyle.FONT);
        passwordLabel.setForeground(IAStyle.COLOR_FONT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passwordLabel, gbc);

        JPasswordField passwordText = new JPasswordField(25); // Aumenta el tamaño del campo
        gbc.gridx = 1;
        loginPanel.add(passwordText, gbc);

        // Botones
        JButton loginButton = new JButton("Entrar");
        loginButton.setFont(IAStyle.FONT_BOLD);
        loginButton.setCursor(IAStyle.CURSOR_HAND);
        loginButton.setBackground(IAStyle.COLOR_FONT_LIGHT); // Color de fondo
        loginButton.setForeground(Color.WHITE); // Color del texto
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        loginPanel.add(loginButton, gbc);

        JButton registerButton = new JButton("Registrarse");
        registerButton.setFont(IAStyle.FONT_BOLD);
        registerButton.setCursor(IAStyle.CURSOR_HAND);
        registerButton.setBackground(IAStyle.COLOR_FONT_LIGHT);
        registerButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        loginPanel.add(registerButton, gbc);

        // Acción del botón de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = new String(passwordText.getPassword());
                if (user.equals("admin") && password.equals("12345")) {
                    frame.setVisible(false); // Oculta la ventana de login
                    showMainFrame(); // Muestra la ventana principal
                } else {
                    IAStyle.showMsgError("Usuario o contraseña incorrectos");
                }
            }
        });

        // Acción del botón de registro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el CardLayout del panel principal
                JPanel parentPanel = (JPanel) loginPanel.getParent();
                CardLayout cl = (CardLayout) (parentPanel.getLayout());
                cl.show(parentPanel, "Register");
            }
        });

        return loginPanel;
    }

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(IAStyle.FONT);
        userLabel.setForeground(IAStyle.COLOR_FONT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        registerPanel.add(userLabel, gbc);

        JTextField userText = new JTextField(25); // Aumenta el tamaño del campo
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Rellenar horizontalmente
        registerPanel.add(userText, gbc);

        // Contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(IAStyle.FONT);
        passwordLabel.setForeground(IAStyle.COLOR_FONT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        registerPanel.add(passwordLabel, gbc);

        JPasswordField passwordText = new JPasswordField(25); // Aumenta el tamaño del campo
        gbc.gridx = 1;
        registerPanel.add(passwordText, gbc);

        // Confirmar Contraseña
        JLabel confirmPasswordLabel = new JLabel("Confirmar Contraseña:");
        confirmPasswordLabel.setFont(IAStyle.FONT);
        confirmPasswordLabel.setForeground(IAStyle.COLOR_FONT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(confirmPasswordLabel, gbc);

        JPasswordField confirmPasswordText = new JPasswordField(25); // Aumenta el tamaño del campo
        gbc.gridx = 1;
        registerPanel.add(confirmPasswordText, gbc);

        // Botones
        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(IAStyle.FONT_BOLD);
        registerButton.setCursor(IAStyle.CURSOR_HAND);
        registerButton.setBackground(IAStyle.COLOR_FONT_LIGHT);
        registerButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        registerPanel.add(registerButton, gbc);

        JButton backButton = new JButton("Volver");
        backButton.setFont(IAStyle.FONT_BOLD);
        backButton.setCursor(IAStyle.CURSOR_HAND);
        backButton.setBackground(IAStyle.COLOR_FONT_LIGHT);
        backButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        registerPanel.add(backButton, gbc);

        // Acción del botón de registro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = new String(passwordText.getPassword());
                String confirmPassword = new String(confirmPasswordText.getPassword());
                if (password.equals(confirmPassword)) {
                    IAStyle.showMsg("Registro exitoso");
                } else {
                    IAStyle.showMsgError("Las contraseñas no coinciden");
                }
            }
        });

        // Acción del botón de volver
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el CardLayout del panel principal
                JPanel parentPanel = (JPanel) registerPanel.getParent();
                CardLayout cl = (CardLayout) (parentPanel.getLayout());
                cl.show(parentPanel, "Login");
            }
        });

        return registerPanel;
    }

    private void showMainFrame() {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
