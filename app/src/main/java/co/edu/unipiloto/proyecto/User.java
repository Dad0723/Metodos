package co.edu.unipiloto.proyecto;

public class User {

    private String fullName;
    private String userName;
    private String email;
    private String clave;
    private String rolUsuario;
    private String longitud;
    private String latitud;
    private String ano_nacimiento;
    private String genero;


    public User(String fullName, String userName, String email, String clave, String rolUsuario, String longitud, String latitud, String ano_nacimiento, String genero) {
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.clave = clave;
        this.rolUsuario = rolUsuario;
        this.longitud = longitud;
        this.latitud = latitud;
        this.ano_nacimiento = ano_nacimiento;
        this.genero = genero;
    }

    public User() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getAno_nacimiento() {
        return ano_nacimiento;
    }

    public void setAno_nacimiento(String ano_nacimiento) {
        this.ano_nacimiento = ano_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
