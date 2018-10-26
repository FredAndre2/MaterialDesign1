package com.holamundo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Random;

public class Agregar_Persona extends AppCompatActivity {
private EditText txtcedula,txtnombres,txtapellidos;
private Spinner cmbsexo;
private String[] opc;
private ArrayList<Integer> fotos;
private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar__persona);

        txtcedula = findViewById(R.id.Txt_Cedula);
        txtnombres = findViewById(R.id.Txt_Nombres);
        txtapellidos = findViewById(R.id.Txt_Apellidos);
        cmbsexo = findViewById(R.id.Cmb_Sexo);
        foto = findViewById(R.id.foto);
        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
        opc = getResources().getStringArray(R.array.opciones_sexo);
    }

    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public void guardar(View v){
        String ced,nom,ape,foto,id;
        int sexo;

        //foto =this.fotoAleatoria();
       id = Datos.getId();
       foto= id+".jpg";
        ced = txtcedula.getText().toString();
        nom = txtnombres.getText().toString();
        ape =txtapellidos.getText().toString();
        sexo = cmbsexo.getSelectedItemPosition();

        Persona p = new Persona(foto,id,ced,nom,ape,sexo);
        p.guardar();
        Snackbar.make(v,"Persona guardada con exito!",Snackbar.LENGTH_SHORT).show();

    }
    public void Limpiar(){
        txtapellidos.setText("");
        txtcedula.setText("");
        txtnombres.setText("");
        cmbsexo.setSelection(0);
        txtcedula.requestFocus();

    }

    public void limpiar(View v){
        Limpiar();
    }
    public void onBackPressed(){
        finish();
        Intent i = new Intent( Agregar_Persona.this,Principal.class);
        startActivity(i);
    }

    public void seleccionar_foto(View v){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
      //  startActivityForResult(Intent.createChooser(i,));
    }

}
