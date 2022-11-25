package co.edu.unipiloto.proyecto;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class OrderActivity extends AppCompatActivity {

    public String EXTRA_MESSAGE = "tipoComida";
    public String EXTRA_MESSAGE1 = "name";
    public String EXTRA_MESSAGE2 = "description";
    public String EXTRA_MESSAGE3 = "price";
    public String EXTRA_MESSAGE4 = "count";
    public String EXTRA_MESSAGE5 = "direction";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle extras = new Bundle();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();

        TextView tipocomida = (TextView) findViewById(R.id.comidatipo);
        TextView name = (TextView) findViewById(R.id.comidaNombre);
        TextView description = (TextView) findViewById(R.id.comidaDescripcion);
        TextView price = (TextView) findViewById(R.id.comidaPrecio);
        TextView count = (TextView) findViewById(R.id.comidaCantidad);
        TextView direction = (TextView) findViewById(R.id.comidaDireccion);

        String tip = intent.getStringExtra(EXTRA_MESSAGE);
        String nam = intent.getStringExtra(EXTRA_MESSAGE1);
        String des = intent.getStringExtra(EXTRA_MESSAGE2);
        String pri = intent.getStringExtra(EXTRA_MESSAGE3);
        String cou = intent.getStringExtra(EXTRA_MESSAGE4);
        String dir = intent.getStringExtra(EXTRA_MESSAGE5);

        /*String tip_txt = (String) tipocomida.getText();
        String nam_txt = (String) name.getText();
        String des_txt = (String) description.getText();
        String pri_txt = (String) price.getText();
        String cou_txt = (String) count.getText();
        String dir_txt = (String) direction.getText();
*/

        String tip_txt = tip;
        String nam_txt = nam;
        String des_txt = des;
        String pri_txt = pri;
        String cou_txt = cou;
        String dir_txt = dir;

        tipocomida.setText(tip_txt);
        name.setText(nam_txt);
        description.setText(des_txt);
        price.setText(pri_txt);
        count.setText(cou_txt);
        direction.setText(dir_txt);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


}