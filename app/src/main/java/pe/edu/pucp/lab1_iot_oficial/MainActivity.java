package pe.edu.pucp.lab1_iot_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMemoria = (Button) findViewById(R.id.memoria);
        btnMemoria.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Activity_2_memoria.class);
            startActivity(intent);
        });

        Button btntresRayas = (Button) findViewById(R.id.tresRayas);
        btntresRayas.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this,Activity_3_en_Raya.class);
            startActivity(intent1);
        });


    }


}