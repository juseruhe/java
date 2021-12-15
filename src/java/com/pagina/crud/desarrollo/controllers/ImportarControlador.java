/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagina.crud.desarrollo.controllers;

import com.mysql.jdbc.Connection;
import com.pagina.crud.desarrollo.config.Conexion;
import com.pagina.crud.desarrollo.models.read;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author SQA
 */
public class ImportarControlador extends HttpServlet {
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
            out.println("<title>Servlet ImportarControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ImportarControlador at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
        
      
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
        
        if(accion.equalsIgnoreCase("importar")){
          try
        {
            String file = request.getParameter("archivo");

            String fileName1=""+file+"";

            ArrayList dataHolder = read.readExcelFile(fileName1);

            Conexion cn = new Conexion();
           Connection con;
           con= cn.getConnection();
            System.out.println("Connection :"+con);
            @SuppressWarnings("unused")
            Statement sql_statement = con.createStatement();
            String jdbc_insert_sql = "INSERT INTO personas"
                    + "(dni,nombre) VALUES"
                    + "(?,?)";

            PreparedStatement ps = con.prepareStatement(jdbc_insert_sql);
            int count=0;

            ArrayList cellStoreArrayList=null;
            for(int i=1;i<dataHolder.size();i++)
            {
                cellStoreArrayList=(ArrayList)dataHolder.get(i);
                ps.setString(1,((HSSFCell)cellStoreArrayList.get(0)).toString());
                ps.setString(2,((HSSFCell)cellStoreArrayList.get(1)).toString());
               // ps.setString(3,((HSSFCell)cellStoreArrayList.get(2)).toString());
                count= ps.executeUpdate();
            }
            if(count>0)
            {
                for (int j=1;j < dataHolder.size(); j++)
                {
                    cellStoreArrayList=(ArrayList)dataHolder.get(j);
                    System.out.println(((HSSFCell)cellStoreArrayList.get(0)).toString());
                    System.out.println(((HSSFCell)cellStoreArrayList.get(1)).toString());
                    //System.out.println(((HSSFCell)cellStoreArrayList.get(2)).toString());
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
      
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
