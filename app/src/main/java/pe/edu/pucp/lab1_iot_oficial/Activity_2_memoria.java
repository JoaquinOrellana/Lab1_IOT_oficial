package pe.edu.pucp.lab1_iot_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity_2_memoria extends AppCompatActivity {
    private final int[] botonesID = {R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btn10,R.id.btn11,R.id.btn12,R.id.btn13,R.id.btn14,R.id.btn15,R.id.btn16};
    //private final Button[] botones = new Button[16];
    private final HashMap<Button,String> butonLetra = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_memoria);

        Intent intent = this.getIntent();
        ArrayList<String> letras = (ArrayList<String>) intent.getStringArrayListExtra("letras");
        //Button[] botones = new Button[16];

        //int[] botonesID = {R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btn10,R.id.btn11,R.id.btn12,R.id.btn13,R.id.btn14,R.id.btn15,R.id.btn16};

        for(int i=0;i<botonesID.length;i++){
            //botones[i] = (Button) findViewById(botonesID[i]);
            Button botoncito = (Button) findViewById(botonesID[i]);
            butonLetra.put(botoncito,letras.get(i));
            botoncito.setText(String.valueOf(letras.get(i)));
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<botonesID.length;i++){
                    Button botoncito = (Button) findViewById(botonesID[i]);
                    botoncito.setText("-");
                }


            }
        }, 1000);



    }

    public void extraerLetraBoton(View view){
        Button boton = (Button) view;
        String letra = butonLetra.get(boton);
        boton.setText(String.valueOf(letra));
        Log.d("Letra:",letra);
    }


}