package com.example.android1lesson7dz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etLogin;
    EditText etPsw;
    String admin = "admin";
    Button btnInput;
    Button btnPress;
    TextView tvInput;
    TextView tvWelcome;
    TextView tvInput2;
    TextView tvRegister;
    TextView tvForgotPsw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLogin = findViewById(R.id.et_login);
        etPsw = findViewById(R.id.et_psw);
        btnInput = findViewById(R.id.btn_input);
        btnPress = findViewById(R.id.btn_press);
        tvInput = findViewById(R.id.tv_input);
        tvWelcome = findViewById(R.id.tv_welcome);
        tvInput2 = findViewById(R.id.tv_input2);
        tvRegister = findViewById(R.id.tv_register);
        tvForgotPsw = findViewById(R.id.tv_forgot_psw);

        click();


        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }


    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String inputLogin = etLogin.getText().toString();
            String inputPassword = etPsw.getText().toString();
            btnInput.setActivated(!inputLogin.isEmpty() && !inputPassword.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void click() {
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = etLogin.getText().toString();
                String password = etPsw.getText().toString();

                if (!login.equals(admin) || !password.equals(admin)) {

                    if (!login.equals(admin)) {

                        etLogin.setError("Не правельный логин");

                    }
                    if (!password.equals(admin)) {

                        etPsw.setError("Не правельный пароль");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    etLogin.setVisibility(View.INVISIBLE);
                    etPsw.setVisibility(View.INVISIBLE);
                    tvInput.setVisibility(View.INVISIBLE);
                    tvRegister.setVisibility(View.INVISIBLE);
                    tvInput2.setVisibility(View.INVISIBLE);
                    btnInput.setVisibility(View.INVISIBLE);
                    btnPress.setVisibility(View.INVISIBLE);
                    tvForgotPsw.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}