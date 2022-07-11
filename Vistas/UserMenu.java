package Vistas;

import Modelo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UserMenu extends javax.swing.JFrame {
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTablaEmpleados;
    

    public UserMenu() {
        initComponents();
        listarEmpleados();
    }

    private void listarEmpleados(){
        
        String filtroBusqueda = txtSearch.getText();
        if (filtroBusqueda.isEmpty()) {

            String query = "SELECT * FROM empleados";
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Object[] empleado = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tblEmployee.getModel();
                while (rs.next()) {
                    empleado[0] = rs.getInt("idEmp");
                    empleado[1] = rs.getString("nombreEmp");
                    empleado[2] = rs.getString("apellidos");
                    empleado[3] = rs.getString("tipoDocumento");
                    empleado[4] = rs.getString("documento");
                    empleado[5] = rs.getString("correo");
                    contenidoTablaEmpleados.addRow(empleado);
                    tblEmployee.setModel(contenidoTablaEmpleados);
                    System.out.println("idEmp: " + empleado[0] + ", nombre: " + empleado[1] + ", apellidos" + empleado[2]
                            + ", tipodocumento: " + empleado[3] + ", documento" + empleado[4] + ", correo: " + empleado[5]);
                }
            } catch (SQLException e) {
                System.out.println("No se pudo cargar información de los empleados");
            }
        } else {
            String query = "SELECT * FROM empleados WHERE nombreEmp like '%"+filtroBusqueda+"%' OR apellidos like '%"+filtroBusqueda+"%' ";
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Object[] empleado = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tblEmployee.getModel();
                while (rs.next()) {
                    empleado[0] = rs.getInt("idEmp");
                    empleado[1] = rs.getString("nombreEmp");
                    empleado[2] = rs.getString("apellidos");
                    empleado[3] = rs.getString("tipoDocumento");
                    empleado[4] = rs.getString("documento");
                    empleado[5] = rs.getString("correo");
                    contenidoTablaEmpleados.addRow(empleado);
                    tblEmployee.setModel(contenidoTablaEmpleados);
                    System.out.println("idEmp: " + empleado[0] + ", nombre: " + empleado[1] + ", apellidos" + empleado[2]
                            + ", tipodocumento: " + empleado[3] + ", documento" + empleado[4] + ", correo: " + empleado[5]);
                }
            } catch (SQLException e) {
                System.out.println("No se pudo cargar información de los empleados");
            }
        }
    }
    private void borrarRegistrosTabla(){
        for (int i = 0; i < tblEmployee.getRowCount(); i++){
            contenidoTablaEmpleados.removeRow(i);
            i = i - 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        btnAdduser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú de Usuario");
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id empleado", "Nombres", "Apellidos", "Tipo documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmployee.setGridColor(new java.awt.Color(255, 255, 255));
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        btnAdduser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/avatar.png"))); // NOI18N
        btnAdduser.setText("Añadir empleado");
        btnAdduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdduserActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("  Empleados");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("  Misión TIC");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Buscar:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(165, 165, 165)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addComponent(btnAdduser)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdduser)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Empleados", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdduserActionPerformed
        AddUserForm adduserform = new AddUserForm(this, true);
        adduserform.setVisible(true);
        borrarRegistrosTabla();
        listarEmpleados();
        
    }//GEN-LAST:event_btnAdduserActionPerformed

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        //1. Capturar el número de fila seleccionada
        int row = tblEmployee.getSelectedRow();
        System.out.println("Fila seleccionada" + row);
        //2. Validar si el usuario no ha seleccionado una fila
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un empleado.", "", JOptionPane.WARNING_MESSAGE);
        } else {
            //3. Indicamos de la fila de empleado (id, nombre,tipo doc, doc, correo)
            //fila 0 columna 0 = id
            int Idempleado = Integer.parseInt(tblEmployee.getValueAt(row, 0).toString());
            //Tener en cuenta que los de la tabla estan en tipo Object
            //fila 0 columna 1 = nombre empleado
            String nombres = (String) tblEmployee.getValueAt(row, 1);
            String apellidos = (String) tblEmployee.getValueAt(row, 2);
            String tipoDocumento = (String) tblEmployee.getValueAt(row, 3);
            String documento = (String) tblEmployee.getValueAt(row, 4);
            String correo = (String) tblEmployee.getValueAt(row, 5);
            System.out.println("Id: " + Idempleado + ", empleado" + nombres + "" + apellidos + ", tipo Documento:" + tipoDocumento
                    + ", documento:" + documento + ", correo:" + correo);
            ShowUserForm showUserForm = new ShowUserForm(this, true);
            showUserForm.recibirDatos(Idempleado, nombres, apellidos, tipoDocumento, documento, correo);
            showUserForm.setVisible(true);
            borrarRegistrosTabla();
            listarEmpleados();

}
        
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        borrarRegistrosTabla();
        listarEmpleados();
    }//GEN-LAST:event_btnSearchActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdduser;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
