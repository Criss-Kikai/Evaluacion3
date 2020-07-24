package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Clases.Usuario;

public class UsuarioDAO extends Conexion{
    public int registrarUsuario(Usuario u) throws ClassNotFoundException, SQLException{
        String sentencia = "insert into user values (?,?,?,?)";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, u.getRUN());
        ps.setString(2, u.getNombre());
        ps.setString(3, u.getApellido());
        ps.setString(4, u.getContraseña());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
   
    public ArrayList<Usuario> obtenerUsuarios() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from user";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Usuario> lista = new ArrayList();
        while(rs.next()){
            lista.add(new Usuario(rs.getString("RUN"),rs.getString("Nombre"),
                    rs.getString("Apellido"),rs.getString("Contraseña")));
        }
        return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
    public Usuario obtenerUsuario(String RUN) throws ClassNotFoundException, SQLException{
        String sentencia = "SELECT * FROM user WHERE RUN = ?";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, RUN);
        ResultSet rs = ps.executeQuery();
        Usuario u = null;
        if(rs.next()){
           u = new Usuario(rs.getString("RUN"),rs.getString("Nombre"), rs.getString("Apellido"),rs.getString("Contraseña"));
        }
        return u;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }

}
