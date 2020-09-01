/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ch.unil.doplab.bankjpa2.AccountFacadeLocal;
import ch.unil.doplab.bankjpa2.entities.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class insert extends HttpServlet {

    @EJB
    private AccountFacadeLocal theBank;

    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

}
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Banking – Output</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BankServlet at " + request.getContextPath() + "</h1>");

            String operation = request.getParameter("action");
            out.println("---------------<br>");
            out.println("operation  = " + operation + "<br>");
            out.println("---------------<br>");

            
            if (operation.equals("open")) {
                String lastName = request.getParameter("lastname");
                String firstName = request.getParameter("firstname");
                out.println("opening an account for " + firstName + " " + lastName + "<br>");
                Account account = theBank.openAccount(lastName, firstName);
                out.println("account =  " + account + "<br>");

        }
    }
        
    }

}