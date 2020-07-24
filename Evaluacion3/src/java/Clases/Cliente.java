package Clases;

public class Cliente {
    private int ID;
    private String Correo;

    public Cliente(int ID, String Correo) {
        this.ID = ID;
        this.Correo = Correo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
}
