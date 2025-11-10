package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {

    int mResource;
    public PlanetaAdapter(Context context, int resource,List<Planeta> objects) {
        super(context, resource, objects);
        mResource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View v = layoutInflater.inflate(mResource,parent,false);
        Planeta planeta = getItem(position);
        TextView tv = v.findViewById(R.id.textView);
        ImageView iv = v.findViewById(R.id.imageView);
        tv.setText(planeta.nome);
        iv.setImageResource(planeta.foto);
        return v;
    }



}
