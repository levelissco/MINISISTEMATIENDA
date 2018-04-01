/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ISCO
 */
public class prueba {
    public static void main(String []agrs){
        Object[][] datos = {
            {"12","llanta","dos","500"},
            {"13","llanta2","dos2","5002"},
            {"14","llanta3","dos3","5003"}
        };
        String columns[] = {"folio","producto","cantidad","precio"};
        DefaultTableModel dtm= new DefaultTableModel(datos,columns);
        
        JTable tabla = new JTable(dtm);
        String header = "Aupartes ARCCA"+" \n factura No: "+1500 +" \nFecha: "+"20/05/2017"+ "\nTelefono: Tel.  951 135 40 48\n" 
                +"Lugar de Expedicion"+" ALMAMA No 903 COL CENTRO"
                +"\n_______________________________________________________________________________";
        
        String info = "DATOS DEL CLIENTE\n"+"Nombre : "+"VICTOR FCO"+"\nApellidos : "+"VASQUEZ CUEEVAS"+"\n"
                +"RFC : "+"123456AFTAQ"+"\nDomicilio : "+"ALDAMA 14 MACUILXOCHITL"+"\nTelefono : "+"9511309134"+"\n"+
                "------------------------------------------------------------------------------------------------------------\n\n";
        
        String footer = "\n\n\n\n------------------------------------------------pie de pagina---------------------------------------";
        
        GenerarPDF gPDF = new GenerarPDF();
        gPDF.generarPDF(header, info, footer,tabla, "C:\\Users\\ISCO\\Documents\\NetBeansProjects\\mx.edu.itoaxaca.Sistema_Autopartes\\logotienda.png","C:\\Users\\ISCO\\Desktop\\PDF Arcca\\PRUEBA.pdf",500.5);
    }
    
}
