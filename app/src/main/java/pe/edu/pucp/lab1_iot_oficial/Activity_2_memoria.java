package pe.edu.pucp.lab1_iot_oficial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Activity_2_memoria extends AppCompatActivity {
    private final int[] botonesID = {R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btn10,R.id.btn11,R.id.btn12,R.id.btn13,R.id.btn14,R.id.btn15,R.id.btn16};
    private  HashMap<Button,String> butonLetra = new HashMap<>();
    private int contadorElecciones;
    private ArrayList<Button> botonesElecciones = new ArrayList<>();
    private Instant instantStarted;
    private Instant instantStopped;
    private ArrayList<String> listaTiempos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_memoria);

        listaTiempos.clear();
        inicializacionDelJuegoMemoria();

    }


    public void inicializacionDelJuegoMemoria(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            instantStarted = Instant.now();
        }

        contadorElecciones = 0;
        botonesElecciones.clear();
        butonLetra.clear();
        TextView cronometro = (TextView) findViewById(R.id.mostrarTiempo);
        cronometro.setText("");

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

        for(int i=0;i<botonesID.length;i++){
            Button botoncito = (Button) findViewById(botonesID[i]);
            butonLetra.put(botoncito,letritas.get(i));
            botoncito.setText(String.valueOf(letritas.get(i)));
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                inicioJuegoMemoria();

            }
        }, 1000);

    }

    public void inicioJuegoMemoria(){
        for(int i=0;i<botonesID.length;i++){
            Button botoncito = (Button) findViewById(botonesID[i]);
            botoncito.setText("-");
        }

    }

    public void extraerLetraBoton(View view){
        if(contadorElecciones < 2){
            Button boton = (Button) view;
            //botonesElecciones.add(boton);
            String letra = butonLetra.get(boton);

            if(letra != null) {
                botonesElecciones.add(boton);
                boton.setText(String.valueOf(letra));
                contadorElecciones++;

                if (botonesElecciones.size() == 2) {

                    if(botonesElecciones.get(0).getId() != botonesElecciones.get(1).getId()) {
                        String letra1 = butonLetra.get(botonesElecciones.get(0));
                        String letra2 = butonLetra.get(botonesElecciones.get(1));


                        if (letra1.equalsIgnoreCase(letra2)) {
                            Log.d("advertencia", "Las letras son iguales");
                            butonLetra.remove(botonesElecciones.get(0));
                            butonLetra.remove(botonesElecciones.get(1));

                        } else {
                            Log.d("advertencia", "Las letras NO son iguales");
                            Button boton1Selected = botonesElecciones.get(0);
                            Button boton2Selected = botonesElecciones.get(1);

                            Handler handler1 = new Handler();
                            handler1.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    boton1Selected.setText("-");
                                    boton2Selected.setText("-");
                                }
                            }, 500);

                        }
                    }else{
                        botonesElecciones.get(0).setText("-");
                    }
                    botonesElecciones.clear();
                    contadorElecciones = 0;

                }

                if (butonLetra.size() == 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        instantStopped = Instant.now();
                    }

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        long seconds = instantStopped.getEpochSecond() - instantStarted.getEpochSecond();

                        if (seconds < 60){
                            String tiempo = "Termino en " + (seconds/60.0) + " minutos";

                            String estadistica = "Juego " + (listaTiempos.size() + 1) + " : " + tiempo;
                            listaTiempos.add(estadistica);

                            TextView cronometro = (TextView) findViewById(R.id.mostrarTiempo);
                            cronometro.setText(tiempo);

                        }else{
                            String tiempo = "Termino en " + (60.0/seconds) + " minutos";

                            String estadistica = "Juego " + (listaTiempos.size() + 1) + " : " + tiempo;
                            listaTiempos.add(estadistica);

                            TextView cronometro = (TextView) findViewById(R.id.mostrarTiempo);
                            cronometro.setText(tiempo);
                        }
                    }

                }

            }
        }

    }

    public void correrJuegoMemoriaAgain(View view){

        if(butonLetra.size() != 0){
            String estadistica = "Juego " + (listaTiempos.size() + 1) + " : " + "Canceló";
            listaTiempos.add(estadistica);
        }

        inicializacionDelJuegoMemoria();
    }

    public void mostrarEstadisticas(View view){
        String estadistica = "";
        for(String mensaje : listaTiempos){
            estadistica = estadistica + mensaje + "\n";
        }
        Intent intent3 = new Intent(Activity_2_memoria.this,Activity_Estadistica_Memoria.class);
        intent3.putExtra("estadisticas",estadistica);
        startActivity(intent3);

    }

}