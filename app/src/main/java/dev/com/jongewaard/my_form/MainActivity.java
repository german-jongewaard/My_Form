package dev.com.jongewaard.my_form;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private View btn;
    private final String GREETER = "Hello from the other side!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Forzar y cargar  icono en el Action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_form);


        btn = (Button)findViewById(R.id.btn_Next_Step_Main);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Acceder al segundo activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("greeter", GREETER);
                startActivity(intent);


            }
        });
    }

}
