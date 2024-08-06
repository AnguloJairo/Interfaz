import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Usuario {
    private String usuario;
    private String clave;
    public String metodoPago;

    public void realizarCompra() {
        // Implementación del método realizarCompra
    }

    public void login() {
        // Crear el marco principal
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Crear el panel y añadirlo al marco
        JPanel panel = new JPanel();
        panel.setLayout(new CardLayout());
        frame.add(panel);

        // Crear paneles para login y registro
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(null);

        // Añadir componentes al panel de login
        placeLoginComponents(loginPanel);

        // Añadir componentes al panel de registro
        placeRegisterComponents(registerPanel);

        // Añadir paneles al panel principal
        panel.add(loginPanel, "Login");
        panel.add(registerPanel, "Register");

        // Mostrar el panel de login por defecto
        CardLayout cl = (CardLayout) (panel.getLayout());
        cl.show(panel, "Login");

        // Hacer visible el marco
        frame.setVisible(true);
    }

    private void placeLoginComponents(JPanel panel) {
        // Cargar la imagen
        ImageIcon imageIcon = new ImageIcon("src/ImagenLogo/logo.jpeg"); // Ajusta esta ruta a tu imagen
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(150, 10, 100, 100); // Ajusta las coordenadas y el tamaño según sea necesario
        panel.add(imageLabel);

        // Crear etiqueta de usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 120, 80, 25);
        panel.add(userLabel);

        // Crear campo de texto para el usuario
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 120, 165, 25);
        panel.add(userText);

        // Crear etiqueta de contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 150, 80, 25);
        panel.add(passwordLabel);

        // Crear campo de texto para la contraseña
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 150, 165, 25);
        panel.add(passwordText);

        // Crear botón de inicio de sesión
        JButton loginButton = new JButton("Entrar");
        loginButton.setBounds(10, 180, 80, 25);
        panel.add(loginButton);

        // Crear botón de registro
        JButton registerButton = new JButton("Registrarse");
        registerButton.setBounds(100, 180, 130, 25);
        panel.add(registerButton);

        // Añadir acción al botón de inicio de sesión
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = new String(passwordText.getPassword());
                // Validar usuario y contraseña
                if (user.equals("admin") && password.equals("12345")) {
                    JOptionPane.showMessageDialog(panel, "Login exitoso");
                } else {
                    JOptionPane.showMessageDialog(panel, "Usuario o contraseña incorrectos");
                }
            }
        });

        // Añadir acción al botón de registro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (panel.getParent().getLayout());
                cl.show(panel.getParent(), "Register");
            }
        });
    }

    private void placeRegisterComponents(JPanel panel) {
        // Crear etiquetas y campos para registro
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JLabel confirmPasswordLabel = new JLabel("Confirmar Contraseña:");
        confirmPasswordLabel.setBounds(10, 80, 150, 25);
        panel.add(confirmPasswordLabel);

        JPasswordField confirmPasswordText = new JPasswordField(20);
        confirmPasswordText.setBounds(160, 80, 165, 25);
        panel.add(confirmPasswordText);

        JButton registerButton = new JButton("Registrar");
        registerButton.setBounds(10, 120, 120, 25);
        panel.add(registerButton);

        JButton backButton = new JButton("Volver");
        backButton.setBounds(150, 120, 120, 25);
        panel.add(backButton);

        // Acción del botón de registro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = new String(passwordText.getPassword());
                String confirmPassword = new String(confirmPasswordText.getPassword());
                if (password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(panel, "Registro exitoso");
                    // Puedes añadir lógica adicional para guardar el nuevo usuario aquí
                } else {
                    JOptionPane.showMessageDialog(panel, "Las contraseñas no coinciden");
                }
            }
        });

        // Acción del botón de volver
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (panel.getParent().getLayout());
                cl.show(panel.getParent(), "Login");
            }
        });
    }

    public void logout() {
        // Implementación del método logout
    }

    public void configuracionAjustes() {
        // Implementación del método configuracionAjustes
    }

    public void recibirNotificacion() {
        // Implementación del método recibirNotificacion
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
