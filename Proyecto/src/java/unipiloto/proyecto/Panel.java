package unipiloto.proyecto;

import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Panel {
    
    public int id;
    public String identificacion;
    public String nombre;
    public String apellido;
    public String fe_registro;
    public int idTipo;
    public String tipopanel;
    public String mensaje;
    public String ubicacion;
    public String fe_entrada;
    public String fe_salida;

    public Panel(int id,String identificacion, String nombre, String apellido, String fe_registro, int idTipo, String tipopanel, String mensaje, String ubicacion, String fe_entrada, String fe_salida) {
        this.id=id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fe_registro = fe_registro;
        this.idTipo = idTipo;
        this.tipopanel = tipopanel;
        this.mensaje = mensaje;
        this.ubicacion = ubicacion;
        this.fe_entrada = fe_entrada;
        this.fe_salida = fe_salida;
    }

    public Panel(){}

    /*Conexion cn=new Conexion();
    Statement st;
    ResultSet rs;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    public String getFe_registro() {
        return fe_registro;
    }

    public void setFe_registro(String fe_registro) {
        this.fe_registro = fe_registro;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    
    
    public String getTipopanel() {
        return tipopanel;
    }

    public void setTipopanel(String tipopanel) {
        this.tipopanel = tipopanel;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFe_entrada() {
        return fe_entrada;
    }

    public void setFe_entrada(String fe_entrada) {
        this.fe_entrada = fe_entrada;
    }

    public String getFe_salida() {
        return fe_salida;
    }

    public void setFe_salida(String fe_salida) {
        this.fe_salida = fe_salida;
    }
    
    
    
}
