package com.ejemplo.app.koltinyjavaplatzi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListadoActivity extends AppCompatActivity {
    //Forma JAVA
    //RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        //Forma JAVA
        //recyclerView = findViewById(R.id.rcListado);

        //Forma Kotlin
        RecyclerView rcListado = findViewById(R.id.rcListado);

        TextView textView = findViewById(R.id.txtListadoUser);

        if (getIntent()!=null){
            Bundle bundle = getIntent().getExtras();
            String nombre = null;
            if (bundle != null) {
                nombre = bundle.getString("Usuario", "");
            }
            textView.setText("Bienvenido " + nombre);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcListado.setLayoutManager(linearLayoutManager);
        rcListado.setAdapter(new AdapterListado(getFakeData()));

    }

    private List<PojoBasico> getFakeData() {
        List<PojoBasico> pojoBasicos = new ArrayList<>();
        for (int i=0; i < 10; i++) {
            pojoBasicos.add(new PojoBasico("Titulo", "Desc"));
        }
        return pojoBasicos;
    }

}
