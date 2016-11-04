package io.github.mochadwi.codelabsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtEmail;
    private EditText edtHp;
    private Button btnRegister;
    private String txtNama;
    private String txtEmail;
    private String txtHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initView();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNama = edtName.getText().toString().trim();
                txtEmail = edtEmail.getText().toString().trim();
                txtHp = edtHp.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("Nama", txtNama);
                intent.putExtra("Email", txtEmail);
                intent.putExtra("Handphone", txtHp);
                startActivityForResult(intent, 0); // mark the activity, using request code
            }
        });
    }

    private void initView() {
        edtName = (EditText) findViewById(R.id.edt_name);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtHp = (EditText) findViewById(R.id.edt_hp);
        btnRegister = (Button) findViewById(R.id.btn_register);
    }
}