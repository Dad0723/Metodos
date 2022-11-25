package co.edu.unipiloto.proyecto;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Usuario_mapa extends AppCompatActivity {

    private TextView latitud,longitud,pais, localidad, direccion;
    private Button bt_location;
    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_mapa);

        latitud= (TextView) findViewById(R.id.txt_latitud);
        longitud= (TextView) findViewById(R.id.txt_longitud);
        pais= (TextView) findViewById(R.id.txt_pais);
        direccion= (TextView) findViewById(R.id.txt_direccion);
        localidad = (TextView) findViewById(R.id.txt_localidad);
        bt_location = (Button) findViewById(R.id.bt_location);

        //inicializar el objeto para acceder a servicios de localizacion
        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
        bt_location.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                obtenerLocalizacion();
            }

        });

    }


    private void obtenerLocalizacion() {
        Log.d("", "hola");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ) {

            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(
                    new OnCompleteListener<Location>() {
                        @Override
                        public void onComplete(@NonNull Task<Location> task) {
                            Location localizacion = task.getResult();

                            if(localizacion != null){
                                Geocoder geocoder = new Geocoder(Usuario_mapa.this, Locale.getDefault());
                                try {
                                    List<Address> listDirecciones = geocoder.getFromLocation(localizacion.getLatitude(), localizacion.getLongitude(), 1);
                                    latitud.setText("Latitud "+listDirecciones.get(0).getLatitude());
                                    longitud.setText("Longitud "+ listDirecciones.get(0).getLongitude());
                                    pais.setText("Pais "+listDirecciones.get(0).getCountryName());
                                    localidad.setText("Localidad "+ listDirecciones.get(0).getLocality());
                                    direccion.setText("Direcciones "+listDirecciones.get(0).getAddressLine(0));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
            );
        }else {
            ActivityCompat.requestPermissions(Usuario_mapa.this, new String [] {Manifest.permission.ACCESS_FINE_LOCATION}, 44);
            Log.d("","else");
        }
    }

    public void onSendMaps1(View view) {

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api", "1")
                .appendQueryParameter("origin", 4.0323397+ ","+ -74.9653500)
                .appendQueryParameter("destination", 4.632339710+ ","+ -74.065350);

        //crear una cadena para tener la direccion completa
        String url = builder.build().toString();
        Log.d("Direccion",url);

        //llamado a la app
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void onSendMaps3(View view){

        Uri a = Uri.parse("geo:0,0?q=restaurants");
        Intent intent = new Intent(Intent.ACTION_VIEW,a);
        intent.setPackage("com.google.android.apps.maps");
        //Log.d("Direction",a.toString());
        //if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);

        //}
    }

    public void onSendMaps(View view){

        /*Uri a = Uri.parse("google.navigation:q=Salt+Mines,+Zipaquira+Colombia");
        Intent intent = new Intent(Intent.ACTION_VIEW,a);
        intent.setPackage("com.google.android.apps.maps");
        //Log.d("Direction",a.toString());
        //if (intent.resolveActivity(getPackageManager()) != null)
        startActivity(intent);
        */
        //}

        Intent intent = new Intent(Usuario_mapa.this, MapsActivity.class);
        startActivity(intent);
    }
}