package Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
        TextPrompt texto = new TextPrompt("Nombre",txtnombreP);
        TextPrompt texto1 = new TextPrompt("Id",txtID);
        TextPrompt texto2 = new TextPrompt("Stock",txtStock);
        TextPrompt texto9 = new TextPrompt("Precio",txtprecio);
        TextPrompt texto11 = new TextPrompt("Buscar",txtBuscarRp);
   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlBotones = new javax.swing.JPanel();
        txtBuscarRp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnEliminarRp = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnGuardarRp = new javax.swing.JButton();
        btnEditarRp = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtnombreP = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDescripcion = new javax.swing.JTextArea();
        btnExaminar = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(230, 245, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBotones.setBackground(new java.awt.Color(0, 107, 179));
        pnlBotones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscarRp.setForeground(new java.awt.Color(51, 51, 51));
        pnlBotones.add(txtBuscarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar:");
        pnlBotones.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 50, 20));

        jPanel1.add(pnlBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 730, 60));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre", "Precio", "Stock", "Descripcion", "Foto"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 730, 150));

        btnEliminarRp.setText("Eliminar");
        jPanel1.add(btnEliminarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, -1, 30));

        btnAceptar.setText("Nuevo");
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 70, 30));

        btnGuardarRp.setText("Actualizar");
        jPanel1.add(btnGuardarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, 30));

        btnEditarRp.setText("Editar");
        jPanel1.add(btnEditarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 70, 30));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, 40));
        jPanel1.add(txtnombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 160, 40));
        jPanel1.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 40));
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 160, 40));

        areaDescripcion.setColumns(20);
        areaDescripcion.setRows(5);
        jScrollPane2.setViewportView(areaDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 400, 60));

        btnExaminar.setText("Examinar");
        jPanel1.add(btnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, -1, 30));

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFoto.setOpaque(true);
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 150, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    

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
        return btnAceptar;
    }

    public void setBtnNuevoRp(JButton btnNuevoRp) {
        this.btnAceptar = btnNuevoRp;
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
    private javax.swing.JTextArea areaDescripcion;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnEditarRp;
    private javax.swing.JButton btnEliminarRp;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnGuardarRp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
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
