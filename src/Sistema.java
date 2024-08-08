// import javax.swing.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// //import java.util.List;
 
// public class Sistema {
//     public short mostrarMenu() {
//         // Crear el marco principal
//         JFrame frame = new JFrame("Sistema de Monitoreo");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(500, 400);
 
//         // Crear la barra de menú
//         JMenuBar menuBar = new JMenuBar();
 
//         // Crear el menú
//         JMenu menu = new JMenu("Opciones");
//         menuBar.add(menu);
 
//         // Crear elementos de menú
//         JMenuItem capturaMovimientoItem = new JMenuItem("Captura de Movimiento");
//         JMenuItem camaraEnVivoItem = new JMenuItem("Cámara en Vivo");
//         JMenuItem mensajesAlertaItem = new JMenuItem("Mensajes de Alerta");
//         JMenuItem configuracionItem = new JMenuItem("Configuración");
 
//         // Añadir elementos al menú
//         menu.add(capturaMovimientoItem);
//         menu.add(camaraEnVivoItem);
//         menu.add(mensajesAlertaItem);
//         menu.add(configuracionItem);
 
//         // Añadir barra de menú al marco
//         frame.setJMenuBar(menuBar);
 
//         // Añadir acciones a los elementos del menú
//         capturaMovimientoItem.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 activarCapturaMovimiento();
//             }
//         });
 
//         camaraEnVivoItem.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 mostrarCamaraEnVivo();
//             }
//         });
 
//         mensajesAlertaItem.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 mostrarMensajesAlerta();
//             }
//         });
 
//         configuracionItem.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 mostrarConfiguracion();
//             }
//         });
 
//         // Hacer visible el marco
//         frame.setVisible(true);
       
//         return 0;
//     }
   
//     private void activarCapturaMovimiento() {
//         JOptionPane.showMessageDialog(null, "Captura de Movimiento activada");
//         // Implementar lógica para activar la captura de movimiento
//     }
 
//     private void mostrarCamaraEnVivo() {
//         JOptionPane.showMessageDialog(null, "Mostrando Cámara en Vivo");
//         // Implementar lógica para mostrar la cámara en vivo
//     }
 
//     private void mostrarMensajesAlerta() {
//         JOptionPane.showMessageDialog(null, "Mostrando Mensajes de Alerta");
//         // Implementar lógica para mostrar los mensajes de alerta
//     }
 
//     private void mostrarConfiguracion() {
//         JOptionPane.showMessageDialog(null, "Mostrando Configuración");
//         // Implementar lógica para mostrar la configuración
//     }
 
//     public void agregarCamara(Camara camara) {

//     }
 
//     public void agregarUsuario(Persona user) {

//     }
 
//     public void iniciarMonitoreo() {
//         // Implementar lógica para iniciar el monitoreo
//     }
   
//     public void detenerMonitoreo() {
//         // Implementar lógica para detener el monitoreo
//     }
// }