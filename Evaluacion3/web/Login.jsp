<%-- 
    Document   : Login
    Created on : 23-07-2020, 18:56:18
    Author     : Criss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
    <%
        int formu = 1;
        if(request.getParameter("form")!=null){
            formu = Integer.parseInt(request.getParameter("form"));
        }
        
        if(formu==1){%>
        <center>
        <h1>Login</h1>
        <form action="ControladorUsuario">
            <input type="text" name="RUN" placeholder="Ingrese Run" required /><br><br>
            <input type="text" name="Contra" placeholder="Ingrese Contraseña" required /><br><br>
            <input type="hidden" value="1" name="action"/>
            <input type="submit" value="Ingresar" />
        </form><br>
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
        <a href="Login.jsp?form=2">Registrarse</a>
        </center>
        <br><% }else{%>
        <br>
        <center>
        <h1>Registrarse</h1>
        <form action="ControladorUsuario">
            <input type="text" name="RUN" placeholder="Ingrese Run" required /><br><br>
            <input type="text" name="Nombre" placeholder="Ingrese Nombre" required /><br><br>
            <input type="text" name="Apellido" placeholder="Ingrese Apellido" required /><br><br>
            <input type="text" name="Contra" placeholder="Ingrese Contraseña" required /><br><br>
            <input type="hidden" value="2" name="action"/>
            <input type="submit" value="Ingresar" />
        </form><br>
        <a href="Login.jsp?form=1">Iniciar Sesion</a>
        </center>
        <%}%>
    
    </body>
</html>
