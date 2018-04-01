/*
 */
package vistas;

import controladores.FacturaJpaController;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Factura;

/**
 *
 * @author ISCO
 */
public class PanelGenerarFactura extends javax.swing.JPanel {

    private String rutaLogo;
    private String rutaSalida;
    private String nombreEmisor;
    private String razonSocial;
    private String rfcEmisor;
    private String domicilio;
    private String nombreReceptor;
    private String apellidosReceptor;
    private String rfcReceptor;
    private String direccionReceptor;
    private String telefonoReceptor;
    
    private int numeroFactura=0;
    private double total;
    private int vendedor;
    
    private EntityManagerFactory emf;
    private FacturaJpaController fjc;
    Factura f;
    
    private JTable tabla;
    
    public PanelGenerarFactura(Double tot, int vende, JTable t) {
        initComponents();
        setVisible(true);
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        emf=Persistence.createEntityManagerFactory("mx.edu.itoaxaca.Sistema_AutopartesPU");
        fjc= new FacturaJpaController(emf);
        
        rutaLogo = "C:\\Users\\ISCO\\Documents\\NetBeansProjects\\mx.edu.itoaxaca.Sistema_Autopartes\\logotienda.png";
        rutaSalida = "C:\\Users\\ISCO\\Desktop\\PDF Arcca\\"+getNumFactura()+".pdf";
        nombreEmisor = "Tienda de Autopartes";
        razonSocial = "ARCCA Autopartes, poder en cada Parte";
        rfcEmisor = "AAA010101AAA";
        domicilio = "Aldama # 903 Col. Centro OAXACA, MEXICO";
        total = tot;
        vendedor = vende;
        tabla = t;
        
        initBtn();
    }
    public int getNumFactura(){
        numeroFactura = 1500+fjc.getFacturaCount()+1;
        return numeroFactura;
    }
    public void initBtn(){
        btnVer.setEnabled(false);
    }

    /**
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Base = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textApellidos = new javax.swing.JTextField();
        textDireccion = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        textRFC = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Datos del Cliente");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Nombre ");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Direccion");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Telefono");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("RFC");

        textNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        textApellidos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        textDireccion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        textTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        textRFC.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        btnAceptar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("Guardar en:");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("C:\\Users\\ISCO\\Desktop\\PDF Arcca");

        btnCancelar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Salir.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnVer.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ver.jpg"))); // NOI18N
        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BaseLayout = new javax.swing.GroupLayout(Base);
        Base.setLayout(BaseLayout);
        BaseLayout.setHorizontalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BaseLayout.createSequentialGroup()
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BaseLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BaseLayout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BaseLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BaseLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(BaseLayout.createSequentialGroup()
                                    .addComponent(btnCancelar)
                                    .addGap(38, 38, 38)
                                    .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(BaseLayout.createSequentialGroup()
                                    .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textNombre)
                                        .addComponent(textApellidos)
                                        .addComponent(textDireccion)
                                        .addComponent(textTelefono)
                                        .addComponent(textRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(BaseLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnAceptar)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        BaseLayout.setVerticalGroup(
            BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
                    .addComponent(btnVer))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:

        try {
            String url = rutaSalida;
            ProcessBuilder p = new ProcessBuilder();
            p.command("cmd.exe","/c",url);
            p.start();
        } catch (IOException ex) {
            Logger.getLogger(PanelGenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        nombreReceptor = "";
        textNombre.setText("");
        apellidosReceptor = "";
        textApellidos.setText("");
        rfcReceptor = "";
        textRFC.setText("");
        direccionReceptor = "";
        textDireccion.setText("");
        telefonoReceptor = "";
        textTelefono.setText("");
        //textPDF.setText("");
        initBtn();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        nombreReceptor = textNombre.getText();
        apellidosReceptor = textApellidos.getText();
        rfcReceptor = textRFC.getText();
        direccionReceptor = textDireccion.getText();
        telefonoReceptor = textTelefono.getText();

        if(rfcReceptor.length()==11){
            try {
                System.out.println(numeroFactura);
                f = new Factura(numeroFactura);
                f.setCNombre(nombreEmisor);
                f.setFPago("efectivo");
                Calendar fecha = new GregorianCalendar();
                f.setFecha(fecha.getTime());
                f.setCNombre(nombreReceptor);
                f.setCApellidos(apellidosReceptor);
                f.setCDireccion(direccionReceptor);
                f.setCTelefono(telefonoReceptor);
                f.setTotal(total);
                f.setVendedor(vendedor);

                fjc.create(f);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Datos Erroneos Factura Cancelada");
            }
        }

        String header = razonSocial+" \n factura No: "+numeroFactura +" \nFecha: "+fecha()+ "\nTelefono: Tel.  951 135 40 48\n"
        +"Lugar de Expedicion"+domicilio
        +"\n_______________________________________________________________________________";

        String info = " DATOS DEL CLIENTE\n"+"Nombre : "+nombreReceptor+"\nApellidos : "+apellidosReceptor+"\n"
        +"RFC : "+rfcReceptor+"\nDomicilio : "+direccionReceptor+"\nTelefono : "+telefonoReceptor+"\n"+
        "------------------------------------------------------------------------------------------------------------";

        String footer = "\n\n\n\n\n-----------------Esta es una expedicion de Factura valida para cualquier efecto fiscal------------------";

        GenerarPDF gPDF = new GenerarPDF();
        gPDF.generarPDF(header, info, footer,tabla, rutaLogo, rutaSalida,total);

        /*-----------------------------------------*/
        btnVer.setEnabled(true);
    }//GEN-LAST:event_btnAceptarActionPerformed

    public String fecha(){
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        return dia+"/"+mes+"/"+anio;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textApellidos;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textRFC;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}
