/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.ArtPedidoJpaController;
import controladores.ArticuloJpaController;
import controladores.PedidoJpaController;
import controladores.exceptions.NonexistentEntityException;
import java.awt.HeadlessException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ArtPedido;
import modelo.Articulo;
import modelo.Pedido;
import modelo.Venta;

/**
 *
 * @author ISCO
 */
public class PanelPedidos extends javax.swing.JPanel {
    
    private EntityManagerFactory emf;
    private ArticuloJpaController ajc;
    private DefaultComboBoxModel comboModel;
    private Articulo articulo, busqueda;
    private String nombreVendedor ="";
    private int idUsuarioLogin = 0;
    private PedidoJpaController vjc;
    private ArtPedido artP;
    private ArtPedidoJpaController avjc;
    
    private Double precioArt = 0.0;
    private Double subtotal = 0.0;
    private Double total = 0.0;
    private Double pago = 0.0;
    private Double cambio = 0.0;
    private int folioVenta = 0;
    
    DefaultTableModel model;

    /**
     * Creates new form PanelPedidos
     */
    public PanelPedidos(String vendedor, int idUsuarioLogin) {
        nombreVendedor = vendedor;
        this.idUsuarioLogin = idUsuarioLogin;
        initComponents();
        this.setSize(1300,621);
        initPanel();
        
        emf=Persistence.createEntityManagerFactory("mx.edu.itoaxaca.Sistema_AutopartesPU");
        ajc= new ArticuloJpaController(emf);
        vjc= new PedidoJpaController(emf);
        avjc = new ArtPedidoJpaController(emf);
        listaFolio();
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
//        textPago.setEnabled(false);
  //      textCambio.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnCancelar.setEnabled(false);
        textPrecio.setEnabled(false);
        textNombreC.setEnabled(false);
        textTelefonoC.setEnabled(false);
        textDireccionC.setEnabled(false);
    }
    
    public void listaFolio(){
        List <Articulo> array = ajc.findArticuloEntities();
       String [] options = new String[array.size()];
       for(int x = 0; x < array.size(); x++){
           options[x] = array.get(x).getArtId()+"";
       }
       comboCodigo.setModel(new DefaultComboBoxModel(options));
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
//        textPago.setText("");
  //      textCambio.setText("");
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        textPrecio.setText("");
        textNombreC.setText("");
        textTelefonoC.setText("");
        textDireccionC.setText("");
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
//        textPago.setEnabled(true);
  //      textCambio.setEnabled(true);
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        textPrecio.setEnabled(true);
        textPrecio.setEditable(false);
   //     textCambio.setEditable(false);
     //   textPago.setToolTipText("ingresa el monto del pago");
        textNombreC.setEnabled(true);
        textTelefonoC.setEnabled(true);
        textDireccionC.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textPrecio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        comboCodigo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        textArticulo = new javax.swing.JTextField();
        textFecha = new javax.swing.JTextField();
        btnNueva = new javax.swing.JButton();
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
        jLabel2 = new javax.swing.JLabel();
        textSubtotal = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        textNombreC = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        textTelefonoC = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        textDireccionC = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Total");

        textTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTotalActionPerformed(evt);
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

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("Precio");

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
        btnNueva.setText("Nuevo Pedido");
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Vendedor");

        tablaArt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaArt);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Folio de Pedido");

        textFolioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFolioVentaActionPerformed(evt);
            }
        });

        panelCamposRelleno.setBackground(new java.awt.Color(102, 255, 102));

        btnAgregar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAgregar.setText("Agregar Pedido");
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
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Subtotal");

        textSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSubtotalActionPerformed(evt);
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

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel18.setText("Datos del Cliente");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel19.setText("Nombre");

        textNombreC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreCActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel20.setText("Telefono");

        textTelefonoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTelefonoCActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel21.setText("Direccion");

        textDireccionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDireccionCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textTelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCamposRelleno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFolioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(btnNueva)))
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(67, 67, 67))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(430, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFolioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(panelCamposRelleno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(125, 125, 125)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(479, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTotalActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        cobrar();
        msjTicket();
        limpiarCampos();
        initPanel();

    }//GEN-LAST:event_btnAceptarActionPerformed

    private int generarFolio(){
       return 1500+vjc.getPedidoCount()+1;
    }
    
    private void cobrar(){
        System.out.println("Entrando");
//       Double cPago = Double.parseDouble(textPago.getText());
         System.out.println("model");
         if(total > 0){
              model=(DefaultTableModel)tablaArt.getModel();
        //cambio=cPago-total;
         System.out.println("dando cambioD");
        //textCambio.setText(String.valueOf(Math.floor(cambio * 100) / 100));
         System.out.println("seteando cambio");
         
         int i = Integer.parseInt(textFolioVenta.getText().toString());
        Pedido v=new Pedido(i);
         System.out.println("creando venta");
        v.setVendedor(idUsuarioLogin);
        System.out.println("creando empleado");
        Calendar fecha = new GregorianCalendar();
        //fecha.set(2004,1,7);
        v.setFecha(fecha.getTime());
         System.out.println("creando fecha");
        v.setCNombre(textNombreC.getText());
        v.setCTelefono(textTelefonoC.getText());
        v.setCDireccion(textDireccionC.getText());
        v.setTotal(total);
             
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
              JOptionPane.showMessageDialog(null,"Pedido rechazado");
         }
    }
    
    public String fecha(){
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        return dia+"/"+mes+"/"+anio;
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String encabezado[]={"Codigo","Articulo","Cantidad","Precio"};
        //model=new DefaultTableModel(encabezado,0);
        model=(DefaultTableModel)tablaArt.getModel();

        int c = Integer.parseInt(textCantidad.getText());

        if(c > 0){
            String[] rowData={comboCodigo.getSelectedItem().toString(),textArticulo.getText(),textCantidad.getText(),String.valueOf(precioArt)};
            model.addRow(rowData);

            artP= new ArtPedido();
            int i = Integer.parseInt(textFolioVenta.getText().toString());
            artP.setPedId(i);
            int j = Integer.parseInt(comboCodigo.getSelectedItem().toString());
            artP.setArtId(j);
            artP.setCantidad(c);
            artP.setPrecio(precioArt);

            subtotal+=precioArt * c;
            total+=subtotal;
            tablaArt.setModel(model);
            textSubtotal.setText(String.valueOf(Math.floor(subtotal * 100) / 100));
            textTotal.setText(String.valueOf(Math.floor(total * 100) / 100));
            textPrecio.setText("");
            textCantidad.setText("");
        }else{JOptionPane.showMessageDialog(null,"Ingresa una cantidad valida");}

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void textSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSubtotalActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        List <ArtPedido> array = avjc.findArtPedidoEntities();
        try{
            int aux = Integer.parseInt(textFolioVenta.getText());
            for(int x = 0; x<array.size();x++){
                if(array.get(x).getPedId() == aux){ 
                    avjc.destroy(array.get(x).getArtPId());
                }
            }
            JOptionPane.showMessageDialog(null,"Cancelado");
        }catch(NumberFormatException | NonexistentEntityException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        limpiarCampos();
        initPanel();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void msjTicket(){
        String s="";
        for(int i=0;i<tablaArt.getRowCount();i++){
            s+=tablaArt.getValueAt(i, 1)+"\t\t "+tablaArt.getValueAt(i, 2)+"\t\t "+tablaArt.getValueAt(i, 3)+"\n";
        }
        JOptionPane.showMessageDialog(this, "*****Autopartes Arcca S.A de C.V*****\n\nFolio: "+
                folioVenta+"  \t\t Fecha: "+textFecha.getText()+
                "\nAtendido por:  -"+nombreVendedor+"\n\n"+
                "Producto\t\t  cantidad \t\t precio \n"+s+"Subtotal: "+textSubtotal.getText()+"  \tTotal: "+textTotal.getText()+
                "\n\nDatoCliente \n Nombre "+textNombreC.getText()+"  \t\t Telefono: "+textTelefonoC.getText()+ " \t\t Direccion "+textDireccionC.getText()
                );
    }
    
    private void textNombreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreCActionPerformed

    private void textTelefonoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTelefonoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelefonoCActionPerformed

    private void textDireccionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDireccionCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDireccionCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JComboBox<String> comboCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelCamposRelleno;
    private javax.swing.JTable tablaArt;
    private javax.swing.JTextField textArticulo;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textDireccionC;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textFolioVenta;
    private javax.swing.JTextField textNombreC;
    private javax.swing.JTextField textPrecio;
    private javax.swing.JTextField textSubtotal;
    private javax.swing.JTextField textTelefonoC;
    private javax.swing.JTextField textTotal;
    private javax.swing.JTextField textVendedor;
    // End of variables declaration//GEN-END:variables
}
