package dev.com.jongewaard.my_form;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by german on 6-11-17.
 */

public class ThirdActivity extends AppCompatActivity {

    // Elementos UI
    private ImageButton buttonConfirm;
    private Button buttonShare;

    // Otros valores
    private String name;
    private int age;
    private int typeOfMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //Activar flecha ir hacia atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Recogemos el nombre del activity anterior
         Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("name");
            age = bundle.getInt("age");
            typeOfMessage = bundle.getInt("option");
        }

        // Instanciamos los elementos de la UI con sus referencias
        buttonConfirm = (ImageButton) findViewById(R.id.buttonConfirm);
        buttonShare = (Button) findViewById(R.id.buttonToShare);


        // Instanciamos los elementos de la UI con sus referencias
        buttonConfirm = (ImageButton) findViewById(R.id.buttonConfirm);
        buttonShare = (Button) findViewById(R.id.buttonToShare);


        // Evento click del botón confirmar
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ThirdActivity.this, createMessage(name, age, typeOfMessage), Toast.LENGTH_LONG).show();
                buttonShare.setVisibility(View.VISIBLE);
                buttonConfirm.setVisibility(View.INVISIBLE);
            }
        });

        // Evento click del botón share
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, createMessage(name, age, typeOfMessage));
                startActivity(intent);
            }
        });
    }


        private String createMessage(String name, int age, int typeOfMessage) {
            if (typeOfMessage == SecondActivity.GREETER_OPTION) {
                return "Hola " + name + ", ¿Cómo llevas esos " + age + " años? #MyForm";
            } else {
                return "Espero verte pronto " + name + ", antes que cumplas " + (age + 1) + ".. #MyForm";
            }
        }




}
