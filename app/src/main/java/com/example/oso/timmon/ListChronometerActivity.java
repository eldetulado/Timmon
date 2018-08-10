package com.example.oso.timmon;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.oso.timmon.data.model.Actividad;
import com.example.oso.timmon.data.modelsql.Tarea;
import com.example.oso.timmon.data.sqlite.DataBaseHelper;
import com.example.oso.timmon.data.sqlite.Estructura.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class ListChronometerActivity extends AppCompatActivity {

    private boolean sw = false;
    private InputMethodManager imm;
    private EditText nombreActividad;
    private Button btnNew;
    private ImageButton btnAdicionarActividad;
    private ImageView imgCover;
    private LinearLayout ly;
    private LinearLayout img;
    private ArrayList<Actividad> lista;
    private AdapterActividad adapter;
    private ViewPager pg;

    NotificationCompat.Builder mBuilder;
    NotificationManager mNotifyMgr;

    DataBaseHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chronometer);

        //chronometer = findViewById(R.id.timeChronometer);

        //chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
        //    @Override
        //    public void onChronometerTick(Chronometer chronometerChanged) {
        //        chronometer = chronometerChanged;
        //    }
        //});

        lista = new ArrayList<Actividad>();

        ly = findViewById(R.id.container);
        nombreActividad = findViewById(R.id.actividad);
        img = findViewById(R.id.warning);
        imgCover = findViewById(R.id.img_cover_page);
        btnNew = findViewById(R.id.btnNew);
        btnAdicionarActividad = findViewById(R.id.btn_adicionar_actividad);
        pg = findViewById(R.id.pager);
        final PagerAdapter pAdapter = new PagerAdapter(getSupportFragmentManager());
        pg.setAdapter(pAdapter);
        RecyclerView rv = findViewById(R.id.lista_actividades);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterActividad(lista, this, R.layout.item_actividad);
        rv.setAdapter(adapter);
        revisarVista(img);
        con = new DataBaseHelper(this);
        consutarTarea();


        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNew.setVisibility(View.INVISIBLE);
                ly.setVisibility(View.VISIBLE);
                nombreActividad.requestFocus();
                if (nombreActividad.isFocused()) {
                    imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

//                    Forzar nombreActividad mostrar el teclado
                    imm.showSoftInput(nombreActividad, InputMethodManager.SHOW_IMPLICIT);

//                    Ocultar teclado
//                    imm.hideSoftInputFromWindow(nombreActividad.getWindowToken(), 0);
                }
                sw = true;
            }
        });

        btnAdicionarActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SQLiteDatabase db = con.getWritableDatabase();


                String nombre = nombreActividad.getText().toString().trim();
                ContentValues values = new ContentValues();
                values.put(ColumnasTarea.NOMBRE, nombre);
                values.put(ColumnasTarea.ID_CATEGORIA, 1);

                Long idResultado = db.insert(ColumnasTarea.TABLE_NAME, ColumnasTarea.ID, values);
                Toast.makeText(v.getContext(), "id:" + idResultado, Toast.LENGTH_SHORT).show();

                consutarTarea();
                /*Actividad a = new Actividad(nombre,15,"hoy",false,false, R.color.colorAccent);
                lista.add(a);
                revisarVista(img);
                adapter.notifyDataSetChanged();
                nombreActividad.getText().clear();
                onBackPressed();*/
            }
        });

        adapter.setOnChangeFragment(new AdapterActividad.OnChangeFragment() {
            @Override
            public void changeFragment() {
                pg.setCurrentItem(1);
            }
        });

    }


    private void consutarTarea() {
        SQLiteDatabase db = con.getReadableDatabase();
        Actividad t = new Actividad();
        lista.clear();
        Cursor cursor = db.rawQuery("SELECT * FROM " + ColumnasTarea.TABLE_NAME, null);
        while (cursor.moveToNext()) {
            t = new Actividad();
            //t.set(cursor.getInt(0));
            t.setId(cursor.getInt(0));
            t.setNombreActividad(cursor.getString(1));
            t.setEstadoActividad(false);
            t.setEsRutina(false);
            //t.set(cursor.getInt(2));


            lista.add(t);
            revisarVista(img);
            adapter.notifyDataSetChanged();
            nombreActividad.getText().clear();
        }

    }

    //private static Chronometer chronometer;


    private void revisarVista(LinearLayout img) {
        if (lista.size() > 0) {
            img.setVisibility(View.INVISIBLE);
            imgCover.setVisibility(View.INVISIBLE);
            pg.setVisibility(View.VISIBLE);
        } else {
            img.setVisibility(View.VISIBLE);
            imgCover.setVisibility(View.VISIBLE);
            pg.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        if (sw) {
            imm.hideSoftInputFromWindow(nombreActividad.getWindowToken(), 0);
            sw = false;
            ly.setVisibility(View.INVISIBLE);
            btnNew.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onPause(){
        super.onPause();


        mNotifyMgr =(NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

        int icono = R.mipmap.ic_launcher;
        Intent intent = new Intent(ListChronometerActivity.this, ListChronometerActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(ListChronometerActivity.this, 0,intent, 0);

        mBuilder =new NotificationCompat.Builder(getApplicationContext())
                .setContentIntent(pendingIntent)
                .setSmallIcon(icono)
                .setContentTitle("Titulo")
                .setContentText("Hola que tal?")
                .setVibrate(null)
                .setAutoCancel(false);

        mNotifyMgr.notify(1, mBuilder.build());


    }

    @Override
    public void onResume(){
        super.onResume();
        try{
            mNotifyMgr.cancel(1);
        }
        catch (Exception e){

        }
    }




}
