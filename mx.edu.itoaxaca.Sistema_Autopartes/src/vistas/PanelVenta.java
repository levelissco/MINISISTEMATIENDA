/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ArtVentaJpaController;
import controladores.ArticuloJpaController;
import controladores.VentaJpaController;
import controladores.exceptions.NonexistentEntityException;
import java.awt.HeadlessException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ArtVenta;
import modelo.Articulo;
import modelo.Venta;

/**
 *
 * @author ISCO
 */
public class PanelVenta extends javax.swing.JPanel {

    private EntityManagerFactory emf;
    private ArticuloJpaController ajc;
    private DefaultComboBoxModel comboModel;
    private Articulo articulo, busqueda;
    private String nombreVendedor ="";
    private int idUsuarioLogin = 0;
    private VentaJpaController vjc;
    private ArtVenta artV;
    private ArtVentaJpaController avjc;
    
    private Double precioArt = 0.0;
    private Double subtotal = 0.0;
    private Double total = 0.0;
    private Double pago = 0.0;
    private Double cambio = 0.0;
    private int folioVenta = 0;
    
    private JTable tabla;
    private double auxTotal =0;
    
    DefaultTableModel model;
    
    /**
     * Creates new form PanelVenta
     */
    public PanelVenta(String vendedor, int idUsuarioLogin) {
        nombreVendedor = vendedor;
        this.idUsuarioLogin = idUsuarioLogin;
        initComponents();
        this.setSize(1300,621);
        initPanel();
        
        emf=Persistence.createEntityManagerFactory("mx.edu.itoaxaca.Sistema_AutopartesPU");
        ajc= new ArticuloJpaController(emf);
        vjc= new VentaJpaController(emf);
        avjc = new ArtVentaJpaController(emf);
        
        listaFolio();
        //String encabezado[]={"Codigo","Articulo","Cantidad","Precio"};
        //model=new DefaultTableModel(encabezado,0);
        //tabla = new javax.swing.JTable(model);
    }

    public void listaFolio(){
        List <Articulo> array = ajc.findArticuloEntities();
       String [] options = new String[array.size()];
       for(int x = 0; x < array.size(); x++){
           options[x] = array.get(x).getArtId()+"";
       }
       comboCodigo.setModel(new DefaultComboBoxModel(options));
    }
    
    public void initPanel(){
        textFolioVenta.setEnabled(false);
        textVendedor.setEnabled(false);
        textFecha.setEnabled(false);
        comboCodigo.setEnabled(false);
        textArticulo.setEnabled(false);
        textCantidad.setEnabled(false);
        btnAgregar.setEnabled(false);
        tablaArt.setEnabled(false);
        textSubtotal.setEnabled(false);
        textTotal.setEnabled(false);
        textPago.setEnabled(false);
        textCambio.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnCancelar.setEnabled(false);
        textPrecio.setEnabled(false);
        btnFacturar.setEnabled(false);
        btnTerminar.setEnabled(false);
    }
    
    public void limpiarCampos(){
        textFolioVenta.setText("");
        textVendedor.setText("");
        textFecha.setText("");
        comboCodigo.setSelectedIndex(0);
        textArticulo.setText("");
        textCantidad.setText("");
        btnAgregar.setEnabled(true);
        //tablaArt.setModel();
        model=(DefaultTableModel)tablaArt.getModel();
        model.setNumRows(0);
        tablaArt.setModel(model);
        textSubtotal.setText("");
        textTotal.setText("");
        textPago.setText("");
        textCambio.setText("");
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        textPrecio.setText("");
    }
    
