package com.revature.project1;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.*;


public class validate {
    Connection connection;
    public validate(){
        
    }
    public boolean checkUser(String user,String pass) 
     {
      boolean st =false;
      try{String dbName = "jdbc:postgresql://192.168.99.101:5432/postgres";
         String dbDriver = "org.postgresql.Driver";
         String userName = "postgres";
         String password = "postgres"; 

       
         Class.forName(dbDriver);
         this.connection = DriverManager.getConnection(dbName, userName, password);
         PreparedStatement ps =connection.prepareStatement("select * from emp where username=? and password=?");
         ps.setString(1, user);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         if(rs.isBeforeFirst()){
             st=true;
         }
        connection.close();
      }catch(Exception e)
      {
          e.printStackTrace();
      }
 
         return st;                 
  }
    public boolean checkIT(String user, String pass){
        boolean st =false;
      try{String dbName = "jdbc:postgresql://192.168.99.101:5432/postgres";
         String dbDriver = "org.postgresql.Driver";
         String userName = "postgres";
         String password = "postgres"; 

       
         Class.forName(dbDriver);
         this.connection = DriverManager.getConnection(dbName, userName, password);
         PreparedStatement ps =connection.prepareStatement("select * from it where username=? and password=?");
         ps.setString(1, user);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         if(rs.isBeforeFirst()){
             st=true;
         }
        connection.close();
      }catch(Exception e)
      {
          e.printStackTrace();
      }
 
         return st;   
    }
    public List gettickets(String user){
        List ticket=new ArrayList<>();
        try{String dbName = "jdbc:postgresql://192.168.99.101:5432/postgres";
         String dbDriver = "org.postgresql.Driver";
         String userName = "postgres";
         String password = "postgres"; 
         
       
         Class.forName(dbDriver);
         this.connection = DriverManager.getConnection(dbName, userName, password);
         System.out.println("Got Connection"+this.connection);
         PreparedStatement ps =connection.prepareStatement("select * from tickets where username=?");
         ps.setString(1, user);
     
         ResultSet rs =ps.executeQuery();
         while(rs.next()){
             String info="Ticket ID:"+ rs.getString("id")+"\t"+"Submitted by: "+rs.getString("firstname")+" "+rs.getString("lastname")
                     +"\t"+"Created: "+rs.getTimestamp("created")+"\t"+"Issue: "+rs.getString("notes")+"\t"+"IT Team Notes: "+rs.getString("it_notes");
             ticket.add(info);
         }
                 
        connection.close();
        return ticket;
      }catch(Exception e)
      {
          e.printStackTrace();
      }
       return null;
    }
     public List getticket(int id){
        List ticket=new ArrayList<>();
        try{String dbName = "jdbc:postgresql://192.168.99.101:5432/postgres";
         String dbDriver = "org.postgresql.Driver";
         String userName = "postgres";
         String password = "postgres"; 
         
       
         Class.forName(dbDriver);
         this.connection = DriverManager.getConnection(dbName, userName, password);
         System.out.println("Got Connection"+this.connection);
         PreparedStatement ps =connection.prepareStatement("select * from tickets where id=?");
         ps.setInt(1, id);
     
         ResultSet rs =ps.executeQuery();
         while(rs.next()){
             String info="Ticket ID:"+ rs.getString("id")+"\t"+"Submitted by: "+rs.getString("firstname")+" "+rs.getString("lastname")
                     +"\t"+"Created: "+rs.getTimestamp("created")+"\t"+"Issue: "+rs.getString("notes")+"\t"+"IT Team Notes: "+rs.getString("it_notes");
             ticket.add(info);
         }
                 
        connection.close();
        return ticket;
      }catch(Exception e)
      {
          e.printStackTrace();
      }
       return null;
    }
    
    public void addticket(String first, String last, String issue, String user){
          try{String dbName = "jdbc:postgresql://192.168.99.101:5432/postgres";
         String dbDriver = "org.postgresql.Driver";
         String userName = "postgres";
         String password = "postgres"; 
         
       
         Class.forName(dbDriver);
         this.connection = DriverManager.getConnection(dbName, userName, password);
         System.out.println("Got Connection"+this.connection);
         PreparedStatement ps =connection.prepareStatement("Insert into tickets(firstname,lastname,notes,username)values(?,?,?,?)");
         ps.setString(1, first);
         ps.setString(2, last);
         ps.setString(3, issue);
         ps.setString(4, user);
         ps.executeUpdate();
     
                   
        connection.close();
       
      }catch(Exception e)
      {
          e.printStackTrace();
      }
      
    }
    
    public List getalltickets(){
        List<String> tickets=new ArrayList<>();
         try{String dbName = "jdbc:postgresql://192.168.99.101:5432/postgres";
         String dbDriver = "org.postgresql.Driver";
         String userName = "postgres";
         String password = "postgres"; 
         
       
         Class.forName(dbDriver);
         this.connection = DriverManager.getConnection(dbName, userName, password);
         System.out.println("Got Connection"+this.connection);
         PreparedStatement ps =connection.prepareStatement("select * from Tickets");
        
         ResultSet rs= ps.executeQuery();
       while(rs.next()){
             String info="Ticket ID:"+ rs.getString("id")+"\t"+"Submitted by: "+rs.getString("firstname")+" "+rs.getString("lastname")
                     +"\t"+"Created: "+rs.getTimestamp("created")+"\t"+"Issue: "+rs.getString("notes")+"\t"+"IT Team Notes: "+rs.getString("it_notes");
             tickets.add(info);
                   
        
      }connection.close();
       return tickets;}catch(Exception e)
      {
          e.printStackTrace();
      }
      
    return null;
}
    public void notes(String s, int index){
         try{
             String dbName = "jdbc:postgresql://192.168.99.101:5432/postgres";
         
         String dbDriver = "org.postgresql.Driver";
         String userName = "postgres";
         String password = "postgres"; 
         
       
         Class.forName(dbDriver);
         this.connection = DriverManager.getConnection(dbName, userName, password);
         System.out.println("Got Connection"+this.connection);
         PreparedStatement ps =connection.prepareStatement("update tickets set it_notes=? where tickets.id=?");
         ps.setString(1, s);
         ps.setInt(2, index);
         ps.executeUpdate();
    }catch(Exception e)
      {
          e.printStackTrace();
      }
}
    public void closeticket(int index){
          try{
             String dbName = "jdbc:postgresql://192.168.99.101:5432/postgres";
         
         String dbDriver = "org.postgresql.Driver";
         String userName = "postgres";
         String password = "postgres"; 
         
       
         Class.forName(dbDriver);
         this.connection = DriverManager.getConnection(dbName, userName, password);
         System.out.println("Got Connection"+this.connection);
         PreparedStatement ps =connection.prepareStatement("delete from tickets where tickets.id=?");
         ps.setInt(1, index);

         ps.executeUpdate();
    }catch(Exception e)
      {
          e.printStackTrace();
      }
    }
}