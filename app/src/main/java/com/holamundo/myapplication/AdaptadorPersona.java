package com.holamundo.myapplication;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersona extends
        RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder>{

    private ArrayList<Persona> personas;

    public AdaptadorPersona(ArrayList<Persona> personas){
        this.personas =  personas;
    }
    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona,parent,false);
       return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
Persona p = personas.get(position);
//holder.foto.setImageResource(p.getFoto());
    //    holder.foto.setImageResource(p.getFoto());
        holder.cedula.setText(p.getCedula());
        holder.nombres.setText(p.getNombres());
        holder.apellidos.setText(p.getApellidos());
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
       private ImageView foto;
       private TextView cedula;
       private TextView nombres;
       private TextView apellidos;
       private View v;

       public PersonaViewHolder(View itemView){
           super(itemView);
           v = itemView;
           foto = v.findViewById(R.id.foto);
           cedula = v.findViewById(R.id.Lbl_ID);
           nombres = v.findViewById(R.id.Lbl_Nombre);
           apellidos = v.findViewById(R.id.Lbl_Apellido);
       }
    }
}
