package dev.com.jongewaard.my_form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * Created by german on 6-11-17.
 */

public class SecondActivity extends AppCompatActivity {

    // Elements UI
    private Button btnNext;
    private TextView textView_Age;
    private SeekBar seekBar_Age;
    private RadioButton radioButton_Greeter;
    private RadioButton radioButton_Farewell;

    //Other values
    private String name = "";
    private int age = 18;
    private final int MAX_AGE = 60;
    private final int MIN_AGE = 16;

    // Para compartir
    public static final int GREETER_OPTION = 1;
    public static final int FAREWELL_OPTION = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Activar flecha ir hacia atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Recogemos el nombre del activity anterior - Tomo los datos del Intent
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            name = bundle.getString("name");
        }

        // Instanciamos los elementos de la UI con sus referencias
        seekBar_Age = (SeekBar) findViewById(R.id.seekBar_Age);
        textView_Age = (TextView) findViewById(R.id.textView_Age);
        btnNext = (Button) findViewById(R.id.btn_Next_Step_Second);
        radioButton_Greeter = (RadioButton) findViewById(R.id.radioButton_Greeter);
        radioButton_Farewell = (RadioButton) findViewById(R.id.radioButton_Farewell);

        // Evento change para el SeekBar
        seekBar_Age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int currentAge, boolean fromUser) {
                age = currentAge;
                textView_Age.setText(age + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);

            }
        });

    }
}
