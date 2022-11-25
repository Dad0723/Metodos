/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unipiloto.proyecto.UsuarioDAO;

/**
 *
 * @author DANIEL
 */
public class ingresarServlet extends HttpServlet {

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
            
            //captura de datos ingresar
            String cliente = request.getParameter("usuario_entrar");
            String contra = request.getParameter("password_entrar");
            
            String msg="Error";
            
            String js;
            
            UsuarioDAO userDAO = new UsuarioDAO();
            
            if(request.getParameter("btn_ingress") != null ){
                    js = userDAO.iniciarProyecto(cliente, contra);
                    if(js.equals("administrador")){
                        msg="Bienvenido Administrador";
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("/vistas/administrador.jsp").forward(request, response);
                        return;
                    }else if(js.equals("cliente")){
                        msg="Bienvenido Cliente";
                        request.setAttribute("message", msg);
                        request.getRequestDispatcher("/vistas/clientes.jsp").forward(request, response);
                        return;
                    }else{
                        msg="Datos Incorrectos";
                    }
                        
                    
            }
            
            request.setAttribute("message", msg);
            request.getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
            
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
