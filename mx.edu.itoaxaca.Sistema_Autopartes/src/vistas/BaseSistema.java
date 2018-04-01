/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.UsuarioJpaController;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author ISCO
 */
public class BaseSistema extends javax.swing.JFrame {
    
    boolean estadoLogin = false;
    private EntityManagerFactory emf;
    private UsuarioJpaController ujpc;
    private Usuario usuarioL;
    private int idUsuarioLogin=0;
    private String password = "";
    private String nombreUsL ="";
    private String puestoUsL = "";
    private ImagenL imagenLogo;
    private String nomUsCompleto = "";
    
    /**
     * Creates new form BaseSistema
     */
    PanelArticulos panelArticulos;
    PanelVenta panelVenta;
    PanelPedidos panelPedido;
    PanelUsuario panelUsuario;
    PanelCategorias panelCategorias;
    PanelVerFacturas panelVerFacturas;
    PanelProveedores panelProveedores;
    ArticuloVenta panelArticuloVenta; 
    ArticuloCompra panelArticuloCompra;
    ArticuloPedido panelArticuloPedido;
    
public class Imagen extends javax.swing.JPanel {
String nombre="";

    public Imagen(String nom) {
        nombre = nom;
        this.setSize(192, 194); //se selecciona el tamaño del panel
    }
    //Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
    Dimension height = getSize();
    //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
    ImageIcon Img = new ImageIcon(getClass().getResource("/recursos/"+nombre)); 
    //se dibuja la imagen que tenemos en el paquete recursos //dentro de un panel
    grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
    setOpaque(false);
    super.paintComponent(grafico);
    }
}
public class ImagenL extends javax.swing.JPanel {
String nombre="";

    public ImagenL(String nom) {
        nombre = nom;
        this.setSize(556, 380); //se selecciona el tamaño del panel
    }
    //Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
    Dimension height = getSize();
    //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
    ImageIcon Img = new ImageIcon(getClass().getResource("/recursos/"+nombre)); 
    //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
    grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
    setOpaque(false);
    super.paintComponent(grafico);
    }
}

