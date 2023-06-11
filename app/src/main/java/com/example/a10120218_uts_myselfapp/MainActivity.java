/*
NIM : 10120218
Nama : Faiz Amri Rahman
Kelas : IF-6
Tanggal pengerjaan : 10 Mei 2023
*/
package com.example.a10120218_uts_myselfapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static int splash_timeout = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent walktroughIntent = new Intent( MainActivity.this, Walkthrough.class);
                startActivity(walktroughIntent);
                finish();
            }
        }, splash_timeout);
    }
}