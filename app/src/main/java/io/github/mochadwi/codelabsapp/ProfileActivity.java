package io.github.mochadwi.codelabsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mochadwi on 11/4/16.
 */

public class ProfileActivity extends AppCompatActivity {

    private TextView txtNama;
    private TextView txtEmail;
    private TextView txtHp;
    String nama = null;
    String hp = null;
    String email = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nama = getIntent().getStringExtra("Nama");
        email = getIntent().getStringExtra("Email");
        hp = getIntent().getStringExtra("Handphone");

        initView();

        txtNama.setText(nama);
        txtEmail.setText(email);
        txtHp.setText(hp);
    }

    private void initView() {
        txtNama = (TextView) findViewById(R.id.txt_name);
        txtEmail = (TextView) findViewById(R.id.txt_email);
        txtHp = (TextView) findViewById(R.id.txt_phone);
    }
}