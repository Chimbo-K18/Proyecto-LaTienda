package Vista;

import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;

/**
 *
 * @author Santiago
 */
public class VistaMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaMenu
     */
    public VistaMenuPrincipal() {
        initComponents();
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public JButton getBtnV2() {
        return btnV2;
    }

    public void setBtnV2(JButton btnV2) {
        this.btnV2 = btnV2;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblTipoUsuario() {
        return lblTipoUsuario;
    }

    public void setLblTipoUsuario(JLabel lblTipoUsuario) {
        this.lblTipoUsuario = lblTipoUsuario;
    }

    public JButton getBtnAdminPersonal() {
        return btnAdminPersonal;
    }

    public void setBtnAdminPersonal(JButton btnAdminPersonal) {
        this.btnAdminPersonal = btnAdminPersonal;
    }

    public JButton getBtnAdminProductos() {
        return btnAdminProductos;
    }

    public void setBtnAdminProductos(JButton btnAdminProductos) {
        this.btnAdminProductos = btnAdminProductos;
    }

    public JButton getBtnRegistrarClientes() {
        return btnRegistrarClientes;
    }

    public void setBtnRegistrarClientes(JButton btnRegistrarClientes) {
        this.btnRegistrarClientes = btnRegistrarClientes;
    }

    public JButton getBtnReportes() {
        return btnReportes;
    }

    public void setBtnReportes(JButton btnReportes) {
        this.btnReportes = btnReportes;
    }

    public JButton getBtnVentas() {
        return btnVentas;
    }

    public void setBtnVentas(JButton btnVentas) {
        this.btnVentas = btnVentas;
    }

    public JDesktopPane getjDeskPanel() {
        return jDeskPanel;
    }

    public void setjDeskPanel(JDesktopPane jDeskPanel) {
        this.jDeskPanel = jDeskPanel;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenu getjMenu2() {
        return menuCrearUsuarios;
    }

    public void setjMenu2(JMenu jMenu2) {
        this.menuCrearUsuarios = jMenu2;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    public JMenu getMenuCrearUsuarios() {
        return menuCrearUsuarios;
    }

    public void setMenuCrearUsuarios(JMenu menuCrearUsuarios) {
        this.menuCrearUsuarios = menuCrearUsuarios;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAdminProductos = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnAdminPersonal = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnVentas = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnReportes = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnRegistrarClientes = new javax.swing.JButton();
        jDeskPanel = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnV2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTipoUsuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCrearUsuarios = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar2.setBackground(new java.awt.Color(0, 107, 179));
        jToolBar2.setRollover(true);
        jToolBar2.add(jSeparator1);

        btnAdminProductos.setText("APR");
        btnAdminProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminProductosActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAdminProductos);
        jToolBar2.add(jSeparator4);

        btnAdminPersonal.setText("APE");
        jToolBar2.add(btnAdminPersonal);
        jToolBar2.add(jSeparator2);

        btnVentas.setText("VNT");
        jToolBar2.add(btnVentas);
        jToolBar2.add(jSeparator3);

        btnReportes.setText("RPT");
        jToolBar2.add(btnReportes);
        jToolBar2.add(jSeparator5);

        btnRegistrarClientes.setText("RCL");
        jToolBar2.add(btnRegistrarClientes);

        jDeskPanel.setBackground(new java.awt.Color(230, 245, 254));

        javax.swing.GroupLayout jDeskPanelLayout = new javax.swing.GroupLayout(jDeskPanel);
        jDeskPanel.setLayout(jDeskPanelLayout);
        jDeskPanelLayout.setHorizontalGroup(
            jDeskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );
        jDeskPanelLayout.setVerticalGroup(
            jDeskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("PR");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 57));

        jButton3.setText("PE");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 51, 57));

        jButton4.setText("VN");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 50, 57));

        jButton5.setText("RP");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 51, 57));

        jButton6.setText("RC");
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 51, 57));
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 50, 57));

        btnV2.setText("V2");
        jPanel1.add(btnV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 51, 57));
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 51, 57));
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 50, 57));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Helados \"La Tienda\"");

        jLabel2.setText("Software 1.0");

        jLabel3.setText("Usuario Registrado:");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTipoUsuario.setText("Admin");

        jLabel5.setText("Dirección:");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNombre.setText("Joaquin Ortega");
        lblNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Av. Don Bosco y Av. Loja");

        jLabel8.setText("Télefonos:");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("0985487758 - 4135687");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(lblNombre)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTipoUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jMenu1.setText("Productos");
        jMenuBar.add(jMenu1);

        menuCrearUsuarios.setText("Crear Usuario");
        jMenuBar.add(menuCrearUsuarios);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDeskPanel))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jDeskPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdminProductosActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminPersonal;
    private javax.swing.JButton btnAdminProductos;
    private javax.swing.JButton btnRegistrarClientes;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnV2;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDeskPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JMenu menuCrearUsuarios;
    // End of variables declaration//GEN-END:variables
}
