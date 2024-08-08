package UserInterface.Form;

import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;
import UserInterface.IAStyle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GrabacionesPanel extends JPanel implements ActionListener {
    private Integer rowNum = 0, idRowMaxGrabacion = 0;
    // Aquí se debe crear o inyectar una instancia de la lógica de negocio para grabaciones
    // private GrabacionesBL grabacionesBL = new GrabacionesBL();
    // private GrabacionesDTO grabacionDAO = null;

    public GrabacionesPanel() {
        try {
            customizeComponent();
            loadRow();
            showRow();
            showTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
            
            btnNuevo.addActionListener(e -> btnNuevoClick());
            btnGuardar.addActionListener(e -> btnGuardarClick());
            btnEliminar.addActionListener(e -> btnEliminarClick());
            btnCancelar.addActionListener(e -> btnCancelarClick());
        } catch (Exception e) {
            IAStyle.showMsg(e.getMessage());
        }
    }

    // Cargar la fila inicial de datos
    private void loadRow() {
        try {
            rowNum = 1;
            // Implementar carga de grabación desde la base de datos
            // grabacionDAO = grabacionesBL.getBy(rowNum);
            idRowMaxGrabacion = 10; // Cambiar según la lógica de negocio
        } catch (Exception e) {
            IAStyle.showMsg(e.getMessage());
        }
    }

    // Mostrar los datos de la grabación actual
    private void showRow() {
        boolean grabacionNull = (/* grabacionDAO == null */ false);
        txtRowNum.setText((grabacionNull) ? " " : "ID"); // Mostrar ID de la grabación
        txtNombre.setText((grabacionNull) ? " " : "Nombre"); // Mostrar nombre de la grabación
        txtPassword.setText((grabacionNull) ? " " : "Detalles"); // Mostrar detalles de la grabación
        lblTotalReg.setText(rowNum.toString() + " de " + idRowMaxGrabacion.toString());
    }

    private void btnNuevoClick() {
        // grabacionDAO = null;
        showRow();
    } 

    private void btnGuardarClick() {
        boolean grabacionNull = (/* grabacionDAO == null */ false);
        try {
            if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((grabacionNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))) {
                if (grabacionNull) {
                    // Crear nueva grabación
                    // grabacionDAO = new GrabacionesDTO(txtNombre.getText().trim(), txtPassword.getText().trim());
                } else {
                    // Actualizar grabación existente
                    // grabacionDAO.setNombre(txtNombre.getText());
                    // grabacionDAO.setDetalles(txtPassword.getText());
                }

                // Guardar la grabación en la base de datos
                // if (!((grabacionNull) ? grabacionesBL.add(grabacionDAO) : grabacionesBL.update(grabacionDAO)))
                //     IAStyle.showMsgError("Error al guardar...!");

                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            IAStyle.showMsgError(e.getMessage());
        }
    }

    private void btnEliminarClick() {
        try {
            if (IAStyle.showConfirmYesNo("¿Seguro que desea Eliminar?")) {
                // Eliminar grabación de la base de datos
                // if (!grabacionesBL.delete(grabacionDAO.getId()))
                //     throw new Exception("Error al eliminar...!");
                
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            IAStyle.showMsgError(e.getMessage());
        }
    }

    private void btnCancelarClick() {
        try {
            if (/* grabacionDAO == null */ false)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            rowNum = 1;
        if (e.getSource() == btnRowAnt && (rowNum > 1))
            rowNum--;
        if (e.getSource() == btnRowSig && (rowNum < idRowMaxGrabacion))
            rowNum++;
        if (e.getSource() == btnRowFin)
            rowNum = idRowMaxGrabacion;
        try {
            // grabacionDAO = grabacionesBL.getBy(rowNum);
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        // Aquí debes obtener los datos de las grabaciones desde la base de datos
        // String[] header = {"ID", "Nombre", "Detalles"};
        // Object[][] data = new Object[grabacionesBL.getAll().size()][3];
        // int index = 0;
        // for (GrabacionesDTO g : grabacionesBL.getAll()) {
        //     data[index][0] = g.getId();
        //     data[index][1] = g.getNombre();
        //     data[index][2] = g.getDetalles();
        //     index++;
        // }

        String[] header = {"", "", ""};
        Object[][] data = new Object[10][3]; // Datos ficticios para la demostración
        int index = 0;
        for (int i = 1; i <= 10; i++) {
            data[index][0] = i;
            data[index][1] = "Grabación " + i;
            data[index][2] = "Detalles " + i;
            index++;
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(800, 400)); // Ajustar tamaño según sea necesario
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(new JScrollPane(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strRowNum = table.getModel().getValueAt(row, 0).toString();
                    rowNum = Integer.parseInt(strRowNum);
                    try {
                        // grabacionDAO = grabacionesBL.getBy(rowNum);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strRowNum);
                }
            }
        });
    }

    /************************
     * FormDesing : pat_mic
     ************************/ 
    private PatLabel 
            lblTitulo = new PatLabel("GRABACIONES"),
            lblRowNum = new PatLabel(" ID:          "),
            lblNombre = new PatLabel("*Nombre:     "),
            lblPassword = new PatLabel("*Detalles:   "),
            lblTotalReg = new PatLabel(" 0 de 0 ");
    private PatTextBox 
            txtRowNum = new PatTextBox(),
            txtNombre = new PatTextBox(),
            txtPassword = new PatTextBox();
    private PatButton 
            btnPageIni = new PatButton(" |< "),
            btnPageAnt = new PatButton(" << "),
            btnPageSig = new PatButton(" >> "),
            btnPageFin = new PatButton(" >| "),

            btnRowIni = new PatButton(" |< "),
            btnRowAnt = new PatButton(" << "),
            btnRowSig = new PatButton(" >> "),
            btnRowFin = new PatButton(" >| "),

            btnNuevo = new PatButton("Nuevo"),
            btnGuardar = new PatButton("Guardar"),
            btnCancelar = new PatButton("Cancelar"),
            btnEliminar = new PatButton("Eliminar");
    private JPanel 
            pnlTabla = new JPanel(),
            pnlBtnRow = new JPanel(new FlowLayout()),
            pnlBtnPage = new JPanel(new FlowLayout()),
            pnlBtnCRUD = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtRowNum.setEnabled(false);
        txtRowNum.setBorderLine();
        txtNombre.setBorderLine();
        txtPassword.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new PatLabel(" Page:( "));
        pnlBtnPage.add(lblTotalReg); // Mostrar total de registros
        pnlBtnPage.add(new PatLabel(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(new PatLabel(" Row:( "));
        pnlBtnRow.add(lblTotalReg); // Mostrar total de registros
        pnlBtnRow.add(new PatLabel(" ) "));
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.add(btnCancelar);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.insets = new Insets(5, 5, 5, 5);
        add(lblTitulo, gbc);

        gbc.gridy = 1; gbc.gridwidth = 1; gbc.fill = GridBagConstraints.NONE;
        add(lblRowNum, gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtRowNum, gbc);
        gbc.gridx = 2; gbc.fill = GridBagConstraints.NONE;
        add(lblNombre, gbc);
        gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNombre, gbc);

        gbc.gridy = 2; gbc.gridx = 0; gbc.fill = GridBagConstraints.NONE;
        add(lblPassword, gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtPassword, gbc);

        gbc.gridy = 3; gbc.gridx = 0; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlTabla, gbc);

        gbc.gridy = 4; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);

        gbc.gridy = 5; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnRow, gbc);
    }
}

