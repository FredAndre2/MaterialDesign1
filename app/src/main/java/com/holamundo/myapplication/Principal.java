package com.holamundo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {
private Intent i;
private RecyclerView lstOpciones;
private ArrayList<Persona> personas;
private LinearLayoutManager llm;
private DatabaseReference databaseReference;
private String db = "Personas";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstOpciones = findViewById(R.id.Lst_Opc);
                personas = Datos.mostrar();

                AdaptadorPersona adaptadorPersona = new AdaptadorPersona(personas);
    llm = new LinearLayoutManager(this);
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    lstOpciones.setLayoutManager(llm);
    lstOpciones.setAdapter(adaptadorPersona);
    databaseReference = FirebaseDatabase.getInstance().getReference();
   // databaseReference.child(db).addChildEventListener(new ValueEventListener())
    }

   public void agregarPersona(View v){
        i = new Intent(Principal.this,Agregar_Persona.class);
        startActivity(i);
        finish();
   }
public void onDataChange(DataSnapshot dataSnapshot){
        personas.clear();
        if(dataSnapshot.exists()){
            for (DataSnapshot snapshot :dataSnapshot.getChildren()){
                Persona p = snapshot.getValue(Persona.class);
                personas.add(p);
            }
        }
}
}
