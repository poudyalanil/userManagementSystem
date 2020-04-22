/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author goani
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/resister-servlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       try{
             // Data from UI
            String firstName = request.getParameter("fname");
            String middleName = request.getParameter("mname");
            String lastName = request.getParameter("lname");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String password1 = request.getParameter("password1");
            String password2  = request.getParameter("password2");
            
            // User instance
            User user = new User();
            user.setFirst_name(firstName);
            user.setMiddle_name(middleName);
            user.setLast_name(lastName);
            user.setAddress(address);
            user.setEmail(email);
            user.setPassword2(password2);
            
            // passing to database
            JdbcRegisterService.userRegister(user);
          
            response.sendRedirect("userLogin.jsp");
            
        }catch(Exception e){
            
            e.printStackTrace();
        }

     
        
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doGet(request,response);          
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
