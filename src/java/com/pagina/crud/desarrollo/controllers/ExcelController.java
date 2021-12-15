/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagina.crud.desarrollo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.poi.openxml4j.exceptions.ODFNotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author SQA
 */
public class ExcelController extends HttpServlet {
    String index = "views/index.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExcelController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExcelController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String acceso = "";
        String accion = request.getParameter("accion");
       
        Part archivo = request.getPart("archivo");
        
        InputStream is = archivo.getInputStream();
        
        File f = new File("C:/Users/SQA/Documents/NetBeansProjects/java/web/datafiles/"+"personas.xlsx");
        
        FileOutputStream os = new FileOutputStream(f);
        
        int dato = is.read();
        
        while(dato != -1){
            dato = is.read();
        }
        
        os.close();
        is.close();
        
        String excelPath = "C:/Users/SQA/Documents/NetBeansProjects/java/web/datafiles/personasexcel.xlsx";
        
       FileInputStream inputstream = new FileInputStream(excelPath);
        
        XSSFWorkbook workbook =  new XSSFWorkbook(inputstream);
        
        Sheet sheet = workbook.getSheetAt(0);
        
        // ciclos e iteración
        /*
        int rows = sheet.getLastRowNum();
       int cols =  sheet.getRow(1).getLastCellNum();
       
       
       for(int r=0;r<=rows;r++){
          XSSFRow row = (XSSFRow) sheet.getRow(r);
           for(int c=0;c<=cols;c++){
               XSSFCell cell = row.getCell(c);
              switch( cell.getCellType()) {
                  case STRING: System.out.println(cell.getStringCellValue());
                  break;
                  case NUMERIC: System.out.println(cell.getNumericCellValue());
                  break;
                  case BOOLEAN: System.out.println(cell.getBooleanCellValue());
                  
              }
           }
           System.out.println();
       }
       */
        
        
        Iterator iterator = sheet.iterator();
        
        while(iterator.hasNext()){
          XSSFRow row =  (XSSFRow) iterator.next();
          Iterator cellIterator = row.cellIterator();
          while(cellIterator.hasNext()){
            XSSFCell cell =   (XSSFCell) cellIterator.next();
            switch( cell.getCellType()) {
                  case STRING: System.out.println(cell.getStringCellValue());
                  break;
                  case NUMERIC: System.out.println(cell.getNumericCellValue());
                  break;
                  case BOOLEAN: System.out.println(cell.getBooleanCellValue());
                  
              }
            
            System.out.println(" | ");
          }
          
          System.out.println();
        } 
        
        if(accion.equalsIgnoreCase("index")){
            acceso = index;
            
        }
        
           RequestDispatcher vista = request.getRequestDispatcher(acceso);
        
        vista.forward(request, response);
    }

    
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              String acceso = "";
        String accion = request.getParameter("accion");
       
        Part archivo = request.getPart("archivo");
        
        System.out.println(archivo);
        
      
        
        
        
        InputStream is = archivo.getInputStream();
        
        File f = new File("C:/Users/SQA/Documents/NetBeansProjects/java/web/datafiles/"+"personas.xlsx");
        
        FileOutputStream os = new FileOutputStream(f);
        
        int dato = is.read();
        
        while(dato != -1){
            dato = is.read();
        }
        
        os.close();
        is.close();
        
        if(accion.equalsIgnoreCase("importar")){
            acceso = index;
            
        }
        
           RequestDispatcher vista = request.getRequestDispatcher(acceso);
        
        vista.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
