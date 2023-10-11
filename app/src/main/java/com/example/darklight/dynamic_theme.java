package com.example.darklight;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class dynamic_theme extends AppCompatActivity implements View.OnClickListener {
    ImageButton btntheme1,btntheme2,btntheme3,btntheme4;

    Button butn;

    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        int selectitem=sharedPreferences.getInt("Selectedthemes",0);
        setdynamictheme(selectitem);

        setContentView(R.layout.activity_dynamic_theme);

        btntheme1=findViewById(R.id.btn1);
        btntheme2=findViewById(R.id.btn2);
        btntheme3=findViewById(R.id.btn3);
        btntheme4=findViewById(R.id.btn4);

        btntheme1.setOnClickListener(this);
        btntheme2.setOnClickListener(this);
        btntheme3.setOnClickListener(this);
        btntheme4.setOnClickListener(this);



    }


    private void setdynamictheme(int selectitem){
        switch (selectitem){
            case 1:
                dynamic_theme.this.setTheme(R.style.dynamictheme1);
                break;
            case 2:
                dynamic_theme.this.setTheme(R.style.dynamictheme2);
                break;
            case 3:
                dynamic_theme.this.setTheme(R.style.dynamictheme3);
                break;

        }
    }

    @Override
    public void onClick(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (view.getId() == R.id.btn1) {
            editor.putInt("Selectedthemes", 1);
        } else if (view.getId() == R.id.btn2) {
            editor.putInt("Selectedthemes", 2);
        } else if (view.getId() == R.id.btn3) {
            editor.putInt("Selectedthemes", 3);
        }

        editor.apply();
        startActivity(new Intent(dynamic_theme.this,dynamic_theme.class));
        finish();
    }


}