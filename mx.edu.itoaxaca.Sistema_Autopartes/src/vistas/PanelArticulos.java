
package vistas;

import controladores.ArticuloJpaController;
import controladores.CategoriaJpaController;
import controladores.ProveedorJpaController;
import controladores.exceptions.NonexistentEntityException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Articulo;
import modelo.Categoria;
import modelo.Proveedor;

/**
 *
 * @author ISCO
 */
public class PanelArticulos extends javax.swing.JPanel {
    
    private EntityManagerFactory emf;
    private ArticuloJpaController ajc;
    private DefaultComboBoxModel comboModel;
    private Articulo articulo, busqueda;
    private CategoriaJpaController cjc;
    private ProveedorJpaController pjc;
    int indSelec = 1;
    Imagen imagen;
    String src = "";
    /**
     * Creates new form PanelArticulos
     */
    public PanelArticulos(String cargo) {
        initComponents();
        this.setSize(1300,621);
        setSeguridad(cargo);
        
        emf = Persistence.createEntityManagerFactory("mx.edu.itoaxaca.Sistema_AutopartesPU");
        ajc = new ArticuloJpaController(emf);
        cjc = new CategoriaJpaController(emf);
        pjc = new ProveedorJpaController(emf);
        listarDatos();
        
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
public class Imagen extends javax.swing.JPanel {
String nombre="";

    public Imagen(String nom) {
        nombre = nom;
        this.setSize(200, 202); //se selecciona el tamaño del panel
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
    
    public void listarDatos(){
        String encabezado[]={"Codigo","Nombre","modelo","Existencia","Precio","Marca","Categoria","Imagen","Disponible","proveedor"};
        DefaultTableModel modelo=new DefaultTableModel(encabezado,0);
        
        tablaArt.setModel(new DefaultTableModel());
         List <Articulo> array=ajc.findArticuloEntities();
         
         for(int x=0;x<array.size();x++){
              int id = array.get(x).getArtId();
              String nom = array.get(x).getNombre();
              String mod = array.get(x).getModelo();
              String des = array.get(x).getDescripcion();
              int exis = array.get(x).getExistencia();
              double precio = array.get(x).getPrecio();
              String marca = array.get(x).getMarca();
              int cat = array.get(x).getCategoria();
              String srcI = array.get(x).getSrcimagen();
              String estado  = array.get(x).getEstado();
              int proveedor = array.get(x).getProv();
             
             Object [] data={id,nom,des,exis,precio,marca,cat,srcI,estado,proveedor};
             modelo.addRow(data);
         }
         
         tablaArt.setModel(modelo);
    }
    
    public void comboCategoria(){
       List <Categoria> array = cjc.findCategoriaEntities();
       String [] options = new String[array.size()];
       for(int x = 0; x < array.size(); x++){
           options[x] = array.get(x).getNombre();
       }
       comboCat1.setModel(new DefaultComboBoxModel(options));
       comboCat2.setModel(new DefaultComboBoxModel(options));
    }
    
    public void comboProv(){
       List <Proveedor> array = pjc.findProveedorEntities();
       String [] options = new String[array.size()];
       for(int x = 0; x < array.size(); x++){
           options[x] = array.get(x).getNombre();
       }
       comboProv.setModel(new DefaultComboBoxModel(options));
    }
    
    public void setSeguridad(String cargo){
        String carg =cargo.toLowerCase();
        if(carg.equals("administrador") ){
            panelCamposRelleno.setVisible(true);
            btnEditar.setVisible(true);
            btnAgregar.setVisible(true);
            btnEliminar.setVisible(true);
            textId.setEditable(true);
            comboCat2.setEditable(true);
            textNom.setEditable(true);
            textMod.setEditable(true);
            textDes.setEditable(true);
            textExi.setEditable(true);
            textPrecio.setEditable(true);
            textMarca.setEditable(true);
            textEstado.setEditable(true);
            comboProv.setEditable(true);
        }
        else{
            //panelCamposRelleno.setVisible(false);
            btnEditar.setVisible(false);
            btnAgregar.setVisible(false);
            btnEliminar.setVisible(false);
            textId.setEditable(false);
            comboCat2.setEditable(false);
            textNom.setEditable(false);
            textMod.setEditable(false);
            textDes.setEditable(false);
            textExi.setEditable(false);
            textPrecio.setEditable(false);
            textMarca.setEditable(false);
            textEstado.setEditable(false);
            comboProv.setEditable(false);
        }
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelImg = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        comboCat1 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArt = new javax.swing.JTable();
        campoidBuscar = new javax.swing.JTextField();
        btnOkBuscar = new javax.swing.JButton();
        panelCamposRelleno = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        textExi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textPrecio = new javax.swing.JTextField();
        textNom = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textMarca = new javax.swing.JTextField();
        textMod = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textDes = new javax.swing.JTextField();
        comboCat2 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnAgregarImg = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        textEstado = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        comboProv = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Buscar Articulo por : ");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Codigo");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Nombre");

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton1.setText("OK");

        panelImg.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelImgLayout = new javax.swing.GroupLayout(panelImg);
        panelImg.setLayout(panelImgLayout);
        panelImgLayout.setHorizontalGroup(
            panelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panelImgLayout.setVerticalGroup(
            panelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Categoria :");

        comboCat1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comboCat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

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

        btnOkBuscar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnOkBuscar.setText("OK");
        btnOkBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkBuscarActionPerformed(evt);
            }
        });

        panelCamposRelleno.setBackground(new java.awt.Color(153, 255, 255));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("Codigo ");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel9.setText("Existencia");

        textId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIdActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("Nombre");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setText("Precio");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel12.setText("Marca");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("Modelo");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Categoria");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel10.setText("Descripcion");

        comboCat2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comboCat2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setText("Imagen");

        btnAgregarImg.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregarImg.setText("Seleccionar");
        btnAgregarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImgActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel15.setText("Disponible");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setText("Proveedor");

        comboProv.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        comboProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEditar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/editar.png"))); // NOI18N
        btnEditar.setText("Editar Articulo");
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAgregar.setText("Agregar Articulo");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminar1.png"))); // NOI18N
        btnEliminar.setText("Eliminar Articulo");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCamposRellenoLayout = new javax.swing.GroupLayout(panelCamposRelleno);
        panelCamposRelleno.setLayout(panelCamposRellenoLayout);
        panelCamposRellenoLayout.setHorizontalGroup(
            panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCamposRellenoLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textNom, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textMod, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(textDes, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                        .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(textExi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(btnEditar)
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(btnAgregar))
                                    .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                                                .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnEliminar)
                                                    .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(comboCat2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel16)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboProv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(43, 43, 43)))
                .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarImg, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelCamposRellenoLayout.setVerticalGroup(
            panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposRellenoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNom, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMod, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textExi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCat2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboProv, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(panelCamposRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel5.setText("Imagen Actual");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoidBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOkBuscar)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(comboCat1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119))
                    .addComponent(panelCamposRelleno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(panelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCat1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoidBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOkBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCamposRelleno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(panelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIdActionPerformed

    private void btnAgregarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImgActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int seleccion=fc.showOpenDialog(this);
        
        if(seleccion==JFileChooser.APPROVE_OPTION){
 
            //Seleccionamos el fichero
            File fichero=fc.getSelectedFile();
            String ruta = fichero.getAbsolutePath();
            src = fichero.getName();
            File copia = new File("C:\\Users\\ISCO\\Documents\\NetBeansProjects\\mx.edu.itoaxaca.Sistema_Autopartes\\src\\recursos\\"+fichero.getName());
            try {
                copiarPegarArchivo(fichero, copia);
                
            } catch (IOException ex) {
                Logger.getLogger(PanelArticulos.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }//GEN-LAST:event_btnAgregarImgActionPerformed

  public void limpiarCampos(){
                textId.setEditable(false);
                textId.setToolTipText("Este campo no se debe editar");
                src = "nofoto.jpg";
                panelImg.removeAll();
                imagen = new Imagen("nofoto.jpg");
                panelImg.add(imagen);
                panelImg.repaint();
                comboCat1.setSelectedIndex(0);
                textId.setText("");
                textNom.setText("");
                textMod.setText("");
                textDes.setText("");
                textExi.setText("");
                textPrecio.setText("");
                textMarca.setText("");
                comboCat2.setSelectedIndex(0);
                textEstado.setText("");
                comboProv.setSelectedIndex(0);
                btnEditar.setEnabled(false);
                btnEliminar.setEnabled(false);
    }
    
    private void btnOkBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkBuscarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        comboCategoria();
        comboProv();
        String claveaBuscar = null;
        int aux = 0;
        try{
            claveaBuscar=campoidBuscar.getText();
            aux = Integer.parseInt(claveaBuscar);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ingresa un código valido");
        }
        
        if(claveaBuscar!=null){
            busqueda = ajc.findArticulo(aux);
            if(busqueda!=null){
                campoidBuscar.setEnabled(true);
                campoidBuscar.setText(busqueda.getArtId()+"");
                
                indSelec = busqueda.getCategoria()-1;
                comboCat1.setSelectedIndex(indSelec);
                textId.setText(busqueda.getArtId()+"");
                textNom.setText(busqueda.getNombre());
                textMod.setText(busqueda.getModelo());
                textDes.setText(busqueda.getDescripcion());
                textExi.setText(busqueda.getExistencia()+"");
                textPrecio.setText(busqueda.getPrecio()+"");
                textMarca.setText(busqueda.getMarca());
                comboCat2.setSelectedIndex(indSelec);
                textEstado.setText(busqueda.getEstado());
                indSelec = busqueda.getProv()-1;
                comboProv.setSelectedIndex(indSelec);
                String image = busqueda.getSrcimagen();
                src = image;
                panelImg.removeAll();
                if(image.length()<1){image = "nofoto.jpg";}
                imagen = new Imagen(image);
                panelImg.add(imagen);
                panelImg.repaint();
                
                btnEditar.setEnabled(true);
                btnEliminar.setEnabled(true);
            }else JOptionPane.showMessageDialog(null,"No existe Articulo con ese código");
        }
    }//GEN-LAST:event_btnOkBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        articulo = new Articulo();
        try{
            articulo.setCategoria(comboCat2.getSelectedIndex()+1);
            articulo.setNombre(textNom.getText());
            articulo.setModelo(textMod.getText());
            articulo.setDescripcion(textDes.getText());
            articulo.setExistencia(Integer.parseInt(textExi.getText()));
            articulo.setPrecio(Double.parseDouble(textPrecio.getText()));
            articulo.setMarca(textMarca.getText());
            articulo.setSrcimagen(src);
            articulo.setEstado(textEstado.getText());
            articulo.setProv(comboProv.getSelectedIndex()+1);
        }catch(Exception e){JOptionPane.showInputDialog(null,"error");}
        
        try{
            ajc.create(articulo);
             listarDatos();
             limpiarCampos();
            JOptionPane.showMessageDialog(null,"Articulo Agregado");
            }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
            }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try{
            ajc.destroy(Integer.parseInt(campoidBuscar.getText()));
            JOptionPane.showMessageDialog(null,"Articulo Eliminado");
            listarDatos();
            limpiarCampos();
        }catch(NumberFormatException | NonexistentEntityException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        textId.setEditable(true);
        articulo = new Articulo(Integer.parseInt(campoidBuscar.getText()));
        articulo.setArtId(Integer.parseInt(textId.getText()));
        articulo.setCategoria(comboCat2.getSelectedIndex()+1);
        articulo.setNombre(textNom.getText());
        articulo.setModelo(textMod.getText());
        articulo.setDescripcion(textDes.getText());
        articulo.setExistencia(Integer.parseInt(textExi.getText()));
        articulo.setPrecio(Double.parseDouble(textPrecio.getText()));
        articulo.setMarca(textMarca.getText());
        articulo.setSrcimagen(src);
        articulo.setEstado(textEstado.getText());
        articulo.setProv(comboProv.getSelectedIndex()+1);
        try{
            ajc.edit(articulo);
            JOptionPane.showMessageDialog(null,"Cambios realizados exitosamente");
            listarDatos();
            limpiarCampos();
            
        }catch(Exception e){ JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
                                e.printStackTrace();}
        
    }//GEN-LAST:event_btnEditarActionPerformed

    public void copiarPegarArchivo(File src, File dst) throws IOException {
	try {
 
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst);
 
		byte[] b = new byte[1024];
		int l;
		while((l = in.read(b)) >0){
			out.write(b, 0, l);
		}
                in.close();
                out.close();
 
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
} 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarImg;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnOkBuscar;
    private javax.swing.JTextField campoidBuscar;
    private javax.swing.JComboBox<String> comboCat1;
    private javax.swing.JComboBox<String> comboCat2;
    private javax.swing.JComboBox<String> comboProv;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panelCamposRelleno;
    private javax.swing.JPanel panelImg;
    private javax.swing.JTable tablaArt;
    private javax.swing.JTextField textDes;
    private javax.swing.JTextField textEstado;
    private javax.swing.JTextField textExi;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textMarca;
    private javax.swing.JTextField textMod;
    private javax.swing.JTextField textNom;
    private javax.swing.JTextField textPrecio;
    // End of variables declaration//GEN-END:variables
}
