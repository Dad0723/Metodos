package co.edu.unipiloto.proyecto;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Singup_Form extends AppCompatActivity {

    private RapiCoopDatabaseHelper myDb;
    private EditText editFullName,editUserName, editEmail, editPassword, editLatitud, editLongitud;
    private Spinner editTipoUsuario;
    private RadioButton male,female, other;
    private Button btnAddData;
    private Button btnViewAll;
    private int tipo;
    private String genero;
    int anio, mes , dia;
    Calendar cal =  Calendar.getInstance();
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_form);

        //relacionar un objeto con el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        myDb=new RapiCoopDatabaseHelper(this,"instituto",null,1);
        tv=findViewById(R.id.button_fecha);
        editFullName=(EditText) findViewById(R.id.editText_fullname);
        editUserName=(EditText)findViewById(R.id.editText_userName);
        editEmail=(EditText)findViewById(R.id.editText_email);
        editPassword=(EditText)findViewById(R.id.editText_password);
        editTipoUsuario=(Spinner) findViewById(R.id.color);
        editLatitud=(EditText)findViewById(R.id.txtLatitud);
        editLongitud=(EditText)findViewById(R.id.txtLongitud);
        male = (RadioButton)findViewById(R.id.radioButton_hombre);
        female = (RadioButton)findViewById(R.id.radioButton_mujer);
        other = (RadioButton)findViewById(R.id.radioButton_otro);
        btnAddData=(Button)findViewById(R.id.button_registrar);
        btnViewAll=(Button)findViewById(R.id.button_mostrar_registro);
        addData();
        viewAll();

        //myDb.initData();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void abrir_calendario(View view) {

        anio = cal.get(Calendar.YEAR);
        mes = cal.get(Calendar.MONTH);
        dia = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(Singup_Form.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;
                String fecha = dayOfMonth+"/"+month+"/"+year;
                //String fecha = String.valueOf(LocalDate.now());
                tv.setText(fecha);
                anio=year;
                mes=month;
                dia=dayOfMonth;
            }
        }, anio, mes, dia);

        dpd.show();

        //Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());

        //Toast.makeText(Singup_Form.this, "La edad en años es: "+edad.getYears(), Toast.LENGTH_LONG).show();
        /*int edad = edad_user(anio,mes,dia);

        if(edad<18)
            showMessage("Error","Su edad es"+edad+"Debe ser mayor de edad para registrase como vendedor o domiciliario");
*/
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int edad_user(int anio, int mes, int dia){
        Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());

        return Integer.parseInt(edad.getYears() + "");

    }

    public void addData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View view) {
                        //int edad = edad_user(anio,mes,dia);

                        String seleccion =editTipoUsuario.getSelectedItem().toString();

                        User user=new User();
                        user.setFullName(editFullName.getText().toString());
                        user.setUserName(editUserName.getText().toString());
                        user.setEmail(editEmail.getText().toString());
                        user.setClave(editPassword.getText().toString());
                        user.setRolUsuario(seleccion);
                        user.setLatitud(editLatitud.getText().toString());
                        user.setLongitud(editLongitud.getText().toString());
                        //int edad = edad_user(anio,mes,dia);
                        user.setAno_nacimiento(tv.getText().toString());
                        //if(edad<18)
                        //    showMessage("Error","Su edad es"+edad+"Debe ser mayor de edad para registrase como vendedor o domiciliario");
                        if (male.isChecked())
                            user.setGenero("Hombre");
                        else if (female.isChecked())
                            user.setGenero("Mujer");
                        else if (other.isChecked())
                            user.setGenero("Otro");
                        long anos= Mayor18();

//                        boolean isInserted=myDb.insertData(user);
                        if(anos>=18 || seleccion.equals("Comprador")) {
                            boolean isInserted = myDb.insertData(user);

                            if(isInserted == true ){
                            Intent i = new Intent(Singup_Form.this, login_form.class);
                            startActivity(i);
                                Toast.makeText( Singup_Form.this,  "Informacion registrada ", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText( Singup_Form.this,  "Informacion NO registrada ", Toast.LENGTH_LONG).show();
                            }
                        }else {

                            Intent i = new Intent(Singup_Form.this, Singup_Form.class);
                            startActivity(i);
                            showMessage("Error","Su edad es "+anos+" .Debe ser mayor de edad para registrase como vendedor o domiciliario");
                        }
                    }
                }
        );
    }
    public void viewAll(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res=myDb.getAlldata();
                        if(res.getCount()==0){
                            showMessage( "Error", "No hay usuarios guardados");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id: "+res.getString(0)+"\n");
                            buffer.append("Nombre: "+res.getString( 1)+"\n");
                            buffer.append("Usuario: "+res.getString( 2)+"\n");
                            buffer.append("Correo: "+res.getString( 3)+"\n");
                            buffer.append("Contraseña: "+res.getString( 4)+"\n");
                            buffer.append("Rol: "+res.getString( 5)+"\n");
                            buffer.append("Direccion: \nLongitud: "+res.getString( 6)+" ");
                            buffer.append("Latitud: "+res.getString( 7)+"\n");
                            buffer.append("Año de nacimiento: "+res.getString( 8)+"\n");
                            buffer.append("Genero: "+res.getString( 9)+"\n\n");

                        }
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    public long Mayor18(){
        SimpleDateFormat fechaf = new SimpleDateFormat("dd/mm/yyyy");


        try {
            Date fecha_inicio = fechaf.parse(tv.getText().toString());

            Calendar calendar = new GregorianCalendar();

            Date dateObj = calendar.getTime();
            String fecha_actual = fechaf.format(dateObj);
            Date fecha_final = fechaf.parse(fecha_actual);

            long tiempo_transcurrido = fecha_final.getTime() - fecha_inicio.getTime();
            TimeUnit unidad = TimeUnit.DAYS;
            long dias = unidad.convert(tiempo_transcurrido, TimeUnit.MILLISECONDS);


            long anos = dias / 365;
            return anos;

        } catch (ParseException e) {
            e.printStackTrace();return 0;
        }

    }


    /*
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void btn_registro(View view) {

        int edad = edad_user(anio,mes,dia);

        String seleccion =editTipoUsuario.getSelectedItem().toString();
        Integer valueInt= new Integer(tipo);
        User user=new User();
        user.setFullName(editFullName.getText().toString());
        user.setUserName(editUserName.getText().toString());
        user.setEmail(editEmail.getText().toString());
        user.setClave(editPassword.getText().toString());
        user.setLatitud(editLatitud.getText().toString());
        user.setLongitud(editLongitud.getText().toString());
        user.setRolUsuario(seleccion);
        user.setAno_nacimiento(Integer.parseInt(String.valueOf(tv.getText())));
        if(edad<18)
            showMessage("Error","Su edad es"+edad+"Debe ser mayor de edad para registrase como vendedor o domiciliario");
        user.setGenero(genero);
        boolean isInserted=myDb.insertData(user);



        if(isInserted == true){

            Toast.makeText( Singup_Form.this,  "Informacion registrada y su edad es : "+edad, Toast.LENGTH_LONG).show();
        }
        /*else if(seleccion.equals("Comprador") && isInserted == true){
            startActivity(new Intent(Singup_Form.this,login_form.class));
            Toast.makeText( Singup_Form.this,  "Informacion registrada", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText( Singup_Form.this,  "Informacion no registrada y su edad es: "+edad, Toast.LENGTH_LONG).show();
        }*/


}