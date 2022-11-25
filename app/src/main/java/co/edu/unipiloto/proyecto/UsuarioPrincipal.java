package co.edu.unipiloto.proyecto;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class UsuarioPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_principal);

        ListView listView = (ListView) findViewById(R.id.lista_user);

        AdapterView.OnItemClickListener itemClickListener= new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    Intent intent = new Intent(UsuarioPrincipal.this, QuienesSomos.class);
                    startActivity(intent);
                }else if (position == 1){
                    Intent intent = new Intent(UsuarioPrincipal.this, ProductosUsuario.class);
                    startActivity(intent);
                }else if (position == 2){
                    Intent intent = new Intent(UsuarioPrincipal.this, Contactenos.class);
                    startActivity(intent);
                }else if (position == 3){
                    Intent intent = new Intent(UsuarioPrincipal.this, Usuario_mapa.class);
                    startActivity(intent);
                }

            }
        };

        listView.setOnItemClickListener(itemClickListener);

        //relacionar un objeto con el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}