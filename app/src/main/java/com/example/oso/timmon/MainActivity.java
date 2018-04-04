package com.example.oso.timmon;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void signUp(View view) {
//        Registrarse
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_sign_up, null);
        builder.setView(dialogView);

        final EditText nombreCompleto = dialogView.findViewById(R.id.names);
        final EditText nick = dialogView.findViewById(R.id.user_name);
        final EditText correo = dialogView.findViewById(R.id.email);
        final EditText password = dialogView.findViewById(R.id.password);


        builder.setPositiveButton("listo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,
                        nombreCompleto.getText().toString()+
                                nick.getText().toString()+
                                correo.getText().toString()+
                                password.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void signIn(View view) {
//        Ingresar
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_sign_in, null);
        builder.setView(dialogView);

        final EditText correo = dialogView.findViewById(R.id.email);
        final EditText password = dialogView.findViewById(R.id.password);


        builder.setPositiveButton("listo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,
                                correo.getText().toString()+
                                password.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

}
