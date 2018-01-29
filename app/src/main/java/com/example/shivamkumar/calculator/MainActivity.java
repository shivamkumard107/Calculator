package com.example.shivamkumar.calculator;

import android.renderscript.Double2;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one ;
    private Button two ;
    private Button three ;
    private Button four ;
    private Button five ;
    private Button six ;
    private Button seven ;
    private Button eight ;
    private Button nine ;
    private Button clear ;
    private Button zero ;
    private Button add ;
    private Button sub ;
    private Button mul ;
    private Button div ;
    private TextView info ;
    private TextView result ;
    private final char ADDITION = '+' ;
    private final char SUBTRACTION = '-' ;
    private final char MULTIPLY = 'X';
    private final char DIVIDE = '÷' ;
    private double val1 = Double.NaN ;
    private double val2 ;
    private char ACTION ;
    private final char EQU = 0;
    private Button equal ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "0" ) ;
            }
        } );
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "1" ) ;
            }
        } );
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "2" ) ;
            }
        } );
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "3" ) ;
            }
        } );
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "4" ) ;
            }
        } );
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "5" ) ;
            }
        } );
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "6" ) ;
            }
        } );
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "7" ) ;
            }
        } );
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "8" ) ;
            }
        } );
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "9" ) ;
            }
        } );
         add.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                  compute();
                          ACTION = ADDITION ;
                          result.setText(String.valueOf(val1) + "+");
                          info.setText(null);
                      }
                  });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = SUBTRACTION ;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = MULTIPLY ;
                result.setText(String.valueOf(val1) + "X");
                info.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = DIVIDE ;
                result.setText(String.valueOf(val1) + "÷");
                info.setText(null);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = EQU ;
                result.setText(result.getText().toString() + String.valueOf(val2 + " = " + String.valueOf(val1)));
            info.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info.getText().length() > 0) {
                    CharSequence name = info.getText().toString() ;
                    info.setText(name.subSequence(0, name.length()-1));
                }
                else {
                    val1 = Double.NaN ;
                    val2 = Double.NaN ;
                    info.setText(null) ;
                    result.setText(null) ;

                }
            }
        });

    }

    private void setupUIViews() {
        one = (Button)findViewById(R.id.btn1) ;

        zero = (Button)findViewById(R.id.btn0) ;

        three = (Button)findViewById(R.id.btn3) ;
        two = (Button)findViewById(R.id.btn2) ;

        four = (Button)findViewById(R.id.btn4) ;
        five = (Button)findViewById(R.id.btn5) ;


        six = (Button)findViewById(R.id.btn6) ;
        seven = (Button)findViewById(R.id.btn7 );
        eight = (Button)findViewById(R.id.btn8) ;
        nine = (Button)findViewById(R.id.btn9) ;
        equal = (Button)findViewById(R.id.btnequal) ;
        add = (Button)findViewById(R.id.btnadd) ;
        sub = (Button)findViewById(R.id.btnsub) ;


        mul = (Button)findViewById(R.id.btnmul) ;
        info = (TextView)findViewById(R.id.tvControl) ;
        div = (Button)findViewById(R.id.btndivide)  ;
        result = (TextView)findViewById(R.id.tvResult) ;
        clear = (Button)findViewById(R.id.btnclear) ;
    }
    private void compute() {
        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(info.getText().toString());
            switch (ACTION) {
                case ADDITION :
                    val1 = val1 + val2 ;
                    break;
                case SUBTRACTION :
                    val1 = val1 - val2 ;
                    break;
                case MULTIPLY :
                    val1 = val1 * val2 ;
                    break;
                case DIVIDE :
                    val1 = val1 / val2 ;
                    break;
                case EQU :
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(info.getText().toString()) ;
        }
    }
}
