package co.edu.unipiloto.proyecto;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProductosUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_usuario);

        //relacionar un objeto con el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    public void img_btn_Chorizo(View view) {
        Intent i = new Intent(ProductosUsuario.this, Usuario_mapa.class);
        startActivity(i);
    }

    public void img_btn_Crepes(View view) {
        Intent i = new Intent(ProductosUsuario.this, Use_opciones_crepes.class);
        startActivity(i);
    }
/*
    public void img_btn_Empanadas(View view) {
        Intent i = new Intent(ProductosUsuario.this, Use_opciones_empanadas.class);
        startActivity(i);
    }

    public void img_btn_Sandwiches(View view) {
        Intent i = new Intent(ProductosUsuario.this, Use_opciones_sandwiches.class);
        startActivity(i);
    }

    public void img_btn_Tacos(View view) {
        Intent i = new Intent(ProductosUsuario.this, Use_opciones_tacos.class);
        startActivity(i);
    }
*/
    public void img_btn_Hamburguesa(View view) {
        Intent i = new Intent(ProductosUsuario.this, Use_opciones_hamburguesa.class);
        startActivity(i);
    }
/*
    public void img_btn_Perros(View view) {
        Intent i = new Intent(ProductosUsuario.this, Use_opciones_perros.class);
        startActivity(i);
    }

    public void img_btn_Pinchos(View view) {
        Intent i = new Intent(ProductosUsuario.this, Use_opciones_pinchos.class);
        startActivity(i);
    }

    public void img_btn_Pizza(View view) {
        Intent i = new Intent(ProductosUsuario.this, Use_opciones_pizza.class);
        startActivity(i);
    }

    public void img_btn_Salchipapa(View view) {
        Intent i = new Intent(ProductosUsuario.this, Use_opciones_salchipapa.class);
        startActivity(i);
    }

 */
}