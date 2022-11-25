package co.edu.unipiloto.proyecto;

public class Hamburguesas {

    private String nombre;
    private String descripcion;
    private String precio;
    private int imageId;


    public static final Hamburguesas [] productos = {
            new Hamburguesas("Sheriff",
                    "Selecta combinación entre carne de res y filete de pechuga apanada con doble porcion de queso cheddar, cebolla crispy, arepita y vegetales frescos",
                    "34900",
                    R.drawable.hamburguesa_sheriff),
            new Hamburguesas("Polvorete",
                    "Delicioso chorizo en reducción de panela acompañado de pollo desmechado en salsa tartara sobre una jugosa carne a la parrilla, queso cheddar, pan artesanal, crujiente cebolla crispy y vegetales frescos",
                    "39900",
                    R.drawable.hamburguesa_polvorete),
            new Hamburguesas("Billy Boy",
                    "Jugosa carne a la parrilla acompañada de platanito maduro en reducción de panela, arepita, carne desmechada con suero costeño y vegetales frescos en pan artesanal",
                    "39900",
                    R.drawable.hamburguesa_billyboy)
    };

    public Hamburguesas(String nombre, String descripcion, String precio, int imageId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imageId = imageId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
