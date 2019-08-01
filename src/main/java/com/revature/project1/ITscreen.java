
package com.revature.project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ITscreen extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ITscreen</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ITscreen at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
       String user=request.getParameter("username");
       validate valid=new validate();
       List<String>ticket=new ArrayList<>();
       ticket=valid.getalltickets();
       PrintWriter out= response.getWriter();
       out.println("<!DOCTYPE html>");
       out.println("<html>");
        out.println("<head>");
        out.println("<title>IT Ticket Archive</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Current Tickets</h1>");
        out.println("<table border=\"1\">");
        out.println("<form action=\"modticket\" method=\"post\">");
        for (int i = 0; i < ticket.size(); i++) {
            String s=ticket.get(i);
            String [] ss=s.split(":");
            String x=ss[1];
            String [] sss=x.split("\\s+");
            String index=sss[0];          
         out.println("<tr>");
        out.println("<td>" + ticket.get(i) +"<button name=\"edit\" type=\"submit\" value="+index+">Edit</button></td>");
    out.println("</tr>");
        }      
       out.println("</table>");
  out.println("</form");
          out.println("<form action=\"logout\" method=\"post\">\n" +           
"        <input type=\"submit\" value=\"LogOut\" />\n" +
"        </form>");      
        out.println("</body>");
        out.println("</html>");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request,response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
