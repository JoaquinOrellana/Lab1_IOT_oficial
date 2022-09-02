package pe.edu.pucp.lab1_iot_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import java.util.ArrayList;

public class Activity_2_memoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_memoria);

        Intent intent = this.getIntent();
        ArrayList<String> letras = (ArrayList<String>) intent.getStringArrayListExtra("letras");
        Button[] botones = new Button[16];

        int[] botonesID = {R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btn10,R.id.btn11,R.id.btn12,R.id.btn13,R.id.btn14,R.id.btn15,R.id.btn16};

        for(int i=0;i<botonesID.length;i++){
            botones[i] = (Button) findViewById(botonesID[i]);
            Button botoncito = botones[i];
            botoncito.setText(String.valueOf(letras.get(i)));
        }


        /*Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                metodoaEjecutarPasadoUnsegundo();
            }
        }, 1000);*/



    }

    private void metodoaEjecutarPasadoUnsegundo() {



    }
}