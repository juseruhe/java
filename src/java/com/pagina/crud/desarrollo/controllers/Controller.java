
package com.pagina.crud.desarrollo.controllers;

import com.pagina.crud.desarrollo.dao.PersonaDAO;
import com.pagina.crud.desarrollo.models.Persona;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controller extends HttpServlet {
    
    String index = "views/index.jsp";
    String create = "views/create.jsp";
    String show = "views/show.jsp";
    String edit = "views/edit.jsp";
    String exportar = "views/excel.jsp";
    Persona p = new Persona();
    PersonaDAO dao = new PersonaDAO();
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
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
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
    
    // Método GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso = "";
        String accion = request.getParameter("accion");
        
        if(accion.equalsIgnoreCase("index")){
            acceso = index;
            
        }else if (accion.equalsIgnoreCase("create")){
            acceso = create;
        }else if(accion.equalsIgnoreCase("show")){
           request.setAttribute("idper", request.getParameter("id"));
           acceso = show;
        }else if(accion.equalsIgnoreCase("edit")){
            request.setAttribute("idper", request.getParameter("id"));
            acceso = edit;
        }else if(accion.equalsIgnoreCase("destroy")){
          int  id = Integer.parseInt(request.getParameter("id"));
          p.setId(id);
          dao.eliminarPersona(id);
          acceso= index;
        }else if(accion.equalsIgnoreCase("exportar")){
            acceso = exportar;
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
    
    // Método POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String acceso = "";
        String accion = request.getParameter("accion");
        
         if(accion.equalsIgnoreCase("store")){
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            p.setDni(dni);
            p.setNombre(nombre);
           dao.insertarPersona(p);
           acceso = index;
           
         } else if(accion.equalsIgnoreCase("update")){
             int id= Integer.parseInt(request.getParameter("id"));
              String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            p.setId(id);
            p.setDni(dni);
            p.setNombre(nombre);
            dao.actualizarPersona(p);
            request.setAttribute("idper", request.getParameter("id"));
            acceso = show;
        } else if(accion.equalsIgnoreCase("importar")){
            // Crear  
             
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
