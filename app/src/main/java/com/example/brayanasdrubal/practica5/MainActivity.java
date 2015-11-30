package com.example.brayanasdrubal.practica5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int num=0,idm=0,p=0;

    ListView lstNombres;
    static String titl,can, c;
    public String[] tit={"Cine","Teatro","Restaurante","Rumba","Turismo","Cinema", "Theatre", "Restaurant", "Rumba", "Tourism"};

    private Lista_Entrada[] datos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos= new Lista_Entrada[]{
                new Lista_Entrada(R.drawable.cine, getString(R.string.Cine), "3 "+getString(R.string.L),"Cinema","3 Places"),
                new Lista_Entrada(R.drawable.teatro, getString(R.string.Teatro), "2 "+getString(R.string.L), "Theatre","2 Places"),
                new Lista_Entrada(R.drawable.rest,getString(R.string.Restaurante), "3 "+getString(R.string.L), "Restaurant","3 Places"),
                new Lista_Entrada(R.drawable.rumba,getString(R.string.Rumba),"3 "+getString(R.string.L), "Rumba","3 Places"),
                new Lista_Entrada(R.drawable.turi,getString(R.string.Turismo),"3 "+getString(R.string.L), "Tourism","3 Places")};

        Adapter adaptador = new Adapter(this, datos);

        lstNombres = (ListView) findViewById(R.id.Lst);

        lstNombres.setAdapter(adaptador);
        lstNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = tit[position+p];
                num=position;
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, seleccion, Toast.LENGTH_SHORT).show();
                        //Abrir la actividad
                        Intent i = new Intent(MainActivity.this, LisTabs.class);
                        startActivity(i);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, seleccion, Toast.LENGTH_SHORT).show();
                        //Abrir la actividad
                        Intent i1 = new Intent(MainActivity.this, LisTabs.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, seleccion, Toast.LENGTH_SHORT).show();
                        //Abrir la actividad
                        Intent i2 = new Intent(MainActivity.this, LisTabs.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, seleccion, Toast.LENGTH_SHORT).show();
                        //Abrir la actividad
                        Intent i3 = new Intent(MainActivity.this, LisTabs.class);
                        startActivity(i3);
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, seleccion, Toast.LENGTH_SHORT).show();
                        //Abrir la actividad
                        Intent i4 = new Intent(MainActivity.this, LisTabs.class);
                        startActivity(i4);
                        break;
                }
            }
        });

     /*   lstNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this, String.valueOf(parent.getItemAtPosition(position)),Toast.LENGTH_SHORT).show();
            }
        });*/

    }


    public class Adapter extends ArrayAdapter<Lista_Entrada> {

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.activity_lista, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(p==0){
                titl=datos[position].getNombre();
                can=datos[position].getNombrePila();
            }else{
                titl=datos[position].getNombrei();
                can=datos[position].getCant();
            }
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.activity_lista, null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(titl);

            TextView nombrePila = (TextView) item.findViewById(R.id.tNombrePila);
            nombrePila.setText(can);

            // TextView fecha = (TextView) item.findViewById(R.id.fecha);
            //fecha.setText(datos[position].getFecha());

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement



        if (id == R.id.acerca) {
            //Abrir la actividad
            Intent i = new Intent(this, Acercade.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
