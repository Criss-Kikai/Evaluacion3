package Clases;

public class Pedido {
    private int ID;
    private Cliente cliente;
    private Producto producto;
    private boolean estado;

    public Pedido(Cliente cliente, Producto producto, boolean estado) {
        this.cliente = cliente;
        this.producto = producto;
        this.estado = estado;
    }

    
    
    public Pedido(int ID, Cliente cliente, Producto producto, boolean estado) {
        this.ID = ID;
        this.cliente = cliente;
        this.producto = producto;
        this.estado = estado;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
