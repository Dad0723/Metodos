package co.edu.unipiloto.proyecto;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Use_opciones_hamburguesa extends AppCompatActivity {

    private String productos[] = {"Sheriff", "Polvorete","Billy Boy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_opciones_hamburguesa);

        //relacionar un objeto con el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //definir el adaptador con la lista de hamburguesas
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, productos);

        //enlazar el adaptador con la lista
        ListView listaProductos=(ListView) findViewById(R.id.lista_hamburguesa);
        listaProductos.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listaProductos, View itemView, int position, long l) {
                                            Intent intent = new Intent( Use_opciones_hamburguesa.this, Use_descripcion_hamburguesa.class);
                intent.putExtra(Use_descripcion_hamburguesa.EXTRA_DRINKID, (int) l);
                startActivity(intent);
            }
        };

        //ASIGNAR EL ESCUCHA AL LISTVIEW
        listaProductos.setOnItemClickListener(itemClickListener);

    }
}