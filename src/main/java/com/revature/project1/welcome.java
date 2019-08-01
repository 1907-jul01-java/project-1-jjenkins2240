package com.revature.project1;



import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class welcome extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet welcome</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet welcome at " + request.getContextPath() + "</h1>");
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
       ticket=valid.gettickets(user);
       PrintWriter out= response.getWriter();
       out.println("<!DOCTYPE html>");
       out.println("<html>");
        out.println("<head>");
        out.println("<title>IT Ticketing App</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Current Tickets</h1>");
        out.println("<table border=\"1\">");
        
        for (int i = 0; i < ticket.size(); i++) {
         out.println("<tr>");
        out.println("<td>" + ticket.get(i) + "</td>");
    out.println("</tr>");
        }
       out.println("</table>");
        out.println("<button id=\"myButton\" class=\"float-left submit-button\" >Create Ticket</button>\n" +
"\n" +
"<script type=\"text/javascript\">\n" +
"    document.getElementById(\"myButton\").onclick = function () {\n" +
"        location.href = \"/Project1/createticket.html\";\n" +
"    };\n" +
"</script>");
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
