/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ArticuloJpaController;
import controladores.UsuarioJpaController;
import controladores.VentaJpaController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ArtCompra;
import modelo.Proveedor;
import modelo.Usuario;
import modelo.Venta;

/**
 *
 * @author magik
 */
public class ArticuloVenta extends javax.swing.JPanel {
     EntityManagerFactory emf =Persistence.createEntityManagerFactory("mx.edu.itoaxaca.Sistema_AutopartesPU");
    //ArtCompraJpaController service = new ArtCompraJpaController(emf);
    EntityManager em = emf.createEntityManager();
    
    VentaJpaController cp = new VentaJpaController(emf);
    UsuarioJpaController pro= new UsuarioJpaController(emf);
    ArticuloJpaController art= new ArticuloJpaController(emf);
    
    List<ArtCompra>  artCompra; 
    List<Venta> ven;
    List<Proveedor> pr;
    /**
     * Creates new form ArticuloCompra
     */
    public ArticuloVenta(String cargo) {
        initComponents();
        this.setSize(1300,621);
        this.setVisible(true);
        
        
        ActualizarTabla();
        llenar();
           }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        provedor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1300, 621));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "FECHA", "ID VENDEDOR", "VENDEDOR", "TOTAL"
            }
        ));
        tabla.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        jLabel1.setText("BUSCAR POR ID ");

        id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel2.setText("VENDEDOR");

        provedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        provedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provedorActionPerformed(evt);
            }
        });

        jLabel3.setText("FECHA");

        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("yyyy-mm-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id, 0, 221, Short.MAX_VALUE)
                            .addComponent(fecha))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(provedor, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(provedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Andalus", 0, 24)); // NOI18N
        jLabel5.setText("VENTAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1169, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(497, 497, 497)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel5)
                .addGap(45, 45, 45)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
 
    public void llenar(){
        //=================LLENAR ID=====================
         DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(new String [] {});
      //artCompra=service.findArtCompraEntities();
      
      for(int i=0;i<cp.getVentaCount();i++){
          Venta ac;
          ac=cp.findVentaEntities().get(i);
          String ids= String.valueOf(ac.getVentaId());
          modeloCombo.addElement(ids);
      }
      id.setModel(modeloCombo);  
      
      //=======================LLenar Provedor=================
      DefaultComboBoxModel mode2 = new DefaultComboBoxModel(new String [] {});
      //pr=pro.findProveedorEntities();
      
      for(int i=0;i<pro.getUsuarioCount();i++){
          Usuario ap;
          ap=pro.findUsuarioEntities().get(i);
          String ids= ap.getNombres();
          mode2.addElement(ids);
      }
      provedor.setModel(mode2);  
    }
    
   private void ActualizarTabla(){
        Object [] fila=new Object[6]; 
        String[] titulos = {"ID VENTA","FECHA DE LA VENTA","ID VENDEDOR","VENDEDOR","TOTAL"};
       DefaultTableModel dt= new DefaultTableModel(titulos,0);
        for(int i=0;i<cp.getVentaCount();i++){
          Venta ac;
          ac=cp.findVentaEntities().get(i);
         // String ids= String.valueOf(ac.getCompraId());
          Usuario p= pro.findUsuario(ac.getVendedor());
          fila[0]=ac.getVentaId();
          fila[1]=ac.getFecha();
          fila[2]=ac.getVendedor();
          fila[3]=p.getNombres();
          fila[4]=ac.getTotal();
          
          
          dt.addRow(fila);
      }
      tabla.setModel(dt);  
       
   }
    private void provedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provedorActionPerformed
        // TODO add your handling code here:
        
     
        String caso =String.valueOf(provedor.getSelectedItem());
        
         Object [] fila=new Object[6]; 
        String[] titulos = {"ID VENTA","FECHA DE LA VENTA","ID VENDEDOR","VENDEDOR","TOTAL"};
       DefaultTableModel dt= new DefaultTableModel(titulos,0);
        for(int i=0;i<cp.getVentaCount();i++){
          Venta ac;
          
          ac=cp.findVentaEntities().get(i);
           Usuario p= pro.findUsuario(ac.getVendedor());
          String ids = p.getNombres();
          if(caso.equals(ids)){
             // Proveedor p= pro.findProveedor(ac.getProv());
          fila[0]=ac.getVentaId();
          fila[1]=ac.getFecha();
          fila[2]=ac.getVendedor();
          fila[3]=p.getNombres();
          fila[4]=ac.getTotal();  
          
           dt.addRow(fila);
          }

      }
      tabla.setModel(dt);  
    }//GEN-LAST:event_provedorActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
   
        
    }//GEN-LAST:event_formFocusGained

    private void tablaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablaFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ActualizarTabla();
        llenar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
        
       
        int caso =Integer.parseInt(String.valueOf(id.getSelectedItem()));
        
         Object [] fila=new Object[6]; 
        String[] titulos = {"ID VENTA","FECHA DE LA VENTA","ID VENDEDOR","VENDEDOR","TOTAL"};
       DefaultTableModel dt= new DefaultTableModel(titulos,0);
        for(int i=0;i<cp.getVentaCount();i++){
          Venta ac;
          
          ac=cp.findVentaEntities().get(i);
          int ids = ac.getVentaId();
          if(caso==ids){
              Usuario p= pro.findUsuario(ac.getVendedor());
          fila[0]=ac.getVentaId();
          fila[1]=ac.getFecha();
          fila[2]=ac.getVendedor();
          fila[3]=p.getNombres();
          fila[4]=ac.getTotal();  
          
           dt.addRow(fila);
          }

      }
      tabla.setModel(dt);  
    }//GEN-LAST:event_idActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat fr= new SimpleDateFormat("yyyy-MM-dd");
        Date caso=null;
         try {
             caso = fr.parse(fecha.getText());
                      Object [] fila=new Object[6]; 
        String[] titulos = {"ID VENTA","FECHA DE LA VENTA","ID VENDEDOR","VENDEDOR","TOTAL"};
       DefaultTableModel dt= new DefaultTableModel(titulos,0);
        for(int i=0;i<cp.getVentaCount();i++){
          Venta ac;
          
          ac=cp.findVentaEntities().get(i);
          Date ids = ac.getFecha();
          if(caso.equals(ids)){
              Usuario p= pro.findUsuario(ac.getVendedor());
          fila[0]=ac.getVentaId();
          fila[1]=ac.getFecha();
          fila[2]=ac.getVendedor();
          fila[3]=p.getNombres();
          fila[4]=ac.getTotal();  
          
           dt.addRow(fila);
          }

      }
      tabla.setModel(dt); 
             
         } catch (ParseException ex) {
             //Logger.getLogger(ArticuloCompra.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"INGRESE UN VALOR VALIDO (YYYY-MM-DD)");
         } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jPanel1FocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fecha;
    private javax.swing.JComboBox<String> id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> provedor;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
