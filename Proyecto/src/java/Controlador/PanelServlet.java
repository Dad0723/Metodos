/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import unipiloto.proyecto.Panel;
import unipiloto.proyecto.PanelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author DANIEL
 */
public class PanelServlet extends HttpServlet {

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
            
            //captura de datos
            int codigo= Integer.parseInt(request.getParameter("id"));
            String identificacion = request.getParameter("identificacion");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String fe_registro = request.getParameter("fe_registro");
            int idtipo = Integer.parseInt(request.getParameter("tipopanel"));
            String mensaje = request.getParameter("mensaje");
            String ubicacion = request.getParameter("ubicacion");
            String fe_entrada = request.getParameter("fe_entrada");
            String fe_salida = request.getParameter("fe_salida");
            String msg="Error";
            
            int res;
            
            Panel c= new Panel(codigo, identificacion, nombre, apellido, fe_registro, idtipo, nombre, mensaje, ubicacion, fe_entrada, fe_salida);
            PanelDAO panelDao = new PanelDAO();
            
            if(request.getParameter("btnGuardar") != null){
                res = panelDao.insertarPanel(c);
                if(res !=0){
                    msg="Registro agregado";
                }
            }else if(request.getParameter("botonEditar") !=null){
                res = panelDao.modificarPanel(c);
                if(res !=0){
                    msg="Registro modificado";
                }
            
            }else if(request.getParameter("botonEliminar") !=null){
                res = panelDao.eliminarCliente(c);
                if(res !=0){
                    msg="Registro eliminado";
                }
            
            }
            
            
            request.setAttribute("message", msg);
            request.getRequestDispatcher("/registrar.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println("Error "+e.getLocalizedMessage());
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
