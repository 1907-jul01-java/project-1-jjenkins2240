
package com.revature.project1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


public class modticket extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet modticket</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet modticket at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String index=request.getParameter("edit");
      PrintWriter out=response.getWriter();
      int i=Integer.parseInt(index);
      validate valid=new validate();
      List<String>ticket=new ArrayList<>();
     
      ticket=valid.getticket(i); 
  String s=ticket.get(0);
  String [] o=s.split("\t");
  String [] values= new String[5];
          
       for(int x=0;x<o.length;x++){
           String [] sp=o[x].split(":");
           values[x]=sp[1];
       }
       
     
  
      out.println("<!DOCTYPE html>");
       out.println("<html>");
        out.println("<head>");
        out.println("<title>IT Ticket Archive</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Current Tickets</h1>");
        out.println("<table style=\"width:100%\" border=1>");
        out.println("<tr>"); 
    out.println("<th>Submitted by</th>");
 out.println("<th>Created</th>");
   out.println("<th>Issue</th>");
    out.println("<th>IT Notes</th>");
 out.println("</tr>");
  out.println("<tr>");
   out.println("<td>"+values[1]+"</td>");
   out.println("<td>"+values[2]+"</td>");
     out.println("<td>"+values[3]+"</td>");
     out.println("<td>"+values[4]+"</td>");
 out.println("</tr>");

       out.println("</table>");
       out.println("<br>");
     out.println("<form action=\"Addnotes\" method=\"post\">\n" +
            "<label>Add Notes: </label><input type=\"text\" name=\"notes\"/><br>"+
"        <button name=\"add\" type=\"submit\" value="+index+">Add Notes</button>" +
"        </form>");
     out.println("<br>");
     out.println("<form action=\"Closeticket\" method=\"post\">\n" +       
"        <button name=\"close\" type=\"submit\" value="+index+">Close Ticket</button>" +
"        </form>");
       out.println("</body>");
       out.println("</html>");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
