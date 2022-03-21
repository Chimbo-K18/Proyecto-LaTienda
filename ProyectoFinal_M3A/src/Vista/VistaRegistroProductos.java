package Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/** @author Bryan Orellana */
public class VistaRegistroProductos extends javax.swing.JInternalFrame  {

    public VistaRegistroProductos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogoProducto = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDescripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnombreP = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        btnExaminar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pnlBotones = new javax.swing.JPanel();
        btnGuardarRp = new javax.swing.JButton();
        btnEditarRp = new javax.swing.JButton();
        btnNuevoRp = new javax.swing.JButton();
        btnEliminarRp = new javax.swing.JButton();
        txtBuscarRp = new javax.swing.JTextField();
        btnBuscarRp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("ID:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel8.setText("Precio:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel9.setText("Descripcion:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));
        jPanel2.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 120, -1));
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 120, -1));

        areaDescripcion.setColumns(20);
        areaDescripcion.setRows(5);
        jScrollPane2.setViewportView(areaDescripcion);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, 60));

        jLabel10.setText("Nombre:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jLabel11.setText("Stock:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));
        jPanel2.add(txtnombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 160, -1));
        jPanel2.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 130, -1));

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setOpaque(true);
        jPanel2.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 150, 120));

        btnExaminar.setText("Examinar");
        jPanel2.add(btnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, -1, -1));

        btnAceptar.setText("Aceptar");
        jPanel2.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        javax.swing.GroupLayout DialogoProductoLayout = new javax.swing.GroupLayout(DialogoProducto.getContentPane());
        DialogoProducto.getContentPane().setLayout(DialogoProductoLayout);
        DialogoProductoLayout.setHorizontalGroup(
            DialogoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
        DialogoProductoLayout.setVerticalGroup(
            DialogoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(153, 255, 153));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(230, 245, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBotones.setBackground(new java.awt.Color(0, 107, 179));
        pnlBotones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardarRp.setText("Guardar");
        pnlBotones.add(btnGuardarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        btnEditarRp.setText("Editar");
        pnlBotones.add(btnEditarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 70, -1));

        btnNuevoRp.setText("Nuevo");
        pnlBotones.add(btnNuevoRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, -1));

        btnEliminarRp.setText("Eliminar");
        pnlBotones.add(btnEliminarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        txtBuscarRp.setForeground(new java.awt.Color(51, 51, 51));
        pnlBotones.add(txtBuscarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 160, -1));

        btnBuscarRp.setText("Buscar");
        pnlBotones.add(btnBuscarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));

        jPanel1.add(pnlBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 60));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Precio", "Stock", "Descripcion", "Foto"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 700, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    public JTextArea getAreaDescripcion() {
        return areaDescripcion;
    }

    public void setAreaDescripcion(JTextArea areaDescripcion) {
        this.areaDescripcion = areaDescripcion;
    }

    public JButton getBtnExaminar() {
        return btnExaminar;
    }

    public void setBtnExaminar(JButton btnExaminar) {
        this.btnExaminar = btnExaminar;
    }

    public JLabel getLblFoto() {
        return lblFoto;
    }

    public void setLblFoto(JLabel lblFoto) {
        this.lblFoto = lblFoto;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public JTextField getTxtStock() {
        return txtStock;
    }

    public void setTxtStock(JTextField txtStock) {
        this.txtStock = txtStock;
    }

    public JTextField getTxtnombreP() {
        return txtnombreP;
    }

    public void setTxtnombreP(JTextField txtnombreP) {
        this.txtnombreP = txtnombreP;
    }

    public JTextField getTxtprecio() {
        return txtprecio;
    }

    public void setTxtprecio(JTextField txtprecio) {
        this.txtprecio = txtprecio;
    }

    public JDialog getDialogoProducto() {
        return DialogoProducto;
    }

    public void setDialogoProducto(JDialog DialogoProducto) {
        this.DialogoProducto = DialogoProducto;
    }

    public JButton getBtnBuscarRp() {
        return btnBuscarRp;
    }

    public void setBtnBuscarRp(JButton btnBuscarRp) {
        this.btnBuscarRp = btnBuscarRp;
    }

    public JButton getBtnEditarRp() {
        return btnEditarRp;
    }

    public void setBtnEditarRp(JButton btnEditarRp) {
        this.btnEditarRp = btnEditarRp;
    }

    public JButton getBtnEliminarRp() {
        return btnEliminarRp;
    }

    public void setBtnEliminarRp(JButton btnEliminarRp) {
        this.btnEliminarRp = btnEliminarRp;
    }

   
    public JButton getBtnGuardarRp() {
        return btnGuardarRp;
    }

    public void setBtnGuardarRp(JButton btnGuardarRp) {
        this.btnGuardarRp = btnGuardarRp;
    }

    public JButton getBtnNuevoRp() {
        return btnNuevoRp;
    }

    public void setBtnNuevoRp(JButton btnNuevoRp) {
        this.btnNuevoRp = btnNuevoRp;
    }


    public JPanel getPnlBotones() {
        return pnlBotones;
    }

    public void setPnlBotones(JPanel pnlBotones) {
        this.pnlBotones = pnlBotones;
    }


    public JTable getTablaProductos() {
        return tablaProductos;
    }

    public void setTablaProductos(JTable tablaProductos) {
        this.tablaProductos = tablaProductos;
    }

    public JTextField getTxtBuscarRp() {
        return txtBuscarRp;
    }

    public void setTxtBuscarRp(JTextField txtBuscarRp) {
        this.txtBuscarRp = txtBuscarRp;
    }


   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogoProducto;
    private javax.swing.JTextArea areaDescripcion;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscarRp;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarRp;
    private javax.swing.JButton btnEliminarRp;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnGuardarRp;
    private javax.swing.JButton btnNuevoRp;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscarRp;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtnombreP;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