// package UserInterface.Form;

// import UserInterface.CustomerControl.PatButton;
// import UserInterface.CustomerControl.PatLabel;
// import UserInterface.CustomerControl.PatTextBox;
// import UserInterface.IAStyle;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
// import javax.swing.*;

// public class GrabacionesPanel extends JPanel implements ActionListener {
//     private Integer rowNum = 0, idRowMaxGrabacion = 0;
//     // Aquí se debe crear o inyectar una instancia de la lógica de negocio para grabaciones
//     // private GrabacionesBL grabacionesBL = new GrabacionesBL();
//     // private GrabacionesDTO grabacionDAO = null;

//     public GrabacionesPanel() {
//         try {
//             customizeComponent();
//             loadRow();
//             showRow();
//             showTable();

//             btnRowIni.addActionListener(this);
//             btnRowAnt.addActionListener(this);
//             btnRowSig.addActionListener(this);
//             btnRowFin.addActionListener(this);
            
//             btnNuevo.addActionListener(e -> btnNuevoClick());
//             btnGuardar.addActionListener(e -> btnGuardarClick());
//             btnEliminar.addActionListener(e -> btnEliminarClick());
//             btnCancelar.addActionListener(e -> btnCancelarClick());
//         } catch (Exception e) {
//             IAStyle.showMsg(e.getMessage());
//         }
//     }

