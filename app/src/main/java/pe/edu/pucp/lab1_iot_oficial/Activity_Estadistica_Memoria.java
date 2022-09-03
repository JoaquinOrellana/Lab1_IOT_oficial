package pe.edu.pucp.lab1_iot_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.Instant;

public class Activity_Estadistica_Memoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica_memoria);

        Intent intent = this.getIntent();
        String estadisticas = intent.getStringExtra("estadisticas");

        TextView text = (TextView) findViewById(R.id.info);
        text.setText(estadisticas);

    }

    public void NuevoJuegoMemoria(View view){
        Intent intent5 = new Intent(Activity_Estadistica_Memoria.this,Activity_2_memoria.class);
        startActivity(intent5);
    }

}