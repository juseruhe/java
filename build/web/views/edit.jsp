<%@page import="com.pagina.crud.desarrollo.models.Persona"%>
<%@page import="com.pagina.crud.desarrollo.dao.PersonaDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
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
        <h1 class="h1 text-center my-4">Editar Persona </h1>
        </div>
            <div class="col-lg-2"></div>
        </div>
        
        
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
        
                <form  action="Controller" method="post">
                    <div class="input-group mb-3"> 
                        <input type="hidden" name="id" value="<%= p.getId() %>">
                        <label class="input-group-text" for="dni">DNI:</label>
                        <input class="form-control" required type="number" name="dni" id="dni" value="<%= p.getDni() %>">
                    </div>
                    
                    <div class="input-group mb-3"> 
                        <label class="input-group-text" for="nombre">Nombre:</label>
                        <input class="form-control" required type="text" name="nombre" id="nombre" value="<%= p.getNombre() %>">
                    </div>
                    
                    <div class="input-group mb-3"> 
                        <a class="btn btn-secondary form-control mx-4" href="Controller?accion=index"><i class="bi bi-arrow-left"></i>       Volver</a>
                        <button type="submit" name="accion" value="update" class="btn btn-warning form-control mx-4">Actualizar  <i class="bi bi-arrow-repeat"> </i>  </button>
                    </div>
                </form>
            </div>
            <div class="col-lg-2"></div>
        </div>
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>


