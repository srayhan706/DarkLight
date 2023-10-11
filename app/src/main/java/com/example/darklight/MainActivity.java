package com.example.darklight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SwitchCompat switchmode;
    Button btn;
    boolean nightmode;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchmode=findViewById(R.id.switchMode);

        btn=findViewById(R.id.gothemebtn);

        sharedPreferences=getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightmode=sharedPreferences.getBoolean("nightmode",false);
        if(nightmode){
            switchmode.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        switchmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nightmode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor=sharedPreferences.edit();
                    editor.putBoolean("nightmode",false);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor=sharedPreferences.edit();
                    editor.putBoolean("nightmode",true);

                }
                editor.apply();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,dynamic_theme.class);
                startActivity(intent);

            }
        });


    }
}