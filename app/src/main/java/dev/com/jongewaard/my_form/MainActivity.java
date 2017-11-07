package dev.com.jongewaard.my_form;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Elementos UI
    private View btnNext;
    private EditText eTxt_Intro_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Forzar el logo, en todas las versiones android
        getSupportActionBar().setLogo(R.mipmap.ic_form);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Forzar y cargar  icono en el Action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_form);

        // Instanciamos los elementos de la UI con sus referencias
        eTxt_Intro_Name = findViewById(R.id.editText_Intro_Name);
        btnNext = findViewById(R.id.btn_Next_Step_Main);

        // Evento click del botón para pasar al siguiente Activity
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = eTxt_Intro_Name.getText().toString();

                if (name != null && !name.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "The name is mandatory, please type it", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
