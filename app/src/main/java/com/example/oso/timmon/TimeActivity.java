package com.example.oso.timmon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;

public class TimeActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private Button btnAdd;
    private ImageView imgPlayPause;
    private TextView timeActivity;
    private AdapterTime adapterTime;
    private Boolean sw = true;
    private ArrayList<String> actividades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        RecyclerView rv = findViewById(R.id.rc_time_data);
        btnAdd = findViewById(R.id.btnNewActivity);
        editText = findViewById(R.id.new_activity_name);
        imgPlayPause = findViewById(R.id.img_play_stop);
        timeActivity = findViewById(R.id.time);
        actividades = new ArrayList<>();
        actividades.add("leer");
        actividades.add("escribir");
        actividades.add("correr");
        adapterTime = new AdapterTime(actividades,this,R.layout.item_time_activity);
        rv.setAdapter(adapterTime);
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(lm);

        btnAdd.setOnClickListener(this);
        imgPlayPause.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnNewActivity :
                String dato = editText.getText().toString();
                actividades.add(dato);
                adapterTime.notifyDataSetChanged();
                editText.getText().clear();
                break;

            case R.id.img_play_stop :
                if (sw){
                    imgPlayPause.setImageDrawable(getDrawable(R.drawable.ic_stop));
                    sw = false;
                }else {
                    imgPlayPause.setVisibility(View.INVISIBLE);
                    LayoutParams lp = (LayoutParams) timeActivity.getLayoutParams();
                    lp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                    lp.setMargins(0,50,0,10);
                    timeActivity.setLayoutParams(lp);
                    timeActivity.setTextSize(90);
                    sw = true;
                }
                chronometer();
                break;

        }
    }

    private void chronometer() {
        timeActivity.setText("10:00");
    }
}
