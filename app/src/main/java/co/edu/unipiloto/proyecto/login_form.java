package co.edu.unipiloto.proyecto;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;

public class login_form extends AppCompatActivity {

    EditText userName;
    EditText password;
    Button usuario;
    Cursor fila;
    private RapiCoopDatabaseHelper myDb;
    //private TextInputLayout getUser;
    private EditText getUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        usuario = (Button) findViewById(R.id.usuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        //relacionar un objeto con el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        userName = (EditText) findViewById(R.id.user_login);
        password = (EditText) findViewById(R.id.user_password);
    }

    public void btn_ingresar(View view) {

        InicioSesion(view);

        //agregar cada propiedad del identificador universal
        /*Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api" ,"1")
                .appendQueryParameter("destination", 4.632339710 +","+ -74.065350);

        //crea cadena para tener direccion completa
        String url = builder.build().toString();
        Log.d("Direccion" , url);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);*/
    }

    public void btn_singupForm(View view) {
        Intent i = new Intent(login_form.this, Singup_Form.class);
        startActivity(i);
    }

    public void InicioSesion(View v){
        /*Creamos un objeto de la clase DBHelper e
        instanciamos el constructor y damos el nonbre de
         la base de datos y la version*/
        RapiCoopDatabaseHelper admin=new RapiCoopDatabaseHelper(this,"instituto",null,1);
        //Abrimos la base de datos como escritura
                SQLiteDatabase db=admin.getWritableDatabase();
        /*Creamos dos variables string y capturamos los datos
         ingresado por el usuario y lo convertimos a string*/
        String usuario=userName.getText().toString();
        String contrasena=password.getText().toString();
        /*inicializamos al cursor y llamamos al objeto de la base
        de datos para realizar un sentencia query where donde
         pasamos las dos variables nombre de usuario y password*/
        fila=db.rawQuery("select USERNAME,PASSWORD,TIPO_USUARIO from Registros_RapiCoop where USERNAME='"+
                usuario+"' and PASSWORD='"+contrasena+"'",null);
        //Realizamos un try catch para captura de errores
        try {
            //Condicional if preguntamos si cursor tiene algun dato/
            if(fila.moveToFirst()){
                //capturamos los valores del cursos y lo almacenamos en variable
                String usua=fila.getString(0);
                String pass=fila.getString(1);
                String tipo=fila.getString(2);
                //preguntamos si los datos ingresados son iguales
                if (usuario.equals(usua)&&contrasena.equals(pass)){
                    //si son iguales entonces vamos a otra ventana
                    //Menu es una nueva actividad empty
                    if(tipo.equals("Vendedor")){
                        Intent ven=new Intent(this, MainActivity.class);
                        //lanzamos la actividad
                        startActivity(ven);
                    } else if(tipo.equals("Comprador")){
                        Intent ven=new Intent(this, UsuarioPrincipal.class);
                        //lanzamos la actividad
                        startActivity(ven);
                    } else if(tipo.equals("Domiciliario")){
                        Intent ven=new Intent(this, Usuario_mapa.class);
                        //lanzamos la actividad
                        startActivity(ven);
                    }

                }
            }//si la primera condicion no cumple entonces que envie un mensaje toast
            else {
                Toast toast=Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_LONG);
                //mostramos el toast
                toast.show();
            }

        } catch (Exception e) {//capturamos los errores que ubieran
            Toast toast=Toast.makeText(this,"Error" + e.getMessage(),Toast.LENGTH_LONG);
            //mostramos el mensaje
            toast.show();
        }
    }
}