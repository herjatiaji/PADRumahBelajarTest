package com.pad1.padrumahbelajar.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pad1.padrumahbelajar.R;

public class TutorialActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial2);
    }

    private void pindah(){
        Intent intent = new Intent( TutorialActivity2.this, TutorialActivity3.class);
        startActivity(intent);
    }

}