package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/** @author Bryan Orellana */
public class VistaRegistroProductos extends javax.swing.JInternalFrame  {

    public VistaRegistroProductos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlBuscar = new javax.swing.JPanel();
        txtBuscarRp = new javax.swing.JTextField();
        btnBuscarRp = new javax.swing.JButton();
        pnlRegistro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdRp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreRp = new javax.swing.JTextField();
        txtPrecioRp = new javax.swing.JTextField();
        txtStockRp = new javax.swing.JTextField();
        txtDescripcionRp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFotoRp = new javax.swing.JLabel();
        btnFotoRp = new javax.swing.JButton();
        pnlBotones = new javax.swing.JPanel();
        btnGuardarRp = new javax.swing.JButton();
        btnEditarRp = new javax.swing.JButton();
        btnNuevoRp = new javax.swing.JButton();
        btnEliminarRp = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 255, 153));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(17, 177, 124));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBuscar.setBackground(new java.awt.Color(255, 255, 255));
        pnlBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscarRp.setForeground(new java.awt.Color(51, 51, 51));
        pnlBuscar.add(txtBuscarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 18, 238, -1));

        btnBuscarRp.setBackground(new java.awt.Color(153, 153, 153));
        btnBuscarRp.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarRp.setText("Buscar");
        pnlBuscar.add(btnBuscarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 17, -1, -1));

        jPanel1.add(pnlBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 11, 340, 60));

        pnlRegistro.setBackground(new java.awt.Color(255, 255, 255));
        pnlRegistro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Registro Producto");
        pnlRegistro.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 14, -1, -1));

        txtIdRp.setForeground(new java.awt.Color(51, 51, 51));
        pnlRegistro.add(txtIdRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 34, 100, -1));

        jLabel2.setText("ID Producto");
        pnlRegistro.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        txtNombreRp.setForeground(new java.awt.Color(51, 51, 51));
        pnlRegistro.add(txtNombreRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 60, 100, -1));

        txtPrecioRp.setForeground(new java.awt.Color(51, 51, 51));
        pnlRegistro.add(txtPrecioRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 86, 100, -1));

        txtStockRp.setForeground(new java.awt.Color(51, 51, 51));
        pnlRegistro.add(txtStockRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 112, 100, -1));

        txtDescripcionRp.setForeground(new java.awt.Color(51, 51, 51));
        pnlRegistro.add(txtDescripcionRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 136, 150, 64));

        jLabel3.setText("Nombre");
        pnlRegistro.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 63, -1, -1));

        jLabel4.setText("Precio");
        pnlRegistro.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 89, -1, -1));

        jLabel5.setText("Stock");
        pnlRegistro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 115, -1, -1));

        jLabel6.setText("Desecripcion");
        pnlRegistro.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 161, -1, -1));

        lblFotoRp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoRp.setText("Foto");
        lblFotoRp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlRegistro.add(lblFotoRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 30, 111, 106));

        btnFotoRp.setBackground(new java.awt.Color(153, 153, 153));
        btnFotoRp.setForeground(new java.awt.Color(255, 255, 255));
        btnFotoRp.setText("Examinar");
        pnlRegistro.add(btnFotoRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 143, -1, -1));

        jPanel1.add(pnlRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, 460, 230));

        pnlBotones.setBackground(new java.awt.Color(255, 255, 255));
        pnlBotones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardarRp.setBackground(new java.awt.Color(153, 153, 153));
        btnGuardarRp.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarRp.setText("Guardar");
        pnlBotones.add(btnGuardarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btnEditarRp.setBackground(new java.awt.Color(153, 153, 153));
        btnEditarRp.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarRp.setText("Editar");
        pnlBotones.add(btnEditarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, -1));

        btnNuevoRp.setBackground(new java.awt.Color(153, 153, 153));
        btnNuevoRp.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoRp.setText("Nuevo");
        pnlBotones.add(btnNuevoRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, -1));

        btnEliminarRp.setBackground(new java.awt.Color(153, 153, 153));
        btnEliminarRp.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarRp.setText("Eliminar");
        pnlBotones.add(btnEliminarRp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        btnImprimir.setBackground(new java.awt.Color(153, 153, 153));
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("Imprimir");
        pnlBotones.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jPanel1.add(pnlBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 87, 91, 179));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Precio", "Stock", "Foto"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 560, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public void setBtnImprimir(JButton btnImprimir) {
        this.btnImprimir = btnImprimir;
    }

   

    public JButton getBtnFotoRp() {
        return btnFotoRp;
    }

    public void setBtnFotoRp(JButton btnFotoRp) {
        this.btnFotoRp = btnFotoRp;
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

    public JLabel getLblFotoRp() {
        return lblFotoRp;
    }

    public void setLblFotoRp(JLabel lblFotoRp) {
        this.lblFotoRp = lblFotoRp;
    }

    public JPanel getPnlBotones() {
        return pnlBotones;
    }

    public void setPnlBotones(JPanel pnlBotones) {
        this.pnlBotones = pnlBotones;
    }

    public JPanel getPnlBuscar() {
        return pnlBuscar;
    }

    public void setPnlBuscar(JPanel pnlBuscar) {
        this.pnlBuscar = pnlBuscar;
    }

    public JPanel getPnlRegistro() {
        return pnlRegistro;
    }

    public void setPnlRegistro(JPanel pnlRegistro) {
        this.pnlRegistro = pnlRegistro;
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

    public JTextField getTxtDescripcionRp() {
        return txtDescripcionRp;
    }

    public void setTxtDescripcionRp(JTextField txtDescripcionRp) {
        this.txtDescripcionRp = txtDescripcionRp;
    }

    public JTextField getTxtIdRp() {
        return txtIdRp;
    }

    public void setTxtIdRp(JTextField txtIdRp) {
        this.txtIdRp = txtIdRp;
    }

    public JTextField getTxtNombreRp() {
        return txtNombreRp;
    }

    public void setTxtNombreRp(JTextField txtNombreRp) {
        this.txtNombreRp = txtNombreRp;
    }

    public JTextField getTxtPrecioRp() {
        return txtPrecioRp;
    }

    public void setTxtPrecioRp(JTextField txtPrecioRp) {
        this.txtPrecioRp = txtPrecioRp;
    }

    public JTextField getTxtStockRp() {
        return txtStockRp;
    }

    public void setTxtStockRp(JTextField txtStockRp) {
        this.txtStockRp = txtStockRp;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistroProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistroProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarRp;
    private javax.swing.JButton btnEditarRp;
    private javax.swing.JButton btnEliminarRp;
    private javax.swing.JButton btnFotoRp;
    private javax.swing.JButton btnGuardarRp;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevoRp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFotoRp;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscarRp;
    private javax.swing.JTextField txtDescripcionRp;
    private javax.swing.JTextField txtIdRp;
    private javax.swing.JTextField txtNombreRp;
    private javax.swing.JTextField txtPrecioRp;
    private javax.swing.JTextField txtStockRp;
    // End of variables declaration//GEN-END:variables
}
