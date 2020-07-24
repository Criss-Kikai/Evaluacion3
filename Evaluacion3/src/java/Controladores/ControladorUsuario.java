/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Usuario;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Criss
 */
@WebServlet(name = "ControladorUsuario", urlPatterns = {"/ControladorUsuario"})
public class ControladorUsuario extends HttpServlet {

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
        
        if(request.getParameter("action")!=null){
        String accion = request.getParameter("action");
        switch(accion){
            case "1": iniciarSesion(request,response);
                break;
            case "2": registrar(request,response);
                break;
            default: response.sendRedirect("Login.jsp?msj=Opcion no valida");
        }
        }else{
            response.sendRedirect("Login.jsp?msj=Opcion no valida");
        }
    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
        String RUN = request.getParameter("RUN");
        String PASS = request.getParameter("Contra");
        Usuario usuarioIniciando = new Usuario(RUN,PASS);
        UsuarioDAO ud = new UsuarioDAO();
        Usuario temporal= ud.obtenerUsuario(usuarioIniciando.getRUN());
        if(temporal!=null){
            if(temporal.getContraseña().equals(usuarioIniciando.getContraseña())){
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", temporal);
            
            Cookie co = new Cookie("usuario",temporal.getRUN()+","+temporal.getNombre()+","+
                    temporal.getApellido()+","+temporal.getContraseña());
            co.setMaxAge(60*60*24*30);
            response.addCookie(co);
            
            Cookie c = new Cookie("nombre",temporal.getNombre()+" "+temporal.getApellido());
            c.setMaxAge(60*60*24*30);
            response.addCookie(c);
            
            Cookie c2 = new Cookie("id",temporal.getRUN());
            c2.setMaxAge(60*60*24*30);
            response.addCookie(c2);
            
            Cookie c3 = new Cookie("pass",temporal.getContraseña());
            c3.setMaxAge(60*60*24*30);
            response.addCookie(c3);
            
            response.sendRedirect("index.jsp");
            }else{
                response.sendRedirect("Login.jsp?msj=Password incorrecto");
            }
        }else{
            response.sendRedirect("Login.jsp?msj=Usuario inexistente");
        }
        }catch(Exception e){
            response.sendRedirect("Login.jsp?msj="+e.getMessage());
        }
    }
        private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
           try{
            String RUN = request.getParameter("RUN").trim();
            String Nombre = request.getParameter("Nombre").trim();
            String Apellido = request.getParameter("Apellido").trim();
            String PASS = request.getParameter("Contra").trim();
            if(RUN.equals("")||Nombre.equals("")||Apellido.equals("")||PASS.equals("")){
                response.sendRedirect("Login.jsp?msj=Campos incompletos");
            }else{
                Usuario usuarioNuevo = new Usuario(RUN,Nombre,Apellido,PASS);
                UsuarioDAO ud = new UsuarioDAO();
                HttpSession sesion = request.getSession();
                if(ud.obtenerUsuario(usuarioNuevo.getRUN())==null){
                    int respuesta = ud.registrarUsuario(usuarioNuevo);
                    if(respuesta==1){
                    response.sendRedirect((sesion.getAttribute("usuario")!=null)?"Login.jsp?msj=Usuario registrado"
                            :"Login.jsp?msj=Usuario registrado, inicie sesion");
                    }else{
                    response.sendRedirect((sesion.getAttribute("usuario")!=null)?"Login.jsp?msj=Usuario no se puede registar"
                            :"Login.jsp?msj=Usuario no se puede registrar");
                    }

                }else{
                    response.sendRedirect((sesion.getAttribute("usuario")!=null)?"Login.jsp?msj=Usuario ya existe":
                            "registro.jsp?msj=Usuario ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("Login.jsp?msj="+e.getMessage());
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
