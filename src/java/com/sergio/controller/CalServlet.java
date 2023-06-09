package com.sergio.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sergi
 */

@WebServlet(name = "CalcularServlet", urlPatterns = {"/CalcularServlet"})
public class CalServlet extends HttpServlet {


    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
               
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        LocalTime horaActual = LocalTime.now();
        int hora = horaActual.getHour();
        
        if (hora >= 12 && hora < 18) {
            apellido = apellido+ "   , buenas tardes ";
        }else if (hora >= 18 && hora <= 24) {
            apellido= apellido+ "    , buenas noches ";
        }else if(hora >= 0  && hora < 12){
            apellido= apellido+ "    , buenos dias ";
        }

        LocalTime horaHM = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String horahm = horaHM.format(formatter);

        String year = request.getParameter("actual");
        String fechaNacimientoStr = request.getParameter("nacimiento");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        
        int edad = periodo.getYears();
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>WebSergio</title>");
            out.println("<style>");
            out.println("body {");
            out.println("   font-family: Times New Roman, Helvetica, sans-serif;");
            out.println("   text-align: center;");
            out.println("}");
            out.println("h1 {");
            out.println("   font-size: 5em;");
            out.println("   margin-top: 60px;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h2> Hola  " + nombre +"  "+ apellido + "</h2>");                   
            out.println("<h2> Su edad es: "  + edad + " años  </h2>");        
            out.println("<h2>Y la hora actual es : "  + horahm + " </h2>");        
            out.println("<h2> Tenga un buen resto de día </h2"); 
            out.println("</body>");
            out.println("</html>");
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
