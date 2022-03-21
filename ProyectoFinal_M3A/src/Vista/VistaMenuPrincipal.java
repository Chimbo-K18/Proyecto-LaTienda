package Vista;

import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
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

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
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
        return jMenu2;
    }

    public void setjMenu2(JMenu jMenu2) {
        this.jMenu2 = jMenu2;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
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
        jButton2 = new javax.swing.JButton();
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
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar2.setBackground(new java.awt.Color(0, 107, 179));
        jToolBar2.setRollover(true);

        jButton2.setText("B1");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton2);
        jToolBar2.add(jSeparator1);

        btnAdminProductos.setText("APE");
        btnAdminProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminProductosActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAdminProductos);
        jToolBar2.add(jSeparator4);

        btnAdminPersonal.setText("APR");
        jToolBar2.add(btnAdminPersonal);
        jToolBar2.add(jSeparator2);

        btnVentas.setText("VN");
        jToolBar2.add(btnVentas);
        jToolBar2.add(jSeparator3);

        btnReportes.setText("RP");
        jToolBar2.add(btnReportes);
        jToolBar2.add(jSeparator5);

        btnRegistrarClientes.setText("RC");
        jToolBar2.add(btnRegistrarClientes);

        jDeskPanel.setBackground(new java.awt.Color(230, 245, 254));

        javax.swing.GroupLayout jDeskPanelLayout = new javax.swing.GroupLayout(jDeskPanel);
        jDeskPanel.setLayout(jDeskPanelLayout);
        jDeskPanelLayout.setHorizontalGroup(
            jDeskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDeskPanelLayout.setVerticalGroup(
            jDeskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
            .addComponent(jDeskPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDeskPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdminProductosActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminPersonal;
    private javax.swing.JButton btnAdminProductos;
    private javax.swing.JButton btnRegistrarClientes;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDeskPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
