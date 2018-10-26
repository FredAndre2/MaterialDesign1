package com.holamundo.myapplication;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Datos {
    public static ArrayList<Persona> personas = new ArrayList<>();

    private static String db = "Personas";

    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();




  public static void guardar(Persona p){
      databaseReference.child(db).child(p.getId()).setValue(p);
  }

  public static String getId(){
      return databaseReference.push().getKey();
  }

  public static void setPersonas(ArrayList<Persona> personas){
      Datos.personas = personas;
  }

  public static ArrayList<Persona> mostrar(){
      return personas;
    }
}
