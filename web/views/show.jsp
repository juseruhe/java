
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.pagina.crud.desarrollo.models.Persona"%>
<%@page import="com.pagina.crud.desarrollo.dao.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
   <link rel="stylesheet" href="./css/estilos.css" />
    </head>
    <body>
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
           <% 
                
                PersonaDAO dao = new PersonaDAO();
                
                int id = Integer.parseInt((String)request.getAttribute("idper"));

                Persona p = (Persona) dao.mostrarPersona(id);
                
                %>
                 
        <h1 class="h1 text-center my-4">Datos de <%= p.getNombre()     %></h1>
        </div>
            <div class="col-lg-2"></div>
        </div>
        
        
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                
              
                <table class="table table-info">
                    <thead>
                        <tr>
                            <th> # </th>
                            <th>DNI</th>
                            <th> Nombre </th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <tr>
                            <td><%= p.getId() %></td>
                            <td><%= p.getDni() %></td>
                            <td><%= p.getNombre() %></td>
                   </tr>
                    </tbody>
                   
                </table>
        </div>
                   <div class="col-lg-2"></div>
        </div>
           
                   <div class="row">
                       <div class="col-lg-2 "></div>
                       <div class="col-lg-8">
                           <a href="Controller?accion=index" class="btn btn-secondary form-control"><i class="bi bi-arrow-left"></i>  Volver</a>
                       </div>
                       <div class="col-lg-2"></div>
                   </div>
                   
                    
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>








































































