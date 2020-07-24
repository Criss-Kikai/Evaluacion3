/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Producto;
import DAO.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Criss
 */
@WebServlet(name = "ControladorProducto", urlPatterns = {"/ControladorProducto"})
public class ControladorProducto extends HttpServlet {

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
        if(request.getParameter("accion")!=null){
        String accion = request.getParameter("accion");
        switch(accion){
            case "1": registrar(request,response);
                break;
            /*case "2": modificar(request,response);
            break;*/
            case "3": eliminar(request,response);
            break;
        }
         }else{
             response.sendRedirect("index.jsp?msj=Opcion no valida");
         }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            
            String Nombre = request.getParameter("Nombre").trim();
            String Descripcion = request.getParameter("Descripcion").trim();
            int Precio = Integer.parseInt(request.getParameter("Precio").trim());
           
            if(Nombre.equals("") || Descripcion.equals("") || Precio<1){
                response.sendRedirect("index.jsp?msj=Valores incompletos");
            }else{
                ProductoDAO pro = new ProductoDAO();
                Producto p = new Producto(Nombre,Descripcion,Precio);
                 
                
                if(pro.obtenerProducto(p.getNombre())==null){
                    int respuesta = pro.registrarProducto(p);
                    if(respuesta==1){
                    response.sendRedirect("index.jsp?msj=Producto registrado");
                    }else{
                    response.sendRedirect("index.jsp?msj=Producto no se pudo registrar");
                    }
                }else{
                    response.sendRedirect("index.jsp?msj=Producto ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("index.jsp?msj="+e.getMessage());
           }
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            String Nombre = request.getParameter("Nombre").trim();
            String Descripcion = request.getParameter("Descripcion").trim();
            int Precio = Integer.parseInt(request.getParameter("Precio").trim());
           
            if(Nombre.equals("") || Descripcion.equals("") || Precio<1){
                response.sendRedirect("index.jsp?msj=Opcion no valida");
            }else{
                
                ProductoDAO pro = new ProductoDAO();
                Producto p = new Producto(Nombre,Descripcion,Precio);
                
                /*if(pro.obtenerProducto(p.getNombre())==null){
                    int respuesta = pro.;
                    if(jug.existeEquipo(e)){
                        response.sendRedirect("equipos.jsp?msj=No se puede eliminar por tener jugadores asociados");
                    }else{
                    int respuesta = eq.eliminar(e);
                    if(respuesta==1){
                    response.sendRedirect("equipos.jsp?msj=Equipo eliminado");
                    }else{
                    response.sendRedirect("equipos.jsp?msj=Equipo no se pudo eliminar");
                    }}
                }else{
                    response.sendRedirect("equipos.jsp?msj=Equipo no existe");
                }*/
            }
           }catch(Exception e){
               response.sendRedirect("delequipo.jsp?msj="+e.getMessage());
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