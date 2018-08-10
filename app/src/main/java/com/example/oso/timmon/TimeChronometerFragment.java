package com.example.oso.timmon;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TimeChronometerFragment extends Fragment {
    private ImageButton btnPause;
    private ImageButton btnStop;
    private ImageButton btnBackSlider;

    private Chronometer chronometer;

    public TimeChronometerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_time_chronometer, container, false);
        btnPause = rootView.findViewById(R.id.btnPauseChronometer);
        btnStop = rootView.findViewById(R.id.btnStopChronometer);
        btnBackSlider = rootView.findViewById(R.id.btnBackSlider);

        chronometer = rootView.findViewById(R.id.timeChronometer);

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Pause", Toast.LENGTH_SHORT).show();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Stop", Toast.LENGTH_SHORT).show();
            }
        });
        
        btnBackSlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Desarrollo", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

}
