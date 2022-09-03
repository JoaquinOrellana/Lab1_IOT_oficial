package pe.edu.pucp.lab1_iot_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_Estadisticas_3_en_Raya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas3_en_raya);

        Intent intent = this.getIntent();
        String estadisticas = intent.getStringExtra("estadisticas");

        TextView text = (TextView) findViewById(R.id.textInfo);
        text.setText(estadisticas);

    }

    public void NuevoJuegoTresRaya(View view){
        Intent intent2 = new Intent(Activity_Estadisticas_3_en_Raya.this,Activity_3_en_Raya.class);
        startActivity(intent2);


    }
}