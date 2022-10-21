package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //private Button alamat_btn;
    Button alamat, telepon, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*alamat_btn = findViewById(R.id.alamat);
        alamat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:-6.919050678235945, 109.74640489711385"));
                Intent chooser = Intent.createChooser(intent,"ALAMAT");
                startActivity(chooser);
            }
        });*/

        alamat = (Button) findViewById(R.id.alamat);
        alamat.setOnClickListener(this);
        telepon = findViewById(R.id.telepon);
        email = findViewById(R.id.email);

        telepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomor = "081227010847";
                Intent memanggil = new Intent(Intent.ACTION_DIAL);
                memanggil.setData(Uri.fromParts("tel", nomor, null));
                startActivity(memanggil);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendemail = new Intent(Intent.ACTION_SEND);
                sendemail.setType("text/plain");
                sendemail.putExtra(Intent.EXTRA_EMAIL, new String[]{"muhammadalden12@gmail.com"});
                sendemail.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
                startActivity(sendemail);
            }
        });


    }

    @Override
    public void onClick(View view) {
        Uri gmmIntentUri = Uri.parse("geo:-6.919050678235945,109.74640489711385?q=" + Uri.parse("-6.919050678235945," + "109.74640489711385(Rumah Alden)"));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}