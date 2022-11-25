package unipiloto.proyecto;

public class Notificacion {
    public int id;
    public String ubicacion;
    public String mensaje;
    public String viaAlterna;
    public int tipopanel;

    public Notificacion(int id, String ubicacion, String mensaje, String viaAlterna, int tipopanel) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.mensaje = mensaje;
        this.viaAlterna = viaAlterna;
        this.tipopanel = tipopanel;
    }

    

    public Notificacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getViaAlterna() {
        return viaAlterna;
    }

    public void setViaAlterna(String viaAlterna) {
        this.viaAlterna = viaAlterna;
    }

    public int getTipopanel() {
        return tipopanel;
    }

    public void setTipopanel(int tipopanel) {
        this.tipopanel = tipopanel;
    }
    
    
}
