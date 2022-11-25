package co.edu.unipiloto.proyecto;

public class Crepes {

    private String nombre;
    private String descripcion;
    private String precio;
    private int imageId;


    public static final Crepes [] productos = {
            new Crepes("Crepes de Carne\n",
                    "Carne desmechada, preparada con “hogao” " +
                            "sobre puré de plátano maduro, acompañada de " +
                            "crema agria, aguacate y un toque de pico de gallo. \n",
                    "20900\n",
                    R.drawable.crepes_crepescarne),
            new Crepes("Crepes de Fruta\n",
                    "Delicioso crepes con fresas, nutella y con un helado exquisito sabor a vainilla\n",
                    "15900\n",
                    R.drawable.crepes_crepesdefruta),
            new Crepes("Crepes de Pollo\n",
                    "Pechuga de pollo y champiñones portobello, " +
                            "con una mezcla de sabores orientales a base de curry " +
                            "y maracuyá.\n ",
                    "23600\n",
                    R.drawable.crepes_crepesdesal)
    };

    public Crepes(String nombre, String descripcion, String precio, int imageId) {
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
