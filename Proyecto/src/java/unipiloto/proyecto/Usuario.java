package unipiloto.proyecto;


public class Usuario{
    
    public String user;
    public String nombre;
    public String apellido;
    public String correo;
    public String password;
    public int tiporol;

    public Usuario() {
    }

    public Usuario(String user, String nombre, String apellido, String correo, String password, int tiporol) {
        this.user = user;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.tiporol = tiporol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTiporol() {
        return tiporol;
    }

    public void setTiporol(int tiporol) {
        this.tiporol = tiporol;
    }
    
    
}
