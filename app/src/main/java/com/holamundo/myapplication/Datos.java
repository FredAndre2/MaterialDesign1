package com.holamundo.myapplication;

import java.util.ArrayList;

public class Datos {
    public static ArrayList<Persona> personas = new ArrayList<>();

  public static void guardar(Persona p){
      personas.add(p);
  }
  public static ArrayList<Persona> mostrar(){
      return personas;
    }
}
