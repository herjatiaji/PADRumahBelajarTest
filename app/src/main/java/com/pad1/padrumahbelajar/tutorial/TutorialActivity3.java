package com.pad1.padrumahbelajar.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pad1.padrumahbelajar.MainActivity;
import com.pad1.padrumahbelajar.R;

public class TutorialActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial3);
    }
    private void pindah(){
        Intent intent = new Intent( TutorialActivity3.this, MainActivity.class);
        startActivity(intent);
    }


}