package Clases;

public class Producto {
    private int ID;
    private String Nombre;
    private String Descripcion;
    private int Precio;

    public Producto() {
    }

    public Producto(int ID, String Nombre, String Descripcion, int Precio) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
    }
    
    public Producto(String Nombre, String Descripcion, int Precio) {
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
}