//     // Cargar la fila inicial de datos
//     private void loadRow() {
//         try {
//             rowNum = 1;
//             // Implementar carga de grabación desde la base de datos
//             // grabacionDAO = grabacionesBL.getBy(rowNum);
//             idRowMaxGrabacion = 10; // Cambiar según la lógica de negocio
//         } catch (Exception e) {
//             IAStyle.showMsg(e.getMessage());
//         }
//     }

//     // Mostrar los datos de la grabación actual
//     private void showRow() {
//         boolean grabacionNull = (/* grabacionDAO == null */ false);
//         txtRowNum.setText((grabacionNull) ? " " : "ID"); // Mostrar ID de la grabación
//         txtNombre.setText((grabacionNull) ? " " : "Nombre"); // Mostrar nombre de la grabación
//         txtPassword.setText((grabacionNull) ? " " : "Detalles"); // Mostrar detalles de la grabación
//         lblTotalReg.setText(rowNum.toString() + " de " + idRowMaxGrabacion.toString());
//     }

//     private void btnNuevoClick() {
//         // grabacionDAO = null;
//         showRow();
//     } 

//     private void btnGuardarClick() {
//         boolean grabacionNull = (/* grabacionDAO == null */ false);
//         try {
//             if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((grabacionNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))) {
//                 if (grabacionNull) {
//                     // Crear nueva grabación
//                     // grabacionDAO = new GrabacionesDTO(txtNombre.getText().trim(), txtPassword.getText().trim());
//                 } else {
//                     // Actualizar grabación existente
//                     // grabacionDAO.setNombre(txtNombre.getText());
//                     // grabacionDAO.setDetalles(txtPassword.getText());
//                 }

//                 // Guardar la grabación en la base de datos
//                 // if (!((grabacionNull) ? grabacionesBL.add(grabacionDAO) : grabacionesBL.update(grabacionDAO)))
//                 //     IAStyle.showMsgError("Error al guardar...!");

//                 loadRow();
//                 showRow();
//                 showTable();
//             }
//         } catch (Exception e) {
//             IAStyle.showMsgError(e.getMessage());
//         }
//     }

//     private void btnEliminarClick() {
//         try {
//             if (IAStyle.showConfirmYesNo("¿Seguro que desea Eliminar?")) {
//                 // Eliminar grabación de la base de datos
//                 // if (!grabacionesBL.delete(grabacionDAO.getId()))
//                 //     throw new Exception("Error al eliminar...!");
                
//                 loadRow();
//                 showRow();
//                 showTable();
//             }
//         } catch (Exception e) {
//             IAStyle.showMsgError(e.getMessage());
//         }
//     }

//     private void btnCancelarClick() {
//         try {
//             if (/* grabacionDAO == null */ false)
//                 loadRow();
//             showRow();
//         } catch (Exception e) {}
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         if (e.getSource() == btnRowIni)
//             rowNum = 1;
//         if (e.getSource() == btnRowAnt && (rowNum > 1))
//             rowNum--;
//         if (e.getSource() == btnRowSig && (rowNum < idRowMaxGrabacion))
//             rowNum++;
//         if (e.getSource() == btnRowFin)
//             rowNum = idRowMaxGrabacion;
//         try {
//             // grabacionDAO = grabacionesBL.getBy(rowNum);
//             showRow(); 
//         } catch (Exception ex) {}
//     }

//     private void showTable() throws Exception {
//         // Aquí debes obtener los datos de las grabaciones desde la base de datos
//         // String[] header = {"ID", "Nombre", "Detalles"};
//         // Object[][] data = new Object[grabacionesBL.getAll().size()][3];
//         // int index = 0;
//         // for (GrabacionesDTO g : grabacionesBL.getAll()) {
//         //     data[index][0] = g.getId();
//         //     data[index][1] = g.getNombre();
//         //     data[index][2] = g.getDetalles();
//         //     index++;
//         // }

//         String[] header = {"ID", "Nombre", "Detalles"};
//         Object[][] data = new Object[10][3]; // Datos ficticios para la demostración
//         int index = 0;
//         for (int i = 1; i <= 10; i++) {
//             data[index][0] = i;
//             data[index][1] = "Grabación " + i;
//             data[index][2] = "Detalles " + i;
//             index++;
//         }

//         JTable table = new JTable(data, header);
//         table.setShowHorizontalLines(true);
//         table.setGridColor(Color.lightGray);
//         table.setRowSelectionAllowed(true);
//         table.setColumnSelectionAllowed(false);

//         table.setPreferredScrollableViewportSize(new Dimension(800, 400)); // Ajustar tamaño según sea necesario
//         table.setFillsViewportHeight(true);

