package co.edu.unipiloto.proyecto;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relacionar un objeto con el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


    }

    //adicionar el menu al app bar
    public boolean onCreateOptionsMenu(Menu menu){
        //inflate del menu; adicionar items

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.action_create_order:
                EditText tipoComida= (EditText)findViewById(R.id.editTipoComida);
                EditText nombre= (EditText)findViewById(R.id.nombreComida);
                EditText descripcion= (EditText)findViewById(R.id.descripcion);
                EditText precio= (EditText)findViewById(R.id.precio);
                EditText cantidad= (EditText)findViewById(R.id.cantidad);
                EditText direccion = (EditText)findViewById(R.id.editDireccion);

                String tipoComida_txt = tipoComida.getText().toString();
                String nombre_txt = nombre.getText().toString();
                String descripcion_txt = descripcion.getText().toString();
                String precio_txt = precio.getText().toString();
                String cantidad_txt = cantidad.getText().toString();
                String direccion_txt = direccion.getText().toString();

                Intent intent = new Intent(this, OrderActivity.class);
                intent.putExtra("tipoComida", tipoComida_txt);
                intent.putExtra("name", nombre_txt);
                intent.putExtra("description", descripcion_txt);
                intent.putExtra("price", precio_txt);
                intent.putExtra("count", cantidad_txt);
                intent.putExtra("direction", direccion_txt);

                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}