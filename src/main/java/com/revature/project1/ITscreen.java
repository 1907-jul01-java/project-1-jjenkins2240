
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
        out.println("<style>");
        out.println("body {");
   out.println("font-family: \"Open Sans\", sans-serif;");
  out.println("line-height: 1.25;");
  out.println("}");

  out.println("table {");
    out.println("border: 1px solid #ccc;");
    out.println("border-collapse: collapse;");
    out.println("margin: 0;");
    out.println("padding: 0;");
    out.println("width: 100%;");
    out.println("table-layout: fixed;");
  out.println("}");

  out.println("table caption {");
    out.println("font-size: 1.5em;");
    out.println("margin: .5em 0 .75em;");
  out.println("}");

  out.println("table tr {");
    out.println("background-color: #f8f8f8;");
   out.println(" border: 1px solid #ddd;");
    out.println("padding: .35em;");
  out.println("}");

  out.println("table th,");
  out.println("table td {");
    out.println("padding: .625em;");
  out.println("text-align: center;");
out.println("}");

out.println("table th {");
  out.println("font-size: .85em;");
 out.println("letter-spacing: .1em;"); 
  out.println("text-transform: uppercase;");
out.println("}");

out.println("@media screen and (max-width: 600px) {");
 out.println("table {"); 
   out.println("border: 0;"); 
  out.println("}");

 out.println(" table caption {");
    out.println("font-size: 1.3em;");
  out.println("}");
  
  out.println("table thead {");
    out.println("border: none;");
    out.println("clip: rect(0 0 0 0);");
    out.println("height: 1px;");
    out.println("margin: -1px;");
    out.println("overflow: hidden;");
    out.println("padding: 0;");
    out.println("position: absolute;");
    out.println("width: 1px;");
 out.println("}"); 
  
  out.println("table tr {");
    out.println("border-bottom: 3px solid #ddd;");
    out.println("display: block;");
    out.println("margin-bottom: .625em;");
  out.println("}");
  
  out.println("table td {");
   out.println("border-bottom: 1px solid #ddd;");
    out.println("display: block;");
    out.println("font-size: .8em;");
    out.println("text-align: right;");
  out.println("}");
  
  out.println("table td::before {");
    /*
    * aria-label has no advantage, it won't be read inside a table
    content: attr(aria-label);
    */
   out.println("content: attr(data-label);"); 
    out.println("float: left;");
    out.println("font-weight: bold;");
    out.println("text-transform: uppercase;");
 out.println("}"); 
  
  out.println("table td:last-child {");
   out.println("border-bottom: 0;"); 
  out.println("}");

        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
  out.println("<table>"); 
    out.println("<caption>Open Tickets</caption>");
    out.println("<thead>");
      out.println("<tr>");
        out.println("<th scope=\"col\">Ticket ID</th>");
        out.println("<th scope=\"col\">Submitted By</th>");
        out.println("<th scope=\"col\">Created By</th>");
        out.println("<th scope=\"col\">Issue</th>");
        out.println("<th scope=\"col\">IT Notes</th>");
        out.println("<th scope=\"col\"></th>");
      out.println("</tr>");
    out.println("</thead>");
    out.println("<tbody>");
   


        out.println("<form action=\"modticket\" method=\"post\">");
        for (int i = 0; i < ticket.size(); i++) {
            String s=ticket.get(i);
            String [] ss=s.split("\t");
                String in=ss[0];         
                String[]index=in.split(":");
                String sub=ss[1];
                String [] submitted=sub.split(":");
                String cre=ss[2];
                String [] create=cre.split(":");
                String iss=ss[3];
                String [] issue=iss.split(":");
                String not=ss[4];
                String [] notes=not.split(":");
         out.println("<tr>");
      out.println("<td data-label=\"Ticket ID\">"+index[1]+"</td>");
      out.println("<td data-label=\"Submitted By\">"+submitted[1]+"</td>");
     out.println("<td data-label=\"Created By\">"+create[1]+":"+create[2]+":"+create[3]+"</td>"); 
      out.println("<td data-label=\"Issue\">"+issue[1]+"</td>");
     out.println("<td data-label=\"IT Notes\">"+notes[1]+"</td>");
      
             out.println("<td> <button name=\"edit\" type=\"submit\" value="+index[1]+">Edit</button></td>;");
    out.println("</tr>");
        }   out.println("</tbody>");    
       out.println("</table>");
  out.println("</form>");
  
           out.println("<form action=\"logout\" method=\"post\">\n" +
           
"              <input type=\"submit\" value=\"LogOut\" />\n" +
"\n" +
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
