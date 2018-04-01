/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author ISCO
 */
public class PanelCompras extends javax.swing.JPanel {

    /**
     * Creates new form PanelCompras
     */
    public PanelCompras(String cargo) {
        initComponents();
        setSeguridad(cargo);
    }
    
    public void setSeguridad(String cargo){
        String s = cargo.toLowerCase();
        if(s.equals("administrador")){
            panelSeguridad.setVisible(true);
        }
        else{
                panelSeguridad.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSeguridad = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textFolioVenta = new javax.swing.JTextField();
        comboCodigo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textFecha = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Folio de Compra");

        textFolioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFolioVentaActionPerformed(evt);
            }
        });

        comboCodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comboCodigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCodigoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Vendedor");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setText("Fecha");

        javax.swing.GroupLayout panelSeguridadLayout = new javax.swing.GroupLayout(panelSeguridad);
        panelSeguridad.setLayout(panelSeguridadLayout);
        panelSeguridadLayout.setHorizontalGroup(
            panelSeguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeguridadLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFolioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(393, Short.MAX_VALUE))
        );
        panelSeguridadLayout.setVerticalGroup(
            panelSeguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeguridadLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelSeguridadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFolioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(563, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeguridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeguridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textFolioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFolioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFolioVentaActionPerformed

    private void comboCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCodigoActionPerformed
        // TODO add your handling code here:
      /*  String claveaBuscar=null;
        int aux = 0;
        try{
            claveaBuscar=comboCodigo.getSelectedItem().toString();
            aux = Integer.parseInt(claveaBuscar);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ingresa un código valido");
        }

        if(claveaBuscar!=null){
            busqueda = ajc.findArticulo(aux);
            if(busqueda!=null){
                textCantidad.setToolTipText("ingresa el numero de unidades");
                textArticulo.setText(busqueda.getNombre());
                precioArt = busqueda.getPrecio();
                textPrecio.setText(String.valueOf(Math.floor(precioArt * 100) / 100));

            }else JOptionPane.showMessageDialog(null,"error interno");
        }*/
    }//GEN-LAST:event_comboCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelSeguridad;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textFolioVenta;
    // End of variables declaration//GEN-END:variables
}
