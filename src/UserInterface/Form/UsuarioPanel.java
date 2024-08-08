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

public class UsuarioPanel extends JPanel implements ActionListener {
    private Integer rowNum = 0, idRowMaxUsuario = 0;
    // Aquí se debe crear o inyectar una instancia de la lógica de negocio para usuarios
    // private UsuarioBL usuarioBL = new UsuarioBL();
    // private UsuarioDTO usuarioDAO = null;

    public UsuarioPanel() {
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

    private void loadRow() {
        try {
            rowNum = 1;
            // Implementar carga de usuario desde la base de datos
            // usuarioDAO = usuarioBL.getBy(rowNum);
            idRowMaxUsuario = 10; // Cambiar según la lógica de negocio
        } catch (Exception e) {
            IAStyle.showMsg(e.getMessage());
        }
    }

    private void showRow() {
        boolean usuarioNull = (/* usuarioDAO == null */ false);
        txtRowNum.setText((usuarioNull) ? " " : "ID"); // Mostrar ID del usuario
        txtNombre.setText((usuarioNull) ? " " : "Nombre"); // Mostrar nombre del usuario
        txtPassword.setText((usuarioNull) ? " " : "Contraseña"); // Mostrar contraseña del usuario
        lblTotalReg.setText(rowNum.toString() + " de " + idRowMaxUsuario.toString());
    }

    private void btnNuevoClick() {
        // usuarioDAO = null;
        showRow();
    } 

    private void btnGuardarClick() {
        boolean usuarioNull = (/* usuarioDAO == null */ false);
        try {
            if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((usuarioNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))) {
                if (usuarioNull) {
                    // Crear nuevo usuario
                    // usuarioDAO = new UsuarioDTO(txtNombre.getText().trim(), txtPassword.getText().trim());
                } else {
                    // Actualizar usuario existente
                    // usuarioDAO.setNombre(txtNombre.getText());
                    // usuarioDAO.setPassword(txtPassword.getText());
                }

                // Guardar el usuario en la base de datos
                // if (!((usuarioNull) ? usuarioBL.add(usuarioDAO) : usuarioBL.update(usuarioDAO)))
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
                // Eliminar usuario de la base de datos
                // if (!usuarioBL.delete(usuarioDAO.getId()))
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
            if (/* usuarioDAO == null */ false)
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
        if (e.getSource() == btnRowSig && (rowNum < idRowMaxUsuario))
            rowNum++;
        if (e.getSource() == btnRowFin)
            rowNum = idRowMaxUsuario;
        try {
            // usuarioDAO = usuarioBL.getBy(rowNum);
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        // Aquí debes obtener los datos de los usuarios desde la base de datos
        // String[] header = {"ID", "Nombre", "Contraseña"};
        // Object[][] data = new Object[usuarioBL.getAll().size()][3];
        // int index = 0;
        // for (UsuarioDTO u : usuarioBL.getAll()) {
        //     data[index][0] = u.getId();
        //     data[index][1] = u.getNombre();
        //     data[index][2] = u.getPassword();
        //     index++;
        // }

        String[] header = {"ID", "Nombre", "Contraseña"};
        Object[][] data = new Object[10][3]; // Datos ficticios para la demostración
        int index = 0;
        for (int i = 1; i <= 10; i++) {
            data[index][0] = i;
            data[index][1] = "Usuario " + i;
            data[index][2] = "Contraseña " + i;
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
                        // usuarioDAO = usuarioBL.getBy(rowNum);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strRowNum);
                }
            }
        });
    }

    /***************
     * FormDesing 
     ***************/
    private PatLabel 
            lblTitulo = new PatLabel("USUARIOS"),
            lblRowNum = new PatLabel(" ID:          "),
            lblNombre = new PatLabel("*Nombre:     "),
            lblPassword = new PatLabel("*Contraseña: "),
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
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(IAStyle.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 150;
        gbc.ipadx = 450;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);  // Ajustar el valor superior a 50
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblRowNum, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtRowNum, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtNombre, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        add(lblPassword, gbc);
        gbc.gridy = 7;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtPassword, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}
