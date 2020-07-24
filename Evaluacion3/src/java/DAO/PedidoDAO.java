package DAO;

import Clases.Cliente;
import Clases.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoDAO extends Conexion{
    public int registrarPedido(Pedido p) throws ClassNotFoundException, SQLException{
        String sentencia = "insert into pedido values (,?,?,?)";
        try{
           Cliente c = p.getCliente();
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, c.getID());
        ps.setString(2, c.getCorreo());
        ps.setBoolean(3, p.isEstado());
        int r = ps.executeUpdate();
        return r;
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
   
    public ArrayList<Pedido> obtenerPedidos() throws ClassNotFoundException, SQLException{
        String sentencia = "select * from producto";
        try{
        conectar();
        ClienteDAO cli = new ClienteDAO();
        ProductoDAO pro = new ProductoDAO();
        PreparedStatement ps= obtenerPS(sentencia);
        ResultSet rs = ps.executeQuery();
        ArrayList<Pedido> lista = new ArrayList();
        while(rs.next()){
            lista.add(new Pedido(rs.getInt("ID"),cli.obtenerCliente(rs.getInt("ID_Cliente")),pro.obtenerProducto(rs.getInt("ID_Producto")),rs.getBoolean("Estado")));
        }
        return lista;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
    public Pedido obtenerPedido(int ID) throws ClassNotFoundException, SQLException{
        String sentencia = "SELECT * FROM pedido WHERE ID = ?";
        try{
        conectar();
        ClienteDAO cli = new ClienteDAO();
        ProductoDAO pro = new ProductoDAO();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        Pedido p = null;
        if(rs.next()){
           p = new Pedido(rs.getInt("ID"),cli.obtenerCliente(rs.getInt("ID_Cliente")),pro.obtenerProducto(rs.getInt("ID_Producto")),rs.getBoolean("Estado"));
        }
        return p;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
}
