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
        <h1 class="h1 text-center my-4">Insertar Persona </h1>
        </div>
            <div class="col-lg-2"></div>
        </div>
        
        
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
        
                <form method="post"  action="Controller" >
                    <div class="input-group mb-3"> 
                        <label class="input-group-text" for="dni">DNI:</label>
                        <input class="form-control" required type="number" name="dni" id="dni">
                    </div>
                    
                    <div class="input-group mb-3"> 
                        <label class="input-group-text" for="nombre">Nombre:</label>
                        <input class="form-control" required type="text" name="nombre" id="nombre">
                    </div>
                    
                    <div class="input-group mb-3"> 
                        <a class="btn btn-secondary form-control mx-4" href="Controller?accion=index"><i class="bi bi-arrow-left"></i>       Volver</a>
                        <button type="submit" name="accion" value="store" class="btn btn-success form-control mx-4">Aceptar  <i class="bi bi-check-circle"> </i>  </button>
                    </div>
                </form>
            </div>
            <div class="col-lg-2"></div>
        </div>
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>

