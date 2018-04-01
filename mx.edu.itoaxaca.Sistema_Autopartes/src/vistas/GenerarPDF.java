/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import javax.swing.JOptionPane;

/**
 *
 * @author ISCO
 */
public class GenerarPDF {
    
    private Font fuenteBold = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
    private Font fuenteNormal = new Font(Font.FontFamily.COURIER, 8, Font.NORMAL);
    private Font fuenteItalica = new Font(Font.FontFamily.COURIER, 8, Font.ITALIC);
    PdfPTable table;
    public void generarPDF(String header, String info, String footer,JTable tabla ,String rutaImagen, String salida,Double tot){
        try {
            Document document = new Document(PageSize.A4,36,36,10,10);
            PdfWriter.getInstance(document, new FileOutputStream(salida));
            document.open();
            document.add(getHeader(header));
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(100, 100);
            imagen.setAlignment(Element.ALIGN_CENTER);
            document.add(imagen);
            document.add(getInfo(info));
//
            generaTabla(tabla,tot);
            document.add(table);
            document.add(getInfo2("SUBTOTAL $           "+tot+"            "+"\nTOTAL $            "+tot+"           "));
            document.add(getFooter(footer));
            document.close();
            JOptionPane.showMessageDialog(null,"Factura Creada Correctamente");
            
        } catch (Exception e) {
        }
    }
    
    public void generaTabla(JTable tablaArt, Double tot){
        table = new PdfPTable(tablaArt.getColumnCount());
        String s="";
        table.addCell("Codigo");
        table.addCell("Producto");
        table.addCell("Cantidad");
        table.addCell("Precio");
        System.out.println("primeras celdas");
        String s1,s2,s3,s4;
        for(int i=0;i<tablaArt.getRowCount();i++){

            s1 = tablaArt.getValueAt(i, 0).toString();
            s2 = tablaArt.getValueAt(i, 1).toString();
            s3 = tablaArt.getValueAt(i, 2).toString();
            s4 = tablaArt.getValueAt(i, 3).toString();
            System.out.println(s1+"-"+s2+"-"+s3+"-"+s4);
            table.addCell(s1);
            table.addCell(s2);
            table.addCell(s3);
            table.addCell(s4);
        }
         
    }
    
    private Paragraph getHeader(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteBold);
        p.add(c);
        return p;
    }
    private Paragraph getInfo(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_LEFT);
        c.append(texto);
        c.setFont(fuenteNormal);
        p.add(c);
        return p;
    }
    private Paragraph getInfo2(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_RIGHT);
        c.append(texto);
        c.setFont(fuenteNormal);
        p.add(c);
        return p;
    }
    private Paragraph getFooter(String texto){
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_RIGHT);
        c.append(texto);
        c.setFont(fuenteItalica);
        p.add(c);
        return p;
    }
}
