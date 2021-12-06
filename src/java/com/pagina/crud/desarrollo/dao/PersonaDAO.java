
package com.pagina.crud.desarrollo.dao;

import com.pagina.crud.desarollo.interfaces.CRUD;
import com.pagina.crud.desarrollo.config.Conexion;
import com.pagina.crud.desarrollo.models.Persona;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

   

   
 
  
    
    
}
