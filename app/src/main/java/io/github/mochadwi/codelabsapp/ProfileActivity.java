package io.github.mochadwi.codelabsapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by mochadwi on 11/4/16.
 */

public class ProfileActivity extends AppCompatActivity {

    private final int PICK_IMAGE_REQUEST = 1;
    private TextView txtNama;
    private TextView txtEmail;
    private TextView txtHp;
    private ImageView imgChangePp;
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

        setProfileImage();
    }

    private void initView() {
        txtNama = (TextView) findViewById(R.id.txt_name);
        txtEmail = (TextView) findViewById(R.id.txt_email);
        txtHp = (TextView) findViewById(R.id.txt_phone);
        imgChangePp = (ImageView) findViewById(R.id.img_change_pp);
    }

    private void setProfileImage() {
        imgChangePp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image"),
                        PICK_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null
                && data.getData() != null) {
            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//                Log.d(TAG, String.valueOf(bitmap));

                ImageView imgTargetPp = (ImageView) findViewById(R.id.img_fp);

                imgTargetPp.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}