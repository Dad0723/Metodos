package co.edu.unipiloto.proyecto;

import android.os.Bundle;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Use_descripcion_crepes extends AppCompatActivity {

    public static final String EXTRA_DRINKID = "productoId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_descripcion_crepes);

        //relacionar un objeto con el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int productoId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);
        Crepes producto = Crepes.productos[productoId];

        //Actualizar el layout con el contenido

        TextView nombre =(TextView) findViewById(R.id.cre_Nombre);
        nombre.setText(producto.getNombre());

        TextView descripcion =(TextView) findViewById(R.id.cre_descripcion);
        descripcion.setText(producto.getDescripcion());

        TextView precio =(TextView) findViewById(R.id.cre_precio);
        precio.setText(producto.getPrecio());

        ImageView image =(ImageView) findViewById(R.id.cre_imaProducto);
        image.setImageResource(producto.getImageId());
        image.setContentDescription(producto.getNombre());
    }
}