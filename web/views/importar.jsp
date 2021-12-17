<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
     <%@page import="java.sql.*" %>
    <%@ page import ="java.util.Date" %>  
    <%@ page import ="java.io.*" %>  
    <%@ page import ="java.io.FileNotFoundException" %>  
    <%@ page import ="java.io.IOException" %>  
    <%@ page import ="java.util.Iterator" %>  
    <%@ page import ="java.util.ArrayList" %> 
    <%@ page import="org.apache.poi.xssf.usermodel.*" %>
    <%@ page import ="org.apache.poi.hssf.usermodel.HSSFCell" %>  
    <%@ page import ="org.apache.poi.hssf.usermodel.HSSFRow" %>  
    <%@ page import ="org.apache.poi.hssf.usermodel.HSSFSheet" %>  
    <%@ page import ="org.apache.poi.hssf.usermodel.HSSFWorkbook" %>  
    <%@ page import ="org.apache.poi.poifs.filesystem.POIFSFileSystem" %>
    <%@ page import="org.apache.poi.ss.usermodel.Cell" %>
    <%@ page import ="org.apache.poi.ss.usermodel.Row"%>
    <%@ page import="org.apache.poi.ss.usermodel.Sheet" %>
    <%@ page import="org.apache.poi.ss.usermodel.Workbook" %>
    <%@ page import ="org.apache.poi.xssf.usermodel.XSSFWorkbook" %>
    <%@ page import="com.oreilly.servlet.MultipartRequest" %>
     <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    </head>
    <body>
    <%

    ArrayList cellArrayListHolder = new ArrayList (); 

    try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/java","root","");
        String Path="upload";
        String absolutepath=getServletContext().getRealPath(Path);
        System.out.println(absolutepath);
        MultipartRequest   mr=new MultipartRequest(request,absolutepath);
        String filename=mr.getOriginalFileName("archivo");
        FileInputStream myinput = new FileInputStream(new File(absolutepath+"/"+filename));
        Workbook workbook = new XSSFWorkbook(myinput);
        /*Create a workbook using myfilesystem  */
        /* Get the first sheet from workbook */
         Sheet firstSheet = workbook.getSheetAt(0);
        /*We need to something to iterate through the cell  */
        Iterator<Row> iterator = firstSheet.iterator();
        while (iterator.hasNext()) 
        {
            XSSFRow nextRow =(XSSFRow)iterator.next();
            ArrayList rowarrylist=new ArrayList();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

             while (cellIterator.hasNext()) {
                 XSSFCell cell = (XSSFCell)cellIterator.next();
                 rowarrylist.add(cell);    
             }    
             cellArrayListHolder.add(rowarrylist);
             
        }
        out.println(cellArrayListHolder);
        ArrayList rowarrylist=null;
       PreparedStatement st=con.prepareStatement("INSERT INTO  personas(dni,nombre) VALUES(?,?) ");
      
        
        for(int i=1;i<cellArrayListHolder.size();i++)
            
        {   
            
          //  if(i<cellArrayListHolder.size() ){
            
        rowarrylist=(ArrayList)cellArrayListHolder.get(i);
 
           st.setString(1,rowarrylist.get(0).toString());
        st.setString(2,rowarrylist.get(1).toString());                    
     st.execute();
       
        //   }
       
             
                 
                
      //  System.out.println(i);
   
       
         } 
  
}
catch(Exception e)
{
    e.getMessage();
    out.println(e.getMessage());
}
%>
</body>
</html>