    public void editarV(){
        textFolioVenta.setEnabled(true);
        textFolioVenta.setEditable(false);
        textVendedor.setEnabled(true);
        textVendedor.setEditable(false);
        textFecha.setEnabled(true);
        textFecha.setEditable(false);
        comboCodigo.setEnabled(true);
        textArticulo.setEnabled(true);
        textCantidad.setEnabled(true);
        btnAgregar.setEnabled(true);
        tablaArt.setEnabled(true);
        textSubtotal.setEnabled(true);
        textSubtotal.setEditable(false);
        textTotal.setEnabled(true);
        textTotal.setEditable(false);
        textPago.setEnabled(true);
        textCambio.setEnabled(true);
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        textPrecio.setEnabled(true);
        textPrecio.setEditable(false);
        textCambio.setEditable(false);
        textPago.setToolTipText("ingresa el monto del pago");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArt = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        textFolioVenta = new javax.swing.JTextField();
        textVendedor = new javax.swing.JTextField();
        panelCamposRelleno = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textCantidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        comboCodigo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        textArticulo = new javax.swing.JTextField();
        textFecha = new javax.swing.JTextField();
        btnNueva = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textSubtotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textPago = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        textCambio = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textPrecio = new javax.swing.JTextField();
        btnFacturar = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Vendedor");

        tablaArt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO"
            }
        ));
        jScrollPane1.setViewportView(tablaArt);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Folio de Venta");

        textFolioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFolioVentaActionPerformed(evt);
            }
        });

        panelCamposRelleno.setBackground(new java.awt.Color(255, 255, 153));

        btnAgregar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAgregar.setText("Agregar Articulo");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("Cantidad");

        javax.swing.GroupLayout panelCamposRellenoLayout = new javax.swing.GroupLayout(panelCamposRelleno);
        panelCamposRelleno.setLayout(panelCamposRellenoLayout);
        panelCamposRellenoLayout.setHorizontalGroup(
            panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(btnAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCamposRellenoLayout.setVerticalGroup(
            panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setText("Fecha");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("Codigo del Articulo ");

        comboCodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comboCodigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCodigoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Articulo");

        btnNueva.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nuevo.jpg"))); // NOI18N
        btnNueva.setText("Nueva Venta");
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Subtotal");

        textSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSubtotalActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Total");

        textTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTotalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Pago");

        textPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPagoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel17.setText("Cambio");

        textCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCambioActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Ingresar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Salir.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("Precio");

        btnFacturar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/factura.jpg"))); // NOI18N
        btnFacturar.setText("FACTURAR");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });

        btnTerminar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnTerminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Salir.png"))); // NOI18N
        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboCodigo, 0, 172, Short.MAX_VALUE)
                            .addComponent(textFolioVenta))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(textVendedor))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addComponent(btnNueva)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textPago, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCambio)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCamposRelleno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFolioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelCamposRelleno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPago, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        model=(DefaultTableModel)tablaArt.getModel();
        int c = Integer.parseInt(textCantidad.getText());
        
        if(c > 0){
            String[] rowData={comboCodigo.getSelectedItem().toString(),textArticulo.getText(),textCantidad.getText(),String.valueOf(precioArt)};
            model.addRow(rowData);
            
            artV= new ArtVenta();
            int i = Integer.parseInt(textFolioVenta.getText().toString());
            artV.setVentaId(i);
            int j = Integer.parseInt(comboCodigo.getSelectedItem().toString());
            artV.setArtId(j);
            artV.setCantidad(c);
            artV.setPrecio(precioArt);
            
            subtotal+=precioArt * c;
            total=subtotal;
                tablaArt.setModel(model);
                //tabla.setModel(model);
                textSubtotal.setText(String.valueOf(Math.floor(subtotal * 100) / 100));
                textTotal.setText(String.valueOf(Math.floor(total * 100) / 100));
                textPrecio.setText("");
                textCantidad.setText("");
                //btnFacturar.setEnabled(true);
        }else{JOptionPane.showMessageDialog(null,"Ingresa una cantidad valida");}
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    public void msjTicket(){
        String s="";
        for(int i=0;i<tablaArt.getRowCount();i++){
            s+=tablaArt.getValueAt(i, 1)+"\t\t "+tablaArt.getValueAt(i, 2)+"\t\t "+tablaArt.getValueAt(i, 3)+"\n";
        }
        JOptionPane.showMessageDialog(this, "*****Autopartes Arcca S.A de C.V*****\n\nFolio: "+
                folioVenta+"  \t\t Fecha: "+textFecha.getText()+
                "\nAtendido por:  -"+nombreVendedor+"\n\n"+
                "Producto\t\t  cantidad \t\t precio \n"+s+"Subtotal: "+textSubtotal.getText()+"  \tTotal: "+textTotal.getText()+
                "\nRecibido: "+textPago.getText()+"  \t\tCambio: "+textCambio.getText()
                );
    }
    
    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        // TODO add your handling code here:
       limpiarCampos();
       editarV();
       folioVenta = 0;
       precioArt = 0.0;
        subtotal = 0.0;
        total = 0.0;
        pago = 0.0;
        cambio = 0.0;
        folioVenta = generarFolio();
        textFolioVenta.setText(folioVenta+"");
        textVendedor.setText(nombreVendedor);
        textFecha.setText(fecha());
        
        
    }//GEN-LAST:event_btnNuevaActionPerformed

    private void textFolioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFolioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFolioVentaActionPerformed

    private void textSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSubtotalActionPerformed

    private void textTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTotalActionPerformed

    private void textPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPagoActionPerformed

    private void textCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCambioActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        //tabla = tablaArt;
        Object [][] data = new Object [tablaArt.getRowCount()][tablaArt.getColumnCount()];
        for(int x = 0;x<tablaArt.getRowCount();x++){
            for(int j =0;j<tablaArt.getColumnCount(); j++){
                    data[x][j]=tablaArt.getValueAt(x, j)+"";
            }
        }
        /*Object[][] datos = {
            {"12","llanta","dos","500"},
            {"13","llanta2","dos2","5002"},
            {"14","llanta3","dos3","5003"}
        };*/
        
        String columns[] = {"folio","producto","cantidad","precio"};
        DefaultTableModel dtm= new DefaultTableModel(data,columns);
        //DefaultTableModel dtm =(DefaultTableModel) tablaArt.getModel();
        tabla = new JTable(dtm);
        //tabla = tablaArt;
        auxTotal = total;
        
        cobrar();
        msjTicket();
        limpiarCampos();
        initPanel();
        btnFacturar.setEnabled(true);
        btnTerminar.setEnabled(true);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        folioVenta = 0;
       precioArt = 0.0;
        subtotal = 0.0;
        total = 0.0;
        pago = 0.0;
        cambio = 0.0;
        folioVenta = generarFolio();
        
        List <ArtVenta> array = avjc.findArtVentaEntities();
        try{
            int aux = Integer.parseInt(textFolioVenta.getText());
            for(int x = 0; x<array.size();x++){
                if(array.get(x).getVentaId() == aux){
                    avjc.destroy(array.get(x).getArtVId());
                }
            }
            JOptionPane.showMessageDialog(null,"Cancelado");
        }catch(NumberFormatException | NonexistentEntityException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        limpiarCampos();
        initPanel();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public String fecha(){
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        return anio+"-"+mes+"-"+dia;
    }
    
    private void comboCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCodigoActionPerformed
        // TODO add your handling code here:
        String claveaBuscar=null;
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
        }
    }//GEN-LAST:event_comboCodigoActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        //PanelGenerarFactura pf = new PanelGenerarFactura(total,idUsuarioLogin,tabla);
        //pf.setVisible(true);
        FrameFactura ff = new FrameFactura(auxTotal,idUsuarioLogin,tabla,folioVenta);
        ff.setVisible(true);
        btnFacturar.setEnabled(false);
    }//GEN-LAST:event_btnFacturarActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        limpiarCampos();
        initPanel();
        btnAceptar.setEnabled(false);
        btnFacturar.setEnabled(false);
    }//GEN-LAST:event_btnTerminarActionPerformed

    private int generarFolio(){
       return 2500+vjc.getVentaCount()+1;
    }
    
    private void cobrar(){
        System.out.println("Entrando");
       Double cPago = Double.parseDouble(textPago.getText());
         System.out.println("model");
         if(cPago>=total){
              model=(DefaultTableModel)tablaArt.getModel();
        cambio=cPago-total;
         System.out.println("dando cambioD");
        textCambio.setText(String.valueOf(Math.floor(cambio * 100) / 100));
         System.out.println("seteando cambio");
         
         int i = Integer.parseInt(textFolioVenta.getText().toString());
        Venta v=new Venta(i);
         System.out.println("creando venta");
        v.setVendedor(idUsuarioLogin);
        System.out.println("creando empleado");
        Calendar fecha = new GregorianCalendar();
        //fecha.set(2004,1,7);
        v.setFecha(fecha.getTime());
         System.out.println("creando fecha");
     
             
        try {
            vjc.create(v);
             System.out.println("creando venta");
            //imprimeTicket();
             System.out.println("imprime ticket");
            //
             System.out.println("nueva venta");
        }catch (Exception ex) {
           // Logger.getLogger(IVenta.class.getName()).log(Level.SEVERE, null, ex);
        }}else{
              JOptionPane.showMessageDialog(null,"Ingrese un monto mayor o igual al total de la compra");
         }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JComboBox<String> comboCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelCamposRelleno;
    private javax.swing.JTable tablaArt;
    private javax.swing.JTextField textArticulo;
    private javax.swing.JTextField textCambio;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textFolioVenta;
    private javax.swing.JTextField textPago;
    private javax.swing.JTextField textPrecio;
    private javax.swing.JTextField textSubtotal;
    private javax.swing.JTextField textTotal;
    private javax.swing.JTextField textVendedor;
    // End of variables declaration//GEN-END:variables
}
