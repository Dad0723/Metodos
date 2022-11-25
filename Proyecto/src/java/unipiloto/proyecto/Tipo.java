package unipiloto.proyecto;

public class Tipo {
    
    private int idTipo;
    private String tipopanel;

    public Tipo() {
    }

    public Tipo(int idTipo, String tipopanel) {
        this.idTipo = idTipo;
        this.tipopanel = tipopanel;
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
    
    
    
}
