import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
 
public class Usuario {
    private String usuario;
    private String clave;
    public String metodoPago;
    public void realizarCompra(){

    }
    public void login(){
        // Crear el marco principal
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        // Crear el panel y añadirlo al marco
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        // Hacer visible el marco
        frame.setVisible(true);
    }
    public void logout(){
        // Implementación del método logout
    }
    public void configuracionAjustes(){
        // Implementación del método configuracionAjustes
    }
    public void recibirNotificacion(){
        // Implementación del método recibirNotificacion
    }
    public void placeComponents(JPanel panel) {
        panel.setLayout(null);
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
 
        // Añadir acción al botón
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