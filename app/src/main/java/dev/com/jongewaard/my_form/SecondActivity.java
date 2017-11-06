package dev.com.jongewaard.my_form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by german on 6-11-17.
 */

public class SecondActivity extends AppCompatActivity {

    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Activar flecha ir hacia atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

     //   textView = (TextView)findViewById(R.id.textViewMain);
         btnNext = (Button)findViewById(R.id.btn_Next_Step_Second);

        //Tomar los datos del Intent
        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.getString("greeter") != null ){
            String greeter = bundle.getString("greeter");

            Toast.makeText(SecondActivity.this, greeter, Toast.LENGTH_LONG).show();

          //  textView.setText(greeter);
        }else{
            Toast.makeText(SecondActivity.this, "It is empty!", Toast.LENGTH_LONG).show();
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);

            }
        });

    }
}
