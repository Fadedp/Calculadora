package com.facudeveloper.calculadora;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_AC;
    Button btn_C;

    TextView textViewResultadoEnPantalla;

    String strNumeroIngresado;

    String state;

    boolean clear;

    boolean negativo;

    boolean onlyOneMinus;

    ArrayList<String> numerosAlmacenados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        negativo= false;

        onlyOneMinus= false;

        numerosAlmacenados = new ArrayList<>();

        textViewResultadoEnPantalla = findViewById(R.id.textview_display);

        btn_AC = findViewById(R.id.btn_ac);
        btn_C = findViewById(R.id.btn_c);
        Button btn_pstneg = findViewById(R.id.btn_pstneg);
        Button btn_porc = findViewById(R.id.btn_perc);

        Button btn_div = findViewById(R.id.btn_div);
        Button btn_multi = findViewById(R.id.btn_multi);
        Button btn_resta = findViewById(R.id.btn_menos);
        Button btn_suma = findViewById(R.id.btn_mas);
        Button btn_igual = findViewById(R.id.btn_igual);
        Button btn_punto = findViewById(R.id.btn_coma);

        Button btn_1 = findViewById(R.id.btn_uno);
        Button btn_2 = findViewById(R.id.btn_dos);
        Button btn_3 = findViewById(R.id.btn_tres);
        Button btn_4 = findViewById(R.id.btn_cuatro);
        Button btn_5 = findViewById(R.id.btn_cinco);
        Button btn_6 = findViewById(R.id.btn_seis);
        Button btn_7 = findViewById(R.id.btn_siete);
        Button btn_8 = findViewById(R.id.btn_ocho);
        Button btn_9 = findViewById(R.id.btn_nueve);
        Button btn_0 = findViewById(R.id.btn_cero);

        btn_AC.setVisibility(View.VISIBLE);
        btn_C.setVisibility(View.GONE);

        strNumeroIngresado = null;

        textViewResultadoEnPantalla.setText("0");

        numerosAlmacenados.clear();


        btn_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearNumbers();
            }
        });

        btn_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearNumbers();
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumbers(1);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumbers(2);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumbers(3);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumbers(4);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumbers(5);
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumbers(6);
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumbers(7);
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumbers(8);
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumbers(9);
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumbers(0);
            }
        });

        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suma();
            }
        });

        btn_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resta();
            }
        });

        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multi();
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                division();
            }
        });

        btn_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                igual();
            }
        });

        btn_pstneg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiosigno();
            }
        });

    }

    void setNumbers(int numero) {

        if (strNumeroIngresado != null && strNumeroIngresado.length() == 1 && strNumeroIngresado.equals("0")) {
            clearNumbers();
        }


        if (strNumeroIngresado != null && strNumeroIngresado.length() >= 9) {
            return;
        }

        if (clear) {
            strNumeroIngresado = null;

            clear = false;
        }

        if (strNumeroIngresado == null) {
            strNumeroIngresado = "";
        }

        if (negativo){

            if (onlyOneMinus) {

                if(strNumeroIngresado.isEmpty()){
                    strNumeroIngresado = "-" + strNumeroIngresado + numero;
                }else{
                    strNumeroIngresado = strNumeroIngresado + numero;
                }

            }else{
                strNumeroIngresado = "-" + strNumeroIngresado + numero;

                onlyOneMinus=true;
            }


        }else{
            strNumeroIngresado = strNumeroIngresado + numero;
        }

        textViewResultadoEnPantalla.setText(strNumeroIngresado);

        if (!(strNumeroIngresado != null && strNumeroIngresado.length() == 1 && strNumeroIngresado.equals("0"))) {
            btn_AC.setVisibility(View.GONE);
            btn_C.setVisibility(View.VISIBLE);
        }



    }

    void clearNumbers() {

        textViewResultadoEnPantalla.setText("0");

        btn_AC.setVisibility(View.VISIBLE);
        btn_C.setVisibility(View.GONE);

        numerosAlmacenados.clear();

        state = null;

        strNumeroIngresado = null;

        negativo=false;

        onlyOneMinus=false;

    }

    void suma() {

        Log.v("suma", "START");
        Log.v("negativo", String.valueOf(negativo));
        Log.v("strNumeroIngresado", String.valueOf(strNumeroIngresado));
        Log.v("onlyOneMinus", String.valueOf(onlyOneMinus));

        state = Constantes.SUMA;

        clear = true;

        if (strNumeroIngresado != null) {

            if (negativo) {

                numerosAlmacenados.add(strNumeroIngresado);

                negativo=false;

                onlyOneMinus=false;

            }else {
                numerosAlmacenados.add(strNumeroIngresado);
            }
        }


        int suma = 0;

        for (int x = 0; x < numerosAlmacenados.size(); x++) {

            suma = suma + Integer.parseInt(numerosAlmacenados.get(x));
        }

        textViewResultadoEnPantalla.setText(String.valueOf(suma));

        strNumeroIngresado = null;

        negativo=false;

        onlyOneMinus=false;

        Log.v("suma", "END");
        Log.v("negativo", String.valueOf(negativo));
        Log.v("strNumeroIngresado", String.valueOf(strNumeroIngresado));
        Log.v("onlyOneMinus", String.valueOf(onlyOneMinus));


    }

    void resta() {
        state = Constantes.RESTA;

        clear = true;

        if (strNumeroIngresado != null) {
            if (negativo) {
                numerosAlmacenados.add(strNumeroIngresado);

                negativo=false;

                onlyOneMinus=false;

            } else {
                numerosAlmacenados.add(strNumeroIngresado);
            }
        }

        if (numerosAlmacenados.size() > 1) {
            int resta = Integer.parseInt(numerosAlmacenados.get(0));

            for (int x = 1; x < numerosAlmacenados.size(); x++) {

                resta = resta - Integer.parseInt(numerosAlmacenados.get(x));
            }

            textViewResultadoEnPantalla.setText(String.valueOf(resta));

        }

        strNumeroIngresado = null;

        negativo=false;

        onlyOneMinus=false;


    }

    void multi() {

        state = Constantes.MULTIPLICACION;

        clear = true;

        if (strNumeroIngresado != null) {
            if (negativo) {
                numerosAlmacenados.add(strNumeroIngresado);

                negativo=false;

                onlyOneMinus=false;
            } else {
                numerosAlmacenados.add(strNumeroIngresado);
            }
        }

        if (numerosAlmacenados.size() > 1) {
            int multi = Integer.parseInt(numerosAlmacenados.get(0));

            for (int x = 1; x < numerosAlmacenados.size(); x++) {

                multi = multi * Integer.parseInt(numerosAlmacenados.get(x));
            }

            textViewResultadoEnPantalla.setText(String.valueOf(multi));

            strNumeroIngresado = null;

            negativo=false;

            onlyOneMinus=false;


        }
    }

    void division() {

        state = Constantes.DIVISION;

        clear = true;

        if (strNumeroIngresado != null) {
            if (negativo) {
                numerosAlmacenados.add(strNumeroIngresado);

                negativo=false;

                onlyOneMinus=false;
            } else {
                numerosAlmacenados.add(strNumeroIngresado);
            }
        }

        if (numerosAlmacenados.size() > 1) {
            int divi = Integer.parseInt(numerosAlmacenados.get(0));

            for (int x = 1; x < numerosAlmacenados.size(); x++) {

                divi = divi / Integer.parseInt(numerosAlmacenados.get(x));
            }

            textViewResultadoEnPantalla.setText(String.valueOf(divi));

            strNumeroIngresado = null;

            negativo=false;

            onlyOneMinus=false;

        }
    }

    void cambiosigno(){

        if (negativo){


            if (strNumeroIngresado!=null) {

                if (onlyOneMinus){

                    strNumeroIngresado = String.valueOf(Math.abs(Integer.parseInt(strNumeroIngresado)));

                    textViewResultadoEnPantalla.setText(strNumeroIngresado);

                    onlyOneMinus= false;

                    negativo=false;

                }


            } else {
                textViewResultadoEnPantalla.setText("0");
                onlyOneMinus=false;
                negativo=false;

            }



        } else {


            if(strNumeroIngresado!=null) {


                textViewResultadoEnPantalla.setText("-" + strNumeroIngresado);


                strNumeroIngresado = "-" + String.valueOf(Math.abs(Integer.parseInt(strNumeroIngresado)));


            } else {
                textViewResultadoEnPantalla.setText("-" + 0);


            }

            negativo = true;

            onlyOneMinus = true;
        }
    }

    void igual() {

        Log.v("igual", "START");
        Log.v("negativo", String.valueOf(negativo));
        Log.v("strNumeroIngresado", String.valueOf(strNumeroIngresado));
        Log.v("onlyOneMinus", String.valueOf(onlyOneMinus));

        if (state != null) {
            if (strNumeroIngresado != null) {
                if (negativo) {
                    numerosAlmacenados.add(strNumeroIngresado);

                    negativo=false;
                    onlyOneMinus=false;
                } else {
                    numerosAlmacenados.add(strNumeroIngresado);
                }
            } else {
                numerosAlmacenados.add(numerosAlmacenados.get(numerosAlmacenados.size() - 1));
            }

            if (state.equals(Constantes.SUMA)) {
                int suma = 0;

                for (int x = 0; x < numerosAlmacenados.size(); x++) {

                    suma = suma + Integer.parseInt(numerosAlmacenados.get(x));
                }


                textViewResultadoEnPantalla.setText(String.valueOf(suma));

                if(suma<0){
                    negativo=true;

                    onlyOneMinus=true;
                }
                strNumeroIngresado = null;

                Log.v("igual", "END");
                Log.v("negativo", String.valueOf(negativo));
                Log.v("strNumeroIngresado", String.valueOf(strNumeroIngresado));
                Log.v("onlyOneMinus", String.valueOf(onlyOneMinus));

            }

            if (state.equals(Constantes.RESTA)) {
                int resta = Integer.parseInt(numerosAlmacenados.get(0));

                for (int x = 1; x < numerosAlmacenados.size(); x++) {

                    resta = resta - Integer.parseInt(numerosAlmacenados.get(x));
                }


                textViewResultadoEnPantalla.setText(String.valueOf(resta));

                if(resta<0){
                    negativo=true;

                    onlyOneMinus=true;
                }

                strNumeroIngresado = null;
            }

            if (state.equals(Constantes.MULTIPLICACION)) {
                int multi = Integer.parseInt(numerosAlmacenados.get(0));

                for (int x = 1; x < numerosAlmacenados.size(); x++) {

                    multi = multi * Integer.parseInt(numerosAlmacenados.get(x));
                }


                textViewResultadoEnPantalla.setText(String.valueOf(multi));

                if(multi<0){
                    negativo=true;

                    onlyOneMinus=true;
                }

                strNumeroIngresado = null;


            }

            if (state.equals(Constantes.DIVISION)) {
                int divi = Integer.parseInt(numerosAlmacenados.get(0));

                for (int x = 1; x < numerosAlmacenados.size(); x++) {

                    divi = divi / Integer.parseInt(numerosAlmacenados.get(x));
                }


                textViewResultadoEnPantalla.setText(String.valueOf(divi));

                if(divi<0){
                    negativo=true;

                    onlyOneMinus=true;
                }

                strNumeroIngresado = null;

            }
        }
    }
}

