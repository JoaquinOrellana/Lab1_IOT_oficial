package pe.edu.pucp.lab1_iot_oficial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_3_en_Raya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_en_raya);
    }
    int i =0;
    int numJuego=0;
    private ArrayList<String> listaEst = new ArrayList<>();
    String caso1Hor="";
    String caso2Hor="";
    String caso3Hor="";
    String caso1Ver="";
    String caso2Ver="";
    String caso3Ver="";
    String cas1Diag="";
    String cas2Diag="";


    public void actualizarEstado1erJugadorCasilla1(View view){

        TextView [][] matriz3x3= {{findViewById(R.id.casilla1),findViewById(R.id.casilla2),findViewById(R.id.casilla3)},
                {findViewById(R.id.casilla4),findViewById(R.id.casilla5),findViewById(R.id.casilla6)},
                {findViewById(R.id.casilla7),findViewById(R.id.casilla8),findViewById(R.id.casilla9)}};

        TextView textResult=findViewById(R.id.TextoResult);
        //Valida que ya no se pueda jugar si ya hay un ganador o empate
        if(!(textResult.getText().toString().equals("Ganó X")|| textResult.getText().toString().equals("Ganó O")||
                textResult.getText().toString().equals("Empate"))){
            //valida que no pueda presionar 2 veces al mismo casillero
            TextView valorCasilla= (TextView) view;
            if(!(valorCasilla.getText().toString().equals("x")||valorCasilla.getText().toString().equals("o"))){

                if (valorCasilla.getText().toString().equals("----") & (i)%2==0){
                    valorCasilla.setText("x");
                }else if(valorCasilla.getText().toString().equals("----")){
                    valorCasilla.setText("o");
                }
                i++;
            }
        }





        //Log.d("msg", String.valueOf(view.getId()));

        //validar ganador
        //definimos los 8 casos en que se puede ganar
        caso1Hor=matriz3x3[0][0].getText().toString()+matriz3x3[0][1].getText().toString()+matriz3x3[0][2].getText().toString();
        Log.d("msg",caso1Hor.toString());
        caso2Hor=matriz3x3[1][0].getText().toString()+matriz3x3[1][1].getText().toString()+matriz3x3[1][2].getText().toString();
        caso3Hor=matriz3x3[2][0].getText().toString()+matriz3x3[2][1].getText().toString()+matriz3x3[2][2].getText().toString();
        caso1Ver=matriz3x3[0][0].getText().toString()+matriz3x3[1][0].getText().toString()+matriz3x3[2][0].getText().toString();
        caso2Ver=matriz3x3[0][1].getText().toString()+matriz3x3[1][1].getText().toString()+matriz3x3[2][1].getText().toString();
        caso3Ver=matriz3x3[0][2].getText().toString()+matriz3x3[1][2].getText().toString()+matriz3x3[2][2].getText().toString();

        cas1Diag=matriz3x3[0][0].getText().toString()+matriz3x3[1][1].getText().toString()+matriz3x3[2][2].getText().toString();
        cas2Diag=matriz3x3[0][2].getText().toString()+matriz3x3[1][1].getText().toString()+matriz3x3[2][0].getText().toString();

        //verificamos si el jugador x,o gano

        if(caso1Hor.equals("xxx")||caso2Hor.equals("xxx")||caso3Hor.equals("xxx")||
                caso1Ver.equals("xxx")||caso2Ver.equals("xxx")||caso3Ver.equals("xxx")|| cas1Diag.equals("xxx")||cas2Diag.equals("xxx")){
            textResult.setText("Ganó X");
            numJuego++;
            listaEst.add("Juego"+numJuego+":Ganó X");

        }else if(caso1Hor.equals("ooo")||caso2Hor.equals("ooo")||caso3Hor.equals("ooo")||
                caso1Ver.equals("ooo")||caso2Ver.equals("ooo")||caso3Ver.equals("ooo")|| cas1Diag.equals("ooo")||cas2Diag.equals("ooo")){
            textResult.setText("Ganó O");
            numJuego++;
            listaEst.add("Juego"+numJuego+":Ganó O");
        }
        //verificar si todos las casillas estan completas y hay empate
        int cont=0;
        for ( int  j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if(matriz3x3[j][k].getText().toString().equals("----")){
                    cont++;
                }
            }
        }
        if (cont==0){
            textResult.setText("Empate");
            numJuego++;
            listaEst.add("Juego"+numJuego+":Empate");
        }


    }

    public void nuevoJuego(View view){
        numJuego++;
        listaEst.add("Juego"+numJuego+":Canceló");
        TextView cas1= findViewById(R.id.casilla1);
        cas1.setText("----");

        TextView cas2= findViewById(R.id.casilla2);
        cas2.setText("----");
        TextView cas3= findViewById(R.id.casilla3);
        cas3.setText("----");
        TextView cas4= findViewById(R.id.casilla4);
        cas4.setText("----");
        TextView cas5= findViewById(R.id.casilla5);
        cas5.setText("----");
        TextView cas6= findViewById(R.id.casilla6);
        cas6.setText("----");
        TextView cas7= findViewById(R.id.casilla7);
        cas7.setText("----");
        TextView cas8= findViewById(R.id.casilla8);
        cas8.setText("----");
        TextView cas9= findViewById(R.id.casilla9);
        cas9.setText("----");

        TextView textResult=findViewById(R.id.TextoResult);
        textResult.setText("");




    }

    public void estadisticas(View view){

        String estadistica = "";
        for(String mensaje : listaEst){
            estadistica = estadistica + mensaje + "\n";
        }
        Intent intent3 = new Intent(Activity_3_en_Raya.this,Activity_Estadisticas_3_en_Raya.class);
        intent3.putExtra("estadisticas",estadistica);
        startActivity(intent3);

    }







}