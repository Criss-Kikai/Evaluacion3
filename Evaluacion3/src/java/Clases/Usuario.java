package Clases;

public class Usuario {
   private String RUN;
   private String Nombre;
   private String Apellido;
   private String Contraseña;

    public Usuario() {
    }

    public Usuario(String RUN, String Contraseña) {
        this.RUN = RUN;
        this.Contraseña = Contraseña;
    }
    
    public Usuario(String RUN, String Nombre, String Apellido, String Contraseña) {
        this.RUN = RUN;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Contraseña = Contraseña;
    }

    public String getRUN() {
        return RUN;
    }

    public void setRUN(String RUN) {
        this.RUN = RUN;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
}
