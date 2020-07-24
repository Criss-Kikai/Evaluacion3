
package DAO;

import Clases.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Criss
 */
public class ClienteDAO extends Conexion {
    public int registrarCliente(Cliente c) throws ClassNotFoundException, SQLException{
        String sentencia = "insert into producto values (,?)";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, c.getCorreo());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
   
    public ArrayList<Cliente> obtenerClientes() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from cliente";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Cliente> lista = new ArrayList();
        while(rs.next()){
            lista.add(new Cliente(rs.getInt("ID"),rs.getString("Correo")));
        }
        return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
    public Cliente obtenerCliente(int ID) throws ClassNotFoundException, SQLException{
        String sentencia = "SELECT * FROM cliente WHERE ID = ?";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        Cliente c = null;
        if(rs.next()){
           c = new Cliente(rs.getInt("ID"),rs.getString("Correo"));
        }
        return c;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }

}
