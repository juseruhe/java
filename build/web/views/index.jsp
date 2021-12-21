
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
                <!-- Mensajes Según sea el caso de la información -->
                <%
                    if(request.getAttribute("mensaje")=="Se ha importado los datos con éxito"){
             %>
             <div class="alert alert-success" role="alert"><i class="bi bi-check-circle"> </i>
                     <%= request.getAttribute("mensaje") %> 
                 <button type="button" class="btn btn-close" data-bs-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
             </div>
        
<%
}
         %>
         
        <h1 class="h1 text-center my-4">Lista de  Personas</h1>
        </div>
            <div class="col-lg-2"></div>
        </div>
        
        
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                 <a class="my-4  btn btn-success " href="Controller?accion=create"> Nueva Persona  <i class="bi bi-plus-circle"></i></a>
                 <a class="my-4  btn btn-success " href="Controller?accion=exportar"> Exportar Personas Excel  <i class="bi bi-file-excel-fill"></i></a> 
                <form method="post" action="views/importar.jsp" enctype="multipart/form-data">
                     <input type="file" name="archivo" required class="my-4 btn btn-success">
                     <button type="submit"   class="btn btn-success" > <i class="bi bi-file-excel-fill"></i> <i class="bi bi-upload"></i> Importar Personas Excel </button>
                 </form>
                 <a class="my-4 btn btn-success" href="Controller?accion=exportarPDF"> Exportar Personas <i class="bi bi-file-pdf"> </i> </a>
                <table class="table table-info">
                    <thead>
                        <tr>
                            <th> # </th>
                            <th>DNI</th>
                            <th> Nombre </th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <% 
                  
                    PersonaDAO dao= new PersonaDAO();
                    List<Persona> personas = dao.mostrarPersonas();
                    
                   Iterator<Persona>iter = personas.iterator();
                   
                    Persona per = null;
                 
                   while(iter.hasNext()){
                       
                       per = iter.next();
                   
                    %>
                    <tbody>
                        <tr>
                            <td><%= per.getId() %></td>
                            <td><%= per.getDni()%></td>
                            <td><%= per.getNombre() %></td>
                            <td>
                                <a href="Controller?accion=show&id=<%= per.getId() %>" class="btn btn-info"> Mostrar  <i class="bi bi-eye"></i></a>
                                <a href="Controller?accion=edit&id=<%= per.getId() %>" class="btn btn-warning"> Editar  <i class="bi bi-pencil-square"></i></a>
                                <a href="Controller?accion=destroy&id=<%= per.getId() %>" class="btn btn-danger"> Eliminar  <i class="bi bi-eraser"></i></a>
                            </td>
                                             </tr>
                    </tbody>
                    <% } %>
                </table>
        </div>
            <div class="col-lg-2"></div>
        </div>
            
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>