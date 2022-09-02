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

            ArrayList<String> letrasMemoria = new ArrayList<>();
            letrasMemoria.add("A");
            letrasMemoria.add("B");
            letrasMemoria.add("C");
            letrasMemoria.add("D");
            letrasMemoria.add("E");
            letrasMemoria.add("F");
            letrasMemoria.add("G");
            letrasMemoria.add("H");

            ArrayList<String> letritas = new ArrayList<>();
            for(String letras : letrasMemoria){
                letritas.add(letras);
                letritas.add(letras);
            }

            Collections.shuffle(letritas);
            Log.d("msg",letritas.toString());
            intent.putExtra("letras",letritas);
            startActivity(intent);
        });

        Button btntresRayas = (Button) findViewById(R.id.tresRayas);
        btntresRayas.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this,Activity_3_en_Raya.class);
            startActivity(intent1);
        });


    }


}