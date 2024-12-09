package com.example.testfragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editTextText);


        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                // Crear una instancia del fragmento y pasar el texto mediante un Bundle
                BlankFragment fragment = new BlankFragment();
                Bundle bundle = new Bundle();
                bundle.putString("texto", editText.getText().toString());
                fragment.setArguments(bundle);

                // Administrar el fragmento con el FragmentManager
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Usar add para agregar el fragmento al contenedor cada vez que se presione el botón
                fragmentTransaction.add(R.id.fragmentContainerView, fragment);

                fragmentTransaction.commit();


            }
        });

    }

}
