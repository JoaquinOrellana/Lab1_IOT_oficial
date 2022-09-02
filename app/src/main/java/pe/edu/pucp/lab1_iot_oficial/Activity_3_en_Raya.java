package pe.edu.pucp.lab1_iot_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Activity_3_en_Raya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_en_raya);
    }
    int i =0;
    public void actualizarEstado1erJugadorCasilla1(View view){

        TextView [][] matriz3x3= {{findViewById(R.id.casilla1),findViewById(R.id.casilla2),findViewById(R.id.casilla3)},
                {findViewById(R.id.casilla4),findViewById(R.id.casilla5),findViewById(R.id.casilla6)},
                {findViewById(R.id.casilla7),findViewById(R.id.casilla8),findViewById(R.id.casilla9)}};


        TextView valorCasilla= (TextView) view;
        if (valorCasilla.getText().toString().equals("----") & (i)%2==0){
            valorCasilla.setText("x");
        }else if(valorCasilla.getText().toString().equals("----")){
            valorCasilla.setText("o");
        }


        i++;
        Log.d("msg", String.valueOf(view.getId()));




    }










}