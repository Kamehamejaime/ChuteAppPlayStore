package com.example.chuteapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText emailLogin, passwordLogin;
    protected final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    protected FirebaseUser currentUser;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //bloqueo de orientación de telefono por defecto Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //splashScreen con logo al inicio de la app con duración de 2 seg
        setTheme(R.style.Theme_ChuteApp);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        emailLogin = findViewById(R.id.emailLogin);
        passwordLogin = findViewById(R.id.passwordLogin);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentUser = mAuth.getCurrentUser();

        if(currentUser != null) {
            Intent intent = new Intent(this, Perfil.class);
            startActivity(intent);
        }
    }
    //Evento botón ingresar en pantalla inicio de sesión
    public void onClickIngreso(View view){
        String email = emailLogin.getText().toString();
        String password = passwordLogin.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            currentUser = mAuth.getCurrentUser();
                            Intent intent = new Intent(MainActivity.this, Perfil.class);
                            startActivity(intent);
                        }
                        else{
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Autenticación fallida", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void onClickRegistro(View view){
        Intent intent = new Intent(MainActivity.this, register.class);
        startActivity(intent);
    }
}