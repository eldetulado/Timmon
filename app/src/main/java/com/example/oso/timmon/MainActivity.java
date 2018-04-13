package com.example.oso.timmon;

import android.content.DialogInterface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.oso.timmon.data.model.LoginR;
import com.example.oso.timmon.data.remote.APIService;
import com.example.oso.timmon.data.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Boolean sw = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registro = findViewById(R.id.btnRegistro);
        Button ingresar = findViewById(R.id.btnIngresar);

        registro.setOnClickListener(this);
        ingresar.setOnClickListener(this);
    }

    private void registroDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View mView = inflater.inflate(R.layout.dialog_sign_up, null);
        builder.setView(mView);
        builder.setCancelable(false);
        final AlertDialog alert = builder.create();
        alert.show();

        final TextInputLayout tInputNombre = mView.findViewById(R.id.tilNombre);
        final TextInputLayout tInputNick = mView.findViewById(R.id.tilNick);
        final TextInputLayout tInputCorreo = mView.findViewById(R.id.tilCorreo);
        final TextInputLayout tInputPassword = mView.findViewById(R.id.tilPassword);
        final EditText nombreCompleto = mView.findViewById(R.id.names);
        final EditText nick = mView.findViewById(R.id.user_name);
        final EditText correo = mView.findViewById(R.id.email);
        final EditText password = mView.findViewById(R.id.password);
        ImageButton btnRegistro = mView.findViewById(R.id.btnDialogRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarRegistro(tInputNombre, tInputNick,tInputCorreo,tInputPassword,
                        nombreCompleto,nick,correo,password)) {
                    String datos = nombreCompleto.getText().toString() + "-" +
                            nick.getText().toString() + "-" +
                            correo.getText().toString() + "-" +
                            password.getText().toString();
                    Toast.makeText(MainActivity.this, datos, Toast.LENGTH_SHORT).show();
                    alert.dismiss();
                    sw = true;
                }
            }
        });
    }

    private boolean validarRegistro(TextInputLayout tInputNombre, TextInputLayout tInputNick,
                                    TextInputLayout tInputCorreo, TextInputLayout tInputPassword,
                                    EditText nombreCompleto, EditText nick, EditText correo,
                                    EditText password) {
        if (nombreCompleto.getText().toString().trim().isEmpty()){
            tInputNombre.setError("Falta rellenar campo");
            return false;
        }
        if (nick.getText().toString().trim().isEmpty()){
            tInputNick.setError("Falta rellenar campo");
            return false;
        }
        if (correo.getText().toString().trim().isEmpty()){
            tInputCorreo.setError("Falta rellenar campo");
            return false;
        }
        if (password.getText().toString().trim().isEmpty()){
            tInputPassword.setError("Falta rellenar campo");
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnRegistro :
                if (sw) {
                    sw = false;
                    registroDialogo();
                }
                break;

            case R.id.btnIngresar:
                if (sw){
                    sw = false;
                    ingresarDialogo();
                }
                break;
        }
    }


    private APIService mAPIService;
    private void ingresarDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_sign_in, null);
        builder.setView(mView);
        builder.setCancelable(false);
        final AlertDialog alert = builder.create();
        alert.show();
        final TextInputLayout tNickCorreo = mView.findViewById(R.id.tilNickCorreo);
        final TextInputLayout tPassword = mView.findViewById(R.id.tilPassword);
        final EditText nickCorreo = mView.findViewById(R.id.nickCorreo);
        final EditText password = mView.findViewById(R.id.password);
        ImageButton btnIngresar = mView.findViewById(R.id.btnDialogIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarIngreso(tNickCorreo, tPassword, nickCorreo, password)){
                    mAPIService = ApiUtils.getAPIService();
                    sendPost(nickCorreo.getText().toString().trim(), password.getText().toString().trim());

                    String datos = nickCorreo.getText().toString() + "-" +
                            password.getText().toString();
                    Toast.makeText(MainActivity.this, datos, Toast.LENGTH_SHORT).show();
                    alert.dismiss();
                    sw = true;
                }
            }
        });
    }

    private boolean validarIngreso(TextInputLayout tNickCorreo, TextInputLayout tPassword,
                                   EditText nickCorreo, EditText password) {
        if (nickCorreo.getText().toString().trim().isEmpty()){
            tNickCorreo.setError("Falta rellenar campo");
            return false;
        }
        if (password.getText().toString().trim().isEmpty()){
            tPassword.setError("Falta rellenar campo");
            return false;
        }
        return true;
    }


    public void sendPost(String correo, String password) {
        mAPIService.savePost(correo, password).enqueue(new Callback<LoginR>() {
            @Override
            public void onResponse(Call<LoginR> call, Response<LoginR> response) {
                Toast.makeText(MainActivity.this,
                        response.code()+"".toString(),
                        Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Toast.makeText(MainActivity.this,
                            response.body().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginR> call, Throwable t) {

            }
        });
    }

    public void showResponse(String response) {
        Toast.makeText(MainActivity.this,
                response,
                Toast.LENGTH_SHORT).show();
    }

}
