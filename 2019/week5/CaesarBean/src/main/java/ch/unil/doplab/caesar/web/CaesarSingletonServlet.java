/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.caesar.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import ch.unil.doplab.caesar.ejb.CaesarSingletonBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author garbi
 */

public class CaesarSingletonServlet extends HttpServlet {

    @EJB
    CaesarSingletonBean caesar;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String key_check = request.getParameter("key");
            
            if (key_check != null){
                out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Caesar Singleton Ciphering – Output</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CaesarServlet at " + request.getContextPath() + "</h1>");

            String output = "";
            String input = "hello";
            String action = request.getParameter("action");
            
            int key = Integer.parseInt(request.getParameter("key"));
            caesar.setKey(key);

            out.println("input   = " + input + "<br>");
            out.println("key     = " + key + "<br>");
            out.println("action  = " + action + "<br>");

            if (action.equals("encode")) {
                output = this.caesar.getEncodedMessage();

            } else if (action.equals("decode")) {
                output = this.caesar.getDecodedMessage();
            } else {
                output = action + " is unknown!";
            }

            out.println("---------------<br>");

            out.println("output = " + output + "<br>");

            out.println("---------------<br>");

            out.println("</body>");
            out.println("</html>");
                
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("/indexSingleton.html");
                rd.forward(request, response);
                
            }
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