//         pnlTabla.removeAll();
//         pnlTabla.add(new JScrollPane(table));

//         table.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                 int row = table.rowAtPoint(e.getPoint());
//                 int col = table.columnAtPoint(e.getPoint());
//                 if (row >= 0 && col >= 0) {
//                     String strRowNum = table.getModel().getValueAt(row, 0).toString();
//                     rowNum = Integer.parseInt(strRowNum);
//                     try {
//                         // grabacionDAO = grabacionesBL.getBy(rowNum);
//                         showRow();
//                     } catch (Exception ignored) {
//                     }
//                     System.out.println("Tabla.Selected: " + strRowNum);
//                 }
//             }
//         });
//     }

//     /************************
//      * FormDesing : pat_mic
//      ************************/ 
//     private PatLabel 
//             lblTitulo = new PatLabel("GRABACIONES"),
//             lblRowNum = new PatLabel(" ID:          "),
//             lblNombre = new PatLabel("*Nombre:     "),
//             lblPassword = new PatLabel("*Detalles:   "),
//             lblTotalReg = new PatLabel(" 0 de 0 ");
//     private PatTextBox 
//             txtRowNum = new PatTextBox(),
//             txtNombre = new PatTextBox(),
//             txtPassword = new PatTextBox();
//     private PatButton 
//             btnPageIni = new PatButton(" |< "),
//             btnPageAnt = new PatButton(" << "),
//             btnPageSig = new PatButton(" >> "),
//             btnPageFin = new PatButton(" >| "),

//             btnRowIni = new PatButton(" |< "),
//             btnRowAnt = new PatButton(" << "),
//             btnRowSig = new PatButton(" >> "),
//             btnRowFin = new PatButton(" >| "),

//             btnNuevo = new PatButton("Nuevo"),
//             btnGuardar = new PatButton("Guardar"),
//             btnCancelar = new PatButton("Cancelar"),
//             btnEliminar = new PatButton("Eliminar");
//     private JPanel 
//             pnlTabla = new JPanel(),
//             pnlBtnRow = new JPanel(new FlowLayout()),
//             pnlBtnPage = new JPanel(new FlowLayout()),
//             pnlBtnCRUD = new JPanel(new FlowLayout());

//     public void customizeComponent() {
//         setLayout(new GridBagLayout());
//         GridBagConstraints gbc = new GridBagConstraints();
        
//         txtRowNum.setEnabled(false);
//         txtRowNum.setBorderLine();
//         txtNombre.setBorderLine();
//         txtPassword.setBorderLine();

//         pnlBtnPage.add(btnPageIni);
//         pnlBtnPage.add(btnPageAnt);
//         pnlBtnPage.add(new PatLabel(" Page:( "));
//         pnlBtnPage.add(lblTotalReg); // Mostrar total de registros
//         pnlBtnPage.add(new PatLabel(" ) "));
//         pnlBtnPage.add(btnPageSig);
//         pnlBtnPage.add(btnPageFin);

//         pnlBtnRow.add(btnRowIni);
//         pnlBtnRow.add(btnRowAnt);
//         pnlBtnRow.add(lblTotalReg);
//         pnlBtnRow.add(btnRowSig);
//         pnlBtnRow.add(btnRowFin);

//         pnlBtnCRUD.add(btnNuevo);
//         pnlBtnCRUD.add(btnGuardar);
//         pnlBtnCRUD.add(btnEliminar);
//         pnlBtnCRUD.add(btnCancelar);

//         gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.insets = new Insets(5, 5, 5, 5);
//         add(lblTitulo, gbc);

//         gbc.gridy = 1; gbc.gridwidth = 1; gbc.fill = GridBagConstraints.NONE;
//         add(lblRowNum, gbc);
//         gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
//         add(txtRowNum, gbc);
//         gbc.gridx = 2; gbc.fill = GridBagConstraints.NONE;
//         add(lblNombre, gbc);
//         gbc.gridx = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
//         add(txtNombre, gbc);

//         gbc.gridy = 2; gbc.gridx = 0; gbc.fill = GridBagConstraints.NONE;
//         add(lblPassword, gbc);
//         gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
//         add(txtPassword, gbc);

//         gbc.gridy = 3; gbc.gridx = 0; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
//         add(pnlTabla, gbc);

//         gbc.gridy = 4; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
//         add(pnlBtnCRUD, gbc);

//         gbc.gridy = 5; gbc.gridwidth = 4; gbc.fill = GridBagConstraints.HORIZONTAL;
//         add(pnlBtnRow, gbc);
//     }
// }
