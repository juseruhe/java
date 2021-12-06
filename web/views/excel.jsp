<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.pagina.crud.desarrollo.models.Persona"%>
<%@page import="com.pagina.crud.desarrollo.dao.PersonaDAO"%>
<%@ page contentType="application/msexcel" %>
<%
 out.clearBuffer();   
 response.setHeader("Content-Type","application/vnd.ms-excel;charset=UTF-8");   
 response.setHeader("Content-Disposition","attachment;filename=excel.xls");   
%>

   <table >
                    <thead>
                        <tr>
                            <th> # </th>
                            <th>DNI</th>
                            <th> Nombre </th>
                          
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
                           
                                             </tr>
                    </tbody>
                    <% } %>
                </table>