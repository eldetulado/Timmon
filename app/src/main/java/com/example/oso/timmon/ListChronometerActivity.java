package com.example.oso.timmon;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.oso.timmon.data.model.Actividad;

import java.util.ArrayList;

public class ListChronometerActivity extends AppCompatActivity {

    private boolean sw = false;
    private InputMethodManager imm;
    private EditText nombreActividad;
    private Button btnNew;
    private ImageButton btnAdicionarActividad;
    private LinearLayout ly;
    private LinearLayout img;
    private ArrayList<Actividad> lista;
    private AdapterActividad adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chronometer);
        lista = new ArrayList<>();

        ly = findViewById(R.id.container);
        nombreActividad = findViewById(R.id.actividad);
        img = findViewById(R.id.warning);
        btnNew = findViewById(R.id.btnNew);
        btnAdicionarActividad = findViewById(R.id.btn_adicionar_actividad);
        RecyclerView rv = findViewById(R.id.lista_actividades);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterActividad(lista,this,R.layout.item_actividad);
        rv.setAdapter(adapter);
        revisarVista(img);


        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNew.setVisibility(View.INVISIBLE);
                ly.setVisibility(View.VISIBLE);
                nombreActividad.requestFocus();
                if (nombreActividad.isFocused()){
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
                String nombre = nombreActividad.getText().toString().trim();
                Actividad a = new Actividad(nombre,15,"hoy",false,false, R.color.colorAccent);
                lista.add(a);
                revisarVista(img);
                adapter.notifyDataSetChanged();
                nombreActividad.getText().clear();
                onBackPressed();
            }
        });


    }

    private void revisarVista(LinearLayout img) {
        if (lista.size()>0) img.setVisibility(View.INVISIBLE);
        else img.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (sw){
            imm.hideSoftInputFromWindow(nombreActividad.getWindowToken(), 0);
            sw = false;
            ly.setVisibility(View.INVISIBLE);
            btnNew.setVisibility(View.VISIBLE);
        }else{
            super.onBackPressed();
        }
    }
}
