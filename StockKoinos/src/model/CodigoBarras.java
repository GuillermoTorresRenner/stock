package model;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guille
 */
public class CodigoBarras { 
    
    public void dameArchivoCodigoBarras(String path,String codigo){
       
        try {
            Document doc=new Document();
            PdfWriter pdf=PdfWriter.getInstance(doc,new FileOutputStream(path));
            doc.open();
            Barcode128 code=new Barcode128();
            code.setCode(codigo);
            Image img=code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            doc.add(img);
            doc.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodigoBarras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CodigoBarras.class.getName()).log(Level.SEVERE, null, ex);
        }
      
}
    
    public Icon dameimagenCodigoBarras(String codigo,JLabel lblCodigo)  {
       
       Icon icono=null;
        try {
            
            Barcode128 code=new Barcode128();
            code.setCode(codigo);
            java.awt.Image img=code.createAwtImage(Color.BLACK, Color.white);
            ImageIcon imageIcon= new ImageIcon(img);
            icono =new ImageIcon(imageIcon.getImage().getScaledInstance(lblCodigo.getWidth()/2, lblCodigo.getHeight()/2, java.awt.Image.SCALE_AREA_AVERAGING));
            
            
        } catch (Exception ex) {
            Logger.getLogger(CodigoBarras.class.getName()).log(Level.SEVERE, null, ex);
        }
      return icono;
}
}
    
