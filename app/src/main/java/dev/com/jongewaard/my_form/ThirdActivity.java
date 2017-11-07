package dev.com.jongewaard.my_form;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;

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





    }
}
