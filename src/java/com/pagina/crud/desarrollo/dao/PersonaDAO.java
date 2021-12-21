
package com.pagina.crud.desarrollo.dao;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pagina.crud.desarollo.interfaces.CRUD;
import com.pagina.crud.desarrollo.config.Conexion;
import com.pagina.crud.desarrollo.models.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PersonaDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p = new Persona();
    

    @Override
    public Persona mostrarPersona(int id) {
          String sql = "select * from personas where id="+id;
        
        try{
             con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                 p.setId(rs.getInt("id"));
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));   
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return p;
    }

    @Override
    public boolean insertarPersona(Persona per) {
        String sql = "insert into personas(dni,nombre) values('"+per.getDni()+"','"+per.getNombre()+"')";
       
        try{
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            ps.close();
        }catch(Exception e){
           e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean actualizarPersona(Persona per) {
        String sql = "update personas set dni='"+per.getDni()+"',nombre='"+per.getNombre()+"' where id="+per.getId();
        
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
        
    }

    @Override
    public boolean eliminarPersona(int id) {
        String sql = "delete from personas where id="+id;
        try{
          con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }

    @Override
    public List mostrarPersonas() {
        ArrayList<Persona>lista = new ArrayList<>();
        String sql = "select * from personas";
        
        try{
             con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Persona p = new Persona();
                
                p.setId(rs.getInt("id"));
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));
                
                lista.add(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public boolean exportarPDF() {
      String sql = "select * from personas";
      
      // Reporte
      String encabezado = "Reporte de Personas\n ";
      Date date= new Date();
      Font fuente = new Font(Font.getFamily("ARIAL"),12,Font.BOLD);
      Paragraph linea = new Paragraph(encabezado,fuente);
      Paragraph fecha = new Paragraph(String.valueOf(date+"\n"+"\n"));
      PdfPTable tabla = new PdfPTable(3);
      tabla.setWidthPercentage(100);
      Document documento = new Document(PageSize.A4);
      //Destino del archivo PDF
       String file = "C:\\Users\\SQA\\Documents\\NetBeansProjects\\java\\web\\pdf\\Personas.pdf";
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(file));
        } catch (DocumentException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PdfPCell celda1 = new PdfPCell(new Paragraph("#",FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
        PdfPCell celda2 = new PdfPCell(new Paragraph("DNI",FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
        PdfPCell celda3 = new PdfPCell(new Paragraph("Nombre",FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
        
        documento.open();
        try {
            documento.add(linea);
        } catch (DocumentException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            documento.add(fecha);
        } catch (DocumentException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tabla.addCell(celda1);
        tabla.addCell(celda2);
        tabla.addCell(celda3);
       
       try{
             con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
             tabla.addCell(String.valueOf(rs.getInt("id")));
             tabla.addCell(rs.getString("dni"));
             tabla.addCell(rs.getString("nombre"));
                
            }
            
            documento.add(tabla);
            documento.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }

   

   
 
  
    
    
}
