package co.edu.unipiloto.proyecto;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import co.edu.unipiloto.proyecto.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    private Marker marcador,marcador1;
    double lat = 0.0;
    double lng = 0.0;
    public Button botonAtras;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        botonAtras = (Button) findViewById(R.id.btn_atras);
        botonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        miUbicacion();

        uno(4.632507103095728, -74.0653226308777, "Comida Universidad Piloto");
        dos(4.636482834701246, -74.08307012156905,"Comida Universidad Nacional");
        tres(4.599913070394129, -74.07267056989933,"Comida Universidad Gran Colombia");
        cuatro(4.595438643686581, -74.06859090421258,"Comida Universidad Externado");
        cinco(4.634201278130335, -74.06665786127326,"comida Universidad Catolica");
    }

    public void uno(Double latitud, Double longitud, String titulo){
        LatLng coordenadas = new LatLng(latitud, longitud);

        marcador1 = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconomaparojo)));

    }

    public void dos(Double latitud, Double longitud, String titulo){
        LatLng coordenadas = new LatLng(latitud, longitud);

        marcador1 = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconomaparojo)));

    }

    public void tres(Double latitud, Double longitud, String titulo){
        LatLng coordenadas = new LatLng(latitud, longitud);

        marcador1 = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconomaparojo)));

    }

    public void cinco(Double latitud, Double longitud, String titulo){

        LatLng coordenadas = new LatLng(latitud, longitud);

        marcador1 = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconomaparojo)));

    }
    public void cuatro(Double latitud, Double longitud, String titulo){

        LatLng coordenadas = new LatLng(latitud, longitud);

        marcador1 = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title(titulo)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconomaparojo)));

    }

    private void agregarMarcador(double lat, double lng) {

        LatLng coordenadas = new LatLng(lat, lng);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 12);
        if (marcador != null) {
            marcador.remove();
        }
        marcador = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title("Mi ubicación actual")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconopersonamapa)));

        mMap.animateCamera(miUbicacion);
    }

    private void actualizarUbicacion(Location location) {
        if (location != null) {
            lat = 4.61222431323798;
            lng = -74.14905667304994;
            //location.getLongitude()
            agregarMarcador(lat, lng);
        }
    }

    LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {

            actualizarUbicacion(location);
        }
        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
    };

    private void miUbicacion() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,15000,0,locListener);
    }
}