public void login(){
        btnUsSalir1.setEnabled(false);
        panelP.setEnabled(false);
        panelArticulosBase.setEnabled(false);
        panelVentaBase.setEnabled(false);
        panelPedidoBase.setEnabled(false);
        panelFacturaBase.setEnabled(false);
        panelCompraBase.setEnabled(false);
        panelProvBase.setEnabled(false);
        panelCategoriBase.setEnabled(false);
        panelArticulosBase.setEnabled(false);
        panelUsuarioBase.setEnabled(false);
        panelArticulosBase.setVisible(false);
        
            labelLogin1.setEnabled(true);
            msjLogin.setEnabled(true);
            campoIdLogin.setEnabled(true);
            labelLogin2.setEnabled(true);
            campoPasswordLogin.setEnabled(true);
            btnAceptarLogin.setEnabled(true);
}
public void loginAceptado(){
        cargaModuloArticulos();
        cargaModuloUsuario();
        cargaModuloCategorias();
        cargaModuloVerFacturas();
        cargaModuloProveedor();
        
        panelP.setEnabled(true);
        nombreUsL = usuarioL.getNombres();
        puestoUsL = usuarioL.getCargo();
        nomUsCompleto = usuarioL.getNombres()+" "+usuarioL.getApP();
        cargaModuloVenta();
        cargaModuloPedido();
        cargaVerVentas();
        cargaVerCompras();
        cargaVerPedidos();
    
    if(puestoUsL.equals("administrador")){
        panelArticulosBase.setEnabled(true);
        panelVentaBase.setEnabled(true);
        panelPedidoBase.setEnabled(true);
        panelFacturaBase.setEnabled(true);
        panelCompraBase.setEnabled(true);
        panelProvBase.setEnabled(true);
        panelCategoriBase.setEnabled(true);
        panelUsuarioBase.setEnabled(true);
    }
    if(puestoUsL.equals("vendedor")){
        panelArticulosBase.setEnabled(true);
        panelVentaBase.setEnabled(true);
        panelPedidoBase.setEnabled(true);
        panelFacturaBase.setEnabled(true);
    }
        
        labelUsPuesto2.setText(puestoUsL);
        labelUsnombre2.setText(nombreUsL);
}
    
    public void initControladores(){
        //controlador para usuarios
        emf = Persistence.createEntityManagerFactory("mx.edu.itoaxaca.Sistema_AutopartesPU");
        ujpc = new UsuarioJpaController(emf);
        //
    }
    
    public BaseSistema() {
        initComponents();
        initControladores();
        login();
        ////////
    }
    
    /**********************************modulos***************************************/
    
    public void cargaModuloArticulos(){
            panelArticulos = new PanelArticulos(usuarioL.getCargo());
            panelMovilArticulos.add(panelArticulos);
            panelMovilArticulos.repaint();
    }
    
    public void cargaModuloVenta(){
        panelVenta = new PanelVenta(nomUsCompleto,idUsuarioLogin);
        panelVentaBase.add(panelVenta);
        panelVentaBase.repaint();
    }
    
    public void cargaModuloPedido(){
        panelPedido = new PanelPedidos(nomUsCompleto,idUsuarioLogin);
        panelPedidoBase.add(panelPedido);
        panelPedidoBase.repaint();
    }
    
    public void cargaModuloUsuario(){
        panelUsuario = new PanelUsuario(usuarioL.getCargo());
        panelUsuarioBase.add(panelUsuario);
        panelUsuarioBase.repaint();
    }
    
    public void cargaModuloCategorias(){
        panelCategorias = new PanelCategorias(usuarioL.getCargo());
        panelCategoriBase.add(panelCategorias);
        panelCategoriBase.repaint();
    }
    
    public void cargaModuloVerFacturas(){
        panelVerFacturas = new PanelVerFacturas(usuarioL.getCargo());
        panelFacturaBase.add(panelVerFacturas);
        panelFacturaBase.repaint();
    }
    
    public void cargaModuloProveedor(){
        panelProveedores = new PanelProveedores(usuarioL.getCargo());
        panelProvBase.add(panelProveedores);
        panelProvBase.repaint();
    }
    
    public void cargaVerVentas(){
        panelArticuloVenta = new ArticuloVenta(usuarioL.getCargo());
        panelVerVentasBase.add(panelArticuloVenta);
        panelVerVentasBase.repaint();
    }
    
    public void cargaVerCompras(){
        panelArticuloCompra = new ArticuloCompra(usuarioL.getCargo());
        panelVerComprasBase.add(panelArticuloCompra);
        panelVerComprasBase.repaint();
    }
    
    public void cargaVerPedidos(){
        panelArticuloPedido = new ArticuloPedido(usuarioL.getCargo());
        panelVerPedidosBase.add(panelArticuloPedido);
        panelVerPedidosBase.repaint();
    }
    
    
    /**********************************************************************************/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelP = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        panelHomeBase = new javax.swing.JPanel();
        panelLogo = new javax.swing.JPanel();
        msjLogin = new javax.swing.JLabel();
        labelLogin1 = new javax.swing.JLabel();
        campoIdLogin = new javax.swing.JTextField();
        labelLogin2 = new javax.swing.JLabel();
        btnAceptarLogin = new javax.swing.JButton();
        labelAlertaLogin = new javax.swing.JLabel();
        campoPasswordLogin = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        labelUsPuesto2 = new javax.swing.JLabel();
        labelUsnombre2 = new javax.swing.JLabel();
        btnUsSalir1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        panelArticulosBase = new javax.swing.JPanel();
        panelMovilArticulos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panelVentaBase = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        panelPedidoBase = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        panelFacturaBase = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelCompraBase = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        panelProvBase = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        panelCategoriBase = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        panelUsuarioBase = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        panelVerVentasBase = new javax.swing.JPanel();
        panelVerComprasBase = new javax.swing.JPanel();
        panelVerPedidosBase = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelP.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        panelLogo.setBackground(new java.awt.Color(255, 255, 255));

        msjLogin.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        msjLogin.setText("Para iniciar sesion ingrese los datos correspondientes");

        labelLogin1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        labelLogin1.setText("Identificador Unico :");

        labelLogin2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        labelLogin2.setText("Contraseña :");

        btnAceptarLogin.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAceptarLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Ingresar.png"))); // NOI18N
        btnAceptarLogin.setText("Aceptar");
        btnAceptarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarLoginActionPerformed(evt);
            }
        });

        labelAlertaLogin.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        labelAlertaLogin.setForeground(new java.awt.Color(255, 0, 0));
        labelAlertaLogin.setText("-");

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(msjLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelAlertaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelLogoLayout.createSequentialGroup()
                                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelLogin2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelLogin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(43, 43, 43)
                                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoIdLogin)
                                    .addComponent(campoPasswordLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))))
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(btnAceptarLogin)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(msjLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoIdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(labelAlertaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Arcca -> Home");

        jLabel5.setFont(new java.awt.Font("Castellar", 2, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Autopartes Arcca");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelUsPuesto2.setBackground(new java.awt.Color(204, 204, 255));
        labelUsPuesto2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        labelUsPuesto2.setText("Puesto :");

        labelUsnombre2.setText("nombre");

        btnUsSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Salir.png"))); // NOI18N
        btnUsSalir1.setText("Salir");
        btnUsSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsSalir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelUsPuesto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelUsnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsSalir1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsPuesto2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Tienda de Autopartes Arcca S.A de C.V.");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Sucursal no 1 ");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Aldama # 903 colonia centro");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Tel.  951 135 40 48");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setText("mail:  arccaAutopartes@gmail.com");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addGap(47, 47, 47)
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        Imagen i = new Imagen("login_manager.png");
        jPanel3.add(i);
        jPanel3.repaint();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Bienvenidos");

        javax.swing.GroupLayout panelHomeBaseLayout = new javax.swing.GroupLayout(panelHomeBase);
        panelHomeBase.setLayout(panelHomeBaseLayout);
        panelHomeBaseLayout.setHorizontalGroup(
            panelHomeBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeBaseLayout.createSequentialGroup()
                .addGroup(panelHomeBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHomeBaseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(315, 315, 315)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelHomeBaseLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(panelHomeBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeBaseLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addGap(77, 77, 77)
                        .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addGroup(panelHomeBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );
        panelHomeBaseLayout.setVerticalGroup(
            panelHomeBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHomeBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHomeBaseLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelHomeBaseLayout.createSequentialGroup()
                        .addGroup(panelHomeBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelHomeBaseLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelHomeBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelHomeBaseLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelHomeBaseLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHomeBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHomeBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelP.addTab("Home", jPanel2);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Arcca -> ARTICULOS");

        javax.swing.GroupLayout panelMovilArticulosLayout = new javax.swing.GroupLayout(panelMovilArticulos);
        panelMovilArticulos.setLayout(panelMovilArticulosLayout);
        panelMovilArticulosLayout.setHorizontalGroup(
            panelMovilArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovilArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(1396, Short.MAX_VALUE))
        );
        panelMovilArticulosLayout.setVerticalGroup(
            panelMovilArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovilArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(593, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelArticulosBaseLayout = new javax.swing.GroupLayout(panelArticulosBase);
        panelArticulosBase.setLayout(panelArticulosBaseLayout);
        panelArticulosBaseLayout.setHorizontalGroup(
            panelArticulosBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMovilArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelArticulosBaseLayout.setVerticalGroup(
            panelArticulosBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMovilArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelP.addTab("Articulos", panelArticulosBase);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Arcca -> VENTA");

        javax.swing.GroupLayout panelVentaBaseLayout = new javax.swing.GroupLayout(panelVentaBase);
        panelVentaBase.setLayout(panelVentaBaseLayout);
        panelVentaBaseLayout.setHorizontalGroup(
            panelVentaBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentaBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(1427, Short.MAX_VALUE))
        );
        panelVentaBaseLayout.setVerticalGroup(
            panelVentaBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentaBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(593, Short.MAX_VALUE))
        );

        panelP.addTab("Venta", panelVentaBase);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Arcca -> PEDIDO");

        javax.swing.GroupLayout panelPedidoBaseLayout = new javax.swing.GroupLayout(panelPedidoBase);
        panelPedidoBase.setLayout(panelPedidoBaseLayout);
        panelPedidoBaseLayout.setHorizontalGroup(
            panelPedidoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidoBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(1419, Short.MAX_VALUE))
        );
        panelPedidoBaseLayout.setVerticalGroup(
            panelPedidoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidoBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(593, Short.MAX_VALUE))
        );

        panelP.addTab("Pedido", panelPedidoBase);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Arcca -> FACTURA");

        javax.swing.GroupLayout panelFacturaBaseLayout = new javax.swing.GroupLayout(panelFacturaBase);
        panelFacturaBase.setLayout(panelFacturaBaseLayout);
        panelFacturaBaseLayout.setHorizontalGroup(
            panelFacturaBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFacturaBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(1410, Short.MAX_VALUE))
        );
        panelFacturaBaseLayout.setVerticalGroup(
            panelFacturaBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFacturaBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(593, Short.MAX_VALUE))
        );

        panelP.addTab("Factura", panelFacturaBase);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Arcca -> COMPRA");

        javax.swing.GroupLayout panelCompraBaseLayout = new javax.swing.GroupLayout(panelCompraBase);
        panelCompraBase.setLayout(panelCompraBaseLayout);
        panelCompraBaseLayout.setHorizontalGroup(
            panelCompraBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompraBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(1412, Short.MAX_VALUE))
        );
        panelCompraBaseLayout.setVerticalGroup(
            panelCompraBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompraBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(593, Short.MAX_VALUE))
        );

        panelP.addTab("Compra", panelCompraBase);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Arcca -> PROVEEDOR");

        javax.swing.GroupLayout panelProvBaseLayout = new javax.swing.GroupLayout(panelProvBase);
        panelProvBase.setLayout(panelProvBaseLayout);
        panelProvBaseLayout.setHorizontalGroup(
            panelProvBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProvBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(1391, Short.MAX_VALUE))
        );
        panelProvBaseLayout.setVerticalGroup(
            panelProvBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProvBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(593, Short.MAX_VALUE))
        );

        panelP.addTab("Proveedor", panelProvBase);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Arcca -> CATEGORIA");

        javax.swing.GroupLayout panelCategoriBaseLayout = new javax.swing.GroupLayout(panelCategoriBase);
        panelCategoriBase.setLayout(panelCategoriBaseLayout);
        panelCategoriBaseLayout.setHorizontalGroup(
            panelCategoriBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(1395, Short.MAX_VALUE))
        );
        panelCategoriBaseLayout.setVerticalGroup(
            panelCategoriBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCategoriBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(593, Short.MAX_VALUE))
        );

        panelP.addTab("Categoria", panelCategoriBase);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Arcca -> USUARIO");

        javax.swing.GroupLayout panelUsuarioBaseLayout = new javax.swing.GroupLayout(panelUsuarioBase);
        panelUsuarioBase.setLayout(panelUsuarioBaseLayout);
        panelUsuarioBaseLayout.setHorizontalGroup(
            panelUsuarioBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(1410, Short.MAX_VALUE))
        );
        panelUsuarioBaseLayout.setVerticalGroup(
            panelUsuarioBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(593, Short.MAX_VALUE))
        );

        panelP.addTab("Usuario", panelUsuarioBase);

        javax.swing.GroupLayout panelVerVentasBaseLayout = new javax.swing.GroupLayout(panelVerVentasBase);
        panelVerVentasBase.setLayout(panelVerVentasBaseLayout);
        panelVerVentasBaseLayout.setHorizontalGroup(
            panelVerVentasBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        panelVerVentasBaseLayout.setVerticalGroup(
            panelVerVentasBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        panelP.addTab("Ventas", panelVerVentasBase);

        javax.swing.GroupLayout panelVerComprasBaseLayout = new javax.swing.GroupLayout(panelVerComprasBase);
        panelVerComprasBase.setLayout(panelVerComprasBaseLayout);
        panelVerComprasBaseLayout.setHorizontalGroup(
            panelVerComprasBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        panelVerComprasBaseLayout.setVerticalGroup(
            panelVerComprasBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        panelP.addTab("Compras", panelVerComprasBase);

        javax.swing.GroupLayout panelVerPedidosBaseLayout = new javax.swing.GroupLayout(panelVerPedidosBase);
        panelVerPedidosBase.setLayout(panelVerPedidosBaseLayout);
        panelVerPedidosBaseLayout.setHorizontalGroup(
            panelVerPedidosBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        panelVerPedidosBaseLayout.setVerticalGroup(
            panelVerPedidosBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        panelP.addTab("Pedidos", panelVerPedidosBase);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelP)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelP)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsSalir1ActionPerformed
        // TODO add your handling code here:
        login();
        idUsuarioLogin=0;
        password = "";
        nombreUsL ="";
        puestoUsL = "";
        labelUsPuesto2.setText("");
        labelUsnombre2.setText("");
        campoIdLogin.setText("");
        campoPasswordLogin.setText("");
        labelAlertaLogin.setText("");
        panelLogo.remove(imagenLogo);
        usuarioL = null;
        panelMovilArticulos.remove(panelArticulos);
    }//GEN-LAST:event_btnUsSalir1ActionPerformed

    private void btnAceptarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarLoginActionPerformed
        // TODO add your handling code here:
        try{
            idUsuarioLogin = Integer.parseInt(campoIdLogin.getText().toString());
            password = campoPasswordLogin.getText().toString();
            System.out.println("id "+idUsuarioLogin+" pas "+password);
            usuarioL = ujpc.findUsuario(idUsuarioLogin);
            System.out.println("llega qui");
            int id = usuarioL.getUsId();
            String pas = usuarioL.getContrasena();
            
            if(id ==idUsuarioLogin){
                if(password.equals(pas)){
                    estadoLogin = true;
                }
            }

        }catch(Exception e){
            labelAlertaLogin.setText("EL identificador o contraseña incorrectos");
            
        }

        if(estadoLogin==false){
            //login();
            campoIdLogin.setText("");
            campoPasswordLogin.setText("");
            labelAlertaLogin.setText("EL identificador o contraseña incorrectos");

        }else{
            loginAceptado();
            btnUsSalir1.setEnabled(true);
            
            labelLogin1.setEnabled(false);
            msjLogin.setEnabled(false);
            campoIdLogin.setEnabled(false);
            labelLogin2.setEnabled(false);
            campoPasswordLogin.setEnabled(false);
            btnAceptarLogin.setEnabled(false);
            
            imagenLogo = new ImagenL("logotienda.png");
            panelLogo.add(imagenLogo);
            panelLogo.repaint();
        }
    }//GEN-LAST:event_btnAceptarLoginActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(BaseSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaseSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaseSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaseSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaseSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarLogin;
    private javax.swing.JButton btnUsSalir1;
    private javax.swing.JTextField campoIdLogin;
    private javax.swing.JPasswordField campoPasswordLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelAlertaLogin;
    private javax.swing.JLabel labelLogin1;
    private javax.swing.JLabel labelLogin2;
    private javax.swing.JLabel labelUsPuesto2;
    private javax.swing.JLabel labelUsnombre2;
    private javax.swing.JLabel msjLogin;
    private javax.swing.JPanel panelArticulosBase;
    private javax.swing.JPanel panelCategoriBase;
    private javax.swing.JPanel panelCompraBase;
    private javax.swing.JPanel panelFacturaBase;
    private javax.swing.JPanel panelHomeBase;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPanel panelMovilArticulos;
    private javax.swing.JTabbedPane panelP;
    private javax.swing.JPanel panelPedidoBase;
    private javax.swing.JPanel panelProvBase;
    private javax.swing.JPanel panelUsuarioBase;
    private javax.swing.JPanel panelVentaBase;
    private javax.swing.JPanel panelVerComprasBase;
    private javax.swing.JPanel panelVerPedidosBase;
    private javax.swing.JPanel panelVerVentasBase;
    // End of variables declaration//GEN-END:variables
}
