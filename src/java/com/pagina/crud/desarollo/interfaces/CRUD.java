
package com.pagina.crud.desarollo.interfaces;

import com.pagina.crud.desarrollo.models.Persona;
import java.util.List;

public interface CRUD {
    
    public List mostrarPersonas();
    public Persona mostrarPersona(int id);
    public boolean insertarPersona(Persona per);
    public boolean actualizarPersona(Persona per);
    public boolean eliminarPersona(int id);
}
