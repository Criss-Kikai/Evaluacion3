package DAO;

import Clases.Pedido;
import java.sql.SQLException;

public class PedidoDAO {
    /*public int registrarProducto(Pedido p) throws ClassNotFoundException, SQLException{
        String sentencia = "insert into producto values (,?,?,?)";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, p.getNombre());
        ps.setString(2, p.getDescripcion());
        ps.setInt(3, p.getPrecio());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
   
    public ArrayList<Producto> obtenerProductos() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from producto";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Producto> lista = new ArrayList();
        while(rs.next()){
            lista.add(new Producto(rs.getString("Nombre"),rs.getString("Descripcion"),
                    rs.getInt("Precio")));
        }
        return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
    public Producto obtenerProducto(String Nombre) throws ClassNotFoundException, SQLException{
        String sentencia = "SELECT * FROM producto WHERE Nombre = ?";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, Nombre);
        ResultSet rs = ps.executeQuery();
        Producto u = null;
        if(rs.next()){
           u = new Producto(rs.getString("Nombre"),rs.getString("Descripcion"), rs.getInt("Precio"));
        }
        return u;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }*/
}
