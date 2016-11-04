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
    }
}