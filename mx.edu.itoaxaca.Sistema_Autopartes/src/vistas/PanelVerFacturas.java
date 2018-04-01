
package vistas;

import controladores.FacturaJpaController;
import controladores.UsuarioJpaController;
import controladores.VentaJpaController;
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
import modelo.Factura;
import modelo.Usuario;
import modelo.Venta;


public class PanelVerFacturas extends javax.swing.JPanel {

    private EntityManagerFactory emf;
    private FacturaJpaController fjc;
    private UsuarioJpaController ujc;
    private VentaJpaController vjc;
    private DefaultComboBoxModel comboModel;
    private Factura factura, busqueda;
    
    private int indSelec1 = 0;
    private int indSelec2 = 0;
    
    public PanelVerFacturas(String cargo) {
        initComponents();
        this.setSize(1300,621);
        setSeguridad(cargo);
        
        emf = Persistence.createEntityManagerFactory("mx.edu.itoaxaca.Sistema_AutopartesPU");
        fjc = new FacturaJpaController(emf);
        ujc = new UsuarioJpaController(emf);
        vjc = new VentaJpaController(emf);
        
        initPanel();
        comboVendedor();
        comboVenta();
        listarDatos();
    }
    
    public void initPanel(){
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void setSeguridad(String cargo){
        String carg =cargo.toLowerCase();
        if(carg.equals("administrador") ){
            btnEditar.setVisible(true);
            btnAgregar.setVisible(true);
            btnEliminar.setVisible(true);
            textNombre.setEditable(true);
        }
        else{
            btnEditar.setVisible(false);
            btnAgregar.setVisible(false);
            btnEliminar.setVisible(false);
            textNombre.setEditable(false);
        }
        repaint();
    }
    public void comboVendedor(){
       List <Usuario> array = ujc.findUsuarioEntities();
       String [] options = new String[array.size()];
       for(int x = 0; x < array.size(); x++){
           options[x] = array.get(x).getUsId().toString();
       }
       comboVendedorId.setModel(new DefaultComboBoxModel(options));
    }
    
    public void comboVenta(){
       List <Venta> array = vjc.findVentaEntities();
       String [] options = new String[array.size()];
       for(int x = 0; x < array.size(); x++){
           options[x] = array.get(x).getVentaId().toString();
       }
       comboVentaId.setModel(new DefaultComboBoxModel(options));
    }
    
    public void listarDatos(){
        String encabezado[]={"Folio Factura","Folio Venta","Id Vendedor","Fecha","Total","Nombre","Apellidos","RFC","Direccion","Telefono","FormaPago"};
        DefaultTableModel modelo = new DefaultTableModel(encabezado,0);
        
        tablaCat.setModel(new DefaultTableModel());
         List <Factura> array = fjc.findFacturaEntities();
         
         try {
                    for(int x=0;x<array.size();x++){
                    int id = array.get(x).getFacId();
                    String fecha = array.get(x).getFecha().toString();
                    String total = array.get(x).getTotal().toString();
                    String nom = array.get(x).getCNombre();
                    String fpago = array.get(x).getFPago();
                    String apellido = array.get(x).getCApellidos();
                    String rfc = array.get(x).getCRfc();
                    String dir = array.get(x).getCDireccion();
                    String telefono = array.get(x).getCTelefono();
                    String idVenta = array.get(x).getVentaId().toString();
                    String idVende = array.get(x).getVendedor().toString();
             
             Object [] data={id,idVenta,idVende,fecha,total,nom,apellido,rfc,dir,telefono,fpago};
             modelo.addRow(data);
         }
         
         tablaCat.setModel(modelo);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error desconocido");
        }
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textIdBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        panelCampos = new javax.swing.JPanel();
        textFacturaId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textFecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        textApellidos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textRFC = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textTelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textPago = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        comboVentaId = new javax.swing.JComboBox<>();
        comboVendedorId = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCat = new javax.swing.JTable();
        btnActualiza = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese Id de la Factura");

        textIdBuscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/buscar.jpg"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        panelCampos.setBackground(new java.awt.Color(209, 253, 137));

        textFacturaId.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Factura id");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Venta Id");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Fecha");

        textFecha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        textFecha.setToolTipText("Formato debe ser '2017-05-21'");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Total");

        textTotal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("Id Vendedor");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("Nombre");

        textNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("Apelidos");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText(" Datos del Cliente");

        textApellidos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setText("RFC");

        textRFC.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setText("Direccion");

        textDireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel12.setText("Telefono");

        textTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Pago");

        textPago.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        btnEditar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/editar.png"))); // NOI18N
        btnEditar.setText("Editar Factura");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAgregar.setText("Agregar  Factura");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar1.png"))); // NOI18N
        btnEliminar.setText("Eliminar Factura");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        comboVentaId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboVendedorId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelCamposLayout = new javax.swing.GroupLayout(panelCampos);
        panelCampos.setLayout(panelCamposLayout);
        panelCamposLayout.setHorizontalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFacturaId, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboVentaId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboVendedorId, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCamposLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelCamposLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(btnEditar)))
                                .addGap(18, 18, 18)
                                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCamposLayout.createSequentialGroup()
                                        .addComponent(btnAgregar)
                                        .addGap(56, 56, 56)
                                        .addComponent(btnEliminar))
                                    .addGroup(panelCamposLayout.createSequentialGroup()
                                        .addComponent(textRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel12)
                                        .addGap(36, 36, 36)
                                        .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPago, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelCamposLayout.setVerticalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFacturaId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboVentaId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboVendedorId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(jSeparator3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        tablaCat.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaCat);

        btnActualiza.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnActualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/sync.png"))); // NOI18N
        btnActualiza.setText("Actualizar");
        btnActualiza.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCampos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualiza)
                .addGap(176, 176, 176))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnActualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void limpiarCampos(){
        textFacturaId.setText("");
        textNombre.setText("");
        textApellidos.setText("");
        textFecha.setText("");
        textRFC.setText("");
        textTotal.setText("");
        textDireccion.setText("");
        textTelefono.setText("");
        textPago.setText("");
        comboVendedorId.setSelectedIndex(0);
        comboVentaId.setSelectedIndex(0);
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        limpiarCampos();
        comboVenta();
        comboVendedor();
        
        String claveaBuscar = null;
        int aux = 0;
        try{
            claveaBuscar=textIdBuscar.getText();
            aux = Integer.parseInt(claveaBuscar);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ingresa un código valido");
        }

        if(claveaBuscar!=null){
            busqueda = fjc.findFactura(aux);
            if(busqueda!=null){
                textIdBuscar.setEnabled(true);
                textFacturaId.setText(busqueda.getFacId().toString());
                textNombre.setText(busqueda.getCNombre());
                textApellidos.setText(busqueda.getCApellidos());
                textFecha.setText(busqueda.getFecha().toString());
                textRFC.setText(busqueda.getCRfc());
                textTotal.setText(busqueda.getTotal().toString());
                textDireccion.setText(busqueda.getCDireccion());
                textTelefono.setText(busqueda.getCTelefono());
                textPago.setText(busqueda.getFPago());
                
                String s1,s2 = "";
                for(int i =0; i<comboVentaId.getItemCount();i++){
                    comboVentaId.setSelectedIndex(i);
                    s1 = comboVentaId.getSelectedItem().toString();
                    s2 = busqueda.getVentaId().toString();
                    if(s1.equals(s2)){
                        indSelec1 = i;
                        break;
                    }
                }
                comboVentaId.setSelectedIndex(indSelec1);
                s1 ="";
                s2 = "";
                for(int i =0; i<comboVendedorId.getItemCount();i++){
                    comboVendedorId.setSelectedIndex(i);
                    s1 = comboVendedorId.getSelectedItem().toString();
                    s2 = busqueda.getVendedor().toString();
                    if(s1.equals(s2)){
                        indSelec2 = i;
                        break;
                    }
                }
                comboVendedorId.setSelectedIndex(indSelec2);
                
                btnEditar.setEnabled(true);
                btnEliminar.setEnabled(true);
            }else JOptionPane.showMessageDialog(null,"No existe Factura con ese código");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        try{
            fjc.destroy(Integer.parseInt(textIdBuscar.getText()));
            JOptionPane.showMessageDialog(null,"Registro Eliminado");
            listarDatos();
            limpiarCampos();
            initPanel();
        }catch(NumberFormatException | NonexistentEntityException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        textFacturaId.setEditable(true);
        factura = new Factura(Integer.parseInt(textIdBuscar.getText()));
        factura.setVentaId(Integer.parseInt(comboVentaId.getSelectedItem().toString()));
        factura.setVendedor(Integer.parseInt(comboVendedorId.getSelectedItem().toString()));
        factura.setCNombre(textNombre.getText());
        factura.setCApellidos(textApellidos.getText());
        factura.setCDireccion(textDireccion.getText());
        factura.setCRfc(textRFC.getText());
        factura.setCTelefono(textTelefono.getText());
        factura.setFPago(textPago.getText());
        factura.setTotal(Double.parseDouble(textTotal.getText()));
        Calendar fecha = new GregorianCalendar();
        factura.setFecha(fecha.getTime());
        
        try{
            fjc.edit(factura);
            JOptionPane.showMessageDialog(null,"Cambios realizados exitosamente");
            listarDatos();
            limpiarCampos();
            initPanel();
        }catch(Exception e){ JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
            e.printStackTrace();}

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        factura = new Factura();
        try{
            
            factura = new Factura(Integer.parseInt(textIdBuscar.getText()));
            factura.setVendedor(Integer.parseInt(comboVendedorId.getSelectedItem().toString()));
            factura.setVentaId(Integer.parseInt(comboVentaId.getSelectedItem().toString()));
            factura.setCApellidos(textApellidos.getText());
            factura.setCDireccion(textDireccion.getText());
            factura.setCRfc(textRFC.getText());
            factura.setCTelefono(textTelefono.getText());
            factura.setFPago(textPago.getText());
            Calendar fecha = new GregorianCalendar();
            factura.setFecha(fecha.getTime());
            
        }catch(Exception e){JOptionPane.showInputDialog(null,"error");}

        try{
            fjc.create(factura);
            listarDatos();
            limpiarCampos();
            JOptionPane.showMessageDialog(null,"Factura Agregado");
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizaActionPerformed
        // TODO add your handling code here:
        listarDatos();
    }//GEN-LAST:event_btnActualizaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiza;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboVendedorId;
    private javax.swing.JComboBox<String> comboVentaId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JTable tablaCat;
    private javax.swing.JTextField textApellidos;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textFacturaId;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textIdBuscar;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPago;
    private javax.swing.JTextField textRFC;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField textTotal;
    // End of variables declaration//GEN-END:variables
}
