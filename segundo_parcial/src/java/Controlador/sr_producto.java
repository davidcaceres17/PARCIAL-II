/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Producto;
/**
 *
 * @author justo
 */
@WebServlet(name = "sr_producto", urlPatterns = {"/sr_producto"})
public class sr_producto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Producto prod;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_producto</title>");            
            out.println("</head>");
            out.println("<body>");  
            out.println("<style>"
                    + "body{"
                    + "text-align:center;}"
                    + ".boton{ \n" +
"                text-decoration: none !important;\n" +
"                background: none;\n" +
"                color: #4d2e0c;\n" +
"                padding: 23px 35px 24px 35px !important;\n" +
"                border-radius: 5px;\n" +
"                font-size: 16px;\n" +
"                text-transform: uppercase;\n" +
"                border: 1px solid !important;\n" +
"                width: 15%;\n" +
"                margin: 0 auto;\n" +
"                margin-top: 1%;\n" +
"                font-weight: bold;\n" +
"                margin-bottom: 5%;\n" +
"                background-position: 100% 0;\n" +
"                background-size: 200% 100%;\n" +
"                transition: all .25s ease-in;display:block;\n" +
                    
"            }\n" +
"            .boton:hover{\n" +
"                background-position: 0 0;\n" +
"                background-image: linear-gradient(to left, transparent, transparent 50%, #efab3c 50%, #efab3c);\n" +
"                color: #fff;\n" +
"                border: 1px solid !important;\n" +
"            }.titulo{\n" +
"                text-align: center;\n" +
"                margin-top: 5%;\n" +
"                margin-bottom: 3%;\n" +
"                box-shadow: 0px 7px 12px -9px #222;\n" +
"                padding: 0 0 29px 0;\n" +
"            }"
                    + "</style>");  
            prod = new Producto(request.getParameter("txt_producto"),request.getParameter("txt_descripcion"),0,Integer.valueOf(request.getParameter("txt_pcosto")),Integer.valueOf(request.getParameter("txt_pventa")),Integer.valueOf(request.getParameter("txt_existencia")),Integer.valueOf(request.getParameter("txt_marca")));
            prod.agregar();
                   out.println("<h1 class='titulo'>Ingreso Exitoso</h1>");
                   out.println("<p class='escrito'>Tu producto se ha ingresado correctamente, regresa a la pantalla de inicio para ver tu producto ingresado</p>");
                   out.println("<a class='boton' href='index.jsp'>Regresar</a>");     
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
